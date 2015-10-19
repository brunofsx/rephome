/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rephome;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Bruno
 */
public class Datas {
    public static void main(String[] args) throws ParseException {
        
        Calendar c = Calendar.getInstance(); 
        
        Date data = new Date(93, 0, 05); 
        System.out.println("Data atual sem formatação: "+data);
        
        DateFormat formataData = DateFormat.getDateInstance(); 
        System.out.println("Data atual com formatação: "+ formataData.format(data)); 

        
     Calendar c2 = Calendar.getInstance(); 
     c2.set(1993, Calendar.JANUARY, 5);
     Date data3=c2.getTime();

     DateFormat f = DateFormat.getDateInstance();
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
     System.out.println("Data formatada: "+sdf.format(data3));

        
    }
}
