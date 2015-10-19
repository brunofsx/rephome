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
public class Pessoa {
    private int id_user;
    private String nome;
    private String email;
    private String descricao;
    private Date dataNasc;
    private Blob foto;
    private String  telefone;
    private String endereco;
    private String senha;
    
    public Pessoa(){
        
        
        
    }

    public Pessoa(int id_user, String nome,  String email, String descricao, Date dataNasc, Blob foto, String telefone, String endereco, String senha) {
        this.id_user = id_user;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataNasc = dataNasc;
        this.foto = foto;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha= senha;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

  

  
   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id_user=" + id_user + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataNasc=" + dataNasc + ", foto=" + foto + ", telefone=" + telefone + ", endereco=" + endereco + ", senha=" + senha;
    }
    

}
   