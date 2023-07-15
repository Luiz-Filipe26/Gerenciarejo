/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.*;

/**
 *
 * @author ytalo
 */
public class CategoriaController {
    
    public static void adicionarCategoria(Categoria categoria) {
        persistencia.CategoriaDAO.inserirCategoria(categoria);
    }
    
    public static void atualizarCategoria (String nome, String descricao){
        persistencia.CategoriaDAO.atualizarCategoria(nome, descricao);
    }
    
    public static void deletarCategoria(String nome){
        persistencia.CategoriaDAO.deletarCategoria(nome);
    }
    
}
