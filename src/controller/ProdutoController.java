/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.*;
import java.math.BigDecimal;

/**
 *
 * @author ytalo
 */
public class ProdutoController {

    public static void adicionarProduto(Produto produto) {
        persistencia.ProdutoDAO.inserirProduto(produto);
    }

    public static void atualizarProduto(String nome, String descricao, String categoria, Integer quantidade, BigDecimal preco ) {
        persistencia.ProdutoDAO.atualizarProduto(nome,  descricao, categoria, quantidade, preco);
    }

}
