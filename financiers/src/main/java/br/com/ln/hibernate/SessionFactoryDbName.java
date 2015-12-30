/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Fabrica de conexÃ£o
 * @author Marcos Naves
 */
public class SessionFactoryDbName implements Serializable{
    
    static Map<String, SessionFactory> mapSessionFactory = new HashMap<>(2);
    static Logger logger = Logger.getLogger(SessionFactoryDbName.class);
    
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
        try {
            logger.info("Buscando Session no banco dados : " + strDbName);
            
            
            Configuration cfg = new Configuration().configure();
            cfg.configure("hibernate.cfg.xml");
//            cfg.setProperty("hibernate.connection.datasource", "jdbc/Financiers");
            cfg.setProperty("hibernate.connection.datasource", "java:/jdbc/financiers");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            cfg.setProperty("hibernate.default_schema", strDbName);
            
//            SchemaExport export = new SchemaExport(cfg);
//            export.create(true, true);
            
            StandardServiceRegistry seviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(seviceRegistry);
//           sessionFactory = cfg.configure().buildSessionFactory();
        } catch (HibernateException ex) {
            mapSessionFactory.clear();
            logger.fatal(ex);
        }
        return sessionFactory;
    }
}
