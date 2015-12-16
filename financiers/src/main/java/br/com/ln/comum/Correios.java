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
import org.apache.log4j.Logger;

/**
 *
 * @author Marcos Naves
 */
public class Correios {

    private WebResource webResoure;
    private Client client;
    Logger logger = Logger.getLogger(Correios.class);

    private static final String URL = "http://correiosapi.apphb.com/cep/";

    public Correios() {
        try {
            ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
            client = Client.create(config);
            webResoure = client.resource(URL);
        } catch (Exception ex) {
            logger.error("Problemas de acesso ao site de endereço : " + ex.getMessage());
        }
    }

    public String getConsultaEnderecoByCep(String cep) {
        try {
            String sJson = webResoure.path(cep)
                    .type(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                    .get(String.class);
            return sJson;
        } catch (Exception ex) {
            logger.error("Problemas de acesso ao site de endereço : " + ex.getMessage());
            return null;
        }
    }

    public EnderecoCep entregaEndereco(String cep) {
        EnderecoCep endereco = null;
        String sEnd = getConsultaEnderecoByCep(cep);
        if (sEnd != null) {
            Gson gson = new Gson();
            endereco = gson.fromJson(sEnd, EnderecoCep.class);
            close();
        }
        return endereco;
    }

    public void close() {
        client.destroy();
    }
}
