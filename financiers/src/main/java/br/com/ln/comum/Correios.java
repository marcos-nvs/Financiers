/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

/**
 *
 * @author Marcos Naves
 */
public class Correios {
    
    private WebResource webResoure;
    private Client client;
    
    private static final String URL = "http://correiosapi.apphb.com/cep/";

    public Correios() {
        ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResoure = client.resource(URL);
    }
    
    public String getConsultaEnderecoByCep(String cep){
        String sJson = webResoure.path(cep)
                .type(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .get(String.class);
        return sJson;
    }

    public EnderecoCep entregaEndereco(String cep) {
        EnderecoCep endereco = null;
        String sEnd = getConsultaEnderecoByCep(cep);
        Gson gson = new Gson();
        endereco = gson.fromJson(sEnd, EnderecoCep.class);
        close();
        return endereco;
    }
   
    public void close() {
        client.destroy();
    }
}
