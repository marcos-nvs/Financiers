/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Fabrica de conexão
 * @author Marcos Naves
 */
public class SessionFactoryDbName implements Serializable{
    
    static Map<String, SessionFactory> mapSessionFactory = new HashMap<>(2);
    
    public static Session getCurrentSessionByName(String strDbName){
        return getSessionFactoryByName(strDbName).openSession();
    }
    
    private static SessionFactory getSessionFactoryByName(String strDbName){
        if (mapSessionFactory.containsKey(strDbName)){
            return mapSessionFactory.get(strDbName);
        } else{
            SessionFactory sessionFactory = buildSessionFactoryByDbName(strDbName);
            mapSessionFactory.put(strDbName, sessionFactory);
            return sessionFactory;
        }
    }

    private static SessionFactory buildSessionFactoryByDbName(String strDbName) {
        
        SessionFactory sessionFactory = null;
        try{
            switch (strDbName) {
//                case "Public":
//                    System.out.println("Buscando Session no banco dados : " + strDbName);
//                    sessionFactory = new AnnotationConfiguration().configure("hibernate"+strDbName+".cfg.xml").buildSessionFactory();
//                    break;
                default:
                    System.out.println("Buscando Session no banco dados : " + strDbName);
                    sessionFactory = new AnnotationConfiguration().configure("hibernate"+strDbName+".cfg.xml").buildSessionFactory();
            }
        }catch (HibernateException ex){
            System.out.println(ex.getMessage());
            mapSessionFactory.clear();
        }
        
        return sessionFactory;
    }
    
}
