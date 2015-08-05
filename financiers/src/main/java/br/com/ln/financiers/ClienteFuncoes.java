/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.financiers;

import br.com.ln.comum.Historico;
import br.com.ln.comum.Utilitarios;
import br.com.ln.dao.ClienteDao;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
import br.com.ln.entity.LnUsuario;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
public class ClienteFuncoes {

    public String mensagem;
    private boolean validado;
    private Historico historico;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());

    public String cliente(LnCliente lnCliente, List<LnEndereco> listEndereco, List<LnTelefone> listTelefone) {

        mensagem = "";
        historico = new Historico();

        switch (lnCliente.getTipoFuncao()) {
            case Incluir:
                incluirCliente(lnCliente, listEndereco, listTelefone);
                break;
            case Alterar:
                break;
            case Excluir:
                break;
            case Pesquisar:
                break;
        }
        return mensagem;
    }

    public boolean validacao(LnUsuario lnUsuario, LnCliente lnCliente, List<LnEndereco> listEndereco, List<LnTelefone> listTelefone) {

        mensagem = bundle.getString("ln.mb.frase.preenchercampos") + ": ";
        validado = true;
        
        System.out.println("usuario :  " + lnUsuario.toString());
        System.out.println("Clilente : " + lnCliente.toString());
        
        if (lnUsuario != null){
            UsuarioFuncoes usuarioFuncoes = new UsuarioFuncoes();
            validado = usuarioFuncoes.verificaDadosUsuario(lnUsuario);
            mensagem = usuarioFuncoes.mensagem;
        }

        if (lnCliente != null) {
            if (lnCliente.getCliStDocumento() != null && !lnCliente.getCliStDocumento().isEmpty()) {
                if (!Utilitarios.calculaCPF(lnCliente.getCliStDocumento())) {
                    mensagem = mensagem + bundle.getString("ln.mb.frase.invalidocpf") + "; ";
                    validado = false;
                } else {
                    LnCliente lnClienteCpf = ClienteDao.grabClienteCpf(lnCliente.getCliStDocumento());
                    if (lnClienteCpf != null) {
                        mensagem = bundle.getString("ln.mb.frase.clientecadastrado");
                        return false;
                    }
                }
            } else {
                mensagem = mensagem + "CPF; ";
                validado = false;
            }

            if (lnCliente.getCliStNome() != null && lnCliente.getCliStNome().isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.nome") +  "; ";
                validado = false;
            }

            if (lnCliente.getCliStBanco() != null && lnCliente.getCliStBanco().isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.identificacaosistema") + "; ";
                validado = false;
            }
            if (lnCliente.getCliStEmail() != null && lnCliente.getCliStEmail().isEmpty()) {
                mensagem = mensagem + "E-Mail";
                validado = false;
            }

            if (listEndereco.size() == 0 && listEndereco.isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.endereco") +  "; ";
                validado = false;
            }

            if (listTelefone.size() == 0 && listTelefone.isEmpty()) {
                mensagem = mensagem + bundle.getString("ln.texto.telefone") +  "; ";
                validado = false;
            }

        } else {
            mensagem = bundle.getString("ln.mb.frase.preenchercampos");
            validado = false;
        }

        return validado;
    }

    private void incluirCliente(LnCliente lnCliente, List<LnEndereco> listEndereco, List<LnTelefone> listTelefone) {

        if (lnCliente != null) {
            ClienteDao.saveObject(lnCliente);
            historico.gravaHistorico("Web", bundle.getString("ln.mb.historico.inclusaocliente") + " " + lnCliente.getCliStNome());

            for (LnEndereco lnEndereco : listEndereco) {
                lnEndereco.setCliInCodigo(lnCliente.getCliInCodigo());
                ClienteDao.saveObject(lnEndereco);
                historico.gravaHistorico("Web", bundle.getString("ln.mb.historico.inclusaoendereco") + " " + lnCliente.getCliStNome());
            }

            for (LnTelefone lnTelefone : listTelefone) {
                lnTelefone.setCliInCodigo(lnCliente.getCliInCodigo());
                ClienteDao.saveObject(lnTelefone);
                historico.gravaHistorico("Web", bundle.getString("ln.mb.historico.inclusaotelefone") + " " + lnCliente.getCliStNome());
            }
            mensagem = bundle.getString("ln.mb.texto.sucesso");
        } else {
            mensagem = bundle.getString("ln.mb.frase.erro");
        }
    }

}
