/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.tipos.TipoFuncao;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_planoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnPlanoconta.findAll", query = "SELECT l FROM LnPlanoconta l order by l.catInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaInCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaInCodigo = :ctaInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByCatInCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.catInCodigo = :catInCodigo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaStDescricao", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaStDescricao = :ctaStDescricao"),
    @NamedQuery(name = "LnPlanoconta.findByCtaChAtivo", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChAtivo = :ctaChAtivo"),
    @NamedQuery(name = "LnPlanoconta.findByCtaFinanceiro", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaChAtivo = :ctaChAtivo and l.catInCodigo in (2,3,4)"),
    @NamedQuery(name = "LnPlanoconta.findByCtaFlSaldoinicial", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaFlSaldoinicial = :ctaFlSaldoinicial"),
    @NamedQuery(name = "LnPlanoconta.findByCtaStConfiguracao", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaStConfiguracao = :ctaStConfiguracao"),
    @NamedQuery(name = "LnPlanoconta.findByCtaStAlerta", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaStAlerta = :ctaStAlerta"),
    @NamedQuery(name = "LnPlanoconta.findByCtaDtCriacao", query = "SELECT l FROM LnPlanoconta l WHERE l.ctaDtCriacao = :ctaDtCriacao"),
    @NamedQuery(name = "LnPlanoconta.findByUsuStCodigo", query = "SELECT l FROM LnPlanoconta l WHERE l.usuStCodigo = :usuStCodigo")})
public class LnPlanoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cta_in_codigo")
    private Integer ctaInCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat_in_codigo")
    private int catInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cta_st_descricao")
    private String ctaStDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cta_ch_ativo")
    private Character ctaChAtivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cta_fl_saldoinicial")
    private double ctaFlSaldoinicial;
    @Size(max = 1000)
    @Column(name = "cta_st_configuracao")
    private String ctaStConfiguracao;
    @Size(max = 1000)
    @Column(name = "cta_st_alerta")
    private String ctaStAlerta;
    @Column(name = "cta_dt_criacao")
    @Temporal(TemporalType.DATE)
    private Date ctaDtCriacao;
    @Size(max = 30)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;
    
    @Transient
    private TipoFuncao tipoFuncao;    

    public LnPlanoconta() {
    }

    public LnPlanoconta(Integer ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public LnPlanoconta(Integer ctaInCodigo, int catInCodigo, String ctaStDescricao, Character ctaChAtivo, double ctaFlSaldoinicial) {
        this.ctaInCodigo = ctaInCodigo;
        this.catInCodigo = catInCodigo;
        this.ctaStDescricao = ctaStDescricao;
        this.ctaChAtivo = ctaChAtivo;
        this.ctaFlSaldoinicial = ctaFlSaldoinicial;
    }

    public Integer getCtaInCodigo() {
        return ctaInCodigo;
    }

    public void setCtaInCodigo(Integer ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public int getCatInCodigo() {
        return catInCodigo;
    }

    public void setCatInCodigo(int catInCodigo) {
        this.catInCodigo = catInCodigo;
    }

    public String getCtaStDescricao() {
        return ctaStDescricao;
    }

    public void setCtaStDescricao(String ctaStDescricao) {
        this.ctaStDescricao = ctaStDescricao;
    }

    public Character getCtaChAtivo() {
        return ctaChAtivo;
    }

    public void setCtaChAtivo(Character ctaChAtivo) {
        this.ctaChAtivo = ctaChAtivo;
    }

    public double getCtaFlSaldoinicial() {
        return ctaFlSaldoinicial;
    }

    public void setCtaFlSaldoinicial(double ctaFlSaldoinicial) {
        this.ctaFlSaldoinicial = ctaFlSaldoinicial;
    }

    public String getCtaStConfiguracao() {
        return ctaStConfiguracao;
    }

    public void setCtaStConfiguracao(String ctaStConfiguracao) {
        this.ctaStConfiguracao = ctaStConfiguracao;
    }

    public String getCtaStAlerta() {
        return ctaStAlerta;
    }

    public void setCtaStAlerta(String ctaStAlerta) {
        this.ctaStAlerta = ctaStAlerta;
    }

    public Date getCtaDtCriacao() {
        return ctaDtCriacao;
    }

    public void setCtaDtCriacao(Date ctaDtCriacao) {
        this.ctaDtCriacao = ctaDtCriacao;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
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
