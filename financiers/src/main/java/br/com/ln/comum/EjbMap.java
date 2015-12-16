/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import br.com.ln.entity.LnTipoconta;
import br.com.ln.dao.TipoContaDao;
import br.com.ln.dao.TipoFavorecidoDao;
import br.com.ln.entity.LnTipofavorecido;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Marcos Naves
 */

@Singleton
public class EjbMap implements Serializable{
    
    private static final Map<String, LnTipoconta> mapTipoConta = new HashMap<>(20);
    private static final Map<String, LnTipofavorecido> mapTipoFavorecido = new HashMap<>(100);

    public synchronized static LnTipoconta grabTipoConta(Integer tipInCodigo){
        
        LnTipoconta lnTipoconta = null;
        String code = tipInCodigo.toString();
        
        if (mapTipoConta.containsKey(code)){
            return mapTipoConta.get(code);
        } else {
            lnTipoconta = TipoContaDao.grabTipoConta(tipInCodigo);
            mapTipoConta.put(code, lnTipoconta);
            return lnTipoconta;
        }
    }
    
    public synchronized static LnTipofavorecido grabTipofavorecido(Integer tfaInCodigo){
        
        LnTipofavorecido lnTipofavorecido;
        String code = tfaInCodigo.toString();
        
        if (mapTipoFavorecido.containsKey(code)){
            return mapTipoFavorecido.get(code);
        } else {
            lnTipofavorecido = TipoFavorecidoDao.grabTipoFavorecido(tfaInCodigo);
            mapTipoFavorecido.put(code, lnTipofavorecido);
            return lnTipofavorecido;
        }
    }
}
