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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import modelo.ModeloTabela;

/**
 *
 * @author cyro cruz
 */
public class CaixasFechados extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();
    DecimalFormat df = new DecimalFormat("0.00");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    LocalDate dataPesquisa;
    public CaixasFechados() {
        initComponents();
        setIcon();
        //this.setExtendedState(MAXIMIZED_BOTH);
        preencherTabela("select * from caixa where status = 'fechado'");
        Sair();
        
    }
    public void preencherTabela(String SQL){
            ArrayList dados = new ArrayList();
           
            String[] Colunas = new String[]{"Caixa","Saldo Abertura", "Data Abertura", "Hora Abertura", "Fica no Caixa", "Data Fechamento","Hora Fechamento","Total do Caixa","Status"};
            conecta.conexao();
            conecta.executaSQL(SQL);
            
            try {
                if(conecta.rs.next()){
                conecta.rs.first();
                
                do {
                    float saldoInicial = conecta.rs.getFloat("saldo_inicial");
                    float SaldoFinal = conecta.rs.getFloat("saldo_final");
                    float totalGeral = conecta.rs.getFloat("total_caixa");
                    Date data = conecta.rs.getDate("data");
                    
                    dados.add(new Object[]{conecta.rs.getInt("id_caixa"), df.format(saldoInicial), sdf.format(data), conecta.rs.getString("hora"),df.format(SaldoFinal), conecta.rs.getString("data_fechamento"), conecta.rs.getString("hora_fechamento"),df.format(totalGeral), conecta.rs.getString("status")});
                    
                } while (conecta.rs.next());
                 jLabelTotalRegistros.setText(String.valueOf(dados.size()));
                }else{
                
                  JOptionPane.showMessageDialog(null, "Não há registros de caixas");
                  
                
                }
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR"+ e);
            }finally{
            
             conecta.desconecta();
            
            }
            
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            
            jTableCaixa.setModel(modelo);
            jTableCaixa.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTableCaixa.getColumnModel().getColumn(0).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableCaixa.getColumnModel().getColumn(1).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableCaixa.getColumnModel().getColumn(2).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTableCaixa.getColumnModel().getColumn(3).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTableCaixa.getColumnModel().getColumn(4).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTableCaixa.getColumnModel().getColumn(5).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(6).setPreferredWidth(120);
            jTableCaixa.getColumnModel().getColumn(6).setResizable(false);
            jTableCaixa.getColumnModel().getColumn(7).setPreferredWidth(170);
            jTableCaixa.getColumnModel().getColumn(7).setResizable(false);
             jTableCaixa.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTableCaixa.getColumnModel().getColumn(8).setResizable(false);
            
            
            
            
            jTableCaixa.getTableHeader().setReorderingAllowed(false);
            jTableCaixa.setAutoResizeMode(jTableCaixa.AUTO_RESIZE_OFF);
            jTableCaixa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableCaixa.setRowHeight(30);
            
            
            //somaValores();
        
        
    
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCaixa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelTotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

        jTableCaixa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableCaixa.setForeground(new java.awt.Color(51, 51, 51));
        jTableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCaixa);

        jPanel2.setBackground(new java.awt.Color(0, 151, 151));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite uma data :");

        jFormattedTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jFormattedTextFieldData.setPreferredSize(new java.awt.Dimension(20, 37));
        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });
        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Todos os caixas");
        jButton1.setPreferredSize(new java.awt.Dimension(137, 37));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(0, 151, 151));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonCancelar.setText("Sair (ESC)");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantidade de Caixas:");

        jLabelTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelTotalRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalRegistros.setText("total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTotalRegistros))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataActionPerformed

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            conecta.conexao();
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]), Integer.parseInt(dataFormatada[0]));
            
            conecta.executaSQL("select * from caixa where data='"+dataPesquisa+"'");
            
            try {
                if(conecta.rs.next()){
                
                preencherTabela("select * from caixa where data='"+dataPesquisa+"' and status ='fechado'");
                
                
                }else{
                
                JOptionPane.showMessageDialog(null,"Não há caixas para essa data");
                jTableCaixa.removeAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarDespesas.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
             conecta.desconecta();
            
            }
            
            
        }
    }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed

    private void jFormattedTextFieldDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conecta.conexao();
//           
            
            conecta.executaSQL("select * from caixa where status ='fechado'");
            
            try {
                if(conecta.rs.next()){
                
                preencherTabela("select * from caixa where status ='fechado'");
                
                
                }else{
                
                JOptionPane.showMessageDialog(null,"Não há caixas para essa data");
                jTableCaixa.removeAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarDespesas.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
             conecta.desconecta();
            
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CaixasFechados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaixasFechados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaixasFechados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaixasFechados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaixasFechados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTotalRegistros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCaixa;
    // End of variables declaration//GEN-END:variables
    
    private void Sair() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0),"escape");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("escape", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonCancelar.doClick();
                }
            });   
    }
   public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
   }
}
