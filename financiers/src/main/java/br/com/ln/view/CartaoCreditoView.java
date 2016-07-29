/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.objeto.CartaoCredito;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "ccView")
public class CartaoCreditoView implements Serializable{
    
    private Double numCartao;
    private Double limiteCartao;
    private Integer diaVencimento;

    public CartaoCreditoView() {
    }

    public Double getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(Double numCartao) {
        this.numCartao = numCartao;
    }

    public Double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(Double limiteCartao) {
        this.limiteCartao = limiteCartao;
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
        hash = 79 * hash + Objects.hashCode(this.numCartao);
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
        final CartaoCreditoView other = (CartaoCreditoView) obj;
        if (!Objects.equals(this.numCartao, other.numCartao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartaoCreditoView{" + "numCartao=" + numCartao + ", limiteCartao=" + limiteCartao + ", diaVencimento=" + diaVencimento + '}';
    }
    
    public CartaoCredito grabCartaoCredito(){
        
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setDiaVencimentoCartao(diaVencimento);
        cartaoCredito.setLimiteCartao(limiteCartao);
        cartaoCredito.setNumeroCartao(numCartao);
        
        diaVencimento = null;
        limiteCartao = null;
        numCartao = null;

        return cartaoCredito;
    }

}
