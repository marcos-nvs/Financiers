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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class UsuarioDao extends GenericDao implements Serializable {
    
    /**
     * Pesquisa de usuario e senha para validacao.
     * @param usuStCodigo
     * @param strDbName
     * @return 
     */
    
    public static LnUsuario grabUsuario(String usuStCodigo, Character usuChAtivo){
        
        Session session = null;
        Transaction tx;
        LnUsuario lnUsuario = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName("acessocontrol");
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
            System.out.println("Hibernate Exception : " + ex.getMessage());
        }finally{
            
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnUsuario;
    }
    
    /**
     * Busca usuario especifico.
     * @param usuStCodigo
     * @param strDbName
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
            System.out.println("Hibernate Exception : " + ex.getMessage());
        }finally{
            
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnUsuario;
    }
    
    /**
     * Busca Perfil do usuario.
     * @param usuStCodigo
     * @param strDbName
     * @return 
     */
    public static List<LnUsuario> grabUsuarioPerfil(Integer perInCodigo){
        
        Session session = null;
        Transaction tx = null;
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
     * Pesquisa de usuario e senha para validacao.
     * @param cliente
     * @return 
     */
    public static List<LnUsuario> grabListUsuarioCliente(Integer cliente){
        
        Session session = null;
        Transaction tx = null;
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
    
    public static LnUsuario grabUsuarioDocumento(String documento){
        
        Session session = null;
        Transaction tx = null;
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
