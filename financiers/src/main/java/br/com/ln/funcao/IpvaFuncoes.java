/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.dao.TabelaDao;
import br.com.ln.entity.LnTabela;
import br.com.ln.objeto.Tabela;
import br.com.ln.objeto.TabelaItem;
import br.com.ln.tipos.TipoFuncao;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class IpvaFuncoes {
    
    public String mensagem;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public boolean verificaInformacoes(Tabela tabela, TabelaItem tabelaItem) {
        boolean validado = true;
        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + " ";

        if (tabela.getNomeTabela() == null || tabela.getNomeTabela().equals("")) {
            mensagem = mensagem + bundle.getString("ln.texto.descricao") +  "; ";
            validado = false;
        }
        if ((tabela.getDataInicial() == null || tabela.getDataFinal() == null) || tabela.getDataInicial().after(tabela.getDataFinal())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvalorinicial") + "; ";
            validado = false;
        }
        if ((tabela.getDataFinal() == null || tabela.getDataInicial() == null) || tabela.getDataFinal().before(tabela.getDataInicial())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvalorfinal") + "; ";
            validado = false;
        }
        if (tabelaItem.getOrigem() == null) {
            mensagem = mensagem + bundle.getString("ln.texto.origemcarro") + "; ";
            validado = false;
        }
        if (tabelaItem.getTipo() == null) {
            mensagem = mensagem + bundle.getString("ln.texto.tipocombustivel") + "; ";
            validado = false;
        }
        if (tabelaItem.getPercentual() == null) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfpercentual") + "; ";
            validado = false;
        }
        
        if (tabela.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            List<LnTabela> listaTabela = TabelaDao.grabLnTabelaDate(3, tabela.getDataInicial(), tabela.getDataFinal());

            if (listaTabela == null && listaTabela.isEmpty() && listaTabela.size() > 0) {
                mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfdataintercalada") + " ";
                validado = false;
            }
        }

        return validado;
    }
    
    public boolean verificaListaRepetida(List<TabelaItem> listTabelaItem, TabelaItem NTabelaItem){
        
        for (TabelaItem tbItem : listTabelaItem) {
            if (tbItem.getOrigem().equals(NTabelaItem.getOrigem()) && tbItem.getTipo().equals(NTabelaItem.getTipo())){
                mensagem = bundle.getString("ln.mb.frase.itemexistente");
                return false;
            }
        }
        return true;
    }
}
 