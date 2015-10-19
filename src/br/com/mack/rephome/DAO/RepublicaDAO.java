/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import br.com.mack.rephome.model.Republica;
import br.com.mack.rephome.model.Vaga;
import java.sql.Array;
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
public class RepublicaDAO  implements GenericsDAO<Republica>{

    @Override
    public List<Republica> listar() {
        List<Republica> republicas = new ArrayList();
        
        Connection conn = Conexao.getConn();
        String sql = "select * from republicas";
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                Republica rep = new Republica();
                
                rep.setDescricao(rs.getNString("descricao"));
                rep.setFoto(rs.getBlob("foto"));
                rep.setNumeroVagas((ArrayList<Vaga>) rs.getArray("numerovagas"));
              republicas.add(rep);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return republicas;
        
        
    }

    @Override
    public boolean inserir(Republica e) {

    Connection conn = Conexao.getConn();
    String sql = "insert into republica (descricao, foto, numerovagas) values(?,?,?)";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getDescricao());
            ps.setBlob(2, e.getFoto());
            ps.setArray(3, (Array) e.getNumeroVagas());
             
            int resp = ps.executeUpdate();
            if(resp>0)resposta = true;
            
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resposta;
    
    }

    @Override
    public boolean alterar(Republica e) {
 Connection conn = Conexao.getConn();
    String sql = "udpate republica set descricao=?, set foto=?, set numerovagas =? where id =?";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getDescricao());
            ps.setBlob(2, e.getFoto());
            ps.setArray(3, (Array) e.getNumeroVagas());
            ps.setInt(4, e.getId());
             
            int resp = ps.executeUpdate();
            if(resp>0)resposta = true;
            
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resposta;
        }

    @Override
    public boolean remover(Republica e) {
         Connection conn = Conexao.getConn();
    String sql = "delete from republica where id=?";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
           
          
            int resp = ps.executeUpdate();
            if(resp>0){
                
                resposta=true;
                
            }
            
            
            
            ps.close();
            conn.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resposta;
    
    
    }
    
}
