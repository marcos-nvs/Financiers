/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcos Naves
 */

@ViewScoped
@ManagedBean(name = "defineCaminho")
public class DefineBanco implements Serializable {
    
    private String retorno;

    public DefineBanco() {
        
        VarComuns.strDbName = JsfHelper.getRequestParameter("nome");
        
        if (VarComuns.strDbName == null){
            VarComuns.strDbName = "Public";
        }
    }
    
    public void inicia(){
        retorno = "yes";
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
}
