/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

/**
 *
 * @author resource
 */
class EstadoInfo {

    private String areaKm2;
    private String codigoIbge;
    private String nome;
    private String cep;

    public EstadoInfo() {
    }

    public String getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(String areaKm2) {
        this.areaKm2 = areaKm2;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "EstadoInfo{" + "areaKm2=" + areaKm2 + ", codigoIbge=" + codigoIbge + ", nome=" + nome + ", cep=" + cep + '}';
    }
    
    
}



	