/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.objeto.ConfiguracaoAlerta;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "alertaView")
public class AlertaView implements Serializable {
    
    private ConfiguracaoAlerta configuracaoAlerta;

    public AlertaView() {
        configuracaoAlerta = new ConfiguracaoAlerta();
    }

    public ConfiguracaoAlerta getConfiguracaoAlerta() {
        return configuracaoAlerta;
    }

    public void setConfiguracaoAlerta(ConfiguracaoAlerta configuracaoAlerta) {
        this.configuracaoAlerta = configuracaoAlerta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.configuracaoAlerta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlertaView other = (AlertaView) obj;
        if (!Objects.equals(this.configuracaoAlerta, other.configuracaoAlerta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlertaView{" + "configuracaoAlerta=" + configuracaoAlerta + '}';
    }
    
    
}
