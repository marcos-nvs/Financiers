/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnPerfilacessoPK;
import br.com.ln.financiers.PerfilFuncoes;
import br.com.ln.financiers.TipoFuncao;
import br.com.ln.financiers.TratamentoEspecial;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@ManagedBean(name = "perfilView")
public class PerfilView implements Serializable {

    private List<LnPerfil> listPerfil;
    private LnPerfil lnPerfil;
    private LnPerfilacesso lnPerfilacesso;
    private List<LnModulo> listModulo;
    private String perfilDescricao;
    private boolean bAtivo;
    private boolean bAlteraSenha;
    private Integer modInCodigo;
    private boolean bIncluirAcesso;
    private boolean bAlterarAcesso;
    private boolean bExcluirAcesso;
    private boolean bPesquisarAcesso;
    private List<LnPerfilacesso> listPerfilacesso;
    private String mensagem;
    private PerfilFuncoes perfilFuncoes;
    private TratamentoEspecial tratativa;

    public PerfilView() {
        listPerfil = Postgress.grabListObject(LnPerfil.class);
        listaPerfilAcesso();
        listModulo = Postgress.grabListModuloAtivo('S');
        perfilFuncoes = new PerfilFuncoes();
        tratativa = new TratamentoEspecial();
        listPerfilacesso = new ArrayList<>();
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

    public List<LnModulo> getListModulo() {
        return listModulo;
    }

    public void setListModulo(List<LnModulo> listModulo) {
        this.listModulo = listModulo;
    }

    public String getPerfilDescricao() {
        return perfilDescricao;
    }

    public void setPerfilDescricao(String perfilDescricao) {
        this.perfilDescricao = perfilDescricao;
    }

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public boolean isbAlteraSenha() {
        return bAlteraSenha;
    }

    public void setbAlteraSenha(boolean bAlteraSenha) {
        this.bAlteraSenha = bAlteraSenha;
    }
    
    public Integer getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public boolean isbIncluirAcesso() {
        return bIncluirAcesso;
    }

    public void setbIncluirAcesso(boolean bIncluirAcesso) {
        this.bIncluirAcesso = bIncluirAcesso;
    }

    public boolean isbAlterarAcesso() {
        return bAlterarAcesso;
    }

    public void setbAlterarAcesso(boolean bAlterarAcesso) {
        this.bAlterarAcesso = bAlterarAcesso;
    }

    public boolean isbExcluirAcesso() {
        return bExcluirAcesso;
    }

    public void setbExcluirAcesso(boolean bExcluirAcesso) {
        this.bExcluirAcesso = bExcluirAcesso;
    }

    public boolean isbPesquisarAcesso() {
        return bPesquisarAcesso;
    }

    public void setbPesquisarAcesso(boolean bPesquisarAcesso) {
        this.bPesquisarAcesso = bPesquisarAcesso;
    }

    public List<LnPerfilacesso> getListPerfilacesso() {
        return listPerfilacesso;
    }

    public void setListPerfilacesso(List<LnPerfilacesso> listPerfilacesso) {
        this.listPerfilacesso = listPerfilacesso;
    }

    private void listaPerfilAcesso() {
        listPerfil.stream().forEach((perfil) -> {
            perfil.setListPerfilAcesso(Postgress.grabPerfilAcessoperInCodigo(perfil.getPerInCodigo()));
        });
    }

    public String buscaDescModulo(Integer modInCodigo) {
        return VarComuns.mapModulo.get(modInCodigo);
    }

    public void btIncluirPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            lnPerfil = new LnPerfil();
            lnPerfil.setTipoFuncao(TipoFuncao.Incluir);
            lnPerfilacesso = new LnPerfilacesso();
            lnPerfilacesso.setTipoFuncao(TipoFuncao.Incluir);
            RequestContext.getCurrentInstance().execute("PF('PerfilEdit').show()");
        } else {
            mensagem = "Usuario sem perimissao para incluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btAlterarPerfil(){
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')){
            if (lnPerfil != null){
                dataLoadPerfil();
                lnPerfil.setTipoFuncao(TipoFuncao.Alterar);
                RequestContext.getCurrentInstance().execute("PF('PerfilEdit').show()");
            } else {
                mensagem = "Por favor, escolha um perfil para alterar";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Usuario sem perimissao para alterar";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btExcluirPerfil(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnPerfil != null) {
                lnPerfil.setTipoFuncao(TipoFuncao.Excluir);
                lnPerfilacesso.setTipoFuncao(TipoFuncao.Excluir);
            } else {
                mensagem = "Por favor, escolha um perfil para excluir";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Usuario sem perimissao para Excluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btIncluirPerfilAcesso(){
        dataLoadVar();
        
        if (!listPerfilacesso.contains(lnPerfilacesso)) {
            listPerfilacesso.add(lnPerfilacesso);
        } else {
            mensagem = "Modulo já existe";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btGravarPerfilAcesso(){
        
        for (LnPerfilacesso lnPerfilacesso : listPerfilacesso) {
            
            if (lnPerfil.getListPerfilAcesso().contains(lnPerfilacesso)){
                lnPerfil.getListPerfilAcesso().remove(lnPerfilacesso);
            }
            lnPerfil.getListPerfilAcesso().add(lnPerfilacesso);
        }
        mensagem = perfilFuncoes.perfil(lnPerfil);
        
        if (mensagem.equals("Sucesso")) {
            listPerfil = Postgress.grabListObject(LnPerfil.class);
            lnPerfil = new LnPerfil();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            RequestContext.getCurrentInstance().execute("PF('PerfilEdit').hide()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btEditaPerfilAcesso(){
        dataLoadPerfil();
        listPerfilacesso.remove(lnPerfilacesso);
    }
    
    private void dataLoadVar(){
        lnPerfil.setPerStDescricao(perfilDescricao);
        lnPerfil.setPerChAtivo(tratativa.tratamentoTextoCharacter(bAtivo));
        lnPerfil.setPerChAlterasenha(tratativa.tratamentoTextoCharacter(bAlteraSenha));

        LnPerfilacessoPK lnPerfilacessoPK = new LnPerfilacessoPK(0, modInCodigo);
        lnPerfilacesso = new LnPerfilacesso();
        
        lnPerfilacesso.setLnPerfilacessoPK(lnPerfilacessoPK);
        lnPerfilacesso.setPacChIncluir(tratativa.tratamentoTextoCharacter(bIncluirAcesso));
        lnPerfilacesso.setPacChAlterar(tratativa.tratamentoTextoCharacter(bAlterarAcesso));
        lnPerfilacesso.setPacChExcluir(tratativa.tratamentoTextoCharacter(bExcluirAcesso));
        lnPerfilacesso.setPacChPesquisar(tratativa.tratamentoTextoCharacter(bPesquisarAcesso));
    }

    private void dataLoadPerfil(){
        perfilDescricao = lnPerfil.getPerStDescricao();
        bAtivo = tratativa.tratamentoTextoBoolean(lnPerfil.getPerChAtivo());
        bAlteraSenha = tratativa.tratamentoTextoBoolean(lnPerfil.getPerChAlterasenha());

        if (lnPerfilacesso != null) {
            modInCodigo = lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo();
            bIncluirAcesso = tratativa.tratamentoTextoBoolean(lnPerfilacesso.getPacChIncluir());
            bAlterarAcesso = tratativa.tratamentoTextoBoolean(lnPerfilacesso.getPacChAlterar());
            bExcluirAcesso = tratativa.tratamentoTextoBoolean(lnPerfilacesso.getPacChExcluir());
            bPesquisarAcesso = tratativa.tratamentoTextoBoolean(lnPerfilacesso.getPacChPesquisar());
        }
        
        listPerfilacesso = lnPerfil.getListPerfilAcesso();
    }
}
