/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_agendaconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnAgendaconta.findAll", query = "SELECT l FROM LnAgendaconta l"),
    @NamedQuery(name = "LnAgendaconta.findByActInCodigo", query = "SELECT l FROM LnAgendaconta l WHERE l.actInCodigo = :actInCodigo"),
    @NamedQuery(name = "LnAgendaconta.findByCtaInCodigo", query = "SELECT l FROM LnAgendaconta l WHERE l.ctaInCodigo = :ctaInCodigo"),
    @NamedQuery(name = "LnAgendaconta.findByActDtInicio", query = "SELECT l FROM LnAgendaconta l WHERE l.actDtInicio = :actDtInicio"),
    @NamedQuery(name = "LnAgendaconta.findByActDtFinal", query = "SELECT l FROM LnAgendaconta l WHERE l.actDtFinal = :actDtFinal"),
    @NamedQuery(name = "LnAgendaconta.findByTpaInCodigo", query = "SELECT l FROM LnAgendaconta l WHERE l.tpaInCodigo = :tpaInCodigo"),
    @NamedQuery(name = "LnAgendaconta.findByActChAtivo", query = "SELECT l FROM LnAgendaconta l WHERE l.actChAtivo = :actChAtivo"),
    @NamedQuery(name = "LnAgendaconta.findByActInDia", query = "SELECT l FROM LnAgendaconta l WHERE l.actInDia = :actInDia"),
    @NamedQuery(name = "LnAgendaconta.findByActChDomingo", query = "SELECT l FROM LnAgendaconta l WHERE l.actChDomingo = :actChDomingo"),
    @NamedQuery(name = "LnAgendaconta.findByActChSegunda", query = "SELECT l FROM LnAgendaconta l WHERE l.actChSegunda = :actChSegunda"),
    @NamedQuery(name = "LnAgendaconta.findByActChTerca", query = "SELECT l FROM LnAgendaconta l WHERE l.actChTerca = :actChTerca"),
    @NamedQuery(name = "LnAgendaconta.findByActChQuarta", query = "SELECT l FROM LnAgendaconta l WHERE l.actChQuarta = :actChQuarta"),
    @NamedQuery(name = "LnAgendaconta.findByActChQuinta", query = "SELECT l FROM LnAgendaconta l WHERE l.actChQuinta = :actChQuinta"),
    @NamedQuery(name = "LnAgendaconta.findByActChSexta", query = "SELECT l FROM LnAgendaconta l WHERE l.actChSexta = :actChSexta"),
    @NamedQuery(name = "LnAgendaconta.findByActChSabado", query = "SELECT l FROM LnAgendaconta l WHERE l.actChSabado = :actChSabado"),
    @NamedQuery(name = "LnAgendaconta.findByActChAviso", query = "SELECT l FROM LnAgendaconta l WHERE l.actChAviso = :actChAviso"),
    @NamedQuery(name = "LnAgendaconta.findByActChEmail", query = "SELECT l FROM LnAgendaconta l WHERE l.actChEmail = :actChEmail"),
    @NamedQuery(name = "LnAgendaconta.findByActInQtde", query = "SELECT l FROM LnAgendaconta l WHERE l.actInQtde = :actInQtde")})
public class LnAgendaconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "act_in_codigo")
    private Integer actInCodigo;
    @Basic(optional = false)
    @Column(name = "cta_in_codigo")
    private int ctaInCodigo;
    @Basic(optional = false)
    @Column(name = "act_dt_inicio")
    @Temporal(TemporalType.DATE)
    private Date actDtInicio;
    @Column(name = "act_dt_final")
    @Temporal(TemporalType.DATE)
    private Date actDtFinal;
    @Basic(optional = false)
    @Column(name = "tpa_in_codigo")
    private int tpaInCodigo;
    @Basic(optional = false)
    @Column(name = "act_ch_ativo")
    private Character actChAtivo;
    @Column(name = "act_in_dia")
    private Integer actInDia;
    @Column(name = "act_ch_domingo")
    private Character actChDomingo;
    @Column(name = "act_ch_segunda")
    private Character actChSegunda;
    @Column(name = "act_ch_terca")
    private Character actChTerca;
    @Column(name = "act_ch_quarta")
    private Character actChQuarta;
    @Column(name = "act_ch_quinta")
    private Character actChQuinta;
    @Column(name = "act_ch_sexta")
    private Character actChSexta;
    @Column(name = "act_ch_sabado")
    private Character actChSabado;
    @Basic(optional = false)
    @Column(name = "act_ch_aviso")
    private Character actChAviso;
    @Column(name = "act_ch_email")
    private Character actChEmail;
    @Column(name = "act_in_qtde")
    private Integer actInQtde;

    public LnAgendaconta() {
    }

    public LnAgendaconta(Integer actInCodigo) {
        this.actInCodigo = actInCodigo;
    }

    public LnAgendaconta(Integer actInCodigo, int ctaInCodigo, Date actDtInicio, int tpaInCodigo, Character actChAtivo, Character actChAviso) {
        this.actInCodigo = actInCodigo;
        this.ctaInCodigo = ctaInCodigo;
        this.actDtInicio = actDtInicio;
        this.tpaInCodigo = tpaInCodigo;
        this.actChAtivo = actChAtivo;
        this.actChAviso = actChAviso;
    }

    public Integer getActInCodigo() {
        return actInCodigo;
    }

    public void setActInCodigo(Integer actInCodigo) {
        this.actInCodigo = actInCodigo;
    }

    public int getCtaInCodigo() {
        return ctaInCodigo;
    }

    public void setCtaInCodigo(int ctaInCodigo) {
        this.ctaInCodigo = ctaInCodigo;
    }

    public Date getActDtInicio() {
        return actDtInicio;
    }

    public void setActDtInicio(Date actDtInicio) {
        this.actDtInicio = actDtInicio;
    }

    public Date getActDtFinal() {
        return actDtFinal;
    }

    public void setActDtFinal(Date actDtFinal) {
        this.actDtFinal = actDtFinal;
    }

    public int getTpaInCodigo() {
        return tpaInCodigo;
    }

    public void setTpaInCodigo(int tpaInCodigo) {
        this.tpaInCodigo = tpaInCodigo;
    }

    public Character getActChAtivo() {
        return actChAtivo;
    }

    public void setActChAtivo(Character actChAtivo) {
        this.actChAtivo = actChAtivo;
    }

    public Integer getActInDia() {
        return actInDia;
    }

    public void setActInDia(Integer actInDia) {
        this.actInDia = actInDia;
    }

    public Character getActChDomingo() {
        return actChDomingo;
    }

    public void setActChDomingo(Character actChDomingo) {
        this.actChDomingo = actChDomingo;
    }

    public Character getActChSegunda() {
        return actChSegunda;
    }

    public void setActChSegunda(Character actChSegunda) {
        this.actChSegunda = actChSegunda;
    }

    public Character getActChTerca() {
        return actChTerca;
    }

    public void setActChTerca(Character actChTerca) {
        this.actChTerca = actChTerca;
    }

    public Character getActChQuarta() {
        return actChQuarta;
    }

    public void setActChQuarta(Character actChQuarta) {
        this.actChQuarta = actChQuarta;
    }

    public Character getActChQuinta() {
        return actChQuinta;
    }

    public void setActChQuinta(Character actChQuinta) {
        this.actChQuinta = actChQuinta;
    }

    public Character getActChSexta() {
        return actChSexta;
    }

    public void setActChSexta(Character actChSexta) {
        this.actChSexta = actChSexta;
    }

    public Character getActChSabado() {
        return actChSabado;
    }

    public void setActChSabado(Character actChSabado) {
        this.actChSabado = actChSabado;
    }

    public Character getActChAviso() {
        return actChAviso;
    }

    public void setActChAviso(Character actChAviso) {
        this.actChAviso = actChAviso;
    }

    public Character getActChEmail() {
        return actChEmail;
    }

    public void setActChEmail(Character actChEmail) {
        this.actChEmail = actChEmail;
    }

    public Integer getActInQtde() {
        return actInQtde;
    }

    public void setActInQtde(Integer actInQtde) {
        this.actInQtde = actInQtde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actInCodigo != null ? actInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnAgendaconta)) {
            return false;
        }
        LnAgendaconta other = (LnAgendaconta) object;
        if ((this.actInCodigo == null && other.actInCodigo != null) || (this.actInCodigo != null && !this.actInCodigo.equals(other.actInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnAgendaconta[ actInCodigo=" + actInCodigo + " ]";
    }
    
}
