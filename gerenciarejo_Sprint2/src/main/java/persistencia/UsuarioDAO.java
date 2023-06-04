package persistencia;

import conexao.*;
import classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UsuarioDAO {

    private final ConexaoMYSQL conexao;

    //Ponto de controle, posso definir aqui para mysql ou postgres
    public UsuarioDAO() {
        this.conexao = new ConexaoMYSQL();
    }

    /*Salva as informações do usuário
       "0L" significa um número zero (0) do tipo longo (long). 
        O sufixo "L" é usado para indicar que o valor é um literal do tipo long.
     */
    public String salvar(Usuario usuario) {
        return usuario.getId() == 0L ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {

        //Inserir quais informações eu quero pegar(...,...,...,...,...) e quais campos preencher (...,...,...,...,...)
        String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado) VALUES (?, ?, ?, ?, ?)";

        //Tratativa para que o usário não adicione um usuário que já existe ( posso pegar pelo id)
        Usuario usuarioTemp = buscarUsuarioPeloUsername(usuario.getUsername());

        //Verifica se o usuário já existe 
        if (usuarioTemp != null) {
            return String.format("Error: username %s ja existe no banco de dados", usuario.getUsername());
        }

        //Bloco para capturar algum tipo de erro
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);

            //Preenche os valores no preparedStatement
            preencherValoresDoPreparedStatements(preparedStatement, usuario);

            //Para retornar um resultado
            int resultado = preparedStatement.executeUpdate();

            /*Utilizando operador ternário 
             condição ? valor_se_verdadeiro : valor_se_falso
             */
            return resultado == 1 ? "Usuario adicionado com sucesso." : "Nao foi possivel adiconar usuario";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {

        //Atualiza as informações para se pegar, comando sql
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);

            preencherValoresDoPreparedStatements(preparedStatement, usuario);

            int resultado = preparedStatement.executeUpdate();

            return resultado == 1 ? "Usuario editado com sucesso." : "Nao foi possivel editar usuario";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    //Necessário colocar throws SQLException para evitar erro

    private void preencherValoresDoPreparedStatements(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        
        //Instânciando o framework
        BCryptPasswordEncoder passowrdEncoder = new BCryptPasswordEncoder();
        
        String senhaCriptografada = passowrdEncoder.encode(usuario.getSenha());
        
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsername());
        preparedStatement.setString(3, senhaCriptografada);
        preparedStatement.setString(4, usuario.getPerfil().toString());
        preparedStatement.setBoolean(5, usuario.isEstado());

        /*"0L" significa um número zero (0) do tipo longo (long). 
        O sufixo "L" é usado para indicar que o valor é um literal do tipo long.
         */
        if (usuario.getId() != 0L) {
            preparedStatement.setLong(6, usuario.getId());
        }

    }

    public List<Usuario> todosUsuarios() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            ResultSet result = conexao.getConnection().prepareStatement(sql).executeQuery();

            while (result.next()) {
                usuarios.add(getUsuario(result));
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return usuarios;
    }

    private Usuario getUsuario(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsername(result.getString("usuario"));
        usuario.setPerfil(Perfil.valueOf(result.getString("perfil")));
        usuario.setSenha(result.getString("senha"));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data_hora_criacao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo_login", LocalDateTime.class));

        return usuario;
    }
    //Vai retornar somente um dado não tem necessidade de <List>
    public Usuario buscarUsuarioPeloId(Long id) {
        String sql = String.format("SELECT * FROM usuario WHERE id = %d", id);


        /*Tratativa para erros
        Pode ser usado preparedStatement se quiser
        */
        try {
            ResultSet result = conexao.getConnection().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getUsuario(result);
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }

    public Usuario buscarUsuarioPeloUsername(String usuario) {
        String sql = String.format("SELECT * FROM usuario WHERE usuario = '%s'",usuario);
        System.out.println(sql);

        try {
            //PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            //preparedStatement.setString(1, usuario);
            
            ResultSet result = conexao.getConnection().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(String.format("Error: ", e.getMessage()));
        }

        return null;
    }

    public String deleteUsuarioPeloId(Long id) {
        String sql = String.format("DELETE FROM usuario WHERE id = %d", id);

        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);

            int resultado = preparedStatement.executeUpdate();

            return resultado == 1 ? "Usuario apagado com sucesso" : "Nao foi possivel apagar";

        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    public void actualizarUltimoLogin(Usuario usuario) {
        String sql = "UPDATE usuario SET ultimo_login = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, LocalDateTime.now().toString());
            preparedStatement.setLong(2, usuario.getId());

            int resultado = preparedStatement.executeUpdate();

            System.out.println(String.format("Actualizacao do ultimo login: %s",
                    resultado == 1 ? "Com sucesso!!!" : "Sem Sucesso."));
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }

}
