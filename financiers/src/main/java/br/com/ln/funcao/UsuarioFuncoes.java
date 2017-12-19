/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.tipos.TipoFuncao;
import br.com.ln.comum.Historico;
import br.com.ln.comum.Utilitarios;
import br.com.ln.dao.ClienteDao;
import br.com.ln.entity.LnUsuario;
import br.com.ln.dao.GenericDao;
import br.com.ln.dao.HistoricoDao;
import br.com.ln.dao.UsuarioDao;
import br.com.ln.entity.LnCliente;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Marcos Naves
 */
public class UsuarioFuncoes implements Serializable {

    public String mensagem;
    private Historico historico;
    private String cpf;

    private final FacesContext context = FacesContext.getCurrentInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
    Logger logger = Logger.getLogger(UsuarioFuncoes.class);

    public boolean gravaUsuario(LnUsuario lnUsuario) {
        mensagem = "";
        historico = new Historico();

        switch (lnUsuario.getTipoFuncao()) {
            case Incluir:
                return inclusaoUsuario(lnUsuario);
            case Alterar:
                return alteracaoUsuario(lnUsuario);
            case Excluir:
                return exclusaoUsuario(lnUsuario);
            case Pesquisar:
                break;
        }

        return true;
    }

    private boolean inclusaoUsuario(LnUsuario lnUsuario) {
        LnUsuario pUsuario = UsuarioDao.grabUsuario(lnUsuario.getUsuStCodigo());

        if (pUsuario != null) {
            mensagem = bundle.getString("ln.mb.frase.usuariocadastrado");
            return false;
        } else {
            if (lnUsuario.getUsuChExpirasenha().equals('S')) {
                lnUsuario.setUsuInDia(30);
                lnUsuario.setUsuDtExpiracao(GenericDao.grabDateFromDB());
            }
            lnUsuario.setUsuDtCadastro(GenericDao.grabDateFromDB());
            lnUsuario.setUsuChAdmin('N');
            UsuarioDao.saveObject(lnUsuario);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.inclusaousuario") + " " + lnUsuario.getUsuStCodigo()
                    + " - " + lnUsuario.getUsuStNome());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        }
    }

    public boolean verificaDadosUsuario(LnUsuario lnUsuario) {

        mensagem = bundle.getString("ln.mb.frase.preenchercampos");
        boolean validado = true;
        
        LnUsuario lnUsuCod = UsuarioDao.grabUsuario(lnUsuario.getUsuStCodigo());
        
        if (lnUsuCod != null && lnUsuario.getTipoFuncao().equals(TipoFuncao.Incluir)){
            validado = false;
            mensagem = mensagem + bundle.getString("ln.texto.usuexiste") + "; ";
        }
        
        if (lnUsuario.getUsuStNome() == null || lnUsuario.getUsuStNome().isEmpty()) {
            validado = false;
            mensagem = mensagem + bundle.getString("ln.texto.usuario") + "; ";
        }
        if (lnUsuario.getUsuStEmail() == null || lnUsuario.getUsuStEmail().isEmpty()) {
            validado = false;
            mensagem = mensagem + "E-mail; ";
        }

        if (lnUsuario.getTipoFuncao().equals(TipoFuncao.Incluir)) {
            if (lnUsuario.getUsuStCodigo() == null || lnUsuario.getUsuStCodigo().isEmpty()) {
                validado = false;
                mensagem = mensagem + bundle.getString("ln.texto.nome") + "; ";
            }
            if (lnUsuario.getUsuStSenha() == null || lnUsuario.getUsuStSenha().isEmpty()) {
                validado = false;
                mensagem = mensagem + bundle.getString("ln.texto.senha") + "; ";
            }
        }
        if (lnUsuario.getUsuStCpf() != null && lnUsuario.getUsuStCpf().equals("")) {
            if (!Utilitarios.calculaCPF(lnUsuario.getUsuStCpf())) {
                mensagem = mensagem + bundle.getString("ln.texto.documento") + "; ";
                validado = false;
            }

        } else {
            if (lnUsuario.getTipoFuncao().equals(TipoFuncao.Incluir)) {
                LnUsuario lnUsuCPF = UsuarioDao.grabUsuarioDocumento(lnUsuario.getUsuStCpf());

                if (lnUsuCPF != null) {
                    mensagem = mensagem + bundle.getString("ln.mb.frase.usuariocadastrado");
                    validado = false;
                }
            }
        }
        
        

        return validado;
    }

    private boolean alteracaoUsuario(LnUsuario lnUsuario) {
        LnUsuario pUsuario = UsuarioDao.grabUsuario(lnUsuario.getUsuStCodigo());
//        EjbMap.deleteUsuario(pUsuario);
        lnUsuario.setUsuStSenha(pUsuario.getUsuStSenha());
        UsuarioDao.saveOrUpdateObject(lnUsuario);
        historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.alteracaousuario") + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
        mensagem = bundle.getString("ln.mb.texto.sucesso");
        return true;
    }

    private boolean exclusaoUsuario(LnUsuario lnUsuario) {

        if (HistoricoDao.grabVerificaHistorico(lnUsuario.getUsuStCodigo())) {
            UsuarioDao.deleteObject(lnUsuario);
            historico.gravaHistoricoModulo(bundle.getString("ln.mb.historico.exclusaousuario") + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
            mensagem = bundle.getString("ln.mb.texto.sucesso");
            return true;
        } else {
            mensagem = bundle.getString("ln.texto.usuario") + " " + lnUsuario.getUsuStCodigo() + " " + bundle.getString("ln.mb.historico.naoexcluirusuario");
            return false;
        }
    }

    public Date calculaDataExpiracao(LnUsuario lnUsuario) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(GenericDao.grabDateFromDB());
        calendar.add(Calendar.DATE, lnUsuario.getUsuInDia());
        return calendar.getTime();

    }

    public boolean verificaExpiracaoSenha(LnUsuario lnUsuario) {

        if (lnUsuario.getUsuChExpirasenha().equals('S')) {

            Calendar hoje = Calendar.getInstance();
            hoje.setTime(GenericDao.grabDateFromDB());

            Calendar expira = Calendar.getInstance();
            expira.setTime(lnUsuario.getUsuDtExpiracao());

            return !hoje.getTime().after(expira.getTime());
        } else {
            return true;
        }
    }

}
