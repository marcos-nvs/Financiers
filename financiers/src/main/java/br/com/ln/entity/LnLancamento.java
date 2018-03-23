/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnLancamento.findAll", query = "SELECT l FROM LnLancamento l")
    , @NamedQuery(name = "LnLancamento.findByLanInCodigo", query = "SELECT l FROM LnLancamento l WHERE l.lanInCodigo = :lanInCodigo")
    , @NamedQuery(name = "LnLancamento.findByLanDtData", query = "SELECT l FROM LnLancamento l WHERE l.lanDtData = :lanDtData")
    , @NamedQuery(name = "LnLancamento.findByLanInContadebito", query = "SELECT l FROM LnLancamento l WHERE l.lanInContadebito = :lanInContadebito")
    , @NamedQuery(name = "LnLancamento.findByLanInContacredito", query = "SELECT l FROM LnLancamento l WHERE l.lanInContacredito = :lanInContacredito")
    , @NamedQuery(name = "LnLancamento.findByLanFlVlrdebito", query = "SELECT l FROM LnLancamento l WHERE l.lanFlVlrdebito = :lanFlVlrdebito")
    , @NamedQuery(name = "LnLancamento.findByLanFlVlrcredito", query = "SELECT l FROM LnLancamento l WHERE l.lanFlVlrcredito = :lanFlVlrcredito")
    , @NamedQuery(name = "LnLancamento.findByLanFlSaldoconta", query = "SELECT l FROM LnLancamento l WHERE l.lanFlSaldoconta = :lanFlSaldoconta")
    , @NamedQuery(name = "LnLancamento.findByLanFlValor", query = "SELECT l FROM LnLancamento l WHERE l.lanFlValor = :lanFlValor")
    , @NamedQuery(name = "LnLancamento.findByUsuStCodigo", query = "SELECT l FROM LnLancamento l WHERE l.usuStCodigo = :usuStCodigo")
    , @NamedQuery(name = "LnLancamento.findByFavInCodigo", query = "SELECT l FROM LnLancamento l WHERE l.favInCodigo = :favInCodigo")
    , @NamedQuery(name = "LnLancamento.findByLanStDescricao", query = "SELECT l FROM LnLancamento l WHERE l.lanStDescricao = :lanStDescricao")
    , @NamedQuery(name = "LnLancamento.findByLanChSituacao", query = "SELECT l FROM LnLancamento l WHERE l.lanChSituacao = :lanChSituacao")
    , @NamedQuery(name = "LnLancamento.findByLanDtVencimento", query = "SELECT l FROM LnLancamento l WHERE l.lanDtVencimento = :lanDtVencimento")
    , @NamedQuery(name = "LnLancamento.findByLanInTipo", query = "SELECT l FROM LnLancamento l WHERE l.lanInTipo = :lanInTipo")})
public class LnLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_in_codigo")
    private Integer lanInCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_dt_data")
    @Temporal(TemporalType.DATE)
    private Date lanDtData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_in_contadebito")
    private int lanInContadebito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_in_contacredito")
    private int lanInContacredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lan_fl_vlrdebito")
    private BigDecimal lanFlVlrdebito;
    @Column(name = "lan_fl_vlrcredito")
    private BigDecimal lanFlVlrcredito;
    @Column(name = "lan_fl_saldoconta")
    private BigDecimal lanFlSaldoconta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_fl_valor")
    private BigDecimal lanFlValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fav_in_codigo")
    private int favInCodigo;
    @Size(max = 50)
    @Column(name = "lan_st_descricao")
    private String lanStDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_ch_situacao")
    private Character lanChSituacao;
    @Column(name = "lan_dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date lanDtVencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lan_in_tipo")
    private int lanInTipo;

    public LnLancamento() {
    }

    public LnLancamento(Integer lanInCodigo) {
        this.lanInCodigo = lanInCodigo;
    }

    public LnLancamento(Integer lanInCodigo, Date lanDtData, int lanInContadebito, int lanInContacredito, BigDecimal lanFlValor, String usuStCodigo, int favInCodigo, Character lanChSituacao, int lanInTipo) {
        this.lanInCodigo = lanInCodigo;
        this.lanDtData = lanDtData;
        this.lanInContadebito = lanInContadebito;
        this.lanInContacredito = lanInContacredito;
        this.lanFlValor = lanFlValor;
        this.usuStCodigo = usuStCodigo;
        this.favInCodigo = favInCodigo;
        this.lanChSituacao = lanChSituacao;
        this.lanInTipo = lanInTipo;
    }

    public Integer getLanInCodigo() {
        return lanInCodigo;
    }

    public void setLanInCodigo(Integer lanInCodigo) {
        this.lanInCodigo = lanInCodigo;
    }

    public Date getLanDtData() {
        return lanDtData;
    }

    public void setLanDtData(Date lanDtData) {
        this.lanDtData = lanDtData;
    }

    public int getLanInContadebito() {
        return lanInContadebito;
    }

    public void setLanInContadebito(int lanInContadebito) {
        this.lanInContadebito = lanInContadebito;
    }

    public int getLanInContacredito() {
        return lanInContacredito;
    }

    public void setLanInContacredito(int lanInContacredito) {
        this.lanInContacredito = lanInContacredito;
    }

    public BigDecimal getLanFlVlrdebito() {
        return lanFlVlrdebito;
    }

    public void setLanFlVlrdebito(BigDecimal lanFlVlrdebito) {
        this.lanFlVlrdebito = lanFlVlrdebito;
    }

    public BigDecimal getLanFlVlrcredito() {
        return lanFlVlrcredito;
    }

    public void setLanFlVlrcredito(BigDecimal lanFlVlrcredito) {
        this.lanFlVlrcredito = lanFlVlrcredito;
    }

    public BigDecimal getLanFlSaldoconta() {
        return lanFlSaldoconta;
    }

    public void setLanFlSaldoconta(BigDecimal lanFlSaldoconta) {
        this.lanFlSaldoconta = lanFlSaldoconta;
    }

    public BigDecimal getLanFlValor() {
        return lanFlValor;
    }

    public void setLanFlValor(BigDecimal lanFlValor) {
        this.lanFlValor = lanFlValor;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public int getFavInCodigo() {
        return favInCodigo;
    }

    public void setFavInCodigo(int favInCodigo) {
        this.favInCodigo = favInCodigo;
    }

    public String getLanStDescricao() {
        return lanStDescricao;
    }

    public void setLanStDescricao(String lanStDescricao) {
        this.lanStDescricao = lanStDescricao;
    }

    public Character getLanChSituacao() {
        return lanChSituacao;
    }

    public void setLanChSituacao(Character lanChSituacao) {
        this.lanChSituacao = lanChSituacao;
    }

    public Date getLanDtVencimento() {
        return lanDtVencimento;
    }

    public void setLanDtVencimento(Date lanDtVencimento) {
        this.lanDtVencimento = lanDtVencimento;
    }

    public int getLanInTipo() {
        return lanInTipo;
    }

    public void setLanInTipo(int lanInTipo) {
        this.lanInTipo = lanInTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lanInCodigo != null ? lanInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnLancamento)) {
            return false;
        }
        LnLancamento other = (LnLancamento) object;
        if ((this.lanInCodigo == null && other.lanInCodigo != null) || (this.lanInCodigo != null && !this.lanInCodigo.equals(other.lanInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnLancamento[ lanInCodigo=" + lanInCodigo + " ]";
    }
    
}
