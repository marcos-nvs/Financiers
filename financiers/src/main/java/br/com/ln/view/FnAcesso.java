/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.Historico;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.Utilitarios;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.ClienteDao;
import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnUsuario;
import br.com.ln.financiers.LnMenuModel;
import br.com.ln.financiers.TratamentoEspecial;
import br.com.ln.funcao.UsuarioFuncoes;
import br.com.ln.dao.GenericDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnCliente;
import java.io.Serializable;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "financiersView")
public class FnAcesso implements Serializable {

    private String documento;
    private String usuario;
    private String senha;
    private String rusuario;
    private String rsenha;
    private String novaSenha;
    private String confirmaSenha;

    private String mensagem;
    private LnUsuario lnUsuario;
    private LnCliente lnCliente;
    private BeanVar beanVar;
    private MenuModel model;
    private String cpf;
    private final TratamentoEspecial tratamentoEspecial;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    Logger logger = Logger.getLogger(FnAcesso.class);

    public FnAcesso() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
        tratamentoEspecial = new TratamentoEspecial();
        logger.info("Inicializando  FnAcesso");
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRusuario() {
        return rusuario;
    }

    public void setRusuario(String rusuario) {
        this.rusuario = rusuario;
    }

    public String getRsenha() {
        return rsenha;
    }

    public void setRsenha(String rsenha) {
        this.rsenha = rsenha;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
    }

    public BeanVar getBeanVar() {
        return beanVar;
    }

    public void setBeanVar(BeanVar beanVar) {
        this.beanVar = beanVar;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.mensagem);
        hash = 67 * hash + Objects.hashCode(this.lnUsuario);
        hash = 67 * hash + Objects.hashCode(this.beanVar);
        hash = 67 * hash + Objects.hashCode(this.model);
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
        final FnAcesso other = (FnAcesso) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.lnUsuario, other.lnUsuario)) {
            return false;
        }
        if (!Objects.equals(this.beanVar, other.beanVar)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FnAcesso{" + "usuario=" + usuario + ", senha=" + senha + ", mensagem=" + mensagem + ", lnUsuario=" + lnUsuario + ", beanVar=" + beanVar + ", model=" + model + '}';
    }

    public void sistemaLogin() {
        RequestContext.getCurrentInstance().execute("PF('statusDialog').show()");
        if (VarComuns.strDbName != null) {
            if (usuario != null && senha != null) {
                lnUsuario = UsuarioDao.grabUsuario(usuario, 'S');
                if (lnUsuario != null) {
                    lnCliente = ClienteDao.grabClienteCodigo(lnUsuario.getCliInCodigo());
                    VarComuns.lnCliente = lnCliente;
                    if (lnUsuario != null) {
                        if (!lnUsuario.getUsuStSenha().equals(senha)) {
                            lnUsuario = null;
                            mensagem = bundle.getString("ln.mb.frase.usuarioinvalido");
                            RequestContext.getCurrentInstance().execute("PF('statusDialog').hide()");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                        } else {
                            UsuarioFuncoes usuarioFuncoes = new UsuarioFuncoes();
                            if (usuarioFuncoes.verificaExpiracaoSenha(lnUsuario)) {
                                VarComuns.strDbName = lnCliente.getCliStBanco();
                                VarComuns.lnUsusario = lnUsuario;
                                LnMenuModel lnMenuModel = new LnMenuModel(lnUsuario, VarComuns.strDbName);
                                model = lnMenuModel.getModel();
                                if (model != null && model.getElements().size() > 0) {
                                    beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
                                    LnHistorico lnHistorico = new LnHistorico(new Integer("0"), GenericDao.grabDateFromDB(), usuario,
                                            bundle.getString("ln.mb.historico.acessosistema"));
                                    GenericDao.saveObject(lnHistorico);
                                } else {
                                    lnUsuario = null;
                                    beanVar.setNovaTela("WEB-INF/templates/usuario/login.xhtml");
                                    mensagem = bundle.getString("ln.mb.frase.problemamenu");
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                                }
                            } else {
                                lnUsuario = null;
                                beanVar.setNovaTela("WEB-INF/templates/usuario/login.xhtml");
                                mensagem = bundle.getString("ln.mb.titulo.senhaexpira");
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                        bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                            }
                        }
                    } else {
                        mensagem = bundle.getString("ln.mb.frase.autenticacaoproblema");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                    }
                } else {
                    mensagem = bundle.getString("ln.mb.frase.usuarioinvalido");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                }
            } else {
                mensagem = bundle.getString("ln.mb.frase.usuariobranco");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
            }
        }
        RequestContext.getCurrentInstance().execute("PF('statusDialog').hide()");
        }

    public void logout() {

        cleanUpEveryThing();

        try {
            FacesContext externalcontext = FacesContext.getCurrentInstance();
            externalcontext.getExternalContext().redirect("/financiers/encerra.ln");
        } catch (Exception ex) {
            logger.error(ex);
        } finally {

        }
    }

    private void cleanUpEveryThing() {
        this.lnUsuario = null;
    }

    public void recuperaAcesso() {
        beanVar.setNovaTela("WEB-INF/templates/usuario/recuperaacesso.xhtml");
        beanVar.setNomeTela("ln.frase.recuperaaceso");
    }

    public void cadastroCliente() {
        beanVar.setTelaOrigem("WEB-INF/templates/usuario/login.xhtml");
        beanVar.setNovaTela("WEB-INF/templates/usuario/cliente.xhtml");
        beanVar.setNomeTela("ln.texto.cadastrocliente");
    }

    public void btVoltar() {
        beanVar.setNovaTela("WEB-INF/templates/usuario/login.xhtml");
        beanVar.setNomeTela("ln.frase.sistemafinanceiro");
    }

    public void btEnviaEmailAcesso() {
        lnUsuario = UsuarioDao.grabUsuario(usuario);

        if (lnUsuario != null) {
            try {
                cpf = tratamentoEspecial.tratamentoCpf(cpf);

                if (Utilitarios.calculaCPF(cpf)) {
                    if (lnUsuario.getUsuStCpf().equals(cpf)) {
                        SimpleEmail email = new SimpleEmail();
                        email.setHostName("mail.dasa.com.br");
                        email.addTo(lnUsuario.getUsuStEmail(), lnUsuario.getUsuStNome());
                        email.setFrom("marcos.naves@dasa.com.br");
                        email.setSubject(bundle.getString("ln.frase.recuperaaceso"));
                        email.setMsg(bundle.getString("ln.mb.texto.recuperaacesso") + lnUsuario.getUsuStSenha());
                        email.send();

                        lnUsuario = null;
                        mensagem = bundle.getString("ln.mb.texto.enviaemail");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                        beanVar.setNovaTela("WEB-INF/templates/usuario/usuario/login.xhtml");
                        beanVar.setNomeTela("ln.frase.sistemafinanceiro");

                    } else {
                        lnUsuario = null;
                        beanVar.setNovaTela("WEB-INF/templates/usuario/recuperaacesso.xhtml");
                        beanVar.setNomeTela(bundle.getString("ln.frase.recuperaaceso"));
                        mensagem = bundle.getString("ln.mb.texto.usuarionaoencontradobase");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                    }
                } else {
                    lnUsuario = null;
                    beanVar.setNovaTela("WEB-INF/templates/usuario/recuperaacesso.xhtml");
                    beanVar.setNomeTela(bundle.getString("ln.frase.recuperaaceso"));
                    mensagem = bundle.getString("ln.mb.frase.invalidocpf");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                }
            } catch (EmailException ex) {
                lnUsuario = null;
                beanVar.setNovaTela("WEB-INF/templates/usuario/login.xhtml");
                beanVar.setNomeTela("ln.frase.sistemafinanceiro");
                mensagem = bundle.getString("ln.mb.frase.emailcomproblema") + " " + ex.getMessage();
                logger.error(mensagem);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
            } catch (NumberFormatException ex) {
                lnUsuario = null;
                beanVar.setNovaTela("WEB-INF/templates/usuario/recuperaacesso.xhtml");
                beanVar.setNomeTela(bundle.getString("ln.frase.recuperaaceso"));
                mensagem = bundle.getString("ln.mb.frase.emailcomproblema");
                logger.error(mensagem);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
            }
        } else {
            lnUsuario = null;
            mensagem = bundle.getString("ln.mb.texto.usuarionaoencontradobase");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
            beanVar.setNovaTela("WEB-INF/templates/usuario/recuperaacesso.xhtml");
            beanVar.setNomeTela("ln.frase.recuperaaceso");
        }
    }

    public void btConfirmaSenha() {
        if (documento != null && !documento.isEmpty()) {
            UsuarioFuncoes usuarioFuncao = new UsuarioFuncoes();
            lnUsuario = UsuarioDao.grabUsuarioDocumento(documento);
            if (lnUsuario != null) {
                if (lnUsuario.getUsuStSenha().equals(rsenha)) {
                    if (!novaSenha.equals("")) {
                        if (novaSenha.equals(confirmaSenha)) {
                            Historico historico = new Historico();
                            lnUsuario.setUsuStSenha(novaSenha);
                            lnUsuario.setUsuDtExpiracao(usuarioFuncao.calculaDataExpiracao(lnUsuario));
                            UsuarioDao.saveOrUpdateObject(lnUsuario);
                            VarComuns.lnUsusario = lnUsuario;
                            historico.gravaHistorico(lnUsuario, bundle.getString("ln.mb.frase.senhausuario") + " " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome() + " "
                                    + bundle.getString("ln.mb.frase.alterada"));
                            RequestContext.getCurrentInstance().execute("PF('senha').hide()");
                            mensagem = bundle.getString("ln.mb.frase.senhasucesso");
                            rusuario = null;
                            rsenha = null;
                            lnUsuario = new LnUsuario();
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                        } else {
                            mensagem = bundle.getString("ln.mb.frase.senhanaoconfere");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                        }
                    } else {
                        mensagem = bundle.getString("ln.mb.frase.senhavazia");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                    }
                } else {
                    mensagem = bundle.getString("ln.mb.frase.usuarioinvalido");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
                }
            } else {
                mensagem = bundle.getString("ln.mb.texto.usuarionaoencontradobase");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
            }
        } else {
            mensagem = "Por favor, entre com o documento (CPF)!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    bundle.getString("ln.mb.titulo.usuariosenha"), mensagem));
        }
    }

    public void btFechaTroca() {
        lnUsuario = null;
        RequestContext.getCurrentInstance().execute("PF('senha').hide()");
    }

}
