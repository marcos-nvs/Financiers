/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.financiers.Irrf;
import br.com.ln.financiers.IrrfDescricao;
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
public class IrrfDao extends GenericDao implements Serializable {
    
     /**
     * Lista de IRRF
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static List<IrrfDescricao> grabIrrfDescricao(){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<IrrfDescricao> listIrrfDescricao = null;
                
        try{
            Query query = session.getNamedQuery("LnTabela.findByCodDescricaoListaIRRF");
            query.setInteger("ttbInCodigo", 1);
            
            listIrrfDescricao = query.list();
            tx.commit();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listIrrfDescricao;
    } 
    
    public static List<Irrf> listIrrf(Integer tabinCodigo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<Irrf> listIrrf = null;
        
        try{
            Query query = session.getNamedQuery("LnTabela.findByTtbInCodigo");
            query.setInteger("ttbInCodigo", 1);
            
            listIrrf = query.list();
            tx.commit();;
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listIrrf;
    }
   
    
    
}
