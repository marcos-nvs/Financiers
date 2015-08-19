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
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnFavorecido;
import br.com.ln.entity.LnTelefone;
import br.com.ln.entity.LnTipofavorecido;
import br.com.ln.financiers.TratamentoEspecial;
import br.com.ln.tipos.TipoFuncao;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

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
    
    private LnFavorecido lnFavorecido;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;
    
    private String mensagem;
    private List<LnTipofavorecido> listaTipoFavorecido;
    private List<LnFavorecido> listaFavorecido;
    private List<LnEndereco> listaEndereco;
    private List<LnTelefone> listaTelefone;
    
    private final TratamentoEspecial tratativa;
    private final BeanVar beanVar;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    
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

    public LnFavorecido getLnFavorecido() {
        return lnFavorecido;
    }

    public void setLnFavorecido(LnFavorecido lnFavorecido) {
        this.lnFavorecido = lnFavorecido;
    }

    public LnEndereco getLnEndereco() {
        return lnEndereco;
    }

    public void setLnEndereco(LnEndereco lnEndereco) {
        this.lnEndereco = lnEndereco;
    }

    public LnTelefone getLnTelefone() {
        return lnTelefone;
    }

    public void setLnTelefone(LnTelefone lnTelefone) {
        this.lnTelefone = lnTelefone;
    }

    public List<LnEndereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<LnEndereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public List<LnTelefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<LnTelefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
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
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            lnFavorecido = new LnFavorecido();
            lnFavorecido.setTipoFuncao(TipoFuncao.Incluir);
            RequestContext.getCurrentInstance().execute("PF('favorecido').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.favorecido"), mensagem));
        }
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
