/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.tipos.TipoFuncao;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnAgenda.findAll", query = "SELECT l FROM LnAgenda l"),
    @NamedQuery(name = "LnAgenda.findByAgeInCodigo", query = "SELECT l FROM LnAgenda l WHERE l.ageInCodigo = :ageInCodigo"),
    @NamedQuery(name = "LnAgenda.findByActInCodigo", query = "SELECT l FROM LnAgenda l WHERE l.actInCodigo = :actInCodigo"),
    @NamedQuery(name = "LnAgenda.findByAgeDtData", query = "SELECT l FROM LnAgenda l WHERE l.ageDtData = :ageDtData"),
    @NamedQuery(name = "LnAgenda.findByAgeFlValor", query = "SELECT l FROM LnAgenda l WHERE l.ageFlValor = :ageFlValor"),
    @NamedQuery(name = "LnAgenda.findByAgeChEncerrado", query = "SELECT l FROM LnAgenda l WHERE l.ageChEncerrado = :ageChEncerrado")})
public class LnAgenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "age_in_codigo")
    private Integer ageInCodigo;
    @Basic(optional = false)
    @Column(name = "act_in_codigo")
    private int actInCodigo;
    @Basic(optional = false)
    @Column(name = "age_dt_data")
    @Temporal(TemporalType.DATE)
    private Date ageDtData;
    @Basic(optional = false)
    @Column(name = "age_fl_valor")
    private double ageFlValor;
    @Basic(optional = false)
    @Column(name = "age_ch_encerrado")
    private Character ageChEncerrado;

    @Transient
    private TipoFuncao tipoFuncao;
    
    public LnAgenda() {
    }

    public LnAgenda(Integer ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    public LnAgenda(Integer ageInCodigo, int actInCodigo, Date ageDtData, double ageFlValor, Character ageChEncerrado) {
        this.ageInCodigo = ageInCodigo;
        this.actInCodigo = actInCodigo;
        this.ageDtData = ageDtData;
        this.ageFlValor = ageFlValor;
        this.ageChEncerrado = ageChEncerrado;
    }

    public Integer getAgeInCodigo() {
        return ageInCodigo;
    }

    public void setAgeInCodigo(Integer ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    public int getActInCodigo() {
        return actInCodigo;
    }

    public void setActInCodigo(int actInCodigo) {
        this.actInCodigo = actInCodigo;
    }

    public Date getAgeDtData() {
        return ageDtData;
    }

    public void setAgeDtData(Date ageDtData) {
        this.ageDtData = ageDtData;
    }

    public double getAgeFlValor() {
        return ageFlValor;
    }

    public void setAgeFlValor(double ageFlValor) {
        this.ageFlValor = ageFlValor;
    }

    public Character getAgeChEncerrado() {
        return ageChEncerrado;
    }

    public void setAgeChEncerrado(Character ageChEncerrado) {
        this.ageChEncerrado = ageChEncerrado;
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
        if (!(object instanceof LnAgenda)) {
            return false;
        }
        LnAgenda other = (LnAgenda) object;
        if ((this.ageInCodigo == null && other.ageInCodigo != null) || (this.ageInCodigo != null && !this.ageInCodigo.equals(other.ageInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnAgenda[ ageInCodigo=" + ageInCodigo + " ]";
    }
    
}
