/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.financiers;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.MenuDao;
import br.com.ln.dao.PerfilDao;
import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */

@ManagedBean
public class LnMenuModel implements Serializable {
    
    private MenuModel model;
    private LnUsuario lnUsuario;
    private LnPerfil lnPerfil;
//    private String strDbName;
    private final Map<String, LnPerfilacesso> mapPerfilUsuario = new HashMap<>();
    private BeanVar beanVar;
    Logger logger = Logger.getLogger(LnMenuModel.class);

    public LnMenuModel() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public LnMenuModel(LnUsuario lnUsuario, String strDbName) {
        this.lnUsuario = lnUsuario;
//        this.strDbName = strDbName;
        montaMenu();
    }

    private void montaMenu() {
        menuPerfil();

        List<LnMenu> listMenu = MenuDao.grabMenu('S');

        model = new DefaultMenuModel();
        DefaultSubMenu subMenu;
        DefaultMenuItem item;

        if (listMenu != null && !listMenu.isEmpty()) {

            if (VarComuns.lnUsusario.getUsuChAdmin().equals('S')) {
                model.addElement(clienteControl());
            }
            for (LnMenu lnMenu : listMenu) {
                subMenu = new DefaultSubMenu(lnMenu.getMenStDescricao());
                subMenu.setRendered(false);

                Iterator inIt = lnMenu.getListModulos().iterator();

                while (inIt.hasNext()) {
                    LnModulo lnModulo = (LnModulo) inIt.next();

                    if (!VarComuns.mapModulo.containsKey(lnModulo.getModInCodigo())) {
                        VarComuns.mapModulo.put(lnModulo.getModInCodigo(), lnModulo.getModStDescricao());
                    }

                    if (mapPerfilUsuario.containsKey(Integer.toString(lnModulo.getModInCodigo()))) {
                        item = new DefaultMenuItem(lnModulo.getModStDescricao());
                        item.setTitle(lnModulo.getModStDescricao());
                        item.setCommand("#{lnMenuModel.menuActionClick}");
                        item.setUpdate(":idFormCenter");
                        item.setProcess(":idFormCenter");
                        item.setAjax(false);
                        subMenu.addElement(item);
                        subMenu.setRendered(true);
                        subMenu.setId(Integer.toString(lnModulo.getModInCodigo()));
                    }
                }

                model.addElement(subMenu);
            }
            model.addElement(itemAll());
        } else {
            logger.warn("Nao foi possivel montar o menu. Favor entrar em contato como o Administrador");
        }
    }


    private void menuPerfil() {
        if (lnUsuario != null) {
            lnPerfil = PerfilDao.grabPerfil(lnUsuario.getPerInCodigo(),'S');

            VarComuns.lnPerfil = lnPerfil;
            
            List<LnPerfilacesso> lnPerfilacesso = PerfilDao.grabPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());

            for (LnPerfilacesso perfilAcesso : lnPerfilacesso) {
                String Key = Integer.toString(perfilAcesso.getLnPerfilacessoPK().getModInCodigo());
                if (!mapPerfilUsuario.containsKey(Key)) {
                    mapPerfilUsuario.put(Key, perfilAcesso);
                }
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void menuActionClick(MenuActionEvent menuActionEvent){
        
        if (menuActionEvent != null) {
            String itemMenuClick = menuActionEvent.getMenuItem().getTitle();
            switch (itemMenuClick) {
                case "Cliente":
                    beanVar.setNovaTela("WEB-INF/templates/usuario/clienteadmin.xhtml");
                    beanVar.setNomeTela("ln.texto.cadastrocliente");
//                    VarComuns.lnPerfilacesso = EjbMap.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 1);
                    break;
                case "Usuário":
                    beanVar.setNovaTela("WEB-INF/templates/usuario/usuario.xhtml");
                    beanVar.setNomeTela("ln.mb.titulo.cadastrousuario");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 1);
                    break;
                case "Perfil":
                    beanVar.setNovaTela("WEB-INF/templates/usuario/perfil.xhtml");
                    beanVar.setNomeTela("ln.texto.cadastrodeperfil");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 2);
                    break;
                case "Tabelas":
                    beanVar.setNovaTela("WEB-INF/templates/tabela/tabela.xhtml");
                    beanVar.setNomeTela("ln.texto.tabelacalculo");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 3);
                    break;
                case "Categoria":
                    beanVar.setNovaTela("WEB-INF/templates/cadastro/categoria.xhtml");
                    beanVar.setNomeTela("ln.texto.cadastrodecategoriascontas");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 4);
                    break;
                case "Plano de Contas":
                    beanVar.setNovaTela("WEB-INF/templates/cadastro/planoconta.xhtml");
                    beanVar.setNomeTela("ln.mb.titulo.planoconta");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 5);
                    break;
                case "Favorecidos":
                    beanVar.setNovaTela("WEB-INF/templates/cadastro/favorecido.xhtml");
                    beanVar.setNomeTela("ln.mb.titulo.favorecido");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 6);
                    break;
                case "Orçamento":
                    beanVar.setNovaTela("WEB-INF/templates/cadastro/orcamento.xhtml");
                    beanVar.setNomeTela("Orçamentos");
                    VarComuns.lnPerfilacesso = PerfilDao.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 2);
                    break;
                case "Histórico":
                    beanVar.setNovaTela("WEB-INF/templates/historico.xhtml");
//                    VarComuns.lnPerfilacesso = EjbMap.grabPerfilAcesso(VarComuns.lnPerfil.getPerInCodigo(), 2);
                    break;
            }
        }
    }
    
    public DefaultSubMenu clienteControl(){
        
        DefaultSubMenu subMenu;
        DefaultMenuItem item;
        
        subMenu = new DefaultSubMenu("Administração");
        item = new DefaultMenuItem("Cliente");
        item.setTitle("Cliente");
        item.setCommand("#{lnMenuModel.menuActionClick}");
        item.setUpdate(":idFormCenter");
        item.setProcess(":idFormCenter");
        item.setAjax(false);
        subMenu.addElement(item);
        subMenu.setRendered(true);
        
        return subMenu;
    } 

    public DefaultSubMenu itemAll(){
        
        DefaultSubMenu subMenu = new DefaultSubMenu("");
        DefaultMenuItem item;
        
        item = new DefaultMenuItem("Sair");
        item.setCommand("#{financiersView.logout()}");
        item.setAjax(false);
        item.setPartialSubmit(false);
        item.setProcess(":idFormCenter:idPanelLogin, :idFormCenter:idInUsuario, :idFormCenter:idPassword");
        item.setUpdate(":idFormCenter:idPanelLogin, :idFormCenter:idInUsuario, :idFormCenter:idPassword");
        subMenu.addElement(item);
        subMenu.setRendered(true);
        
        return subMenu;
    } 
}