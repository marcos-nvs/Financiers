/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
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
    private LnPerfil lnPerfil;
    private LnPerfilacesso lnPerfilacesso;

    public PerfilView() {
        listPerfil = Postgress.grabListPerfilAtivo('S');
        listaPerfilAcesso();
    }

    public List<LnPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<LnPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public LnPerfil getLnPerfil() {
        return lnPerfil;
    }

    public void setLnPerfil(LnPerfil lnPerfil) {
        this.lnPerfil = lnPerfil;
    }

    public LnPerfilacesso getLnPerfilacesso() {
        return lnPerfilacesso;
    }

    public void setLnPerfilacesso(LnPerfilacesso lnPerfilacesso) {
        this.lnPerfilacesso = lnPerfilacesso;
    }

    private void listaPerfilAcesso() {
        for (LnPerfil perfil : listPerfil) {
            perfil.setListPerfilAcesso(Postgress.grabPerfilAcessoperInCodigo(perfil.getPerInCodigo()));
        }
    }
    
    public String buscaDescModulo(Integer modInCodigo) {
        return VarComuns.mapModulo.get(modInCodigo);
    }

    
}
