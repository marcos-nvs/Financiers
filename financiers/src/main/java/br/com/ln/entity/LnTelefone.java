/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author f12684146896
 */
@Entity
@Table(name = "ln_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTelefone.findAll", query = "SELECT l FROM LnTelefone l"),
    @NamedQuery(name = "LnTelefone.findByTelInCodigo", query = "SELECT l FROM LnTelefone l WHERE l.telInCodigo = :telInCodigo"),
    @NamedQuery(name = "LnTelefone.findByCliInCodigo", query = "SELECT l FROM LnTelefone l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnTelefone.findByTelStTipo", query = "SELECT l FROM LnTelefone l WHERE l.telStTipo = :telStTipo"),
    @NamedQuery(name = "LnTelefone.findByTelStDdd", query = "SELECT l FROM LnTelefone l WHERE l.telStDdd = :telStDdd"),
    @NamedQuery(name = "LnTelefone.findByTelStTelefone", query = "SELECT l FROM LnTelefone l WHERE l.telStTelefone = :telStTelefone")})
public class LnTelefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel_in_codigo")
    private Integer telInCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_in_codigo")
    private int cliInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tel_st_tipo")
    private String telStTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tel_st_ddd")
    private String telStDdd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tel_st_telefone")
    private String telStTelefone;

    public LnTelefone() {
    }

    public LnTelefone(Integer telInCodigo) {
        this.telInCodigo = telInCodigo;
    }

    public LnTelefone(Integer telInCodigo, int cliInCodigo, String telStTipo, String telStDdd, String telStTelefone) {
        this.telInCodigo = telInCodigo;
        this.cliInCodigo = cliInCodigo;
        this.telStTipo = telStTipo;
        this.telStDdd = telStDdd;
        this.telStTelefone = telStTelefone;
    }

    public Integer getTelInCodigo() {
        return telInCodigo;
    }

    public void setTelInCodigo(Integer telInCodigo) {
        this.telInCodigo = telInCodigo;
    }

    public int getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(int cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public String getTelStTipo() {
        return telStTipo;
    }

    public void setTelStTipo(String telStTipo) {
        this.telStTipo = telStTipo;
    }

    public String getTelStDdd() {
        return telStDdd;
    }

    public void setTelStDdd(String telStDdd) {
        this.telStDdd = telStDdd;
    }

    public String getTelStTelefone() {
        return telStTelefone;
    }

    public void setTelStTelefone(String telStTelefone) {
        this.telStTelefone = telStTelefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telInCodigo != null ? telInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTelefone)) {
            return false;
        }
        LnTelefone other = (LnTelefone) object;
        if ((this.telInCodigo == null && other.telInCodigo != null) || (this.telInCodigo != null && !this.telInCodigo.equals(other.telInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTelefone[ telInCodigo=" + telInCodigo + " ]";
    }
    
}
