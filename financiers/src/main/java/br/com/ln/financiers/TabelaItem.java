/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class TabelaItem implements Serializable{
    
    private Integer codigoTabItem;
    private Integer codigoTabela;
    private Double valorInicial;
    private Double valorFinal;
    private Double valorDependente;
    private Double valorDesconto;
    private Double percentual;
    private Integer qtdDependente;
    
    private TipoFuncao tipoFuncao;

    public TabelaItem() {
    }

    public Integer getCodigoTabItem() {
        return codigoTabItem;
    }

    public void setCodigoTabItem(Integer codigoTabItem) {
        this.codigoTabItem = codigoTabItem;
    }

    public Integer getCodigoTabela() {
        return codigoTabela;
    }

    public void setCodigoTabela(Integer codigoTabela) {
        this.codigoTabela = codigoTabela;
    }
    
    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getValorDependente() {
        return valorDependente;
    }

    public void setValorDependente(Double valorDependente) {
        this.valorDependente = valorDependente;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Integer getQtdDependente() {
        return qtdDependente;
    }

    public void setQtdDependente(Integer qtdDependente) {
        this.qtdDependente = qtdDependente;
    }

    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.valorInicial);
        hash = 19 * hash + Objects.hashCode(this.valorFinal);
        hash = 19 * hash + Objects.hashCode(this.valorDependente);
        hash = 19 * hash + Objects.hashCode(this.valorDesconto);
        hash = 19 * hash + Objects.hashCode(this.percentual);
        hash = 19 * hash + Objects.hashCode(this.qtdDependente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TabelaItem other = (TabelaItem) obj;
        if (!Objects.equals(this.valorInicial, other.valorInicial)) {
            return false;
        }
        if (!Objects.equals(this.valorFinal, other.valorFinal)) {
            return false;
        }
        if (!Objects.equals(this.valorDependente, other.valorDependente)) {
            return false;
        }
        if (!Objects.equals(this.valorDesconto, other.valorDesconto)) {
            return false;
        }
        if (!Objects.equals(this.percentual, other.percentual)) {
            return false;
        }
        if (!Objects.equals(this.qtdDependente, other.qtdDependente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TabelaItem{" + "codigoTabItem=" + codigoTabItem + ", codigoTabela=" + codigoTabela + ", valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + ", valorDependente=" + valorDependente + ", valorDesconto=" + valorDesconto + ", percentual=" + percentual + ", qtdDependente=" + qtdDependente + ", tipoFuncao=" + tipoFuncao + '}';
    }


}
