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
public class LnPerfilacessoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "per_in_codigo")
    private int perInCodigo;
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private int modInCodigo;

    public LnPerfilacessoPK() {
    }

    public LnPerfilacessoPK(int perInCodigo, int modInCodigo) {
        this.perInCodigo = perInCodigo;
        this.modInCodigo = modInCodigo;
    }

    public int getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(int perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public int getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(int modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perInCodigo;
        hash += (int) modInCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnPerfilacessoPK)) {
            return false;
        }
        LnPerfilacessoPK other = (LnPerfilacessoPK) object;
        if (this.perInCodigo != other.perInCodigo) {
            return false;
        }
        if (this.modInCodigo != other.modInCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.LnPerfilacessoPK[ perInCodigo=" + perInCodigo + ", modInCodigo=" + modInCodigo + " ]";
    }
    
}
