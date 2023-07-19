package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UsuarioTest {

    @Test
    public void testUsuarioEquals() {
        Usuario usuario1 = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        Usuario usuario2 = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        Usuario usuario3 = new Usuario(2L, "Outro Nome", "username2", "senha2", Perfil.PADRAO, LocalDateTime.now(), LocalDateTime.now());
        Assertions.assertTrue(usuario1.equals(usuario2)); 
        Assertions.assertFalse(usuario1.equals(usuario3)); 
    }
    
    @Test
    public void testUsuarioHashCode() {
        Usuario usuario1 = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        Usuario usuario2 = new Usuario(1L, "Nome", "username1", "senha1", Perfil.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        Usuario usuario3 = new Usuario(2L, "Outro Nome", "username2", "senha2", Perfil.PADRAO, LocalDateTime.now(), LocalDateTime.now());
        Assertions.assertEquals(usuario1.hashCode(), usuario2.hashCode());
        Assertions.assertNotEquals(usuario1.hashCode(), usuario3.hashCode());
    }

    @Test
    public void testUsuarioReset() {
        Usuario usuario = new Usuario();
        usuario.setEstado(false);
        usuario.reset();
        Assertions.assertTrue(usuario.isEstado());
    }

    @Test
    public void testUsuarioMudarEstado() {
        Usuario usuario = new Usuario();
        boolean initialState = usuario.isEstado();
        usuario.mudarEstado();
        Assertions.assertNotEquals(initialState, usuario.isEstado());
    }
}
