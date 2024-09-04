/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloParcelamentoCartao;
import modelo.ModeloParcelamentoVenda;

/**
 *
 * @author cyro
 */
public class ControleParcelamentoCartao {
    int codCliente;
        ConectaBanco conecta = new ConectaBanco();
        ConectaBanco c = new ConectaBanco();
        
    
        public void SalvaParcela(ModeloParcelamentoCartao mod){
       
        conecta.conexao();
        
            try {
                if(mod.getTipoPagamento().equals("Credito")){
                PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO parcela_cartao (cod_venda, valor_venda,valor_total, numero_parcela, valor_parc, datavenc,estado, bandeira,tipo_pagamento,datavenda)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, mod.getCodVenda());
                pst.setFloat(2, mod.getValor_venda());
                pst.setFloat(3, mod.getValor_total());
                //pst.setFloat(4, mod.getEntrada());
                pst.setInt(4, mod.getNumParc());                
                pst.setFloat(5, mod.getValorParcela());             
                pst.setDate(6, new java.sql.Date(mod.getDataVenc().getTime()));
                pst.setString(7, "NAO");
                pst.setString(8, mod.getBandeira());
                pst.setString(9, mod.getTipoPagamento());
                pst.setDate(10, new java.sql.Date(System.currentTimeMillis()));
                
                pst.execute();
                }else{
                c.conexao();
                PreparedStatement ps = c.conn.prepareStatement("INSERT INTO tbl_cartao_debito (id_caixa,valor_venda,valor_total,id_venda,data_venda,pagamento,bandeira,status)VALUES(?,?,?,?,?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setFloat(2, mod.getValor_venda());
                ps.setFloat(3, mod.getValor_total());
                ps.setInt(4, mod.getCodVenda());
                ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                ps.setString(6, mod.getTipoPagamento());
                ps.setString(7,mod.getBandeira());
                ps.setString(8, "AGUARDANDO");
                
                ps.execute();
                
                c.desconecta();
                conecta.desconecta();
                }
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao Registrar venda Parcelada"+ e);
            }
            
            conecta.desconecta();
        
    }
        
        public void achaBairro(String cliente){
        
        
        try {
            conecta.conexao();
            conecta.executaSQL("SELECT * FROM clientes WHERE nome_cliente = '"+cliente+"'");
            conecta.rs.first();
            codCliente = conecta.rs.getInt("id_cliente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar id do cliente"+ex);
        }
        
    }
   
}
