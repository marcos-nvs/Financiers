/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTabela;
import br.com.ln.entity.LnTabelaItem;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class TabelaDao extends GenericDao implements Serializable{
    
    public static synchronized List<LnTabela> grabTabela(Integer ttbInCodigo){
        
        Session session = null;
        Transaction tx;
        List<LnTabela> listTabela = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTabela.findByTtbInCodigo");
            query.setInteger("ttbInCodigo", ttbInCodigo);
            listTabela = query.list();
            tx.commit();
            
        } finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
        return listTabela;
    }
    
    public static synchronized List<LnTabelaItem> grabTabelaItem(Integer tabInCodigo){
        
        Session session = null;
        Transaction tx = null;
        List<LnTabelaItem> listTabelaItem = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTabelaItem.findByTabInCodigo");
            query.setInteger("tabInCodigo", tabInCodigo);
            listTabelaItem = query.list();
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
                
        return listTabelaItem;
    }
    
    public static synchronized Integer grabLnTabelaNextId() {
        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_tabela');"));
    }
    
    public static synchronized Integer grabLnTabelaItemNextId() {
        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_tabelaitem');"));
    }
    
    public static synchronized List<LnTabela> grabLnTabelaDate(Integer ttbInCodigo, Date tabDtInicio, Date tabDtFinal){
        Session session = null;
        Transaction tx;
        List<LnTabela> listaTabela = null;
        
        try{
            session  = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createQuery("select l from LnTabela l where l.ttbInCodigo = :ttbInCodigo and l.tabDtFinal >= :tabDtFinal");
            query.setInteger("ttbInCodigo", ttbInCodigo);
            query.setDate("tabDtFinal", tabDtFinal);
            listaTabela = query.list();
            tx.commit();
            
        } finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listaTabela;
    }
}
