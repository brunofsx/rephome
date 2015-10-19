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

public class Locador extends Pessoa {

    public Locador(){
        
       super(); 
    }

    

    public Locador(int id_user, String nome,  String email, String descricao, Date dataNasc, Blob foto, String telefone, String endereco, String senha) {
        super(id_user, nome,  email, descricao, dataNasc, foto, telefone, endereco, senha);
    }

    

   

}
