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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_agendaalerta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnAgendaalerta.findAll", query = "SELECT l FROM LnAgendaalerta l"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeInCodigo", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageInCodigo = :ageInCodigo"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeDtCriacao", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageDtCriacao = :ageDtCriacao"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeDtAviso", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageDtAviso = :ageDtAviso"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeChAlertar", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageChAlertar = :ageChAlertar"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeChEmail", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageChEmail = :ageChEmail"),
    @NamedQuery(name = "LnAgendaalerta.findByAgeStEmail", query = "SELECT l FROM LnAgendaalerta l WHERE l.ageStEmail = :ageStEmail")})
public class LnAgendaalerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "age_in_codigo")
    private Integer ageInCodigo;
    @Column(name = "age_dt_criacao")
    @Temporal(TemporalType.DATE)
    private Date ageDtCriacao;
    @Column(name = "age_dt_aviso")
    @Temporal(TemporalType.DATE)
    private Date ageDtAviso;
    @Column(name = "age_ch_alertar")
    private Character ageChAlertar;
    @Column(name = "age_ch_email")
    private Character ageChEmail;
    @Size(max = 50)
    @Column(name = "age_st_email")
    private String ageStEmail;

    public LnAgendaalerta() {
    }

    public LnAgendaalerta(Integer ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    public Integer getAgeInCodigo() {
        return ageInCodigo;
    }

    public void setAgeInCodigo(Integer ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    public Date getAgeDtCriacao() {
        return ageDtCriacao;
    }

    public void setAgeDtCriacao(Date ageDtCriacao) {
        this.ageDtCriacao = ageDtCriacao;
    }

    public Date getAgeDtAviso() {
        return ageDtAviso;
    }

    public void setAgeDtAviso(Date ageDtAviso) {
        this.ageDtAviso = ageDtAviso;
    }

    public Character getAgeChAlertar() {
        return ageChAlertar;
    }

    public void setAgeChAlertar(Character ageChAlertar) {
        this.ageChAlertar = ageChAlertar;
    }

    public Character getAgeChEmail() {
        return ageChEmail;
    }

    public void setAgeChEmail(Character ageChEmail) {
        this.ageChEmail = ageChEmail;
    }

    public String getAgeStEmail() {
        return ageStEmail;
    }

    public void setAgeStEmail(String ageStEmail) {
        this.ageStEmail = ageStEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ageInCodigo != null ? ageInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnAgendaalerta)) {
            return false;
        }
        LnAgendaalerta other = (LnAgendaalerta) object;
        if ((this.ageInCodigo == null && other.ageInCodigo != null) || (this.ageInCodigo != null && !this.ageInCodigo.equals(other.ageInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnAgendaalerta[ ageInCodigo=" + ageInCodigo + " ]";
    }
    
}
