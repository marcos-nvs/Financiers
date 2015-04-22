/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.entity.LnPerfil;

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
        
        return mensagem;
    }
}
