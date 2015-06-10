/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTipoconta;
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
public class TipoContaDao implements Serializable {
    
    public static LnTipoconta grabTipoConta(Integer tipInCodigo){
        
        Session session = null;
        Transaction tx = null;
        List<LnTipoconta> listTipoConta = null;
        LnTipoconta lnTipoconta = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTipoconta.findByTipInCodigo");
            query.setInteger("tipInCodigo", tipInCodigo);
            listTipoConta = query.list();
            lnTipoconta = listTipoConta.get(0);
            tx.commit();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnTipoconta;
    }
    
}
