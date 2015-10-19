/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.model;

import br.com.mack.rephome.model.Locatario;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Vaga{
    private int id;
    private double preco;
    private boolean disponibilidade;
    ArrayList<Locatario> candidatos;

    public Vaga() {
    }
    
    

    public Vaga(int id, double preco, boolean disponibilidade, ArrayList<Locatario> candidatos) {
        this.id=id;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.candidatos = candidatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Locatario> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Locatario> candidatos) {
        this.candidatos = candidatos;
    }

  
    

  

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Vaga{" + "id=" + id + ", preco=" + preco + ", disponibilidade=" + disponibilidade + ", candidatos=" + candidatos + '}';
    }

   


    
    
}

