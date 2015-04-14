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
 * @author m-nvs_000
 */
@Embeddable
public class LnUsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "usu_st_cpf")
    private String usuStCpf;
    @Basic(optional = false)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;

    public LnUsuarioPK() {
    }

    public LnUsuarioPK(String usuStCpf, String usuStCodigo) {
        this.usuStCpf = usuStCpf;
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStCpf() {
        return usuStCpf;
    }

    public void setUsuStCpf(String usuStCpf) {
        this.usuStCpf = usuStCpf;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuStCpf != null ? usuStCpf.hashCode() : 0);
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnUsuarioPK)) {
            return false;
        }
        LnUsuarioPK other = (LnUsuarioPK) object;
        if ((this.usuStCpf == null && other.usuStCpf != null) || (this.usuStCpf != null && !this.usuStCpf.equals(other.usuStCpf))) {
            return false;
        }
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.LnUsuarioPK[ usuStCpf=" + usuStCpf + ", usuStCodigo=" + usuStCodigo + " ]";
    }
    
}
