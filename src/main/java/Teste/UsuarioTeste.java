
package Teste;

import classes.Perfil;
import classes.Usuario;
import java.time.LocalDateTime;
import persistencia.*;


public class UsuarioTeste {
    
    public static void main(String[] args) {
        
       // Usuario usuario = new Usuario(0L, "Thiago", "ThSalles", "123", PERFIL.ADMIN, null, null);
        Usuario usuario = new Usuario(0L, "Thiago", "ThSalles", "1234", Perfil.ADMIN, null, null);
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
        
        
    }
    
}
