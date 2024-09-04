package visao;

import controle.ConectaBanco;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;

/**
 *
 * @author Benson
 */
public class FrmLogin extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();
    ModeloLogin mod = new ModeloLogin();

    public FrmLogin() {
        initComponents();

        setIcon();
        preencherUser();
        jPasswordFieldPass.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxUser = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Entrar ");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setText("Cancelar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordFieldPass.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPasswordFieldPass.setForeground(new java.awt.Color(102, 102, 102));
        jPasswordFieldPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPasswordFieldPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPassKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Senha");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuário");

        jComboBoxUser.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBoxUser.setForeground(new java.awt.Color(51, 51, 51));
        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxUser, 0, 320, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldPass))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Easy-Store 2.0");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Todos os direitos reservados - Benson Henrique/Luiz Henrique");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        conecta.conexao();
        mod.setUser((String) jComboBoxUser.getSelectedItem());
        mod.setPass(jPasswordFieldPass.getText());

        try {
            conecta.executaSQL("SELECT user,pass FROM users WHERE user = '" + mod.getUser() + "'");
            conecta.rs.first();

            if (conecta.rs.getString("pass").equals(mod.getPass())) {
                //Método add 09/01/2018
                conecta.executaSQL("SELECT * FROM chaveacesso");
                conecta.rs.last();

                SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
                Date hoje = new Date();
                String dataAtual = (String) df.format(hoje);
                String dataSistema = conecta.rs.getString("datavenc");

                int diaAt, mesAt, anoAt, diaVenc, mesVenc, anoVenc;

                diaAt = Integer.parseInt("" + dataAtual.charAt(0) + dataAtual.charAt(1));
                mesAt = Integer.parseInt("" + dataAtual.charAt(2) + dataAtual.charAt(3));
                anoAt = Integer.parseInt("" + dataAtual.charAt(4) + dataAtual.charAt(5) + dataAtual.charAt(6) + dataAtual.charAt(7));

                diaVenc = Integer.parseInt("" + dataSistema.charAt(0) + dataSistema.charAt(1));
                mesVenc = Integer.parseInt("" + dataSistema.charAt(2) + dataSistema.charAt(3));
                anoVenc = Integer.parseInt("" + dataSistema.charAt(4) + dataSistema.charAt(5) + dataSistema.charAt(6) + dataSistema.charAt(7));

                //verificando se a data do sistema já esta vencida
                if ((diaAt <= diaVenc) && (mesAt <= mesVenc) && (anoAt == anoVenc)) {

                    TelaPrincipal tela = new TelaPrincipal(mod.getUser());
                    tela.setVisible(true);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Achave do seu sistema está Vencida,\nEnsira uma nova chave de acesso valida.");
                    FrmValidaSis frm = new FrmValidaSis();
                    frm.setVisible(true);
                }

            } else {

                JOptionPane.showMessageDialog(rootPane, "Senha ou Usuario estão errados");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro, Informe o código do erro para o suporte: 03301\n");
        } finally {

            conecta.desconecta();

        }

    }//GEN-LAST:event_jButton1ActionPerformed
    private void preencherUser() {
        conecta.conexao();
        conecta.executaSQL("select user  from users");
        jComboBoxUser.removeAllItems();
        try {
            conecta.rs.first();
            do {

                jComboBoxUser.addItem("" + conecta.rs.getString("user"));

            } while (conecta.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            conecta.desconecta();

        }

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordFieldPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            conecta.conexao();
            mod.setUser((String) jComboBoxUser.getSelectedItem());
            mod.setPass(jPasswordFieldPass.getText());

            try {
                conecta.executaSQL("SELECT user,pass FROM users WHERE user = '" + mod.getUser() + "'");
                conecta.rs.first();

                if (conecta.rs.getString("pass").equals(mod.getPass())) {
                    //Método add 09/01/2018
                    conecta.executaSQL("SELECT * FROM chaveacesso");
                    conecta.rs.last();

                    SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
                    Date hoje = new Date();
                    String dataAtual = (String) df.format(hoje);
                    String dataSistema = conecta.rs.getString("datavenc");

                    int diaAt, mesAt, anoAt, diaVenc, mesVenc, anoVenc;

                    diaAt = Integer.parseInt("" + dataAtual.charAt(0) + dataAtual.charAt(1));
                    mesAt = Integer.parseInt("" + dataAtual.charAt(2) + dataAtual.charAt(3));
                    anoAt = Integer.parseInt("" + dataAtual.charAt(4) + dataAtual.charAt(5) + dataAtual.charAt(6) + dataAtual.charAt(7));

                    diaVenc = Integer.parseInt("" + dataSistema.charAt(0) + dataSistema.charAt(1));
                    mesVenc = Integer.parseInt("" + dataSistema.charAt(2) + dataSistema.charAt(3));
                    anoVenc = Integer.parseInt("" + dataSistema.charAt(4) + dataSistema.charAt(5) + dataSistema.charAt(6) + dataSistema.charAt(7));

                    //verificando se a data do sistema já esta vencida
                    if ((diaAt <= diaVenc) && (mesAt <= mesVenc) && (anoAt == anoVenc)) {

                        TelaPrincipal tela = new TelaPrincipal(mod.getUser());
                        tela.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Achave do seu sistema está Vencida,\nEnsira uma nova chave de acesso valida.");
                        FrmValidaSis frm = new FrmValidaSis();
                        frm.setVisible(true);
                    }

                } else {

                    JOptionPane.showMessageDialog(rootPane, "Senha ou Usuario estão errados");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro, Informe o código do erro para o suporte: 03301\n");
            } finally {

                conecta.desconecta();

            }

    }//GEN-LAST:event_jPasswordFieldPassKeyPressed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
