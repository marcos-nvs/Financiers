/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.view;

import br.com.ln.comum.ApprovalConnection;
import br.com.ln.comum.Correios;
import br.com.ln.comum.EnderecoCep;
import br.com.ln.objeto.Endereco;
import java.io.Serializable;
import java.net.ConnectException;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "enderecoView")
public class EnderecoView implements Serializable {

    Logger logger = Logger.getLogger(ClienteView.class);
    private Endereco endereco;

    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public EnderecoView() {
        endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.endereco);
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
        final EnderecoView other = (EnderecoView) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    public void btPesquisaCEP() {
        try {
            if (ApprovalConnection.getConnectionApproval("http://correiosapi.apphb.com")) {
                if (endereco.getCep() != null) {
                    EnderecoCep enderecoCep;
                    Correios correio = new Correios();
                    enderecoCep = correio.entregaEndereco(endereco.getCep().replaceAll("-", ""));
                    correio.close();
                    if (enderecoCep != null) {
                        endereco.setEndereco(enderecoCep.getTipoDeLogradouro() + " " + enderecoCep.getLogradouro());
                        endereco.setBairro(enderecoCep.getBairro());
                        endereco.setCidade(enderecoCep.getCidade());
                        endereco.setEstado(enderecoCep.getEstado());
                    } else {
                        mensagem = "Cep não localizado!!!";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                bundle.getString("ln.mb.titulo.cliente"), mensagem));
                    }
                } else {
                    mensagem = "Cep em branco, por favor entre com o CEP!!!";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            bundle.getString("ln.mb.titulo.cliente"), mensagem));
                }
            } else {
                mensagem = "Não foi possível pesquisar o CEP, computador fora da internet ou site indisponível!!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("ln.mb.titulo.cliente"), mensagem));
            }
        } catch (ConnectException ex) {
            mensagem = "Não foi possível pesquisar o CEP, computador fora da internet ou site indisponível!!!!";
            logger.error(mensagem);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    bundle.getString("ln.mb.titulo.cliente"), mensagem));
        }

    }
}
