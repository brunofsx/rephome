/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.model;

import java.io.File;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Locatario extends Pessoa{
    private String nomeFiador;

    public Locatario() {
    }

    public Locatario(int id_user, String nome,  String email, String descricao, Date dataNasc, Blob foto, String telefone, String endereco, String senha, String nomeFiador) {
        super(id_user, nome,  email, descricao, dataNasc, foto, telefone, endereco, senha);
        this.nomeFiador = nomeFiador;
    }

    public String getNomeFiador() {
        return nomeFiador;
    }

    public void setNomeFiador(String nomeFiador) {
        this.nomeFiador = nomeFiador;
    }

    @Override
    public String toString() {
        return super.toString() +", "+ "nomeFiador=" + nomeFiador;
    }

   
    
    
    

  
}
