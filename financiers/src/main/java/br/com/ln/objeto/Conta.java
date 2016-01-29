/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class Conta implements Serializable {
    
    private Integer codigoConta;
    private Integer codigoCategoria;
    private String descricaoConta;
    private boolean bContaAtiva;
    private Double saldoConta;
    
    private Ativo ativo;
    private Banco banco;
    private CartaoCredito cartaoCredito;
    private Emprestimo emprestimo;
    private Financiamento financimento;
    private ReceitaDespesa receitaDespesa;
    
    private ConfiguracaoAlerta configuracaoAlerta;

    public Conta() {
    }

    public Integer getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(Integer codigoConta) {
        this.codigoConta = codigoConta;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public boolean isbContaAtiva() {
        return bContaAtiva;
    }

    public void setbContaAtiva(boolean bContaAtiva) {
        this.bContaAtiva = bContaAtiva;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Financiamento getFinancimento() {
        return financimento;
    }

    public void setFinancimento(Financiamento financimento) {
        this.financimento = financimento;
    }

    public ReceitaDespesa getReceitaDespesa() {
        return receitaDespesa;
    }

    public void setReceitaDespesa(ReceitaDespesa receitaDespesa) {
        this.receitaDespesa = receitaDespesa;
    }

    public ConfiguracaoAlerta getConfiguracaoAlerta() {
        return configuracaoAlerta;
    }

    public void setConfiguracaoAlerta(ConfiguracaoAlerta configuracaoAlerta) {
        this.configuracaoAlerta = configuracaoAlerta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.codigoConta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.codigoConta, other.codigoConta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "codigoConta=" + codigoConta + ", codigoCategoria=" + codigoCategoria + ", descricaoConta=" + descricaoConta + ", bContaAtiva=" + bContaAtiva + ", saldoConta=" + saldoConta + ", ativo=" + ativo + ", banco=" + banco + ", cartaoCredito=" + cartaoCredito + ", emprestimo=" + emprestimo + ", financimento=" + financimento + ", receitaDespesa=" + receitaDespesa + ", configuracaoAlerta=" + configuracaoAlerta + '}';
    }
 
}
