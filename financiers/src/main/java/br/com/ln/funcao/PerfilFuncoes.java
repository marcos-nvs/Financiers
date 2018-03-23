    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.comum.Historico;
import br.com.ln.dao.ModuloDao;
import br.com.ln.dao.PerfilDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.tipos.TipoFuncao;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Marcos Naves
 */
public class PerfilFuncoes {

    public String mensagem;
    private Historico historico;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    Logger logger = Logger.getLogger(PerfilFuncoes.class);

    public boolean perfil(LnPerfil lnPerfil) {
        historico = new Historico();

        switch (lnPerfil.getTipoFuncao()) {
            case Incluir:
                return inclusaoPerfil(lnPerfil);
            case Alterar:
                return alteracaoPerfil(lnPerfil);
            case Excluir:
                return exclusaoPerfil(lnPerfil);
            case Pesquisar:
                return true;
            default:
                return false;
        }
    }

    public boolean perfilAcesso(LnPerfilacesso lnPerfilacesso) {
        historico = new Historico();

        switch (lnPerfilacesso.getTipoFuncao()) {
            case Incluir:
                return inclusaoPerfilAcesso(lnPerfilacesso);
            case Alterar:
                return true;
            case Excluir:
                return exclusaoPerfilAcesso(lnPerfilacesso);
            case Pesquisar:
                return false;
            default:
                return false;
        }
    }

    private boolean inclusaoPerfil(LnPerfil lnPerfil) {

        historico = new Historico();

        if (lnPerfil != null) {
            if (verificaPerfil(lnPerfil)) {
                lnPerfil.setPerInCodigo(PerfilDao.grabLnPerfilNextId());

                for (LnPerfilacesso lnPerfilacesso : lnPerfil.getListPerfilAcesso()) {
                    lnPerfilacesso.getLnPerfilacessoPK().setPerInCodigo(lnPerfil.getPerInCodigo());
                    if (!perfilAcesso(lnPerfilacesso)) {
                        return false;
                    }
                }
                PerfilDao.saveObject(lnPerfil);
                PerfilDao.grabPerfil(lnPerfil.getPerInCodigo(), 'S');
                historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.inclusaoperfil") + " " + lnPerfil.getPerStDescricao());
                mensagem = bundle.getString("ln.mb.texto.sucesso");
                return true;
            } else{
                return false;
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.erro");
            return false;
        }
    }

    private boolean verificaPerfil(LnPerfil lnPerfil) {
        mensagem = bundle.getString("ln.mb.frase.preenchercampos");
        boolean validado = true;

        if (lnPerfil.getPerStDescricao() == null || lnPerfil.getPerStDescricao().isEmpty()) {
            validado = false;
            mensagem = mensagem + bundle.getString("ln.texto.descricao") + " ";
        }

        if (lnPerfil.getListPerfilAcesso() == null || lnPerfil.getListPerfilAcesso().isEmpty()) {
            validado = false;
            mensagem = mensagem + bundle.getString("ln.mb.frase.definatipoacesso");
        }
        return validado;
    }

    private boolean alteracaoPerfil(LnPerfil lnPerfil) {
        if (lnPerfil != null) {
            if (verificaPerfil(lnPerfil)) {
                for (LnPerfilacesso lnPerfilacesso : lnPerfil.getListPerfilAcesso()) {
                    if (lnPerfilacesso.getTipoFuncao() == null){
                        lnPerfilacesso.setTipoFuncao(TipoFuncao.Alterar);
                    }
                    if (!perfilAcesso(lnPerfilacesso)) {
                        return false;
                    }
                }
                PerfilDao.saveOrUpdateObject(lnPerfil);
//                EjbMap.updatePerfil(lnPerfil, VarComuns.strDbName);
                historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.alteracaoperfil") + " " + lnPerfil.getPerStDescricao());
                mensagem = bundle.getString("ln.mb.texto.sucesso");
                return true;
            } else {
                return false;
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.erro");
            return false;
        }
    }

    private boolean inclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        PerfilDao.saveObject(lnPerfilacesso);
        LnModulo lnModulo = ModuloDao.getModulo(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo());
        historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.inclusaoperfilacesso") + " " + lnModulo.getModStDescricao());
        mensagem = bundle.getString("ln.mb.texto.sucesso");
        return true;
    }

    private boolean exclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        PerfilDao.deleteObject(lnPerfilacesso);
        LnModulo lnModulo = ModuloDao.getModulo(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo());
        historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.exclusaoperfilacesso") + " " + lnModulo.getModStDescricao());
        mensagem = bundle.getString("ln.mb.texto.sucesso");
        return true;
    }

    private boolean exclusaoPerfil(LnPerfil lnPerfil) {

        if (verificaExclusaoPerfil(lnPerfil)) {
            if (lnPerfil.getListPerfilAcesso() != null) {
                for (LnPerfilacesso lnPerfilacesso : lnPerfil.getListPerfilAcesso()) {
                    lnPerfilacesso.setTipoFuncao(TipoFuncao.Excluir);
                    if (!perfilAcesso(lnPerfilacesso)) {
                        return false;
                    }
                }
            }
            PerfilDao.deleteObject(lnPerfil);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.exclusaoperfil") + " " + lnPerfil.getPerStDescricao());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaExclusaoPerfil(LnPerfil lnPerfil) {

        List<LnUsuario> listUsuario = UsuarioDao.grabUsuarioPerfil(lnPerfil.getPerInCodigo());

        if (listUsuario != null && !listUsuario.isEmpty()) {
            mensagem = bundle.getString("ln.mb.frase.existehistorico");
            return false;
        } else {
            return true;
        }
    }
}
