/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import static br.com.ln.dao.GenericDao.grabIdByNextValueStringSQL;
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
public class PerfilDao extends GenericDao implements Serializable {
    
    /**
     * Perfil especifico
     * @param perInCodigo
     * @param perChAtivo
     * @return List Object
     */
    public static LnPerfil grabPerfil(Integer perInCodigo, Character perChAtivo){
    
        Session session = null;
        Transaction tx = null;
        LnPerfil lnPerfil = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnPerfil.findByPerInCodigoPerChAtivo");
            query.setInteger("perInCodigo", perInCodigo);
            query.setCharacter("perChAtivo", perChAtivo);
            
            List l = query.list();
            tx.commit();
            
            if (l != null && !l.isEmpty()){
                lnPerfil = (LnPerfil) l.get(0); 
            } 
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnPerfil;
    }

    /**
     * Lista de Perfil Ativo
     * @param clazz
     * @param strDbName
     * @return List Object
     */

    public static List<LnPerfil> grabListPerfilAtivo(Character perChAtivo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<LnPerfil> listPerfil;
        
        try{
            Query query = session.getNamedQuery("LnPerfil.findByPerChAtivo");
            query.setCharacter("perChAtivo", perChAtivo);
            listPerfil = query.list();
            tx.commit();
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listPerfil;
    }

    /**
     * Perfil e Modulo especifico
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static LnPerfilacesso grabPerfilAcesso(Integer perInCodigo, Integer modInCodigo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        LnPerfilacesso lnPerfilAcesso = null;
        
        try{
            Query query = session.getNamedQuery("LnPerfilacesso.findByPerInCodigoModInCodigo");
            query.setInteger("perInCodigo", perInCodigo);
            query.setInteger("modInCodigo", modInCodigo);
            
            List l = query.list();
            
            if (l != null && !l.isEmpty()){
                lnPerfilAcesso = (LnPerfilacesso) l.get(0); 
            }
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnPerfilAcesso;
    }
    
    /**
     * Perfil de acesso especifico
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static List<LnPerfilacesso> grabPerfilAcessoperInCodigo(Integer perInCodigo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<LnPerfilacesso> listlnPerfilAcesso = null;
        
        try{
            Query query = session.getNamedQuery("LnPerfilacesso.findByPerInCodigo");
            query.setInteger("perInCodigo", perInCodigo);
            
            List l = query.list();
            
            if (l != null && !l.isEmpty()){
                listlnPerfilAcesso = l; 
            }
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listlnPerfilAcesso;
    }
 
    /**
     * Descricao do Perfil
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static LnPerfil grabPerfilperStDesc(String perStDescricao){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        LnPerfil lnPerfil = null;
        
        try{
            Query query = session.getNamedQuery("LnPerfil.findByPerStDescricao");
            query.setString("perStDescricao", perStDescricao);
            
            List l = query.list();
            
            if (l != null && !l.isEmpty()){
                lnPerfil = (LnPerfil) l.get(0); 
            }
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnPerfil;
    }

    public static Integer grabLnPerfilNextId() {
        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_perfil');"));
    }
    
}
