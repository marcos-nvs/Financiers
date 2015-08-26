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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_planoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnPlanoconta.findAll", query = "SELECT l FROM LnPlanoconta l"),
    @NamedQuery(name = "LnPlanoconta.findByCtaInCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaInCodigo = :ctaInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaStDescricao", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaStDescricao = :ctaStDescricao"),
    @NamedQuery(name = "LnPlanoconta.findByCatInCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.catInCodigo = :catInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByTipInCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.tipInCodigo = :tipInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaChAtivo", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChAtivo = :ctaChAtivo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaChImposto", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChImposto = :ctaChImposto"),
    @NamedQuery(name = "LnPlanoconta.findByCtaChCalculada", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChCalculada = :ctaChCalculada"),
    @NamedQuery(name = "LnPlanoconta.findByCtaFlPercentual", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaFlPercentual = :ctaFlPercentual"),
    @NamedQuery(name = "LnPlanoconta.findByCtaFlLimite", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaFlLimite = :ctaFlLimite"),
    @NamedQuery(name = "LnPlanoconta.findByCtaChAgenda", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChAgenda = :ctaChAgenda")})
public class LnPlanoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cta_in_codigo")
    private Integer ctaInCodigo;
    @Basic(optional = false)
    @Column(name = "cta_st_descricao")
    private String ctaStDescricao;
    @Basic(optional = false)
    @Column(name = "cat_in_codigo")
    private int catInCodigo;
    @Basic(optional = false)
    @Column(name = "tip_in_codigo")
    private int tipInCodigo;
    @Basic(optional = false)
    @Column(name = "cta_ch_ativo")
    private Character ctaChAtivo;
    @Basic(optional = false)
    @Column(name = "cta_ch_imposto")
    private Character ctaChImposto;
    @Basic(optional = false)
    @Column(name = "cta_ch_calculada")
    private Character ctaChCalculada;
    @Basic(optional = false)
    @Column(name = "cta_fl_percentual")
    private double ctaFlPercentual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cta_fl_limite")
    private Double ctaFlLimite;
    @Basic(optional = false)
    @Column(name = "cta_ch_agenda")
    private Character ctaChAgenda;

    @Transient
    private TipoFuncao tipoFuncao;
    
    public LnPlanoconta() {
    }

    public LnPlanoconta(Integer ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public LnPlanoconta(Integer ctaInCodigo, String ctaStDescricao, int catInCodigo, int tipInCodigo, Character ctaChAtivo, Character ctaChImposto, Character ctaChCalculada, double ctaFlPercentual, Character ctaChAgenda) {
        this.ctaInCodigo = ctaInCodigo;
        this.ctaStDescricao = ctaStDescricao;
        this.catInCodigo = catInCodigo;
        this.tipInCodigo = tipInCodigo;
        this.ctaChAtivo = ctaChAtivo;
        this.ctaChImposto = ctaChImposto;
        this.ctaChCalculada = ctaChCalculada;
        this.ctaFlPercentual = ctaFlPercentual;
        this.ctaChAgenda = ctaChAgenda;
    }

    public Integer getCtaInCodigo() {
        return ctaInCodigo;
    }

    public void setCtaInCodigo(Integer ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public String getCtaStDescricao() {
        return ctaStDescricao;
    }

    public void setCtaStDescricao(String ctaStDescricao) {
        this.ctaStDescricao = ctaStDescricao;
    }

    public int getCatInCodigo() {
        return catInCodigo;
    }

    public void setCatInCodigo(int catInCodigo) {
        this.catInCodigo = catInCodigo;
    }

    public int getTipInCodigo() {
        return tipInCodigo;
    }

    public void setTipInCodigo(int tipInCodigo) {
        this.tipInCodigo = tipInCodigo;
    }

    public Character getCtaChAtivo() {
        return ctaChAtivo;
    }

    public void setCtaChAtivo(Character ctaChAtivo) {
        this.ctaChAtivo = ctaChAtivo;
    }

    public Character getCtaChImposto() {
        return ctaChImposto;
    }

    public void setCtaChImposto(Character ctaChImposto) {
        this.ctaChImposto = ctaChImposto;
    }

    public Character getCtaChCalculada() {
        return ctaChCalculada;
    }

    public void setCtaChCalculada(Character ctaChCalculada) {
        this.ctaChCalculada = ctaChCalculada;
    }

    public double getCtaFlPercentual() {
        return ctaFlPercentual;
    }

    public void setCtaFlPercentual(double ctaFlPercentual) {
        this.ctaFlPercentual = ctaFlPercentual;
    }

    public Double getCtaFlLimite() {
        return ctaFlLimite;
    }

    public void setCtaFlLimite(Double ctaFlLimite) {
        this.ctaFlLimite = ctaFlLimite;
    }

    public Character getCtaChAgenda() {
        return ctaChAgenda;
    }

    public void setCtaChAgenda(Character ctaChAgenda) {
        this.ctaChAgenda = ctaChAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaInCodigo != null ? ctaInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnPlanoconta)) {
            return false;
        }
        LnPlanoconta other = (LnPlanoconta) object;
        if ((this.ctaInCodigo == null && other.ctaInCodigo != null) || (this.ctaInCodigo != null && !this.ctaInCodigo.equals(other.ctaInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnPlanoconta[ ctaInCodigo=" + ctaInCodigo + " ]";
    }
    
}
