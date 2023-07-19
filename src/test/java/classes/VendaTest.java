package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class VendaTest {

    @Test
     public void testVendaEquals() {
        Cliente cliente = new Cliente("123456789", "João", "123456789", "Rua A");
        Usuario usuario = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        HashMap<String, VendaDetalhes> vendasDetalhes = new HashMap<>();

        Venda venda1 = new Venda(1L, cliente, usuario, BigDecimal.valueOf(100.00), BigDecimal.valueOf(100.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Venda venda2 = new Venda(1L, cliente, usuario, BigDecimal.valueOf(100.00), BigDecimal.valueOf(100.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Venda venda3 = new Venda(2L, cliente, usuario, BigDecimal.valueOf(200.00), BigDecimal.valueOf(200.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Assertions.assertEquals(venda1, venda2);
        Assertions.assertTrue(venda1.equals(venda1)); 
        Assertions.assertTrue(venda1.equals(venda2)); 
        Assertions.assertFalse(venda1.equals(venda3)); 
    }

    @Test
    public void testVendaHashCode() {
        Cliente cliente = new Cliente("123456789", "João", "123456789", "Rua A");
        Usuario usuario = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        HashMap<String, VendaDetalhes> vendasDetalhes = new HashMap<>();

        Venda venda1 = new Venda(1L, cliente, usuario, BigDecimal.valueOf(100.00), BigDecimal.valueOf(100.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Venda venda2 = new Venda(1L, cliente, usuario, BigDecimal.valueOf(100.00), BigDecimal.valueOf(100.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Venda venda3 = new Venda(2L, cliente, usuario, BigDecimal.valueOf(200.00), BigDecimal.valueOf(200.00), BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), vendasDetalhes);
        Assertions.assertEquals(venda1.hashCode(), venda2.hashCode());
        Assertions.assertNotEquals(venda1.hashCode(), venda3.hashCode());
    }

}
