package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void testGetSetCpf() {
        String cpf = "123456789";
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        Assertions.assertEquals(cpf, cliente.getCpf());
    }

    @Test
    public void testGetSetNome() {
        String nome = "Maria João";
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        Assertions.assertEquals(nome, cliente.getNome());
    }

    @Test
    public void testGetSetTelefone() {
        String telefone = "1234567890";
        Cliente cliente = new Cliente();
        cliente.setTelefone(telefone);
        Assertions.assertEquals(telefone, cliente.getTelefone());
    }

    @Test
    public void testGetSetEndereco() {
        String endereco = "123 Main St";
        Cliente cliente = new Cliente();
        cliente.setEndereco(endereco);
        Assertions.assertEquals(endereco, cliente.getEndereco());
    }
}
