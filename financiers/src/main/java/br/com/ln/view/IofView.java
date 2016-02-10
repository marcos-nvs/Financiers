/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.FavorecidoDao;
import br.com.ln.entity.LnTabela;
import br.com.ln.funcao.IofFuncoes;
import br.com.ln.funcao.JurosFuncoes;
import br.com.ln.funcao.TabelaFuncoes;
import br.com.ln.objeto.Tabela;
import br.com.ln.objeto.TabelaItem;
import br.com.ln.tipos.TipoFuncao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
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
@ManagedBean(name = "iofView")
public class IofView implements Serializable {

    private Integer idCodigo;
    private Integer codigoTabela;
    private String nomeTabela;
    private Date dataInicial;
    private Date dataFinal;
    private Integer codigoTabItem;
    private Double percentual;
    private final Integer TIPOTABELA = 4;

    private LnTabela lnTabela;
    private Tabela tabela;
    private TabelaItem tabelaItem;
    private List<TabelaItem> listTabelaItem;
    private List<Tabela> listTabela;
    private TabelaFuncoes tabelaFuncao;
    private IofFuncoes iofFuncao;
    private BeanVar beanVar;
    private String valor;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public IofView() {
        tabela = new Tabela();
        tabelaItem = new TabelaItem();
        tabelaFuncao = new TabelaFuncoes();
        iofFuncao = new IofFuncoes();
        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
        listTabelaItem = new ArrayList<>();
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
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

    public Integer getCodigoTabItem() {
        return codigoTabItem;
    }

    public void setCodigoTabItem(Integer codigoTabItem) {
        this.codigoTabItem = codigoTabItem;
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

    public TabelaItem getTabelaItem() {
        return tabelaItem;
    }

    public void setTabelaItem(TabelaItem tabelaItem) {
        this.tabelaItem = tabelaItem;
    }

    public List<TabelaItem> getListTabelaItem() {
        return listTabelaItem;
    }

    public void setListTabelaItem(List<TabelaItem> listTabelaItem) {
        this.listTabelaItem = listTabelaItem;
    }

    public List<Tabela> getListTabela() {
        return listTabela;
    }

    public void setListTabela(List<Tabela> listTabela) {
        this.listTabela = listTabela;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idCodigo);
        hash = 47 * hash + Objects.hashCode(this.codigoTabela);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IofView other = (IofView) obj;
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
        return "IofView{" + "tabela=" + tabela + ", tabelaItem=" + tabelaItem + '}';
    }

    public void btIncluir() {
        
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            clearVarTabela();
            clearVarTabelaItem();
            tabela = new Tabela();
            tabela.setTipoFuncao(TipoFuncao.Incluir);
            beanVar.setTelaDialog("WEB-INF/templates/dialog/dialogtabelaiof.xhtml");
            beanVar.setTituloDialog("ln.frase.inclusaotabela");
            RequestContext.getCurrentInstance().execute("PF('dialog').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }

    }

    public void btAlterar() {

    }

    public void btExcluir() {

    }

    public void btIncluirDetalhe() {

    }

    public void btExcluirDetalhe() {

    }

    public void btSalvar() {

    }

    public void btFechar() {

    }

    private void loadVarTabela() {
        tabela.setDataFinal(dataFinal);
        tabela.setDataInicial(dataInicial);
        tabela.setNomeTabela(nomeTabela);
    }

    private void loadVarTabelaItem() {
        tabelaItem.setPercentual(percentual);
    }

    private void clearVarTabela() {
        nomeTabela = "";
        dataInicial = null;
        dataFinal = null;
        codigoTabela = null;
    }

    private void clearVarTabelaItem() {
        codigoTabItem = null;
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            }
        } else {
            lnTabela = null;
            mensagem = bundle.getString("ln.mb.frase.listavazia");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
        return lnTabela;
    }

    public void btVoltar() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }

}
