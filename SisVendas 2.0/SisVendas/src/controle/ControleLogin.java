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
import modelo.ModeloLogin;

/**
 *
 * @author cyro
 */
public class ControleLogin {
    
    ConectaBanco conecta = new ConectaBanco();
    
    public void LogarSistema(ModeloLogin mod){
    
        conecta.conexao();
        
        try {
            conecta.executaSQL("SELECT * FROM user WHERE user ='"+mod.getUser()+"' AND pass='"+mod.getPass()+"'");
            conecta.rs.first();
            conecta.rs.getString("user");
            conecta.rs.getString("pass");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Selecionar Usuário"+ ex);
        }
        
        
    }
    
    public void CadastrarUsuario(ModeloLogin mod){
        
        try {
            conecta.conexao();
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO users (user, pass,level,tipo)VALUES(?,?,?,?)");
           
            pst.setString(1, mod.getUser());
            pst.setString(2, mod.getPass());
            if(mod.getTipo().equals("Gerente")){
            pst.setInt(3, 1);
            }else if(mod.getTipo().equals("Vendedor")){
            
            pst.setInt(3, 2);
            }
            pst.setString(4, mod.getTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Usuario Cadatrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO!"+ex);
        }
        
    }
    
}
