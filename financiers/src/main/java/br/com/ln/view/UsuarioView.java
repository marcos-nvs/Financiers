/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.Historico;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.financiers.UsuarioFunctions;
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
@ManagedBean(name = "usuarioView")
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
    private final BeanVar beanVar;
    private List<LnUsuario> listUsuario = new ArrayList<>();
    private String novaSenha;
    private String confirmaSenha;
    private String mensagem;
    private LnUsuario lnUsuario;
    private final TratamentoEspecial tratamentoEspecial;
    private final UsuarioFunctions functions;

    private boolean bAtivo = false;
    private boolean bAlteraSenha = false;
    private boolean bExpiraSenha = false;

    public UsuarioView() {
        listPerfil = Postgress.grabListPerfilAtivo('S');
        listUsuario = Postgress.grabListObject(LnUsuario.class);
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        lnUsuario = new LnUsuario();
        tratamentoEspecial = new TratamentoEspecial();
        functions = new UsuarioFunctions();
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
        return "UsuarioView{" + "usuario=" + usuario + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dia=" + dia + ", dtExpira=" + dtExpira + ", dtCadastro=" + dtCadastro + ", perfil=" + perfil + '}';
    }

    public void btIncluir() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            beanVar.setApresenta(true);
            beanVar.setBloquear(false);
            dataClean();
            lnUsuario = new LnUsuario();
            lnUsuario.setTipoFuncao(TipoFuncao.Incluir);
        } else {
            mensagem = "Usuario sem perimissao para incluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btAlterar() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                beanVar.setApresenta(true);
                beanVar.setBloquear(true);
                dataLoadVar();
                lnUsuario.setTipoFuncao(TipoFuncao.Alterar);
            } else {
                mensagem = "Por favor, escolha um Usuario para alterar.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem perimissao para alterar";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btDeletar() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {

            try {
                if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                    lnUsuario.setTipoFuncao(TipoFuncao.Excluir);
                    functions.usuario(lnUsuario);
                    listUsuario = Postgress.grabListObject(LnUsuario.class);
                    beanVar.setApresenta(true);
                } else {
                    mensagem = "Por favor, escolha um Usuario para excluir.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
                }
            } catch (NullPointerException ex) {
                mensagem = "Por favor, escolha um Usuario para excluir.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem perimissao para excluir";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btSalvar() {
        dataLoadUsuario();
        mensagem = functions.usuario(lnUsuario);

        if (mensagem.equals("Sucesso")) {
            listUsuario = Postgress.grabListObject(LnUsuario.class);
            dataClean();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            beanVar.setApresenta(false);
            beanVar.setBloquear(true);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btCancelar() {
        dataClean();
        beanVar.setApresenta(false);
        beanVar.setBloquear(true);
    }

    public void btAlteraSenha() {
        if (VarComuns.lnUsusario.getUsuChAlterasenha().equals('S')) {
            try {
                if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                    RequestContext.getCurrentInstance().execute("PF('novaSenha').show()");
                } else {
                    mensagem = "Por favor, escolha um usuario para realizar a alteracao!!!";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
                }
            } catch (NullPointerException ex) {
                mensagem = "Por favor, escolha um usuario para realizar a alteracao!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem perimissao para alterar senha";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btConfirmaSenha() {
        if (novaSenha.equals(confirmaSenha)) {
            Historico historico = new Historico();
            lnUsuario.setUsuStSenha(novaSenha);
            Postgress.saveOrUpdateObject(lnUsuario);
            historico.gravaHistorico("Senha do usuário: " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome() + " foi alterada." );
            mensagem = "Senha alterada com sucesso!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        } else {
            mensagem = "Senha nao confere, por favor verifique!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void dataClean() {
        usuario = "";
        senha = "";
        email = "";
        bAtivo = false;
        bAlteraSenha = false;
        bExpiraSenha = false;
        nome = "";
        dia = null;
    }

    public void dataLoadUsuario() {
        lnUsuario.setPerInCodigo(perfil);
        lnUsuario.setUsuChAlterasenha(tratamentoEspecial.tratamentoTextoCharacter(bAlteraSenha));
        lnUsuario.setUsuChAtivo(tratamentoEspecial.tratamentoTextoCharacter(bAtivo));
        lnUsuario.setUsuChExpirasenha(tratamentoEspecial.tratamentoTextoCharacter(bExpiraSenha));
        lnUsuario.setUsuStCodigo(usuario);
        lnUsuario.setUsuStEmail(email);
        lnUsuario.setUsuStNome(nome);
        lnUsuario.setUsuStSenha(senha);
        lnUsuario.setUsuInDia(dia);
    }

    public void dataLoadVar() {
        usuario = lnUsuario.getUsuStCodigo();
        senha = lnUsuario.getUsuStSenha();
        email = lnUsuario.getUsuStEmail();
        bAtivo = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChAtivo());
        bAlteraSenha = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChAlterasenha());
        bExpiraSenha = tratamentoEspecial.tratamentoTextoBoolean(lnUsuario.getUsuChExpirasenha());
        nome = lnUsuario.getUsuStNome();
        perfil = lnUsuario.getPerInCodigo();
        dia = lnUsuario.getUsuInDia();
    }
}
