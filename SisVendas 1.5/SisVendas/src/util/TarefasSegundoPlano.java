/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controle.ConectaBanco;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import visao.RelatorioVendaMes;

/**
 *
 * @author cyro cruz
 */
public class TarefasSegundoPlano {
    
    ConectaBanco conecta = new ConectaBanco();
    
    public void Parcelar(int cod){
        

        conecta.conexao();
        JasperPrint rel = null;
        String src ="forms/parcelamento.jasper";
        try {
        Map parametros = new HashMap();
        parametros.put("COD", cod);
        System.out.println("Código da Venda é :"+cod);
        rel = JasperFillManager.fillReport(src, parametros, conecta.conn);
        JasperViewer jv = new JasperViewer(rel, false);
        jv.setExtendedState(jv.MAXIMIZED_BOTH);
        jv.setVisible(true); 
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void VendasDatas(LocalDate Data1, LocalDate Data2){
        

        conecta.conexao();
        JasperPrint rel = null;
        String src ="forms/relatoriovendaspordata.jasper";
        try {
        Map parametros = new HashMap();
        parametros.put("DATA1", Data1);
        parametros.put("DATA2", Data2);
        System.out.println("Data1 é :"+Data1 + "Data 2 : "+ Data2);
        rel = JasperFillManager.fillReport(src, parametros, conecta.conn);
        JasperViewer jv = new JasperViewer(rel, false);
        jv.setExtendedState(jv.MAXIMIZED_BOTH);
        jv.setVisible(true); 
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void comprasDatas(LocalDate Data1, LocalDate Data2){
        

        conecta.conexao();
        JasperPrint rel = null;
        String src ="forms/relatoriocompraspordata.jasper";
        try {
        Map parametros = new HashMap();
        parametros.put("DATA1", Data1);
        parametros.put("DATA2", Data2);
        System.out.println("Data1 é :"+Data1 + "Data 2 : "+ Data2);
        rel = JasperFillManager.fillReport(src, parametros, conecta.conn);
        JasperViewer jv = new JasperViewer(rel, false);
        jv.setExtendedState(jv.MAXIMIZED_BOTH);
        jv.setVisible(true); 
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void VendasDodia(LocalDate data){
        

        conecta.conexao();
        JasperPrint rel = null;
        String src ="forms/vendasdia.jasper";
        try {
        Map parametros = new HashMap();
        parametros.put("DATA", data);
        System.out.println("Código da Venda é :"+data);
        rel = JasperFillManager.fillReport(src, parametros, conecta.conn);
        JasperViewer jv = new JasperViewer(rel, false);
        jv.setExtendedState(jv.MAXIMIZED_BOTH);
        jv.setVisible(true); 
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void relatorioProdutos(){
        
        try {
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM produto");
        String src ="forms/relatorioproduto.jasper";
        JRResultSetDataSource jr = new JRResultSetDataSource(conecta.rs);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(src, null, conecta.conn);
        
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void relatorioClientes(){
        
        try {
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM clientes ");
        String src ="forms/clientes.jasper";
        JRResultSetDataSource jr = new JRResultSetDataSource(conecta.rs);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(src, null, conecta.conn);
        
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void relatorioVendaMes(){
        
        try {
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( )) and status = 'finalizada'");
        String src ="forms/vendasmes.jasper";
        JRResultSetDataSource jr = new JRResultSetDataSource(conecta.rs);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(src, null, conecta.conn);
        
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
