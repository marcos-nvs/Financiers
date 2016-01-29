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
import br.com.ln.tipos.TipoEndereco;
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
    private Endereco enderecoObj;

    private String cep;
    private String endereco;
    private TipoEndereco tipoEndereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    private String mensagem;
    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public EnderecoView() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.enderecoObj);
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
        if (!Objects.equals(this.enderecoObj, other.enderecoObj)) {
            return false;
        }
        return true;
    }

    public void btPesquisaCEP() {
        try {
            if (ApprovalConnection.getConnectionApproval("http://correiosapi.apphb.com")) {
                if (cep != null) {
                    EnderecoCep enderecoCep;
                    Correios correio = new Correios();
                    enderecoCep = correio.entregaEndereco(cep.replaceAll("-", ""));
                    correio.close();
                    if (enderecoCep != null) {
                        endereco = enderecoCep.getTipoDeLogradouro() + " " + enderecoCep.getLogradouro();
                        bairro = enderecoCep.getBairro();
                        cidade = enderecoCep.getCidade();
                        estado = enderecoCep.getEstado();
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
    
    public Endereco grabEnderecoObj(){

        enderecoObj = new Endereco();
        enderecoObj.setBairro(bairro);
        enderecoObj.setCep(cep);
        enderecoObj.setCidade(cidade);
        enderecoObj.setComplemento(complemento);
        enderecoObj.setEndereco(endereco);
        enderecoObj.setEstado(estado);
        enderecoObj.setTipoEndereco(tipoEndereco);
        
        return enderecoObj;
    }
}
