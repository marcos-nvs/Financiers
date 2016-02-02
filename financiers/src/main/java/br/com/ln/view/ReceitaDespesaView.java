/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.objeto.Conta;
import br.com.ln.objeto.ReceitaDespesa;
import br.com.ln.objeto.Tabela;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "recdespView")
public class ReceitaDespesaView implements Serializable {

    private boolean bCalculada;
    private Integer contaBaseCalculo;
    private boolean bImposto;
    private Integer codigoTabelaImposto;
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

    private List<Conta> listaContaBase;
    private List<Tabela> listaTabela;

    private boolean bCalculadaLibera = true;
    private boolean bImpostoLibera = true;
     
    public ReceitaDespesaView() {
    }

    public boolean isbCalculada() {
        return bCalculada;
    }

    public void setbCalculada(boolean bCalculada) {
        this.bCalculada = bCalculada;
    }

    public Integer getContaBaseCalculo() {
        return contaBaseCalculo;
    }

    public void setContaBaseCalculo(Integer contaBaseCalculo) {
        this.contaBaseCalculo = contaBaseCalculo;
    }

    public boolean isbImposto() {
        return bImposto;
    }

    public void setbImposto(boolean bImposto) {
        this.bImposto = bImposto;
    }

    public Integer getCodigoTabelaImposto() {
        return codigoTabelaImposto;
    }

    public void setCodigoTabelaImposto(Integer codigoTabelaImposto) {
        this.codigoTabelaImposto = codigoTabelaImposto;
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

    public List<Conta> getListaContaBase() {
        return listaContaBase;
    }

    public void setListaContaBase(List<Conta> listaContaBase) {
        this.listaContaBase = listaContaBase;
    }

    public List<Tabela> getListaTabela() {
        return listaTabela;
    }

    public void setListaTabela(List<Tabela> listaTabela) {
        this.listaTabela = listaTabela;
    }

    public boolean isbCalculadaLibera() {
        return bCalculadaLibera;
    }

    public void setbCalculadaLibera(boolean bCalculadaLibera) {
        this.bCalculadaLibera = bCalculadaLibera;
    }

    public boolean isbImpostoLibera() {
        return bImpostoLibera;
    }

    public void setbImpostoLibera(boolean bImpostoLibera) {
        this.bImpostoLibera = bImpostoLibera;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.bCalculada ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.contaBaseCalculo);
        hash = 37 * hash + (this.bImposto ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.codigoTabelaImposto);
        hash = 37 * hash + Objects.hashCode(this.qtdeOcorrencia);
        hash = 37 * hash + Objects.hashCode(this.diaOcorrencia);
        hash = 37 * hash + (this.bJaneiro ? 1 : 0);
        hash = 37 * hash + (this.bFevereiro ? 1 : 0);
        hash = 37 * hash + (this.bMarco ? 1 : 0);
        hash = 37 * hash + (this.bAbril ? 1 : 0);
        hash = 37 * hash + (this.bMaio ? 1 : 0);
        hash = 37 * hash + (this.bJunho ? 1 : 0);
        hash = 37 * hash + (this.bJulho ? 1 : 0);
        hash = 37 * hash + (this.bAgosto ? 1 : 0);
        hash = 37 * hash + (this.bSetembro ? 1 : 0);
        hash = 37 * hash + (this.bOutubro ? 1 : 0);
        hash = 37 * hash + (this.bNovembro ? 1 : 0);
        hash = 37 * hash + (this.bDezembro ? 1 : 0);
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
        final ReceitaDespesaView other = (ReceitaDespesaView) obj;
        if (this.bCalculada != other.bCalculada) {
            return false;
        }
        if (this.bImposto != other.bImposto) {
            return false;
        }
        if (this.bJaneiro != other.bJaneiro) {
            return false;
        }
        if (this.bFevereiro != other.bFevereiro) {
            return false;
        }
        if (this.bMarco != other.bMarco) {
            return false;
        }
        if (this.bAbril != other.bAbril) {
            return false;
        }
        if (this.bMaio != other.bMaio) {
            return false;
        }
        if (this.bJunho != other.bJunho) {
            return false;
        }
        if (this.bJulho != other.bJulho) {
            return false;
        }
        if (this.bAgosto != other.bAgosto) {
            return false;
        }
        if (this.bSetembro != other.bSetembro) {
            return false;
        }
        if (this.bOutubro != other.bOutubro) {
            return false;
        }
        if (this.bNovembro != other.bNovembro) {
            return false;
        }
        if (this.bDezembro != other.bDezembro) {
            return false;
        }
        if (!Objects.equals(this.contaBaseCalculo, other.contaBaseCalculo)) {
            return false;
        }
        if (!Objects.equals(this.codigoTabelaImposto, other.codigoTabelaImposto)) {
            return false;
        }
        if (!Objects.equals(this.qtdeOcorrencia, other.qtdeOcorrencia)) {
            return false;
        }
        if (!Objects.equals(this.diaOcorrencia, other.diaOcorrencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReceitaDespesaView{" + "bCalculada=" + bCalculada + ", contaBaseCalculo=" + contaBaseCalculo + ", bImposto=" + bImposto + ", codigoTabelaImposto=" + codigoTabelaImposto + ", qtdeOcorrencia=" + qtdeOcorrencia + ", diaOcorrencia=" + diaOcorrencia + ", bJaneiro=" + bJaneiro + ", bFevereiro=" + bFevereiro + ", bMarco=" + bMarco + ", bAbril=" + bAbril + ", bMaio=" + bMaio + ", bJunho=" + bJunho + ", bJulho=" + bJulho + ", bAgosto=" + bAgosto + ", bSetembro=" + bSetembro + ", bOutubro=" + bOutubro + ", bNovembro=" + bNovembro + ", bDezembro=" + bDezembro + '}';
    }

    
    public void liberaCalculada(){
        if (bCalculada){
            bCalculadaLibera = false;
        } else {
            bCalculadaLibera = true;
        }
    }
    
    public void liberaImposto(){
        
        if (bImposto){
            bImpostoLibera = false;
        } else {
            bImpostoLibera = true;
        }
    }
    
    public ReceitaDespesa grabReceitaDespesa(){
        
        ReceitaDespesa receitaDespesa = new ReceitaDespesa();
        
        receitaDespesa.setCodigoTabelaImposto(codigoTabelaImposto);
        receitaDespesa.setContaBaseCalculo(contaBaseCalculo);
        receitaDespesa.setDiaOcorrencia(diaOcorrencia);
        receitaDespesa.setQtdeOcorrencia(qtdeOcorrencia);
        receitaDespesa.setbAbril(bAbril);
        receitaDespesa.setbAgosto(bAgosto);
        receitaDespesa.setbCalculada(bCalculada);
        receitaDespesa.setbDezembro(bDezembro);
        receitaDespesa.setbFevereiro(bFevereiro);
        receitaDespesa.setbImposto(bImposto);
        receitaDespesa.setbJaneiro(bJaneiro);
        receitaDespesa.setbJulho(bJulho);
        receitaDespesa.setbJunho(bJunho);
        receitaDespesa.setbMaio(bMaio);
        receitaDespesa.setbMarco(bMarco);
        receitaDespesa.setbNovembro(bNovembro);
        receitaDespesa.setbOutubro(bOutubro);
        receitaDespesa.setbSetembro(bSetembro);
        
        return receitaDespesa;
        
    }
}
