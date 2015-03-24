/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.EjbMap;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnUsuario;
import br.com.ln.financiers.LnMenuModel;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
        if (VarComuns.strDbName != null) {
            if (usuario != null && senha != null) {
                lnUsuario = EjbMap.grabUsuario(usuario, VarComuns.strDbName);
                if (lnUsuario != null) {
                    if (!lnUsuario.getUsuStSenha().equals(senha)) {
                        lnUsuario = null;
                        mensagem = "Usuario ou senha invalido";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e Senha", mensagem));
                    } else {
                        VarComuns.lnUsusario = lnUsuario;
                        LnMenuModel lnMenuModel = new LnMenuModel(lnUsuario, VarComuns.strDbName); 
                        model = lnMenuModel.getModel();
                        if (model != null && model.getElements().size() > 0) {
                            beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
                            LnHistorico lnHistorico = new LnHistorico(Postgress.grabLnHistoricoNextId(), new Integer("0"), Postgress.grabDateFromDB(), usuario, "Acesso ao Sistema");
                            Postgress.saveObject(lnHistorico);
                        } else {
                            lnUsuario =  null;
                            beanVar.setNovaTela("WEB-INF/templates/login.xhtml");
                            mensagem = "Ocorreu um problema na montagem do Menu. Favor entrar em contato como Administrador";
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login/Menu", mensagem));
                        }
                    }
                } else{
                    System.out.println("Ocorreu um problema na autenciacao do sistema - Favor entrar em contato como o Administrador.");
                }
            } else {
                mensagem = "Usuario ou senha em Branco.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e Senha", mensagem));
            }
        }
    }
   
    public void logout() { 

        cleanUpEveryThing();

        try {
            FacesContext externalcontext = FacesContext.getCurrentInstance();
            externalcontext.getExternalContext().redirect("/financiers/encerra.ln");
        } catch (Exception ex) {
        } finally {

        }
    }

    private void cleanUpEveryThing() {
        this.lnUsuario = null;
    }    
}
