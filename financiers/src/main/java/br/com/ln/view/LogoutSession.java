/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.view;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Marcos Naves
 */

@ViewScoped
@ManagedBean(name = "logout")
public class LogoutSession implements Serializable{
    
    private String logout;
    Logger logger = Logger.getLogger(LogoutSession.class);

    public LogoutSession() {
    }

    public String getLogout() {
        
        FacesContext externalcontext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) externalcontext.getExternalContext().getSession(false);
        try{
            externalcontext.getExternalContext().redirect("/financiers");
            invalidateSession(session);        
            
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            
        } finally{
            
        }
        
        
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
    
    public void invalidateSession(HttpSession session) {
        java.util.Enumeration attrs = session.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = (String) attrs.nextElement();
            session.removeAttribute(attr);
        }
    }
    
}
