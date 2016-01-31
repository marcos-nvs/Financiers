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
public class Emprestimo implements Serializable{
    
    private String tipoEmprestimo;
    private Date dataEmprestimo;
    private LnFavorecido favorecido;
    private Integer contaPagamento;
    private Integer contaDestino;
    private Double valorEmprestimo;
    private Integer prazoEmprestimo;
    private Double valorParcelas;
    private Double jurosMensais;
    private Double valorTotal;
    private Double jurosAnuais;
    private Double jurosEfetivos;
    private Date dataVencimento;
    private boolean simulado;
    
    public Emprestimo() {
    }

    public String getTipoEmprestimo() {
        return tipoEmprestimo;
    }

    public void setTipoEmprestimo(String tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
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

    public Integer getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Integer getPrazoEmprestimo() {
        return prazoEmprestimo;
    }

    public void setPrazoEmprestimo(Integer prazoEmprestimo) {
        this.prazoEmprestimo = prazoEmprestimo;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Double getJurosMensais() {
        return jurosMensais;
    }

    public void setJurosMensais(Double jurosMensais) {
        this.jurosMensais = jurosMensais;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getJurosAnuais() {
        return jurosAnuais;
    }

    public void setJurosAnuais(Double jurosAnuais) {
        this.jurosAnuais = jurosAnuais;
    }

    public Double getJurosEfetivos() {
        return jurosEfetivos;
    }

    public void setJurosEfetivos(Double jurosEfetivos) {
        this.jurosEfetivos = jurosEfetivos;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


    public boolean isSimulado() {
        return simulado;
    }

    public void setSimulado(boolean simulado) {
        this.simulado = simulado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.tipoEmprestimo);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.tipoEmprestimo, other.tipoEmprestimo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "tipoEmprestimo=" + tipoEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", favorecido=" + favorecido + ", contaPagamento=" + contaPagamento + ", contaDestino=" + contaDestino + ", valorEmprestimo=" + valorEmprestimo + ", prazoEmprestimo=" + prazoEmprestimo + ", valorParcelas=" + valorParcelas + ", jurosMensais=" + jurosMensais + ", valorTotal=" + valorTotal + ", jurosAnuais=" + jurosAnuais + ", jurosEfetivos=" + jurosEfetivos + ", dataVencimento=" + dataVencimento + ", simulado=" + simulado + '}';
    }

}
