/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnAgendaconta;
import br.com.ln.entity.LnContadependente;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.entity.LnTipoagenda;
import br.com.ln.hibernate.SessionFactoryDbName;
import br.com.ln.objeto.Conta;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaDao extends GenericDao{

    public static List<LnContadependente> buscaListaContaDependente(Conta conta) {
        
        List<LnContadependente> listaContaDep = null;
        Session session = null;
        Transaction tx;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnContadependente.findByCtaInCodigo");
            query.setInteger("ctaInCodigo", conta.getIdConta());
            listaContaDep = query.list();
            tx.commit();
            
        }finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listaContaDep;
    }

    public static List<LnPlanoconta> buscaListaContaDependente(Character ativo){
        
        List<LnPlanoconta> listaPlanoConta= null;
        Session session = null;
        Transaction tx;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query  = session.getNamedQuery("LnPlanoconta.findByCtaChAtivo");
            query.setCharacter("ctaChAtivo", ativo);
            listaPlanoConta = query.list();
            tx.commit();
            
        }finally{
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        
        return listaPlanoConta;
    }
    
    public static List<LnTipoagenda> grabListAgenda(){
        
        Session session = null;
        Transaction tx;
        List<LnTipoagenda> listaTipoAgenda = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName(VarComuns.strDbName);
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("LnTipoagenda.findAll");
            listaTipoAgenda = query.list();
            tx.commit();
            
        } finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listaTipoAgenda;
    }

    public static List<LnAgendaconta> buscaListaAgendaConta(Conta conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
