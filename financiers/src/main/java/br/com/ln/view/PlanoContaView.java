/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.objeto.AgendaConta;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.ContaDependente;
import java.io.Serializable;
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
public class PlanoContaView implements Serializable{
    
    private Integer codigo;
    private String descricao;
    private Character ativo;
    private Character imposto;
    private Character calculada;
    private Character agendada;
    
    private Conta conta;
    private ContaDependente contaDependente;
    private AgendaConta agendaConta;
    private List<Conta> listaContas;
    
    private LnPlanoconta planoConta;
    private List<LnPlanoconta> listaPlanoConta;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public PlanoContaView() {
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
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

    public Character getAgendada() {
        return agendada;
    }

    public void setAgendada(Character agendada) {
        this.agendada = agendada;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codigo);
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
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public void btIncluirConta(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            clearVarConta();
            clearVarContaDepdente();
            clearVarAgendaConta();
            conta = new Conta();
            contaDependente = new ContaDependente();
            agendaConta = new AgendaConta();
            RequestContext.getCurrentInstance().execute("PF('dlgconta').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.tabela"), mensagem));
        }
    }
    
    public void btAlterarConta(){
        
    }
    
    public void btExcluirConta(){
        
    }
    
    public void btVisualizarConta(){
    
    }

    private void clearVarConta() {
        codigo = null;
        descricao = null;
        ativo = null;
        imposto = null;
        calculada = null;
        agendada = null;
    }

    private void clearVarContaDepdente() {
    }

    private void clearVarAgendaConta() {
    }
    
}
