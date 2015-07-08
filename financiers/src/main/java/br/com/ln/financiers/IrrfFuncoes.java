/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.IrrfDao;
import br.com.ln.entity.LnTabela;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class IrrfFuncoes implements Serializable  {
    
    private Integer codigoTabItem = 0;
    
    public List<Tabela> buscaTabela(){

        
        Tabela tabela = new Tabela();
        TabelaItem tabelaItem = new TabelaItem();
        List<Tabela> listaTabela = new ArrayList<>();
        List<TabelaItem> listTabelaItem = new ArrayList<>();
        
        List<LnTabela> listTabela = IrrfDao.grabDescricaoTabela();
        List<LnTabela> listTabelaDetalhe = new ArrayList<>();
        
        for (LnTabela tabelaDesc : listTabela) {
            tabela.setCodigoTabela(tabelaDesc.getTtbInCodigo());
            tabela.setDataFinal(tabelaDesc.getTabDtFinal());
            tabela.setDataInicial(tabelaDesc.getTabDtInicio());
            tabela.setIdCodigo(tabelaDesc.getTabInCodigo());
            tabela.setNomeTabela(tabelaDesc.getTabStDescricao());
            
            listTabelaDetalhe = IrrfDao.grabDetalheTabela(tabelaDesc.getTabInCodigo());
            listTabelaItem.clear();
            
            for (LnTabela tabelaDetalhe : listTabelaDetalhe) {
                tabelaItem.setPercentual(tabelaDetalhe.getTabFlPercentual());
                tabelaItem.setQtdDependente(tabelaDetalhe.getTabFlQtddependente());
                tabelaItem.setValorDependente(tabelaItem.getValorDependente());
                tabelaItem.setValorDesconto(tabelaItem.getValorDesconto());
                tabelaItem.setValorFinal(tabelaItem.getValorFinal());
                tabelaItem.setValorInicial(tabelaItem.getValorInicial());
                
                listTabelaItem.add(tabelaItem);
            }
            
            tabela.setListTabelaItem(listTabelaItem);
            listaTabela.add(tabela);
        }
        return listaTabela;
    } 
    
    public Integer calcIdTabelaItem(){
        Integer i = codigoTabItem + 1;
        System.out.println("i : " + i.toString());
        codigoTabItem = i;
        System.out.println("codigoitem : " + codigoTabItem.toString());
        return codigoTabItem;
    }
    
    
}
