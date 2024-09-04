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
import modelo.ModeloTelefone;
/**
 *
 * @author cyro
 */
public class ControleTelefone {
    
    ConectaBanco conectaTelefone = new ConectaBanco();
    
    public void inserirTelefone(ModeloTelefone modTel){
        
        
        conectaTelefone.conexao();
        
        try {
            PreparedStatement pst = conectaTelefone.conn.prepareStatement("INSERT INTO telefone(numero_tel) VALUES(?)");
            pst.setString(1,modTel.getTel());            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        
        
       
        
    }
    
    /*public void ExcluirCidade(ModeloCidades mod){
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("DELETE FROM cidade WHERE id_cidade = ?");
            
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados"+ ex);
        }
        
      
    } */
    
}


