/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.financiers.TipoFuncao;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_usuario", schema = "acessocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnUsuario.findAll", query = "SELECT l FROM LnUsuario l"),
    @NamedQuery(name = "LnUsuario.findByUsuStCodigo", query = "SELECT l FROM LnUsuario l WHERE l.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "LnUsuario.findByUsuStNome", query = "SELECT l FROM LnUsuario l WHERE l.usuStNome = :usuStNome"),
    @NamedQuery(name = "LnUsuario.findByUsuStSenha", query = "SELECT l FROM LnUsuario l WHERE l.usuStSenha = :usuStSenha"),
    @NamedQuery(name = "LnUsuario.findByUsuStEmail", query = "SELECT l FROM LnUsuario l WHERE l.usuStEmail = :usuStEmail"),
    @NamedQuery(name = "LnUsuario.findByUsuChAtivo", query = "SELECT l FROM LnUsuario l WHERE l.usuChAtivo = :usuChAtivo"),
    @NamedQuery(name = "LnUsuario.findByUsuInDia", query = "SELECT l FROM LnUsuario l WHERE l.usuInDia = :usuInDia"),
    @NamedQuery(name = "LnUsuario.findByUsuChAlterasenha", query = "SELECT l FROM LnUsuario l WHERE l.usuChAlterasenha = :usuChAlterasenha"),
    @NamedQuery(name = "LnUsuario.findByUsuChExpirasenha", query = "SELECT l FROM LnUsuario l WHERE l.usuChExpirasenha = :usuChExpirasenha"),
    @NamedQuery(name = "LnUsuario.findByUsuDtExpiracao", query = "SELECT l FROM LnUsuario l WHERE l.usuDtExpiracao = :usuDtExpiracao"),
    @NamedQuery(name = "LnUsuario.findByUsuDtCadastro", query = "SELECT l FROM LnUsuario l WHERE l.usuDtCadastro = :usuDtCadastro"),
    @NamedQuery(name = "LnUsuario.findByPerInCodigo", query = "SELECT l FROM LnUsuario l WHERE l.perInCodigo = :perInCodigo"),
    @NamedQuery(name = "LnUsuario.findByUsuStCpf", query = "SELECT l FROM LnUsuario l WHERE l.usuStCpf = :usuStCpf"),
    @NamedQuery(name = "LnUsuario.findByCliInCodigo", query = "SELECT l FROM LnUsuario l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnUsuario.findAllUsuStCodigoUsuChAtivo", query = "SELECT l FROM LnUsuario l WHERE l.usuStCodigo = :usuStCodigo and l.usuChAtivo = :usuChAtivo")})
public class LnUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;
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
    @Basic(optional = false)
    @Column(name = "usu_st_cpf")
    private String usuStCpf;
    @Column(name = "cli_in_codigo")
    private Integer cliInCodigo;
    @Column(name = "usu_st_admin")
    private Character usuStAdmin;
    
    @Transient
    private TipoFuncao tipoFuncao;
    

    public LnUsuario() {
    }

    public LnUsuario(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public LnUsuario(String usuStCodigo, String usuStNome, String usuStSenha, Character usuChAtivo, Character usuChAlterasenha, Character usuChExpirasenha, int perInCodigo, String usuStCpf) {
        this.usuStCodigo = usuStCodigo;
        this.usuStNome = usuStNome;
        this.usuStSenha = usuStSenha;
        this.usuChAtivo = usuChAtivo;
        this.usuChAlterasenha = usuChAlterasenha;
        this.usuChExpirasenha = usuChExpirasenha;
        this.perInCodigo = perInCodigo;
        this.usuStCpf = usuStCpf;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
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

    public String getUsuStCpf() {
        return usuStCpf;
    }

    public void setUsuStCpf(String usuStCpf) {
        this.usuStCpf = usuStCpf;
    }

    public Integer getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public Character getUsuStAdmin() {
        return usuStAdmin;
    }

    public void setUsuStAdmin(Character usuStAdmin) {
        this.usuStAdmin = usuStAdmin;
    }
    
    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnUsuario)) {
            return false;
        }
        LnUsuario other = (LnUsuario) object;
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnUsuario{" + "usuStCodigo=" + usuStCodigo + ", usuStNome=" + usuStNome + ", usuStSenha=" + usuStSenha + ", usuStEmail=" + usuStEmail + ", usuChAtivo=" + usuChAtivo + ", usuInDia=" + usuInDia + ", usuChAlterasenha=" + usuChAlterasenha + ", usuChExpirasenha=" + usuChExpirasenha + ", usuDtExpiracao=" + usuDtExpiracao + ", usuDtCadastro=" + usuDtCadastro + ", perInCodigo=" + perInCodigo + ", usuStCpf=" + usuStCpf + ", cliInCodigo=" + cliInCodigo + ", usuStAdmin=" + usuStAdmin + ", tipoFuncao=" + tipoFuncao + '}';
    }

    
}
