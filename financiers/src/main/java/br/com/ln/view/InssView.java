/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTabela;
import br.com.ln.financiers.InssFuncoes;
import br.com.ln.financiers.Tabela;
import br.com.ln.financiers.TabelaFuncoes;
import br.com.ln.financiers.TabelaItem;
import br.com.ln.tipos.TipoFuncao;
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
@ManagedBean(name = "inssView")
public class InssView implements Serializable{
    
    private Integer idCodigo;
    private Integer codigoTabela;
    private String nomeTabela;
    private Date dataInicial;
    private Date dataFinal;
    private Integer codigoTabItem;
    private Double valorInicial;
    private Double valorFinal;
    private Double valorDesconto;
    private Double percentual;
    private final Integer TIPOTABELA = 2;

    private LnTabela lnTabela;
    private Tabela tabela;
    private TabelaItem tabelaItem;
    private List<TabelaItem> listTabelaItem;
    private List<Tabela> listTabela;
    private final TabelaFuncoes tabelaFuncao;
    private final InssFuncoes inssFuncao;

    private String valor;

    private String mensagem;

    public InssView() {
        tabela = new Tabela();
        tabelaItem = new TabelaItem();
        tabelaFuncao = new TabelaFuncoes();
        inssFuncao = new InssFuncoes();
        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
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
        hash = 43 * hash + Objects.hashCode(this.idCodigo);
        hash = 43 * hash + Objects.hashCode(this.codigoTabela);
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
        final InssView other = (InssView) obj;
        if (!Objects.equals(this.idCodigo, other.idCodigo)) {
            return false;
        }
        if (!Objects.equals(this.codigoTabela, other.codigoTabela)) {
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
            clearVarTabela();
            clearVarTabelaItem();
            tabela = new Tabela();
            tabela.setTipoFuncao(TipoFuncao.Incluir);
            RequestContext.getCurrentInstance().execute("PF('InssEdit').show()");
        } else {
            mensagem = "Usuario sem premissao para incluir tabela de INSS.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
        }
    }
    
    public void btAlterar(){
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (tabela != null) {
                tabela.setTipoFuncao(TipoFuncao.Alterar);
                listTabelaItem = tabela.getListTabelaItem();
                loadTabelaVarDesc();
                RequestContext.getCurrentInstance().execute("PF('InssEdit').show()");
            } else {
                mensagem = "Para alterar a tabela e necessario escolher um.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela IRRF", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao para alterar a tabela de INSS";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
        }
    }

    public void btExcluir(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')){
            if (tabela != null) {
                tabela.setTipoFuncao(TipoFuncao.Excluir);
                listTabelaItem = tabela.getListTabelaItem();
                boolean bExcluir;
                lnTabela = loadLnTabela();
                if (lnTabela != null) {
                    bExcluir = tabelaFuncao.tabela(lnTabela);
                    if (bExcluir) {
                        clearVarTabela();
                        clearVarTabelaItem();
                        mensagem = "Tabela de Imposto incluida com sucesso!!!";
                        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela IRRF", mensagem));
                    } else {
                        mensagem = tabelaFuncao.mensagem;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tabela IRRF", mensagem));
                    }
                }
            } else {
                mensagem = "Para excluir a tabela e necessario escolher um.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela IRRF", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao para alterar a tabela de INSS";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
        }
    }
    
    public void btIncluirItem(){
        tabelaItem = new TabelaItem();
        tabelaItem.setCodigoTabItem(tabelaFuncao.calcIdTabelaItem());
        tabelaItem.setTipoFuncao(TipoFuncao.Incluir);
        loadVarTabela();
        loadVarTabelaItem();
        if (inssFuncao.verificaInformacoes(tabela, tabelaItem)) {
            tabelaItem.setTipoFuncao(TipoFuncao.Incluir);
            listTabelaItem.add(tabelaItem);
        } else {
            mensagem = inssFuncao.mensagem;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
        }
    }
    
    public void btExcluirItem(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (listTabelaItem.size() > 1) {
                tabelaItem.setTipoFuncao(TipoFuncao.Excluir);
                mensagem = "Registro marcado para exclusao com sucesso";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
            } else {
                mensagem = "E necessario ter pelo menos um valor na tabela.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao para excluir tabela.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
        }
    }
    
    public void btSalvar(){
        boolean bGravar;
        if (tabela != null && tabela.getTipoFuncao().equals(TipoFuncao.Alterar)) {
            loadVarTabela();
        }
        lnTabela = loadLnTabela();
        if (lnTabela != null) {
            bGravar = tabelaFuncao.tabela(lnTabela);
            mensagem = tabelaFuncao.mensagem;
            if (bGravar) {
                clearVarTabela();
                clearVarTabelaItem();
                listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
                RequestContext.getCurrentInstance().execute("PF('InssEdit').hide()");
                mensagem = "Tabela de Imposto incluida com sucesso!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tabela INSS", mensagem));
            } else {
                mensagem = inssFuncao.mensagem;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tabela INSS", mensagem));
            }
        }
    }

    public void btFechar() {
        RequestContext.getCurrentInstance().execute("PF('InssEdit').hide()");
    }

    private void clearVarTabela() {
        nomeTabela = "";
        dataInicial = null;
        dataFinal = null;
        codigoTabela = null;
    }

    private void clearVarTabelaItem() {
        codigoTabItem = null;
        valorDesconto = null;
        valorFinal = null;
        valorInicial = null;
        percentual = null;
        listTabelaItem.clear();
    }

    private void loadTabelaVarDesc() {
        nomeTabela = tabela.getNomeTabela();
        dataInicial = tabela.getDataInicial();
        dataFinal = tabela.getDataFinal();
    }

    private LnTabela loadLnTabela() {
        boolean bGravar;
        
        if (listTabelaItem != null && !listTabelaItem.isEmpty()) {
            lnTabela = tabelaFuncao.loadLnTabela(tabela, listTabelaItem, TIPOTABELA);
            bGravar = tabelaFuncao.bGravar;

            if (!bGravar) {
                mensagem = tabelaFuncao.mensagem;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tabela INSS", mensagem));
            }
        } else {
            lnTabela = null;
            mensagem = "Lista da tabela esta vazia!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tabela INSS", mensagem));
        }
        return lnTabela;
    }
    private void loadVarTabela() {
        tabela.setDataFinal(dataFinal);
        tabela.setDataInicial(dataInicial);
        tabela.setNomeTabela(nomeTabela);
    }

    private void loadVarTabelaItem() {
        tabelaItem.setPercentual(percentual);
        tabelaItem.setValorDesconto(valorDesconto);
        tabelaItem.setValorFinal(valorFinal);
        tabelaItem.setValorInicial(valorInicial);
    }

}
