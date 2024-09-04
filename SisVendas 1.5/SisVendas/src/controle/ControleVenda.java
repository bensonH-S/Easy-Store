/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCompra;
import modelo.ModeloVenda;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ControleVenda {

    int codProd, codCliente;

    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    ModeloVenda modVenda = new ModeloVenda();

    public void adicionaItem(ModeloVenda mod) {

        achaCodProduto(mod.getNomeProduto());
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO itens_venda_produto(id_venda, id_produto, quantidade_produto) VALUES(?,?,?)");
            pst.setInt(1, mod.getIdVenda());
            achaCodProduto(mod.getNomeProduto());
            pst.setInt(2, codProd);
            pst.setInt(3, mod.getQtItem());
            pst.execute();
            // baixa de estoque
            int quant = 0, resul = 0;
            conecta.executaSQL("select * from produto where nome_produto ='" + mod.getNomeProduto() + "'");
            conecta.rs.first();
            quant = conecta.rs.getInt("quantidade");
            resul = quant - mod.getQtItem();
            pst = conecta.conn.prepareStatement("update produto set quantidade = ? where nome_produto = ?");
            pst.setInt(1, resul);
            pst.setString(2, mod.getNomeProduto());
            pst.execute();

            conecta.desconecta();
        } catch (SQLException ex) {

            conecta.desconecta();
            JOptionPane.showMessageDialog(null, "Erro Ao Adiconar Item " + ex);
        }

    }

    public void removeItem(ModeloVenda mod) {

        achaCodProduto(mod.getNomeProduto());
        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("DELETE FROM itens_venda_produto WHERE id_produto = /");
            pst.setInt(1, conecta.rs.getInt("id_produto"));
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void achaCodProduto(String nome) {

        conecta.conexao();

        conecta.executaSQL("SELECT * FROM produto WHERE nome_produto = '" + nome + "'");
        try {

            conecta.rs.first();
            codProd = conecta.rs.getInt("id_produto");

        } catch (SQLException ex) {
            conecta.desconecta();
            JOptionPane.showMessageDialog(null, "Erro Achar o Codigo " + ex);
        }

    }

    public void atualizarProduto(ModeloVenda mod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE itens_venda_produto SET quantidade_produto = ?, WHERE id_venda = ?");
            pst.setInt(1, mod.getQtItem());
            pst.setInt(2, mod.getIdVenda());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fechaVenda(ModeloVenda mod) {
        //achaCliente(mod.getNomeCliente());
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE venda SET data_venda = ?, valor_venda = ?, id_cliente = ?, tipo_pagamento = ?, id_caixa = ?, vendedor = ?, status = ? WHERE id_venda = ?");
            pst.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pst.setFloat(2, mod.getValorVenda());
            pst.setInt(3, 1);// 1 serve para adicionar cliente padrão na venda! o mesmo facilita na impressão do cupom
            pst.setString(4, mod.getPagamento());
            pst.setInt(5, mod.getIdCaixa());
            pst.setString(6, mod.getVendedor());
            pst.setString(7, "finalizada");
            pst.setInt(8, mod.getIdVenda());

            pst.execute();

            c.conexao();
            if (mod.getPagamento().equals("Dinheiro")) {
                PreparedStatement ps = c.conn.prepareStatement("INSERT INTO tbl_entrada_venda (id_caixa,valor_venda, id_venda, data_venda, tipo_pagamento)VALUES(?,?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setFloat(2, mod.getValorVenda());
                ps.setInt(3, mod.getIdVenda());
                ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                ps.setString(5, mod.getPagamento());

                ps.execute();
            }
            c.desconecta();
            //JOptionPane.showMessageDialog(null,"Venda Concluida com Sucesso ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Realizar a Venda " + ex);
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
    public void cancelaVenda() {

        conecta.conexao();
        PreparedStatement pst;
        conecta.executaSQL("select * from venda inner join itens_venda_produto on venda.id_venda = itens_venda_produto.id_venda \n"
                + "inner join produto on itens_venda_produto.id_produto = produto.id_produto where valor_venda = 0");

        try {
            conecta.rs.first();
            do {

                int qtProduto = conecta.rs.getInt("quantidade");
                int qtVend = conecta.rs.getInt("quantidade_produto");

                int soma = qtProduto + qtVend;
                pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade = ? WHERE id_produto = ?");
                pst.setInt(1, soma);
                pst.setInt(2, conecta.rs.getInt("id_produto"));
                pst.execute();
                pst = conecta.conn.prepareStatement("DELETE FROM itens_venda_produto WHERE id_venda = ?");
                pst.setInt(1, conecta.rs.getInt("id_venda"));
                pst.execute();
            } while (conecta.rs.next());
            pst = conecta.conn.prepareStatement("DELETE FROM venda WHERE id_venda = ?");
            pst.setInt(1, 0);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda Cancelada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }

        conecta.desconecta();
    }

    public void cancelaVendaParcelada(ModeloVenda modVenda) {

        conecta.conexao();

        try {

            PreparedStatement pst;
            conecta.executaSQL("select * from venda inner join itens_venda_produto on venda.id_venda = itens_venda_produto.id_venda \n"
                    + "inner join produto on itens_venda_produto.id_produto = produto.id_produto where venda.id_venda =" + modVenda.getIdVenda());

            conecta.rs.first();

            do {

                int qtProduto = conecta.rs.getInt("quantidade");
                int qtVend = conecta.rs.getInt("quantidade_produto");

                int soma = qtProduto + qtVend;
                pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade = ? WHERE id_produto = ?");
                pst.setInt(1, soma);
                pst.setInt(2, conecta.rs.getInt("id_produto"));

                pst.execute();
                pst = conecta.conn.prepareStatement("DELETE FROM itens_venda_produto WHERE id_venda =" + modVenda.getIdVenda());
                //pst.setInt(1, conecta.rs.getInt("id_venda"));
                pst.execute();

                pst = conecta.conn.prepareStatement("DELETE FROM parcela_venda WHERE cod_venda =" + modVenda.getIdVenda());
                pst.execute();
            } while (conecta.rs.next());
            pst = conecta.conn.prepareStatement("DELETE FROM venda WHERE id_venda =" + modVenda.getIdVenda());
            //pst.setInt(1, 0);
            pst.execute();
            pst = conecta.conn.prepareStatement("DELETE FROM tbl_entrada_venda WHERE id_venda =" + modVenda.getIdVenda());
            pst.execute();

            pst = conecta.conn.prepareStatement("DELETE FROM tbl_entrada WHERE id_venda =" + modVenda.getIdVenda());
            pst.execute();
            pst = conecta.conn.prepareStatement("DELETE FROM tbl_cartao WHERE id_venda =" + modVenda.getIdVenda());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Venda Cancelada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }

        conecta.desconecta();
    }

}
