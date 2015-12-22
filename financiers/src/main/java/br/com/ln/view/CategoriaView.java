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
import br.com.ln.dao.CategoriaDao;
import br.com.ln.entity.LnCategoria;
import br.com.ln.entity.LnTipoconta;
import br.com.ln.funcao.CategoriaFuncoes;
import br.com.ln.tipos.TipoFuncao;
import br.com.ln.financiers.TratamentoEspecial;
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
@ManagedBean(name = "categoriaView")
public class CategoriaView implements Serializable {

    private Integer codigo;
    private String descricao;
    private Integer tipo;
    private Character ativo;
    private List<LnCategoria> listCategoria;
    private LnCategoria lnCategoria;
    private boolean bAtivo;
    private String mensagem;
    private final TratamentoEspecial tratativa;
    private final CategoriaFuncoes categoriaFuncoes;
    private List<LnTipoconta> listTipoconta;
    private boolean bTipoConta;
    private final BeanVar beanVar;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public CategoriaView() {
        listCategoria = CategoriaDao.grabListObject(LnCategoria.class);
        listTipoconta = CategoriaDao.grabListObject(LnTipoconta.class);
        tratativa = new TratamentoEspecial();
        categoriaFuncoes = new CategoriaFuncoes();
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public List<LnCategoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<LnCategoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public LnCategoria getLnCategoria() {
        return lnCategoria;
    }

    public void setLnCategoria(LnCategoria lnCategoria) {
        this.lnCategoria = lnCategoria;
    }

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public List<LnTipoconta> getListTipoconta() {
        return listTipoconta;
    }

    public void setListTipoconta(List<LnTipoconta> listTipoconta) {
        this.listTipoconta = listTipoconta;
    }

    public boolean isbTipoConta() {
        return bTipoConta;
    }

    public void setbTipoConta(boolean bTipoConta) {
        this.bTipoConta = bTipoConta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigo);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.tipo);
        hash = 17 * hash + Objects.hashCode(this.ativo);
        hash = 17 * hash + Objects.hashCode(this.listCategoria);
        hash = 17 * hash + Objects.hashCode(this.lnCategoria);
        hash = 17 * hash + (this.bAtivo ? 1 : 0);
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
        final CategoriaView other = (CategoriaView) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.listCategoria, other.listCategoria)) {
            return false;
        }
        if (!Objects.equals(this.lnCategoria, other.lnCategoria)) {
            return false;
        }
        if (this.bAtivo != other.bAtivo) {
            return false;
        }
        return true;
    }

    public void btIncluirCategoria() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            clearVarCategoria();
            lnCategoria = new LnCategoria();
            lnCategoria.setTipoFuncao(TipoFuncao.Incluir);
            bTipoConta = false;
            beanVar.setTelaDialog("WEB-INF/templates/dialog/dialogcategoria.xhtml");
            RequestContext.getCurrentInstance().execute("PF('dialog').show()");
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.categoria"), mensagem));
        }
    }

    public void btAlterarCategoria() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (lnCategoria != null) {
                lnCategoria.setTipoFuncao(TipoFuncao.Alterar);
                bTipoConta = true;
                beanVar.setTelaDialog("WEB-INF/templates/dialog/dialogcategoria.xhtml");
                RequestContext.getCurrentInstance().execute("PF('dialog').show()");
                loadDataVar();
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.categoria"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.categoria"), mensagem));
        }
    }

    public void btExcluirCategoria() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnCategoria != null) {
                lnCategoria.setTipoFuncao(TipoFuncao.Excluir);

                if (categoriaFuncoes.categoria(lnCategoria)) {
                    listCategoria = CategoriaDao.grabListObject(LnCategoria.class);
                    mensagem = categoriaFuncoes.mensagem;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            bundle.getString("ln.mb.titulo.categoria"), mensagem));
                }
            } else {
                mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.categoria"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.permissao");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.categoria"), mensagem));
        }
    }

    public void btSalvarCategoria() {
        if (descricao != null && !descricao.equals("")) {
            dataLoadVar();

            if (categoriaFuncoes.categoria(lnCategoria)) {
                listCategoria = CategoriaDao.grabListObject(LnCategoria.class);
                RequestContext.getCurrentInstance().execute("PF('dialog').hide()");
                listCategoria = CategoriaDao.grabListObject(LnCategoria.class);
                mensagem = categoriaFuncoes.mensagem;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.categoria"), mensagem));
            } else {
                mensagem = categoriaFuncoes.mensagem;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.categoria"), mensagem));
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.selecionaregistro");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.categoria"), mensagem));
        }
    }

    public void btCancelarCategoria() {
        RequestContext.getCurrentInstance().execute("PF('dialog').hide()");
    }

    private void dataLoadVar() {
        lnCategoria.setCatStDescricao(descricao);
        lnCategoria.setTipInCodigo(tipo);
        lnCategoria.setCatChAtivo(tratativa.tratamentoTextoCharacter(bAtivo));
    }

    private void loadDataVar() {
        descricao = lnCategoria.getCatStDescricao();
        tipo = lnCategoria.getTipInCodigo();
        bAtivo = tratativa.tratamentoTextoBoolean(lnCategoria.getCatChAtivo());
        ativo = lnCategoria.getCatChAtivo();
    }

    public String tipoContaDescricao(Integer tipInCodigo) {
        LnTipoconta lnTipoconta = EjbMap.grabTipoConta(tipInCodigo);
        return lnTipoconta.getTipStDescricao();
    }

    private void clearVarCategoria() {
        descricao = null;
        tipo = null;
        bAtivo = false;
    }

    public void btVoltar() {
        beanVar.setNovaTela("WEB-INF/templates/principal.xhtml");
    }
}
