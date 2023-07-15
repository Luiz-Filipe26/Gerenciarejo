package persistencia;

import classes.*;
import conexao.ConexaoMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    //metodo para listar as categorias do banco
    public static ArrayList<Categoria> listarCategorias() throws SQLException {

        ArrayList<Categoria> listaCategorias = new ArrayList<>();

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM gerenciarejo.categoria ORDER BY NOME ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                
                categoria.setNome(rs.getString("NOME"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                

                listaCategorias.add(categoria);

            }

        } catch (SQLException e) {

        } finally {
            ConexaoMYSQL.closeConnection(c, stmt);
        }
        return listaCategorias;
    }
    
    //metodo para inserir uma categoria no banco
    public static void inserirCategoria(Categoria categoria) {

        Connection c = ConexaoMYSQL.getConnection();

        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO gerenciarejo.categoria(nome, descricao)VALUES (?,?)");

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Categoria.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Categoria já existente no banco.");
        }

    }

    //metodo para atualizar uma categoria no banco
    public static void atualizarCategoria(String nome, String descricao) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE gerenciarejo.categoria SET descricao ='" + descricao + "'WHERE nome='" + nome+"'");

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Categoria. Categoria inexistente no banco ou nome incorreto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //metodo para deletar uma categoria no banco
    public static void deletarCategoria(String nome) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM gerenciarejo.categoria WHERE nome = ?");

            stmt.setString(1, nome);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Categoria não localizada no banco. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Categoria não removida do banco.");
        }

    }

}
