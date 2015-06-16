/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnTabela;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class Irrf extends LnTabela implements Serializable{

    private Integer codigo;
    private String descricao;
    private Date dtInicio;
    private Date dtFinal;
    private Double vlrInicio;
    private Double vlrFinal;
    private Double qtdeDependente;
    private Double vlrDependente;
    private Double vlrDesconto;
    private Double percentual;

    public Irrf() {
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public Double getVlrInicio() {
        return vlrInicio;
    }

    public void setVlrInicio(Double vlrInicio) {
        this.vlrInicio = vlrInicio;
    }

    public Double getVlrFinal() {
        return vlrFinal;
    }

    public void setVlrFinal(Double vlrFinal) {
        this.vlrFinal = vlrFinal;
    }

    public Double getQtdeDependente() {
        return qtdeDependente;
    }

    public void setQtdeDependente(Double qtdeDependente) {
        this.qtdeDependente = qtdeDependente;
    }

    public Double getVlrDependente() {
        return vlrDependente;
    }

    public void setVlrDependente(Double vlrDependente) {
        this.vlrDependente = vlrDependente;
    }

    public Double getVlrDesconto() {
        return vlrDesconto;
    }

    public void setVlrDesconto(Double vlrDesconto) {
        this.vlrDesconto = vlrDesconto;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.dtInicio);
        hash = 23 * hash + Objects.hashCode(this.dtFinal);
        hash = 23 * hash + Objects.hashCode(this.vlrInicio);
        hash = 23 * hash + Objects.hashCode(this.vlrFinal);
        hash = 23 * hash + Objects.hashCode(this.qtdeDependente);
        hash = 23 * hash + Objects.hashCode(this.vlrDependente);
        hash = 23 * hash + Objects.hashCode(this.vlrDesconto);
        hash = 23 * hash + Objects.hashCode(this.percentual);
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
        final Irrf other = (Irrf) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dtInicio, other.dtInicio)) {
            return false;
        }
        if (!Objects.equals(this.dtFinal, other.dtFinal)) {
            return false;
        }
        if (!Objects.equals(this.vlrInicio, other.vlrInicio)) {
            return false;
        }
        if (!Objects.equals(this.vlrFinal, other.vlrFinal)) {
            return false;
        }
        if (!Objects.equals(this.qtdeDependente, other.qtdeDependente)) {
            return false;
        }
        if (!Objects.equals(this.vlrDependente, other.vlrDependente)) {
            return false;
        }
        if (!Objects.equals(this.vlrDesconto, other.vlrDesconto)) {
            return false;
        }
        if (!Objects.equals(this.percentual, other.percentual)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IRRF{" + "codigo=" + codigo + ", descricao=" + descricao + ", dtInicio=" + dtInicio + ", dtFinal=" + dtFinal + ", vlrInicio=" + vlrInicio + ", vlrFinal=" + vlrFinal + ", qtdeDependente=" + qtdeDependente + ", vlrDependente=" + vlrDependente + ", vlrDesconto=" + vlrDesconto + ", percentual=" + percentual + '}';
    }
    
}
