/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnMenu;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class MenuDao implements Serializable {
    
    static Logger logger = Logger.getLogger(MenuDao.class);

/**
     * Busca o Menu
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static List<LnMenu> grabMenu(Character menChAtivo){
        
        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List<LnMenu> listMenu = null;
        try{
            Query query = session.getNamedQuery("LnMenu.findAllAtivo");
            query.setCharacter("menChAtivo", 'S');
            listMenu = (List<LnMenu>) query.list();
            
        }finally{
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return listMenu;
    }
    
}

