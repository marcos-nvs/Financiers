/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.entity.LnFavorecido;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.funcao.FavorecidoFuncoes;
import br.com.ln.funcao.PlanoContaFuncoes;
import br.com.ln.objeto.Ativo;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.Financiamento;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "finView")
public class FinanciamentoView implements Serializable {

    private Date dataFinancimento;
    private boolean simulado;
    private Ativo ativoFinanciado;
    private Integer idFavorecido;
    private Integer contaPagamento;
    private Double valorAtivo;
    private Double valorEntrada;
    private Double valorFinanciado;
    private Double valorParcelas;
    private Integer prazoFinanciamento;
    private Double jurosMensais;
    private Date dataVencimento;
    private Double valorTotalFinanciamento;

    private LnFavorecido favorecido;

    private List<LnFavorecido> listaFavorecido;
    private List<Conta> listaContaPagamento;
    private List<Conta> listaContaAtivo;

    private final FavorecidoFuncoes favorecidoFuncoes;
    private final PlanoContaFuncoes planoContaFuncoes;

    public FinanciamentoView() {
        favorecidoFuncoes = new FavorecidoFuncoes();
        planoContaFuncoes = new PlanoContaFuncoes();
        listaFavorecido = favorecidoFuncoes.grabListaFavorecidoAtivo();
        listaContaPagamento = planoContaFuncoes.buscaPlanoContasAtivo();
        listaContaAtivo = planoContaFuncoes.buscaAtivos();
    }    

    public Date getDataFinancimento() {
        return dataFinancimento;
    }

    public void setDataFinancimento(Date dataFinancimento) {
        this.dataFinancimento = dataFinancimento;
    }

    public boolean isSimulado() {
        return simulado;
    }

    public void setSimulado(boolean simulado) {
        this.simulado = simulado;
    }

    public Ativo getAtivoFinanciado() {
        return ativoFinanciado;
    }

    public void setAtivoFinanciado(Ativo ativoFinanciado) {
        this.ativoFinanciado = ativoFinanciado;
    }

    public Integer getIdFavorecido() {
        return idFavorecido;
    }

    public void setIdFavorecido(Integer idFavorecido) {
        this.idFavorecido = idFavorecido;
    }

    public Integer getContaPagamento() {
        return contaPagamento;
    }

    public void setContaPagamento(Integer contaPagamento) {
        this.contaPagamento = contaPagamento;
    }

    public Double getValorAtivo() {
        return valorAtivo;
    }

    public void setValorAtivo(Double valorAtivo) {
        this.valorAtivo = valorAtivo;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Double getValorFinanciado() {
        return valorFinanciado;
    }

    public void setValorFinanciado(Double valorFinanciado) {
        this.valorFinanciado = valorFinanciado;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Integer getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(Integer prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public Double getJurosMensais() {
        return jurosMensais;
    }

    public void setJurosMensais(Double jurosMensais) {
        this.jurosMensais = jurosMensais;
    }


    public List<LnFavorecido> getListaFavorecido() {
        return listaFavorecido;
    }

    public void setListaFavorecido(List<LnFavorecido> listaFavorecido) {
        this.listaFavorecido = listaFavorecido;
    }

    public List<Conta> getListaContaPagamento() {
        return listaContaPagamento;
    }

    public void setListaContaPagamento(List<Conta> listaContaPagamento) {
        this.listaContaPagamento = listaContaPagamento;
    }

    public List<Conta> getListaContaAtivo() {
        return listaContaAtivo;
    }

    public void setListaContaAtivo(List<Conta> listaContaAtivo) {
        this.listaContaAtivo = listaContaAtivo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorTotalFinanciamento() {
        return valorTotalFinanciamento;
    }

    public void setValorTotalFinanciamento(Double valorTotalFinanciamento) {
        this.valorTotalFinanciamento = valorTotalFinanciamento;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dataFinancimento);
        hash = 23 * hash + (this.simulado ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.ativoFinanciado);
        hash = 23 * hash + Objects.hashCode(this.idFavorecido);
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
        final FinanciamentoView other = (FinanciamentoView) obj;
        if (this.simulado != other.simulado) {
            return false;
        }
        if (!Objects.equals(this.dataFinancimento, other.dataFinancimento)) {
            return false;
        }
        if (!Objects.equals(this.ativoFinanciado, other.ativoFinanciado)) {
            return false;
        }
        if (!Objects.equals(this.idFavorecido, other.idFavorecido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FinanciamentoView{" + "dataFinancimento=" + dataFinancimento + ", simulado=" + simulado + ", ativoFinanciado=" + ativoFinanciado + ", idFavorecido=" + idFavorecido + ", contaPagamento=" + contaPagamento + ", valorAtivo=" + valorAtivo + ", valorEntrada=" + valorEntrada + ", valorFinanciado=" + valorFinanciado + ", valorParcelas=" + valorParcelas + ", prazoFinanciamento=" + prazoFinanciamento + ", jurosMensais=" + jurosMensais + ", dataVencimento=" + dataVencimento + ", valorTotalFinanciamento=" + valorTotalFinanciamento + ", favorecido=" + favorecido + ", listaFavorecido=" + listaFavorecido + ", listaContaPagamento=" + listaContaPagamento + ", listaContaAtivo=" + listaContaAtivo + ", favorecidoFuncoes=" + favorecidoFuncoes + '}';
    }


    public Financiamento grabFinanciamento() {

        Financiamento financiamento = new Financiamento();

        financiamento.setAtivoFinanciado(ativoFinanciado);
        financiamento.setContaPagamento(contaPagamento);
        financiamento.setDataFinancimento(dataFinancimento);

        FavorecidoFuncoes favorecidoFuncoes = new FavorecidoFuncoes();

        favorecido = favorecidoFuncoes.grabFavorecido(idFavorecido);
        financiamento.setFavorecido(favorecido);

        financiamento.setJurosMensais(jurosMensais);
        financiamento.setPrazoFinanciamento(prazoFinanciamento);
        financiamento.setSimulado(simulado);
        financiamento.setValorAtivo(valorAtivo);
        financiamento.setValorEntrada(valorEntrada);
        financiamento.setValorFinanciado(valorFinanciado);
        financiamento.setValorParcelas(valorParcelas);
        financiamento.setDataVencimento(dataVencimento);
        financiamento.setValorTotalFinanciamento(valorTotalFinanciamento);
        
        return financiamento;
    }

}
