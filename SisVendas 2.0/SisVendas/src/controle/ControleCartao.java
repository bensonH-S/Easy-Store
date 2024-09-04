/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCartao;
import modelo.ModeloEntrada;


/**
 *
 * @author cyro
 */
public class ControleCartao {
    
        ConectaBanco conecta = new ConectaBanco();
        ModeloCartao mod = new ModeloCartao();
        
        
    
        public void SalvaCartao(ModeloCartao mod){
       
        conecta.conexao();
        
            try {
                
               
                
                
                PreparedStatement ps = conecta.conn.prepareStatement("INSERT INTO tbl_cartao (id_caixa, id_venda, entrada_cartao, parcelas, tipo_cartao, total_venda, data_venda,tipo_pagamento)VALUES(?,?,?,?,?,?,?,?)");
                ps.setInt(1, mod.getIdcaixa());
                ps.setInt(2, mod.getIdvenda());
                ps.setFloat(3, mod.getEntrada());
                ps.setFloat(4, mod.getParcelas());
                ps.setString(5, mod.getTipo());
                ps.setFloat(6, mod.getTotal());
                ps.setString(7, mod.getData());
                
                ps.setString(8, "Cartao");
                
                ps.execute();
                JOptionPane.showMessageDialog(null,"Abrir Formulário para Finalizar");
               
               
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao Registrar Entrada"+ e);
            }finally{
            
             conecta.desconecta();
            
            }
        
    }
        
       
}
