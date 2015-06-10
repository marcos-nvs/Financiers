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
public class CategoriaDao implements Serializable{
    
    public static List<LnCategoria> grabCategoria(Character catChAtivo){
        
        Session session = null;
        Transaction tx = null;
        List<LnCategoria> listCategoria = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnCategoria.findByCatChAtivo");
            query.setInteger("catChAtivo", catChAtivo);
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
    
    
}
