/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "contaView")
public class PlanoContaView implements Serializable{
    
    private Integer codigo;
    private String descricao;
    private boolean bAtivo;
    private Character imposto;
    private Character calculada;
    private Character agendada;
    
    
}
