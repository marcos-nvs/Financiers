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
    
    public String tratamentoTextoCharacter(Character texto){
        
        if (texto =='S'){
            return "Sim";
        } else{
            return "Não";
        }
    }
    
}
