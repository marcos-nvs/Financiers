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
import javax.validation.constraints.NotNull;

/**
 *
 * @author f12684146896
 */
@Embeddable
public class LnMenumoduloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_in_codigo")
    private int menInCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mod_in_codigo")
    private int modInCodigo;

    public LnMenumoduloPK() {
    }

    public LnMenumoduloPK(int menInCodigo, int modInCodigo) {
        this.menInCodigo = menInCodigo;
        this.modInCodigo = modInCodigo;
    }

    public int getMenInCodigo() {
        return menInCodigo;
    }

    public void setMenInCodigo(int menInCodigo) {
        this.menInCodigo = menInCodigo;
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
        hash += (int) menInCodigo;
        hash += (int) modInCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnMenumoduloPK)) {
            return false;
        }
        LnMenumoduloPK other = (LnMenumoduloPK) object;
        if (this.menInCodigo != other.menInCodigo) {
            return false;
        }
        if (this.modInCodigo != other.modInCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnMenumoduloPK[ menInCodigo=" + menInCodigo + ", modInCodigo=" + modInCodigo + " ]";
    }
    
}
