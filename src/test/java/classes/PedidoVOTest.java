
package classes;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoVOTest {
    
    public PedidoVOTest() {
    }
    
    
    @Test
    public void testAdicionarProdutoVO() {
        ProdutoVO produto1 = new ProdutoVO(1L, "Produto 1", "Descrição", 10.5, 5);
        PedidoVO pedido = new PedidoVO(1L); 
        int result = pedido.adicionarProdutoVO(produto1);
        assertEquals(1, result);
        assertEquals(1, pedido.getProdutos().size());
        assertTrue(pedido.getProdutos().contains(produto1));
    }


    @Test
    public void testRemoverProduto() {
        PedidoVO pedido = new PedidoVO(1L); 
        ProdutoVO produto = new ProdutoVO();
        pedido.adicionarProdutoVO(produto);
        int result = pedido.removerProduto(produto);
        assertEquals(1, result);
        assertEquals(0, pedido.getProdutos().size());
        assertFalse(pedido.getProdutos().contains(produto));
    }

    @Test
    public void testPesquisar() {
        PedidoVO pedido = new PedidoVO(1L); 
        ProdutoVO produto1 = new ProdutoVO(1L, "Produto 1", "Descrição", 10.5, 5);
        ProdutoVO produto2 = new ProdutoVO(2L, "Produto 2", "Descrição", 10.5, 5);
        pedido.adicionarProdutoVO(produto1);
        pedido.adicionarProdutoVO(produto2);
        ProdutoVO result = pedido.pesquisar(1L);
        assertEquals(produto1, result);
    }

    @Test
    public void testAtualizar() {
        PedidoVO pedido = new PedidoVO(1L); 
        ProdutoVO produto1 = new ProdutoVO(1L, "Produto 1", "Descrição", 10.5, 5);
        ProdutoVO produto2 = new ProdutoVO(2L, "Produto 2", "Descrição", 10.5, 5);
        pedido.adicionarProdutoVO(produto1);
        pedido.adicionarProdutoVO(produto2);

        ProdutoVO produtoAtualizar = pedido.pesquisar(1L);
        produtoAtualizar.setDescricaoProduto("Descrição Atualizada");
        int result = pedido.atualizar(produtoAtualizar);
        assertEquals(1, result);
        ProdutoVO produtoAtualizadoNoPedido = pedido.pesquisar(1L);
        assertEquals("Descrição Atualizada", produtoAtualizadoNoPedido.getDescricaoProduto());
    }
   
}
