/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.entity.LnFavorecido;
import br.com.ln.objeto.Ativo;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.Endereco;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "finView")
public class FinanciamentoView implements Serializable {
    
    private Date dataFinancimento;
    private boolean simulado;
    private Ativo ativoFinanciado;
    private LnFavorecido favorecido;
    private Integer contaPagamento;
    private Double valorAtivo;
    private Double valorEntrada;
    private Double valorFinanciado;
    private Double valorParcelas;
    private Integer prazoFinanciamento;
    private Double jurosMensais;

    private Ativo ativo;
    private Endereco endereco;

    private List<LnFavorecido> listaFavorecido;
    private List<Conta> listaContaPagamento;
    private List<Conta> listaContaAtivo;
    
}
