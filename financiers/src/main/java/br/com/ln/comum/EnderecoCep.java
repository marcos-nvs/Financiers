/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */
public class EnderecoCep implements Serializable{
    
    private String bairro;
    private String cidade;
    private String logradouro;
    private EstadoInfo estadoInfo;
    private CidadeInfo cidadeInfo;
    private String estado;

    public EnderecoCep() {
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public EstadoInfo getEstadoInfo() {
        return estadoInfo;
    }

    public void setEstadoInfo(EstadoInfo estadoInfo) {
        this.estadoInfo = estadoInfo;
    }

    public CidadeInfo getCidadeInfo() {
        return cidadeInfo;
    }

    public void setCidadeInfo(CidadeInfo cidadeInfo) {
        this.cidadeInfo = cidadeInfo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EnderecoCep{" + "bairro=" + bairro + ", cidade=" + cidade + ", logradouro=" + logradouro + ", estadoInfo=" + estadoInfo + ", cidadeInfo=" + cidadeInfo + ", estado=" + estado + '}';
    }
}
