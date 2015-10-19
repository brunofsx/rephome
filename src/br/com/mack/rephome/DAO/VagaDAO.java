/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import br.com.mack.rephome.model.Locatario;
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
public class VagaDAO implements GenericsDAO<Vaga> {

    @Override
    public List<Vaga> listar() {
         List<Vaga> vagas = new ArrayList();
        
        Connection conn = Conexao.getConn();
        String sql = "select * from vagas";
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                Vaga vaga = new Vaga();
                
                vaga.setPreco(rs.getDouble("preco"));
                vaga.setId(rs.getInt("id"));
                vaga.setCandidatos((ArrayList<Locatario>) rs.getArray("candidatos"));
                vagas.add(vaga);
                
            }
            
            conn.close();
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vagas;
        
    
    }

    @Override
    public boolean inserir(Vaga e) {
        Connection conn = Conexao.getConn();
    String sql = "insert into vagas (preco, disponibilidade, candidatos) values(?,?,?)";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, e.getPreco());
            ps.setBoolean(2, e.isDisponibilidade());
            ps.setArray(3, (Array) e.getCandidatos());
             
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
    public boolean alterar(Vaga e) {
      Connection conn = Conexao.getConn();
    String sql = "update vagas set preco=?, disponiblidade=?, candidatos=? where id = ?";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, e.getPreco());
            ps.setBoolean(2, e.isDisponibilidade());
            ps.setArray(3, (Array) e.getCandidatos());
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
    public boolean remover(Vaga e) {
      Connection conn = Conexao.getConn();
    String sql = "delete from vagas where id=?";
      boolean resposta = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getId());
           
            int resp = ps.executeUpdate();
            if(resp>0)resposta = true;
            
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepublicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resposta;
        }
    
}
