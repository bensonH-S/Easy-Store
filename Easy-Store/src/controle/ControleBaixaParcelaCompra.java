/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.ModeloBaixaParcelaCompra;

/**
 *
 * @author cyro
 */
public class ControleBaixaParcelaCompra {
    
     ConectaBanco conecta = new ConectaBanco();
     ConectaBanco c = new ConectaBanco();
     SimpleDateFormat hoje = new SimpleDateFormat("dd/MM/yyyy");
     public ModeloBaixaParcelaCompra BuscaParcela(ModeloBaixaParcelaCompra mod ){
         
         conecta.conexao();
         
         
         try {
             conecta.executaSQL("select * from parcela_compra inner join compras on parcela_compra.cod_compra = compras.id_compra inner join fornecedor on parcela_compra.id_fornecedor = fornecedor.id_fornecedor\n" +
"where nome_fornecedor like '%"+mod.getNomeFornecedor()+"%'");
             conecta.rs.first();
             mod.setCodParc(conecta.rs.getInt("id_parc_compra"));
             mod.setCodCompra(conecta.rs.getInt("cod_compra"));
             mod.setDataVenc(conecta.rs.getString("datavenc"));
             mod.setValor(conecta.rs.getFloat("valor_parc"));
             mod.setNomeFornecedor(conecta.rs.getString("nome_fornecedor"));
             
             
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Parcela\n Erro "+ ex);
         }
        
         conecta.desconecta();
         return mod;
         
     }
     
     public void BaixarParcela(ModeloBaixaParcelaCompra mod){
         conecta.conexao();
  
         try {
             
             
             conecta.executaSQL("SELECT * FROM parcela_compra WHERE id_parc_compra ="+mod.getCodParc()+" AND valor_resta = '0.00'");
             if(conecta.rs.first()){
                 
                 JOptionPane.showMessageDialog(null,"Parcela Ja Está Paga");
                 
             }else if(mod.getValor_resta() == 0){
                
                try {
                 PreparedStatement pst = conecta.conn.prepareStatement("UPDATE parcela_compra SET estado=?, valor_parcial=?, valor_resta=?, pago=?, datarecebimento = ? WHERE id_parc_compra=?");
                 pst.setString(1, "Pago");
                 pst.setFloat(2, mod.getValor_parcial());
                 pst.setFloat(3, mod.getValor_resta());
                 pst.setFloat(4, mod.getPago());
                 pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                 pst.setInt(6, mod.getCodParc());              
                 pst.execute();
                 
                 c.conexao();
                PreparedStatement ps = c.conn.prepareStatement("INSERT INTO tbl_saida_crediario (id_caixa, valor_pago,data_recebimento,id_compra)VALUES(?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setFloat(2, mod.getPago());
                ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                ps.setInt(4, mod.getCodCompra());
                ps.execute();
                
                c.desconecta();
                
                 JOptionPane.showMessageDialog(null,"Parcela Baixada com Sucesso");
                conecta.desconecta();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Parcela Baixada com Erro"+ ex);
                }
                
                }else{
                
                try {
                 PreparedStatement pst = conecta.conn.prepareStatement("UPDATE parcela_compra SET estado=?, valor_parcial=?, valor_resta=? , pago=?, datarecebimento = ? WHERE id_parc_compra=?");
                 pst.setString(1, "Parcial");
                 pst.setFloat(2, mod.getValor_parcial());
                 pst.setFloat(3, mod.getValor_resta());
                 pst.setFloat(4, mod.getPago());
                 SimpleDateFormat in = new SimpleDateFormat("YYYY-MM-DD");
	         SimpleDateFormat out = new SimpleDateFormat("DD-MM-YYYY");
                 pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                 pst.setInt(6, mod.getCodParc());                 
                 pst.execute();
                 
                 c.conexao();
                PreparedStatement ps = c.conn.prepareStatement("INSERT INTO tbl_saida_crediario (id_caixa, valor_pago,data_recebimento,id_compra)VALUES(?,?,?,?)");
                ps.setInt(1, mod.getIdCaixa());
                ps.setFloat(2, mod.getPago());
                ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                ps.setInt(4, mod.getCodCompra());
                ps.execute();
                
                c.desconecta();
                 JOptionPane.showMessageDialog(null,"Parcela Baixada com Sucesso"+"Valor parcial - "+mod.getValor_parcial()+" Valor que Resta "+ mod.getValor_resta());
                conecta.desconecta();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Parcela Baixada com Erro"+ ex);
                }
                
             
                conecta.desconecta();
                
                }
         
         } catch (SQLException ex) {
         conecta.desconecta();
             JOptionPane.showMessageDialog(null,"Parcela Baixada com Erro"+ ex);
         }
         
     }
    
}
