/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private boolean apresenta;
    private boolean bloquear;
    
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    

    public BeanVar() {
        this.localizacao = VarComuns.local();
        this.novaTela = "WEB-INF/templates/login.xhtml";
        this.nomeTela = "ln.frase.sistemafinanceiro";
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

    public ResourceBundle getBundle() {
        return bundle;
    }
    
}
    