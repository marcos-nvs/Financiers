/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;

/**
 *
 * @author Marcos Naves
 */
public class usuarioFunctions {
    
    private String mensagem;
    
    public String usuario(LnUsuario lnUsuario) {
        mensagem = "";
        
        switch (lnUsuario.getTipoFuncao()){
            case Incluir:
                inclusaoUsuario(lnUsuario);
                break;
            case Alterar:
                alteracaoUsuario(lnUsuario);
                break;
            case Excluir:
                exclusaoUsuario(lnUsuario);
                break;
            case Pesquisar:
                break;
        }
        
        return mensagem;
    }
    
    private void inclusaoUsuario(LnUsuario lnUsuario) {
        LnUsuario pUsuario = Postgress.grabUsuario(lnUsuario.getUsuStCodigo());

        if (pUsuario != null) {
            mensagem = "Usuário já cadastrado!!!";
        } else {
            if (verificaDadosUsuario(lnUsuario)) {
                if (lnUsuario.getUsuChExpirasenha().equals('S')){
                    lnUsuario.setUsuInDia(30);
                    lnUsuario.setUsuDtExpiracao(Postgress.grabDateFromDB());
                }
                lnUsuario.setUsuDtCadastro(Postgress.grabDateFromDB());
                Postgress.saveObject(lnUsuario);
                mensagem = "Sucesso";
            }
        }
    }

    private boolean verificaDadosUsuario(LnUsuario lnUsuario) {

        mensagem = "Por favor preencha as seguintes informações: ";
        boolean validado = true;

        if (lnUsuario.getUsuStNome() == null || lnUsuario.getUsuStNome().isEmpty()) {
            validado = false;
            mensagem = mensagem + "Nome - ";
        }
        if (lnUsuario.getUsuStEmail() == null || lnUsuario.getUsuStEmail().isEmpty()) {
            validado = false;
            mensagem = mensagem + "E-mail - ";
        }

        if (lnUsuario.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            if (lnUsuario.getUsuStCodigo() == null || lnUsuario.getUsuStCodigo().isEmpty()) {
                validado = false;
                mensagem = mensagem + "Usuário - ";
            }
            if (lnUsuario.getUsuStSenha() == null || lnUsuario.getUsuStSenha().isEmpty()) {
                validado = false;
                mensagem = mensagem + "Senha";
            }
        }
        return validado;
    }

    private void alteracaoUsuario(LnUsuario lnUsuario) {

        if (verificaDadosUsuario(lnUsuario)){
            LnUsuario pUsuario = Postgress.grabUsuario(lnUsuario.getUsuStCodigo());
            lnUsuario.setUsuStSenha(pUsuario.getUsuStSenha());
            Postgress.saveOrUpdateObject(lnUsuario);
            mensagem = "Sucesso";
        }
    }

    private void exclusaoUsuario(LnUsuario lnUsuario) {
        
        if (Postgress.grabVerificaHistorico(lnUsuario.getUsuStCodigo())) {
            Postgress.deleteObject(lnUsuario);
            mensagem = "Sucesso";
        } else {
            mensagem = "O usuário " +lnUsuario.getUsuStCodigo() + " não pode ser excluído apenas cancelado.!!!!";
        }
    }

}
