/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.entity.LnSaldoconta;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaDao extends GenericDao{
    
    public static List<LnPlanoconta> grabContaAtivo(){
        
        Session session = null;
        Transaction tx;
        List<LnPlanoconta> listaPlanoconta = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnPlanoconta.findByCtaChAtivo");
            query.setCharacter("ctaChAtivo", 'S');
            listaPlanoconta = query.list();
            tx.commit();
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listaPlanoconta;
    }
    
    public static Integer grabLnPlanoContaNextId() {
        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_planoconta');"));
    }
    
    public static List<LnPlanoconta> grabListaConta(){
        
        Session session = null;
        Transaction tx;
        List<LnPlanoconta> listaPlanoconta = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnPlanoconta.findAll");
            listaPlanoconta = query.list();
            tx.commit();
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listaPlanoconta;
    }
    
    public static List<LnSaldoconta> grabListSaldo(Integer ctaInCodigo){
        return null;
    }
    
    public static LnSaldoconta grabSaldoAtualConta(Integer ctaInCodigo, Date sacDtData){
        
        Session session = null;
        Transaction tx;
        LnSaldoconta lnSaldoconta = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnSaldoconta.findByCtaInCodigoSacDtData");
            query.setInteger("ctaInCodigo", ctaInCodigo);
            query.setDate("sacDtData", sacDtData);
            List list = query.list();
            tx.commit();
            
            if (list != null && list.size() >0){
                lnSaldoconta = (LnSaldoconta) list.get(0);
            }
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return lnSaldoconta;
    }
}
