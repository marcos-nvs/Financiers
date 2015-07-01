/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name="tratativa")
public class TratamentoEspecial implements Serializable{
    
    public String tratamentoTextoString(Character texto){
        
        if (texto =='S'){
            return "Sim";
        } else{
            return "Não";
        }
    }

    public boolean tratamentoTextoBoolean(Character texto){
        
        if (texto.equals('S')){
            return true;
        } else {
            return false;
        }
    }

    public Character tratamentoTextoCharacter(boolean texto){
        
        if (texto){
            return 'S';
        } else {
            return 'N';
        }
    }
    
    public String tratamentoCpf(String cpf){
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");
        return cpf;
    }
    
    public String tratamentoTipoEndereco(Character tipoEndereco){
        switch (tipoEndereco){
            case '1':
                return "Residêncial";
            case '2':
                return "Comercial";
            case '3':
                return "Cobrança";
        }
        return null;
    }
    
    public String tratamentoTipoTelefone(Character tipoTelefone){
        switch (tipoTelefone){
            case '1':
                return "Residêncial";
            case '2':
                return "Comercial";
            case '3':
                return "Celular";
        }
        return null;
    }
}
