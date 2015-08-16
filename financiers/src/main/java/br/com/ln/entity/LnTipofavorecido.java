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
@Table(name = "ln_tipofavorecido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTipofavorecido.findAll", query = "SELECT l FROM LnTipofavorecido l"),
    @NamedQuery(name = "LnTipofavorecido.findByTfaInCodigo", query = "SELECT l FROM LnTipofavorecido l WHERE l.tfaInCodigo = :tfaInCodigo"),
    @NamedQuery(name = "LnTipofavorecido.findByTfaStDescricao", query = "SELECT l FROM LnTipofavorecido l WHERE l.tfaStDescricao = :tfaStDescricao"),
    @NamedQuery(name = "LnTipofavorecido.findByTfaChAtivo", query = "SELECT l FROM LnTipofavorecido l WHERE l.tfaChAtivo = :tfaChAtivo")})
public class LnTipofavorecido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tfa_in_codigo")
    private Integer tfaInCodigo;
    @Basic(optional = false)
    @Column(name = "tfa_st_descricao")
    private String tfaStDescricao;
    @Basic(optional = false)
    @Column(name = "tfa_ch_ativo")
    private Character tfaChAtivo;

    public LnTipofavorecido() {
    }

    public LnTipofavorecido(Integer tfaInCodigo) {
        this.tfaInCodigo = tfaInCodigo;
    }

    public LnTipofavorecido(Integer tfaInCodigo, String tfaStDescricao, Character tfaChAtivo) {
        this.tfaInCodigo = tfaInCodigo;
        this.tfaStDescricao = tfaStDescricao;
        this.tfaChAtivo = tfaChAtivo;
    }

    public Integer getTfaInCodigo() {
        return tfaInCodigo;
    }

    public void setTfaInCodigo(Integer tfaInCodigo) {
        this.tfaInCodigo = tfaInCodigo;
    }

    public String getTfaStDescricao() {
        return tfaStDescricao;
    }

    public void setTfaStDescricao(String tfaStDescricao) {
        this.tfaStDescricao = tfaStDescricao;
    }

    public Character getTfaChAtivo() {
        return tfaChAtivo;
    }

    public void setTfaChAtivo(Character tfaChAtivo) {
        this.tfaChAtivo = tfaChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tfaInCodigo != null ? tfaInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTipofavorecido)) {
            return false;
        }
        LnTipofavorecido other = (LnTipofavorecido) object;
        if ((this.tfaInCodigo == null && other.tfaInCodigo != null) || (this.tfaInCodigo != null && !this.tfaInCodigo.equals(other.tfaInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTipofavorecido[ tfaInCodigo=" + tfaInCodigo + " ]";
    }
    
}
