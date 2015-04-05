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
    private String nomeTela;
    private boolean apresenta;

    public BeanVar() {
        this.localizacao = VarComuns.local();
        this.novaTela = "WEB-INF/templates/login.xhtml";
        this.apresenta = false;
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
    
}
    