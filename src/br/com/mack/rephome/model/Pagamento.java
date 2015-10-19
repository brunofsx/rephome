/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.rephome.model;

/**
 *
 * @author Bruno
 */
public class Pagamento {
    private double valor;
    private String  periodicidade;

    public Pagamento(double valor, String periodicidade) {
        this.valor = valor;
        this.periodicidade = periodicidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "valor=" + valor + ", periodicidade=" + periodicidade + '}';
    }
    
    
   
    
}
