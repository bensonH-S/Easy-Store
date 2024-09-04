/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleVenda;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloTabela;
import modelo.ModeloVenda;
import util.TarefasSegundoPlano;

/**
 *
 * @author cyro
 */
public class RelatorioComprasDatas extends javax.swing.JFrame {
    
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    ModeloVenda mod = new ModeloVenda();
    ControleVenda control = new ControleVenda();
    DecimalFormat df = new DecimalFormat("0.00");
    
    String dataRec;
    int i=1,caixa;
    float entradaPrazo, abertura, vista, pago, totalGeral;
    private GregorianCalendar cal = new GregorianCalendar();
    Date hoje = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    LocalDate dataPesquisa1, dataPesquisa2;
    
    
    
    public RelatorioComprasDatas() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jLabelCarregando.setVisible(false);
        setIcon();
        Sair();
        
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            jFormattedTextFieldData1.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException e) {
        }
        
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            jFormattedTextFieldData2.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (ParseException e) {
        }
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupVendas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVendasFeitas = new javax.swing.JTable();
        totalRece = new javax.swing.JLabel();
        precoRender1 = new util.PrecoRender();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jFormattedTextFieldData2 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotalGeral = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelCarregando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Compras");

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 770));
        jPanel1.setPreferredSize(new java.awt.Dimension(894, 700));

        jLabel.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("Compras realizadas :");

        tabelaVendasFeitas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
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
        tabelaVendasFeitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendasFeitasMouseClicked(evt);
            }
        });
        tabelaVendasFeitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaVendasFeitasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaVendasFeitas);

        totalRece.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalRece.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Verificar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jFormattedTextFieldData2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jFormattedTextFieldData2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldData2KeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite uma data : ");

        jFormattedTextFieldData1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jFormattedTextFieldData1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldData1KeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("entre");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data inicial:");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data final:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(271, 271, 271)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel2)))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldData2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addComponent(jFormattedTextFieldData1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(581, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldData2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldData1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total no periodo:");

        jTextFieldTotalGeral.setEditable(false);
        jTextFieldTotalGeral.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalGeral.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalGeral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Imprimir Lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSair.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSair.setText("Sair (ESC)");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelCarregando.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelCarregando.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCarregando.setText("CARREGANDO RELATÓRIO ...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jButtonSair)
                .addGap(78, 78, 78)
                .addComponent(jLabelCarregando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCarregando)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(274, 274, 274)
                                        .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 216, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldData2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldData2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
             pesquisarVendas();
            
        }
        
    }//GEN-LAST:event_jFormattedTextFieldData2KeyPressed

    private void tabelaVendasFeitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasMouseClicked
        
    }//GEN-LAST:event_tabelaVendasFeitasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        pesquisarVendas();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    public void pesquisarVendas(){
        
        String data = jFormattedTextFieldData1.getText();
        String[] dataFormatada = data.split("-");
        dataPesquisa1 = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
        
        String data2 = jFormattedTextFieldData2.getText();
        String[] dataFormatada2 = data2.split("-");
        dataPesquisa2 = LocalDate.of(Integer.parseInt(dataFormatada2[2]), Integer.parseInt(dataFormatada2[1]),Integer.parseInt(dataFormatada2[0]));
        
            preencherTabelaVendasVista("select * from compras where data_emissao between '"+dataPesquisa1+"' and '"+dataPesquisa2+"'");
            somaProduto();
            
    }
    private void tabelaVendasFeitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasKeyPressed
        if(evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER){
            
             String message = "Deseja Estornar a compra ?";
             String title = "Estornar Compra";
             int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);
        
           if(finalizar == JOptionPane.YES_OPTION){
            
            int index =(int)tabelaVendasFeitas.getValueAt(tabelaVendasFeitas.getSelectedRow(), 0);
            
            mod.setIdVenda(index);
            control.cancelaVendaParcelada(mod);
            
            //preencherTabelaVendas("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( )) and status = 'finalizada' ORDER BY id_venda DESC");
            
           }else{
                    
                  JOptionPane.showMessageDialog(null,"Compra não Estornada");
              
           }
        }
    }//GEN-LAST:event_tabelaVendasFeitasKeyPressed

    private void jFormattedTextFieldData1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldData1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
             pesquisarVendas();
            
        }
       
    }//GEN-LAST:event_jFormattedTextFieldData1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        
       
            
            new Thread(){
        
            public void run(){
              jLabelCarregando.setVisible(true);
              TarefasSegundoPlano parc = new TarefasSegundoPlano();
              parc.comprasDatas(dataPesquisa1, dataPesquisa2);
              jLabelCarregando.setVisible(false);
              
            }
        
        }.start();
            
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed
    
    
    public void preencherTabelaVendasVista(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código Compra","Caixa","Valor Compra","Fornecedor","Data Compra","Pagamento"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorVenda = conecta.rs.getFloat("total_nota");
                Date data = conecta.rs.getDate("data_emissao");
                dados.add(new Object[]{conecta.rs.getInt("id_compra"),conecta.rs.getInt("id_caixa"),  df.format(valorVenda), conecta.rs.getString("fornecedor"), format.format(data), conecta.rs.getString("tipo_pagamento")});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Não há registros para essas Datas");
        }finally{
            
            conecta.desconecta();
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(168);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(168);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(250);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setPreferredWidth(250);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setPreferredWidth(250);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(5).setPreferredWidth(250);
        tabelaVendasFeitas.getColumnModel().getColumn(5).setResizable(false);
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(28);
        somaProduto();
        
    }
    
    
    public void somaProduto(){
        
        
        vista = 0;
        conecta.conexao();
        conecta.executaSQL("select * from compras where data_emissao between '"+dataPesquisa1+"' and '"+dataPesquisa2+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               
               vista = vista + conecta.rs.getFloat("total_nota");
                
            }
            
            
              jTextFieldTotalGeral.setText(String.valueOf(df.format(vista)).replace(".", ","));
              //jTextFieldEntradaPrazo.setText(String.valueOf(entrada));
              
              
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }finally{
            
            conecta.desconecta();
        }
    }
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioComprasDatas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupVendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldData1;
    private javax.swing.JFormattedTextField jFormattedTextFieldData2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCarregando;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldTotalGeral;
    private util.PrecoRender precoRender1;
    private javax.swing.JTable tabelaVendasFeitas;
    private javax.swing.JLabel totalRece;
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
