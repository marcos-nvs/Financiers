/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class UsuarioDao extends GenericDao implements Serializable {
    
    static Logger logger = Logger.getLogger(UsuarioDao.class);
    
    /**
     * grabUsuario Get list user for code active.
     * @param usuStCodigo
     * @param usuChAtivo
     * @return 
     */
    
    public static LnUsuario grabUsuario(String usuStCodigo, Character usuChAtivo){
        
        Session session = null;
        Transaction tx;
        LnUsuario lnUsuario = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnUsuario.findAllUsuStCodigoUsuChAtivo");
            query.setString("usuStCodigo", usuStCodigo);
            query.setCharacter("usuChAtivo", usuChAtivo);
            
            List l = query.list();
            tx.commit();
            
            if (l != null && l.size() > 0){
                lnUsuario = (LnUsuario) l.get(0);
            } else {
                lnUsuario = null;
            }
        }catch(HibernateException ex){
            logger.error("Hibernate Exception : " + ex.getMessage());
        }finally{
            
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnUsuario;
    }
    
    /**
     * grabUsuario Get list user for code.
     * @param usuStCodigo
     * @return 
     */
    public static LnUsuario grabUsuario(String usuStCodigo){
        
        Session session = null;
        Transaction tx;
        LnUsuario lnUsuario = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnUsuario.findByUsuStCodigo");
            query.setString("usuStCodigo", usuStCodigo);
            
            List l = query.list();
            tx.commit();
            
            if (l != null && l.size() > 0){
                lnUsuario = (LnUsuario) l.get(0);
            } else {
                lnUsuario = null;
            }
        }catch(HibernateException ex){
            logger.error("Hibernate Exception : " + ex.getMessage());
        }finally{
            
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnUsuario;
    }
    
    /**
     * Get profile in code profile.
     * @param perInCodigo
     * @return 
     */
    public static List<LnUsuario> grabUsuarioPerfil(Integer perInCodigo){
        
        Session session = null;
        Transaction tx;
        List<LnUsuario> listUsuario = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnUsuario.findByPerInCodigo");
            query.setInteger("perInCodigo", perInCodigo);
            listUsuario = query.list();
            tx.commit();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listUsuario;
    }
    
    /**
     * grabListUsuario Get list user for client.
     * @param cliente
     * @return 
     */
    public static List<LnUsuario> grabListUsuarioCliente(Integer cliente){
        
        Session session = null;
        Transaction tx;
        List<LnUsuario> listUsuario = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnUsuario.findByCliInCodigo");
            query.setInteger("cliInCodigo", cliente);
            listUsuario = query.list();
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listUsuario;
    }
    
    /**
     * grabListUsuario Get user for document.
     * @param documento
     * @return 
     */
    public static LnUsuario grabUsuarioDocumento(String documento){
        
        Session session = null;
        Transaction tx;
        LnUsuario lnUsuario = null;
        
        try {
            session  = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnUsuario.findByUsuStCpf");
            query.setString("usuStCpf", documento);
            List l = query.list();
            tx.commit();
            
            if (l != null && !l.isEmpty()){
                lnUsuario = (LnUsuario) l.get(0);
            }
            
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnUsuario;
    }
}
