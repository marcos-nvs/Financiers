/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.entity.LnEndereco;

/**
 *
 * @author Marcos Naves
 */
public class EnderecoFuncoes {
    
    private String mensagem;
    private boolean validado;
    
    public String endereco(LnEndereco lnEndereco){
        mensagem = "";
        
        if (lnEndereco != null){
            if (lnEndereco.getEndStEndereco().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Logradouro - ";
            }
            if (lnEndereco.getEndStBairro().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Bairro - ";
            }
            if (lnEndereco.getEndStCidade().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Cidade - ";
            }
            if (lnEndereco.getEndStEstado().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Estado - ";
            }
            if (lnEndereco.getEndStCep().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o CEP - ";
            }
        } else {
            mensagem="Endereço vazio, por favor preencher";
        }
        return mensagem;
    }
}
