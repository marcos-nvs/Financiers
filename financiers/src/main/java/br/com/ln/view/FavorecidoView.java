/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.EjbMap;
import br.com.ln.comum.JsfHelper;
import br.com.ln.entity.LnFavorecido;
import br.com.ln.entity.LnTipofavorecido;
import br.com.ln.financiers.TratamentoEspecial;
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
@ManagedBean(name = "favorecidoView")
public class FavorecidoView implements Serializable{
    
    private Integer idFavorecido;
    private String nomeFavorecido;
    private Character ativo;
    private boolean bAtivo;
    private String documento;
    private Integer tipoFavorecido;
    
    private List<LnTipofavorecido> listaTipoFavorecido;
    private List<LnFavorecido> listaFavorecido;
    
    private final TratamentoEspecial tratativa;
    private final BeanVar beanVar;

    public FavorecidoView() {
        tratativa = new TratamentoEspecial();
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public Integer getIdFavorecido() {
        return idFavorecido;
    }

    public void setIdFavorecido(Integer idFavorecido) {
        this.idFavorecido = idFavorecido;
    }

    public String getNomeFavorecido() {
        return nomeFavorecido;
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getTipoFavorecido() {
        return tipoFavorecido;
    }

    public void setTipoFavorecido(Integer tipoFavorecido) {
        this.tipoFavorecido = tipoFavorecido;
    }

    public List<LnTipofavorecido> getListaTipoFavorecido() {
        return listaTipoFavorecido;
    }

    public void setListaTipoFavorecido(List<LnTipofavorecido> listaTipoFavorecido) {
        this.listaTipoFavorecido = listaTipoFavorecido;
    }

    public List<LnFavorecido> getListaFavorecido() {
        return listaFavorecido;
    }

    public void setListaFavorecido(List<LnFavorecido> listaFavorecido) {
        this.listaFavorecido = listaFavorecido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idFavorecido);
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
        final FavorecidoView other = (FavorecidoView) obj;
        if (!Objects.equals(this.idFavorecido, other.idFavorecido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FavorecidoView{" + "idFavorecido=" + idFavorecido + ", nomeFavorecido=" + nomeFavorecido + ", ativo=" + ativo + ", bAtivo=" + bAtivo + ", documento=" + documento + ", tipoFavorecido=" + tipoFavorecido + ", listaTipoFavorecido=" + listaTipoFavorecido + ", listaFavorecido=" + listaFavorecido + ", tratativa=" + tratativa + ", beanVar=" + beanVar + '}';
    }
    
    public void btIncluirFavorecido(){
        
    }
    
    public void btAlterarFavorecido(){
        
    }
    
    public void btExcluirFavorecido(){
        
    }
    
    public void btSalvarFavorecido(){
        
    }
    
    public void btFecharFavorecido(){
        
    }
    
    public String descricaoTipoFavorecido(Integer idTipoFavorecido){
        LnTipofavorecido lnTipofavorecido = EjbMap.grabTipofavorecido(idTipoFavorecido);
        return lnTipofavorecido.getTfaStDescricao();
    }
}
