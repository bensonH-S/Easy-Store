/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConectaBanco {
    
   public Statement stm;
   public ResultSet rs;
   private String driver = "org.gjt.mm.mysql.Driver";
   private String caminho = "jdbc:mysql://localhost:3306/sistemavendas";
   private String usuario = "root";
   private String senha = "";
   public Connection conn;
   
   public void conexao(){
   
   
       try {
           System.setProperty("jdbc.Drivers", driver);
           conn = DriverManager.getConnection(caminho, usuario, senha);
           
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao Conectar com o banco de dados!");
       }
   
   
   }
   
   public void executaSQL(String sql){
       
       try {
           stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro de conexao" + ex.getMessage());
           
       }
   
   }
   
   public void desconecta(){
   
       try {
           conn.close();
           //JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
       } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao" + ex.getMessage());
       }
   
   }
   
   
}
