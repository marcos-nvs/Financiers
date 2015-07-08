/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.financiers.IrrfFuncoes;
import br.com.ln.financiers.Tabela;
import br.com.ln.financiers.TabelaItem;
import br.com.ln.financiers.TipoFuncao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "IrrfView")
public class IrrfView implements Serializable {

    private Integer idCodigo;
    private Integer codigoTabela;
    private String nomeTabela;
    private Date dataInicial;
    private Date dataFinal;
    private Integer codigoTabItem;
    private Double valorInicial;
    private Double valorFinal;
    private Double valorDependente;
    private Double valorDesconto;
    private Double percentual;
    private Double qtdDependente;    
    
    private Tabela tabela;
    private TabelaItem tabelaItem;
    private List<TabelaItem> listTabelaItem;
    private List<Tabela> listTabela;
    private final IrrfFuncoes irrfFuncao;
    
    private String valor;
    
    private String mensagem;

    
    public IrrfView() {
        tabela = new Tabela();
        tabelaItem = new TabelaItem();
        irrfFuncao = new IrrfFuncoes();
        listTabela = irrfFuncao.buscaTabela();
        listTabelaItem = new ArrayList<>();
    }

    public Integer getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(Integer idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Integer getCodigoTabela() {
        return codigoTabela;
    }

    public void setCodigoTabela(Integer codigoTabela) {
        this.codigoTabela = codigoTabela;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Integer getCodigoTabItem() {
        return codigoTabItem;
    }

    public void setCodigoTabItem(Integer codigoTabItem) {
        this.codigoTabItem = codigoTabItem;
    }
    
    public Double getValorDependente() {
        return valorDependente;
    }

    public void setValorDependente(Double valorDependente) {
        this.valorDependente = valorDependente;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getQtdDependente() {
        return qtdDependente;
    }

    public void setQtdDependente(Double qtdDependente) {
        this.qtdDependente = qtdDependente;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public List<Tabela> getListTabela() {
        return listTabela;
    }

    public void setListTabela(List<Tabela> listTabela) {
        this.listTabela = listTabela;
    }

    public TabelaItem getTabelaItem() {
        return tabelaItem;
    }

    public void setTabelaItem(TabelaItem tabelaItem) {
        this.tabelaItem = tabelaItem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<TabelaItem> getListTabelaItem() {
        return listTabelaItem;
    }

    public void setListTabelaItem(List<TabelaItem> listTabelaItem) {
        this.listTabelaItem = listTabelaItem;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.tabela);
        hash = 47 * hash + Objects.hashCode(this.listTabela);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IrrfView other = (IrrfView) obj;
        if (!Objects.equals(this.tabela, other.tabela)) {
            return false;
        }
        if (!Objects.equals(this.listTabela, other.listTabela)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IrrfView{" + "tabela=" + tabela + ", listTabela=" + listTabela + '}';
    }

    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            tabela = new Tabela();
            tabela.setTipoFuncao(TipoFuncao.Incluir);
            RequestContext.getCurrentInstance().execute("PF('IrrfEdit').show()");
        } else {
            mensagem = "Usuario sem premissao para incluir tabela de IRRF.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tabela IRRF", mensagem));
        }
    }
    
    public void btAlterar(){
        
    }
    
    public void btExcluir(){
        
    }
    
    public void btIncluiDetalhe(){
        tabelaItem = new TabelaItem();
        tabelaItem.setCodigoTabItem(irrfFuncao.calcIdTabelaItem());
        tabelaItem.setTipoFuncao(TipoFuncao.Incluir);
        loadVarTabelaItem();
        System.out.println("tabela Item : " + tabelaItem.toString());
        listTabelaItem.add(tabelaItem);
    }
    
    public void btExcluiDetalhe(){
        tabelaItem = new TabelaItem();
        tabelaItem.setTipoFuncao(TipoFuncao.Excluir);
        loadVarTabelaItem();
        listTabelaItem.remove(tabelaItem);
    }
    
    public void btSalvar(){
        
    }
    
    public void btFechar(){
        RequestContext.getCurrentInstance().execute("PF('IrrfEdit').hide()");
    }
    
    private void loadVarTabelaItem(){
        tabelaItem.setPercentual(percentual);
        tabelaItem.setQtdDependente(qtdDependente);
        tabelaItem.setValorDependente(valorDependente);
        tabelaItem.setValorDesconto(valorDesconto);
        tabelaItem.setValorFinal(valorFinal);
        tabelaItem.setValorInicial(valorInicial);
    }
}
