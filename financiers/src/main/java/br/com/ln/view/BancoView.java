package br.com.ln.view;


import br.com.ln.objeto.Banco;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "bancoInfo")
public class BancoView implements Serializable{
    
    private Integer agencia;
    private Integer contaCorrente;
    private Double limiteConta;
    private Integer diaVencimento;
    private Banco banco;

    public BancoView() {
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Double getLimiteConta() {
        return limiteConta;
    }

    public void setLimiteConta(Double limiteConta) {
        this.limiteConta = limiteConta;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.agencia);
        hash = 71 * hash + Objects.hashCode(this.contaCorrente);
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
        final BancoView other = (BancoView) obj;
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        if (!Objects.equals(this.contaCorrente, other.contaCorrente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BancoView{" + "agencia=" + agencia + ", contaCorrente=" + contaCorrente + ", limiteConta=" + limiteConta + ", diaVencimento=" + diaVencimento + '}';
    }
    
    public Banco grabBanco(){
        banco = new Banco();
        banco.setAgencia(agencia);
        banco.setContaCorrente(contaCorrente);
        banco.setDiaVencimento(diaVencimento);
        banco.setLimiteConta(limiteConta);
        
        return banco;
    }
    
}
