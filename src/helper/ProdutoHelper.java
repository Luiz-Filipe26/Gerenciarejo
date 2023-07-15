package helper;

import classes.*;
import controller.*;
import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class ProdutoHelper {

    public static void validarEntrada(String produto, String descricao, String categoria, String quantidade, String preco) throws Exception {

        int cont = 0;

        Integer quantidadeProduto = 0;

        if (produto.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (descricao.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Descricao vazio! Preencha por favor.");
            return;
        }

        if (preco.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Preco vazio! Preencha por favor.");
            return;
        }

        if (categoria.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Categoria vazio! Preencha por favor.");
            return;
        }

        if (quantidade.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Quantidade vazio! Preencha por favor.");
            return;
        }

        BigDecimal precoDecimal = new BigDecimal(preco);

        try {
            quantidadeProduto = Integer.parseInt(quantidade);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Conta invalido!");
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            Produto p1 = new Produto(produto, descricao,  categoria, quantidadeProduto, precoDecimal);
            ProdutoController.adicionarProduto(p1);

        }

    }

    public static void validarAtualizacao(String produto, String descricao, String categoria, String quantidade, String preco) throws Exception {

        int cont = 0;

        Integer quantidadeProduto = 0;

        if (produto.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (descricao.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Descricao vazio! Preencha por favor.");
            return;
        }

        if (preco.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Preco vazio! Preencha por favor.");
            return;
        }

        if (categoria.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Categoria vazio! Preencha por favor.");
            return;
        }

        if (quantidade.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Quantidade vazio! Preencha por favor.");
            return;
        }

        BigDecimal precoDecimal = new BigDecimal(preco);

        try {
            quantidadeProduto = Integer.parseInt(quantidade);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Numero da Conta invalido!");
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            ProdutoController.atualizarProduto(produto, descricao, categoria, quantidadeProduto, precoDecimal);

        }

    }

}
