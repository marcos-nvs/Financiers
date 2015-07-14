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
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class ClienteFuncoes {
    
    public String mensagem;
    private boolean validado;
    private Historico historico;

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

    public boolean validacao(LnCliente lnCliente, List<LnEndereco> listEndereco, List<LnTelefone> listTelefone) {

        mensagem = "";
        validado = true;
        
        if (lnCliente != null) {
            if (lnCliente.getCliStDocumento() != null && !lnCliente.getCliStDocumento().isEmpty()) {
                if (!Utilitarios.calculaCPF(lnCliente.getCliStDocumento())) {
                    mensagem = mensagem + "CPF invalido,";
                } else {
                    LnCliente lnClienteCpf = ClienteDao.grabClienteCpf(lnCliente.getCliStDocumento());
                    if (lnClienteCpf != null) {
                        mensagem = "Cliente ja cadastrado!";
                        return false;
                    }
                }
            } else {
                mensagem = mensagem + "Preencher o CPF!,";
            }

            if (lnCliente.getCliStNome() != null && lnCliente.getCliStNome().isEmpty()) {
                mensagem = mensagem + "Preencher o Nome,";
            }

            if (lnCliente.getCliStBanco() != null && lnCliente.getCliStBanco().isEmpty()) {
                mensagem = mensagem + "Preencher a identificacao do sistema,";
            }
            if (lnCliente.getCliStEmail() != null && lnCliente.getCliStEmail().isEmpty()) {
                mensagem = mensagem + "Preencher o e-mail";
            }

            if (listEndereco.size() == 0 && listEndereco.isEmpty()) {
                mensagem = mensagem + "Preencher um endereco";
            }

            if (listTelefone.size() == 0 && listTelefone.isEmpty()) {
                mensagem = mensagem + "Preencher um telefone";
            }

        } else {
            mensagem = "Por favor, preencher todos os campos.";
        }

        if (!mensagem.equals("")) {
            validado = false;
        }
        return validado;
    }

    private void incluirCliente(LnCliente lnCliente, List<LnEndereco> listEndereco, List<LnTelefone> listTelefone) {

        if (lnCliente != null) {
            ClienteDao.saveObject(lnCliente);
            historico.gravaHistorico("Web", "Inclusao do Cliente : " + lnCliente.getCliStNome());

            for (LnEndereco lnEndereco : listEndereco) {
                lnEndereco.setCliInCodigo(lnCliente.getCliInCodigo());
                ClienteDao.saveObject(lnEndereco);
                historico.gravaHistorico("Web", "Inclusso do Endereco do Cliente: " + lnCliente.getCliStNome());
            }

            for (LnTelefone lnTelefone : listTelefone) {
                lnTelefone.setCliInCodigo(lnCliente.getCliInCodigo());
                ClienteDao.saveObject(lnTelefone);
                historico.gravaHistorico("Web", "Inclusao do Telefone do Cliente: " + lnCliente.getCliStNome());
            }

            mensagem = "Sucesso";
        } else {
            mensagem = "Inicie o cadastro novamente, ocorreu um erro!!!";
        }
    }

}
