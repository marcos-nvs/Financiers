/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves 
 */

@SessionScoped
@ManagedBean(name="usuarioView")
public class UsuarioView implements Serializable {
    
    private String usuario;
    private String nome;
    private String senha;
    private String email;
    private Character ativo;
    private Integer dia;
    private Character alteraSenha;
    private Character expiraSenha;
    private Date dtExpira;
    private Date dtCadastro;
    private Integer perfil;
    private List<LnPerfil> listPerfil = new ArrayList<>();
    private BeanVar beanVar;
    private List<LnUsuario> listUsuario = new ArrayList<>();
    private String novaSenha;
    private String confirmaSenha;
    private String mensagem;

    public UsuarioView() {
        this.listPerfil = Postgress.grabListPerfilAtivo('S');
        this.listUsuario = Postgress.grabListObject(LnUsuario.class);
        this.beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Character getAlteraSenha() {
        return alteraSenha;
    }

    public void setAlteraSenha(Character alteraSenha) {
        this.alteraSenha = alteraSenha;
    }

    public Character getExpiraSenha() {
        return expiraSenha;
    }

    public void setExpiraSenha(Character expiraSenha) {
        this.expiraSenha = expiraSenha;
    }

    public Date getDtExpira() {
        return dtExpira;
    }

    public void setDtExpira(Date dtExpira) {
        this.dtExpira = dtExpira;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Integer getPerfil() {
        return perfil;
    }

    public void setPerfil(Integer perfil) {
        this.perfil = perfil;
    }

    public List<LnPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<LnPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
    
    public List<LnUsuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<LnUsuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.usuario);
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
        final UsuarioView other = (UsuarioView) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioView{" + "usuario=" + usuario + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", ativo=" + ativo + ", dia=" + dia + ", alteraSenha=" + alteraSenha + ", expiraSenha=" + expiraSenha + ", dtExpira=" + dtExpira + ", dtCadastro=" + dtCadastro + ", perfil=" + perfil + '}';
    }
    
    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            beanVar.setApresenta(true);

        } else {
            mensagem = "Usuário sem perimissão para incluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }
    
    public void btAlterar(){
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            beanVar.setApresenta(true);

        } else {
            mensagem = "Usuário sem perimissão para alterar";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }
    
    public void btDeletar(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            beanVar.setApresenta(true);

        } else {
            mensagem = "Usuário sem perimissão para excluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btSalvar(){
        beanVar.setApresenta(false);
    }
    
    public void btCancelar(){
        beanVar.setApresenta(false);
    }
    
    public void btConfirmaSenha(){
        
    }
    
    
}
