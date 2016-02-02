/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package br.com.ln.view;

import br.com.ln.entity.LnFavorecido;
import br.com.ln.funcao.FavorecidoFuncoes;
import br.com.ln.funcao.PlanoContaFuncoes;
import br.com.ln.objeto.Conta;
import br.com.ln.objeto.Emprestimo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "emprestimoView")
public class EmprestimoView implements Serializable {
    
    private Date dataEmprestimo;
    private Integer idFavorecido;
    private LnFavorecido favorecido;
    private Integer contaPagamento;
    private Integer contaDestino;
    private Double valorEmprestimo;
    private Integer prazoEmprestimo;
    private Double valorParcelas;
    private Double jurosMensais;
    private Double valorTotal;
    private Double jurosAnuais;
    private Double jurosEfetivos;
    private Date dataVencimento;
    private boolean simulado;
    
    private List<LnFavorecido> listaFavorecido;
    private List<Conta> listaContaDestino;
    private List<Conta> listaContaOrigem;

    private FavorecidoFuncoes favorecidoFuncoes;
    private final PlanoContaFuncoes planoContaFuncoes;

    public EmprestimoView() {
        favorecidoFuncoes = new FavorecidoFuncoes();
        planoContaFuncoes = new PlanoContaFuncoes();

        listaFavorecido = favorecidoFuncoes.grabListaFavorecidoAtivo();
        
        System.out.println("Lista Favorecido " + listaFavorecido.toString());
        
        
        listaContaDestino = planoContaFuncoes.montaConta();
        listaContaOrigem = planoContaFuncoes.montaConta();
        
        favorecido = new LnFavorecido();
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Integer getIdFavorecido() {
        return idFavorecido;
    }

    public void setIdFavorecido(Integer idFavorecido) {
        this.idFavorecido = idFavorecido;
    }
    
    public LnFavorecido getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(LnFavorecido favorecido) {
        this.favorecido = favorecido;
    }

    public Integer getContaPagamento() {
        return contaPagamento;
    }

    public void setContaPagamento(Integer contaPagamento) {
        this.contaPagamento = contaPagamento;
    }

    public Integer getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Integer getPrazoEmprestimo() {
        return prazoEmprestimo;
    }

    public void setPrazoEmprestimo(Integer prazoEmprestimo) {
        this.prazoEmprestimo = prazoEmprestimo;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Double getJurosMensais() {
        return jurosMensais;
    }

    public void setJurosMensais(Double jurosMensais) {
        this.jurosMensais = jurosMensais;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getJurosAnuais() {
        return jurosAnuais;
    }

    public void setJurosAnuais(Double jurosAnuais) {
        this.jurosAnuais = jurosAnuais;
    }

    public Double getJurosEfetivos() {
        return jurosEfetivos;
    }

    public void setJurosEfetivos(Double jurosEfetivos) {
        this.jurosEfetivos = jurosEfetivos;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


    public boolean isSimulado() {
        return simulado;
    }

    public void setSimulado(boolean simulado) {
        this.simulado = simulado;
    }

    public List<LnFavorecido> getListaFavorecido() {
        return listaFavorecido;
    }

    public void setListaFavorecido(List<LnFavorecido> listaFavorecido) {
        this.listaFavorecido = listaFavorecido;
    }

    public List<Conta> getListaContaDestino() {
        return listaContaDestino;
    }

    public void setListaContaDestino(List<Conta> listaContaDestino) {
        this.listaContaDestino = listaContaDestino;
    }

    public List<Conta> getListaContaOrigem() {
        return listaContaOrigem;
    }

    public void setListaContaOrigem(List<Conta> listaContaOrigem) {
        this.listaContaOrigem = listaContaOrigem;
    }

    public FavorecidoFuncoes getFavorecidoFuncoes() {
        return favorecidoFuncoes;
    }

    public void setFavorecidoFuncoes(FavorecidoFuncoes favorecidoFuncoes) {
        this.favorecidoFuncoes = favorecidoFuncoes;
    }

    @Override
    public String toString() {
        return "EmprestimoView{" + "dataEmprestimo=" + dataEmprestimo + ", favorecido=" + favorecido + ", contaPagamento=" + contaPagamento + ", contaDestino=" + contaDestino + ", valorEmprestimo=" + valorEmprestimo + ", prazoEmprestimo=" + prazoEmprestimo + ", valorParcelas=" + valorParcelas + ", jurosMensais=" + jurosMensais + ", valorTotal=" + valorTotal + ", jurosAnuais=" + jurosAnuais + ", jurosEfetivos=" + jurosEfetivos + ", dataVencimento=" + dataVencimento + ", simulado=" + simulado + ", listaFavorecido=" + listaFavorecido + ", listaContaDestino=" + listaContaDestino + ", listaContaOrigem=" + listaContaOrigem + ", favorecidoFuncoes=" + favorecidoFuncoes + ", planoContaFuncoes=" + planoContaFuncoes + '}';
    }



    public Emprestimo grabEmprestimo(){
        
        Emprestimo emprestimo = new Emprestimo();
        
        emprestimo.setContaDestino(contaDestino);
        emprestimo.setContaPagamento(contaPagamento);
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataVencimento(dataVencimento);
        
        favorecido = favorecidoFuncoes.grabFavorecido(idFavorecido);
        
        emprestimo.setFavorecido(favorecido);
        emprestimo.setJurosAnuais(jurosAnuais);
        emprestimo.setJurosEfetivos(jurosEfetivos);
        emprestimo.setJurosMensais(jurosMensais);
        emprestimo.setPrazoEmprestimo(prazoEmprestimo);
        emprestimo.setSimulado(simulado);
        emprestimo.setValorEmprestimo(valorEmprestimo);
        emprestimo.setValorParcelas(valorParcelas);
        emprestimo.setValorTotal(valorTotal);
        
        return emprestimo;
    }
    
}
