/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.hibernate.Postgress;

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
                break;
            case Excluir:
                break;
            case Pesquisar:
                break;
        }
        
        return mensagem;
    }

    private void inclusaoPerfil(LnPerfil lnPerfil) {
        
        if (lnPerfil != null){
            if (verificaPerfil(lnPerfil)){
                lnPerfil.setPerInCodigo(Postgress.grabLnPeriflNextId());
                
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
}
