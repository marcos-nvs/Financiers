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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_tipotabela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTipotabela.findAll", query = "SELECT l FROM LnTipotabela l"),
    @NamedQuery(name = "LnTipotabela.findByTtbInCodigo", query = "SELECT l FROM LnTipotabela l WHERE l.ttbInCodigo = :ttbInCodigo"),
    @NamedQuery(name = "LnTipotabela.findByTtbStDescricao", query = "SELECT l FROM LnTipotabela l WHERE l.ttbStDescricao = :ttbStDescricao")})
public class LnTipotabela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ttb_in_codigo")
    private Integer ttbInCodigo;
    @Basic(optional = false)
    @Column(name = "ttb_st_descricao")
    private String ttbStDescricao;

    public LnTipotabela() {
    }

    public LnTipotabela(Integer ttbInCodigo) {
        this.ttbInCodigo = ttbInCodigo;
    }

    public LnTipotabela(Integer ttbInCodigo, String ttbStDescricao) {
        this.ttbInCodigo = ttbInCodigo;
        this.ttbStDescricao = ttbStDescricao;
    }

    public Integer getTtbInCodigo() {
        return ttbInCodigo;
    }

    public void setTtbInCodigo(Integer ttbInCodigo) {
        this.ttbInCodigo = ttbInCodigo;
    }

    public String getTtbStDescricao() {
        return ttbStDescricao;
    }

    public void setTtbStDescricao(String ttbStDescricao) {
        this.ttbStDescricao = ttbStDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttbInCodigo != null ? ttbInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTipotabela)) {
            return false;
        }
        LnTipotabela other = (LnTipotabela) object;
        if ((this.ttbInCodigo == null && other.ttbInCodigo != null) || (this.ttbInCodigo != null && !this.ttbInCodigo.equals(other.ttbInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTipotabela[ ttbInCodigo=" + ttbInCodigo + " ]";
    }
    
}
