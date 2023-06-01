
package configViewLogin;

/**
 *
 * @author Thiago
 */
public class Login_Tela {
    
    private String usuario;
    private String senha;

    public Login_Tela(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
