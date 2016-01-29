/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.JsfHelper;
import br.com.ln.objeto.Ativo;
import br.com.ln.objeto.Endereco;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "ativoInfo")
public class AtivoView implements Serializable {

    private Double valorInicial;
    private String placaVeiculo;
    private Integer anoFabricacao;
    private Integer anoModelo;

    private EnderecoView enderecoView;
    private Endereco endereco;
    private final Ativo ativo;

    public AtivoView() {
        ativo = new Ativo();
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
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
        hash = 97 * hash + Objects.hashCode(this.valorInicial);
        hash = 97 * hash + Objects.hashCode(this.placaVeiculo);
        hash = 97 * hash + Objects.hashCode(this.anoFabricacao);
        hash = 97 * hash + Objects.hashCode(this.anoModelo);
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
        final AtivoView other = (AtivoView) obj;
        if (!Objects.equals(this.placaVeiculo, other.placaVeiculo)) {
            return false;
        }
        if (!Objects.equals(this.valorInicial, other.valorInicial)) {
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
        return "AtivoView{" + "valorInicial=" + valorInicial + ", placaVeiculo=" + placaVeiculo + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo + '}';
    }

    public Ativo grabAtivo() {
        ativo.setAnoFabricacao(anoFabricacao);
        ativo.setAnoModelo(anoModelo);
        endereco = new Endereco();

        enderecoView = (EnderecoView) JsfHelper.getSessionAttribute("enderecoView");
        if (enderecoView != null) {
            endereco = enderecoView.grabEnderecoObj();
            ativo.setEndereco(endereco);
        }
        
        ativo.setPlaca(placaVeiculo);
        ativo.setValorAtivo(valorInicial);
        ativo.setEndereco(endereco);

        return ativo;
    }

}
