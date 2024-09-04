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
import modelo.ModeloCidades;
/**
 *
 * @author cyro
 */
public class ControleCidade {
    
    ConectaBanco conectaCidade = new ConectaBanco();
    
    public void inserirCidade(ModeloCidades mod){
        
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("INSERT INTO cidade(nome_cidade, id_estado) VALUES(?,?)");
            pst.setString(1,mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        
        
       
        
    }
    
    public void ExcluirCidade(ModeloCidades mod){
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("DELETE FROM cidade WHERE id_cidade = ?");
            
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados"+ ex);
        }
        
      
    } 
    
}


