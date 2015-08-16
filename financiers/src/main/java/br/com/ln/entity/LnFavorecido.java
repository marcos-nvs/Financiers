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
@Table(name = "ln_favorecido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnFavorecido.findAll", query = "SELECT l FROM LnFavorecido l"),
    @NamedQuery(name = "LnFavorecido.findByFavInCodigo", query = "SELECT l FROM LnFavorecido l WHERE l.favInCodigo = :favInCodigo"),
    @NamedQuery(name = "LnFavorecido.findByFavStDescricao", query = "SELECT l FROM LnFavorecido l WHERE l.favStDescricao = :favStDescricao"),
    @NamedQuery(name = "LnFavorecido.findByFavChAtivo", query = "SELECT l FROM LnFavorecido l WHERE l.favChAtivo = :favChAtivo"),
    @NamedQuery(name = "LnFavorecido.findByFavStDocumento", query = "SELECT l FROM LnFavorecido l WHERE l.favStDocumento = :favStDocumento"),
    @NamedQuery(name = "LnFavorecido.findByTfaInCodigo", query = "SELECT l FROM LnFavorecido l WHERE l.tfaInCodigo = :tfaInCodigo")})
public class LnFavorecido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fav_in_codigo")
    private Integer favInCodigo;
    @Basic(optional = false)
    @Column(name = "fav_st_descricao")
    private String favStDescricao;
    @Basic(optional = false)
    @Column(name = "fav_ch_ativo")
    private Character favChAtivo;
    @Column(name = "fav_st_documento")
    private String favStDocumento;
    @Basic(optional = false)
    @Column(name = "tfa_in_codigo")
    private int tfaInCodigo;

    public LnFavorecido() {
    }

    public LnFavorecido(Integer favInCodigo) {
        this.favInCodigo = favInCodigo;
    }

    public LnFavorecido(Integer favInCodigo, String favStDescricao, Character favChAtivo, int tfaInCodigo) {
        this.favInCodigo = favInCodigo;
        this.favStDescricao = favStDescricao;
        this.favChAtivo = favChAtivo;
        this.tfaInCodigo = tfaInCodigo;
    }

    public Integer getFavInCodigo() {
        return favInCodigo;
    }

    public void setFavInCodigo(Integer favInCodigo) {
        this.favInCodigo = favInCodigo;
    }

    public String getFavStDescricao() {
        return favStDescricao;
    }

    public void setFavStDescricao(String favStDescricao) {
        this.favStDescricao = favStDescricao;
    }

    public Character getFavChAtivo() {
        return favChAtivo;
    }

    public void setFavChAtivo(Character favChAtivo) {
        this.favChAtivo = favChAtivo;
    }

    public String getFavStDocumento() {
        return favStDocumento;
    }

    public void setFavStDocumento(String favStDocumento) {
        this.favStDocumento = favStDocumento;
    }

    public int getTfaInCodigo() {
        return tfaInCodigo;
    }

    public void setTfaInCodigo(int tfaInCodigo) {
        this.tfaInCodigo = tfaInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favInCodigo != null ? favInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnFavorecido)) {
            return false;
        }
        LnFavorecido other = (LnFavorecido) object;
        if ((this.favInCodigo == null && other.favInCodigo != null) || (this.favInCodigo != null && !this.favInCodigo.equals(other.favInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnFavorecido[ favInCodigo=" + favInCodigo + " ]";
    }
    
}
