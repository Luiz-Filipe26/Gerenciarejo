/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import classes.*;
import conexao.ConexaoMYSQL;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ytalo
 */
public class ProdutoDAO {
    
    //metodo para listar os produtos do banco
    public static ArrayList<Produto> listarProdutos() throws SQLException {

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = c.prepareStatement("SELECT * FROM gerenciarejo.produto ORDER BY NOME ASC");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
               
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setCategoriaTexto(rs.getString("CATEGORIA_PRODUTO"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setPreco(rs.getBigDecimal("PRECO"));
                produto.setDataHora(rs.getString("DATA_HORA_CRIACAO"));

                listaProdutos.add(produto);

            }

        } catch (SQLException e) {

        } finally {
            ConexaoMYSQL.closeConnection(c, stmt);
        }
        return listaProdutos;
    }
    
    //metodo para inserir um produto no banco
    public static void inserirProduto(Produto produto) {

        Connection c = ConexaoMYSQL.getConnection();
   
        PreparedStatement stmt = null;
        try {

            stmt = c.prepareStatement("INSERT INTO gerenciarejo.produto(nome, descricao, categoria_produto, quantidade, preco)VALUES (?,?,?,?,?)");
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getCategoria());                       
            stmt.setInt(4, produto.getQuantidade());
            stmt.setBigDecimal(5, produto.getPreco());
            

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Produto.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Categoria não existe ou produto já existente no banco.");
        }

    }
    
    //metodo para atualizar um produto no banco
    public static void atualizarProduto(String nome,String descricao, String categoria, Integer quantidade, BigDecimal preco) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement(" UPDATE gerenciarejo.produto SET descricao ='" + descricao + "',preco ='" + preco + "', categoria_produto='" + categoria + "', quantidade='" + quantidade + "'WHERE nome='" + nome+"'");

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Produto. Produto inexistente no banco ou nome incorreto.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nova Categoria não existe. Favor conferir. ");
        }

    }
    
    //metodo para deletar um produto no banco
    public static void deletarProduto(String nome) {

        Connection c = ConexaoMYSQL.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = c.prepareStatement("DELETE FROM gerenciarejo.produto WHERE nome = ?");

            stmt.setString(1, nome);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nome de produto não localizado no banco. ");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não removido do banco.");
        }

    }
    
     
    
}
