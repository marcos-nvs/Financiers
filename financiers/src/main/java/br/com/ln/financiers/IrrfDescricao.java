/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class IrrfDescricao implements Serializable{
    
    private Integer codigo;
    private String Descricao;
    private Date dtInicio;
    private Date dtFinal;
    private List<Irrf> listIrrf;

    public IrrfDescricao() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public List<Irrf> getListIrrf() {
        return listIrrf;
    }

    public void setListIrrf(List<Irrf> listIrrf) {
        this.listIrrf = listIrrf;
    }

    
}
