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
        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + " ";

        if (tabela.getNomeTabela() == null || tabela.getNomeTabela().equals("")) {
            mensagem = mensagem + bundle.getString("ln.texto.descricao") + "; ";
            validado = false;
        }
        if ((tabela.getDataInicial() == null || tabela.getDataFinal() == null) || tabela.getDataInicial().after(tabela.getDataFinal())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfdatainicialmaior")+"; ";
            validado = false;
        }
        if ((tabela.getDataFinal() == null || tabela.getDataInicial() == null) || tabela.getDataFinal().before(tabela.getDataInicial())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfdatafinalmenor") + "; ";
            validado = false;
        }
        if (tabelaItem.getValorInicial() == null || (tabelaItem.getValorInicial() >= tabelaItem.getValorFinal())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvalorinicial") + "; ";
            validado = false;
        } else {
        }
        if (tabelaItem.getValorFinal() == null || (tabelaItem.getValorFinal().equals(0d) && tabelaItem.getValorFinal() <= tabelaItem.getValorInicial())) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvalorfinal") + "; ";
            validado = false;
        }
        if (tabelaItem.getQtdDependente() == null) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfqtddependente") + "; ";
            validado = false;
        }
        if (tabelaItem.getPercentual() == null) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfpercentual") + "; ";
            validado = false;
        }
        if (tabelaItem.getValorDesconto() == null) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvlrdesconto") + "; ";
            validado = false;
        }
        if (tabelaItem.getValorDependente() == null) {
            mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfvlrdependente") + "; ";
            validado = false;
        }
        
        if (tabela.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            
            List<LnTabela> listaTabela = TabelaDao.grabLnTabelaDate(1, tabela.getDataInicial(), tabela.getDataFinal());

            if (listaTabela != null && !listaTabela.isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.mb.frase.tabelairrfdataintercalada") + "; ";
                validado = false;
            }
        }
        
        return validado;
    }
}
