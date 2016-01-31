/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.dao.CategoriaDao;
import br.com.ln.dao.PlanoContaDao;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.objeto.Ativo;
import br.com.ln.objeto.Banco;
import br.com.ln.objeto.CartaoCredito;
import br.com.ln.objeto.ConfiguracaoAlerta;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.Emprestimo;
import br.com.ln.objeto.Financiamento;
import br.com.ln.objeto.ReceitaDespesa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaFuncoes implements Serializable {

    public Integer tipoConta(Integer categoria) {
        return CategoriaDao.grabTipoContaPorCategoria(categoria);
    }

    public List<Conta> montaConta() {

        List<LnPlanoconta> listaPlanoconta = PlanoContaDao.grabContaAtivo();
        List<Conta> listaConta = new ArrayList<>();

        if (listaPlanoconta != null) {

            for (LnPlanoconta planoconta : listaPlanoconta) {

                Conta conta = new Conta();

                if (planoconta != null) {
                    conta.setbContaAtiva(planoconta.getCtaChAtivo().equals('S'));
                    conta.setCodigoCategoria(planoconta.getCatInCodigo());
                    conta.setCodigoConta(planoconta.getCtaInCodigo());
                    conta.setDescricaoConta(planoconta.getCtaStDescricao());
                    conta.setSaldoConta(planoconta.getCtaFlSaldoinicial());

                    Object obj = planoconta.getCtaStConfiguracao();

                    if (obj instanceof Ativo) {
                        conta.setAtivo((Ativo) obj);
                    }

                    if (obj instanceof Banco) {
                        conta.setBanco((Banco) obj);
                    }

                    if (obj instanceof CartaoCredito) {
                        conta.setCartaoCredito((CartaoCredito) obj);
                    }

                    if (obj instanceof Emprestimo) {
                        conta.setEmprestimo((Emprestimo) obj);
                    }

                    if (obj instanceof Financiamento) {
                        conta.setFinancimento((Financiamento) obj);
                    }

                    if (obj instanceof ReceitaDespesa) {
                        conta.setReceitaDespesa((ReceitaDespesa) obj);
                    }

                    obj = planoconta.getCtaStAlerta();

                    if (obj instanceof ConfiguracaoAlerta) {
                        conta.setConfiguracaoAlerta((ConfiguracaoAlerta) obj);
                    }
                }

                listaConta.add(conta);
            }

        }

        return listaConta;
    }
}
