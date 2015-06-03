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
@Table(name = "ln_tipoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTipoconta.findAll", query = "SELECT l FROM LnTipoconta l"),
    @NamedQuery(name = "LnTipoconta.findByTipInCodigo", query = "SELECT l FROM LnTipoconta l WHERE l.tipInCodigo = :tipInCodigo"),
    @NamedQuery(name = "LnTipoconta.findByTipStDescricao", query = "SELECT l FROM LnTipoconta l WHERE l.tipStDescricao = :tipStDescricao"),
    @NamedQuery(name = "LnTipoconta.findByTipStTipo", query = "SELECT l FROM LnTipoconta l WHERE l.tipStTipo = :tipStTipo")})
public class LnTipoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tip_in_codigo")
    private Integer tipInCodigo;
    @Basic(optional = false)
    @Column(name = "tip_st_descricao")
    private String tipStDescricao;
    @Basic(optional = false)
    @Column(name = "tip_st_tipo")
    private Character tipStTipo;

    public LnTipoconta() {
    }

    public LnTipoconta(Integer tipInCodigo) {
        this.tipInCodigo = tipInCodigo;
    }

    public LnTipoconta(Integer tipInCodigo, String tipStDescricao, Character tipStTipo) {
        this.tipInCodigo = tipInCodigo;
        this.tipStDescricao = tipStDescricao;
        this.tipStTipo = tipStTipo;
    }

    public Integer getTipInCodigo() {
        return tipInCodigo;
    }

    public void setTipInCodigo(Integer tipInCodigo) {
        this.tipInCodigo = tipInCodigo;
    }

    public String getTipStDescricao() {
        return tipStDescricao;
    }

    public void setTipStDescricao(String tipStDescricao) {
        this.tipStDescricao = tipStDescricao;
    }

    public Character getTipStTipo() {
        return tipStTipo;
    }

    public void setTipStTipo(Character tipStTipo) {
        this.tipStTipo = tipStTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipInCodigo != null ? tipInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTipoconta)) {
            return false;
        }
        LnTipoconta other = (LnTipoconta) object;
        if ((this.tipInCodigo == null && other.tipInCodigo != null) || (this.tipInCodigo != null && !this.tipInCodigo.equals(other.tipInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTipoconta[ tipInCodigo=" + tipInCodigo + " ]";
    }
    
}
