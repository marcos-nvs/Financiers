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
public class ReceitaDespesa implements Serializable{
    
    private boolean bCalculada;
    private Integer codigoCalculada;
    private boolean bImposto;
    private Integer codigoTabela;
    private Integer qtdeOcorrencia;
    private Integer diaOcorrencia;
    private boolean bJaneiro;
    private boolean bFevereiro;
    private boolean bMarco;
    private boolean bAbril;
    private boolean bMaio;
    private boolean bJunho;
    private boolean bJulho;
    private boolean bAgosto;
    private boolean bSetembro;
    private boolean bOutubro;
    private boolean bNovembro;
    private boolean bDezembro;

    public ReceitaDespesa() {
    }

    public boolean isbCalculada() {
        return bCalculada;
    }

    public void setbCalculada(boolean bCalculada) {
        this.bCalculada = bCalculada;
    }

    public Integer getCodigoCalculada() {
        return codigoCalculada;
    }

    public void setCodigoCalculada(Integer codigoCalculada) {
        this.codigoCalculada = codigoCalculada;
    }

    public boolean isbImposto() {
        return bImposto;
    }

    public void setbImposto(boolean bImposto) {
        this.bImposto = bImposto;
    }

    public Integer getCodigoTabela() {
        return codigoTabela;
    }

    public void setCodigoTabela(Integer codigoTabela) {
        this.codigoTabela = codigoTabela;
    }

    public Integer getQtdeOcorrencia() {
        return qtdeOcorrencia;
    }

    public void setQtdeOcorrencia(Integer qtdeOcorrencia) {
        this.qtdeOcorrencia = qtdeOcorrencia;
    }

    public Integer getDiaOcorrencia() {
        return diaOcorrencia;
    }

    public void setDiaOcorrencia(Integer diaOcorrencia) {
        this.diaOcorrencia = diaOcorrencia;
    }

    public boolean isbJaneiro() {
        return bJaneiro;
    }

    public void setbJaneiro(boolean bJaneiro) {
        this.bJaneiro = bJaneiro;
    }

    public boolean isbFevereiro() {
        return bFevereiro;
    }

    public void setbFevereiro(boolean bFevereiro) {
        this.bFevereiro = bFevereiro;
    }

    public boolean isbMarco() {
        return bMarco;
    }

    public void setbMarco(boolean bMarco) {
        this.bMarco = bMarco;
    }

    public boolean isbAbril() {
        return bAbril;
    }

    public void setbAbril(boolean bAbril) {
        this.bAbril = bAbril;
    }

    public boolean isbMaio() {
        return bMaio;
    }

    public void setbMaio(boolean bMaio) {
        this.bMaio = bMaio;
    }

    public boolean isbJunho() {
        return bJunho;
    }

    public void setbJunho(boolean bJunho) {
        this.bJunho = bJunho;
    }

    public boolean isbJulho() {
        return bJulho;
    }

    public void setbJulho(boolean bJulho) {
        this.bJulho = bJulho;
    }

    public boolean isbAgosto() {
        return bAgosto;
    }

    public void setbAgosto(boolean bAgosto) {
        this.bAgosto = bAgosto;
    }

    public boolean isbSetembro() {
        return bSetembro;
    }

    public void setbSetembro(boolean bSetembro) {
        this.bSetembro = bSetembro;
    }

    public boolean isbOutubro() {
        return bOutubro;
    }

    public void setbOutubro(boolean bOutubro) {
        this.bOutubro = bOutubro;
    }

    public boolean isbNovembro() {
        return bNovembro;
    }

    public void setbNovembro(boolean bNovembro) {
        this.bNovembro = bNovembro;
    }

    public boolean isbDezembro() {
        return bDezembro;
    }

    public void setbDezembro(boolean bDezembro) {
        this.bDezembro = bDezembro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.bCalculada ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.codigoCalculada);
        hash = 37 * hash + (this.bImposto ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.codigoTabela);
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
        final ReceitaDespesa other = (ReceitaDespesa) obj;
        if (this.bCalculada != other.bCalculada) {
            return false;
        }
        if (this.bImposto != other.bImposto) {
            return false;
        }
        if (!Objects.equals(this.codigoCalculada, other.codigoCalculada)) {
            return false;
        }
        if (!Objects.equals(this.codigoTabela, other.codigoTabela)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReceitaDespesa{" + "bCalculada=" + bCalculada + ", codigoCalculada=" + codigoCalculada + ", bImposto=" + bImposto + ", codigoTabela=" + codigoTabela + ", qtdeOcorrencia=" + qtdeOcorrencia + ", diaOcorrencia=" + diaOcorrencia + ", bJaneiro=" + bJaneiro + ", bFevereiro=" + bFevereiro + ", bMarco=" + bMarco + ", bAbril=" + bAbril + ", bMaio=" + bMaio + ", bJunho=" + bJunho + ", bJulho=" + bJulho + ", bAgosto=" + bAgosto + ", bSetembro=" + bSetembro + ", bOutubro=" + bOutubro + ", bNovembro=" + bNovembro + ", bDezembro=" + bDezembro + '}';
    }
    
}
