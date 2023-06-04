
package Helper;

import javax.swing.JOptionPane;
import classes.*;
import controller.*;

public class ClienteHelper {

    public static void validarEntrada(String nome, String cpf, String contato, String endereco) throws Exception {

        int cont = 0;

        if (nome.trim().length() == 0) {
            cont++;
            JOptionPane.showMessageDialog(null, "Campo Nome vazio! Preencha por favor.");
            return;

        }

        if (cpf.trim().length() == 0) {
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

            Cliente c1 = new Cliente(cpf, nome, contato, endereco);
            ClienteController.adicionarCliente(c1);
        }

    }

}
