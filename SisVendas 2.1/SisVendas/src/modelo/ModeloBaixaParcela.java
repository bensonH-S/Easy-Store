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
public class ModeloBaixaParcela {
    
    private int codParc;
    private String dataVenc;
    private int codVenda;
    private Float valor;
    private String NomeCliente;
    private float valor_parcial;
    private float valor_resta;
    private float pago;
    private Date dataatual;
    private int idCaixa;
   

    /**
     * @return the codParc
     */
    public int getCodParc() {
        return codParc;
    }

    /**
     * @param codParc the codParc to set
     */
    public void setCodParc(int codParc) {
        this.codParc = codParc;
    }

    /**
     * @return the dataVenc
     */
    public String getDataVenc() {
        return dataVenc;
    }

    /**
     * @param dataVenc the dataVenc to set
     */
    public void setDataVenc(String dataVenc) {
        this.dataVenc = dataVenc;
    }

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
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the NomeCliente
     */
    public String getNomeCliente() {
        return NomeCliente;
    }

    /**
     * @param NomeCliente the NomeCliente to set
     */
    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }
    
    public float getValor_parcial() {
        return valor_parcial;
    }

    /**
     * @param valor_parcial the valor_parcial to set
     */
    public void setValor_parcial(float valor_parcial) {
        this.valor_parcial = valor_parcial;
    }

    /**
     * @return the valor_resta
     */
    public float getValor_resta() {
        return valor_resta;
    }

    /**
     * @param valor_resta the valor_resta to set
     */
    public void setValor_resta(float valor_resta) {
        this.valor_resta = valor_resta;
    }

    /**
     * @return the dataatual
     */
    public Date getDataatual() {
        return dataatual;
    }

    /**
     * @param dataatual the dataatual to set
     */
    public void setDataatual(Date dataatual) {
        this.dataatual = dataatual;
    }

    /**
     * @return the pago
     */
    public float getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(float pago) {
        this.pago = pago;
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

    
}
