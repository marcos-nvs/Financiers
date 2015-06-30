/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.ApprovalConnection;
import br.com.ln.comum.BeanVar;
import br.com.ln.comum.Correios;
import br.com.ln.comum.EnderecoCep;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.Utilitarios;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
import br.com.ln.financiers.ClienteFuncoes;
import br.com.ln.financiers.EnderecoFuncoes;
import br.com.ln.financiers.TelefoneFuncoes;
import br.com.ln.financiers.TipoEndereco;
import br.com.ln.financiers.TipoFuncao;
import br.com.ln.financiers.TipoTelefone;
import java.io.Serializable;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
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
@ManagedBean(name = "clienteView")
public class ClienteView implements Serializable {

    private String documento;
    private String nome;
    private String banco;
    private String email;
    private TipoEndereco tipoEndereco;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private TipoTelefone tipoTelefone;
    private String codigoPais;
    private String ddd;
    private String telefone;

    private final BeanVar beanVar;
    private Utilitarios utilitarios;
    private ClienteFuncoes clienteFuncoes;
    private EnderecoFuncoes enderecoFuncoes;
    private TelefoneFuncoes telefoneFuncoes;

    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;

    private String mensagem;

    private List<LnEndereco> listEndereco;
    private List<LnTelefone> listTelefone;

    public ClienteView() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        clienteFuncoes = new ClienteFuncoes();
        enderecoFuncoes = new EnderecoFuncoes();
        telefoneFuncoes = new TelefoneFuncoes();
        listEndereco = new ArrayList<>();
        listTelefone = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LnCliente getLnCliente() {
        return lnCliente;
    }

    public void setLnCliente(LnCliente lnCliente) {
        this.lnCliente = lnCliente;
    }

    public LnEndereco getLnEndereco() {
        return lnEndereco;
    }

    public void setLnEndereco(LnEndereco lnEndereco) {
        this.lnEndereco = lnEndereco;
    }

    public LnTelefone getLnTelefone() {
        return lnTelefone;
    }

    public void setLnTelefone(LnTelefone lnTelefone) {
        this.lnTelefone = lnTelefone;
    }

    public List<LnEndereco> getListEndereco() {
        return listEndereco;
    }

    public void setListEndereco(List<LnEndereco> listEndereco) {
        this.listEndereco = listEndereco;
    }

    public List<LnTelefone> getListTelefone() {
        return listTelefone;
    }

    public void setListTelefone(List<LnTelefone> listTelefone) {
        this.listTelefone = listTelefone;
    }

    public void btIncluirEndereco() {
        lnEndereco = new LnEndereco();
        lnEndereco.setTipoFuncao(TipoFuncao.Incluir);
        RequestContext.getCurrentInstance().execute("PF('DlgEndereco').show()");
    }

    public void btAlterarEndereco() {
        if(lnEndereco != null){
            varLoadEndereco();
            listEndereco.remove(lnEndereco);
            RequestContext.getCurrentInstance().execute("PF('DlgEndereco').show()");
        } else {
            mensagem = "Para alterar é necessário escolher um endereço!!";
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btExcluirEndereco() {
        if(lnEndereco != null){
            listEndereco.remove(lnEndereco);
        } else {
            mensagem = "Para excluir é necessário escolher um endereço!!";
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btSalvarEndereco() {
        dataLoadEndereco();
        mensagem = enderecoFuncoes.validacao(lnEndereco);

        if (mensagem.equals("Sucesso")){
            listEndereco.add(lnEndereco);
            clearVarEndereco();
            RequestContext.getCurrentInstance().execute("PF('DlgEndereco').hide()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btFecharEndereco() {
        RequestContext.getCurrentInstance().execute("PF('DlgEndereco').hide()");
    }

    public void btIncluirTelefone() {
        lnTelefone = new LnTelefone();
        lnTelefone.setTipoFuncao(TipoFuncao.Incluir);
        RequestContext.getCurrentInstance().execute("PF('DlgTelefone').show()");
    }

    public void btAlterarTelefone() {
        if (lnTelefone != null){
            varLoadTelefone();
            listTelefone.remove(lnTelefone);
            RequestContext.getCurrentInstance().execute("PF('DlgTelefone').show()");
        } else {
            mensagem = "Para alterar é necessário escolher um telefone!!";
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btExcluirTelefone() {
        if(lnTelefone != null){
            listTelefone.remove(lnTelefone);
        } else {
            mensagem = "Para excluir é necessário escolher um telefone!!";
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }

    }

    public void btSalvarTelefone() {
        dataLoadTelefone();
        mensagem = telefoneFuncoes.validacao(lnTelefone);
        
        if (mensagem.equals("Sucesso")){
            listTelefone.add(lnTelefone);
            clearVarTelefone();
            RequestContext.getCurrentInstance().execute("PF('DlgTelefone').hide()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));            
        }

    }

    public void btFecharTelefone() {
        RequestContext.getCurrentInstance().execute("PF('DlgTelefone').hide()");
    }

    public void btSalvarCliente() {
        dataLoadCliente();
        if (clienteFuncoes.validacao(lnCliente, listEndereco, listTelefone)){
            
        } else {
            mensagem = clienteFuncoes.mensagem;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btFecharCliente() {
        beanVar.setNovaTela("WEB-INF/templates/login.xhtml");
    }
    
    private void dataLoadCliente(){
        lnCliente = new LnCliente();
        lnCliente.setCliStDocumento(documento);
        lnCliente.setCliStNome(nome);
        lnCliente.setCliStBanco(banco);
        lnCliente.setCliStEmail(email);
        lnCliente.setTipoFuncao(TipoFuncao.Incluir);
        
    }

    private void dataLoadEndereco() {
        tipoLoadEndereco();
        lnEndereco.setEndInCodigo(enderecoFuncoes.calculaCodigo());
        lnEndereco.setEndStEndereco(endereco);
        lnEndereco.setEndStComplemento(complemento);
        lnEndereco.setEndStBairro(bairro);
        lnEndereco.setEndStCidade(cidade);
        lnEndereco.setEndStEstado(estado);
        lnEndereco.setEndStCep(cep);
    }
    
    private void dataLoadTelefone(){
        tipoLoadTelefone();
        lnTelefone.setTelInCodigo(telefoneFuncoes.calculaCodigo());
        lnTelefone.setTelStPais(codigoPais);
        lnTelefone.setTelStDdd(ddd);
        lnTelefone.setTelStTelefone(telefone);
    }
    
    private void clearVarEndereco(){
        tipoEndereco = null;
        endereco = "";
        complemento = "";
        bairro = "";
        cidade = "";
        estado = "";
        cep = "";
    }
    
    private void clearVarTelefone(){
        tipoTelefone = null;
        codigoPais = "";
        ddd ="";
        telefone = "";
    }
    
    private void varLoadEndereco(){
        tipoLoadVarEndereco();
        endereco = lnEndereco.getEndStEndereco();
        complemento = lnEndereco.getEndStComplemento();
        bairro = lnEndereco.getEndStBairro();
        cidade = lnEndereco.getEndStCidade();
        estado = lnEndereco.getEndStEstado();
        cep = lnEndereco.getEndStCep();
    }
    
    private void varLoadTelefone(){
        tipoLoadVarTelefone();
        codigoPais = lnTelefone.getTelStPais();
        ddd = lnTelefone.getTelStDdd();
        telefone = lnTelefone.getTelStTelefone();
    }
    
    private void tipoLoadEndereco(){
        switch (tipoEndereco){
            case Residencial:
                lnEndereco.setEndChTipo('1');
                break;
            case Comercial:
                lnEndereco.setEndChTipo('2');
                break;
            case Cobranca:
                lnEndereco.setEndChTipo('3');
                break;
        }
    }
    
    private void tipoLoadTelefone(){
        switch (tipoTelefone){
            case Residencial:
                lnTelefone.setTelChTipo('1');
                break;
            case Comercial:
                lnTelefone.setTelChTipo('2');
                break;
            case Celular:
                lnTelefone.setTelChTipo('3');
                break;
        }
    }
    
    private void tipoLoadVarEndereco(){
        switch (lnEndereco.getEndChTipo()){
            case '1':
                tipoEndereco = tipoEndereco.Residencial;
                break;
            case '2':
                tipoEndereco = tipoEndereco.Comercial;
                break;
            case '3':
                tipoEndereco = tipoEndereco.Cobranca;
                break;
        }
    }
    
    private void tipoLoadVarTelefone(){
        switch (lnTelefone.getTelChTipo()){
            case '1':
                tipoTelefone = tipoTelefone.Residencial;
                break;
            case '2':
                tipoTelefone = tipoTelefone.Comercial;
                break;
            case '3':
                tipoTelefone = tipoTelefone.Celular;
                break;
        }
    }
    
    public String buscaDescricaoTipoEndereco(Character tipoEndereco){
        return enderecoFuncoes.descricaoTipo(tipoEndereco);
    }
    
    public String buscaDescricaoTipoTelefone(Character tipoTelefone){
        return telefoneFuncoes.descricaoTipo(tipoTelefone);
    }

    static {
        String host = "proxy-sp.dasa.net";
        String port = "3128";
        System.out.println("Using proxy: " + host + ":" + port);
        System.setProperty("http.proxyHost", host);
        System.setProperty("http.proxyPort", port);
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
    }

    public void btPesquisaCEP() {
        try {
            if (ApprovalConnection.getConnectionApproval("http://correiosapi.apphb.com")) {
                if (cep != null) {
                    EnderecoCep enderecoCep;
                    Correios correio = new Correios();
                    enderecoCep = correio.entregaEndereco(cep.replaceAll("-", ""));
                    correio.close();
                    if (enderecoCep != null) {
                        endereco = enderecoCep.getTipoDeLogradouro() + " " + enderecoCep.getLogradouro();
                        bairro = enderecoCep.getBairro();
                        cidade = enderecoCep.getCidade();
                        estado = enderecoCep.getEstado();
                    } else {
                        mensagem = "Cep não localizado!!!";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
                    }
                } else {
                    mensagem = "Cep em branco, por favor entre com o CEP!!!";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
                }
            } else {
                mensagem = "Não foi possível pesquisar o CEP, computador fora da internet ou site indisponível!!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } catch (ConnectException ex) {
            mensagem = "Não foi possível pesquisar o CEP, computador fora da internet ou site indisponível!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

}
