/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloCnae.ModeloCnae;
import modelo.ModeloDadosEmpresa;

/**
 *
 * @author cyro
 */
public class ControleDadosEmpresa {
    
    ConectaBanco conecta = new ConectaBanco();
    ModeloDadosEmpresa mod = new ModeloDadosEmpresa();
    
    public void cadastraDados(ModeloDadosEmpresa mod){
       conecta.conexao();
       
       try{
        PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO empresa(nome, nomefantasia, cnpj, ie, im, crt, cnae, ra, ibge, cidade, uf, cep, bairro, rua, telefone, email, cod_uf"
                    + ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNomefantasia());
            pst.setString(3, mod.getCnpj());
            pst.setString(4, mod.getIE());
            pst.setString(5, mod.getIM());
            pst.setString(6, mod.getCRT());
            pst.setString(7, mod.getCNAE());
            pst.setString(8, mod.getRA());
            pst.setInt(9, mod.getIBGE());
            pst.setString(10, mod.getCidade());
            pst.setString(11, mod.getUF());
            pst.setString(12, mod.getCEP());
            pst.setString(13, mod.getBairro());
            pst.setString(14, mod.getRua());
            pst.setString(15, mod.getTelefone());
            pst.setString(16, mod.getEmail());
            pst.setString(17, mod.getCod_UF());
            
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Empresa Cadastrada com Sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao Cadastradar empresa!" + e);
        }

    }
    public void AtualizarDados(ModeloDadosEmpresa mod){
        
        conecta.conexao();
        
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE empresa SET nome = ?, nomefantasia= ?,cnpj =?, ie=?,im=?,crt=?,cnae=?,ra=?,ibge=?,cidade=?,uf=?,cep=?,bairro=?,rua=?,telefone=?,email=?,cod_uf=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNomefantasia());
            pst.setString(3, mod.getCnpj());
            pst.setString(4, mod.getIE());
            pst.setString(5, mod.getIM());
            pst.setString(6, mod.getCRT());
            pst.setString(7, mod.getCNAE());
            pst.setString(8, mod.getRA());
            pst.setInt(9, mod.getIBGE());
            pst.setString(10, mod.getCidade());
            pst.setString(11, mod.getUF());
            pst.setString(12, mod.getCEP());
            pst.setString(13, mod.getBairro());
            pst.setString(14, mod.getRua());
            pst.setString(15, mod.getTelefone());
            pst.setString(16, mod.getEmail());
            pst.setString(17, mod.getCod_UF());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar Dados Da Emoresa"+ ex);
        }
        
        conecta.desconecta();
        
    }
    
    
        
    public ModeloCnae pesquisaCnae(ModeloCnae mod) {

        conecta.conexao();

        conecta.executaSQL("SELECT * FROM cnae WHERE cnae LIKE '%" + mod.getCnae()+ "%'");

        try {
            conecta.rs.first();
            mod.setCnae(conecta.rs.getString("cnae"));
            mod.setDescricao(conecta.rs.getString("descricao"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Cnae " + ex);
}
        conecta.desconecta();
        return mod;
    
    }
    
   
}
