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
public class Ativo implements Serializable{
    
    private String tipoAtivo;
    private Double valorAtivo;
    private Endereco endereco;
    private String placa;
    private Double anoFabricacao;
    private Double anoModelo;

    public Ativo() {
    }

    public String getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(String tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public Double getValorAtivo() {
        return valorAtivo;
    }

    public void setValorAtivo(Double valorAtivo) {
        this.valorAtivo = valorAtivo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Double anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Double anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tipoAtivo);
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
        final Ativo other = (Ativo) obj;
        if (!Objects.equals(this.tipoAtivo, other.tipoAtivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ativo{" + "tipoAtivo=" + tipoAtivo + ", valorAtivo=" + valorAtivo + ", endereco=" + endereco + ", placa=" + placa + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo + '}';
    }
    
}
