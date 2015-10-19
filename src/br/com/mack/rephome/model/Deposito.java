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
public class Deposito extends Pagamento {
    private String numeroConta;
    private String numeroAgencia;

    public Deposito(String numeroConta, String numeroAgencia, double valor, String periodicidade) {
        super(valor, periodicidade);
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    @Override
    public String toString() {
        return "Deposito{" + "numeroConta=" + numeroConta + ", numeroAgencia=" + numeroAgencia + '}';
    }
    
    
    
    
    
}
