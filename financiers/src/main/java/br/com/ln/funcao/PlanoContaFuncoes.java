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

    public boolean verificaInformacao(Conta conta) {

        System.out.println("Conta : ----> " + conta.toString());

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
        
        if (conta.getTipoFuncao() != TipoFuncao.Incluir){
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

        if (conta.getAtivo() != null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getAtivo().toString());
        }
        
        if (conta.getBanco()!= null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getBanco().toString());
        }
        if (conta.getCartaoCredito()!= null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getCartaoCredito().toString());
        }
        if (conta.getEmprestimo()!= null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getEmprestimo().toString());
        }
        if (conta.getFinancimento()!= null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getFinancimento().toString());
        }
        if (conta.getReceitaDespesa() != null) {
            lnPlanoconta.setCtaStConfiguracao(conta.getReceitaDespesa().toString());
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
