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
                lnTabela.setTabInCodigo(IrrfDao.grabLnTabelaNextId());
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
                bSalvo = incluirTabela(lnTabela);
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
            lnTabela.getListLnTabelaItem().stream().forEach((lnTabelaItem) -> {
                IrrfDao.deleteObject(lnTabelaItem);
            });
            IrrfDao.deleteObject(lnTabela);
            return true;
        } catch (HibernateException ex){
            mensagem = "Ocorreu um erro na gravação!";
            return false;
        }
        
    }

    public List<Tabela> buscaTabela(Integer ttbInCodigo){
        Tabela tabela;
        
        List<Tabela> listaTabela = new ArrayList<>();
        List<LnTabela> listTabelaDao = IrrfDao.grabTabela(ttbInCodigo);
        
        for (LnTabela lnTabela : listTabelaDao) {
            lnTabela.setListLnTabelaItem(IrrfDao.grabTabelaItem(lnTabela.getTabInCodigo()));
            
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
