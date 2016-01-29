/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class Banco implements Serializable{
    
    private Integer agencia;
    private Integer contaCorrente;
    private Double limiteConta;
    private Integer diaVencimento;

    public Banco() {
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(Double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.agencia);
        hash = 59 * hash + Objects.hashCode(this.contaCorrente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Banco other = (Banco) obj;
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        if (!Objects.equals(this.contaCorrente, other.contaCorrente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banco{" + "agencia=" + agencia + ", contaCorrente=" + contaCorrente + ", limiteConta=" + limiteConta + ", diaVencimento=" + diaVencimento + '}';
    }


}
