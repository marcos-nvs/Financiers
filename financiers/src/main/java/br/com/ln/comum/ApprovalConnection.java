/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Naves
 */
public class ApprovalConnection {
    
    public static boolean getConnectionApproval(String url) throws ConnectException{
        boolean retorno = false;
        
        try {
            URL u = new URL(url);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            
            if (huc.getResponseCode() == 200){
                retorno = true;
            } else {
                retorno = false;
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ApprovalConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApprovalConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
