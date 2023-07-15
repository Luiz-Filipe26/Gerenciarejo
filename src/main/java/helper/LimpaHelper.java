package helper;

import view.*;

public class LimpaHelper {

    public static void limpaTextoInserirCliente() {

        CadastrarCliente.txtCpf.setText("");
        CadastrarCliente.txtNome.setText("");
        CadastrarCliente.txtContato.setText("");
        CadastrarCliente.txtEndereco.setText("");

    }

    public static void limpaTextoInserirProduto() {
        ProdutoGUI.txtProduto.setText("");
        ProdutoGUI.txtQuantidade.setText("");
        ProdutoGUI.txtPreco.setText("");
        ProdutoGUI.txtDescricao.setText("");
        ProdutoGUI.txtCategoria.setText("");
    }

    public static void limpaTextoInserirCategoria(){
        AdicionarCategoria.txtNome.setText("");
        AdicionarCategoria.txtDescricao.setText("");
    }
}
