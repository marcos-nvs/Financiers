/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.CategoriaDao;
import br.com.ln.entity.LnCategoria;
import br.com.ln.funcao.PlanoContaFuncoes;
import br.com.ln.objeto.Conta;
import java.io.Serializable;
import java.util.List;
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
@ManagedBean(name = "contaView")
public class PlanoContaView implements Serializable {

    //Variavéis Plano Conta
    private Integer idConta;
    private String nomeConta;
    private boolean bContaAtiva;
    private Double saldoInicial;

    private Conta conta;

    private List<Conta> listaContas;
    private List<LnCategoria> listaCategoria;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    private final PlanoContaFuncoes planoContaFuncoes;
    private final BeanVar beanVar;

    //Variavéis de Tela
    private Integer idCategoria;
    private Integer idTipoConta;
    private boolean bAtivoConta;
    private boolean bItemAtivoAplicacao;
    private boolean bItemAtivoMovel;
    private String tipoAtivo;
    private String telaAtivo = "imovel.xhtml";
    private String telaConta = "../cadastro/planocontas/ativo.xhtml";
    private String telaCalculada;
    private boolean bCalculada;
    private String tipoEmprestimo;
    private String tipoFinanciamento;
    private String telaEmprestimo;
    private String telaFinanciamento;
        

    public PlanoContaView() {
        planoContaFuncoes = new PlanoContaFuncoes();
        listaCategoria = CategoriaDao.grabCategoria('S');
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        tipoEmprestimo = "1";
        tipoFinanciamento = "1";
        telaEmprestimo = "infotomando.xhtml";
        telaFinanciamento = "ativo.xhtml";
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public List<LnCategoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<LnCategoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public boolean isbContaAtiva() {
        return bContaAtiva;
    }

    public void setbContaAtiva(boolean bContaAtiva) {
        this.bContaAtiva = bContaAtiva;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    
    //Tela

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(Integer idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public String getTelaConta() {
        return telaConta;
    }

    public void setTelaConta(String telaConta) {
        this.telaConta = telaConta;
    }

    public boolean isbAtivoConta() {
        return bAtivoConta;
    }

    public void setbAtivoConta(boolean bAtivoConta) {
        this.bAtivoConta = bAtivoConta;
    }

    public boolean isbItemAtivoAplicacao() {
        return bItemAtivoAplicacao;
    }

    public void setbItemAtivoAplicacao(boolean bItemAtivoAplicacao) {
        this.bItemAtivoAplicacao = bItemAtivoAplicacao;
    }

    public boolean isbItemAtivoMovel() {
        return bItemAtivoMovel;
    }

    public String getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(String tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public String getTelaAtivo() {
        return telaAtivo;
    }

    public void setTelaAtivo(String telaAtivo) {
        this.telaAtivo = telaAtivo;
    }

    public String getTelaCalculada() {
        return telaCalculada;
    }

    public void setTelaCalculada(String telaCalculada) {
        this.telaCalculada = telaCalculada;
    }

    public boolean isbCalculada() {
        return bCalculada;
    }

    public void setbCalculada(boolean bCalculada) {
        this.bCalculada = bCalculada;
    }
    
    public String getTipoEmprestimo() {
        return tipoEmprestimo;
    }

    public void setTipoEmprestimo(String tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public String getTipoFinanciamento() {
        return tipoFinanciamento;
    }

    public void setTipoFinanciamento(String tipoFinanciamento) {
        this.tipoFinanciamento = tipoFinanciamento;
    }

    public String getTelaEmprestimo() {
        return telaEmprestimo;
    }

    public void setTelaEmprestimo(String telaEmprestimo) {
        this.telaEmprestimo = telaEmprestimo;
    }

    public String getTelaFinanciamento() {
        return telaFinanciamento;
    }

    public void setTelaFinanciamento(String telaFinanciamento) {
        this.telaFinanciamento = telaFinanciamento;
    }
    

    public void btIncluirConta() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            clearVarConta();
            clearVarContaDepdente();
            clearVarAgendaConta();
            conta = new Conta();
            beanVar.setTelaDialog("WEB-INF/templates/dialog/dialogplanoconta.xhtml");
            beanVar.setTituloDialog("ln.texto.cadastroconta");
            RequestContext.getCurrentInstance().execute("PF('dialog').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }

    public void btAlterarConta() {

    }

    public void btExcluirConta() {

    }

    public void btVisualizarConta() {

    }

    public void btFecharConta() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }

    public void btIncluirContaLista() {

    }

    public void btSalvarContaLista() {

    }

    public void btFecharContaLista() {
        RequestContext.getCurrentInstance().execute("PF('dialog').hide()");
    }

    private void clearVarConta() {
    }

    private void clearVarContaDepdente() {
    }

    private void clearVarAgendaConta() {

    }

    public void btVoltar() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }

    public void identificaTipoConta() {

        getTipoContaPorCategoria(idCategoria);

        switch (idTipoConta) {
            case 1:
                telaConta = "../cadastro/planocontas/ativo.xhtml";
                bItemAtivoAplicacao = false;
                bItemAtivoMovel = false;
                break;
            case 2:
                telaConta = "../cadastro/planocontas/vazia.xhtml";
                break;
            case 3:
                telaConta = "../cadastro/planocontas/banco.xhtml";
                break;
            case 4:
                telaConta = "../cadastro/planocontas/cartaocredito.xhtml";
                break;
            case 5:
                telaConta = "../cadastro/planocontas/vazia.xhtml";
                break;
            case 6:
                telaConta = "../cadastro/planocontas/emprestimo.xhtml";
                break;
            case 7:
                telaConta = "../cadastro/planocontas/financiamento.xhtml";
                bItemAtivoAplicacao = true;
                bItemAtivoMovel = true;
                break;
            case 8:
                telaConta = "../cadastro/planocontas/vazia.xhtml";
                break;
            case 9:
                telaConta = "../cadastro/planocontas/receitas.xhtml";
                break;
            case 10:
                telaConta = "../cadastro/planocontas/despesas.xhtml";
                break;
            case 11:
                telaConta = "../cadastro/planocontas/vazia.xhtml";
                break;
            case 12:
                telaConta = "../cadastro/planocontas/vazia.xhtml";
                break;
        }

    }

    private void getTipoContaPorCategoria(Integer categoria) {
        idTipoConta = CategoriaDao.grabTipoContaPorCategoria(categoria);
    }

    public void mostraCalculoConta(){
        if (bCalculada){
            telaCalculada = "../cadastro/planocontas/contacalculada.xhtml";
        } else {
            telaCalculada = "../cadastro/planocontas/vazia.xhtml";
        }
    }

    public void mostraAtivo() {

        switch (tipoAtivo) {
            case "Imóvel":
                telaAtivo = "imovel.xhtml";
                break;
            case "Automóvel":
                telaAtivo = "automovel.xhtml";
                break;
            case "Móvel":
                telaAtivo = "vazia.xhtml";
                break;
            case "Aplicação":
                telaAtivo = "vazia.xhtml";
                break;
        }
    }

    public void mostraTipoEmpretimo(){
        if (tipoEmprestimo.equals("1")){
            telaEmprestimo = "infotomando.xhtml";
        } else {
            telaEmprestimo = "emprestando.xhtml";
        }
    }
    public void mostraTipoFinanciamento(){
        if (tipoFinanciamento.equals("1")){
            telaFinanciamento = "ativo.xhtml";
        } else {
            telaFinanciamento = "escolhebem.xhtml";
        }
    }
}
