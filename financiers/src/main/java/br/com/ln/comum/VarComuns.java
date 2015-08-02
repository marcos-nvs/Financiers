/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
public class VarComuns implements Serializable{
    
    public static String strDbName= VarComuns.strDbName;
    public static LnPerfil lnPerfil;
    public static LnPerfilacesso lnPerfilacesso;
    public static LnUsuario lnUsusario;
    public static LnCliente lnCliente;
    public static Map<Integer, String> mapModulo = new HashMap<>();
    
    public static String local(){
        Locale locale = Locale.getDefault();
        return locale.toString();
    }

    
}
