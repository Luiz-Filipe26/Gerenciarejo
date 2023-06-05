package persistencia;

import configViewLogin.Login_Tela;
import classes.*;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import view.HomeAdmin;
import view.Login;

public class AutenticacaoDAO {

    private final UsuarioDAO usuarioDao;

    public AutenticacaoDAO() {
        this.usuarioDao = new UsuarioDAO();
    }

    public boolean temPermissao(Usuario usuario) {
        try {
            permissao(usuario);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            return false;

        }
    }

    // Não tem permissão quanto usuário não for igual a admim
    public void permissao(Usuario usuario) {
        if (!Perfil.ADMIN.equals(usuario.getPerfil())) {
            throw new VerificaException("Sem permissão para realizar ação");
        }
    }
    //Buscando o usuário
    public Usuario login(Login_Tela login) {
       
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsername(login.getUsuario());

        //Se o usário for igual a null  ou usario for diferente de true não entra
        if (usuario == null || !usuario.isEstado()) {
            return null;
        }
        // Verifica se o estado é true e verifica se a senha está correta
        if (usuario.isEstado() && validarSenha(usuario.getSenha(), login.getSenha())) {
            usuarioDao.actualizarUltimoLogin(usuario);

            return usuario;
        }

        return null;
    }

    public Usuario logout(Login_Tela login) {

        return null;
    }

    /*Sem a utilização do Spring Security
    private boolean validarSenha(String senhaDoUsuario, String senhaDoLogin) {
       return senhaUsuario.equals(senhaLogin);
      
    }
     */
    private boolean validarSenha(String senhaDoUsuario, String senhaDoLogin) {
        BCryptPasswordEncoder passowrdEncoder = new BCryptPasswordEncoder();
        String senhaCriptografada = passowrdEncoder.encode(senhaDoUsuario);
        //Parametros senha não incriptografada = raw // senha incriptografada =encodedPassword
        return passowrdEncoder.matches(senhaDoLogin, senhaCriptografada);
    }
}
