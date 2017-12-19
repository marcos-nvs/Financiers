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
import br.com.ln.dao.PerfilDao;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.funcao.UsuarioFuncoes;
import br.com.ln.tipos.TipoFuncao;
import br.com.ln.financiers.TratamentoEspecial;
import br.com.ln.dao.UsuarioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
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
    private String cpf;
    private Integer dependente;
    private final TratamentoEspecial tratamentoEspecial;
    private final UsuarioFuncoes usuarioFuncoes;
    
    private boolean bAtivo = false;
    private boolean bAlteraSenha = false;
    private boolean bExpiraSenha = false;
    
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    Logger logger = Logger.getLogger(UsuarioView.class);
    
    public UsuarioView() {
        listPerfil = PerfilDao.grabListPerfilAtivo('S');
        listUsuario = UsuarioDao.grabListUsuarioCliente(VarComuns.lnCliente.getCliInCodigo());
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        lnUsuario = new LnUsuario();
        tratamentoEspecial = new TratamentoEspecial();
        usuarioFuncoes = new UsuarioFuncoes();
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
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Integer getDependente() {
        return dependente;
    }
    
    public void setDependente(Integer dependente) {
        this.dependente = dependente;
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
        return Objects.equals(this.usuario, other.usuario);
    }
    
    @Override
    public String toString() {
        return "UsuarioView{" + "usuario=" + usuario + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dia=" + dia + ", dtExpira=" + dtExpira + ", dtCadastro=" + dtCadastro + ", perfil=" + perfil + '}';
    }
    
    public void btIncluir() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            listPerfil = PerfilDao.grabListPerfilAtivo('S');
            beanVar.setApresenta(true);
            beanVar.setBloquear(false);
            dataClean();
            lnUsuario = new LnUsuario();
            lnUsuario.setTipoFuncao(TipoFuncao.Incluir);
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.texto.usuario"), mensagem));
        }
    }
    
    public void btAlterar() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                listPerfil = PerfilDao.grabListPerfilAtivo('S');
                beanVar.setApresenta(true);
                beanVar.setBloquear(true);
                dataLoadVar();
                lnUsuario.setTipoFuncao(TipoFuncao.Alterar);
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("ln.texto.usuario"), mensagem));
        }
    }
    
    public void btExcluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            try {
                if (lnUsuario != null && !lnUsuario.getUsuStCodigo().isEmpty()) {
                    lnUsuario.setTipoFuncao(TipoFuncao.Excluir);
                    usuarioFuncoes.gravaUsuario(lnUsuario);
                    listUsuario = UsuarioDao.grabListObject(LnUsuario.class);
                    beanVar.setApresenta(true);
                    mensagem = usuarioFuncoes.mensagem;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            bundle.getString("ln.texto.usuario"), mensagem));
                } else {
                    mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            bundle.getString("ln.texto.usuario"), mensagem));
                }
            } catch (NullPointerException ex) {
                mensagem = bundle.getString("ln.mb.frase.problema");
                logger.error(mensagem + " : " + ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.texto.usuario"), mensagem));
        }
    }
    
    public void btSalvar() {
        boolean bSalvo;
        dataLoadUsuario();
        
        if (usuarioFuncoes.verificaDadosUsuario(lnUsuario)) {
            bSalvo = usuarioFuncoes.gravaUsuario(lnUsuario);
            mensagem = usuarioFuncoes.mensagem;
            
            if (bSalvo) {
                listUsuario = UsuarioDao.grabListObject(LnUsuario.class);
                dataClean();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
                beanVar.setApresenta(false);
                beanVar.setBloquear(true);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
            }
            
        } else {
            mensagem = usuarioFuncoes.mensagem;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.texto.usuario"), mensagem));
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
                    mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            bundle.getString("ln.texto.usuario"), mensagem));
                }
            } catch (NullPointerException ex) {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
                logger.error("ln.mb.frase.selecionaregistro : " + ex.getMessage());
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.texto.usuario"), mensagem));
        }
    }
    
    public void btVoltar() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
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
        cpf = "";
        dependente = 0;
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
        lnUsuario.setUsuStCpf(tratamentoEspecial.tratamentoCpf(cpf));
        lnUsuario.setCliInCodigo(VarComuns.lnCliente.getCliInCodigo());
        
        if (dependente != null) {
            lnUsuario.setUsuInDependente(dependente);            
        } else {
            lnUsuario.setUsuInDependente(0);
        }
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
        cpf = lnUsuario.getUsuStCpf();
        dependente = lnUsuario.getUsuInDependente();
    }
    
    public void btConfirmaSenha(String tela) {
        if (!novaSenha.equals("")) {
            if (novaSenha.equals(confirmaSenha)) {
                Historico historico = new Historico();
                lnUsuario.setUsuStSenha(novaSenha);
                UsuarioFuncoes usuarioFuncao = new UsuarioFuncoes();
                lnUsuario.setUsuDtExpiracao(usuarioFuncao.calculaDataExpiracao(lnUsuario));
                UsuarioDao.saveOrUpdateObject(lnUsuario);
                
                if (tela.equals("Usuario")) {
                    if (VarComuns.lnUsusario.getUsuStCodigo().equals(lnUsuario.getUsuStCodigo())) {
                        VarComuns.lnUsusario = lnUsuario;
//                        EjbMap.updateUsuario(lnUsuario);
                        historico.gravaHistoricoModulo(bundle.getString("ln.mb.frase.senhausuario") + " " + lnUsuario.getUsuStCodigo() + " - "
                                + lnUsuario.getUsuStNome() + " " + bundle.getString("ln.mb.frase.alterada"));
                        RequestContext.getCurrentInstance().execute("PF('novaSenha').hide()");
                    }
                } else {
                    if (VarComuns.lnUsusario != null) {
                        VarComuns.lnUsusario = lnUsuario;
//                        EjbMap.updateUsuario(lnUsuario);
                    }
                    historico.gravaHistoricoModulo(bundle.getString("ln.mb.frase.senhausuario") + " " + lnUsuario.getUsuStCodigo() + " - "
                            + lnUsuario.getUsuStNome() + " " + bundle.getString("ln.mb.frase.alterada"));
                    RequestContext.getCurrentInstance().execute("PF('senha').hide()");
                }
                mensagem = bundle.getString("ln.mb.frase.senhasucesso");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
            } else {
                mensagem = bundle.getString("ln.mb.frase.senhanaoconfere");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.texto.usuario"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.senhavazia");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.texto.usuario"), mensagem));
        }
    }
    
}
