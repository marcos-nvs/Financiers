/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnModulo;
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
public class ModuloDao implements Serializable{

/**
     *
     * @param obj delete object
     * @param strDbName
     */
    public static List<LnModulo> grabListModuloAtivo(Character modChAtivo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<LnModulo> listlnModulo = null;
        
        try{
            Query query = session.getNamedQuery("LnModulo.findAllAtivo");
            query.setCharacter("modChAtivo", modChAtivo);
            
            List l = query.list();
            
            if (l != null && !l.isEmpty()){
                listlnModulo = l; 
            }
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listlnModulo;
    }
    
}
