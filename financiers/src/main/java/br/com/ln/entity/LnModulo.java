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
 * @author f12684146896
 */
@Entity
@Table(name = "ln_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnModulo.findAll", query = "SELECT l FROM LnModulo l"),
    @NamedQuery(name = "LnModulo.findAllAtivo", query = "SELECT l FROM LnModulo l WHERE l.modChAtivo = :modChAtivo"),
    @NamedQuery(name = "LnModulo.findByModInCodigo", query = "SELECT l FROM LnModulo l WHERE l.modInCodigo = :modInCodigo"),
    @NamedQuery(name = "LnModulo.findByModStDescricao", query = "SELECT l FROM LnModulo l WHERE l.modStDescricao = :modStDescricao"),
    @NamedQuery(name = "LnModulo.findByModChIncluir", query = "SELECT l FROM LnModulo l WHERE l.modChIncluir = :modChIncluir"),
    @NamedQuery(name = "LnModulo.findByModChAlterar", query = "SELECT l FROM LnModulo l WHERE l.modChAlterar = :modChAlterar"),
    @NamedQuery(name = "LnModulo.findByModChExcluir", query = "SELECT l FROM LnModulo l WHERE l.modChExcluir = :modChExcluir"),
    @NamedQuery(name = "LnModulo.findByModChPesquisar", query = "SELECT l FROM LnModulo l WHERE l.modChPesquisar = :modChPesquisar"),
    @NamedQuery(name = "LnModulo.findByModChAtivo", query = "SELECT l FROM LnModulo l WHERE l.modChAtivo = :modChAtivo")})
public class LnModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private Integer modInCodigo;
    @Basic(optional = false)
    @Column(name = "mod_st_descricao")
    private String modStDescricao;
    @Basic(optional = false)
    @Column(name = "mod_ch_incluir")
    private Character modChIncluir;
    @Basic(optional = false)
    @Column(name = "mod_ch_alterar")
    private Character modChAlterar;
    @Basic(optional = false)
    @Column(name = "mod_ch_excluir")
    private Character modChExcluir;
    @Basic(optional = false)
    @Column(name = "mod_ch_pesquisar")
    private Character modChPesquisar;
    @Basic(optional = false)
    @Column(name = "mod_ch_ativo")
    private Character modChAtivo;

    public LnModulo() {
    }

    public LnModulo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public LnModulo(Integer modInCodigo, String modStDescricao, Character modChIncluir, Character modChAlterar, Character modChExcluir, Character modChPesquisar, Character modChAtivo) {
        this.modInCodigo = modInCodigo;
        this.modStDescricao = modStDescricao;
        this.modChIncluir = modChIncluir;
        this.modChAlterar = modChAlterar;
        this.modChExcluir = modChExcluir;
        this.modChPesquisar = modChPesquisar;
        this.modChAtivo = modChAtivo;
    }

    public Integer getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public String getModStDescricao() {
        return modStDescricao;
    }

    public void setModStDescricao(String modStDescricao) {
        this.modStDescricao = modStDescricao;
    }

    public Character getModChIncluir() {
        return modChIncluir;
    }

    public void setModChIncluir(Character modChIncluir) {
        this.modChIncluir = modChIncluir;
    }

    public Character getModChAlterar() {
        return modChAlterar;
    }

    public void setModChAlterar(Character modChAlterar) {
        this.modChAlterar = modChAlterar;
    }

    public Character getModChExcluir() {
        return modChExcluir;
    }

    public void setModChExcluir(Character modChExcluir) {
        this.modChExcluir = modChExcluir;
    }

    public Character getModChPesquisar() {
        return modChPesquisar;
    }

    public void setModChPesquisar(Character modChPesquisar) {
        this.modChPesquisar = modChPesquisar;
    }

    public Character getModChAtivo() {
        return modChAtivo;
    }

    public void setModChAtivo(Character modChAtivo) {
        this.modChAtivo = modChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modInCodigo != null ? modInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnModulo)) {
            return false;
        }
        LnModulo other = (LnModulo) object;
        if ((this.modInCodigo == null && other.modInCodigo != null) || (this.modInCodigo != null && !this.modInCodigo.equals(other.modInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.LnModulo[ modInCodigo=" + modInCodigo + " ]";
    }
    
}
