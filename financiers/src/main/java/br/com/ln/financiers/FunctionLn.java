/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;

/**
 *
 * @author Marcos Naves
 */
public class FunctionLn {
    
    private String mensagem;
    
    public String SaveObject(Object obj) {

        if (obj instanceof LnUsuario) {
            LnUsuario lnUsuario = (LnUsuario) obj;
            gravaUsuario(lnUsuario);
        }
        return mensagem;
    }

    private void gravaUsuario(LnUsuario lnUsuario) {
        mensagem = "";
        
        switch (lnUsuario.getTipoFuncao()){
            case Incluir:
                inclusaoUsuario(lnUsuario);
                break;
            case Alterar:
                break;
            case Excluir:
                break;
            case Pesquisar:
                break;
        }
    }
    
    private void inclusaoUsuario(LnUsuario lnUsuario) {
        LnUsuario pUsuario = Postgress.grabUsuario(lnUsuario.getUsuStCodigo());

        if (pUsuario != null) {
            mensagem = "Usuário já cadastrado!!!";
        } else {
            if (verificaDadosUsuario(lnUsuario)) {
                Postgress.saveObject(lnUsuario);
            }
        }
    }

    private boolean verificaDadosUsuario(LnUsuario lnUsuario) {

        mensagem = "Por favor preencha as seguintes informações:";
        boolean validado = true;

        if (lnUsuario.getUsuStNome() == null || lnUsuario.getUsuStNome().isEmpty()) {
            validado = false;
            mensagem = "Nome";
        }
        if (lnUsuario.getUsuStEmail() == null || lnUsuario.getUsuStEmail().isEmpty()) {
            validado = false;
            mensagem = "E-mail";
        }

        if (lnUsuario.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            if (lnUsuario.getUsuStCodigo() == null || lnUsuario.getUsuStCodigo().isEmpty()) {
                validado = false;
                mensagem = "Usuário";
            }
            if (lnUsuario.getUsuStSenha() == null || lnUsuario.getUsuStSenha().isEmpty()) {
                validado = false;
                mensagem = "Senha";
            }
        }
        return validado;
    }
}
