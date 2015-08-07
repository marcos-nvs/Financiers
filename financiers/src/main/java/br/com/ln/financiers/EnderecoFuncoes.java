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
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class EnderecoFuncoes {
    
    public String mensagem;
    private boolean validado;
    private Integer codigo = 0;
    
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public boolean validacao(LnEndereco lnEndereco){
        
        boolean validado = true;
        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + ": ";
        
        
        if (lnEndereco != null){
            if (lnEndereco.getEndStEndereco() == null || lnEndereco.getEndStEndereco().isEmpty()){
                mensagem = mensagem + bundle.getString("ln.texto.endereco")  + "; ";
                validado = false;
            }
            if (lnEndereco.getEndStBairro() == null || lnEndereco.getEndStBairro().isEmpty()){
                mensagem = mensagem + bundle.getString("ln.texto.bairro")  + "; ";
                validado = false;
            }
            if (lnEndereco.getEndStCidade() == null || lnEndereco.getEndStCidade().isEmpty()){
                mensagem = mensagem + bundle.getString("ln.texto.cidade")  + "; ";
                validado = false;
            }
            if (lnEndereco.getEndStEstado() == null || lnEndereco.getEndStEstado().isEmpty()){
                mensagem = mensagem + bundle.getString("ln.texto.estado")  + "; ";
                validado = false;
            }
            if (lnEndereco.getEndStCep() == null || lnEndereco.getEndStCep().isEmpty()){
                mensagem = mensagem + bundle.getString("ln.texto.cep")  + "; ";
                validado = false;
            }
        } else {
            mensagem = bundle.getString("ln.mb.frase.preenchercampos");
            validado = false;
        }
        
        if (validado){
            mensagem = bundle.getString("ln.mb.texto.sucesso");
        }
        
        return validado;
    }
    
    public String descricaoTipo(Character tipoEndereco){
        
        switch (tipoEndereco){
            case '1':
                return bundle.getString("ln.texto.residencia");
            case '2':
                return bundle.getString("ln.texto.comercial");
            case '3':
                return bundle.getString("ln.texto.cobranca");
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
