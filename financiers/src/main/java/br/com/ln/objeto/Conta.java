/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class Conta implements Serializable{
    
    private Integer idConta;
    private String nomeConta;
    private Integer idCategoria;
    private Integer idTipoConta;
    private Character ativo;
    private Character imposto;
    private Character calculada;
    private Double percentual;
    private Double limite;
    private Character agendar;
        
    private List<ContaDependente> listaContaDependente;
    private List<AgendaConta> listaAgendamento;

    public Conta() {
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(Integer idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Character getImposto() {
        return imposto;
    }

    public void setImposto(Character imposto) {
        this.imposto = imposto;
    }

    public Character getCalculada() {
        return calculada;
    }

    public void setCalculada(Character calculada) {
        this.calculada = calculada;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Character getAgendar() {
        return agendar;
    }

    public void setAgendar(Character agendar) {
        this.agendar = agendar;
    }

    public List<ContaDependente> getListaContaDependente() {
        return listaContaDependente;
    }

    public void setListaContaDependente(List<ContaDependente> listaContaDependente) {
        this.listaContaDependente = listaContaDependente;
    }

    public List<AgendaConta> getListaAgendamento() {
        return listaAgendamento;
    }

    public void setListaAgendamento(List<AgendaConta> listaAgendamento) {
        this.listaAgendamento = listaAgendamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idConta);
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.idConta, other.idConta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "idConta=" + idConta + ", nomeConta=" + nomeConta + ", idCategoria=" + idCategoria + ", idTipoConta=" + idTipoConta + ", ativo=" + ativo + ", imposto=" + imposto + ", calculada=" + calculada + ", percentual=" + percentual + ", limite=" + limite + ", agendar=" + agendar + ", listaContaDependente=" + listaContaDependente + ", listaAgendamento=" + listaAgendamento + '}';
    }
    
}
