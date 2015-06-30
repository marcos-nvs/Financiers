/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnCliente;
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
public class ClienteDao extends GenericDao implements Serializable{
    
    public static LnCliente grabClienteCpf(String documento){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.getTransaction();
        LnCliente lnCliente = null;
        
        try{
            Query query = session.getNamedQuery("LnCliente.findByCliStDocumento");
            query.setString("cliStDocumento", documento);
            
            List l = query.list();
            tx.commit();
            
            lnCliente = (LnCliente) l.get(0);
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return lnCliente;
    }
    
}
