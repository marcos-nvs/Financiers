/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.financiers.TipoFuncao;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_tabela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnTabela.findAll", query = "SELECT l FROM LnTabela l"),
    @NamedQuery(name = "LnTabela.findByTabInCodigo", query = "SELECT l FROM LnTabela l WHERE l.tabInCodigo = :tabInCodigo"),
    @NamedQuery(name = "LnTabela.findByTtbInCodigo", query = "SELECT l FROM LnTabela l WHERE l.ttbInCodigo = :ttbInCodigo"),
    @NamedQuery(name = "LnTabela.findByTabStDescricao", query = "SELECT l FROM LnTabela l WHERE l.tabStDescricao = :tabStDescricao"),
    @NamedQuery(name = "LnTabela.findByTabDtInicio", query = "SELECT l FROM LnTabela l WHERE l.tabDtInicio = :tabDtInicio"),
    @NamedQuery(name = "LnTabela.findByTabDtFinal", query = "SELECT l FROM LnTabela l WHERE l.tabDtFinal = :tabDtFinal"),
    @NamedQuery(name = "LnTabela.findByTabFlInicio", query = "SELECT l FROM LnTabela l WHERE l.tabFlInicio = :tabFlInicio"),
    @NamedQuery(name = "LnTabela.findByTabFlFinal", query = "SELECT l FROM LnTabela l WHERE l.tabFlFinal = :tabFlFinal"),
    @NamedQuery(name = "LnTabela.findByTabFlPercentual", query = "SELECT l FROM LnTabela l WHERE l.tabFlPercentual = :tabFlPercentual"),
    @NamedQuery(name = "LnTabela.findByTabFlDesconto", query = "SELECT l FROM LnTabela l WHERE l.tabFlDesconto = :tabFlDesconto"),
    @NamedQuery(name = "LnTabela.findByTabFlDependente", query = "SELECT l FROM LnTabela l WHERE l.tabFlDependente = :tabFlDependente"),
    @NamedQuery(name = "LnTabela.findByTabFlQtddependente", query = "SELECT l FROM LnTabela l WHERE l.tabFlQtddependente = :tabFlQtddependente"),
    @NamedQuery(name = "LnTabela.findByCodDescricaoListaIRRF",
                      query = "SELECT l.tabInCodigo, l.tabStDescricao, l.tabDtInicio, l.tabFlFinal FROM LnTabela l WHERE l.ttbInCodigo = :ttbInCodigo"),
    @NamedQuery(name = "LnTabela.findByCodigoDetalheIRRF",
                      query = "SELECT l FROM LnTabela l WHERE l.ttbInCodigo = :ttbInCodigo and l.tabDtInicio = :tabDtInicio and l.tabDtFinal = :tabDtFinal")})
public class LnTabela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tab_in_codigo")
    private Integer tabInCodigo;
    @Basic(optional = false)
    @Column(name = "ttb_in_codigo")
    private int ttbInCodigo;
    @Basic(optional = false)
    @Column(name = "tab_st_descricao")
    private String tabStDescricao;
    @Basic(optional = false)
    @Column(name = "tab_dt_inicio")
    @Temporal(TemporalType.DATE)    
    private Date tabDtInicio;
    @Column(name = "tab_dt_final")
    @Temporal(TemporalType.DATE)
    private Date tabDtFinal;
    @Column(name = "tab_fl_inicio")
    private Double tabFlInicio;
    @Column(name = "tab_fl_final")
    private Double tabFlFinal;
    @Column(name = "tab_fl_percentual")
    private Double tabFlPercentual;
    @Column(name = "tab_fl_desconto")
    private Double tabFlDesconto;
    @Column(name = "tab_fl_dependente")
    private Double tabFlDependente;
    @Column(name = "tab_fl_qtddependente")
    private Double tabFlQtddependente;
    
    @Transient
    private TipoFuncao tipoFuncao;
    
    public LnTabela() {
    }

    public LnTabela(Integer tabInCodigo) {
        this.tabInCodigo = tabInCodigo;
    }

    public LnTabela(Integer tabInCodigo, int ttbInCodigo, String tabStDescricao, Date tabDtInicio) {
        this.tabInCodigo = tabInCodigo;
        this.ttbInCodigo = ttbInCodigo;
        this.tabStDescricao = tabStDescricao;
        this.tabDtInicio = tabDtInicio;
    }

    public Integer getTabInCodigo() {
        return tabInCodigo;
    }

    public void setTabInCodigo(Integer tabInCodigo) {
        this.tabInCodigo = tabInCodigo;
    }

    public int getTtbInCodigo() {
        return ttbInCodigo;
    }

    public void setTtbInCodigo(int ttbInCodigo) {
        this.ttbInCodigo = ttbInCodigo;
    }

    public String getTabStDescricao() {
        return tabStDescricao;
    }

    public void setTabStDescricao(String tabStDescricao) {
        this.tabStDescricao = tabStDescricao;
    }

    public Date getTabDtInicio() {
        return tabDtInicio;
    }

    public void setTabDtInicio(Date tabDtInicio) {
        this.tabDtInicio = tabDtInicio;
    }

    public Date getTabDtFinal() {
        return tabDtFinal;
    }

    public void setTabDtFinal(Date tabDtFinal) {
        this.tabDtFinal = tabDtFinal;
    }

    public Double getTabFlInicio() {
        return tabFlInicio;
    }

    public void setTabFlInicio(Double tabFlInicio) {
        this.tabFlInicio = tabFlInicio;
    }

    public Double getTabFlFinal() {
        return tabFlFinal;
    }

    public void setTabFlFinal(Double tabFlFinal) {
        this.tabFlFinal = tabFlFinal;
    }

    public Double getTabFlPercentual() {
        return tabFlPercentual;
    }

    public void setTabFlPercentual(Double tabFlPercentual) {
        this.tabFlPercentual = tabFlPercentual;
    }

    public Double getTabFlDesconto() {
        return tabFlDesconto;
    }

    public void setTabFlDesconto(Double tabFlDesconto) {
        this.tabFlDesconto = tabFlDesconto;
    }

    public Double getTabFlDependente() {
        return tabFlDependente;
    }

    public void setTabFlDependente(Double tabFlDependente) {
        this.tabFlDependente = tabFlDependente;
    }

    public Double getTabFlQtddependente() {
        return tabFlQtddependente;
    }

    public void setTabFlQtddependente(Double tabFlQtddependente) {
        this.tabFlQtddependente = tabFlQtddependente;
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
        hash += (tabInCodigo != null ? tabInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnTabela)) {
            return false;
        }
        LnTabela other = (LnTabela) object;
        if ((this.tabInCodigo == null && other.tabInCodigo != null) || (this.tabInCodigo != null && !this.tabInCodigo.equals(other.tabInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnTabela[ tabInCodigo=" + tabInCodigo + " ]";
    }
    
}
