package helper;

import classes.*;
import controller.*;
import javax.swing.JOptionPane;

public class CategoriaHelper {

    public static void validarEntrada(String nome, String descricao) {

        int cont = 0;

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (descricao.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo descricao vazio! Preencha por favor.");
            return;
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            Categoria c1 = new Categoria(nome, descricao);
            CategoriaController.adicionarCategoria(c1);
        }

    }

    public static void validarAtualizacao(String nome, String descricao) {

        int cont = 0;

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (descricao.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo descricao vazio! Preencha por favor.");
            return;
        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            CategoriaController.atualizarCategoria(nome, descricao);
        }
    }

    public static void validarExclusao(String nome) {

        int cont = 0;
        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            CategoriaController.deletarCategoria(nome);
        }
    }

}
