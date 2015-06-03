/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnCategoria;
import br.com.ln.entity.LnHistorico;
import br.com.ln.hibernate.Postgress;

/**
 *
 * @author Marcos Naves
 */
public class CategoriaFuncoes {
    
    private String mensagem;
    private LnHistorico lnHistorico;
    
    public String categoria(LnCategoria lnCategoria){
        mensagem = "";
        lnHistorico = new LnHistorico();
        
        switch (lnCategoria.getTipoFuncao()){
            case Incluir:
                incluirCategoria(lnCategoria);
                break;
            case Alterar:
                alterarCategoria(lnCategoria);
                break;
            case Excluir:
                excluirCategoria(lnCategoria);
                break;
        }
        return mensagem;
    }

    private void incluirCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            lnCategoria.setCatInCodigo(Postgress.grabLnCategoriaNextId());
            Postgress.saveObject(lnCategoria);
            mensagem = "Sucesso";
        } else {
            mensagem = "Ocorreu um problema durante a gravação.";
        }
    }

    private void alterarCategoria(LnCategoria lnCategoria) {
    }

    private void excluirCategoria(LnCategoria lnCategoria) {
    }
}
