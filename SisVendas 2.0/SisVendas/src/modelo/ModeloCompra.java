/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author cyro
 */
public class ModeloCompra {
    
    private int idCompra;    
    private int idCaixa;
    private String Fornecedor;
    private int numeroNota;
    private Date dataEmissao;
    private float totalProdutos;
    private float descont;
    private float totalNota;
    private String nomeProduto;
    private int quantidade;    
    private String tipoPagamento;
    private String vendedor;
    private String status;
    private Float precoCompra;
    private Float precoVenda;
    private Float lucrovenda;
    private Float lucroesperado;
    
    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }
    public Float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Float precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    
    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
     public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the idFornecedor
     */
    public String getFornecedor() {
        return Fornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    /**
     * @return the numeroNota
     */
    public int getNumeroNota() {
        return numeroNota;
    }

    /**
     * @param numeroNota the numeroNota to set
     */
    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the totalProdutos
     */
    public float getTotalProdutos() {
        return totalProdutos;
    }

    /**
     * @param totalProdutos the totalProdutos to set
     */
    public void setTotalProdutos(float totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    /**
     * @return the descont
     */
    public float getDescont() {
        return descont;
    }

    /**
     * @param descont the descont to set
     */
    public void setDescont(float descont) {
        this.descont = descont;
    }

    /**
     * @return the totalNota
     */
    public float getTotalNota() {
        return totalNota;
    }

    /**
     * @param totalNota the totalNota to set
     */
    public void setTotalNota(float totalNota) {
        this.totalNota = totalNota;
    }

    /**
     * @return the tipoPagamento
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the lucrovenda
     */
    public Float getLucrovenda() {
        return lucrovenda;
    }

    /**
     * @param lucrovenda the lucrovenda to set
     */
    public void setLucrovenda(Float lucrovenda) {
        this.lucrovenda = lucrovenda;
    }

    /**
     * @return the lucroesperado
     */
    public Float getLucroesperado() {
        return lucroesperado;
    }

    /**
     * @param lucroesperado the lucroesperado to set
     */
    public void setLucroesperado(Float lucroesperado) {
        this.lucroesperado = lucroesperado;
    }

    
    
    
}
