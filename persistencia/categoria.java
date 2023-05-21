/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import conexao.conexaoMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.*;

/**
 *
 * @author ytalo
 */
public class categoria {
    
    public static void inserirCategoria(Categoria categoria) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO gerenciarejo.categoria (nome,descricao)VALUES (?,?)");

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Categoria.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Categoria já existente com o nome informado.");
        }

    }
    
    public static void atualizarCategoria(int id, String nome, String descricao) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE gerenciarejo.categoria SET nome ='" + nome + "',descricao ='" + descricao +  "'WHERE id=" + id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria atualizado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Categoria. Categoria inexistente no banco ou ID incorreto.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public static void deletarCategoria(int id) {

        Connection c = conexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM gerenciarejo.categoria WHERE id = ?");

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Categoria deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "ID não localizado no banco. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Categoria não removido do banco.");
        }

    }
    
}
