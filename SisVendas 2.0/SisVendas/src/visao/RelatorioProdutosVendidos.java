/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloTabela;
import modelo.NimbusClasse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author cyro
 */
public class RelatorioProdutosVendidos extends javax.swing.JFrame {
    
    ConectaBanco conecta = new ConectaBanco();
    DecimalFormat df;
    
    Date Atual, dataRec,mesAtual;
    
    Date hoje = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat nsdf = new SimpleDateFormat("yyyy-MM-dd");
    LocalDate dataPesquisa;
    
    
    public RelatorioProdutosVendidos() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        Sair();
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            jFormattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (Exception e) {
        }
        
        
        Calendar c = Calendar.getInstance();
        c.get(Calendar.MONTH);
        mesAtual = c.getTime();
        
        jFormattedTextFieldData.setText(String.valueOf(sdf.format(mesAtual)));
        chamaProdutos();
        
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProdutos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVendasFeitas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos mais Vendidos por Dia");

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Produtos vendidos:");

        tabelaVendasFeitas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaVendasFeitas.setForeground(new java.awt.Color(51, 51, 51));
        tabelaVendasFeitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabelaVendasFeitas);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite uma data : ");

        jFormattedTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData.setForeground(new java.awt.Color(51, 51, 51));
        jFormattedTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jFormattedTextFieldData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDataFocusGained(evt);
            }
        });
        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });
        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldData)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantidade de produtos vendidos:");

        jTextFieldQuantidade.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldQuantidade.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldQuantidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jButtonSair.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSair.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSair.setText("Sair (ESC)");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1271, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            conecta.conexao();
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
            
            conecta.executaSQL("select ip.id_produto, c.nome_categoria,p.nome_produto, p.quantidade, sum(ip.quantidade_produto) as 'quantidades' from itens_venda_produto ip inner join produto p on ip.id_produto= p.id_produto inner join venda v on ip.id_venda = v.id_venda inner join categorias c on p.id_categoria = c.id_categoria where v.data_venda ='"+dataPesquisa+"' group by p.nome_produto order by ip.quantidade_produto asc");
            try {
                if(conecta.rs.next()){
                
                preencherTabelaVendas("select ip.id_produto,c.nome_categoria, p.nome_produto, p.quantidade, sum(ip.quantidade_produto) as 'quantidades' from itens_venda_produto ip inner join produto p on ip.id_produto= p.id_produto inner join venda v on ip.id_venda = v.id_venda inner join categorias c on p.id_categoria = c.id_categoria  where v.data_venda ='"+dataPesquisa+"' group by p.nome_produto order by ip.quantidade_produto asc");
                somaProduto();
                
                }else{
                
                JOptionPane.showMessageDialog(null,"Não há produtos vendidos para essa data");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed
    public void chamaProdutos(){
        
        conecta.conexao();
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
            
            conecta.executaSQL("select ip.id_produto, p.nome_produto, p.quantidade, sum(ip.quantidade_produto) as 'quantidades', c.nome_categoria from itens_venda_produto ip inner join produto p on ip.id_produto= p.id_produto inner join venda v on ip.id_venda = v.id_venda inner join categorias c on p.id_categoria = c.id_categoria  where v.data_venda ='"+dataPesquisa+"' group by p.nome_produto order by ip.quantidade_produto asc");
            try {
                if(conecta.rs.next()){
                
                preencherTabelaVendas("select ip.id_produto, p.nome_produto, p.quantidade, sum(ip.quantidade_produto) as 'quantidades',c.nome_categoria from itens_venda_produto ip inner join produto p on ip.id_produto= p.id_produto inner join venda v on ip.id_venda = v.id_venda inner join categorias c on p.id_categoria = c.id_categoria  where v.data_venda ='"+dataPesquisa+"' group by p.nome_produto order by ip.quantidade_produto asc");
                somaProduto();
                
                }else{
                
                JOptionPane.showMessageDialog(null,"Não há produtos vendidos para essa data");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
            conecta.desconecta();
        }
        
    }
    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jFormattedTextFieldDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataFocusGained
        jFormattedTextFieldData.selectAll();
    }//GEN-LAST:event_jFormattedTextFieldDataFocusGained

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed
    
    public void preencherTabelaVendas(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Cod Produto","Nome Produto","Quantidade Vendida", "Estoque Atual","Nome Categoria"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                
                dados.add(new Object[]{conecta.rs.getInt("id_produto"),conecta.rs.getString("nome_produto"), conecta.rs.getInt("quantidades"), conecta.rs.getInt("quantidade"),conecta.rs.getString("nome_categoria")});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR"+ e);
        }finally{
            
            conecta.desconecta();
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(170);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(450);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setPreferredWidth(320);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setResizable(false);
        
        
        
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(30);
       
        
    }
    
    public void somaProduto(){
        
        int quantidade = 0;
        
        conecta.conexao();
        conecta.executaSQL("select ip.id_produto, p.nome_produto, sum(ip.quantidade_produto) as 'quantidades' from itens_venda_produto ip inner join produto p on ip.id_produto= p.id_produto inner join venda v on ip.id_venda = v.id_venda  where v.data_venda ='"+dataPesquisa+"' group by p.nome_produto order by ip.quantidade_produto asc");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               quantidade = quantidade + conecta.rs.getInt("quantidades");
               
                
            }
            
            
            jTextFieldQuantidade.setText(String.valueOf(quantidade));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }finally{
            
            conecta.desconecta();
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutosVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioProdutosVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProdutos;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTable tabelaVendasFeitas;
    // End of variables declaration//GEN-END:variables

    private void Sair() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"escape");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("escape", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonSair.doClick();
                }
            });   
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
}
