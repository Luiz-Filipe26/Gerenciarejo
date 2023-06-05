
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import configViewLogin.*;
import persistencia.AutenticacaoDAO;
import classes.*;
import javax.swing.JOptionPane;

//Evento de ação
public class LoginController implements ActionListener {
    
    private AutenticacaoDAO autenticacaoDao;
    private final Login login;
    
    public LoginController(Login login){
        this.login = login;
        this.autenticacaoDao = new AutenticacaoDAO();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Verifica qual comando
        //System.out.println(ae.getActionCommand());
        
        String acao = ae.getActionCommand().toLowerCase();
        
        switch(acao){
            case "login" : login(); break;
            case "cancelar" : cancelar(); break;
    }
        
   
    
}

    private void login() {
        String usuario = this.login.getTxtLoginUsuario().getText();
        String senha = this.login.getTxtLoginSenha().getText();
        
        if(usuario.equals("") ||senha.equals("")){
            this.login.getLabelLoginMensagem().setText("Usuario e senha devem ser preenchidos");
            return;
        }
        
        Login_Tela loginTela = new Login_Tela(usuario, senha);
        
        Usuario usuarioTemp = this.autenticacaoDao.login(loginTela);
        
        if(usuarioTemp !=null ){
            if (usuarioTemp.getPerfil() == Perfil.ADMIN){
                this.login.dispose();
                new HomeAdmin(true);
            }
            if (usuarioTemp.getPerfil() == Perfil.PADRAO){
                this.login.dispose();
                new HomePadrao(true);
            }
        }else{
            this.login.getLabelLoginMensagem().setText("Usuario e senha incorreta");
        }
    }

    private void logout() {
        Login_Tela loginTela = new Login_Tela("","");

        Usuario usuarioTemp = this.autenticacaoDao.login(loginTela);

    }

    private void cancelar() {
    int confirma = JOptionPane.showConfirmDialog(null, "Tens certeza que desejas sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }
    
    private void LimparCampos() {
        this.login.getTxtLoginSenha().setText("");
        this.login.getTxtLoginSenha().setText("");
        this.login.getLabelLoginMensagem().setText("");

    }
}