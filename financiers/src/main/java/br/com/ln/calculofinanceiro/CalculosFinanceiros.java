/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.calculofinanceiro;

import br.com.ln.tipos.TipoPeriodo;
import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */
public class CalculosFinanceiros implements Serializable {

    public Double conversaoTxPorPeriodo(Double taxa, TipoPeriodo periodoAtualTx, TipoPeriodo periodoNovoTx) {

        Double txJuros = (taxa / 100);
        
        switch (periodoAtualTx){
            case ANUAL:
                System.out.println("tx juros : " + txJuros); 
                return (converteAnual(txJuros, periodoNovoTx)) * 100d;
            case SEMESTRAL:
                return (converteSemestral(txJuros, periodoNovoTx)) * 100d;
            case QUADRIMESTRAL:
                return (converteQuadrimestal(txJuros, periodoNovoTx)) * 100;
            case TRIMESTRAL:
                return (converteTrimestral(txJuros, periodoNovoTx)) * 100;
            case BIMESTRAL:
                return (converteBimestral(txJuros, periodoNovoTx)) * 100;
            case MENSAL:
                return (converteMensal(txJuros, periodoNovoTx)) * 100;
            case DIARIO:
                return (converteDiario(txJuros, periodoNovoTx)) * 100;
        }

        return null;
    }

    public Double calculoCoeficienteFinanceiro(Double taxa, int periodo) {

        Double txJuros = (taxa / 100);
        Double cf = (txJuros / (1 - (1 / (Math.pow((1 + txJuros), periodo)))));
        return cf;
    }

    public Double calculoValorParcela(Double principal, Double taxa, int periodo) {

        Double cf = calculoCoeficienteFinanceiro(taxa, periodo);
        return principal * cf;
    }

    public Double calculoValorMontante(Double principal, Double taxa, int periodo) {
        return periodo * calculoValorParcela(principal, taxa, periodo);
    }

    public Double calculoValorJuros(Double principal, Double taxa, int periodo) {

        Double montante = calculoValorMontante(principal, taxa, periodo);
        Double juros = montante - principal;
        return juros;
    }
    
    public Double calculoTaxaJuros(Double principal, Double montante, int periodo) {
       return (Math.pow((montante/principal), (1d/periodo)) -1) * 100;
    }

    public Double calculoJurosEfetivo(Double taxa, int periodo) {
        return (Math.pow((1 + ((taxa / 100) / periodo)), periodo) - 1) * 100;
    }

    public Double calculoCet(Double principal, Double taxa, int periodo) {
        return (((calculoValorMontante(principal, taxa, periodo) - principal) / principal) * 100);
    }

    public static void main(String[] args) {

        CalculosFinanceiros c = new CalculosFinanceiros();

        Double principal = 6383.66d;
        int periodo = 54;
        Double parcela = 288.48d;
        Double juros = 3.80d;
        Double montante = 15577.92d;
        
        System.out.println("Valor Principal : " + principal);
        System.out.println("Periodo: " + periodo);
        System.out.println("Valor Parcela : " + parcela);
        System.out.println("Juros  : " + juros);
        System.out.println("Montante : " + montante);

        System.out.println("=============================================================================================================");
        
        Double txJuros = c.calculoTaxaJuros(principal, montante, periodo);
        System.out.println("Calculo do % Juros :" + txJuros);
        System.out.println("Valor da Parcelas  : " + c.calculoValorParcela(principal, juros, periodo));
        System.out.println("CET : " + c.calculoCet(principal, juros, periodo));
        System.out.println("CF : " + c.calculoCoeficienteFinanceiro(juros, periodo));
        System.out.println("Juros Efetivo : " + c.calculoJurosEfetivo(juros, periodo));
        System.out.println("Valor Juros : " + c.calculoValorJuros(principal, juros, periodo));
        System.out.println("Valor Montante : " + c.calculoValorMontante(principal, juros, periodo));
        
        System.out.println("=============================================================================================================");
    }

    protected Double converteAnual(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            return Math.pow((1 + txJuros), (6d/12d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            return Math.pow((1 + txJuros), (4d/12d)) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            return Math.pow((1 + txJuros), (3d/12d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), (2d/12d)) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), (1d/12d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/360d)) -1;
        }
        
        return null;
    }

    protected Double converteSemestral(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), (2d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            return Math.pow((1 + txJuros), (4d/6d)) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            return Math.pow((1 + txJuros), (3d/12d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), (2d/6d)) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), (1d/6d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/180d)) -1;
        }
        
        return null;
    }

    protected Double converteQuadrimestal(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), (3d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            Double txMensal = Math.pow((1 + txJuros), (1d/4d)) - 1;
            return Math.pow((1 + txMensal), 6d) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            return Math.pow((1 + txJuros), (3d/4d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), (2d/4d)) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), (1d/4d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/120d)) -1;
        }
        
        return null;
    }

    protected Double converteTrimestral(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), (4d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            return Math.pow((1 + txJuros), 2d) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            Double txMensal = Math.pow((1 + txJuros), (1d/3d)) - 1;
            return Math.pow((1 + txMensal), 3d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), (2d/3d)) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), (1d/3d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/90d)) -1;
        }
        
        return null;
    }

    protected Double converteBimestral(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), (6d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            return Math.pow((1 + txJuros), 3d) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            return Math.pow((1 + txJuros), 2d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            Double txMensal = Math.pow((1 + txJuros), (1d/3d)) - 1;
            return Math.pow((1 + txJuros), 3d) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), (1d/2d)) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/60d)) -1;
        }
        
        return null;
    }

    protected Double converteMensal(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), 12d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            return Math.pow((1 + txJuros), 6d) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            return Math.pow((1 + txJuros), 4d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            return Math.pow((1 + txJuros), 3d) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), 2d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.DIARIO)) {
            return Math.pow((1 + txJuros), (1d/30d)) -1;
        }
        
        return null;
    }

    protected Double converteDiario(Double txJuros, TipoPeriodo periodoNovoTx) {

        if (periodoNovoTx.equals(TipoPeriodo.ANUAL)) {
            return Math.pow((1 + txJuros), 360d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.SEMESTRAL)) {
            return Math.pow((1 + txJuros), 180d) - 1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.QUADRIMESTRAL)) {
            return Math.pow((1 + txJuros), 120d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.TRIMESTRAL)) {
            return Math.pow((1 + txJuros), 90d) -1 ;
        }

        if (periodoNovoTx.equals(TipoPeriodo.BIMESTRAL)) {
            return Math.pow((1 + txJuros), 60d) -1;
        }

        if (periodoNovoTx.equals(TipoPeriodo.MENSAL)) {
            return Math.pow((1 + txJuros), 30d) -1;
        }
        
        return null;
    }

}
