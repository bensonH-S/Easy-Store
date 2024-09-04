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

import modelo.ModeloRegistrarDespesa;
/**
 *
 * @author cyro
 */
public class ControleRegistrarDespesa {
    
    ConectaBanco conectaCidade = new ConectaBanco();
    
    public void inserirRegistroDespesa(ModeloRegistrarDespesa mod){
        
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("INSERT INTO tbl_registrar_despesa(descricao, tipo, valor, data, id_caixa) VALUES(?,?,?,?,?)");
            pst.setString(1,mod.getDescricao());
            pst.setString(2, mod.getTipo());
            pst.setFloat(3, mod.getValor());
            pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            pst.setInt(5, mod.getIdcaixa());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        
        
       
        
    }
    
    public void ExcluirDespesa(ModeloRegistrarDespesa mod){
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("DELETE FROM despesas WHERE id_despesa = ?");
            
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados"+ ex);
        }
        
      
    } 
    
}


