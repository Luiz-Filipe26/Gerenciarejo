package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoVOTest {

    @Test
    public void testProdutoVOEquals() {
        ProdutoVO produto1 = new ProdutoVO(1L, "Produto 1", "Descrição do produto 1", 10.0, 5);
        ProdutoVO produto2 = new ProdutoVO(1L, "Produto 1", "Descrição do produto 1", 10.0, 5);
        ProdutoVO produto3 = new ProdutoVO(2L, "Produto 2", "Descrição do produto 2", 20.0, 10);
        Assertions.assertEquals(produto1, produto2);
        Assertions.assertNotEquals(produto1, produto3);
    }

    @Test
    public void testProdutoVOHashCode() {
        ProdutoVO produto1 = new ProdutoVO(1L, "Produto 1", "Descrição do produto 1", 10.0, 5);
        ProdutoVO produto2 = new ProdutoVO(1L, "Produto 1", "Descrição do produto 1", 10.0, 5);
        ProdutoVO produto3 = new ProdutoVO(2L, "Produto 2", "Descrição do produto 2", 20.0, 10);
        Assertions.assertEquals(produto1.hashCode(), produto2.hashCode());
        Assertions.assertNotEquals(produto1.hashCode(), produto3.hashCode());
    }

}
