/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import java.util.List;

/**
 *
 * @author Bruno
 */
public interface GenericsDAO<E> {
    
    public List<E> listar();
    public boolean inserir(E e);
    public boolean alterar(E e);
    public boolean remover(E e);
       
    
}
