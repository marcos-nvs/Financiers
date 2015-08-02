/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.TabelaDao;
import br.com.ln.entity.LnTabela;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class IpvaFuncoes {
    
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
        if (tabelaItem.getOrigem() == null) {
            mensagem = mensagem + "Origem do Carro; ";
            validado = false;
        }
        if (tabelaItem.getTipo() == null) {
            mensagem = mensagem + "Tipo Combustivel; ";
            validado = false;
        }
        if (tabelaItem.getPercentual() == null) {
            mensagem = mensagem + "Percentual; ";
            validado = false;
        }
        
        List<LnTabela> listaTabela = TabelaDao.grabLnTabelaDate(3, tabela.getDataInicial(), tabela.getDataFinal());
        
        if (listaTabela == null && listaTabela.isEmpty() && listaTabela.size() > 0){
            mensagem = mensagem + "Verificar as datas, nao pode haver outra tabela com aa mesmas datas ou intercaladas; ";
            validado = false;
        }
        return validado;
    }
    
    public boolean verificaListaRepetida(List<TabelaItem> listTabelaItem, TabelaItem NTabelaItem){
        
        for (TabelaItem tbItem : listTabelaItem) {
            if (tbItem.getOrigem().equals(NTabelaItem.getOrigem()) && tbItem.getTipo().equals(NTabelaItem.getTipo())){
                mensagem = "Item ja existe na tabela";
                return false;
            }
        }
        return true;
    }
}
 