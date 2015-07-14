/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.financiers.TipoFuncao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @NamedQuery(name = "LnTabela.findByTabDtFinal", query = "SELECT l FROM LnTabela l WHERE l.tabDtFinal = :tabDtFinal")})
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
    @Basic(optional = false)
    @Column(name = "tab_dt_final")
    @Temporal(TemporalType.DATE)
    private Date tabDtFinal;
    
    @Transient
    private TipoFuncao tipoFuncao;
    
    @Transient
    List<LnTabelaItem> listLnTabelaItem;

    public LnTabela() {
    }

    public LnTabela(Integer tabInCodigo) {
        this.tabInCodigo = tabInCodigo;
    }

    public LnTabela(Integer tabInCodigo, int ttbInCodigo, String tabStDescricao, Date tabDtInicio, Date tabDtFinal) {
        this.tabInCodigo = tabInCodigo;
        this.ttbInCodigo = ttbInCodigo;
        this.tabStDescricao = tabStDescricao;
        this.tabDtInicio = tabDtInicio;
        this.tabDtFinal = tabDtFinal;
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

    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

    public List<LnTabelaItem> getListLnTabelaItem() {
        return listLnTabelaItem;
    }

    public void setListLnTabelaItem(List<LnTabelaItem> listLnTabelaItem) {
        this.listLnTabelaItem = listLnTabelaItem;
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
        return "LnTabela{" + "tabInCodigo=" + tabInCodigo + ", ttbInCodigo=" + ttbInCodigo + ", tabStDescricao=" + tabStDescricao + ", tabDtInicio=" + tabDtInicio + ", tabDtFinal=" + tabDtFinal + ", tipoFuncao=" + tipoFuncao + ", listLnTabelaItem=" + listLnTabelaItem + '}';
    }
}
