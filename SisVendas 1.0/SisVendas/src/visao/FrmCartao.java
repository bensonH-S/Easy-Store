/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;


import com.sun.glass.events.KeyEvent;
import controle.ConectaBanco;
import controle.ControleCaixa;
import controle.ControleCartao;
import controle.ControleEntrada;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCaixa;
import modelo.ModeloCartao;
import modelo.ModeloEntrada;

/**
 *
 * @author cyro
 */
public class FrmCartao extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();
    ModeloCartao mod = new ModeloCartao();
    ControleCartao control = new ControleCartao();
    DecimalFormat df = new DecimalFormat("0.00");
    FrmVenda venda;
    Date data = new Date();
    Date dataHora = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat hm = new SimpleDateFormat("hh:mm");
    String data_venda;
    float valor,entrada;
    int caixa,codVenda;
    
    
    public FrmCartao( int cod) {
        initComponents();
        setIcon();
        ConectaBanco conecta = new ConectaBanco();
        jTextFieldValorEntrada.setText("0,00");        
        jTextFieldValorEntrada.requestFocus();
        jTextFieldValorEntrada.selectAll();
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM venda WHERE id_venda="+cod);
        try {
            conecta.rs.first();
            codVenda = conecta.rs.getInt("id_venda");
            caixa = conecta.rs.getInt("id_caixa");
            data_venda = conecta.rs.getString("data_venda");
            valor = conecta.rs.getFloat("valor_venda");
            jTextFieldCodigoVenda.setText(String.valueOf(cod));
            jTextFieldDataVemda.setText(data_venda);
            jTextFieldCaixa.setText(String.valueOf(caixa));
            String novoValor = df.format(valor).replace(".", ",");
            jTextFieldValorVenda.setText(String.valueOf(novoValor));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao buscar a Venda"+ ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }

    private FrmCartao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonParcelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCaixa = new javax.swing.JTextField();
        jLabelCodigoVenda = new javax.swing.JLabel();
        jTextFieldDataVemda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigoVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldValorVenda = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldValorEntrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

        jButtonParcelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonParcelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonParcelar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonParcelar.setText("Terminar");
        jButtonParcelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonParcelar.setBorderPainted(false);
        jButtonParcelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParcelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Caixa : ");

        jTextFieldCaixa.setEditable(false);
        jTextFieldCaixa.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCaixa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCaixa.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCaixaActionPerformed(evt);
            }
        });

        jLabelCodigoVenda.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelCodigoVenda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigoVenda.setText("Data da venda: ");

        jTextFieldDataVemda.setEditable(false);
        jTextFieldDataVemda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDataVemda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDataVemda.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldDataVemda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Codigo da venda:");

        jTextFieldCodigoVenda.setEditable(false);
        jTextFieldCodigoVenda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigoVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCodigoVenda.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCodigoVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCodigoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoVendaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Valor da venda :");

        jTextFieldValorVenda.setEditable(false);
        jTextFieldValorVenda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldValorVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldValorVenda.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldValorVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCaixa)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jTextFieldValorVenda)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigoVenda)
                    .addComponent(jTextFieldDataVemda, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelCodigoVenda)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldCodigoVenda)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldDataVemda, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jTextFieldValorEntrada.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jTextFieldValorEntrada.setForeground(new java.awt.Color(0, 181, 181));
        jTextFieldValorEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldValorEntradaFocusGained(evt);
            }
        });
        jTextFieldValorEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorEntradaActionPerformed(evt);
            }
        });
        jTextFieldValorEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorEntradaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite o valor recebido em dinheiro:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldValorEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldValorEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonParcelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonParcelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParcelarActionPerformed
        String valorVenda = jTextFieldValorVenda.getText().replace(",", ".");
        String valorEntrada = jTextFieldValorEntrada.getText().replace(",", ".");
        float recebeEntrada = Float.parseFloat(valorEntrada);
        float recebeValor = Float.parseFloat(valorVenda);
        if(recebeEntrada >= recebeValor || valorEntrada.isEmpty()){
       
       JOptionPane.showMessageDialog(rootPane, "Entrada no valor de R$"+ recebeEntrada + " é Maior que o Valor Total R$"+ recebeValor );
       
       }else{       
       mod.setData(jTextFieldDataVemda.getText());
       mod.setIdcaixa(Integer.parseInt(jTextFieldCaixa.getText()));
       mod.setIdvenda(codVenda);
       mod.setEntrada(Float.parseFloat(valorEntrada));
       mod.setTotal(Float.parseFloat(valorVenda));
       
       
       
       entrada = Float.parseFloat(valorEntrada);
      
       control.SalvaCartao(mod);
       FrmParcelamentoCartao c = new FrmParcelamentoCartao(codVenda, entrada);
       c.setVisible(true);
       dispose();
       
       dispose();
       }
    }//GEN-LAST:event_jButtonParcelarActionPerformed

    private void jTextFieldValorEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorEntradaKeyPressed
        String valorVenda = jTextFieldValorVenda.getText().replace(",", ".");
        String valorEntrada = jTextFieldValorEntrada.getText().replace(",", ".");
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        float recebeEntrada = Float.parseFloat(valorEntrada);
        float recebeValor = Float.parseFloat(valorVenda);
        if(recebeEntrada >= recebeValor || valorEntrada.isEmpty()){
       
       JOptionPane.showMessageDialog(rootPane, "Entrada no valor de R$"+ recebeEntrada + " é Maior que o Valor Total R$"+ recebeValor );
       
       }else{       
       mod.setData(jTextFieldDataVemda.getText());
       mod.setIdcaixa(Integer.parseInt(jTextFieldCaixa.getText()));
       mod.setIdvenda(codVenda);
       mod.setEntrada(Float.parseFloat(valorEntrada));
       
       mod.setTotal(Float.parseFloat(valorVenda));
       
       
       
       entrada = Float.parseFloat(valorEntrada);
       
       control.SalvaCartao(mod);
       
       FrmParcelamentoCartao c = new FrmParcelamentoCartao(codVenda, entrada );
       c.setVisible(true);
       dispose();
       }
            
        }
    }//GEN-LAST:event_jTextFieldValorEntradaKeyPressed

    private void jTextFieldValorEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorEntradaActionPerformed

    private void jTextFieldCodigoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoVendaActionPerformed

    private void jTextFieldValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorVendaActionPerformed

    private void jTextFieldCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCaixaActionPerformed

    private void jTextFieldValorEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorEntradaFocusGained
       jTextFieldValorEntrada.selectAll();
    }//GEN-LAST:event_jTextFieldValorEntradaFocusGained

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
            java.util.logging.Logger.getLogger(FrmCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonParcelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCodigoVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCaixa;
    private javax.swing.JTextField jTextFieldCodigoVenda;
    private javax.swing.JTextField jTextFieldDataVemda;
    private javax.swing.JTextField jTextFieldValorEntrada;
    private javax.swing.JTextField jTextFieldValorVenda;
    // End of variables declaration//GEN-END:variables

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
}
