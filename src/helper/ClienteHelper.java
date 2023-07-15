
package helper;

import javax.swing.JOptionPane;
import classes.*;
import controller.*;

public class ClienteHelper {

    public static void validarEntrada(String cpfTexto, String nome,  String contato, String endereco) throws Exception {

        int cont = 0;
        

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (cpfTexto.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo CPF vazio! Preencha por favor.");
            return;
        }

        if (contato.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Contato vazio! Preencha por favor.");
            return;
        }

        if (endereco.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Endereco vazio! Preencha por favor.");
            return;
        }
        
       
        
        

        if (cont > 0) {
            JOptionPane.showMessageDialog(null, "Verifique o campo em branco e tente novamente.");
        } else {

            Cliente c1 = new Cliente(cpfTexto, nome, contato, endereco);
            ClienteController.adicionarCliente(c1);
        }

    }
    
    public static void validarAtualizacao(String cpfTexto, String nome,  String contato, String endereco){
        
        int cont = 0;
       

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (cpfTexto.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo CPF vazio! Preencha por favor.");
            return;
        }

        if (contato.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Contato vazio! Preencha por favor.");
            return;
        }

        if (endereco.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Endereco vazio! Preencha por favor.");
            return;
        }              
        
        ClienteController.atualizarCliente(cpfTexto, nome, contato, endereco);
        
    }
    
    public static void validarExclusao(String cpf){
        
        int cont = 0;       

        if (cpf.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo CPF vazio! Preencha por favor.");
            return;
        }
        
        ClienteController.deletarCliente(cpf);
    }

}
