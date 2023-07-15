package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoriaTest {
    
    @Test
    public void testCategoriaEquals() {
        Categoria categoria1 = new Categoria(1L, "Nome", "Descrição");
        Categoria categoria2 = new Categoria(1L, "Nome", "Descrição");
        Categoria categoria3 = new Categoria(2L, "Outro Nome", "Outra Descrição");
        Assertions.assertEquals(categoria1, categoria2);
        Assertions.assertNotEquals(categoria1, categoria3);
    }

    @Test
    public void testCategoriaHashCode() {
        Categoria categoria1 = new Categoria(1L, "Nome", "Descrição");
        Categoria categoria2 = new Categoria(1L, "Nome", "Descrição");
        Categoria categoria3 = new Categoria(2L, "Outro Nome", "Outra Descrição");
        Assertions.assertEquals(categoria1.hashCode(), categoria2.hashCode());
        Assertions.assertNotEquals(categoria1.hashCode(), categoria3.hashCode());
    }

    @Test
    public void testCategoriaToString() {
        Categoria categoria = new Categoria(1L, "Nome", "Descrição");
        String expectedToString = "Categoria{id=1, name=Nome, descricao=Descrição}";
        Assertions.assertEquals(expectedToString, categoria.toString());
    }    
}
