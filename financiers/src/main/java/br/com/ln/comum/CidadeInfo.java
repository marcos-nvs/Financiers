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
class CidadeInfo {
    
    private String areaKm2;
    private String codigoIbge;

    public CidadeInfo() {
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

    @Override
    public String toString() {
        return "CidadeInfo{" + "areaKm2=" + areaKm2 + ", codigoIbge=" + codigoIbge + '}';
    }
    
}
