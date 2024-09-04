/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloChave;


public class ControleChave {
    ConectaBanco conecta = new ConectaBanco();
    ModeloChave mod = new ModeloChave();
    Date hoje = new Date();
    
    public void InserirChave(ModeloChave mod){
       
       conecta.conexao();
       
       try{
       PreparedStatement pst = conecta.conn.prepareStatement("UPDATE chaveacesso SET status = ? WHERE chave = ?");
       pst.setString(1, "USADA");
       pst.setString(2, mod.getChave());       
       pst.execute();
       JOptionPane.showMessageDialog(null, "Chave "+mod.getChave()+" cadatrada com sucesso");
       }catch(SQLException e){
           
           JOptionPane.showMessageDialog(null,"Erro ao conectar"+e);
           
       }
        
    }
    
}
