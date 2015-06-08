/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.dao.PerfilDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class PerfilFuncoes {
    
    private String mensagem;
    private Historico historico;
    
    public String perfil(LnPerfil lnPerfil){
        mensagem = "";
        historico = new Historico();
        
        switch (lnPerfil.getTipoFuncao()){
            case Incluir:
                inclusaoPerfil(lnPerfil);
                break;
            case Alterar:
                alteracaoPerfil(lnPerfil);
                break;
            case Excluir:
                exclusaoPerfil(lnPerfil);
                break;
            case Pesquisar:
                break;
        }
        
        return mensagem;
    }
    
    public String perfilAcesso(LnPerfilacesso lnPerfilacesso){
        mensagem = "";
        historico = new Historico();
        
        switch (lnPerfilacesso.getTipoFuncao()){
            case Incluir:
                inclusaoPerfilAcesso(lnPerfilacesso);
                break;
            case Alterar:
                break;
            case Excluir:
                exclusaoPerfilAcesso(lnPerfilacesso);
                break;
            case Pesquisar:
                break;
        }
        return mensagem;
    }

    private void inclusaoPerfil(LnPerfil lnPerfil) {
        
        if (lnPerfil != null){
            if (verificaPerfil(lnPerfil)){
//                lnPerfil.setPerInCodigo(Postgress.grabLnPerfilNextId());
                
                for (LnPerfilacesso lnPerfilacesso : lnPerfil.getListPerfilAcesso()) {
                    lnPerfilacesso.getLnPerfilacessoPK().setPerInCodigo(lnPerfil.getPerInCodigo());
                    Postgress.saveObject(lnPerfilacesso);
                }
                Postgress.saveObject(lnPerfil);
                historico.gravaHistoricoModulo("Inclusão do Perfil : " + lnPerfil.getPerStDescricao());
                mensagem = "Sucesso";
            } 
        } else {
            mensagem = "Inicie novamente o processo de inclusão de Perfil";
        }
        
    }

    private boolean verificaPerfil(LnPerfil lnPerfil) {
        mensagem = "Por favor preencha as seguintes informações: ";
        boolean validado = true;

        if (lnPerfil.getPerStDescricao() == null || lnPerfil.getPerStDescricao().isEmpty()){
            validado = false;
            mensagem = mensagem + "Descricao do perfil - ";
        } 
        
        if (lnPerfil.getListPerfilAcesso() == null || lnPerfil.getListPerfilAcesso().isEmpty()){
            validado = false;
            mensagem = mensagem + "Defina um tipo de acesso - ";
        }
        return validado;
    }

    private void alteracaoPerfil(LnPerfil lnPerfil) {
        if (lnPerfil != null){
            if (verificaPerfil(lnPerfil)){
                Postgress.saveOrUpdateObject(lnPerfil);
                historico.gravaHistoricoModulo("Alteração do Perfil : " + lnPerfil.getPerStDescricao());
                mensagem = "Sucesso";
            } 
        } else {
            mensagem = "Inicie novamente o processo de alteracao de Perfil";
        }
    }

    private void inclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        Postgress.saveObject(lnPerfilacesso);
        historico.gravaHistoricoModulo("Inclusão de Acesso Perfil");
        mensagem = "Sucesso";
    }

    private void exclusaoPerfilAcesso(LnPerfilacesso lnPerfilacesso) {
        Postgress.deleteObject(lnPerfilacesso);
        historico.gravaHistoricoModulo("Exclusão de Acesso Perfil ");
        mensagem = "Sucesso";
    }

    private void exclusaoPerfil(LnPerfil lnPerfil) {

        if (verificaExclusaoPerfil(lnPerfil)) {
            for (LnPerfilacesso lnPerfAcesso : lnPerfil.getListPerfilAcesso()) {
                Postgress.deleteObject(lnPerfAcesso);
            }
            Postgress.deleteObject(lnPerfil);
            historico.gravaHistoricoModulo("Exclusão de todo o perfil : " + lnPerfil.getPerStDescricao());
            mensagem = "Sucesso";
        }
    }

    private boolean verificaExclusaoPerfil(LnPerfil lnPerfil) {
        
        List<LnUsuario> listUsuario = UsuarioDao.grabUsuarioPerfil(lnPerfil.getPerInCodigo());
        
        if (listUsuario != null && !listUsuario.isEmpty()){
            mensagem = "Perfil não pode ser excluído, está sendo utilizado";
            return false;
        } else {
            return true;
        }
    }
}
