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
import modelo.ModeloBairros;
/**
 *
 * @author cyro
 */
public class ControleBairros {
    
    ConectaBanco conectaCidade = new ConectaBanco();
    
    public void inserirBairro(ModeloBairros modBairros){
        
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("INSERT INTO bairro(nome_bairro, id_cidade) VALUES(?,?)");
            pst.setString(1,modBairros.getNome());
            pst.setInt(2, modBairros.getCod_cidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        
        
       
        
    }
    
    public void ExcluirBairro(ModeloBairros mod){
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("DELETE FROM bairro WHERE id_bairro = ?");
            
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados"+ ex);
        }
        
      
    } 
    
}


