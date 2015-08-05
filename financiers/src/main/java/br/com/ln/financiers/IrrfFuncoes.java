/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.TabelaDao;
import br.com.ln.entity.LnTabela;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class IrrfFuncoes implements Serializable {

    public String mensagem;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

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
        
        List<LnTabela> listaTabela = TabelaDao.grabLnTabelaDate(1, tabela.getDataInicial(), tabela.getDataFinal());
        
        if (listaTabela != null && !listaTabela.isEmpty() ){
            mensagem = mensagem + "Verificar as datas, nao pode haver outra tabela com aa mesmas datas ou intercaladas; ";
            validado = false;
        }
        return validado;
    }
}
