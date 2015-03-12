/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class JsfHelper {
    
    public static ExternalContext getExternalContext(){
        FacesContext externalcontext = FacesContext.getCurrentInstance();
        return externalcontext.getExternalContext();
    }
   
    public static String getRequestParameter(String parameterName){
        Map paramMap = getExternalContext().getRequestParameterMap();
        return (String) paramMap.get(parameterName);
    }
 
    public static Object getRequestAttribute(String attributeName){
        Map attributeMap = getExternalContext().getRequestMap();
        return attributeMap.get(attributeName);
    }
   
    public static Object getSessionAttribute(String attributeName){
        Map attributeMap = getExternalContext().getSessionMap();
        return attributeMap.get(attributeName);
    }
   
    public static Object getApplicationAttribute(String attributeName){
        Map attributeMap = getExternalContext().getApplicationMap();
        return attributeMap.get(attributeName);
    }
}