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
@Table(name = "ln_tipoagenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTipoagenda.findAll", query = "SELECT l FROM LnTipoagenda l"),
    @NamedQuery(name = "LnTipoagenda.findByTpaInCodigo", query = "SELECT l FROM LnTipoagenda l WHERE l.tpaInCodigo = :tpaInCodigo"),
    @NamedQuery(name = "LnTipoagenda.findByTpaStDescricao", query = "SELECT l FROM LnTipoagenda l WHERE l.tpaStDescricao = :tpaStDescricao"),
    @NamedQuery(name = "LnTipoagenda.findByTpaInQtdedias", query = "SELECT l FROM LnTipoagenda l WHERE l.tpaInQtdedias = :tpaInQtdedias")})
public class LnTipoagenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpa_in_codigo")
    private Integer tpaInCodigo;
    @Basic(optional = false)
    @Column(name = "tpa_st_descricao")
    private String tpaStDescricao;
    @Basic(optional = false)
    @Column(name = "tpa_in_qtdedias")
    private int tpaInQtdedias;

    public LnTipoagenda() {
    }

    public LnTipoagenda(Integer tpaInCodigo) {
        this.tpaInCodigo = tpaInCodigo;
    }

    public LnTipoagenda(Integer tpaInCodigo, String tpaStDescricao, int tpaInQtdedias) {
        this.tpaInCodigo = tpaInCodigo;
        this.tpaStDescricao = tpaStDescricao;
        this.tpaInQtdedias = tpaInQtdedias;
    }

    public Integer getTpaInCodigo() {
        return tpaInCodigo;
    }

    public void setTpaInCodigo(Integer tpaInCodigo) {
        this.tpaInCodigo = tpaInCodigo;
    }

    public String getTpaStDescricao() {
        return tpaStDescricao;
    }

    public void setTpaStDescricao(String tpaStDescricao) {
        this.tpaStDescricao = tpaStDescricao;
    }

    public int getTpaInQtdedias() {
        return tpaInQtdedias;
    }

    public void setTpaInQtdedias(int tpaInQtdedias) {
        this.tpaInQtdedias = tpaInQtdedias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpaInCodigo != null ? tpaInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTipoagenda)) {
            return false;
        }
        LnTipoagenda other = (LnTipoagenda) object;
        if ((this.tpaInCodigo == null && other.tpaInCodigo != null) || (this.tpaInCodigo != null && !this.tpaInCodigo.equals(other.tpaInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTipoagenda[ tpaInCodigo=" + tpaInCodigo + " ]";
    }
    
}
