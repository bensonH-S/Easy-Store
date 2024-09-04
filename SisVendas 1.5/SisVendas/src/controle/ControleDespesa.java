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

import modelo.ModeloDespesa;
/**
 *
 * @author cyro
 */
public class ControleDespesa {
    
    ConectaBanco conectaCidade = new ConectaBanco();
    
    public void inserirDespesa(ModeloDespesa mod){
        
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("INSERT INTO despesas(nome_despesa) VALUES(?)");
            pst.setString(1,mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        finally{
            
            conectaCidade.desconecta();
        }
        
       
        
    }
    
    public void ExcluirDespesa(ModeloDespesa mod){
        
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


