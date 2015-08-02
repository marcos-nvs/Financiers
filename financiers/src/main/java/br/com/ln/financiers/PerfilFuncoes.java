    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.EjbMap;
import br.com.ln.comum.Historico;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.PerfilDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class PerfilFuncoes {

    public String mensagem;
    private Historico historico;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

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
                return false;
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
                    PerfilDao.saveObject(lnPerfilacesso);
                }
                PerfilDao.saveObject(lnPerfil);
                EjbMap.grabPerfil(lnPerfil.getPerInCodigo(), VarComuns.strDbName);
                historico.gravaHistoricoModulo("Inclusão do Perfil : " + lnPerfil.getPerStDescricao());
                mensagem = "Sucesso";
                return true;
            } else{
                return false;
            }
        } else {
            mensagem = "Inicie novamente o processo de inclusão de Perfil";
            return false;
        }
    }

    private boolean verificaPerfil(LnPerfil lnPerfil) {
        mensagem = "Por favor preencha as seguintes informações: ";
        boolean validado = true;

        if (lnPerfil.getPerStDescricao() == null || lnPerfil.getPerStDescricao().isEmpty()) {
            validado = false;
            mensagem = mensagem + "Descricao do perfil - ";
        }

        if (lnPerfil.getListPerfilAcesso() == null || lnPerfil.getListPerfilAcesso().isEmpty()) {
            validado = false;
            mensagem = mensagem + "Defina um tipo de acesso - ";
        }
        return validado;
    }

    private boolean alteracaoPerfil(LnPerfil lnPerfil) {
        if (lnPerfil != null) {
            if (verificaPerfil(lnPerfil)) {
                PerfilDao.saveOrUpdateObject(lnPerfil);
                EjbMap.updatePerfil(lnPerfil, VarComuns.strDbName);
                historico.gravaHistoricoModulo("Alteração do Perfil : " + lnPerfil.getPerStDescricao());
                mensagem = "Sucesso";
                return true;
            } else {
                return false;
            }
        } else {
            mensagem = "Inicie novamente o processo de alteracao de Perfil";
            return false;
        }
    }

    private boolean inclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        PerfilDao.saveObject(lnPerfilacesso);
        historico.gravaHistoricoModulo("Inclusão de Acesso Perfil");
        mensagem = "Sucesso";
        return true;
    }

    private boolean exclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        PerfilDao.deleteObject(lnPerfilacesso);
        historico.gravaHistoricoModulo("Exclusão de Acesso Perfil ");
        mensagem = "Sucesso";
        return true;
    }

    private boolean exclusaoPerfil(LnPerfil lnPerfil) {

        if (verificaExclusaoPerfil(lnPerfil)) {
            if (lnPerfil.getListPerfilAcesso() != null) {
                for (LnPerfilacesso lnPerfAcesso : lnPerfil.getListPerfilAcesso()) {
                    PerfilDao.deleteObject(lnPerfAcesso);
                }
            }
            PerfilDao.deleteObject(lnPerfil);
            historico.gravaHistoricoModulo("Exclusão de todo o perfil : " + lnPerfil.getPerStDescricao());
            mensagem = "Sucesso";
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaExclusaoPerfil(LnPerfil lnPerfil) {

        List<LnUsuario> listUsuario = UsuarioDao.grabUsuarioPerfil(lnPerfil.getPerInCodigo());

        if (listUsuario != null && !listUsuario.isEmpty()) {
            mensagem = "Perfil não pode ser excluído, está sendo utilizado";
            return false;
        } else {
            return true;
        }
    }
}
