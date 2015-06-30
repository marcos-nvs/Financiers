/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnTelefone;

/**
 *
 * @author Marcos Naves
 */
public class TelefoneFuncoes {
    
    private String mensagem;
    private boolean validado;
    private Integer codigo = 0;
    
    public String validacao(LnTelefone lnTelefone){
        mensagem = "";
        
        if (lnTelefone != null){
            if (lnTelefone.getTelStDdd() != null && lnTelefone.getTelStDdd().isEmpty()){
                mensagem = "Por favor, entre com o DDD - ";
            }
            if (lnTelefone.getTelStTelefone() != null && lnTelefone.getTelStTelefone().isEmpty()){
                mensagem = "Por favor, entre com o Telefone - ";
            }
        } else {
                mensagem = "Telefone vazio!!!";
        }
        
        if (mensagem.equals("")){
            mensagem = "Sucesso";
        }
        
        return mensagem;
    }
    
    public String descricaoTipo(Character tipoTelefone){
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
    
    public Integer calculaCodigo(){
        Integer codigoNovo;
        codigoNovo = codigo +1;
        
        codigo = codigoNovo;
        return codigo;
    }
}
