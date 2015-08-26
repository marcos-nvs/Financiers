/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marcos Naves
 */
@Embeddable
public class LnContadependentePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cta_in_codigo")
    private int ctaInCodigo;
    @Basic(optional = false)
    @Column(name = "cta_in_calculada")
    private int ctaInCalculada;

    public LnContadependentePK() {
    }

    public LnContadependentePK(int ctaInCodigo, int ctaInCalculada) {
        this.ctaInCodigo = ctaInCodigo;
        this.ctaInCalculada = ctaInCalculada;
    }

    public int getCtaInCodigo() {
        return ctaInCodigo;
    }

    public void setCtaInCodigo(int ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public int getCtaInCalculada() {
        return ctaInCalculada;
    }

    public void setCtaInCalculada(int ctaInCalculada) {
        this.ctaInCalculada = ctaInCalculada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ctaInCodigo;
        hash += (int) ctaInCalculada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnContadependentePK)) {
            return false;
        }
        LnContadependentePK other = (LnContadependentePK) object;
        if (this.ctaInCodigo != other.ctaInCodigo) {
            return false;
        }
        if (this.ctaInCalculada != other.ctaInCalculada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnContadependentePK[ ctaInCodigo=" + ctaInCodigo + ", ctaInCalculada=" + ctaInCalculada + " ]";
    }
    
}
