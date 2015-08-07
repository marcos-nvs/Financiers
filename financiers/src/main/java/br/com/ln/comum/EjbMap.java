/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import br.com.ln.dao.ClienteDao;
import br.com.ln.dao.MenuDao;
import br.com.ln.dao.PerfilDao;
import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnTipoconta;
import br.com.ln.entity.LnUsuario;
import br.com.ln.dao.TipoContaDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnCliente;
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
    private static final Map<String, LnCliente> mapCliente = new HashMap<>(100);
    private static final Map<String, LnPerfil> mapPerfil = new HashMap<>(30);
    private static final Map<String, List<LnPerfilacesso>> mapListPerfilAcesso = new HashMap<>(200);
    private static final Map<String, List<LnMenu>> mapMenu = new HashMap<>(100);
    private static final Map<String, LnPerfilacesso> mapPerfilAcesso = new HashMap<>(100);
    private static final Map<String, LnTipoconta> mapTipoConta = new HashMap<>(20);
    
    
    public synchronized static LnUsuario grabUsuario(String usuStCodigo){
        LnUsuario lnUsuario = null;
        String code = usuStCodigo;
        
        if (usuStCodigo != null){
            if (mapUsuario.containsKey(code)){
                return mapUsuario.get(code);
            } else {
                lnUsuario = UsuarioDao.grabUsuario(usuStCodigo, 'S');
                
                if (lnUsuario != null){
                    mapUsuario.put(code, lnUsuario);
                    return lnUsuario;
                }
            }
        }
        return lnUsuario;
    }
    
    public synchronized static LnCliente grabCliente(Integer cliInCodigo){
        LnCliente lnCliente = null;
        String code = cliInCodigo.toString();
        
        if (cliInCodigo != null){
            if (mapCliente.containsKey(code)){
                lnCliente = mapCliente.get(code);
            } else {
                lnCliente = ClienteDao.grabClienteCodigo(cliInCodigo);
                if (lnCliente != null){
                    mapCliente.put(code, lnCliente);
                }
            }
        }
        
        return lnCliente;
    }
    
    public synchronized static void updateUsuario(LnUsuario lnUsuario){
        String code = lnUsuario.getUsuStCodigo();
        mapUsuario.put(code, lnUsuario);
    }
    
    public synchronized static void deleteUsuario(LnUsuario lnUsuario){
        String code = lnUsuario.getUsuStCodigo();
        mapUsuario.remove(code,lnUsuario);
    }
    
    public synchronized static LnPerfil grabPerfil(Integer perInCodigo,String strDbName){
        mapPerfil.clear();
        LnPerfil lnPerfil = null;
        String code = perInCodigo.toString()+strDbName;
        
        if(perInCodigo != null){
            if(mapPerfil.containsKey(code)){
                return mapPerfil.get(code);
            } else {
                lnPerfil = PerfilDao.grabPerfil(perInCodigo, 'S');
                
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
    
    public synchronized static void excluiPerfil(LnPerfil lnPerfil, String strDbName){
        String code = lnPerfil.getPerInCodigo().toString()+strDbName;
        mapPerfil.remove(code);
    }
    
    public synchronized static List<LnPerfilacesso> grabListPerfilAcesso(Integer perInCodigo, String strDbName){
        List<LnPerfilacesso> listPerfilAcesso = null;
        mapListPerfilAcesso.clear();
        
        String code = perInCodigo.toString()+strDbName;
        
        if(perInCodigo != null){
            if (mapListPerfilAcesso.containsKey(code)){
                return mapListPerfilAcesso.get(code);
            } else {
                listPerfilAcesso = PerfilDao.grabPerfilAcessoperInCodigo(perInCodigo);
                
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
        List<LnMenu> listMenu = MenuDao.grabMenu('S');
        String code = VarComuns.strDbName;
        mapMenu.put(code, listMenu);
    }
    
    public synchronized static List<LnMenu> grabMenu(String strDbName){
        List<LnMenu> listMenu = null;
        mapMenu.clear();
        if(mapMenu.containsKey(strDbName)){
            return mapMenu.get(strDbName);
        } else {
            listMenu = MenuDao.grabMenu('S');
            mapMenu.put(strDbName, listMenu);
        }
        return listMenu;
    }
    
    public synchronized static LnPerfilacesso grabPerfilAcesso(Integer perInCodigo, Integer modInCodigo){
        mapPerfilAcesso.clear();
        LnPerfilacesso lnPerfilacesso = null;
        String code = perInCodigo.toString()+modInCodigo.toString()+VarComuns.strDbName;
        
        if(mapPerfilAcesso.containsKey(code)){
            return mapPerfilAcesso.get(code);
        }else {
            lnPerfilacesso = PerfilDao.grabPerfilAcesso(perInCodigo, modInCodigo);
            mapPerfilAcesso.put(code, lnPerfilacesso);
            return lnPerfilacesso;
        }
    }
    
    public synchronized static LnTipoconta grabTipoConta(Integer tipInCodigo){
        
        LnTipoconta lnTipoconta = null;
        String code = tipInCodigo.toString();
        
        if (mapTipoConta.containsKey(code)){
            return mapTipoConta.get(code);
        } else {
            lnTipoconta = TipoContaDao.grabTipoConta(tipInCodigo);
            mapTipoConta.put(code, lnTipoconta);
            return lnTipoconta;
        }
    }
}
