/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Locale;

/**
 * Definição de váriavies para visualização no modo web.
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "beanVar")
public class BeanVar implements Serializable{
    
    private String localizacao;
    private String novaTela;

    public BeanVar() {
        this.localizacao = VarComuns.local();
        this.novaTela = "WEB-INF/templates/login.xhtml";
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
    
}
    