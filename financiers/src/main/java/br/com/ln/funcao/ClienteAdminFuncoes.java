/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.dao.ClienteAdminDao;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class ClienteAdminFuncoes {

    
    public List<LnCliente> grabListCliente(){
        return ClienteAdminDao.grabListObject(LnCliente.class);
    }
    
}
