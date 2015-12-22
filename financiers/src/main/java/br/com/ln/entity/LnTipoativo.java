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
@Table(name = "ln_tipoativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTipoativo.findAll", query = "SELECT l FROM LnTipoativo l"),
    @NamedQuery(name = "LnTipoativo.findByTiaInCodigo", query = "SELECT l FROM LnTipoativo l WHERE l.tiaInCodigo = :tiaInCodigo"),
    @NamedQuery(name = "LnTipoativo.findByTiaStDescricao", query = "SELECT l FROM LnTipoativo l WHERE l.tiaStDescricao = :tiaStDescricao"),
    @NamedQuery(name = "LnTipoativo.findByTiaChAtivo", query = "SELECT l FROM LnTipoativo l WHERE l.tiaChAtivo = :tiaChAtivo")})
public class LnTipoativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tia_in_codigo")
    private Integer tiaInCodigo;
    @Basic(optional = false)
    @Column(name = "tia_st_descricao")
    private String tiaStDescricao;
    @Basic(optional = false)
    @Column(name = "tia_ch_ativo")
    private Character tiaChAtivo;

    public LnTipoativo() {
    }

    public LnTipoativo(Integer tiaInCodigo) {
        this.tiaInCodigo = tiaInCodigo;
    }

    public LnTipoativo(Integer tiaInCodigo, String tiaStDescricao, Character tiaChAtivo) {
        this.tiaInCodigo = tiaInCodigo;
        this.tiaStDescricao = tiaStDescricao;
        this.tiaChAtivo = tiaChAtivo;
    }

    public Integer getTiaInCodigo() {
        return tiaInCodigo;
    }

    public void setTiaInCodigo(Integer tiaInCodigo) {
        this.tiaInCodigo = tiaInCodigo;
    }

    public String getTiaStDescricao() {
        return tiaStDescricao;
    }

    public void setTiaStDescricao(String tiaStDescricao) {
        this.tiaStDescricao = tiaStDescricao;
    }

    public Character getTiaChAtivo() {
        return tiaChAtivo;
    }

    public void setTiaChAtivo(Character tiaChAtivo) {
        this.tiaChAtivo = tiaChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiaInCodigo != null ? tiaInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTipoativo)) {
            return false;
        }
        LnTipoativo other = (LnTipoativo) object;
        if ((this.tiaInCodigo == null && other.tiaInCodigo != null) || (this.tiaInCodigo != null && !this.tiaInCodigo.equals(other.tiaInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTipoativo[ tiaInCodigo=" + tiaInCodigo + " ]";
    }
    
}
