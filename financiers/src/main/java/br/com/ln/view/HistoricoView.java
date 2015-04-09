/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnHistorico;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name="historicoView")
public class HistoricoView implements Serializable{
    
    private List<LnHistorico> listHistorico;

    public HistoricoView() {
    }

    public List<LnHistorico> getListHistorico() {
        if (VarComuns.lnPerfilacesso != null) {
            listHistorico = Postgress.grabListHistorico(VarComuns.lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo());
        }
        return listHistorico;
    }

    public void setListHistorico(List<LnHistorico> listHistorico) {
        this.listHistorico = listHistorico;
    }
    
    public String buscaDescModulo(Integer modInCodigo) {
        return VarComuns.mapModulo.get(modInCodigo);
    }
    
    
}
