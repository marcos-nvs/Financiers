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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnHistorico.findAll", query = "SELECT l FROM LnHistorico l"),
    @NamedQuery(name = "LnHistorico.findByHisInCodigo", query = "SELECT l FROM LnHistorico l WHERE l.hisInCodigo = :hisInCodigo"),
    @NamedQuery(name = "LnHistorico.findByModInCodigo", query = "SELECT l FROM LnHistorico l WHERE l.modInCodigo = :modInCodigo"),
    @NamedQuery(name = "LnHistorico.findByHisDtData", query = "SELECT l FROM LnHistorico l WHERE l.hisDtData = :hisDtData"),
    @NamedQuery(name = "LnHistorico.findByUsuStCodigo", query = "SELECT l FROM LnHistorico l WHERE l.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "LnHistorico.findByHisStDescricao", query = "SELECT l FROM LnHistorico l WHERE l.hisStDescricao = :hisStDescricao")})
public class LnHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "his_in_codigo")
    private Integer hisInCodigo;
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private int modInCodigo;
    @Basic(optional = false)
    @Column(name = "his_dt_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hisDtData;
    @Basic(optional = false)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;
    @Column(name = "his_st_descricao")
    private String hisStDescricao;

    public LnHistorico() {
    }

    public LnHistorico(Integer hisInCodigo) {
        this.hisInCodigo = hisInCodigo;
    }

    public LnHistorico(Integer hisInCodigo, int modInCodigo, Date hisDtData, String usuStCodigo) {
        this.hisInCodigo = hisInCodigo;
        this.modInCodigo = modInCodigo;
        this.hisDtData = hisDtData;
        this.usuStCodigo = usuStCodigo;
    }

    public LnHistorico(Integer hisInCodigo, int modInCodigo, Date hisDtData, String usuStCodigo, String hisStDescricao) {
        this.hisInCodigo = hisInCodigo;
        this.modInCodigo = modInCodigo;
        this.hisDtData = hisDtData;
        this.usuStCodigo = usuStCodigo;
        this.hisStDescricao = hisStDescricao;
    }

    public LnHistorico(Integer hisInCodigo, Date hisDtData, String usuStCodigo, String hisStDescricao) {
        this.hisInCodigo = hisInCodigo;
        this.hisDtData = hisDtData;
        this.usuStCodigo = usuStCodigo;
        this.hisStDescricao = hisStDescricao;
    }

    public Integer getHisInCodigo() {
        return hisInCodigo;
    }

    public void setHisInCodigo(Integer hisInCodigo) {
        this.hisInCodigo = hisInCodigo;
    }

    public int getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(int modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public Date getHisDtData() {
        return hisDtData;
    }

    public void setHisDtData(Date hisDtData) {
        this.hisDtData = hisDtData;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getHisStDescricao() {
        return hisStDescricao;
    }

    public void setHisStDescricao(String hisStDescricao) {
        this.hisStDescricao = hisStDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisInCodigo != null ? hisInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnHistorico)) {
            return false;
        }
        LnHistorico other = (LnHistorico) object;
        if ((this.hisInCodigo == null && other.hisInCodigo != null) || (this.hisInCodigo != null && !this.hisInCodigo.equals(other.hisInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnHistorico{" + "hisInCodigo=" + hisInCodigo + ", modInCodigo=" + modInCodigo + ", hisDtData=" + hisDtData + ", usuStCodigo=" + usuStCodigo + ", hisStDescricao=" + hisStDescricao + '}';
    }

    
}
