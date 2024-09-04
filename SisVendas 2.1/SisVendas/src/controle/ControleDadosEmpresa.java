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
import modelo.ModeloDadosEmpresa;

/**
 *
 * @author cyro
 */
public class ControleDadosEmpresa {
    
    ConectaBanco conecta = new ConectaBanco();
    ModeloDadosEmpresa mod = new ModeloDadosEmpresa();
    
    
    public void AtualizarDados(ModeloDadosEmpresa mod){
        
        conecta.conexao();
        
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE empresa SET nome = ?, nomefantasia = ?,cnpj =?, rua=? ,bairro=?, cidade=?, telefone=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNomefantasia());
            pst.setString(3, mod.getCnpj());
            pst.setString(4, mod.getRua());
            pst.setString(5, mod.getBairro());
            pst.setString(6, mod.getCidade());
            pst.setString(7, mod.getTelefone());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados Da Emoresa"+ ex);
        }
        
        conecta.desconecta();
        
    }
    
   
}
