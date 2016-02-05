/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcos Naves
 */
@Embeddable
public class LnSaldocontaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cta_in_codigo")
    private int ctaInCodigo;
    @Basic(optional = false)
    @Column(name = "sac_dt_data")
    @Temporal(TemporalType.DATE)
    private Date sacDtData;

    public LnSaldocontaPK() {
    }

    public LnSaldocontaPK(int ctaInCodigo, Date sacDtData) {
        this.ctaInCodigo = ctaInCodigo;
        this.sacDtData = sacDtData;
    }

    public int getCtaInCodigo() {
        return ctaInCodigo;
    }

    public void setCtaInCodigo(int ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public Date getSacDtData() {
        return sacDtData;
    }

    public void setSacDtData(Date sacDtData) {
        this.sacDtData = sacDtData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ctaInCodigo;
        hash += (sacDtData != null ? sacDtData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnSaldocontaPK)) {
            return false;
        }
        LnSaldocontaPK other = (LnSaldocontaPK) object;
        if (this.ctaInCodigo != other.ctaInCodigo) {
            return false;
        }
        if ((this.sacDtData == null && other.sacDtData != null) || (this.sacDtData != null && !this.sacDtData.equals(other.sacDtData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnSaldocontaPK[ ctaInCodigo=" + ctaInCodigo + ", sacDtData=" + sacDtData + " ]";
    }
    
}
