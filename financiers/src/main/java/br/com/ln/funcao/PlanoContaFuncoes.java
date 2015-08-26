/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.funcao;

import br.com.ln.dao.PlanoContaDao;
import br.com.ln.entity.LnAgendaconta;
import br.com.ln.entity.LnContadependente;
import br.com.ln.entity.LnPlanoconta;
import br.com.ln.objeto.AgendaConta;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.ContaDependente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Naves
 */
public class PlanoContaFuncoes implements Serializable {

    public List<Conta> buscaListaContas(){
        
        Conta conta;
        List<Conta> listaContas = null;
        List<LnPlanoconta> listaPlanoContas = PlanoContaDao.grabListObject(LnPlanoconta.class);
        
        if (listaContas != null){
            for (LnPlanoconta lnPlanoConta : listaPlanoContas) {
                conta = new Conta();
                conta.setAgendar(lnPlanoConta.getCtaChAgenda());
                conta.setAtivo(lnPlanoConta.getCtaChAtivo());
                conta.setCalculada(lnPlanoConta.getCtaChCalculada());
                conta.setIdCategoria(lnPlanoConta.getCatInCodigo());
                conta.setIdConta(lnPlanoConta.getCtaInCodigo());
                conta.setIdTipoConta(lnPlanoConta.getTipInCodigo());
                conta.setImposto(lnPlanoConta.getCtaChImposto());
                conta.setLimite(lnPlanoConta.getCtaFlLimite());
                conta.setNomeConta(lnPlanoConta.getCtaStDescricao());
                conta.setPercentual(lnPlanoConta.getCtaFlPercentual());
                conta.setListaAgendamento(buscaAgendaConta(conta));
                conta.setListaContaDependente(buscaContasDependentes(conta));
                
                listaContas.add(conta);
            }
        }
        
        return listaContas;
    } 
    
    public List<ContaDependente> buscaContasDependentes(Conta conta){
    
        ContaDependente contaDependente;
        List<ContaDependente> listaContaDependente = new ArrayList<>();
        List<LnContadependente> listaLnContaDependente = PlanoContaDao.buscaListaContaDependente(conta);
        
        if (listaLnContaDependente != null){
            for (LnContadependente lnContaDependente : listaLnContaDependente) {
                contaDependente = new ContaDependente();
                contaDependente.setIdContaCalculada(lnContaDependente.getLnContadependentePK().getCtaInCalculada());
                contaDependente.setIdContaPrincipal(conta.getIdConta());
                contaDependente.setIdTabela(lnContaDependente.getTbtInCodigo());
                contaDependente.setOrdem(lnContaDependente.getCtdInOrdem());
                listaContaDependente.add(contaDependente);
            }
        }
        
        return listaContaDependente;
    }
    
    public List<AgendaConta> buscaAgendaConta(Conta conta){
        
        AgendaConta agendaConta;
        List<AgendaConta> listaAgendaConta = new ArrayList<>();
        List<LnAgendaconta> listaLnAgendaConta = PlanoContaDao.buscaListaAgendaConta(conta);
        
        if (listaLnAgendaConta != null){
            for (LnAgendaconta lnAgendaConta : listaLnAgendaConta) {
                agendaConta = new AgendaConta();
                agendaConta.setAtivo(lnAgendaConta.getActChAtivo());
                agendaConta.setAvisar(lnAgendaConta.getActChAviso());
                agendaConta.setDiaVencimento(lnAgendaConta.getActInDia());
                agendaConta.setDomingo(lnAgendaConta.getActChDomingo());
                agendaConta.setDtFinal(lnAgendaConta.getActDtFinal());
                agendaConta.setDtInicio(lnAgendaConta.getActDtInicio());
                agendaConta.setIdAgenda(lnAgendaConta.getActInCodigo());
                agendaConta.setIdContaAgendada(lnAgendaConta.getCtaInCodigo());
                agendaConta.setIdTipoAgenda(lnAgendaConta.getTpaInCodigo());
                agendaConta.setPorEmail(lnAgendaConta.getActChEmail());
                agendaConta.setQtdeRepeticao(lnAgendaConta.getActInQtde());
                agendaConta.setQuarta(lnAgendaConta.getActChQuarta());
                agendaConta.setQuinta(lnAgendaConta.getActChQuinta());
                agendaConta.setSabado(lnAgendaConta.getActChSabado());
                agendaConta.setSegunda(lnAgendaConta.getActChSegunda());
                agendaConta.setSexta(lnAgendaConta.getActChSexta());
                agendaConta.setTerca(lnAgendaConta.getActChTerca());
                        
                listaAgendaConta.add(agendaConta);
            }
        }
        
        return listaAgendaConta;
    }
    
}
