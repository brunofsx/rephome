/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import br.com.mack.rephome.model.Locatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class LocatarioDAO implements GenericsDAO<Locatario> {

    @Override
    public List<Locatario> listar() {
        
        List<Locatario> locatarios = new ArrayList();
        Connection conn = Conexao.getConn();
        String sql = "select * from locatario";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
               ResultSet rs =stm.executeQuery();
            
               while(rs.next()){
                   Locatario l = new Locatario();
                   
                l.setId_user(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setEmail(rs.getString("email"));
                l.setEndereco(rs.getString("endereco"));
                l.setTelefone(rs.getString("telefone"));
                l.setFoto(rs.getBlob("foto"));
                l.setDataNasc(rs.getDate("datanasci"));
                l.setDescricao(rs.getString("descricao"));
                l.setNomeFiador(rs.getString("nomefiador"));
                l.setSenha(rs.getString("senha"));
                
                  locatarios.add(l);
                   
               }
               conn.close();
               stm.close();
               rs.close();
               
            
        } catch (SQLException ex) {
            Logger.getLogger(LocatarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return locatarios;
    }

    @Override
    public boolean inserir(Locatario e) {
     boolean resposta = false;
        try {
            Connection conn = Conexao.getConn();
            String sql = "INSERT INTO locatario(nome, email, descricao, datanasci, foto, telefone, endereco, nomefiador, senha) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getNome());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDescricao());
            ps.setDate(4, (java.sql.Date)e.getDataNasc());
            ps.setBlob(5, e.getFoto());
            ps.setString(6, e.getTelefone());
            ps.setString(7, e.getEndereco());
            ps.setString(8, e.getNomeFiador());
            ps.setString(9, e.getSenha());
            
            int resp = ps.executeUpdate();
            if(resp>0)resposta = true;
            
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resposta;
        
    
    }

    @Override
    public boolean alterar(Locatario e) {

    
           boolean resposta = false;
        try {
            Connection conn =  Conexao.getConn();
            String sql = "UPDATE locatario SET nome = ?, email = ?, descricao = ?, datanasci = ?, foto = ?, telefone = ?, endereco = ?, nomefiador= ?, senha=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getNome());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDescricao());
            ps.setDate(4, (java.sql.Date) e.getDataNasc());
            ps.setBlob(5, e.getFoto());
            ps.setString(6, e.getTelefone());
            ps.setString(7, e.getEndereco());
            ps.setString(8, e.getNomeFiador());
            ps.setString(9, e.getSenha());
            ps.setInt(10, e.getId_user());
            
            int resp = ps.executeUpdate();
            
            if(resp>0) resposta = true;
            
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return resposta;
    
    }

    @Override
    public boolean remover(Locatario e) {
 boolean resposta = false;
        Connection conn = Conexao.getConn();
        
        
        try{
         
        String sql = "delete from locatario where id=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1, e.getId_user() );
        
       int resp = stm.executeUpdate();
        
            if(resp>0){
                
                resposta=true;
                
            }
        conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;    }
    
}
