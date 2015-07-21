/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.TabelaDao;
import br.com.ln.entity.LnTabela;
import br.com.ln.entity.LnTabelaItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
                lnTabela.setTabInCodigo(TabelaDao.grabLnTabelaNextId());
                bSalvo = incluirTabela(lnTabela);
                break;
            case Alterar:
                bSalvo = AlterarTabela(lnTabela);
                break;
            case Excluir:
                bSalvo = excluirTabela(lnTabela);
                break;
        }
        return bSalvo;
    }

    public boolean gravaTabelaItem(LnTabelaItem lnTabelaItem){
        mensagem = "";
        boolean bSalvo = false;

        switch (lnTabelaItem.getTipoFuncao()) {
            case Incluir:
                lnTabelaItem.setTaiInCodigo(TabelaDao.grabLnTabelaItemNextId());
                bSalvo = incluirTabelaItem(lnTabelaItem);
                break;
            case Alterar:
                bSalvo = true;
                break;
            case Excluir:
                bSalvo = excluirTabelaItem(lnTabelaItem);
                break;
        }
        return bSalvo;
    }

    private boolean incluirTabela(LnTabela lnTabela) {
        boolean bSalvo = false;
        try{
            for (LnTabelaItem lnTabelaItem : lnTabela.getListLnTabelaItem()){
                lnTabelaItem.setTabInCodigo(lnTabela.getTabInCodigo());
                bSalvo = gravaTabelaItem(lnTabelaItem);
            }
            
            if (bSalvo) {
                TabelaDao.saveObject(lnTabela);
                return true;
            } else {
                return false;
            }
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
    }

    private boolean AlterarTabela(LnTabela lnTabela) {
        
        for (LnTabelaItem lnTabelaItem : lnTabela.getListLnTabelaItem()){
            gravaTabelaItem(lnTabelaItem);
        }

        try{
            TabelaDao.saveOrUpdateObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
    }
    
    private boolean excluirTabela(LnTabela lnTabela) {
        try{
            lnTabela.getListLnTabelaItem().stream().forEach((lnTabelaItem) -> {
                TabelaDao.deleteObject(lnTabelaItem);
            });
            TabelaDao.deleteObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
        
    }
    
    private boolean incluirTabelaItem(LnTabelaItem lnTabelaItem) {

        try {
            TabelaDao.saveObject(lnTabelaItem);
            return true;
        } catch (HibernateException ex) {
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
    }

    private boolean excluirTabelaItem(LnTabelaItem lnTabelaItem){
        
        try{
            TabelaDao.deleteObject(lnTabelaItem);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na exclusao do item!";
            return false;
        }
    }

    public List<Tabela> buscaTabela(Integer ttbInCodigo){
        Tabela tabela;
        
        List<Tabela> listaTabela = new ArrayList<>();
        List<LnTabela> listTabelaDao = TabelaDao.grabTabela(ttbInCodigo);
        
        for (LnTabela lnTabela : listTabelaDao) {
            lnTabela.setListLnTabelaItem(TabelaDao.grabTabelaItem(lnTabela.getTabInCodigo()));
            
            tabela = new Tabela();
            tabela.setCodigoTabela(lnTabela.getTabInCodigo());
            tabela.setNomeTabela(lnTabela.getTabStDescricao());
            tabela.setDataInicial(lnTabela.getTabDtInicio());
            tabela.setDataFinal(lnTabela.getTabDtFinal());
            
            tabela.setListTabelaItem(buscaTabelaItem(lnTabela.getListLnTabelaItem()));

            listaTabela.add(tabela);
        }

        return listaTabela;
    }
    
    private List<TabelaItem> buscaTabelaItem(List<LnTabelaItem> listTabelaItemDao){
        
        List<TabelaItem> listaTabelaItem = new ArrayList<>();
        TabelaItem tabelaItem;
        
        for (LnTabelaItem lnTabelaItem : listTabelaItemDao) {
            tabelaItem = new TabelaItem();
            
            tabelaItem.setCodigoTabela(lnTabelaItem.getTabInCodigo());
            tabelaItem.setCodigoTabItem(lnTabelaItem.getTaiInCodigo());
            tabelaItem.setPercentual(lnTabelaItem.getTaiFlPercentual());
            tabelaItem.setQtdDependente(lnTabelaItem.getTaiInQtddependente());
            tabelaItem.setValorDependente(lnTabelaItem.getTaiFlDependente());
            tabelaItem.setValorDesconto(lnTabelaItem.getTaiFlDesconto());
            tabelaItem.setValorFinal(lnTabelaItem.getTaiFlFinal());
            tabelaItem.setValorInicial(lnTabelaItem.getTaiFlInicio());

            listaTabelaItem.add(tabelaItem);
        }
        
        return listaTabelaItem;
    }

    
    
}
