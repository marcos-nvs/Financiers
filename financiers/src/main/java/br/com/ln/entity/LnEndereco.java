/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_endereco",schema = "acessocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnEndereco.findAll", query = "SELECT l FROM LnEndereco l"),
    @NamedQuery(name = "LnEndereco.findByEndInCodigo", query = "SELECT l FROM LnEndereco l WHERE l.endInCodigo = :endInCodigo"),
    @NamedQuery(name = "LnEndereco.findByCliInCodigo", query = "SELECT l FROM LnEndereco l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnEndereco.findByEndStEndereco", query = "SELECT l FROM LnEndereco l WHERE l.endStEndereco = :endStEndereco"),
    @NamedQuery(name = "LnEndereco.findByEndStBairro", query = "SELECT l FROM LnEndereco l WHERE l.endStBairro = :endStBairro"),
    @NamedQuery(name = "LnEndereco.findByEndStCidade", query = "SELECT l FROM LnEndereco l WHERE l.endStCidade = :endStCidade"),
    @NamedQuery(name = "LnEndereco.findByEndStEstado", query = "SELECT l FROM LnEndereco l WHERE l.endStEstado = :endStEstado"),
    @NamedQuery(name = "LnEndereco.findByEndStCep", query = "SELECT l FROM LnEndereco l WHERE l.endStCep = :endStCep")})
public class LnEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "end_in_codigo")
    private Integer endInCodigo;
    @Basic(optional = false)
    @Column(name = "cli_in_codigo")
    private int cliInCodigo;
    @Basic(optional = false)
    @Column(name = "end_st_endereco")
    private String endStEndereco;
    @Basic(optional = false)
    @Column(name = "end_st_bairro")
    private String endStBairro;
    @Basic(optional = false)
    @Column(name = "end_st_cidade")
    private String endStCidade;
    @Basic(optional = false)
    @Column(name = "end_st_estado")
    private String endStEstado;
    @Basic(optional = false)
    @Column(name = "end_st_cep")
    private String endStCep;

    public LnEndereco() {
    }

    public LnEndereco(Integer endInCodigo) {
        this.endInCodigo = endInCodigo;
    }

    public LnEndereco(Integer endInCodigo, int cliInCodigo, String endStEndereco, String endStBairro, String endStCidade, String endStEstado, String endStCep) {
        this.endInCodigo = endInCodigo;
        this.cliInCodigo = cliInCodigo;
        this.endStEndereco = endStEndereco;
        this.endStBairro = endStBairro;
        this.endStCidade = endStCidade;
        this.endStEstado = endStEstado;
        this.endStCep = endStCep;
    }

    public Integer getEndInCodigo() {
        return endInCodigo;
    }

    public void setEndInCodigo(Integer endInCodigo) {
        this.endInCodigo = endInCodigo;
    }

    public int getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(int cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public String getEndStEndereco() {
        return endStEndereco;
    }

    public void setEndStEndereco(String endStEndereco) {
        this.endStEndereco = endStEndereco;
    }

    public String getEndStBairro() {
        return endStBairro;
    }

    public void setEndStBairro(String endStBairro) {
        this.endStBairro = endStBairro;
    }

    public String getEndStCidade() {
        return endStCidade;
    }

    public void setEndStCidade(String endStCidade) {
        this.endStCidade = endStCidade;
    }

    public String getEndStEstado() {
        return endStEstado;
    }

    public void setEndStEstado(String endStEstado) {
        this.endStEstado = endStEstado;
    }

    public String getEndStCep() {
        return endStCep;
    }

    public void setEndStCep(String endStCep) {
        this.endStCep = endStCep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endInCodigo != null ? endInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnEndereco)) {
            return false;
        }
        LnEndereco other = (LnEndereco) object;
        if ((this.endInCodigo == null && other.endInCodigo != null) || (this.endInCodigo != null && !this.endInCodigo.equals(other.endInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnEndereco[ endInCodigo=" + endInCodigo + " ]";
    }
    
}
