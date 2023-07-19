
package classes;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {
    
    public ProdutoTest() {
    }
    
    @Test
    public void testHashCode() {
        Produto produto = new Produto("Produto","Descrição","Categoria",5,BigDecimal.ONE);
        int expResult = 83 * 7 ;
        int result = produto.hashCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        Object obj = null;
        Produto produto = new Produto();
        assertFalse(produto.equals(obj)); 
    }
}
