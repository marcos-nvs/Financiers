/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnHistorico;
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
public class HistoricoDao implements Serializable{
    

    public static boolean grabVerificaHistorico(String usuStCodigo){
        
        Session session = null;
        Transaction tx;
        List<LnHistorico> listHis;
        boolean retorno = false;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnHistorico.findByUsuStCodigo");
            query.setString("usuStCodigo", usuStCodigo);
            
            listHis = query.list();
            tx.commit();

            if (listHis != null) {
                retorno = listHis.isEmpty();
            } else {
                retorno = false;
            }
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return retorno;
    }
    
    public static List<LnHistorico> grabListHistorico(Integer modInCodigo){
        
        Session session = null;
        Transaction tx = null;
        List<LnHistorico> listHistorico = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query;
            
            if (modInCodigo != null) {
                query = session.getNamedQuery("LnHistorico.findByModInCodigo");
                query.setInteger("modInCodigo", modInCodigo);
            } else {
                query = session.getNamedQuery("LnHistorico.findAll");
            }
            listHistorico = query.list();
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listHistorico;
    }

//    public static Integer grabLnHistoricoNextId() {
//        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_historico');"));
//    }
    
    
}
