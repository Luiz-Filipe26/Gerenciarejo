/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import persistencia.*;
import classes.*;

/**
 *
 * @author ytalo
 */
public class ClienteController {
    
    public static void adicionarCliente(Cliente cliente) {
        persistencia.ClienteDAO.inserirCliente(cliente);
    }
    
}
