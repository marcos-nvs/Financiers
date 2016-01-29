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
public class ConfiguracaoAlerta implements Serializable{
    
    private boolean aleta;
    private boolean email;
    private String emailDescricao;

    public ConfiguracaoAlerta() {
    }

    public boolean isAleta() {
        return aleta;
    }

    public void setAleta(boolean aleta) {
        this.aleta = aleta;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public String getEmailDescricao() {
        return emailDescricao;
    }

    public void setEmailDescricao(String emailDescricao) {
        this.emailDescricao = emailDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.aleta ? 1 : 0);
        hash = 89 * hash + (this.email ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.emailDescricao);
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
        final ConfiguracaoAlerta other = (ConfiguracaoAlerta) obj;
        if (this.aleta != other.aleta) {
            return false;
        }
        if (this.email != other.email) {
            return false;
        }
        if (!Objects.equals(this.emailDescricao, other.emailDescricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConfiguracaoAlerta{" + "aleta=" + aleta + ", email=" + email + ", emailDescricao=" + emailDescricao + '}';
    }
    
}
