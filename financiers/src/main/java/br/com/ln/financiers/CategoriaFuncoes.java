/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.dao.CategoriaDao;
import br.com.ln.entity.LnCategoria;
import br.com.ln.entity.LnFavorecido;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class CategoriaFuncoes {
    
    public String mensagem;
    private Historico historico;
    
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public boolean categoria(LnCategoria lnCategoria){
        historico = new Historico();
        
        switch (lnCategoria.getTipoFuncao()){
            case Incluir:
                return incluirCategoria(lnCategoria);
            case Alterar:
                return alterarCategoria(lnCategoria);
            case Excluir:
                return excluirCategoria(lnCategoria);
            default:
                return false;
        }
    }

    private boolean incluirCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            CategoriaDao.saveObject(lnCategoria);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.inclusaocategoria") + " " + lnCategoria.getCatStDescricao());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        } else {
            mensagem = bundle.getString("ln.mb.frase.problema");
            return false;
        }
    }

    private boolean alterarCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            CategoriaDao.saveOrUpdateObject(lnCategoria);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.alteracaousuario") + " " + lnCategoria.getCatStDescricao());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        } else {
            mensagem = bundle.getString("ln.mb.frase.problema");
            return false;
        }
    }

    private boolean excluirCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            CategoriaDao.deleteObject(lnCategoria);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.exclusaocategoria") + " "  + lnCategoria.getCatStDescricao());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        } else {
            mensagem = bundle.getString("ln.mb.frase.problema");
            return false;
        }
    }

    public boolean verificaExclusaoCategoria(LnCategoria lnCategoria) {
            return true;
    }
}
