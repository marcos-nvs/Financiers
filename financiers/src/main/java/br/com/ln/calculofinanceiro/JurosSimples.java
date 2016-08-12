/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.calculofinanceiro;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
        System.out.println("Equivalência de Juros : " + js.taxaEquivalente(15d, 360, 1));
        System.out.println("Desconto : " + js.calcularDesconto(5000d, 4d, 2));
        System.out.println("Montante pelo Desconto: " + js.calcularDescontoMontante(370.37, 4d, 2));
        System.out.println("Prazo pelo montante : " + js.calcularDescontoPrazoPeloMontante(5000d, 400d, 4d));
        System.out.println("Taxa Juros desconto : " + js.calcularDescontoTaxaJuros(542.37d, 57.63d , 5));
        System.out.println("Prazo pelo desconto : " + js.calcularDescontoPrazoPeloPrincipal(1061.22d, 238.78d, 27d));
        System.out.println("Montante pelo desconto - Principal : " + js.calcularDescontoMontantePeloPrincipal(1921.95d, js.taxaEquivalente(23d, 360, 1), 145));
        System.out.println("Desconto Comercial: " + js.calcularDescontoComercial(5000d, 4d, 2));
        System.out.println("Montante pelo Desconto Comercial: " + js.calcularDescontoComercialMontante(400d, 4d, 2));
        System.out.println("CET : " + js.calcularCustoEfetivo(4600d, 400d, 2));
        System.out.println("Valor Nominal : " + js.calcularValorNominal(1921.95d, js.taxaEquivalente(23d, 360, 145)));
        System.out.println("Desconto Comercial : " + js.calcularDescontoComercial(18000d, js.taxaEquivalente(35d, 12, 1), 3));
        
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
 
    protected Double taxaEquivalente(Double taxaJuros, Integer tempoAtual, Integer tempoNovo){
        return taxaJuros * tempoNovo / tempoAtual;
    }
    
    protected Double calcularDesconto(Double montante, Double taxaJuros, Integer prazo){
        return (montante * (taxaJuros/100) * prazo) / (1+(taxaJuros /100) * prazo);
    }
    
    protected Double calcularDescontoMontante(Double desconto, Double taxaJuros, Integer prazo){
        return (desconto * (1 + (taxaJuros/100) * prazo)) / ((taxaJuros/100) * prazo);
    }
    
    protected Long calcularDescontoPrazoPeloMontante(Double montante, Double desconto, Double taxaJuros){
        return Math.round(desconto / ((taxaJuros/100) * (montante - desconto)));
    }
    
    protected Double calcularDescontoTaxaJuros(Double principal, Double desconto, Integer prazo){
        return (desconto / (principal * prazo)) * 100;
    }
   
    protected Double calcularDescontoPrazoPeloPrincipal(Double principal, Double desconto, Double taxaJuros){
        return (desconto / (principal * (taxaJuros/100))) * 12;
    }
    
    protected Double calcularDescontoMontantePeloPrincipal(Double principal, Double taxaJuros, Integer prazo){
        return principal * (1 + (taxaJuros/100) * prazo);
    }
    
    protected Double calcularDescontoComercial(Double montante, Double taxaJuros, Integer prazo){
        return (montante * (taxaJuros/100) * prazo);
    }
 
    protected Double calcularDescontoComercialMontante(Double desconto, Double taxaJuros, Integer prazo){
        return desconto / ((taxaJuros/100) * prazo);
    }
    
    protected Double calcularCustoEfetivo(Double principal, Double desconto, Integer prazo){
        return ((desconto / principal)/ prazo) * 100;
    }
    
    protected Double calcularValorNominal(Double principal, Double taxaJuros){
        return principal / (1-(taxaJuros /100));
    }

    
    
}
