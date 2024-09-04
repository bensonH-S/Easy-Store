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
public class ModeloCaixa {
    
    private int idCaixa;
    private float saldoInciial;
    private float saldoFinal;
    private float totalCaixa;
    private Date data;
    private String dataFechamento;
    private String hora;
    private String horaFechar;
    private String status;

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
     * @return the saldoInciial
     */
    public float getSaldoInciial() {
        return saldoInciial;
    }

    /**
     * @param saldoInciial the saldoInciial to set
     */
    public void setSaldoInciial(float saldoInciial) {
        this.saldoInciial = saldoInciial;
    }

    /**
     * @return the saldoFinal
     */
    public float getSaldoFinal() {
        return saldoFinal;
    }

    /**
     * @param saldoFinal the saldoFinal to set
     */
    public void setSaldoFinal(float saldoFinal) {
        this.saldoFinal = saldoFinal;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the totalCaixa
     */
    public float getTotalCaixa() {
        return totalCaixa;
    }

    /**
     * @param totalCaixa the totalCaixa to set
     */
    public void setTotalCaixa(float totalCaixa) {
        this.totalCaixa = totalCaixa;
    }

    /**
     * @return the horaFechar
     */
    public String getHoraFechar() {
        return horaFechar;
    }

    /**
     * @param horaFechar the horaFechar to set
     */
    public void setHoraFechar(String horaFechar) {
        this.horaFechar = horaFechar;
    }

    /**
     * @return the dataFechamento
     */
    public String getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    
}
