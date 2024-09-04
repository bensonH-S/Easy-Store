/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloParcelamentoVenda;

/**
 *
 * @author cyro
 */
public class ControleParcelamento {
    int codCliente;
        ConectaBanco conecta = new ConectaBanco();
        ConectaBanco c = new ConectaBanco();
        
    
        public void SalvaParcela(ModeloParcelamentoVenda mod){
       
        conecta.conexao();
        
            try {
                achaBairro(mod.getCliente());
                PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO parcela_venda (cod_venda, valor_venda,valor_total, numero_parcela, valor_parc, datavenc,estado, id_cliente, datavenda)VALUES(?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, mod.getCodVenda());
                pst.setFloat(2, mod.getValor_venda());
                pst.setFloat(3, mod.getValor_total());
                //pst.setFloat(4, mod.getEntrada());
                pst.setInt(4, mod.getNumParc());                
                pst.setFloat(5, mod.getValorParcela());             
                pst.setDate(6, new java.sql.Date(mod.getDataVenc().getTime()));
                pst.setString(7, "NAO");
                pst.setInt(8, codCliente);
                pst.setDate(9, new java.sql.Date(System.currentTimeMillis()));
                
                pst.execute();
                
                c.conexao();
                PreparedStatement ps = c.conn.prepareStatement("update venda set id_cliente = ? where id_venda="+mod.getCodVenda());
                ps.setInt(1, codCliente);
                ps.execute();
                
                c.desconecta();
                conecta.desconecta();
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao Registrar venda Parcelada"+ e);
            }
            
            conecta.desconecta();
        
    }
        
        public void achaBairro(String cliente){
        
        
        try {
            conecta.conexao();
            conecta.executaSQL("SELECT * FROM clientes WHERE nome_cliente = '"+cliente+"'");
            conecta.rs.first();
            codCliente = conecta.rs.getInt("id_cliente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar id do cliente"+ex);
        }
        
    }
   
}
