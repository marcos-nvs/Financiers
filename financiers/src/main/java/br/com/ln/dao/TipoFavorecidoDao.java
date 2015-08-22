/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTipofavorecido;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class TipoFavorecidoDao implements Serializable{
    
    public static LnTipofavorecido grabTipoFavorecido(Integer tfaInCodigo){
        
        Session session = null;
        Transaction tx;
        
        List<LnTipofavorecido> listFavorecido;
        LnTipofavorecido lnTipofavorecido = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTipofavorecido.findByTfaInCodigo");
            query.setInteger("tfaInCodigo", tfaInCodigo);
            listFavorecido = query.list();
            lnTipofavorecido = listFavorecido.get(0);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return lnTipofavorecido;
    }
}