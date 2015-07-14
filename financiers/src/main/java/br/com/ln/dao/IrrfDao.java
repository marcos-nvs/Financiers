/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTabela;
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
public class IrrfDao extends GenericDao implements Serializable{
    
    public static synchronized List<LnTabela> grabDescricaoTabela(){
        
        Session session = null;
        Transaction tx;
        List<LnTabela> listTabela = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTabela.findByTtbInCodigo");
            query.setInteger("ttbInCodigo", 1);
            listTabela = query.list();
            tx.commit();
            
        } finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }
        return listTabela;
    }
    
    public static synchronized List<LnTabela> grabDetalheTabela(Integer tipoTabela, Date dtInicio, Date dtFinal){
        
        Session session = null;
        Transaction tx = null;
        List<LnTabela> listTabela = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnTabela.findByCodigoDetalheIRRF");
            query.setInteger("ttbInCodigo", tipoTabela);
            query.setDate("tabDtInicio", dtInicio);
            query.setDate("tabDtFinal", dtFinal);
            listTabela = query.list();
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
                
        return listTabela;
    }
    
    public static Integer grabLnTabelaNextId() {
        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_tabela');"));
    }
    
}
