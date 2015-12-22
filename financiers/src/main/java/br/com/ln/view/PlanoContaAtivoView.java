/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.dao.PlanoContaAtivoDao;
import br.com.ln.entity.LnTipoativo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "ativoView")
public class PlanoContaAtivoView implements Serializable{
    
    private Integer idTipoAtivo;
    private String descricao;
    private LnTipoativo lnTipoativo;
    private List<LnTipoativo> listaAtivo;

    
    public PlanoContaAtivoView() {
        listaAtivo = PlanoContaAtivoDao.grabListaTipoAtivo();
    }

    public Integer getIdTipoAtivo() {
        return idTipoAtivo;
    }

    public void setIdTipoAtivo(Integer idTipoAtivo) {
        this.idTipoAtivo = idTipoAtivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LnTipoativo getLnTipoativo() {
        return lnTipoativo;
    }

    public void setLnTipoativo(LnTipoativo lnTipoativo) {
        this.lnTipoativo = lnTipoativo;
    }

    public List<LnTipoativo> getListaAtivo() {
        return listaAtivo;
    }

    public void setListaAtivo(List<LnTipoativo> listaAtivo) {
        this.listaAtivo = listaAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.lnTipoativo);
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
        final PlanoContaAtivoView other = (PlanoContaAtivoView) obj;
        if (!Objects.equals(this.lnTipoativo, other.lnTipoativo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanoContaAtivoView{" + "lnTipoativo=" + lnTipoativo + ", listaAtivo=" + listaAtivo + '}';
    }
    
    
}
