/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.dao.EnderecoDao;
import br.com.ln.dao.TelefoneDao;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class EnderecoFuncoes {
    
    private String mensagem;
    private boolean validado;
    private Integer codigo = 0;
    
    public String validacao(LnEndereco lnEndereco){
        mensagem = "";
        
        if (lnEndereco != null){
            if (lnEndereco.getEndStEndereco() != null && lnEndereco.getEndStEndereco().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Logradouro - ";
            }
            if (lnEndereco.getEndStBairro() != null && lnEndereco.getEndStBairro().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Bairro - ";
            }
            if (lnEndereco.getEndStCidade() != null && lnEndereco.getEndStCidade().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Cidade - ";
            }
            if (lnEndereco.getEndStEstado() != null && lnEndereco.getEndStEstado().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o Estado - ";
            }
            if (lnEndereco.getEndStCep() != null && lnEndereco.getEndStCep().isEmpty()){
                mensagem = mensagem + "Por favor, preencher o CEP - ";
            }
        } else {
            mensagem="Endereço vazio, por favor preencher";
        }
        
        if (mensagem.equals("")){
            mensagem = "Sucesso";
        }
        
        return mensagem;
    }
    
    public String descricaoTipo(Character tipoEndereco){
        
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
    
    public Integer calculaCodigo(){
        Integer codigoNovo;
        
        codigoNovo = codigo + 1;
        codigo = codigoNovo;
        
        return codigo;
    }
    
    public List<LnEndereco> grabListEndereco(Integer cliInCodigo){
        return EnderecoDao.grabListEnderecoCodigoCliente(cliInCodigo);
    }

    public List<LnTelefone> grabListTelefone(Integer cliInCodigo){
        return TelefoneDao.grabListTelefoneCodigoCliente(cliInCodigo);
    }
}
