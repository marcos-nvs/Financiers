/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnUsuario;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "financiersView")
public class FnAcesso implements Serializable {

    private String usuario;
    private String senha;
    private String mensagem;
    private LnUsuario lnUsuario;
    private BeanVar beanVar;
    private MenuModel model;

    public FnAcesso() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
    }

    public BeanVar getBeanVar() {
        return beanVar;
    }

    public void setBeanVar(BeanVar beanVar) {
        this.beanVar = beanVar;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.mensagem);
        hash = 67 * hash + Objects.hashCode(this.lnUsuario);
        hash = 67 * hash + Objects.hashCode(this.beanVar);
        hash = 67 * hash + Objects.hashCode(this.model);
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
        final FnAcesso other = (FnAcesso) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.lnUsuario, other.lnUsuario)) {
            return false;
        }
        if (!Objects.equals(this.beanVar, other.beanVar)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FnAcesso{" + "usuario=" + usuario + ", senha=" + senha + ", mensagem=" + mensagem + ", lnUsuario=" + lnUsuario + ", beanVar=" + beanVar + ", model=" + model + '}';
    }

    public void sistemaLogin() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }
}
