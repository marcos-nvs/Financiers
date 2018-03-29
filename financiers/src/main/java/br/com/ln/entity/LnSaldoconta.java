/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_saldoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnSaldoconta.findAll", query = "SELECT l FROM LnSaldoconta l"),
    @NamedQuery(name = "LnSaldoconta.findByCtaInCodigoSacDtData", query = "SELECT l FROM LnSaldoconta l WHERE l.lnSaldocontaPK.ctaInCodigo = :ctaInCodigo and l.lnSaldocontaPK.sacDtData = :sacDtData"),
    @NamedQuery(name = "LnSaldoconta.findByCtaInCodigo", query = "SELECT l FROM LnSaldoconta l WHERE l.lnSaldocontaPK.ctaInCodigo = :ctaInCodigo"),
    @NamedQuery(name = "LnSaldoconta.findBySacDtData", query = "SELECT l FROM LnSaldoconta l WHERE l.lnSaldocontaPK.sacDtData = :sacDtData"),
    @NamedQuery(name = "LnSaldoconta.findBySacFlDebito", query = "SELECT l FROM LnSaldoconta l WHERE l.sacFlDebito = :sacFlDebito"),
    @NamedQuery(name = "LnSaldoconta.findBySacFlCredito", query = "SELECT l FROM LnSaldoconta l WHERE l.sacFlCredito = :sacFlCredito"),
    @NamedQuery(name = "LnSaldoconta.findBySacFlSaldo", query = "SELECT l FROM LnSaldoconta l WHERE l.sacFlSaldo = :sacFlSaldo")})
public class LnSaldoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LnSaldocontaPK lnSaldocontaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sac_fl_inicio")
    private Double sacFlInicio;
    @Column(name = "sac_fl_debito")
    private Double sacFlDebito;
    @Column(name = "sac_fl_credito")
    private Double sacFlCredito;
    @Column(name = "sac_fl_saldo")
    private Double sacFlSaldo;

    public LnSaldoconta() {
    }

    public LnSaldoconta(LnSaldocontaPK lnSaldocontaPK) {
        this.lnSaldocontaPK = lnSaldocontaPK;
    }

    public LnSaldoconta(int ctaInCodigo, Date sacDtData) {
        this.lnSaldocontaPK = new LnSaldocontaPK(ctaInCodigo, sacDtData);
    }

    public LnSaldoconta(LnSaldocontaPK lnSaldocontaPK, Double sacFlInicio, Double sacFlDebito, Double sacFlCredito, Double sacFlSaldo) {
        this.lnSaldocontaPK = lnSaldocontaPK;
        this.sacFlInicio = sacFlInicio;
        this.sacFlDebito = sacFlDebito;
        this.sacFlCredito = sacFlCredito;
        this.sacFlSaldo = sacFlSaldo;
    }

    public LnSaldocontaPK getLnSaldocontaPK() {
        return lnSaldocontaPK;
    }

    public void setLnSaldocontaPK(LnSaldocontaPK lnSaldocontaPK) {
        this.lnSaldocontaPK = lnSaldocontaPK;
    }

    public Double getSacFlDebito() {
        return sacFlDebito;
    }

    public void setSacFlDebito(Double sacFlDebito) {
        this.sacFlDebito = sacFlDebito;
    }

    public Double getSacFlCredito() {
        return sacFlCredito;
    }

    public void setSacFlCredito(Double sacFlCredito) {
        this.sacFlCredito = sacFlCredito;
    }

    public Double getSacFlSaldo() {
        return sacFlSaldo;
    }

    public void setSacFlSaldo(Double sacFlSaldo) {
        this.sacFlSaldo = sacFlSaldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnSaldocontaPK != null ? lnSaldocontaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnSaldoconta)) {
            return false;
        }
        LnSaldoconta other = (LnSaldoconta) object;
        if ((this.lnSaldocontaPK == null && other.lnSaldocontaPK != null) || (this.lnSaldocontaPK != null && !this.lnSaldocontaPK.equals(other.lnSaldocontaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnSaldoconta[ lnSaldocontaPK=" + lnSaldocontaPK + " ]";
    }
    
}
