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
import modelo.ModeloCaixa;
import visao.FrmAbrirCaixa;

/**
 *
 * @author cyro
 */
public class ControleCaixa {
    
    ConectaBanco conecta = new ConectaBanco();
    ModeloCaixa mod = new ModeloCaixa();
    
    public void Cadastrar(ModeloCaixa mod){
        
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO caixa (saldo_inicial,data,hora, status)VALUES(?,?,?,?)");
            pst.setFloat(1, mod.getSaldoInciial());
            pst.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            pst.setString(3, mod.getHora());
            pst.setString(4, "aberto");
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Caixa Aberto");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro "+ ex);
        }
        
        
    }
    
    public void Atualizar(ModeloCaixa mod){
         conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE caixa SET total_caixa = ?,data_fechamento = ?, hora_fechamento = ?, saldo_final = ?, status = ? where id_caixa = ?");
            pst.setFloat(1, mod.getTotalCaixa());
            pst.setString(2, mod.getDataFechamento());
            pst.setString(3, mod.getHoraFechar());
            pst.setFloat(4,mod.getSaldoFinal());
            pst.setString(5, "fechado");
            pst.setInt(6, mod.getIdCaixa());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Caixa de numero "+mod.getIdCaixa()+" Fechado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Fechar Caixa"+ex);
        }
        
    }
    
}
