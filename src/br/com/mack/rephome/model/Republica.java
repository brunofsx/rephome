/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.model;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Republica {
   
    private int id;
    private Blob foto;
    private String descricao;
    private ArrayList<Vaga> numeroVagas;

    public Republica() {
    }
    
    

    public Republica( int id, String tamanho, Blob foto, String descricao, ArrayList<Vaga> vagas) {
      
        this.id=id;
        this.foto = foto;
        this.descricao = descricao;
        this.numeroVagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




 

  

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

  

    public ArrayList<Vaga> getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(ArrayList<Vaga> numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    @Override
    public String toString() {
        return "Republica{" + "id=" + id + ", foto=" + foto + ", descricao=" + descricao + ", numeroVagas=" + numeroVagas + '}';
    }

   

    
  
    
    
    
}
