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


/**
 *
 * @author cyro
 */
public class ControleEntrada {
    
        ConectaBanco conecta = new ConectaBanco();
        ModeloEntrada mod = new ModeloEntrada();
        
        
    
        public void SalvaEntrada(ModeloEntrada mod){
       
        conecta.conexao();
        
            try {
                
               
                
                
                PreparedStatement ps = conecta.conn.prepareStatement("INSERT INTO tbl_entrada (id_caixa, id_venda, data_venda, valor_entrada, tipo_pagamento)VALUES(?,?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setInt(2, mod.getIdVenda());
                ps.setString(3, mod.getDataVenda());
                ps.setFloat(4, mod.getEntrada());
                ps.setString(5, "Dinheiro");
                
                ps.execute();
                JOptionPane.showMessageDialog(null,"Entrada Cadastrada com Sucesso");
               
               
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao Registrar Entrada"+ e);
            }
            
            conecta.desconecta();
        
    }
        
       
}
