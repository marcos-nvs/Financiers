/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class CartaoCredito implements Serializable{
    
    private Double numeroCartao;
    private Double limiteCartao;
    private Integer diaVencimentoCartao;

    public CartaoCredito() {
    }

    public Double getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Double numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(Double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public Integer getDiaVencimentoCartao() {
        return diaVencimentoCartao;
    }

    public void setDiaVencimentoCartao(Integer diaVencimentoCartao) {
        this.diaVencimentoCartao = diaVencimentoCartao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.numeroCartao);
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
        final CartaoCredito other = (CartaoCredito) obj;
        if (!Objects.equals(this.numeroCartao, other.numeroCartao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" + "numeroCartao=" + numeroCartao + ", limiteCartao=" + limiteCartao + ", diaVencimentoCartao=" + diaVencimentoCartao + '}';
    }
    
}
