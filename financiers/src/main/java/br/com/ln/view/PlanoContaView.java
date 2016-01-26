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
import br.com.ln.dao.PlanoContaDao;
import br.com.ln.entity.LnCategoria;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.entity.LnTipotabela;
import br.com.ln.funcao.PlanoContaFuncoes;
import br.com.ln.objeto.AgendaConta;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.ContaDependente;
import java.io.Serializable;
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
@ManagedBean(name = "contaView")
public class PlanoContaView implements Serializable {

    //Variavéis de Tela
    private String tipoAtivo;
    private String tipoEmprestimo;
    private String tipoFinanciamento;
    private boolean bItemAtivoAplicacao;
    private boolean bItemAtivoMovel;
    
    
    private Integer idConta;
    private String nomeConta;
    private Integer idCategoria;
    private Integer idTipoConta;
    private Character ativoConta;
    private boolean bAtivoConta;
    private Character imposto;
    private boolean bImposto;
    private Character calculada;
    private boolean bCalculada;
    private Double percentual;
    private Double limite;
    private Character agendar;
    private boolean bAgendar;

    private Integer idContaDependente;
    private Integer idTabela;
    private Integer ordem;

    private Integer idAgenda;
    private Integer idContaAgendada;
    private Date dtInicio;
    private Date DtFinal;
    private Integer idTipoAgenda;
    private Character ativoDependente;
    private Integer diaVencimento;
    private Character domingo;
    private Character segunda;
    private Character terca;
    private Character quarta;
    private Character quinta;
    private Character sexta;
    private Character sabado;
    private Character avisar;
    private Character porEmail;
    private Integer qtdeRepeticao;

    private Conta conta;
    private ContaDependente contaDependente;
    private AgendaConta agendaConta;
    private List<Conta> listaContas;
    private List<ContaDependente> listaContaDependente;
    private List<AgendaConta> listaAgendaConta;
    private List<LnPlanoconta> listaContaCalculada;

    private LnPlanoconta planoConta;
    private List<LnPlanoconta> listaPlanoConta;
    private List<LnCategoria> listaCategoria;
    private List<LnTipotabela> listaTipoTabela;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    private final PlanoContaFuncoes planoContaFuncoes;
    private final BeanVar beanVar;

    public PlanoContaView() {
        planoContaFuncoes = new PlanoContaFuncoes();
        listaContas = planoContaFuncoes.buscaListaContas();
        listaCategoria = CategoriaDao.grabCategoria('S');
        listaTipoTabela = PlanoContaDao.grabListObject(LnTipotabela.class);
        listaContaCalculada = PlanoContaDao.buscaListaContaDependente('S');
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        tipoEmprestimo = "1";
        tipoFinanciamento = "1";
        mostraTipoEmpretimo();
        mostraTipoFinanciamento();
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

    public Character getAtivoConta() {
        return ativoConta;
    }

    public void setAtivoConta(Character ativoConta) {
        this.ativoConta = ativoConta;
    }

    public boolean isbAtivoConta() {
        return bAtivoConta;
    }

    public void setbAtivoConta(boolean bAtivoConta) {
        this.bAtivoConta = bAtivoConta;
    }

    public boolean isbImposto() {
        return bImposto;
    }

    public void setbImposto(boolean bImposto) {
        this.bImposto = bImposto;
    }

    public boolean isbCalculada() {
        return bCalculada;
    }

    public void setbCalculada(boolean bCalculada) {
        this.bCalculada = bCalculada;
    }

    public boolean isbAgendar() {
        return bAgendar;
    }

    public void setbAgendar(boolean bAgendar) {
        this.bAgendar = bAgendar;
    }

    public Character getImposto() {
        return imposto;
    }

    public void setImposto(Character imposto) {
        this.imposto = imposto;
    }

    public Character getCalculada() {
        return calculada;
    }

    public void setCalculada(Character calculada) {
        this.calculada = calculada;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Character getAgendar() {
        return agendar;
    }

    public void setAgendar(Character agendar) {
        this.agendar = agendar;
    }

    public Integer getIdContaDependente() {
        return idContaDependente;
    }

    public void setIdContaDependente(Integer idContaDependente) {
        this.idContaDependente = idContaDependente;
    }

    public Integer getIdTabela() {
        return idTabela;
    }

    public void setIdTabela(Integer idTabela) {
        this.idTabela = idTabela;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Integer getIdContaAgendada() {
        return idContaAgendada;
    }

    public void setIdContaAgendada(Integer idContaAgendada) {
        this.idContaAgendada = idContaAgendada;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFinal() {
        return DtFinal;
    }

    public void setDtFinal(Date DtFinal) {
        this.DtFinal = DtFinal;
    }

    public Integer getIdTipoAgenda() {
        return idTipoAgenda;
    }

    public void setIdTipoAgenda(Integer idTipoAgenda) {
        this.idTipoAgenda = idTipoAgenda;
    }

    public Character getAtivoDependente() {
        return ativoDependente;
    }

    public void setAtivoDependente(Character ativoDependente) {
        this.ativoDependente = ativoDependente;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Character getDomingo() {
        return domingo;
    }

    public void setDomingo(Character domingo) {
        this.domingo = domingo;
    }

    public Character getSegunda() {
        return segunda;
    }

    public void setSegunda(Character segunda) {
        this.segunda = segunda;
    }

    public Character getTerca() {
        return terca;
    }

    public void setTerca(Character terca) {
        this.terca = terca;
    }

    public Character getQuarta() {
        return quarta;
    }

    public void setQuarta(Character quarta) {
        this.quarta = quarta;
    }

    public Character getQuinta() {
        return quinta;
    }

    public void setQuinta(Character quinta) {
        this.quinta = quinta;
    }

    public Character getSexta() {
        return sexta;
    }

    public void setSexta(Character sexta) {
        this.sexta = sexta;
    }

    public Character getSabado() {
        return sabado;
    }

    public void setSabado(Character sabado) {
        this.sabado = sabado;
    }

    public Character getAvisar() {
        return avisar;
    }

    public void setAvisar(Character avisar) {
        this.avisar = avisar;
    }

    public Character getPorEmail() {
        return porEmail;
    }

    public void setPorEmail(Character porEmail) {
        this.porEmail = porEmail;
    }

    public Integer getQtdeRepeticao() {
        return qtdeRepeticao;
    }

    public void setQtdeRepeticao(Integer qtdeRepeticao) {
        this.qtdeRepeticao = qtdeRepeticao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ContaDependente getContaDependente() {
        return contaDependente;
    }

    public void setContaDependente(ContaDependente contaDependente) {
        this.contaDependente = contaDependente;
    }

    public AgendaConta getAgendaConta() {
        return agendaConta;
    }

    public void setAgendaConta(AgendaConta agendaConta) {
        this.agendaConta = agendaConta;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public List<ContaDependente> getListaContaDependente() {
        return listaContaDependente;
    }

    public void setListaContaDependente(List<ContaDependente> listaContaDependente) {
        this.listaContaDependente = listaContaDependente;
    }

    public List<AgendaConta> getListaAgendaConta() {
        return listaAgendaConta;
    }

    public void setListaAgendaConta(List<AgendaConta> listaAgendaConta) {
        this.listaAgendaConta = listaAgendaConta;
    }

    public List<LnCategoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<LnCategoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<LnTipotabela> getListaTipoTabela() {
        return listaTipoTabela;
    }

    public void setListaTipoTabela(List<LnTipotabela> listaTipoTabela) {
        this.listaTipoTabela = listaTipoTabela;
    }

    public List<LnPlanoconta> getListaContaCalculada() {
        return listaContaCalculada;
    }

    public void setListaContaCalculada(List<LnPlanoconta> listaContaCalculada) {
        this.listaContaCalculada = listaContaCalculada;
    }

    public String getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(String tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
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

    public boolean isbItemAtivoAplicacao() {
        return bItemAtivoAplicacao;
    }

    public void setbItemAtivoAplicacao(boolean bItemAtivoAplicacao) {
        this.bItemAtivoAplicacao = bItemAtivoAplicacao;
    }

    public boolean isbItemAtivoMovel() {
        return bItemAtivoMovel;
    }

    public void setbItemAtivoMovel(boolean bItemAtivoMovel) {
        this.bItemAtivoMovel = bItemAtivoMovel;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idConta);
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
        final PlanoContaView other = (PlanoContaView) obj;
        if (!Objects.equals(this.idConta, other.idConta)) {
            return false;
        }
        return true;
    }

    public void btIncluirConta() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            clearVarConta();
            clearVarContaDepdente();
            clearVarAgendaConta();
            conta = new Conta();
            contaDependente = new ContaDependente();
            agendaConta = new AgendaConta();
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
        idConta = null;
        nomeConta = null;
        ativoConta = null;
        imposto = null;
        calculada = null;
        agendaConta = null;
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
                beanVar.setTelaConta("../cadastro/planocontas/ativo.xhtml");
                bItemAtivoAplicacao = false;
                bItemAtivoMovel = false;
                break;
            case 2:
                beanVar.setTelaConta("../cadastro/planocontas/vazia.xhtml");
                break;
            case 3:
                beanVar.setTelaConta("../cadastro/planocontas/banco.xhtml");
                break;
            case 4:
                beanVar.setTelaConta("../cadastro/planocontas/cartaocredito.xhtml");
                break;
            case 5:
                beanVar.setTelaConta("../cadastro/planocontas/vazia.xhtml");
                break;
            case 6:
                beanVar.setTelaConta("../cadastro/planocontas/emprestimo.xhtml");
                break;
            case 7:
                beanVar.setTelaConta("../cadastro/planocontas/financiamento.xhtml");
                bItemAtivoAplicacao = true;
                bItemAtivoMovel = true;
                break;
            case 8:
                beanVar.setTelaConta("../cadastro/planocontas/vazia.xhtml");
                break;
            case 9:
                beanVar.setTelaConta("../cadastro/planocontas/receitas.xhtml");
                break;
            case 10:
                beanVar.setTelaConta("../cadastro/planocontas/despesas.xhtml");
                break;
            case 11:
                beanVar.setTelaConta("../cadastro/planocontas/vazia.xhtml");
                break;
            case 12:
                beanVar.setTelaConta("../cadastro/planocontas/vazia.xhtml");
                break;
        }

    }

    private void getTipoContaPorCategoria(Integer categoria) {
        idTipoConta = CategoriaDao.grabTipoContaPorCategoria(categoria);
    }

    public void mostrarAgendamento() {
        if (bAgendar) {
            beanVar.setTelaAgenda("../cadastro/planocontas/agendamento.xhtml");
        } else {
            beanVar.setTelaAgenda("../cadastro/planocontas/vazia.xhtml");
        }
    }
    
    public void mostraCalculoConta(){
        if (bCalculada){
            beanVar.setTelaCalculada("../cadastro/planocontas/contacalculada.xhtml");
        } else {
            beanVar.setTelaCalculada("../cadastro/planocontas/vazia.xhtml");
        }
    }
    
    public void mostraAtivo(){
        
       switch (tipoAtivo){
           case "Imóvel":
               beanVar.setTelaAtivo("imovel.xhtml");
               break;
           case "Automóvel":
               beanVar.setTelaAtivo("automovel.xhtml");
               break;
           case "Móvel":
               beanVar.setTelaAtivo("vazia.xhtml");
               break;
           case "Aplicação":
               beanVar.setTelaAtivo("vazia.xhtml");
               break;
               
       }
               
    }
    
    public void mostraTipoEmpretimo(){
        if (tipoEmprestimo.equals("1")){
            beanVar.setTelaEmprestimo("infotomando.xhtml");
        } else {
            beanVar.setTelaEmprestimo("emprestando.xhtml");
        }
    }

    public void mostraTipoFinanciamento(){
        if (tipoFinanciamento.equals("1")){
            beanVar.setTelaFinanciamento("ativo.xhtml");
        } else {
            beanVar.setTelaFinanciamento("escolhebem.xhtml");
        }
    }
}
