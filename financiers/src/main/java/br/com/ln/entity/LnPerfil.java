/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import br.com.ln.financiers.TipoFuncao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnPerfil.findAll", query = "SELECT l FROM LnPerfil l"),
    @NamedQuery(name = "LnPerfil.findByPerInCodigo", query = "SELECT l FROM LnPerfil l WHERE l.perInCodigo = :perInCodigo"),
    @NamedQuery(name = "LnPerfil.findByPerStDescricao", query = "SELECT l FROM LnPerfil l WHERE l.perStDescricao = :perStDescricao"),
    @NamedQuery(name = "LnPerfil.findByPerChAtivo", query = "SELECT l FROM LnPerfil l WHERE l.perChAtivo = :perChAtivo"),
    @NamedQuery(name = "LnPerfil.findByPerInCodigoPerChAtivo", query = "SELECT l FROM LnPerfil l WHERE l.perInCodigo = :perInCodigo and l.perChAtivo = :perChAtivo"),
    @NamedQuery(name = "LnPerfil.findByPerChAlterasenha", query = "SELECT l FROM LnPerfil l WHERE l.perChAlterasenha = :perChAlterasenha")})

public class LnPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @SequenceGenerator(name="seqPerfil", sequenceName = "seq_perfil", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPerfil")
    @Column(name = "per_in_codigo", unique = true, nullable = false)
    private Integer perInCodigo;
    @Basic(optional = false)
    @Column(name = "per_st_descricao")
    private String perStDescricao;
    @Basic(optional = false)
    @Column(name = "per_ch_ativo")
    private Character perChAtivo;
    @Basic(optional = false)
    @Column(name = "per_ch_alterasenha")
    private Character perChAlterasenha;
    
    @Transient
    private List<LnPerfilacesso> listPerfilAcesso = new ArrayList<>(100);
    @Transient
    private TipoFuncao tipoFuncao;

    public LnPerfil() {
    }

    public LnPerfil(Integer perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public LnPerfil(Integer perInCodigo, String perStDescricao, Character perChAtivo, Character perChAlterasenha) {
        this.perInCodigo = perInCodigo;
        this.perStDescricao = perStDescricao;
        this.perChAtivo = perChAtivo;
        this.perChAlterasenha = perChAlterasenha;
    }

    public Integer getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(Integer perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public String getPerStDescricao() {
        return perStDescricao;
    }

    public void setPerStDescricao(String perStDescricao) {
        this.perStDescricao = perStDescricao;
    }

    public Character getPerChAtivo() {
        return perChAtivo;
    }

    public void setPerChAtivo(Character perChAtivo) {
        this.perChAtivo = perChAtivo;
    }

    public Character getPerChAlterasenha() {
        return perChAlterasenha;
    }

    public void setPerChAlterasenha(Character perChAlterasenha) {
        this.perChAlterasenha = perChAlterasenha;
    }

    public List<LnPerfilacesso> getListPerfilAcesso() {
        return listPerfilAcesso;
    }

    public void setListPerfilAcesso(List<LnPerfilacesso> listPerfilAcesso) {
        this.listPerfilAcesso = listPerfilAcesso;
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
        hash += (perInCodigo != null ? perInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnPerfil)) {
            return false;
        }
        LnPerfil other = (LnPerfil) object;
        if ((this.perInCodigo == null && other.perInCodigo != null) || (this.perInCodigo != null && !this.perInCodigo.equals(other.perInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnPerfil{" + "perInCodigo=" + perInCodigo + ", perStDescricao=" + perStDescricao + ", perChAtivo=" + perChAtivo + ", perChAlterasenha=" + perChAlterasenha + ", listPerfilAcesso=" + listPerfilAcesso + ", tipoFuncao=" + tipoFuncao + '}';
    }

    
}
