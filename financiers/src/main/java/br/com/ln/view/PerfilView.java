/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.entity.LnPerfil;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "perfilView")
public class PerfilView implements Serializable{
    
    private List<LnPerfil> listPerfil;

    public PerfilView() {
        listPerfil = Postgress.grabListPerfilAtivo('S');
        
    }

    public List<LnPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<LnPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
    
    
    
}
