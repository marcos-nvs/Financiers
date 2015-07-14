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

/**
 *
 * @author Marcos Naves
 */
public class IrrfFuncoes implements Serializable {

    private Integer codigoTabItem = 0;
    public String mensagem;

    public List<Tabela> buscaTabela() {
        Tabela tabela;
        TabelaItem tabelaItem;
        
        List<Tabela> listaTabela = new ArrayList<>();
        List<TabelaItem> listTabelaItem = new ArrayList<>();

        List<LnTabela> listLnTabela = IrrfDao.grabTabela();
        List<LnTabelaItem> listLnTabelaItem;
        
        for (LnTabela lnTabela : listLnTabela) {
            tabela = new Tabela();
            
            tabela.setCodigoTabela(lnTabela.getTabInCodigo());
            tabela.setIdCodigo(lnTabela.getTtbInCodigo());
            tabela.setNomeTabela(lnTabela.getTabStDescricao());
            tabela.setDataInicial(lnTabela.getTabDtInicio());
            tabela.setDataFinal(lnTabela.getTabDtFinal());
            
            listLnTabelaItem = IrrfDao.grabTabelaItem(lnTabela.getTabInCodigo());
            
            if (listLnTabelaItem != null && listLnTabelaItem.size() > 0){
                for (LnTabelaItem lnTabelaItem : listLnTabelaItem) {
                    tabelaItem = new TabelaItem();
                    
                    tabelaItem.setCodigoTabItem(lnTabelaItem.getTaiInCodigo());
                    tabelaItem.setCodigoTabela(lnTabelaItem.getTabInCodigo());
                    tabelaItem.setValorInicial(lnTabelaItem.getTaiFlInicio());
                    tabelaItem.setValorFinal(lnTabelaItem.getTaiFlFinal());
                    tabelaItem.setPercentual(lnTabelaItem.getTaiFlPercentual());
                    tabelaItem.setQtdDependente(lnTabelaItem.getTaiInQtddependente());
                    tabelaItem.setValorDependente(lnTabelaItem.getTaiFlDependente());
                    tabelaItem.setValorDesconto(lnTabelaItem.getTaiFlDesconto());

                    listTabelaItem.add(tabelaItem);
                    
                }
            }
            
            tabela.setListTabelaItem(listTabelaItem);
            listaTabela.add(tabela);
        }
        return listaTabela;
    }

    public Integer calcIdTabelaItem() {
        Integer i = codigoTabItem + 1;
        codigoTabItem = i;
        return codigoTabItem;
    }

    public boolean verificaInformacoes(Tabela tabela, TabelaItem tabelaItem) {
        boolean validado = true;
        mensagem = "Verifique os dados: ";

        if (tabela.getNomeTabela() == null || tabela.getNomeTabela().equals("")) {
            mensagem = mensagem + "Descricao da tabela; ";
            validado = false;
        }
        if ((tabela.getDataInicial() == null || tabela.getDataFinal() == null) || tabela.getDataInicial().after(tabela.getDataFinal())) {
            mensagem = mensagem + "Data Inicial nao pode ser maior que data final e ambas nao podem estar vazias; ";
            validado = false;
        }
        if ((tabela.getDataFinal() == null || tabela.getDataInicial() == null) || tabela.getDataFinal().before(tabela.getDataInicial())) {
            mensagem = mensagem + "Data Final nao pode ser menor que data inicial e ambas nao podem estar vazias; ";
            validado = false;
        }
        if (tabelaItem.getValorInicial() == null || (tabelaItem.getValorInicial() >= tabelaItem.getValorFinal())) {
            mensagem = mensagem + "Valor Inicial nao pode ser igual ou maior que o valor final; ";
            validado = false;
        } else {
        }
        if (tabelaItem.getValorFinal() == null || (tabelaItem.getValorFinal().equals(0d) && tabelaItem.getValorFinal() <= tabelaItem.getValorInicial())) {
            mensagem = mensagem + "Valor Final nao pode igual ou menor que o inicial e nao pode ser Zero; ";
            validado = false;
        }
        if (tabelaItem.getQtdDependente() == null) {
            mensagem = mensagem + "Qtde Dependente; ";
            validado = false;
        }
        if (tabelaItem.getPercentual() == null) {
            mensagem = mensagem + "Percentual; ";
            validado = false;
        }
        if (tabelaItem.getValorDesconto() == null) {
            mensagem = mensagem + "Valor do Desconto; ";
            validado = false;
        }
        if (tabelaItem.getValorDependente() == null) {
            mensagem = mensagem + "Valor do Dependente; ";
            validado = false;
        }
        return validado;
    }
    
    public boolean tabela(LnTabela lnTabela){
        TabelaFuncoes tabelafuncao = new TabelaFuncoes();
        mensagem = tabelafuncao.mensagem;
        return tabelafuncao.gravaTabela(lnTabela);
    }
    

}