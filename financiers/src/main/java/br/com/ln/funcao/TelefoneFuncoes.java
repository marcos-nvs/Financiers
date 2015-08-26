/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.entity.LnTelefone;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class TelefoneFuncoes {

    public String mensagem;
    private boolean validado;
    private Integer codigo = 0;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public boolean validacao(LnTelefone lnTelefone) {
        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + ": ";
        boolean validacao = true;

        if (lnTelefone != null) {
            if (lnTelefone.getTelStDdd() != null && lnTelefone.getTelStDdd().isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.ddd") + "; ";
                validacao = false;
            }
            if (lnTelefone.getTelStTelefone() != null && lnTelefone.getTelStTelefone().isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.telefone") + "; ";
                validacao = false;
            }
        } else {
            mensagem = bundle.getString("ln.texto.telefone");
            validacao = false;
        }

        if (validacao) {
            mensagem = bundle.getString("ln.mb.texto.sucesso");
        }

        return validacao;
    }

    public String descricaoTipo(Character tipoTelefone) {
        switch (tipoTelefone) {
            case '1':
                return bundle.getString("ln.texto.residencia");
            case '2':
                return bundle.getString("ln.texto.comercial");
            case '3':
                return bundle.getString("ln.texto.celular");
        }
        return null;
    }

    public Integer calculaCodigo() {
        Integer codigoNovo;
        codigoNovo = codigo + 1;

        codigo = codigoNovo;
        return codigo;
    }
}
