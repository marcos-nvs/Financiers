/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcos Naves
 */
public class ContaDependente implements Serializable{
    
    private Integer idContaPrincipal;
    private Integer idContaCalculada;
    private Integer idTabela;
    private Integer ordem;

    public ContaDependente() {
    }

    public Integer getIdContaPrincipal() {
        return idContaPrincipal;
    }

    public void setIdContaPrincipal(Integer idContaPrincipal) {
        this.idContaPrincipal = idContaPrincipal;
    }

    public Integer getIdContaCalculada() {
        return idContaCalculada;
    }

    public void setIdContaCalculada(Integer idContaCalculada) {
        this.idContaCalculada = idContaCalculada;
    }

    public Integer getIdTabela() {
        return idTabela;
    }

    public void setIdTabela(Integer idTabela) {
        this.idTabela = idTabela;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idContaPrincipal);
        hash = 23 * hash + Objects.hashCode(this.idContaCalculada);
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
        final ContaDependente other = (ContaDependente) obj;
        if (!Objects.equals(this.idContaPrincipal, other.idContaPrincipal)) {
            return false;
        }
        if (!Objects.equals(this.idContaCalculada, other.idContaCalculada)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContaDependente{" + "idContaPrincipal=" + idContaPrincipal + ", idContaCalculada=" + idContaCalculada + ", idTabela=" + idTabela + ", ordem=" + ordem + '}';
    }
    
    
}
