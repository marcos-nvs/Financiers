/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.dao.ClienteAdminDao;
import br.com.ln.dao.EnderecoDao;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
import br.com.ln.financiers.ClienteAdminFuncoes;
import br.com.ln.financiers.EnderecoFuncoes;
import br.com.ln.financiers.TratamentoEspecial;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "clienteAdminView")
public class ClienteAdminView implements Serializable {
    
    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;
    
    private List<LnCliente> listCliente;
    private List<LnEndereco> listEndereco;
    private List<LnTelefone> listTelefone;
    
    private ClienteAdminFuncoes clienteAdminFuncoes;
    private EnderecoFuncoes enderecoFuncoes;
    private TratamentoEspecial tratativa;
    
    public ClienteAdminView() {
        enderecoFuncoes = new EnderecoFuncoes();
        tratativa = new TratamentoEspecial();
        clienteAdminFuncoes = new ClienteAdminFuncoes();
        listCliente = clienteAdminFuncoes.grabListCliente();
        listaEnderecoCliente();
        listaTelefoneCliente();
    }

    public LnCliente getLnCliente() {
        return lnCliente;
    }

    public void setLnCliente(LnCliente lnCliente) {
        this.lnCliente = lnCliente;
    }

    public LnEndereco getLnEndereco() {
        return lnEndereco;
    }

    public void setLnEndereco(LnEndereco lnEndereco) {
        this.lnEndereco = lnEndereco;
    }

    public LnTelefone getLnTelefone() {
        return lnTelefone;
    }

    public void setLnTelefone(LnTelefone lnTelefone) {
        this.lnTelefone = lnTelefone;
    }

    public List<LnCliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<LnCliente> listCliente) {
        this.listCliente = listCliente;
    }

    public List<LnEndereco> getListEndereco() {
        return listEndereco;
    }

    public void setListEndereco(List<LnEndereco> listEndereco) {
        this.listEndereco = listEndereco;
    }

    public List<LnTelefone> getListTelefone() {
        return listTelefone;
    }

    public void setListTelefone(List<LnTelefone> listTelefone) {
        this.listTelefone = listTelefone;
    }
    

    private void listaEnderecoCliente(){
        listCliente.stream().forEach((cliente) -> {
            cliente.setListEndereco(enderecoFuncoes.grabListEndereco(cliente.getCliInCodigo()));
        });
    }
            
    private void listaTelefoneCliente(){
        listCliente.stream().forEach((cliente) -> {
            cliente.setListTelefone(enderecoFuncoes.grabListTelefone(cliente.getCliInCodigo()));
        });
    }
    
}
