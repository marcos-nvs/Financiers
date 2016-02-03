/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.comum.Historico;
import br.com.ln.objeto.Ativo;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */

public class AtivoFuncoes implements Serializable {
    
    public String mensagem;
    private Historico historico;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    
    public boolean validaInformacao(Ativo ativo){
        
        if (ativo.getValorAtivo() == null){
            
        }
        
        return false;
    }
    
}
