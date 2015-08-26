/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.tipos.TipoFuncao;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_contadependente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnContadependente.findAll", query = "SELECT l FROM LnContadependente l"),
    @NamedQuery(name = "LnContadependente.findByCtaInCodigo", query = "SELECT l FROM LnContadependente l WHERE l.lnContadependentePK.ctaInCodigo = :ctaInCodigo"),
    @NamedQuery(name = "LnContadependente.findByCtaInCalculada", query = "SELECT l FROM LnContadependente l WHERE l.lnContadependentePK.ctaInCalculada = :ctaInCalculada"),
    @NamedQuery(name = "LnContadependente.findByTbtInCodigo", query = "SELECT l FROM LnContadependente l WHERE l.tbtInCodigo = :tbtInCodigo"),
    @NamedQuery(name = "LnContadependente.findByCtdInOrdem", query = "SELECT l FROM LnContadependente l WHERE l.ctdInOrdem = :ctdInOrdem")})
public class LnContadependente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LnContadependentePK lnContadependentePK;
    @Basic(optional = false)
    @Column(name = "tbt_in_codigo")
    private int tbtInCodigo;
    @Basic(optional = false)
    @Column(name = "ctd_in_ordem")
    private int ctdInOrdem;

    @Transient
    private TipoFuncao tipoFuncao;

    public LnContadependente() {
    }

    public LnContadependente(LnContadependentePK lnContadependentePK) {
        this.lnContadependentePK = lnContadependentePK;
    }

    public LnContadependente(LnContadependentePK lnContadependentePK, int tbtInCodigo, int ctdInOrdem) {
        this.lnContadependentePK = lnContadependentePK;
        this.tbtInCodigo = tbtInCodigo;
        this.ctdInOrdem = ctdInOrdem;
    }

    public LnContadependente(int ctaInCodigo, int ctaInCalculada) {
        this.lnContadependentePK = new LnContadependentePK(ctaInCodigo, ctaInCalculada);
    }

    public LnContadependentePK getLnContadependentePK() {
        return lnContadependentePK;
    }

    public void setLnContadependentePK(LnContadependentePK lnContadependentePK) {
        this.lnContadependentePK = lnContadependentePK;
    }

    public int getTbtInCodigo() {
        return tbtInCodigo;
    }

    public void setTbtInCodigo(int tbtInCodigo) {
        this.tbtInCodigo = tbtInCodigo;
    }

    public int getCtdInOrdem() {
        return ctdInOrdem;
    }

    public void setCtdInOrdem(int ctdInOrdem) {
        this.ctdInOrdem = ctdInOrdem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnContadependentePK != null ? lnContadependentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnContadependente)) {
            return false;
        }
        LnContadependente other = (LnContadependente) object;
        if ((this.lnContadependentePK == null && other.lnContadependentePK != null) || (this.lnContadependentePK != null && !this.lnContadependentePK.equals(other.lnContadependentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnContadependente[ lnContadependentePK=" + lnContadependentePK + " ]";
    }
    
}
