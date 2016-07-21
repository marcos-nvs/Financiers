/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.calculofinanceiro;

import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */
public class CalculoFinanceiro implements Serializable {
    
    
    public Double calculoJuros(Double principal, Double taxa, int periodo){
        
        Double montante = principal * Math.pow((1+(taxa/100)), periodo);
        Double juros = montante - principal;
        return juros;
    }

    public Double calculoMontante(Double principal, Double taxa, int periodo){
        return principal * Math.pow((1+(taxa/100)), periodo);
    }
    
    public Double calculoTaxaJuros(Double principal, Double parcela, int periodo){
        return null;
    }
    
    public Double calculoParcela(Double principal, Double taxa, int periodo){
        return (calculoMontante(principal, taxa, periodo))/periodo;
    }
    
    public Double calculoJurosEfetivo(Double taxa, int periodo){
        return Math.pow((1+((taxa/100)/periodo)), periodo) -1;
    }
    
    public Double calculoCet(Double principal, Double taxa, int periodo){
        return (((calculoMontante(principal, taxa, periodo) - principal)/principal)*100);
    }

    public static void main(String[] args){
        
        Double principal = 100000d;
        Double taxa = 2d;
        int periodo = 12;
        
        CalculoFinanceiro c = new CalculoFinanceiro();
        
        Double cet = c.calculoCet(principal, taxa, periodo);
        System.out.println("CET : " + cet);
        
    }
}
