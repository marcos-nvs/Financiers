/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;


/**
 *
 * @author Marcos Naves
 */
public class GenericDao implements Serializable{

    final static Logger logger = Logger.getLogger(GenericDao.class);
    static SimpleDateFormat formatOnlyYear = new SimpleDateFormat("yyyy");
    
    /**
     * Lista Objetos genericos
     * @param clazz
     * @param strDbName
     * @return List Object
     */
    public static List grabListObject(Class clazz) {

        Session session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
        Transaction tx = session.beginTransaction();
        List result;

        try {
            Criteria criteria = session.createCriteria(clazz);
            result = criteria.list();
            tx.commit();

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return result;
    }
    
    
     /**
     * Salvar ou Atualizar o Objeto
     * @param obj save or update a obj
     * @param strDbName
     *
     */
    public static void saveOrUpdateObject(Object obj) {
        Session session = null;
        Transaction tx;
        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException ex){
            logger.error("Ocorreu um erro durante a SaveOrUpdate");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Date grabDateFromDB() {

        Session session = null;
        Transaction tx = null;
        Date rightNow = null;
        try {

            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();

            Query query = session.createSQLQuery("select now()");
            List listQuery = query.list();

            if (listQuery != null && !listQuery.isEmpty()) {
                for (int i = 0; i < listQuery.size(); i++) {
                    java.sql.Timestamp rightNowTimeStamp = (java.sql.Timestamp) listQuery.get(i);
                    rightNow = new Date(rightNowTimeStamp.getTime());
                    break;
                }
            }

        } catch (HibernateException xcp) {
            System.out.println(xcp.getMessage()); 
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return rightNow;
    }

    /**
     *
     * @param obj save a obj
     * @param strDbName *
     */
    public static void saveObject(Object obj) {
        Session session = null;
        Transaction tx;
        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (HibernateException ex){
            logger.error("Ocorreu um erro durante a Save");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     *
     * @param obj delete object
     * @param strDbName
     */
    public static void deleteObject(Object obj) {
        Session session = null;
        Transaction tx;
        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException ex){
            logger.error("Ocorreu um erro durante a Delete");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }
    
    public static String grabIdByNextValueStringSQL(String strSql) {

        Session session = null;
        String strResult = null;
        List result;

        try {
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            Transaction tx = session.beginTransaction();
            org.hibernate.Query query = session.createSQLQuery(strSql);
            result = query.list();
            tx.commit();
            if (result != null) {
                strResult = result.get(0).toString();
            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return strResult;

    }
    
    
    
//    public static List<LnConta> grabContaCategoria(Integer catInCodigo){
//        
//        Session session = null;
//        Transaction tx = null;
//        List<LnUsuario> listUsuario = null;
//        
//        try{
//            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
//            tx = session.beginTransaction();
//            
//            Query query = session.getNamedQuery("LnUsuario.findByPerInCodigo");
//            query.setInteger("perInCodigo", perInCodigo);
//            listUsuario = query.list();
//            tx.commit();
//            
//        }finally{
//            if (session != null && session.isOpen()){
//                session.close();
//            }
//        }
//        return listUsuario;
//    }
    
    
    /**
     *
     * @param clazz
     * @param id
     * @param strDbName
     * @return Object
     */

//    public static Object getObject(Class clazz, long id, String strDbName) {
//
//        Session session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//        Transaction tx = session.beginTransaction();
//
//        Object obj = null;
//        try {
//            obj = session.get(clazz, id);
//            tx.commit();
//
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//
//    }
//
//    /**
//     *
//     * @param clazz
//     * @param id
//     * @param strDbName
//     * @return Object
//     */
//    public static Object getObject(Class clazz, String id, String strDbName) {
//
//        Session session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//        Transaction tx = session.beginTransaction();
//
//        Object obj = null;
//        try {
//            obj = session.get(clazz, id);
//            tx.commit();
//
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return obj;
//    }
//
//    /**
//     *
//     * @param clazz
//     * @param idPk
//     * @param strDbName
//     * @return Object
//     */
//    public static Object getObject(Class clazz, Object idPk, String strDbName) {
//
//        Session session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//        Transaction tx = session.beginTransaction();
//
//        Object obj = null;
//        try {
//            obj = session.get(clazz, (Serializable) idPk);
//            tx.commit();
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//    }
//
//
//    /**
//     *
//     * @param classBean
//     * @param strKey
//     * @param value
//     * @param strDbName
//     * @return a first Object from a List of obejcts
//     */
//    static public Object getObjectByKey(Class classBean, String strKey, Object value, String strDbName) {
//
//        Session session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//        Transaction tx = session.beginTransaction();
//
//        Object obj = null;
//        try {
//            List result;
//            Criteria criteria = session.createCriteria(classBean);
//
//            if (strKey != null) {
//                criteria.add(Restrictions.eq(strKey, value));
//            }
//            result = criteria.list();
//            tx.commit();
//
//            if (result != null && result.size() > 0) {
//                obj = result.get(0);
//            }
//
//        } catch (HibernateException xcp) {
//            System.out.println(xcp.getMessage());
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//    }
//
//    /**
//     *
//     * @param classBean
//     * @param strKey
//     * @param strKey2 * @param value
//     * @param value
//     * @param strDbName
//     * @param value2
//     * @return a first Object from a List of obejcts
//     */
//    static public Object getObjectByKey(Class classBean, String strKey, String strKey2, Object value, Object value2, String strDbName) {
//
//        Session session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//        Transaction tx = session.beginTransaction();
//
//        Object obj = null;
//        try {
//            List result;
//            Criteria criteria = session.createCriteria(classBean);
//
//            if (strKey != null && strKey2 != null) {
//                criteria.add(Restrictions.eq(strKey, value));
//                criteria.add(Restrictions.eq(strKey2, value2));
//            }
//            result = criteria.list();
//            tx.commit();
//
//            if (result != null && result.size() > 0) {
//                obj = result.get(0);
//            }
//        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//    }
//
//    /**
//     *
//     * @param classBean
//     * @param strKey
//     * @param value
//     * @param strDbName * @return a List of obejcts
//     * @return
//     */
//    static public java.util.List getListOfObjectByKey(Class classBean, String strKey, Object value, String strDbName) {
//
//        Session session = null;
//        List result = null;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            Transaction tx = session.beginTransaction();
//            Criteria criteria = session.createCriteria(classBean);
//
//            if (strKey != null) {
//                criteria.add(Restrictions.eq(strKey, value));
//            }
//            result = criteria.list();
//
//            tx.commit();
//        } catch (HibernateException xcp) {
//            System.out.println(xcp.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return result;
//    }
//
//    static public java.util.List getListOfObjectByKeyEq(Class classBean, String strKey, Object value, String orderByField, boolean orderBy, String strDbName) {
//
//        Session session = null;
//        List result = null;
//        try {
//
//            if (strKey != null) {
//                session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//                Transaction tx = session.beginTransaction();
//
//                Criteria criteria = session.createCriteria(classBean);
//
//                criteria.add(Restrictions.eq(strKey, value));
//                if (orderBy) {
//                    criteria.addOrder(Order.asc(strDbName).asc(orderByField));
//                } else {
//                    criteria.addOrder(Order.desc(strDbName).desc(orderByField));
//                }
//                tx.commit();
//
//                result = criteria.list();
//            }
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return result;
//    }
//
//
//    public static Object saveObjectReturn(Object obj, String strDbName) {
//        Session session = null;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            Transaction tx = session.beginTransaction();
//            session.save(obj);
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//    }
//
//    /**
//     *
//     * @param list
//     */
//    public static void saveObjectList(List list, String strDbName) {
//        Session session = null;
//        Transaction tx;
//
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//
//            for (Object obj : list) {
//                session.save(obj);
//            }
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//    }
//
//    /**
//     *
//     * @param list
//     * @param strDbName
//     */
//    public static void saveOrUpdateObjectList(List list, String strDbName) {
//
//        Session session = null;
//        Transaction tx;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//
//            for (Object obj : list) {
//                session.saveOrUpdate(obj);
//            }
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//    }
//
//    /**
//     *
//     *
//     * @param obj
//     * @param strDbName
//     */
//    public static void updateObject(Object obj, String strDbName) {
//        Session session = null;
//        Transaction tx;
//
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//            session.update(obj);
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    /**
//     *
//     * @param obj
//     * @param strDbName
//     * @return
//     */
//    public static Object updateObjectReturnObject(Object obj, String strDbName) {
//        Session session = null;
//        Transaction tx;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//
//            session.update(obj);
//            tx.commit();
//
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return obj;
//    }
//
//    /**
//     *
//     * @param list
//     * @param session
//     */
//    public static void updateObjectList(List list, Session session) {
//
//        try {
//            for (Object obj : list) {
//                session.update(obj);
//            }
//        } finally {
//            if (session != null && session.isOpen()) {
//            }
//        }
//    }
//
//    public static void updateObjectList(List list, String strDbName) {
//
//        Session session = null;
//
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            Transaction tx = session.beginTransaction();
//
//            for (Object obj : list) {
//                session.update(obj);
//            }
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//    }
//
//
//    /**
//     *
//     * @param list
//     * @param strDbName
//     */
//    public static void deleteObjectList(List list, String strDbName) {
//
//        Session session = null;
//        Transaction tx;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//
//            for (Object obj : list) {
//                session.delete(obj);
//            }
//            tx.commit();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    static public List<Object> getListObjectsByOrs(Class myClass, String strFieldName, List listArgs, String strDbName) {
//
//        Session session = null;
//
//        List result = null;
//        if (listArgs != null && listArgs.size() > 0) {
//
//            try {
//                session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//                Transaction tx = session.beginTransaction();
//
//                Criteria criteria = session.createCriteria(myClass);
//
//                Disjunction disj;
//                Property property = Property.forName(strFieldName);
//
//                if (listArgs != null && listArgs.size() > 0) {
//                    disj = Restrictions.disjunction();
//                    for (Object strArgs : listArgs) {
//                        disj.add(property.eq(strArgs));
//                    }
//                    tx.commit();
//                    result = criteria.add(disj).list();
//
//                }
//
//            } finally {
//                if (session != null && session.isOpen()) {
//                    session.close();
//                }
//            }
//
//        }
//        return result;
//    }
//
//    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs, int intMaxresult, String strKeyOrderBy, boolean blOrderBy, String strDbName) {
//        List result = null;
//        Session session = null;
//
//        if (mapArgs != null && mapArgs.size() > 0) {
//
//            try {
//                session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//                Transaction tx = session.beginTransaction();
//
//                Criteria criteria = session.createCriteria(myClass);
//                Iterator iter = mapArgs.entrySet().iterator();
//
//                while (iter.hasNext()) {
//                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
//                }
//
//                if (blOrderBy) {
//                    criteria.addOrder(Order.asc(strKeyOrderBy));
//                } else {
//                    criteria.addOrder(Order.desc(strKeyOrderBy));
//                }
//
//                criteria.setMaxResults(intMaxresult);
//
//                tx.commit();
//                result = criteria.list();
//
//            } finally {
//                if (session != null && session.isOpen()) {
//                    session.close();
//                }
//            }
//
//        }
//        return result;
//
//    }
//
//    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs, String strDbName) {
//        List result = null;
//        Session session = null;
//
//        if (mapArgs != null && mapArgs.size() > 0) {
//
//            try {
//                session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//                Transaction tx = session.beginTransaction();
//
//                Criteria criteria = session.createCriteria(myClass);
//                Iterator iter = mapArgs.entrySet().iterator();
//
//                while (iter.hasNext()) {
//                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
//                }
//
//                tx.commit();
//                result = criteria.list();
//
//            } catch (HibernateException xcp) {
//                System.out.println(xcp.getMessage());
//            } finally {
//                if (session != null && session.isOpen()) {
//                    session.close();
//                }
//            }
//
//        }
//        return result;
//
//    }
//
//    static public List getListObjectsByAnds_Ors(Class myClass, Map<String, Object> mapArgsAnds, String strFieldName, List listArgsOrs, String strDbName) {
//
//        List resutl = null;
//        Session session = null;
//
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            Transaction tx = session.beginTransaction();
//            Criteria criteria = session.createCriteria(myClass);
//
//            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {
//
//                Iterator iter = mapArgsAnds.entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
//                }
//            }
//
//            if (listArgsOrs != null && listArgsOrs.size() > 0) {
//                Disjunction disj;
//                Property property = Property.forName(strFieldName);
//
//                if (listArgsOrs.size() > 0) {
//                    disj = Restrictions.disjunction();
//                    for (Object strArgs : listArgsOrs) {
//                        disj.add(property.eq(strArgs));
//                    }
//                    resutl = criteria.add(disj).list();
//                }
//                tx.commit();
//                if (resutl == null) {
//                    resutl = criteria.list();
//                }
//
//            }
//
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return resutl;
//    }
//
//    static public List getListObjectsByAnds_Ors_Dates(Class myClass,
//            Map<String, Object> mapArgsAnds,
//            Map<String, List> mapArgsOrs,
//            String strDateFieldName, Date dtStart, Date dtEnd, int intMaxResults, String strDbName) {
//        Session session = null;
//        Transaction tx = null;
//
//        List result = null;
//        try {
//            session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//            tx = session.beginTransaction();
//            Criteria criteria = session.createCriteria(myClass);
//
//            if (dtStart != null && dtEnd != null && strDateFieldName != null) {
//                criteria.add(Expression.between(strDateFieldName, dtStart, dtEnd));
//            }
//
//            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {
//
//                Iterator iter = mapArgsAnds.entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
//                }
//            }
//
//            if (mapArgsOrs != null && mapArgsOrs.size() > 0) {
//
//                Iterator iter = mapArgsOrs.entrySet().iterator();
//                Disjunction disj;
//                Property property;
//
//                while (iter.hasNext()) {
//                    disj = Restrictions.disjunction();
//                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//                    property = Property.forName(pair.getKey());
//                    List<Object> l = (List<Object>) pair.getValue();
//                    for (Object obj : l) {
//                        disj.add(property.eq(obj));
//                    }
//
//                    criteria.add(disj);
//                }
//                criteria.setMaxResults(intMaxResults);
//                tx.commit();
//                result = criteria.list();
//            }
//
//            if (result == null) {
//                criteria.setMaxResults(intMaxResults);
//                tx.commit();
//                result = criteria.list();
//            }
//
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return result;
//
//    }
//
//    static public java.util.List getListOfObjectByDate(Class classBean, String strKey, Object value, String strKeyDt, Date dt, boolean blBiggerOrLess, String strDbName) {
//
//        List result = null;
//        Session session = null;
//
//        try {
//
//            if (strKey != null) {
//                session = SessionFactoryDbName.getCurrentSessionByName(strDbName);
//                Transaction tx = session.beginTransaction();
//                Criteria criteria = session.createCriteria(classBean);
//                criteria.add(Restrictions.eq(strKey, value));
//                criteria.add(Expression.ge(strKeyDt, dt));
//                criteria.addOrder(Order.desc(strKey));
//                tx.commit();
//
//                result = criteria.list();
//            }
//        } catch (HibernateException xcp) {
//            System.out.println(xcp.getMessage());
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//
//        return result;
//
//    }
//
//
//
}
