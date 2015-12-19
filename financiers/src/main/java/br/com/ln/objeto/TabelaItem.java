/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import br.com.ln.tipos.TipoFuncao;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class TabelaItem implements Serializable{
    
    private Integer codigoTabela;
    private Integer codigoTabItem;
    private Double valorInicial;
    private Double valorFinal;
    private Double valorDependente;
    private Double valorDesconto;
    private Double percentual;
    private String origem;
    private String tipo;
    
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return true;
    }

    @Override
    public String toString() {
        return "TabelaItem{" + "codigoTabela=" + codigoTabela + ", codigoTabItem=" + codigoTabItem + ", valorInicial=" + valorInicial + ", valorFinal=" + valorFinal + ", valorDependente=" + valorDependente + ", valorDesconto=" + valorDesconto + ", percentual=" + percentual + ", origem=" + origem + ", tipo=" + tipo + ", tipoFuncao=" + tipoFuncao + '}';
    }

}
