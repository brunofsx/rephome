/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.DAO;

import br.com.mack.rephome.model.Locador;
import br.com.mack.rephome.model.Locatario;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class TesteDAO {
    
    public static void main(String[] args) {
        //listar
        /*
        LocadorDAO locador = new LocadorDAO();
        
        
        for(Locador l:  locadores){
            
            System.out.println(l);
            
        }
        
        
        //inserir
        Locador locador1 = new Locador("Fred", 2, "frederico@hotmail.com", "viadão adora o Fernandão", null, null, "3331313", "Avenida Higienopolis, numero 69, apartamento 24" );
        
        System.out.println(locador.inserir(locador1));
        */
        //update
       LocadorDAO locador = new LocadorDAO();
        Locador locadorU = new Locador ();
        locadorU.setId_user(6);
        locadorU.setNome("Bruno");
        locadorU.setEmail("brunosoave2004");
        locadorU.setDescricao("x");
        locadorU.setDataNasc(null);
        locadorU.setEndereco("x");
        locadorU.setFoto(null);
        locadorU.setTelefone("x");
        locadorU.setTelefone("x");
        locadorU.setSenha("555");
      List<Locador> locadores = locador.listar();
        
      System.out.println(locador.alterar(locadorU));
        
        
        for (Locador l : locadores ) {
            
            System.out.println(l);
            
        }
        
    }
}
