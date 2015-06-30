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

    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;

    private String mensagem;

    private List<LnEndereco> listEndereco = new ArrayList<LnEndereco>();
    private List<LnTelefone> listTelefone = new ArrayList<LnTelefone>();

    public ClienteView() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
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
        listEndereco.clear();
        RequestContext.getCurrentInstance().execute("PF('DlgEndereco').show()");
    }

    public void btAlterarEndereco() {

    }

    public void btExcluirEndereco() {

    }

    public void btSalvarEndereco() {
        dataLoadEndereco();

    }

    public void btFecharEndereco() {
        RequestContext.getCurrentInstance().execute("PF('DlgEndereco').hide()");
    }

    public void btIncluirTelefone() {
        RequestContext.getCurrentInstance().execute("PF('DlgTelefone').show()");
    }

    public void btAlterarTelefone() {

    }

    public void btExcluirTelefone() {

    }

    public void btSalvarTelefone() {

    }

    public void btFecharTelefone() {
        RequestContext.getCurrentInstance().execute("PF('DlgTelefone').hide()");
    }

    public void btSalvarCliente() {

    }

    public void btFecharCliente() {
        beanVar.setNovaTela("WEB-INF/templates/login.xhtml");
    }

    private void dataLoadEndereco() {
        lnEndereco.setEndStEndereco(endereco);
        lnEndereco.setEndStBairro(bairro);
        lnEndereco.setEndStCidade(cidade);
        lnEndereco.setEndStEstado(estado);
        lnEndereco.setEndStCep(cep);
    }

//    static {
//        String host = "proxy-sp.dasa.net";
//        String port = "3128";
//        System.out.println("Using proxy: " + host + ":" + port);
//        System.setProperty("http.proxyHost", host);
//        System.setProperty("http.proxyPort", port);
//        System.setProperty("http.proxySet", "true");
//        System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
//    }

    public void btPesquisaCEP() {
        try {
            if (ApprovalConnection.getConnectionApproval("http://correiosapi.apphb.com")) {
                if (cep != null) {
                    EnderecoCep enderecoCep = new EnderecoCep();
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
