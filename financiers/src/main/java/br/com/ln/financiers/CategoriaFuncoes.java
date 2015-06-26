/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.dao.CategoriaDao;
import br.com.ln.entity.LnCategoria;

/**
 *
 * @author Marcos Naves
 */
public class CategoriaFuncoes {
    
    private String mensagem;
    private Historico historico;
    
    public String categoria(LnCategoria lnCategoria){
        mensagem = "";
        historico = new Historico();
        
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
//            lnCategoria.setCatInCodigo(GenericDao.grabLnCategoriaNextId());
            CategoriaDao.saveObject(lnCategoria);
            historico.gravaHistoricoModulo("Inclusão da Categoria : " + lnCategoria.getCatStDescricao());
            mensagem = "Sucesso";
        } else {
            mensagem = "Ocorreu um problema durante a gravação.";
        }
    }

    private void alterarCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            CategoriaDao.saveOrUpdateObject(lnCategoria);
            historico.gravaHistoricoModulo("Alteração da Categoria : " + lnCategoria.getCatStDescricao());
            mensagem = "Sucesso";
        } else {
            mensagem = "Ocorreu um problema durante a gravação";
        }
    }

    private void excluirCategoria(LnCategoria lnCategoria) {
        if (lnCategoria != null){
            CategoriaDao.deleteObject(lnCategoria);
            historico.gravaHistoricoModulo("Exclusão da Categoria : " + lnCategoria.getCatStDescricao());
            mensagem = "Sucesso";
        } else {
            mensagem = "Ocorreu um problema durante a exclusão";
        }
    }
}
