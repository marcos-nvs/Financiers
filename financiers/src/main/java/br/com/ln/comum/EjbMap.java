/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Marcos Naves
 */

@Singleton
public class EjbMap implements Serializable{
    
    private static final Map<String, LnUsuario> mapUsuario = new HashMap<>(100);
    private static final Map<String, LnPerfil> mapPerfil = new HashMap<>(30);
    private static final Map<String, List<LnPerfilacesso>> mapListPerfilAcesso = new HashMap<>(200);
    private static final Map<String, List<LnMenu>> mapMenu = new HashMap<>(100);
    private static final Map<String, LnPerfilacesso> mapPerfilAcesso = new HashMap<>(100);
    
    
    public synchronized static LnUsuario grabUsuario(String usuStCodigo, String strDbName){
        LnUsuario lnUsuario = null;
        String code = usuStCodigo+strDbName;
        
        if (usuStCodigo != null){
            if (mapUsuario.containsKey(code)){
                return mapUsuario.get(code);
            } else {
                lnUsuario = Postgress.grabUsuario(usuStCodigo, 'S');
                
                if (lnUsuario != null){
                    mapUsuario.put(code, lnUsuario);
                    return lnUsuario;
                }
            }
        }
        return lnUsuario;
    }
    
    public synchronized static void updateUsuario(LnUsuario lnUsuario, String strDbName){
        String code = lnUsuario.getUsuStCodigo()+strDbName;
        mapUsuario.put(code, lnUsuario);
    }
    
    public synchronized static LnPerfil grabPerfil(Integer perInCodigo,String strDbName){
        LnPerfil lnPerfil = null;
        String code = perInCodigo.toString()+strDbName;
        
        if(perInCodigo != null){
            if(mapPerfil.containsKey(code)){
                return mapPerfil.get(code);
            } else {
                lnPerfil = Postgress.grabPerfil(perInCodigo, 'S');
                
                if(lnPerfil !=null){
                    mapPerfil.put(code, lnPerfil);
                    return lnPerfil;
                }
            }
        }
        
        return lnPerfil;
    }
    
    public synchronized static void updatePerfil(LnPerfil lnPerfil, String strDbName){
        String code = lnPerfil.getPerInCodigo().toString()+strDbName;
        mapPerfil.put(code, lnPerfil);
    }
    
    public synchronized static List<LnPerfilacesso> grabListPerfilAcesso(Integer perInCodigo, String strDbName){
        List<LnPerfilacesso> listPerfilAcesso = null;
        
        String code = perInCodigo.toString()+strDbName;
        
        if(perInCodigo != null){
            if (mapListPerfilAcesso.containsKey(code)){
                return mapListPerfilAcesso.get(code);
            } else {
                listPerfilAcesso = Postgress.grabPerfilAcessoperInCodigo(perInCodigo);
                
                if(listPerfilAcesso != null && !listPerfilAcesso.isEmpty()){
                    mapListPerfilAcesso.put(code, listPerfilAcesso);
                    return listPerfilAcesso;
                }
            }
        }
        
        return listPerfilAcesso;
    }
    
    public synchronized static void updateListPerfilAcesso(List<LnPerfilacesso> listPerfilAcesso, String strDbName){
//        String code = listPerfilAcesso.get(0).getLnPerfilacessoPK().getPerInCodigo().toString()+strDbName;
//        mapListPerfilAcesso.put(code, listPerfilAcesso);
    }
    
    public static void incluiMenu() {
        List<LnMenu> listMenu = Postgress.grabMenu('S');
        String code = VarComuns.strDbName;
        mapMenu.put(code, listMenu);
    }
    
    public synchronized static List<LnMenu> grabMenu(String strDbName){
        List<LnMenu> listMenu = null;
        if(mapMenu.containsKey(strDbName)){
            return mapMenu.get(strDbName);
        }
        return listMenu;
    }
    
    public synchronized static LnPerfilacesso grabPerfilAcesso(Integer perInCodigo, Integer modInCodigo){
        
        LnPerfilacesso lnPerfilacesso = null;
        String code = perInCodigo.toString()+modInCodigo.toString()+VarComuns.strDbName;
        
        if(mapPerfilAcesso.containsKey(code)){
            return mapPerfilAcesso.get(code);
        }else {
            lnPerfilacesso = Postgress.grabPerfilAcesso(perInCodigo, modInCodigo);
            mapPerfilAcesso.put(code, lnPerfilacesso);
            return lnPerfilacesso;
        }
    }
}
