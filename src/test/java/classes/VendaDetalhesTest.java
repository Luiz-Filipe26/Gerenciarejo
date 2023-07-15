package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class VendaDetalhesTest {
    private VendaDetalhes vendaDetalhes;

    @BeforeEach
    public void setup() {
        vendaDetalhes = new VendaDetalhes();
    }

    @Test
    public void testGetSetVenda() {
        Venda venda = new Venda();
        vendaDetalhes.setVenda(venda);
        Assertions.assertEquals(venda, vendaDetalhes.getVenda());
    }

    @Test
    public void testGetSetProduto() {
        Produto produto = new Produto();
        vendaDetalhes.setProduto(produto);
        Assertions.assertEquals(produto, vendaDetalhes.getProduto());
    }

    @Test
    public void testGetSetQuantidade() {
        int quantidade = 10;
        vendaDetalhes.setQuantidade(quantidade);
        Assertions.assertEquals(quantidade, vendaDetalhes.getQuantidade());
    }

    @Test
    public void testGetSetDesconto() {
        BigDecimal desconto = new BigDecimal("10.5");
        vendaDetalhes.setDesconto(desconto);
        Assertions.assertEquals(desconto, vendaDetalhes.getDesconto());
    }

    @Test
    public void testGetSetTotal() {
        BigDecimal total = new BigDecimal("100.0");
        vendaDetalhes.setTotal(total);
        Assertions.assertEquals(total, vendaDetalhes.getTotal());
    }
}

