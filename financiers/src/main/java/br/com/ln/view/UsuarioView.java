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
import br.com.ln.financiers.FunctionLn;
import br.com.ln.financiers.TipoFuncao;
import br.com.ln.financiers.TratamentoEspecial;
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
import org.primefaces.context.RequestContext;

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
    private Integer dia;
    private Date dtExpira;
    private Date dtCadastro;
    private Integer perfil;
    private List<LnPerfil> listPerfil = new ArrayList<>();
    private BeanVar beanVar;
    private List<LnUsuario> listUsuario = new ArrayList<>();
    private String novaSenha;
    private String confirmaSenha;
    private String mensagem;
    private LnUsuario lnUsuario;
    private TratamentoEspecial tratamentoEspecial;
    private FunctionLn functions;
    
    private boolean bAtivo = false;
    private boolean bAlteraSenha = false;
    private boolean bExpiraSenha = false;

    public UsuarioView() {
        this.listPerfil = Postgress.grabListPerfilAtivo('S');
        this.listUsuario = Postgress.grabListObject(LnUsuario.class);
        this.beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        this.lnUsuario = new LnUsuario();
        tratamentoEspecial = new TratamentoEspecial();
        functions = new FunctionLn();
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

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
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

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
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

    public boolean isbExpiraSenha() {
        return bExpiraSenha;
    }

    public void setbExpiraSenha(boolean bExpiraSenha) {
        this.bExpiraSenha = bExpiraSenha;
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
        return "UsuarioView{" + "usuario=" + usuario + ", nome=" + nome + ", senha=" + senha + ", email=" + email  + ", dia=" + dia + ", dtExpira=" + dtExpira + ", dtCadastro=" + dtCadastro + ", perfil=" + perfil + '}';
    }
    
    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            beanVar.setApresenta(true);
            lnUsuario = new LnUsuario();
            lnUsuario.setTipoFuncao(TipoFuncao.Incluir);
        } else {
            mensagem = "Usuário sem perimissão para incluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }
    
    public void btAlterar(){
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                beanVar.setApresenta(true);
                usuario = lnUsuario.getUsuStCodigo();
                senha = lnUsuario.getUsuStSenha();
                email = lnUsuario.getUsuStEmail();
                bAtivo = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChAtivo());
                bAlteraSenha = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChAlterasenha());
                bExpiraSenha = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChExpirasenha());
                nome = lnUsuario.getUsuStNome();
                perfil = lnUsuario.getPerInCodigo();
                lnUsuario.setTipoFuncao(TipoFuncao.Alterar);
            } else {
                mensagem = "Por favor, escolha um Usuário para alterar.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuário sem perimissão para alterar";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }
    
    public void btDeletar(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            lnUsuario.setTipoFuncao(TipoFuncao.Excluir);
            beanVar.setApresenta(true);
        } else {
            mensagem = "Usuário sem perimissão para excluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btSalvar(){
        mensagem = functions.SaveObject(lnUsuario);
        
        if (mensagem.equals("Sucesso")){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario",mensagem));
            beanVar.setApresenta(false);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario",mensagem));
        }
    }

    public void btCancelar() {
        beanVar.setApresenta(false);
    }

    public void btAlteraSenha() {
        if (VarComuns.lnUsusario.getUsuChAlterasenha().equals('S')) {
            RequestContext.getCurrentInstance().execute("PF('novaSenha').show()");
        } else {
            mensagem = "Usuário sem perimissão para alterar senha";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btConfirmaSenha() {
    }
    
    
}
