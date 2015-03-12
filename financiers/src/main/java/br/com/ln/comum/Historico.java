/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import static br.com.ln.comum.VarComuns.lnPerfilacesso;
import static br.com.ln.comum.VarComuns.lnUsusario;
import br.com.ln.entity.LnHistorico;
import br.com.ln.hibernate.Postgress;

/**
 *
 * @author Marcos Naves
 */
public class Historico {

    public Historico() {
    }
    
    public void gravaHistorico(String descricao){
        LnHistorico lnHistorico = new LnHistorico(Postgress.grabLnHistoricoNextId(), lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                                                Postgress.grabDateFromDB(),lnUsusario.getUsuStCodigo(),descricao);
        Postgress.saveObject(lnHistorico);
    }
    
}
