/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.entity.LnTabela;
import br.com.ln.financiers.IofFuncoes;
import br.com.ln.financiers.Tabela;
import br.com.ln.financiers.TabelaFuncoes;
import br.com.ln.financiers.TabelaItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "iofView")
public class IofView implements Serializable {
    
    private Integer idCodigo;
    private Integer codigoTabela;
    private String nomeTabela;
    private Date dataInicial;
    private Date dataFinal;
    private Integer codigoTabItem;

    private Double percentual;
    private final Integer TIPOTABELA = 4;

    private LnTabela lnTabela;
    private Tabela tabela;
    private TabelaItem tabelaItem;
    private List<TabelaItem> listTabelaItem;
    private List<Tabela> listTabela;
    private final TabelaFuncoes tabelaFuncao;
    private final IofFuncoes iofFuncao;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public IofView() {
        tabela = new Tabela();
        tabelaItem = new TabelaItem();
        tabelaFuncao = new TabelaFuncoes();
        iofFuncao = new IofFuncoes();
        listTabela = tabelaFuncao.montaTabela(TIPOTABELA);
        listTabelaItem = new ArrayList<>();
    }
}
