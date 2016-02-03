/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import br.com.ln.entity.LnFavorecido;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class Financiamento implements Serializable{
    
    private String tipoFinancimanto;
    private Date dataFinancimento;
    private boolean simulado;
    private Ativo ativoFinanciado;
    private LnFavorecido favorecido;
    private Integer contaPagamento;
    private Double valorAtivo;
    private Double valorEntrada;
    private Double valorFinanciado;
    private Double valorParcelas;
    private Integer prazoFinanciamento;
    private Double jurosMensais;
    private Date dataVencimento;
    private Double valorTotalFinanciamento;

    public Financiamento() {
    }

    public String getTipoFinancimanto() {
        return tipoFinancimanto;
    }

    public void setTipoFinancimanto(String tipoFinancimanto) {
        this.tipoFinancimanto = tipoFinancimanto;
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

    public LnFavorecido getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(LnFavorecido favorecido) {
        this.favorecido = favorecido;
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
        hash = 53 * hash + Objects.hashCode(this.tipoFinancimanto);
        hash = 53 * hash + Objects.hashCode(this.dataFinancimento);
        hash = 53 * hash + (this.simulado ? 1 : 0);
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
        final Financiamento other = (Financiamento) obj;
        if (this.simulado != other.simulado) {
            return false;
        }
        if (!Objects.equals(this.tipoFinancimanto, other.tipoFinancimanto)) {
            return false;
        }
        if (!Objects.equals(this.dataFinancimento, other.dataFinancimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Financiamento{" + "tipoFinancimanto=" + tipoFinancimanto + ", dataFinancimento=" + dataFinancimento + ", simulado=" + simulado + ", ativoFinanciado=" + ativoFinanciado + ", favorecido=" + favorecido + ", contaPagamento=" + contaPagamento + ", valorAtivo=" + valorAtivo + ", valorEntrada=" + valorEntrada + ", valorFinanciado=" + valorFinanciado + ", valorParcelas=" + valorParcelas + ", prazoFinanciamento=" + prazoFinanciamento + ", jurosMensais=" + jurosMensais + ", dataVencimento=" + dataVencimento + ", valorTotalFinanciamento=" + valorTotalFinanciamento + '}';
    }


}
