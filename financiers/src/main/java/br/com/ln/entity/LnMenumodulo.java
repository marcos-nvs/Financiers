/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author f12684146896
 */
@Entity
@Table(name = "ln_menumodulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnMenumodulo.findAll", query = "SELECT l FROM LnMenumodulo l"),
    @NamedQuery(name = "LnMenumodulo.findByMenInCodigo", query = "SELECT l FROM LnMenumodulo l WHERE l.lnMenumoduloPK.menInCodigo = :menInCodigo"),
    @NamedQuery(name = "LnMenumodulo.findByModInCodigo", query = "SELECT l FROM LnMenumodulo l WHERE l.lnMenumoduloPK.modInCodigo = :modInCodigo")})
public class LnMenumodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LnMenumoduloPK lnMenumoduloPK;

    public LnMenumodulo() {
    }

    public LnMenumodulo(LnMenumoduloPK lnMenumoduloPK) {
        this.lnMenumoduloPK = lnMenumoduloPK;
    }

    public LnMenumodulo(int menInCodigo, int modInCodigo) {
        this.lnMenumoduloPK = new LnMenumoduloPK(menInCodigo, modInCodigo);
    }

    public LnMenumoduloPK getLnMenumoduloPK() {
        return lnMenumoduloPK;
    }

    public void setLnMenumoduloPK(LnMenumoduloPK lnMenumoduloPK) {
        this.lnMenumoduloPK = lnMenumoduloPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnMenumoduloPK != null ? lnMenumoduloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnMenumodulo)) {
            return false;
        }
        LnMenumodulo other = (LnMenumodulo) object;
        if ((this.lnMenumoduloPK == null && other.lnMenumoduloPK != null) || (this.lnMenumoduloPK != null && !this.lnMenumoduloPK.equals(other.lnMenumoduloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnMenumodulo[ lnMenumoduloPK=" + lnMenumoduloPK + " ]";
    }
    
}
