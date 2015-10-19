/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import br.com.mack.rephome.model.Locador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class LocadorDAO implements GenericsDAO<Locador> {

    @Override
    public List listar() {
    List<Locador> locadores = new ArrayList();
        
        try {
            
            Connection conn = Conexao.getConn();
            
            String sql = "SELECT * FROM LOCADOR";
            
            PreparedStatement stm = conn.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                Locador l= new Locador();
                l.setId_user(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setEmail(rs.getString("email"));
                l.setEndereco(rs.getString("endereco"));
                l.setTelefone(rs.getString("telefone"));
                l.setFoto(rs.getBlob("foto"));
                l.setDataNasc(rs.getDate("datanasci"));
                l.setDescricao(rs.getString("descricao"));
                l.setSenha(rs.getString("senha"));
                
                        
                       
                
                locadores.add(l);
                
            }
            rs.close();
            stm.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return locadores;
    
    }

    @Override
    public boolean inserir(Locador locador) {
        boolean resposta = false;
        try {
            Connection conn = Conexao.getConn();
            String sql = "INSERT INTO Locador(nome, email, descricao, datanasci, foto, telefone, endereco, senha) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, locador.getNome());
            ps.setString(2, locador.getEmail());
            ps.setString(3, locador.getDescricao());
            ps.setDate(4, (java.sql.Date) locador.getDataNasc());
            ps.setBlob(5, locador.getFoto());
            ps.setString(6, locador.getTelefone());
            ps.setString(7, locador.getEndereco());
            ps.setString(8, locador.getSenha());
            
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
    public boolean alterar(Locador locador) {
            boolean resposta = false;
        try {
            Connection conn =  Conexao.getConn();
            String sql = "UPDATE locador SET nome = ?, email = ?, descricao = ?, datanasci = ?, foto = ?, telefone = ?, endereco = ?, senha=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, locador.getNome());
            ps.setString(2, locador.getEmail());
            ps.setString(3, locador.getDescricao());
            ps.setDate(4, (java.sql.Date) locador.getDataNasc());
            ps.setBlob(5, locador.getFoto());
            ps.setString(6, locador.getTelefone());
            ps.setString(7, locador.getEndereco());
            ps.setString(8, locador.getSenha());
            ps.setInt(9, locador.getId_user());
            
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
    public boolean remover(Locador locador) {
        boolean resposta = false;
        Connection conn = Conexao.getConn();
        
        
        try{
         
        String sql = "delete from locador where id=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setInt(1,locador.getId_user() );
        
       int resultado = stm.executeUpdate();
        
        System.out.println(resultado);
        conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LocadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }
    
}
