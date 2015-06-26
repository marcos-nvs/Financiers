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
@Table(name = "ln_cliente", schema = "acessocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnCliente.findAll", query = "SELECT l FROM LnCliente l"),
    @NamedQuery(name = "LnCliente.findByCliInCodigo", query = "SELECT l FROM LnCliente l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnCliente.findByCliStDocumento", query = "SELECT l FROM LnCliente l WHERE l.cliStDocumento = :cliStDocumento"),
    @NamedQuery(name = "LnCliente.findByCliStNome", query = "SELECT l FROM LnCliente l WHERE l.cliStNome = :cliStNome"),
    @NamedQuery(name = "LnCliente.findByCliChAtivo", query = "SELECT l FROM LnCliente l WHERE l.cliChAtivo = :cliChAtivo"),
    @NamedQuery(name = "LnCliente.findByCliStBanco", query = "SELECT l FROM LnCliente l WHERE l.cliStBanco = :cliStBanco")})
public class LnCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cli_in_codigo")
    private Integer cliInCodigo;
    @Basic(optional = false)
    @Column(name = "cli_st_documento")
    private String cliStDocumento;
    @Basic(optional = false)
    @Column(name = "cli_st_nome")
    private String cliStNome;
    @Basic(optional = false)
    @Column(name = "cli_ch_ativo")
    private Character cliChAtivo;
    @Basic(optional = false)
    @Column(name = "cli_st_banco")
    private String cliStBanco;

    public LnCliente() {
    }

    public LnCliente(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public LnCliente(Integer cliInCodigo, String cliStDocumento, String cliStNome, Character cliChAtivo, String cliStBanco) {
        this.cliInCodigo = cliInCodigo;
        this.cliStDocumento = cliStDocumento;
        this.cliStNome = cliStNome;
        this.cliChAtivo = cliChAtivo;
        this.cliStBanco = cliStBanco;
    }

    public Integer getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public String getCliStDocumento() {
        return cliStDocumento;
    }

    public void setCliStDocumento(String cliStDocumento) {
        this.cliStDocumento = cliStDocumento;
    }

    public String getCliStNome() {
        return cliStNome;
    }

    public void setCliStNome(String cliStNome) {
        this.cliStNome = cliStNome;
    }

    public Character getCliChAtivo() {
        return cliChAtivo;
    }

    public void setCliChAtivo(Character cliChAtivo) {
        this.cliChAtivo = cliChAtivo;
    }

    public String getCliStBanco() {
        return cliStBanco;
    }

    public void setCliStBanco(String cliStBanco) {
        this.cliStBanco = cliStBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliInCodigo != null ? cliInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnCliente)) {
            return false;
        }
        LnCliente other = (LnCliente) object;
        if ((this.cliInCodigo == null && other.cliInCodigo != null) || (this.cliInCodigo != null && !this.cliInCodigo.equals(other.cliInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnCliente[ cliInCodigo=" + cliInCodigo + " ]";
    }
    
}
