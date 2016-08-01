/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.comum.Historico;
import br.com.ln.comum.VarComuns;
import br.com.ln.dao.CategoriaDao;
import br.com.ln.dao.PlanoContaDao;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.entity.LnSaldoconta;
import br.com.ln.entity.LnSaldocontaPK;
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
import java.util.Date;
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

    public List<Conta> buscaPlanoContasAtivo() {
        List<LnPlanoconta> listaPlanoconta = PlanoContaDao.grabContaAtivo();
        return montaConta(listaPlanoconta);
    }

    private List<Conta> montaConta(List<LnPlanoconta> listaPlanoconta) {

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
            mensagem = mensagem + bundle.getString("ln.mb.frase.descricao");
            validado = false;
        }

        if (conta.getAtivo() != null) {

            if (conta.getAtivo().getTipoImovel() != null) {
                switch (conta.getAtivo().getTipoImovel()) {
                    case "Próprio":
                        if (conta.getAtivo().getValorAtivo() == null || conta.getAtivo().getValorAtivo() == 0) {
                            mensagem = mensagem + ": " + bundle.getString("ln.mb.frase.valorativo");
                            validado = false;
                        }
                        break;
                    case "Aluguel":
                        break;
                    case "Pais":
                        break;
                }
            } else if (conta.getAtivo().getValorAtivo() == null) {
                mensagem = mensagem + ": " + bundle.getString("ln.mb.frase.valorativo");
                validado = false;
            }
        }

        if (conta.getEmprestimo() != null) {
            if (conta.getEmprestimo().getValorTotal() == null || conta.getEmprestimo().getValorTotal() == 0) {
                mensagem = mensagem + ": " + bundle.getString("ln.mb.frase.valortotal");
                validado = false;
            }
        }

        if (conta.getFinancimento() != null) {
            if (conta.getFinancimento().getValorTotalFinanciamento() == null || conta.getFinancimento().getValorTotalFinanciamento() == 0) {
                mensagem = mensagem + ": " + bundle.getString("ln.mb.frase.valortotal");
                validado = false;
            }
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

        if (!conta.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            lnPlanoconta.setCtaInCodigo(conta.getCodigoConta());
        }

        lnPlanoconta.setCatInCodigo(conta.getCodigoCategoria());
        lnPlanoconta.setTipoFuncao(conta.getTipoFuncao());
        lnPlanoconta.setCtaStDescricao(conta.getDescricaoConta());

        if (conta.isbContaAtiva()) {
            lnPlanoconta.setCtaChAtivo('S');
        } else {
            lnPlanoconta.setCtaChAtivo('N');
        }

        lnPlanoconta.setCtaFlSaldoinicial(conta.getSaldoConta());

        if (conta.getConfiguracaoAlerta() != null) {
            lnPlanoconta.setCtaStAlerta(conta.getConfiguracaoAlerta().toString());
        }

        Gson gson = new Gson();

        if (conta.getAtivo() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getAtivo()));
        }

        if (conta.getBanco() != null) {
            lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getBanco()));
            
            if (conta.getConfiguracaoAlerta() != null){
                lnPlanoconta.setCtaStConfiguracao(gson.toJson(conta.getConfiguracaoAlerta()));
            }
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

        lnPlanoconta.setCtaDtCriacao(conta.getDtCriacao());
        lnPlanoconta.setUsuStCodigo(conta.getUsuStCodigo());

        return lnPlanoconta;
    }

    private boolean incluirConta(LnPlanoconta lnPlanoconta) {

        if (lnPlanoconta != null) {
            lnPlanoconta.setCtaInCodigo(PlanoContaDao.grabLnPlanoContaNextId());

            try {
                PlanoContaDao.saveObject(lnPlanoconta);
                criacaoSaldoConta(lnPlanoconta);
                historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.inclusaoconta") + " " + lnPlanoconta.getCtaStDescricao());
                mensagem = bundle.getString("ln.mb.texto.sucesso");
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                mensagem = bundle.getString("ln.mb.frase.problema");
                return false;
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.problema");
            return false;
        }
    }

    private boolean alterarConta(LnPlanoconta lnPlanoconta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean excluirConta(LnPlanoconta lnPlanoconta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Conta> grabListaConta() {
        List<LnPlanoconta> listaPlanoconta = PlanoContaDao.grabListaConta();
        return montaConta(listaPlanoconta);
    }

    private boolean criacaoSaldoConta(LnPlanoconta lnPlanoconta) {

        LnSaldoconta saldoConta = PlanoContaDao.grabSaldoAtualConta(lnPlanoconta.getCtaInCodigo(), lnPlanoconta.getCtaDtCriacao());

        if (saldoConta == null) {
            LnSaldocontaPK lnSaldocontaPK = new LnSaldocontaPK(lnPlanoconta.getCtaInCodigo(), lnPlanoconta.getCtaDtCriacao());
            saldoConta = new LnSaldoconta(lnSaldocontaPK, 0d, 0d, lnPlanoconta.getCtaFlSaldoinicial());
            PlanoContaDao.saveObject(saldoConta);
            return true;
        } else {
            return false;
        }
    }

    public Date getDataDb() {
        return PlanoContaDao.grabDateFromDB();
    }

    public String getUsuarioLogado() {
        return VarComuns.lnUsusario.getUsuStCodigo();
    }
    
    public Double saldoAtualConta(Integer idConta){

        LnSaldoconta lnSaldoconta = PlanoContaDao.grabSaldoAtualConta(idConta);
        
        return lnSaldoconta.getSacFlSaldo();
    }

}
