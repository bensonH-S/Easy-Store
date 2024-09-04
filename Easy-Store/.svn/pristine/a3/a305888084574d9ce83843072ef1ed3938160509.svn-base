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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.ModeloFornecedor;

/**
 *
 * @author cyro
 */
public class ControleFornecedor {
    
    ConectaBanco conecta = new ConectaBanco();
    ModeloFornecedor mod = new ModeloFornecedor();
    int codBairro;
    public void Salvar(ModeloFornecedor mod){
        conecta.conexao();
        
        try {
            
            PreparedStatement pst = conecta.conn.prepareStatement("insert into fornecedor (nome_fornecedor, endereco_fornecedor, bairro, cidade, estado, cnpj, telefone,celular, email,nomefantasia,ie)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getBairro());
            pst.setString(4, mod.getCidade());
            pst.setString(5, mod.getEstado());
            pst.setString(6, mod.getCnpj());
            pst.setString(7, mod.getTelefone());
            pst.setString(8, mod.getCelular());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getNomeFantasia());
            pst.setString(11, mod.getIe());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados Inseridos com Sucesso");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Foencedor"+ ex);
        }
        
    }
    
    public void Excluir(ModeloFornecedor mod){
        conecta.conexao();
        try {
            
            PreparedStatement pst = conecta.conn.prepareStatement("DELETE FROM fornecedor WHERE id_fornecedor = ?"); //'"+mod.getId()+ "'");
            pst.setInt(1,mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluidos com Sucesso");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro ao excluir os Dados"+ e);
        }
        
    }
    
    public void Alterar(ModeloFornecedor mod){
            conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE fornecedor set nome_fornecedor=?, endereco_fornecedor=?, bairro=?, cidade=?, estado=?, cnpj=?, telefone=?, celular=?, email =?, nomefantasia=?,ie=? WHERE id_fornecedor = ?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEndereco());
            pst.setString(3, mod.getBairro());
            pst.setString(4, mod.getCidade());
            pst.setString(5, mod.getEstado());
            pst.setString(6, mod.getCnpj());
            pst.setString(7, mod.getTelefone());
            pst.setString(8, mod.getCelular());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getNomeFantasia());
            pst.setString(11, mod.getIe());
            pst.setInt(12, mod.getId());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados Alterados com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Inserir os Dados"+ ex);
        }
        conecta.desconecta();
        
    }
    
    public void achaBairro(String bairro){
        
        
        try {
            conecta.conexao();
            conecta.executaSQL("SELECT * FROM bairro WHERE nome_bairro = '"+bairro+"'");
            conecta.rs.first();
            codBairro = conecta.rs.getInt("id_bairro");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ModeloFornecedor Primeiro(){
        
        
        
        try {
            conecta.conexao();
            conecta.executaSQL("SELECT * FROM fornecedor inner join bairro on fornecedor.id_bairro = bairro.id_bairro inner join cidade on bairro.id_cidade = cidade.id_cidade inner join estados on cidade.id_estado = estados.id_estado");
            conecta.rs.first();
            mod.setId(conecta.rs.getInt("id_fornecedor"));
            mod.setNome(conecta.rs.getString("nome_fornecedor"));
            mod.setEndereco(conecta.rs.getString("endereco_fornecedor"));
            mod.setBairro(conecta.rs.getString("nome_bairro"));
            mod.setCnpj(conecta.rs.getString("cnpj"));
            mod.setCidade(conecta.rs.getString("id_cidade"));
            mod.setEstado(conecta.rs.getString("id_estado"));
            mod.setCelular(conecta.rs.getString("celular"));
            mod.setIe(conecta.rs.getString("ie"));
            mod.setEmail(conecta.rs.getString("email"));
            mod.setNomeFantasia(conecta.rs.getString("nomefantasia"));
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERRO ao Buscar "+ e);
        }
        
        
        return mod;
    }
    
    public ModeloFornecedor Ultimo(){
        
        
        
        try {
            conecta.conexao();
            conecta.executaSQL("SELECT * FROM fornecedor inner join bairro on fornecedor.id_bairro = bairro.id_bairro inner join cidade on bairro.id_cidade = cidade.id_cidade inner join estados on cidade.id_estado = estados.id_estado");
            conecta.rs.last();
            mod.setId(conecta.rs.getInt("id_fornecedor"));
            mod.setNome(conecta.rs.getString("nome_fornecedor"));
            mod.setEndereco(conecta.rs.getString("endereco_fornecedor"));
            mod.setBairro(conecta.rs.getString("nome_bairro"));
            mod.setCnpj(conecta.rs.getString("cnpj"));
            mod.setCidade(conecta.rs.getString("nome_cidade"));
            mod.setEstado(conecta.rs.getString("nome_estado"));
            mod.setCelular(conecta.rs.getString("celular"));
            mod.setIe(conecta.rs.getString("ie"));
            mod.setEmail(conecta.rs.getString("email"));
            mod.setNomeFantasia(conecta.rs.getString("nomefantasia"));
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERRO ao Buscar "+ e);
        }
        
        
        return mod;
    }
    
    public ModeloFornecedor Proximo(){
        
            conecta.conexao();
        
        try {
            
            
            conecta.rs.next();
            mod.setId(conecta.rs.getInt("id_fornecedor"));
            mod.setNome(conecta.rs.getString("nome_fornecedor"));
            mod.setEndereco(conecta.rs.getString("endereco_fornecedor"));
            mod.setBairro(conecta.rs.getString("nome_bairro"));
            mod.setCnpj(conecta.rs.getString("cnpj"));
            mod.setCidade(conecta.rs.getString("nome_cidade"));
            mod.setEstado(conecta.rs.getString("nome_estado"));
            mod.setCelular(conecta.rs.getString("celular"));
            mod.setIe(conecta.rs.getString("ie"));
            mod.setEmail(conecta.rs.getString("email"));
            mod.setNomeFantasia(conecta.rs.getString("nomefantasia"));
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERRO ao Buscar "+ e);
        }
        
        
        return mod;
    }
    
    public ModeloFornecedor Anterior(){
        
            conecta.conexao();
        
        try {
            
  
            conecta.rs.previous();
            mod.setId(conecta.rs.getInt("id_fornecedor"));
            mod.setNome(conecta.rs.getString("nome_fornecedor"));
            mod.setEndereco(conecta.rs.getString("endereco_fornecedor"));
            mod.setBairro(conecta.rs.getString("nome_bairro"));
            mod.setCnpj(conecta.rs.getString("cnpj"));
            mod.setCidade(conecta.rs.getString("nome_cidade"));
            mod.setEstado(conecta.rs.getString("nome_estado"));
            mod.setCelular(conecta.rs.getString("celular"));
            mod.setIe(conecta.rs.getString("ie"));
            mod.setEmail(conecta.rs.getString("email"));
            mod.setNomeFantasia(conecta.rs.getString("nomefantasia"));
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERRO ao Buscar "+ e);
        }
        
        
        return mod;
    }
    
}
