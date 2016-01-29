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
    private Integer anoFabricacao;
    private Integer anoModelo;

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

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tipoAtivo);
        hash = 23 * hash + Objects.hashCode(this.valorAtivo);
        hash = 23 * hash + Objects.hashCode(this.endereco);
        hash = 23 * hash + Objects.hashCode(this.placa);
        hash = 23 * hash + Objects.hashCode(this.anoFabricacao);
        hash = 23 * hash + Objects.hashCode(this.anoModelo);
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
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.valorAtivo, other.valorAtivo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.anoFabricacao, other.anoFabricacao)) {
            return false;
        }
        if (!Objects.equals(this.anoModelo, other.anoModelo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ativo{" + "tipoAtivo=" + tipoAtivo + ", valorAtivo=" + valorAtivo + ", endereco=" + endereco + ", placa=" + placa + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo + '}';
    }

}
