/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class AgendaAlerta implements Serializable{
    
    private Integer codigoAgenda;
    private Date dataCriacao;
    private Date dataAviso;
    private boolean alertar;
    private boolean avisaEmail;
    private String emailAviso;

    public AgendaAlerta() {
    }

    public Integer getCodigoAgenda() {
        return codigoAgenda;
    }

    public void setCodigoAgenda(Integer codigoAgenda) {
        this.codigoAgenda = codigoAgenda;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAviso() {
        return dataAviso;
    }

    public void setDataAviso(Date dataAviso) {
        this.dataAviso = dataAviso;
    }

    public boolean isAlertar() {
        return alertar;
    }

    public void setAlertar(boolean alertar) {
        this.alertar = alertar;
    }

    public boolean isAvisaEmail() {
        return avisaEmail;
    }

    public void setAvisaEmail(boolean avisaEmail) {
        this.avisaEmail = avisaEmail;
    }

    public String getEmailAviso() {
        return emailAviso;
    }

    public void setEmailAviso(String emailAviso) {
        this.emailAviso = emailAviso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigoAgenda);
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
        hash = 67 * hash + Objects.hashCode(this.dataAviso);
        hash = 67 * hash + (this.alertar ? 1 : 0);
        hash = 67 * hash + (this.avisaEmail ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.emailAviso);
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
        final AgendaAlerta other = (AgendaAlerta) obj;
        if (this.alertar != other.alertar) {
            return false;
        }
        if (this.avisaEmail != other.avisaEmail) {
            return false;
        }
        if (!Objects.equals(this.emailAviso, other.emailAviso)) {
            return false;
        }
        if (!Objects.equals(this.codigoAgenda, other.codigoAgenda)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataAviso, other.dataAviso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaAlerta{" + "codigoAgenda=" + codigoAgenda + ", dataCriacao=" + dataCriacao + ", dataAviso=" + dataAviso + ", alertar=" + alertar + ", avisaEmail=" + avisaEmail + ", emailAviso=" + emailAviso + '}';
    }
    
    
}
