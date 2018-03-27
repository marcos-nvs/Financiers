/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.tipos.TipoFuncao;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnCategoria.findAll", query = "SELECT l FROM LnCategoria l order by l.catInCodigo"),
    @NamedQuery(name = "LnCategoria.findByCatInCodigo", query = "SELECT l FROM LnCategoria l WHERE l.catInCodigo = :catInCodigo"),
    @NamedQuery(name = "LnCategoria.findByCatStDescricao", query = "SELECT l FROM LnCategoria l WHERE l.catStDescricao = :catStDescricao"),
    @NamedQuery(name = "LnCategoria.findByTipInCodigo", query = "SELECT l FROM LnCategoria l WHERE l.tipInCodigo = :tipInCodigo"),
    @NamedQuery(name = "LnCategoria.findByCatChAtivo", query = "SELECT l FROM LnCategoria l WHERE l.catChAtivo = :catChAtivo order by cat_in_codigo")})
public class LnCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seqCategoria", sequenceName = "seq_categoria", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategoria")
    @Column(name = "cat_in_codigo")
    private Integer catInCodigo;
    @Column(name = "cat_st_descricao")
    private String catStDescricao;
    @Column(name = "tip_in_codigo")
    private Integer tipInCodigo;
    @Column(name = "cat_ch_ativo")
    private Character catChAtivo;
    
    @Transient
    private TipoFuncao tipoFuncao;    

    public LnCategoria() {
    }

    public LnCategoria(Integer catInCodigo) {
        this.catInCodigo = catInCodigo;
    }

    public Integer getCatInCodigo() {
        return catInCodigo;
    }

    public void setCatInCodigo(Integer catInCodigo) {
        this.catInCodigo = catInCodigo;
    }

    public String getCatStDescricao() {
        return catStDescricao;
    }

    public void setCatStDescricao(String catStDescricao) {
        this.catStDescricao = catStDescricao;
    }

    public Integer getTipInCodigo() {
        return tipInCodigo;
    }

    public void setTipInCodigo(Integer tipInCodigo) {
        this.tipInCodigo = tipInCodigo;
    }

    public Character getCatChAtivo() {
        return catChAtivo;
    }

    public void setCatChAtivo(Character catChAtivo) {
        this.catChAtivo = catChAtivo;
    }

    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catInCodigo != null ? catInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnCategoria)) {
            return false;
        }
        LnCategoria other = (LnCategoria) object;
        if ((this.catInCodigo == null && other.catInCodigo != null) || (this.catInCodigo != null && !this.catInCodigo.equals(other.catInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnCategoria[ catInCodigo=" + catInCodigo + " ]";
    }
    
}
