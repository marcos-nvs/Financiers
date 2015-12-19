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
@Table(name = "ln_tabelaItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTabelaItem.findAll", query = "SELECT l FROM LnTabelaItem l"),
    @NamedQuery(name = "LnTabelaItem.findByTaiInCodigo", query = "SELECT l FROM LnTabelaItem l WHERE l.taiInCodigo = :taiInCodigo"),
    @NamedQuery(name = "LnTabelaItem.findByTabInCodigo", query = "SELECT l FROM LnTabelaItem l WHERE l.tabInCodigo = :tabInCodigo"),
    @NamedQuery(name = "LnTabelaItem.findByTaiFlInicio", query = "SELECT l FROM LnTabelaItem l WHERE l.taiFlInicio = :taiFlInicio"),
    @NamedQuery(name = "LnTabelaItem.findByTaiFlFinal", query = "SELECT l FROM LnTabelaItem l WHERE l.taiFlFinal = :taiFlFinal"),
    @NamedQuery(name = "LnTabelaItem.findByTaiFlPercentual", query = "SELECT l FROM LnTabelaItem l WHERE l.taiFlPercentual = :taiFlPercentual"),
    @NamedQuery(name = "LnTabelaItem.findByTaiFlDesconto", query = "SELECT l FROM LnTabelaItem l WHERE l.taiFlDesconto = :taiFlDesconto"),
    @NamedQuery(name = "LnTabelaItem.findByTaiFlDependente", query = "SELECT l FROM LnTabelaItem l WHERE l.taiFlDependente = :taiFlDependente")})

public class LnTabelaItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tai_in_codigo")
    private Integer taiInCodigo;
    @Basic(optional = false)
    @Column(name = "tab_in_codigo")
    private int tabInCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tai_fl_inicio")
    private Double taiFlInicio;
    @Column(name = "tai_fl_final")
    private Double taiFlFinal;
    @Column(name = "tai_fl_percentual")
    private Double taiFlPercentual;
    @Column(name = "tai_fl_desconto")
    private Double taiFlDesconto;
    @Column(name = "tai_fl_dependente")
    private Double taiFlDependente;
    @Column(name = "tai_in_qtddependente")
    private Integer taiInQtddependente;
    @Column(name = "tai_st_origem")
    private String taiStOrigem;
    @Column(name = "tai_st_tipo")
    private String taiStTipo;
    
    @Transient
    private TipoFuncao tipoFuncao;

    public LnTabelaItem() {
    }

    public LnTabelaItem(Integer taiInCodigo) {
        this.taiInCodigo = taiInCodigo;
    }

    public LnTabelaItem(Integer taiInCodigo, int tabInCodigo) {
        this.taiInCodigo = taiInCodigo;
        this.tabInCodigo = tabInCodigo;
    }

    public Integer getTaiInCodigo() {
        return taiInCodigo;
    }

    public void setTaiInCodigo(Integer taiInCodigo) {
        this.taiInCodigo = taiInCodigo;
    }

    public int getTabInCodigo() {
        return tabInCodigo;
    }

    public void setTabInCodigo(int tabInCodigo) {
        this.tabInCodigo = tabInCodigo;
    }

    public Double getTaiFlInicio() {
        return taiFlInicio;
    }

    public void setTaiFlInicio(Double taiFlInicio) {
        this.taiFlInicio = taiFlInicio;
    }

    public Double getTaiFlFinal() {
        return taiFlFinal;
    }

    public void setTaiFlFinal(Double taiFlFinal) {
        this.taiFlFinal = taiFlFinal;
    }

    public Double getTaiFlPercentual() {
        return taiFlPercentual;
    }

    public void setTaiFlPercentual(Double taiFlPercentual) {
        this.taiFlPercentual = taiFlPercentual;
    }

    public Double getTaiFlDesconto() {
        return taiFlDesconto;
    }

    public void setTaiFlDesconto(Double taiFlDesconto) {
        this.taiFlDesconto = taiFlDesconto;
    }

    public Double getTaiFlDependente() {
        return taiFlDependente;
    }

    public void setTaiFlDependente(Double taiFlDependente) {
        this.taiFlDependente = taiFlDependente;
    }

    public Integer getTaiInQtddependente() {
        return taiInQtddependente;
    }

    public void setTaiInQtddependente(Integer taiInQtddependente) {
        this.taiInQtddependente = taiInQtddependente;
    }

    public String getTaiStOrigem() {
        return taiStOrigem;
    }

    public void setTaiStOrigem(String taiStOrigem) {
        this.taiStOrigem = taiStOrigem;
    }

    public String getTaiStTipo() {
        return taiStTipo;
    }

    public void setTaiStTipo(String taiStTipo) {
        this.taiStTipo = taiStTipo;
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
        hash += (taiInCodigo != null ? taiInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTabelaItem)) {
            return false;
        }
        LnTabelaItem other = (LnTabelaItem) object;
        if ((this.taiInCodigo == null && other.taiInCodigo != null) || (this.taiInCodigo != null && !this.taiInCodigo.equals(other.taiInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnTabelaItem{" + "taiInCodigo=" + taiInCodigo + ", tabInCodigo=" + tabInCodigo + ", taiFlInicio=" + taiFlInicio + ", taiFlFinal=" + taiFlFinal + ", taiFlPercentual=" + taiFlPercentual + ", taiFlDesconto=" + taiFlDesconto + ", taiFlDependente=" + taiFlDependente + ", taiInQtddependente=" + taiInQtddependente + ", taiStOrigem=" + taiStOrigem + ", taiStTipo=" + taiStTipo + ", tipoFuncao=" + tipoFuncao + '}';
    }

}
