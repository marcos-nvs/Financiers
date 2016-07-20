/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.objeto;

import java.io.Serializable;

/**
 *
 * @author Marcos Naves
 */

public class MesFrequencia implements Serializable{

    private boolean janeiro;
    private boolean fevereiro;
    private boolean marco;
    private boolean abril;
    private boolean maio;
    private boolean junho;
    private boolean julho;
    private boolean agosto;
    private boolean setembro;
    private boolean outubro;
    private boolean novembro;
    private boolean dezembro;

    public MesFrequencia() {
    }

    public boolean isJaneiro() {
        return janeiro;
    }

    public void setJaneiro(boolean janeiro) {
        this.janeiro = janeiro;
    }

    public boolean isFevereiro() {
        return fevereiro;
    }

    public void setFevereiro(boolean fevereiro) {
        this.fevereiro = fevereiro;
    }

    public boolean isMarco() {
        return marco;
    }

    public void setMarco(boolean marco) {
        this.marco = marco;
    }

    public boolean isAbril() {
        return abril;
    }

    public void setAbril(boolean abril) {
        this.abril = abril;
    }

    public boolean isMaio() {
        return maio;
    }

    public void setMaio(boolean maio) {
        this.maio = maio;
    }

    public boolean isJunho() {
        return junho;
    }

    public void setJunho(boolean junho) {
        this.junho = junho;
    }

    public boolean isJulho() {
        return julho;
    }

    public void setJulho(boolean julho) {
        this.julho = julho;
    }

    public boolean isAgosto() {
        return agosto;
    }

    public void setAgosto(boolean agosto) {
        this.agosto = agosto;
    }

    public boolean isSetembro() {
        return setembro;
    }

    public void setSetembro(boolean setembro) {
        this.setembro = setembro;
    }

    public boolean isOutubro() {
        return outubro;
    }

    public void setOutubro(boolean outubro) {
        this.outubro = outubro;
    }

    public boolean isNovembro() {
        return novembro;
    }

    public void setNovembro(boolean novembro) {
        this.novembro = novembro;
    }

    public boolean isDezembro() {
        return dezembro;
    }

    public void setDezembro(boolean dezembro) {
        this.dezembro = dezembro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.janeiro ? 1 : 0);
        hash = 41 * hash + (this.fevereiro ? 1 : 0);
        hash = 41 * hash + (this.marco ? 1 : 0);
        hash = 41 * hash + (this.abril ? 1 : 0);
        hash = 41 * hash + (this.maio ? 1 : 0);
        hash = 41 * hash + (this.junho ? 1 : 0);
        hash = 41 * hash + (this.julho ? 1 : 0);
        hash = 41 * hash + (this.agosto ? 1 : 0);
        hash = 41 * hash + (this.setembro ? 1 : 0);
        hash = 41 * hash + (this.outubro ? 1 : 0);
        hash = 41 * hash + (this.novembro ? 1 : 0);
        hash = 41 * hash + (this.dezembro ? 1 : 0);
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
        final MesFrequencia other = (MesFrequencia) obj;
        if (this.janeiro != other.janeiro) {
            return false;
        }
        if (this.fevereiro != other.fevereiro) {
            return false;
        }
        if (this.marco != other.marco) {
            return false;
        }
        if (this.abril != other.abril) {
            return false;
        }
        if (this.maio != other.maio) {
            return false;
        }
        if (this.junho != other.junho) {
            return false;
        }
        if (this.julho != other.julho) {
            return false;
        }
        if (this.agosto != other.agosto) {
            return false;
        }
        if (this.setembro != other.setembro) {
            return false;
        }
        if (this.outubro != other.outubro) {
            return false;
        }
        if (this.novembro != other.novembro) {
            return false;
        }
        if (this.dezembro != other.dezembro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MesFrequencia{" + "janeiro=" + janeiro + ", fevereiro=" + fevereiro + ", marco=" + marco + ", abril=" + abril + ", maio=" + maio + ", junho=" + junho + ", julho=" + julho + ", agosto=" + agosto + ", setembro=" + setembro + ", outubro=" + outubro + ", novembro=" + novembro + ", dezembro=" + dezembro + '}';
    }
    
}
