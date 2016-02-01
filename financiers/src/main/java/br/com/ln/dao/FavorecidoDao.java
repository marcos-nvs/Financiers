/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnFavorecido;
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
public class FavorecidoDao extends GenericDao implements Serializable {

    public static List<LnFavorecido> grabBancos() {
        Session session = null;
        Transaction tx;
        List<LnFavorecido> listaFavorecido = null;

        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();

            Query query = session.getNamedQuery("LnFavorecido.findByTfaInCodigo");
            query.setInteger("tfaInCodigo", 2);
            listaFavorecido = query.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listaFavorecido;
    }

    public static LnFavorecido grabFavorecidoBanco(Integer favInCodigo) {

        Session session = null;
        Transaction tx;
        LnFavorecido lnFavorecido = null;

        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();

            Query query = session.getNamedQuery("LnFavorecido.findByFavInCodigo");
            query.setInteger("favInCodigo", favInCodigo);
            List l = query.list();
            tx.commit();

            if (l != null && l.size() > 0) {
                lnFavorecido = (LnFavorecido) l.get(0);
            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lnFavorecido;
    }

    public static List<LnFavorecido> grabListaFavorecido() {

        Session session = null;
        Transaction tx;
        List<LnFavorecido> listaFavorecido = null;

        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();

            Query query = session.getNamedQuery("LnFavorecido.findAll");
            listaFavorecido = query.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listaFavorecido;
    }
    
    public static List<LnFavorecido> grabListaFavorecidoAtivo(){
        
        Session session = null;
        Transaction tx;
        List<LnFavorecido> listaFavorecido = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnFavorecido.findByFavChAtivo");
            query.setCharacter("favChAtivo", 'S');
            listaFavorecido = query.list();
            tx.commit();
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listaFavorecido;
    }
}
