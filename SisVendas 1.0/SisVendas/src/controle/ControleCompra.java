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
import modelo.ModeloCompra;
import modelo.ModeloVenda;

/**
 *
 * @author cyro
 */
public class ControleCompra {
    int codProd, codCliente;
    
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    
    public void adicionaItem(ModeloCompra mod){
        
        achaCodProduto(mod.getNomeProduto());
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO itens_compra_produto(id_compra, id_produto, quantidade_produto) VALUES(?,?,?)");
            pst.setInt(1, mod.getIdCompra());
            achaCodProduto(mod.getNomeProduto());
            pst.setInt(2, codProd);
            pst.setInt(3, mod.getQuantidade());
            pst.execute();
            // baixa de estoque
            int quant = 0, resul = 0;           
            conecta.executaSQL("select * from produto where nome_produto ='"+mod.getNomeProduto()+"'");
            conecta.rs.first();
            quant = conecta.rs.getInt("quantidade");
            resul = quant + mod.getQuantidade();            
            pst = conecta.conn.prepareStatement("update produto set quantidade = ?, preco_compra = ?, lucrovenda = ?, lucro_esperado = ?, preco_venda = ? where nome_produto = ?");
            pst.setInt(1, resul);
            pst.setFloat(2, mod.getPrecoCompra());
            pst.setFloat(3, mod.getLucrovenda());
            pst.setFloat(4, mod.getLucroesperado());
            pst.setFloat(5, mod.getPrecoVenda());
            pst.setString(6, mod.getNomeProduto());
            
            pst.execute();
            
            conecta.desconecta();
        } catch (SQLException ex) {
            
            conecta.desconecta();
            JOptionPane.showMessageDialog(null,"Erro Ao Adiconar Item "+ ex);
        }
        
        
        
    }
    
    public void removeItem(ModeloCompra mod){
        
        achaCodProduto(mod.getNomeProduto());
        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("DELETE FROM itens_venda_produto WHERE id_produto = ?");
            pst.setInt(1, conecta.rs.getInt("id_produto"));
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
        
    }
    
    public void achaCodProduto(String nome){
        
        conecta.conexao();
        
        conecta.executaSQL("SELECT * FROM produto WHERE nome_produto = '"+nome+"'");
        try {
            
            conecta.rs.first();
            codProd = conecta.rs.getInt("id_produto");
            
        } catch (SQLException ex) {
            conecta.desconecta();
            JOptionPane.showMessageDialog(null,"Erro Achar o Codigo "+ ex);
        }
        
    }
    
    public void fechaCompra(ModeloCompra mod){
        //achaCliente(mod.getNomeCliente());
     conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE compras SET fornecedor = ?, numero_nota = ?, data_emissao = ?, total_produtos = ?, desconto = ?, total_nota = ?, tipo_pagamento = ?, vendedor = ?, status = ?, id_caixa = ?  WHERE id_compra = ?");
            pst.setString(1, mod.getFornecedor());
            pst.setInt(2, mod.getNumeroNota());
            pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            pst.setFloat(4, mod.getTotalProdutos());
            pst.setFloat(5, mod.getDescont());
            pst.setFloat(6, mod.getTotalNota());
            pst.setString(7, mod.getTipoPagamento());
            pst.setString(8, mod.getVendedor());
            pst.setString(9, "finalizada");
            pst.setInt(10, mod.getIdCaixa());
            pst.setInt(11, mod.getIdCompra());
           
            pst.execute();
            
            c.conexao();
                if(mod.getTipoPagamento().equals("Dinheiro")){
                PreparedStatement ps = c.conn.prepareStatement("INSERT INTO tbl_saida (id_caixa,id_compra,data_compra,valor_saida, tipo_pagamento)VALUES(?,?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setInt(2, mod.getIdCompra());
                ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                ps.setFloat(4, mod.getTotalNota());                
                ps.setString(5, mod.getTipoPagamento());
                
                ps.execute();
                }
                c.desconecta();
            JOptionPane.showMessageDialog(null,"Compra Concluida com Sucesso ");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro Realizar a Compra "+ ex);
        }
     
     conecta.desconecta();
        
    }
    
//    public void achaVenda(int venda){
//        
//        conecta.conexao();
//        conecta.executaSQL("SELECT * FROM clientes WHERE nome_cliente = '"+nome+"'");
//        
//        try {
//            conecta.rs.first();
//            codCliente = conecta.rs.getInt("id_cliente");
//            
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Erro ao Achar Cliente "+ ex);
//        }
//        
//        
//    }
//    
    public void cancelaCompra(){
        
        conecta.conexao();
        PreparedStatement pst;
        conecta.executaSQL("select * from compras inner join itens_compra_produto on compras.id_compra = itens_compra_produto.id_compra \n" +
"inner join produto on itens_compra_produto.id_produto = produto.id_produto where total_nota = 0");
        
        try {
            conecta.rs.first();
            do {                
                
                int qtProduto = conecta.rs.getInt("quantidade");
                int qtVend = conecta.rs.getInt("quantidade_produto");
                
                int subtrair = qtProduto - qtVend;
                pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade = ? WHERE id_produto = ?");
                pst.setInt(1, subtrair);
                pst.setInt(2, conecta.rs.getInt("id_produto"));
                pst.execute();
                pst = conecta.conn.prepareStatement("DELETE FROM itens_compra_produto WHERE id_compra = ?");
                pst.setInt(1, conecta.rs.getInt("id_compra"));
                pst.execute();
            } while (conecta.rs.next());
            pst = conecta.conn.prepareStatement("DELETE FROM compras WHERE id_compra = ?");
            pst.setInt(1, 0);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Compra Cancelada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Deletar "+ ex);
        }
        
        conecta.desconecta();
    }
    
}
