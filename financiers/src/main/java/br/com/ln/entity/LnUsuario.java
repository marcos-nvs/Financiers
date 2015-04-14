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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ln_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnUsuario.findAll", query = "SELECT l FROM LnUsuario l"),
    @NamedQuery(name = "LnUsuario.findByUsuStCpf", query = "SELECT l FROM LnUsuario l WHERE l.lnUsuarioPK.usuStCpf = :usuStCpf"),
    @NamedQuery(name = "LnUsuario.findByUsuStCodigo", query = "SELECT l FROM LnUsuario l WHERE l.lnUsuarioPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "LnUsuario.findByUsuStNome", query = "SELECT l FROM LnUsuario l WHERE l.usuStNome = :usuStNome"),
    @NamedQuery(name = "LnUsuario.findByUsuStSenha", query = "SELECT l FROM LnUsuario l WHERE l.usuStSenha = :usuStSenha"),
    @NamedQuery(name = "LnUsuario.findByUsuStEmail", query = "SELECT l FROM LnUsuario l WHERE l.usuStEmail = :usuStEmail"),
    @NamedQuery(name = "LnUsuario.findByUsuChAtivo", query = "SELECT l FROM LnUsuario l WHERE l.usuChAtivo = :usuChAtivo"),
    @NamedQuery(name = "LnUsuario.findByUsuInDia", query = "SELECT l FROM LnUsuario l WHERE l.usuInDia = :usuInDia"),
    @NamedQuery(name = "LnUsuario.findByUsuChAlterasenha", query = "SELECT l FROM LnUsuario l WHERE l.usuChAlterasenha = :usuChAlterasenha"),
    @NamedQuery(name = "LnUsuario.findByUsuChExpirasenha", query = "SELECT l FROM LnUsuario l WHERE l.usuChExpirasenha = :usuChExpirasenha"),
    @NamedQuery(name = "LnUsuario.findByUsuDtExpiracao", query = "SELECT l FROM LnUsuario l WHERE l.usuDtExpiracao = :usuDtExpiracao"),
    @NamedQuery(name = "LnUsuario.findByUsuDtCadastro", query = "SELECT l FROM LnUsuario l WHERE l.usuDtCadastro = :usuDtCadastro"),
    @NamedQuery(name = "LnUsuario.findByPerInCodigo", query = "SELECT l FROM LnUsuario l WHERE l.perInCodigo = :perInCodigo")})
public class LnUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LnUsuarioPK lnUsuarioPK;
    @Basic(optional = false)
    @Column(name = "usu_st_nome")
    private String usuStNome;
    @Basic(optional = false)
    @Column(name = "usu_st_senha")
    private String usuStSenha;
    @Column(name = "usu_st_email")
    private String usuStEmail;
    @Basic(optional = false)
    @Column(name = "usu_ch_ativo")
    private Character usuChAtivo;
    @Column(name = "usu_in_dia")
    private Integer usuInDia;
    @Basic(optional = false)
    @Column(name = "usu_ch_alterasenha")
    private Character usuChAlterasenha;
    @Basic(optional = false)
    @Column(name = "usu_ch_expirasenha")
    private Character usuChExpirasenha;
    @Column(name = "usu_dt_expiracao")
    @Temporal(TemporalType.DATE)
    private Date usuDtExpiracao;
    @Column(name = "usu_dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date usuDtCadastro;
    @Basic(optional = false)
    @Column(name = "per_in_codigo")
    private int perInCodigo;

    public LnUsuario() {
    }

    public LnUsuario(LnUsuarioPK lnUsuarioPK) {
        this.lnUsuarioPK = lnUsuarioPK;
    }

    public LnUsuario(LnUsuarioPK lnUsuarioPK, String usuStNome, String usuStSenha, Character usuChAtivo, Character usuChAlterasenha, Character usuChExpirasenha, int perInCodigo) {
        this.lnUsuarioPK = lnUsuarioPK;
        this.usuStNome = usuStNome;
        this.usuStSenha = usuStSenha;
        this.usuChAtivo = usuChAtivo;
        this.usuChAlterasenha = usuChAlterasenha;
        this.usuChExpirasenha = usuChExpirasenha;
        this.perInCodigo = perInCodigo;
    }

    public LnUsuario(String usuStCpf, String usuStCodigo) {
        this.lnUsuarioPK = new LnUsuarioPK(usuStCpf, usuStCodigo);
    }

    public LnUsuarioPK getLnUsuarioPK() {
        return lnUsuarioPK;
    }

    public void setLnUsuarioPK(LnUsuarioPK lnUsuarioPK) {
        this.lnUsuarioPK = lnUsuarioPK;
    }

    public String getUsuStNome() {
        return usuStNome;
    }

    public void setUsuStNome(String usuStNome) {
        this.usuStNome = usuStNome;
    }

    public String getUsuStSenha() {
        return usuStSenha;
    }

    public void setUsuStSenha(String usuStSenha) {
        this.usuStSenha = usuStSenha;
    }

    public String getUsuStEmail() {
        return usuStEmail;
    }

    public void setUsuStEmail(String usuStEmail) {
        this.usuStEmail = usuStEmail;
    }

    public Character getUsuChAtivo() {
        return usuChAtivo;
    }

    public void setUsuChAtivo(Character usuChAtivo) {
        this.usuChAtivo = usuChAtivo;
    }

    public Integer getUsuInDia() {
        return usuInDia;
    }

    public void setUsuInDia(Integer usuInDia) {
        this.usuInDia = usuInDia;
    }

    public Character getUsuChAlterasenha() {
        return usuChAlterasenha;
    }

    public void setUsuChAlterasenha(Character usuChAlterasenha) {
        this.usuChAlterasenha = usuChAlterasenha;
    }

    public Character getUsuChExpirasenha() {
        return usuChExpirasenha;
    }

    public void setUsuChExpirasenha(Character usuChExpirasenha) {
        this.usuChExpirasenha = usuChExpirasenha;
    }

    public Date getUsuDtExpiracao() {
        return usuDtExpiracao;
    }

    public void setUsuDtExpiracao(Date usuDtExpiracao) {
        this.usuDtExpiracao = usuDtExpiracao;
    }

    public Date getUsuDtCadastro() {
        return usuDtCadastro;
    }

    public void setUsuDtCadastro(Date usuDtCadastro) {
        this.usuDtCadastro = usuDtCadastro;
    }

    public int getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(int perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnUsuarioPK != null ? lnUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnUsuario)) {
            return false;
        }
        LnUsuario other = (LnUsuario) object;
        if ((this.lnUsuarioPK == null && other.lnUsuarioPK != null) || (this.lnUsuarioPK != null && !this.lnUsuarioPK.equals(other.lnUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.LnUsuario[ lnUsuarioPK=" + lnUsuarioPK + " ]";
    }
    
}
