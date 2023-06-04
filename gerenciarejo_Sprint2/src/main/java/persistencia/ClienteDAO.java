package persistencia;

import classes.*;
import conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
    
     //metodo para inserir um cliente no banco
    public static void inserirCliente(Cliente cliente) {

        Connection c = ConexaoMYSQL.getConnection();
   
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO gerenciarejo.cliente (cpf,nome,telefone,endereco)VALUES (?,?,?,?)");
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());

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
    public static void atualizarCliente(int cpf, String nome, String telefone, String endereco) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE gerenciarejo.cliente SET nome ='" + nome + "',telefone ='" + telefone + "', endereco='" + endereco + "'WHERE cpf=" + cpf);

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
    public static void deletarCliente(int cpf) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM gerenciarejo.cliente WHERE cpf = ?");

            stmt.setInt(1, cpf);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "CPF não localizado no banco. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente não removido do banco.");
        }

    }
    
     

}