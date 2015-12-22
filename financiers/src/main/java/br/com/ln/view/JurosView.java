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
import br.com.ln.entity.LnFavorecido;
import br.com.ln.entity.LnTabela;
import br.com.ln.funcao.JurosFuncoes;
import br.com.ln.objeto.Tabela;
import br.com.ln.funcao.TabelaFuncoes;
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
@ManagedBean(name = "jurosView")
public class JurosView implements Serializable {

    private Integer idCodigo;
    private Integer codigoTabela;
    private String nomeTabela;
    private Date dataInicial;
    private Date dataFinal;
    private Integer codigoTabItem;
    private Double percentual;
    private String banco;
    private final Integer TIPOTABELA = 4;

    private LnTabela lnTabela;
    private Tabela tabela;
    private TabelaItem tabelaItem;
    private List<TabelaItem> listTabelaItem;
    private List<Tabela> listTabela;
    private List<LnFavorecido> listaBanco;
    private final TabelaFuncoes tabelaFuncao;
    private final JurosFuncoes jurosFuncao;
    private final BeanVar beanVar;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public JurosView() {
        tabela = new Tabela();
        tabelaItem = new TabelaItem();
        tabelaFuncao = new TabelaFuncoes();
        jurosFuncao = new JurosFuncoes();
        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
        listTabelaItem = new ArrayList<>();
        listaBanco = FavorecidoDao.grabBancos();
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
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

    public List<LnFavorecido> getListaBanco() {
        return listaBanco;
    }

    public void setListaBanco(List<LnFavorecido> listaBanco) {
        this.listaBanco = listaBanco;
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
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idCodigo);
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
        final JurosView other = (JurosView) obj;
        if (!Objects.equals(this.idCodigo, other.idCodigo)) {
            return false;
        }
        return true;
    }

    public void btIncluir() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            clearVarTabela();
            clearVarTabelaItem();
            tabela = new Tabela();
            tabela.setTipoFuncao(TipoFuncao.Incluir);
            beanVar.setTituloDialog("ln.frase.inclusaotabela");
            RequestContext.getCurrentInstance().execute("PF('JurosEdit').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btAlterar() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (tabela != null) {
                tabela.setTipoFuncao(TipoFuncao.Alterar);
                listTabelaItem = tabela.getListTabelaItem();
                loadTabelaVarDesc();
                beanVar.setTituloDialog("ln.frase.inclusaotabela");
                RequestContext.getCurrentInstance().execute("PF('JurosEdit').show()");
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btExcluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
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
                        mensagem = bundle.getString("ln.mb.texto.sucesso");
                        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                bundle.getString("ln.mb.titulo.tabela"), mensagem));
                    } else {
                        mensagem = tabelaFuncao.mensagem;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                bundle.getString("ln.mb.titulo.tabela"), mensagem));
                    }
                }
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btIncluiDetalhe() {
        tabelaItem = new TabelaItem();
        tabelaItem.setCodigoTabItem(tabelaFuncao.calcIdTabelaItem());
        tabelaItem.setTipoFuncao(TipoFuncao.Incluir);
        loadVarTabela();
        loadVarTabelaItem();
        if (jurosFuncao.verificaInformacoes(tabela, tabelaItem)) {
            tabelaItem.setTipoFuncao(TipoFuncao.Incluir);
            listTabelaItem.add(tabelaItem);
        } else {
            mensagem = jurosFuncao.mensagem;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btExcluiDetalhe() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (listTabelaItem.size() > 1) {
                tabelaItem.setTipoFuncao(TipoFuncao.Excluir);
                mensagem = bundle.getString("ln.mb.texto.sucesso");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btSalvar() {
        boolean bGravar;
//        if (tabela != null && tabela.getTipoFuncao().equals(TipoFuncao.Alterar)) {
            loadVarTabela();
//        }
        lnTabela = loadLnTabela();
        if (lnTabela != null) {
            bGravar = tabelaFuncao.tabela(lnTabela);
            mensagem = tabelaFuncao.mensagem;
            if (bGravar) {
                clearVarTabela();
                clearVarTabelaItem();
                listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
                RequestContext.getCurrentInstance().execute("PF('JurosEdit').hide()");
                mensagem = bundle.getString("ln.mb.texto.sucesso");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            } else {
                mensagem = jurosFuncao.mensagem;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.tabela"), mensagem));
            }
        }
    }

    public void btFechar() {
        RequestContext.getCurrentInstance().execute("PF('JurosEdit').hide()");
    }

    private void loadVarTabela() {
        tabela.setDataFinal(dataFinal);
        tabela.setDataInicial(dataInicial);
        tabela.setNomeTabela(nomeTabela);
    }

    private void loadVarTabelaItem() {
        tabelaItem.setPercentual(percentual);
        tabelaItem.setOrigem(banco);
    }

    private void clearVarTabela() {
        nomeTabela = "";
        dataInicial = null;
        dataFinal = null;
        codigoTabela = null;
    }

    private void clearVarTabelaItem() {
        codigoTabItem = null;
        banco = null;
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
    
    public String descricaoBanco(String banco){
        return FavorecidoDao.grabFavorecidoBanco(new Integer(banco)).getFavStDescricao();
    } 
    
    public void btVoltar(){
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }
}
