/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.dao.IrrfDao;
import br.com.ln.financiers.Irrf;
import br.com.ln.financiers.IrrfDescricao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "IrrfView")
public class IrrfView implements Serializable {

    private List<IrrfDescricao> listIrrfDescricao;
    private List<Irrf> listIrrf; 
    private IrrfDescricao irrfDescricao;
    
    public IrrfView() {
        listIrrfDescricao = IrrfDao.grabIrrfDescricao();
    }

    public List<IrrfDescricao> getListIrrfDescricao() {
        return listIrrfDescricao;
    }

    public void setListIrrfDescricao(List<IrrfDescricao> listIrrfDescricao) {
        this.listIrrfDescricao = listIrrfDescricao;
    }

    public List<Irrf> getListIrrf() {
        return listIrrf;
    }

    public void setListIrrf(List<Irrf> listIrrf) {
        this.listIrrf = listIrrf;
    }

    public IrrfDescricao getIrrfDescricao() {
        return irrfDescricao;
    }

    public void setIrrfDescricao(IrrfDescricao irrfDescricao) {
        this.irrfDescricao = irrfDescricao;
    }
    
    private void listaIrrf(){
        listIrrfDescricao.stream().forEach((Irrf) -> {
            Irrf.setListIrrf(IrrfDao.listIrrf(Irrf.getCodigo()));
        });
    }
}
