/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.comum.Historico;
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
import br.com.ln.tipos.TipoFuncao;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaFuncoes implements Serializable {

    public String mensagem;
    private Historico historico;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

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

                    Gson gson = new Gson();
                    Integer tipoConta = tipoConta(planoconta.getCatInCodigo());

                    switch (tipoConta) {
                        case 1:
                            conta.setAtivo(gson.fromJson(planoconta.getCtaStConfiguracao(), Ativo.class));
                            break;
                        case 3:
                            conta.setBanco(gson.fromJson(planoconta.getCtaStConfiguracao(), Banco.class));
                            break;
                        case 4:
                            conta.setCartaoCredito(gson.fromJson(planoconta.getCtaStConfiguracao(), CartaoCredito.class));
                            break;
                        case 6:
                            conta.setEmprestimo(gson.fromJson(planoconta.getCtaStConfiguracao(), Emprestimo.class));
                            break;
                        case 7:
                            conta.setFinancimento(gson.fromJson(planoconta.getCtaStConfiguracao(), Financiamento.class));
                            break;
                        case 9:
                            conta.setReceitaDespesa(gson.fromJson(planoconta.getCtaStConfiguracao(), ReceitaDespesa.class));
                            break;
                        case 10:
                            conta.setReceitaDespesa(gson.fromJson(planoconta.getCtaStConfiguracao(), ReceitaDespesa.class));
                            break;
                    }

                    conta.setConfiguracaoAlerta(gson.fromJson(planoconta.getCtaStConfiguracao(), ConfiguracaoAlerta.class));

                }
                listaConta.add(conta);
            }
        }

        return listaConta;
    }

    public boolean verificaInformacao(Conta conta) {

        boolean validado = true;

        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + " ";

        if (conta.getDescricaoConta().equals("") || conta.getDescricaoConta() == null) {
            mensagem = mensagem + bundle.getString("ln.texto.descricao");
            validado = false;
        }

        if (conta.getEmprestimo() != null) {
            
        }

        if (conta.getFinancimento() != null) {

        }

        if (conta.getReceitaDespesa() != null) {

        }

        return validado;
    }

    public boolean planoConta(Conta conta) {

        historico = new Historico();
        LnPlanoconta lnPlanoconta = montaPlanoConta(conta);

        switch (lnPlanoconta.getTipoFuncao()) {
            case Incluir:
                return incluirConta(lnPlanoconta);
            case Alterar:
                return alterarConta(lnPlanoconta);
            case Excluir:
                return excluirConta(lnPlanoconta);
            default:
        }

        return false;
    }

    private LnPlanoconta montaPlanoConta(Conta conta) {

        LnPlanoconta lnPlanoconta = new LnPlanoconta();

        if (conta.getTipoFuncao() != TipoFuncao.Incluir) {
            lnPlanoconta.setCtaInCodigo(conta.getCodigoConta());
        }

        lnPlanoconta.setCatInCodigo(conta.getCodigoCategoria());

        if (conta.isbContaAtiva()) {
            lnPlanoconta.setCtaChAtivo('S');
        } else {
            lnPlanoconta.setCtaChAtivo('N');
        }

        lnPlanoconta.setCtaFlSaldoinicial(conta.getSaldoConta());
        lnPlanoconta.setCtaInCodigo(Integer.MIN_VALUE);
        lnPlanoconta.setCtaStAlerta(conta.getConfiguracaoAlerta().toString());

        Gson gson = new Gson();
        
        if (conta.getAtivo() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getAtivo()));
        }

        if (conta.getBanco() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getBanco()));
        }
        if (conta.getCartaoCredito() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getCartaoCredito()));
        }
        if (conta.getEmprestimo() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getEmprestimo()));
        }
        if (conta.getFinancimento() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getFinancimento()));
        }
        if (conta.getReceitaDespesa() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getReceitaDespesa()));
        }

        return lnPlanoconta;
    }

    private boolean incluirConta(LnPlanoconta lnPlanoconta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean alterarConta(LnPlanoconta lnPlanoconta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean excluirConta(LnPlanoconta lnPlanoconta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
