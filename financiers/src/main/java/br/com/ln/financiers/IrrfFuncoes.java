/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.TabelaDao;
import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */
public class IrrfFuncoes implements Serializable {

    public String mensagem;

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
        if (TabelaDao.grabLnTabelaDate(1, tabela.getDataInicial(), tabela.getDataFinal()) != null){
            mensagem = mensagem + "Verificar data de inicio e final, nao pode haver outra tabela com a mesma data; ";
            validado = false;
        }
        return validado;
    }


}
