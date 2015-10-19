/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rephome;

import br.com.mack.rephome.model.Locador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bruno
 */
public class Rephome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Locador locador = new Locador();
        Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/rephomeDB", "mack", "mack");
        
        String sql = "  UPDATE LOCADOR SET NOME = ?, DESCRICAO=?,EMAIL=?, FOTO=?, DATANASCI=? WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1,locador.getNome() );
        stm.setString(2, locador.getDescricao());
        stm.setString(3, locador.getEmail());
        stm.setBlob(4, locador.getFoto());
        stm.setDate(5, (Date) locador.getDataNasc());
        stm.setInt(6, locador.getId_user());
        
        int i =stm.executeUpdate();
        System.out.println(i);
       

    }
    
}
