/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import static br.com.ln.comum.VarComuns.lnPerfilacesso;
import static br.com.ln.comum.VarComuns.lnUsusario;
import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnUsuario;
import br.com.ln.dao.GenericDao;

/**
 *
 * @author Marcos Naves
 */
public class Historico {

    public Historico() {
    }
    
    public void gravaHistoricoModulo(String descricao){
        LnHistorico lnHistorico = new LnHistorico(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                                                GenericDao.grabDateFromDB(),lnUsusario.getUsuStCodigo(),descricao);
        GenericDao.saveObject(lnHistorico);
    }
    
    public void gravaHistorico(LnUsuario lnUsuario, String descricao){
        LnHistorico lnHistorico = new LnHistorico(GenericDao.grabDateFromDB(), lnUsuario.getUsuStCodigo(), descricao);
        GenericDao.saveObject(lnHistorico);
    }

    public void gravaHistorico(String usuario, String descricao){
        LnHistorico lnHistorico = new LnHistorico(GenericDao.grabDateFromDB(), usuario, descricao);
        GenericDao.saveObject(lnHistorico);
    }
}
