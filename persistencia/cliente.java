
package persistencia;

import conexao.conexaoMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.*;

/**
 *
 * @author ytalo
 */
public class cliente {

    //metodo para inserir um cliente no banco
    public static void inserirCliente(Cliente cliente) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO gerenciarejo.cliente (nome,telefone,endereco)VALUES (?,?,?)");

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente já existente.");
        }

    }
    
    //metodo para atualizar um cliente no banco
    public static void atualizarCliente(int id, String nome, String telefone, String endereco) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE gerenciarejo.cliente SET nome ='" + nome + "',telefone ='" + telefone + "', endereco='" + endereco + "'WHERE id=" + id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente. Cliente inexistente no banco ou ID incorreto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    //metodo para deletar um cliente no banco
    public static void deletarCliente(int id) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM gerenciarejo.cliente WHERE id = ?");

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "ID não localizado no banco. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não removido do banco.");
        }

    }
    
     

}
