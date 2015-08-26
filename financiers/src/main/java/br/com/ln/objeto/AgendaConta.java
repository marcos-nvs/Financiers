/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class AgendaConta {
    
    private Integer idAgenda;
    private Integer idContaAgendada;
    private Date dtInicio;
    private Date DtFinal;
    private Integer idTipoAgenda;
    private Character ativo;
    private Integer diaVencimento;
    private Character domingo;
    private Character segunda;
    private Character terca;
    private Character quarta;
    private Character quinta;
    private Character sexta;
    private Character sabado;
    private Character avisar;
    private Character porEmail;
    private Integer qtdeRepeticao;

    public AgendaConta() {
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Integer getIdContaAgendada() {
        return idContaAgendada;
    }

    public void setIdContaAgendada(Integer idContaAgendada) {
        this.idContaAgendada = idContaAgendada;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFinal() {
        return DtFinal;
    }

    public void setDtFinal(Date DtFinal) {
        this.DtFinal = DtFinal;
    }

    public Integer getIdTipoAgenda() {
        return idTipoAgenda;
    }

    public void setIdTipoAgenda(Integer idTipoAgenda) {
        this.idTipoAgenda = idTipoAgenda;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Character getDomingo() {
        return domingo;
    }

    public void setDomingo(Character domingo) {
        this.domingo = domingo;
    }

    public Character getSegunda() {
        return segunda;
    }

    public void setSegunda(Character segunda) {
        this.segunda = segunda;
    }

    public Character getTerca() {
        return terca;
    }

    public void setTerca(Character terca) {
        this.terca = terca;
    }

    public Character getQuarta() {
        return quarta;
    }

    public void setQuarta(Character quarta) {
        this.quarta = quarta;
    }

    public Character getQuinta() {
        return quinta;
    }

    public void setQuinta(Character quinta) {
        this.quinta = quinta;
    }

    public Character getSexta() {
        return sexta;
    }

    public void setSexta(Character sexta) {
        this.sexta = sexta;
    }

    public Character getSabado() {
        return sabado;
    }

    public void setSabado(Character sabado) {
        this.sabado = sabado;
    }

    public Character getAvisar() {
        return avisar;
    }

    public void setAvisar(Character avisar) {
        this.avisar = avisar;
    }

    public Character getPorEmail() {
        return porEmail;
    }

    public void setPorEmail(Character porEmail) {
        this.porEmail = porEmail;
    }

    public Integer getQtdeRepeticao() {
        return qtdeRepeticao;
    }

    public void setQtdeRepeticao(Integer qtdeRepeticao) {
        this.qtdeRepeticao = qtdeRepeticao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idAgenda);
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
        final AgendaConta other = (AgendaConta) obj;
        if (!Objects.equals(this.idAgenda, other.idAgenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaConta{" + "idAgenda=" + idAgenda + ", idContaAgendada=" + idContaAgendada + ", dtInicio=" + dtInicio + ", DtFinal=" + DtFinal + ", idTipoAgenda=" + idTipoAgenda + ", ativo=" + ativo + ", diaVencimento=" + diaVencimento + ", domingo=" + domingo + ", segunda=" + segunda + ", terca=" + terca + ", quarta=" + quarta + ", quinta=" + quinta + ", sexta=" + sexta + ", sabado=" + sabado + ", avisar=" + avisar + ", porEmail=" + porEmail + ", qtdeRepeticao=" + qtdeRepeticao + '}';
    }
    
}
