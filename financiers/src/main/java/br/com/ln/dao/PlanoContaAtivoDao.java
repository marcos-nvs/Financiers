/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnTipoativo;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaAtivoDao {
    
    public static List<LnTipoativo> grabListaTipoAtivo(){
        
        Session session = null;
        Transaction tx;
        List<LnTipoativo> listaTipoAtivo;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnTipoativo.findByTiaChAtivo");
            query.setCharacter("tiaChAtivo", 'S');
            listaTipoAtivo = query.list();
            
        } finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listaTipoAtivo;
    }
}
