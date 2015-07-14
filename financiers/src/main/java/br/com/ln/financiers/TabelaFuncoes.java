/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.IrrfDao;
import br.com.ln.entity.LnTabela;
import br.com.ln.entity.LnTabelaItem;
import java.io.Serializable;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcos Naves
 */
public class TabelaFuncoes implements Serializable{
    
    public String mensagem;
    
    public boolean gravaTabela(LnTabela lnTabela){
        mensagem = "";
        boolean bSalvo = false;

        switch (lnTabela.getTipoFuncao()) {
            case Incluir:
                bSalvo = incluirTabela(lnTabela);
                bSalvo = incluirTabelaItem(lnTabela);
                break;
            case Alterar:
                break;
            case Excluir:
                bSalvo = excluirTabela(lnTabela);
                break;
        }
        return bSalvo;
    }

    private boolean incluirTabela(LnTabela lnTabela) {
        lnTabela.setTabInCodigo(IrrfDao.grabLnTabelaNextId());
        
        try{
            IrrfDao.saveObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
    }

    private boolean incluirTabelaItem(LnTabela lnTabela) {
        
        boolean bSalvo = false;
        
        for (LnTabelaItem lnTabelaItem: lnTabela.getListLnTabelaItem()){
            lnTabelaItem.setTabInCodigo(lnTabela.getTabInCodigo());
            lnTabelaItem.setTaiInCodigo(IrrfDao.grabLnTabelaItemNextId());
            
            try{
                IrrfDao.saveObject(lnTabelaItem);
                bSalvo = true;
            } catch (HibernateException ex){
                mensagem = "Ocorreu um erro na gravação!";
                bSalvo = false;
                break;
            }
        }
        return bSalvo;
    }

    private boolean excluirTabela(LnTabela lnTabela) {
        try{
            for (LnTabelaItem lnTabelaItem : lnTabela.getListLnTabelaItem()){
                IrrfDao.deleteObject(lnTabelaItem);
            }
            IrrfDao.deleteObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
        
    }

    
}
