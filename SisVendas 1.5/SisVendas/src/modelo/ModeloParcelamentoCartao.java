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
public class ModeloParcelamentoCartao {
    
    private int codVenda;
    private int numParc;
    private float valor_venda;
    private float valor_total;
    private float valorParcela;
    private Date dataVenc;
    private float entrada;
    private String bandeira;
    private String tipoPagamento;
    private Date datavenda;
    private int idCaixa;

    /**
     * @return the codVenda
     */
    public int getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    /**
     * @return the numParc
     */
    public int getNumParc() {
        return numParc;
    }

    /**
     * @param numParc the numParc to set
     */
    public void setNumParc(int numParc) {
        this.numParc = numParc;
    }

    /**
     * @return the valor_venda
     */
    public float getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    /**
     * @return the valor_total
     */
    public float getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the valorParcela
     */
    public float getValorParcela() {
        return valorParcela;
    }

    /**
     * @param valorParcela the valorParcela to set
     */
    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    /**
     * @return the dataVenc
     */
    public Date getDataVenc() {
        return dataVenc;
    }

    /**
     * @param dataVenc the dataVenc to set
     */
    public void setDataVenc(Date dataVenc) {
        this.dataVenc = dataVenc;
    }

    /**
     * @return the entrada
     */
    public float getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the bandeira
     */
    public String getBandeira() {
        return bandeira;
    }

    /**
     * @param bandeira the bandeira to set
     */
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    /**
     * @return the datavenda
     */
    public Date getDatavenda() {
        return datavenda;
    }

    /**
     * @param datavenda the datavenda to set
     */
    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    /**
     * @return the idCaixa
     */
    public int getIdCaixa() {
        return idCaixa;
    }

    /**
     * @param idCaixa the idCaixa to set
     */
    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
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

    
}
