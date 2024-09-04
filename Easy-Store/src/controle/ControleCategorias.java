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
import modelo.ModeloCategorias;
/**
 *
 * @author cyro
 */
public class ControleCategorias {
    
    ConectaBanco conectaCidade = new ConectaBanco();
    
    public void inserirCategoria(ModeloCategorias mod){
        
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("INSERT INTO categorias(nome_categoria) VALUES(?)");
            pst.setString(1,mod.getNome());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Armazenados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao armazenar Dados"+ ex);
        }
        
        
       
        
    }
    
    public void ExcluirCategoria(ModeloCategorias mod){
        
        conectaCidade.conexao();
        
        try {
            PreparedStatement pst = conectaCidade.conn.prepareStatement("DELETE FROM categorias WHERE id_categoria = ?");
            
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados"+ ex);
        }
        
      
    } 
    
}


