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
import modelo.ModeloEntrada;
import modelo.ModeloSaida;


/**
 *
 * @author cyro
 */
public class ControleEntradaCompra {
    
        ConectaBanco conecta = new ConectaBanco();
        ModeloSaida mod = new ModeloSaida();
        
        
    
        public void SalvaEntrada(ModeloSaida mod){
       
        conecta.conexao();
        
            try {
                
               
                
                
                PreparedStatement ps = conecta.conn.prepareStatement("INSERT INTO tbl_saida (id_caixa, id_compra, data_compra, valor_saida, tipo_pagamento)VALUES(?,?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setInt(2, mod.getIdCompra());
                ps.setString(3, mod.getDataCompra());
                ps.setFloat(4, mod.getSaida());
                ps.setString(5, "Dinheiro");
                
                ps.execute();
                JOptionPane.showMessageDialog(null,"Saida de "+mod.getSaida()+" Registrada com Sucesso");
               
               
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao Registrar Saida"+ e);
            }
            
            conecta.desconecta();
        
    }
        
       
}
