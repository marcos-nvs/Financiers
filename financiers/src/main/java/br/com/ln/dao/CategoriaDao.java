/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnCategoria;
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
public class CategoriaDao extends GenericDao implements Serializable{
    
    public static List<LnCategoria> grabCategoria(Character catChAtivo){
        
        Session session = null;
        Transaction tx;
        List<LnCategoria> listCategoria = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnCategoria.findByCatChAtivo");
            query.setCharacter("catChAtivo", catChAtivo);
            listCategoria = query.list();
            tx.commit();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listCategoria;
    }

//    public static Integer grabLnCategoriaNextId() {
//        return new Integer(grabIdByNextValueStringSQL("select nextval('seq_categoria');"));
//    }
    

    public static Integer grabTipoContaPorCategoria(Integer categoria){
        
        Session session = null;
        Transaction tx;
        List<LnCategoria> listaCategoria = null;
        Integer tipInCodigo = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnCategoria.findByCatInCodigo");
            query.setInteger("catInCodigo", categoria);
            listaCategoria = query.list();
            tx.commit();
            tipInCodigo = listaCategoria.get(0).getTipInCodigo();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return tipInCodigo;
    }
    
    public static List<LnCategoria> grabListaCategoria(){
        Session session = null;
        Transaction tx;
        List<LnCategoria> listaCategoria = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnCategoria.findAll");
            listaCategoria = query.list();
            tx.commit();
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listaCategoria;
        
    }

    public static LnCategoria grabCategoria(Integer idCategoria) {
        Session session = null;
        Transaction tx;
        LnCategoria lnCategoria = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnCategoria.findByCatInCodigo");
            query.setInteger("catInCodigo", idCategoria);
            List list = query.list();
            tx.commit();
            
            if (list != null && list.size()>0){
                lnCategoria = (LnCategoria) list.get(0);
            }
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return lnCategoria;
    }
}
