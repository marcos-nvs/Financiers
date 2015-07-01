/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.dao;

import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
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
public class EnderecoDao extends GenericDao implements Serializable{
    
    public static List<LnEndereco> grabListEnderecoCodigoCliente(Integer cliInCodigo){
        
        Session session = null;
        Transaction tx = null;
        List<LnEndereco> listEndereco = null;
        
        try{
            session = SessionFactoryDbName.getCurrentSessionByName("acessocontrol");
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("LnEndereco.findByCliInCodigo");
            query.setInteger("cliInCodigo", cliInCodigo);
            listEndereco = query.list();
            tx.commit();
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return listEndereco;
    }
    
}
