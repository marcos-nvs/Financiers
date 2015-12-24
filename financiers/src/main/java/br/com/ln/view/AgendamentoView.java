/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.dao.PlanoContaDao;
import br.com.ln.entity.LnTipoagenda;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "agendaView")
public class AgendamentoView implements Serializable {

    private Integer iTipoCodigo;
    private Date dtInicio;
    private Date dtFinal;
    private boolean bAtivo;
    private Integer iDiaVencimento;
    private boolean btDomingo;
    private boolean btSegunda;
    private boolean btTerca;
    private boolean btQuarta;
    private boolean btQuinta;
    private boolean btSexta;
    private boolean btSabado;
    private boolean btAvisar;
    private boolean btAvisarEmail;
    private Integer iQtdeExecucao;
    private String eMail;
    
    private List<LnTipoagenda> listaTipoAgenda;

    public AgendamentoView() {
    }

    public Integer getiTipoCodigo() {
        return iTipoCodigo;
    }

    public void setiTipoCodigo(Integer iTipoCodigo) {
        this.iTipoCodigo = iTipoCodigo;
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

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public Integer getiDiaVencimento() {
        return iDiaVencimento;
    }

    public void setiDiaVencimento(Integer iDiaVencimento) {
        this.iDiaVencimento = iDiaVencimento;
    }

    public boolean isBtDomingo() {
        return btDomingo;
    }

    public void setBtDomingo(boolean btDomingo) {
        this.btDomingo = btDomingo;
    }

    public boolean isBtSegunda() {
        return btSegunda;
    }

    public void setBtSegunda(boolean btSegunda) {
        this.btSegunda = btSegunda;
    }

    public boolean isBtTerca() {
        return btTerca;
    }

    public void setBtTerca(boolean btTerca) {
        this.btTerca = btTerca;
    }

    public boolean isBtQuarta() {
        return btQuarta;
    }

    public void setBtQuarta(boolean btQuarta) {
        this.btQuarta = btQuarta;
    }

    public boolean isBtQuinta() {
        return btQuinta;
    }

    public void setBtQuinta(boolean btQuinta) {
        this.btQuinta = btQuinta;
    }

    public boolean isBtSexta() {
        return btSexta;
    }

    public void setBtSexta(boolean btSexta) {
        this.btSexta = btSexta;
    }

    public boolean isBtSabado() {
        return btSabado;
    }

    public void setBtSabado(boolean btSabado) {
        this.btSabado = btSabado;
    }

    public boolean isBtAvisar() {
        return btAvisar;
    }

    public void setBtAvisar(boolean btAvisar) {
        this.btAvisar = btAvisar;
    }

    public boolean isBtAvisarEmail() {
        return btAvisarEmail;
    }

    public void setBtAvisarEmail(boolean btAvisarEmail) {
        this.btAvisarEmail = btAvisarEmail;
    }

    public Integer getiQtdeExecucao() {
        return iQtdeExecucao;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public void setiQtdeExecucao(Integer iQtdeExecucao) {
        this.iQtdeExecucao = iQtdeExecucao;
    }

    public List<LnTipoagenda> getListaTipoAgenda() {
        return PlanoContaDao.grabListAgenda();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.iTipoCodigo);
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
        final AgendamentoView other = (AgendamentoView) obj;
        if (!Objects.equals(this.iTipoCodigo, other.iTipoCodigo)) {
            return false;
        }
        return true;
    }

    
    public void setListaTipoAgenda(List<LnTipoagenda> listaTipoAgenda) {
        this.listaTipoAgenda = listaTipoAgenda;
    }

    @Override
    public String toString() {
        return "AgendamentoView{" + "iTipoCodigo=" + iTipoCodigo + ", dtInicio=" + dtInicio + ", dtFinal=" + dtFinal + ", bAtivo=" + bAtivo + ", iDiaVencimento=" + iDiaVencimento + ", btDomingo=" + btDomingo + ", btSegunda=" + btSegunda + ", btTerca=" + btTerca + ", btQuarta=" + btQuarta + ", btQuinta=" + btQuinta + ", btSexta=" + btSexta + ", btSabado=" + btSabado + ", btAvisar=" + btAvisar + ", btAvisarEmail=" + btAvisarEmail + ", iQtdeExecucao=" + iQtdeExecucao + ", listaTipoAgenda=" + listaTipoAgenda + '}';
    }
    
}
