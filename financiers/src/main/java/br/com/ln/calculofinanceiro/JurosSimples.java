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
public class JurosSimples implements Serializable {
    
    public static void main(String[] args) {
        
        JurosSimples js = new JurosSimples();
        System.out.println("Juros : " + js.valorJurosPeloPrincipal(1000d, 10d, 5));
        System.out.println("Principal: " + js.principalPeloJuros(500d, 10d, 5));
        System.out.println("Taxa Juros: " + js.taxaJurosPeloPrincipal(1000d, 500d, 5));
        System.out.println("Montante: " + js.montante(1000d, 10d, 5));
        System.out.println("Principal pelo montante: " + js.principalPeloMontante(1500d, 10d, 5));
        System.out.println("Taxa Juros pelo montante: " + js.taxaJurosPeloMontante(1500d, 1000d, 5));
        System.out.println("Prazo: " + js.prazo(1500d, 1000d, 10d));
        
    }
    
    protected Double valorJurosPeloPrincipal(Double principal, Double taxaJuros, Integer prazo){
        return principal * (taxaJuros /100) * prazo;
    }

    protected Double principalPeloJuros(Double valorJuros, Double taxaJuros, Integer prazo ){
        return valorJuros/ ((taxaJuros/100) * prazo);
    }

    protected Double principalPeloMontante(Double montante, Double taxaJuros, Integer prazo ){
        return montante / (1+(taxaJuros/100) * prazo);
    }

    protected Double taxaJurosPeloPrincipal(Double principal, Double valorJuros, Integer prazo){
        return (valorJuros / (principal * prazo)) * 100;
    }

    protected Double taxaJurosPeloMontante(Double montante, Double principal, Integer prazo){
        return (((montante/principal) - 1) / prazo) * 100;
    }

    protected Double montante(Double principal, Double taxaJuros, Integer prazo){
        return principal * (1+ (taxaJuros /100)* prazo);
    }
    
    protected Double prazo(Double montante, Double principal, Double taxaJuros){
        return ((montante/principal) -1) / (taxaJuros/100);
    }
 
    
   
}
