/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.IrrfDao;
import br.com.ln.entity.LnTabela;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcos Naves
 */
public class TabelaFuncoes implements Serializable{
    
    public String mensagem;
    
    public boolean gravaTabela(List<LnTabela> listTabela){
        mensagem = "";
        boolean bSalvo = false;

        for (LnTabela lnTabela : listTabela) {
            switch (lnTabela.getTipoFuncao()) {
                case Incluir:
                    bSalvo = incluirTabela(lnTabela);
                    break;
                case Alterar:
                    break;
                case Excluir:
                    break;
            }
        }
        return bSalvo;
    }

    private boolean incluirTabela(LnTabela lnTabela) {
        Integer codTabela = IrrfDao.grabLnTabelaNextId();
        lnTabela.setTabInCodigo(codTabela);
        
        try{
            IrrfDao.saveObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
    }
    
}
