/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import java.util.Locale;

/**
 * Definição de váriavies para visualização no modo web.
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "beanVar")
public class BeanVar implements Serializable{
    
    private String localizacao;
    private String novaTela;
    private String telaOrigem;
    private String nomeTela;
//    private String telaCalculada;
//    private String telaAgenda;
    private String telaDialog;
//    private String telaEmprestimo;
//    private String telaFinanciamento;
    private String tituloDialog;
    private boolean apresenta;
    private boolean bloquear;
    
    

    public BeanVar() {
        this.localizacao = VarComuns.local();
        this.novaTela = "WEB-INF/templates/usuario/login.xhtml";
        this.nomeTela = "ln.frase.sistemafinanceiro";
        this.tituloDialog = "";
        this.apresenta = false;
        this.bloquear = true;
    }
        
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNovaTela() {
        return novaTela;
    }

    public void setNovaTela(String novaTela) {
        this.novaTela = novaTela;
    }

    public String getNomeTela() {
        return nomeTela;
    }

    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    public boolean getApresenta() {
        return apresenta;
    }

    public void setApresenta(boolean apresenta) {
        this.apresenta = apresenta;
    }

    public boolean isBloquear() {
        return bloquear;
    }

    public void setBloquear(boolean bloquear) {
        this.bloquear = bloquear;
    }

    public String getTelaOrigem() {
        return telaOrigem;
    }

    public void setTelaOrigem(String telaOrigem) {
        this.telaOrigem = telaOrigem;
    }

//    public String getTelaConta() {
//        return telaConta;
//    }
//
//    public void setTelaConta(String telaConta) {
//        this.telaConta = telaConta;
//    }

//    public String getTelaAgenda() {
//        return telaAgenda;
//    }
//
//    public void setTelaAgenda(String telaAgenda) {
//        this.telaAgenda = telaAgenda;
//    }

    public String getTelaDialog() {
        return telaDialog;
    }

    public void setTelaDialog(String telaDialog) {
        this.telaDialog = telaDialog;
    }

    public String getTituloDialog() {
        return tituloDialog;
    }

    public void setTituloDialog(String tituloDialog) {
        this.tituloDialog = tituloDialog;
    }

//    public String getTelaCalculada() {
//        return telaCalculada;
//    }
//
//    public void setTelaCalculada(String telaCalculada) {
//        this.telaCalculada = telaCalculada;
//    }
//
//    public String getTelaAtivo() {
//        return telaAtivo;
//    }
//
//    public void setTelaAtivo(String telaAtivo) {
//        this.telaAtivo = telaAtivo;
//    }

//    public String getTelaEmprestimo() {
//        return telaEmprestimo;
//    }
//
//    public void setTelaEmprestimo(String telaEmprestimo) {
//        this.telaEmprestimo = telaEmprestimo;
//    }
//
//    public String getTelaFinanciamento() {
//        return telaFinanciamento;
//    }
//
//    public void setTelaFinanciamento(String telaFinanciamento) {
//        this.telaFinanciamento = telaFinanciamento;
//    }
    
 }
    