/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.sun.glass.events.KeyEvent;
import controle.ConectaBanco;
import controle.ControleVenda;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;
import modelo.ModeloTabela;
import modelo.ModeloVenda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.TarefasSegundoPlano;

/**
 *
 * @author cyro
 */
public class FrmVendaMes extends javax.swing.JFrame {
    
    ConectaBanco conecta = new ConectaBanco();
    DecimalFormat df = new DecimalFormat ("0.00");
    ModeloVenda mod = new ModeloVenda();
    ControleVenda control = new ControleVenda();
    Date Atual, dataRec;
    float mesAnterior = 0, compMes = 0;
    Date hoje = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    
    
    public FrmVendaMes() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jLabelCarregando.setVisible(false);
        setIcon();
        Sair();
        ultimoMes();
        comprasMes();
        comprasMesAnterior();
        conecta.conexao();
            
            conecta.executaSQL("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( ))");
            try {
                if(conecta.rs.next()){
                
                preencherTabelaVendas("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( )) order by id_venda desc");
                somaProduto();
                
                }else{
                
                JOptionPane.showMessageDialog(null,"Não há produtos vendidos para essa data");
                    tabelaVendasFeitas.removeAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmVendaMes.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
            conecta.desconecta();
        }
        
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            
            
        } catch (Exception e) {
        }
        
        
        Calendar c = Calendar.getInstance();
        c.get(Calendar.MONTH);
        Date mesAtual = c.getTime();
        
       
        
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupProdutos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVendasFeitas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelCarregando = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldComprasAtual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTotalAtual = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaProdutosVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAnterior = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldComprasAnterior = new javax.swing.JTextField();
        jTextFieldTotalAnterior = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Total de Vendas do Mês");

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

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

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total de vendas do mês:");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Vendas do Mês - Relatório");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jLabelCarregando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCarregando.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCarregando.setText("CARREGANDO RELATÓRIO...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(jButtonSair)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(558, 558, 558)
                    .addComponent(jLabelCarregando)
                    .addContainerGap(559, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabelCarregando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(23, 23, 23)))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Produtos da venda:");

        jTextFieldQuantidade.setEditable(false);
        jTextFieldQuantidade.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldQuantidade.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldQuantidade.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldQuantidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total vendas do mês:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total compras do mês atual:");

        jTextFieldComprasAtual.setEditable(false);
        jTextFieldComprasAtual.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldComprasAtual.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldComprasAtual.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldComprasAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldComprasAtual.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");

        jTextFieldTotalAtual.setEditable(false);
        jTextFieldTotalAtual.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalAtual.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalAtual.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalAtual.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(86, 86, 86)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldComprasAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(jTextFieldTotalAtual)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTotalAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9)
                        .addComponent(jTextFieldComprasAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        tabelaProdutosVendas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaProdutosVendas.setForeground(new java.awt.Color(51, 51, 51));
        tabelaProdutosVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabelaProdutosVendas);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Observações ");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("* Clique na venda e  enter para estornar");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("* Clique em cima da venda para detalhar");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total vendas do mês anterior:");

        jTextFieldAnterior.setEditable(false);
        jTextFieldAnterior.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAnterior.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldAnterior.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAnterior.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total compras do mês anterior:");

        jTextFieldComprasAnterior.setEditable(false);
        jTextFieldComprasAnterior.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldComprasAnterior.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldComprasAnterior.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldComprasAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldComprasAnterior.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jTextFieldTotalAnterior.setEditable(false);
        jTextFieldTotalAnterior.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalAnterior.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalAnterior.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalAnterior.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Saldo total mês anterior:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldComprasAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldTotalAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1)))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldComprasAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTotalAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void tabelaVendasFeitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasMouseClicked
        
        int cod = (int)tabelaVendasFeitas.getValueAt(tabelaVendasFeitas.getSelectedRow(), 0);
        
        preencherTabelaProdutos("select * from venda inner join itens_venda_produto on venda.id_venda = itens_venda_produto.id_venda\n" +
            "inner join produto on itens_venda_produto.id_produto = produto.id_produto where venda.id_venda ="+cod);
    }//GEN-LAST:event_tabelaVendasFeitasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new Thread(){
            
            
            public void run(){
                jLabelCarregando.setVisible(true);
                TarefasSegundoPlano p = new TarefasSegundoPlano();
                p.relatorioVendaMes();
                jLabelCarregando.setVisible(false);
         
            }
        }.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaVendasFeitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
             String message = "Deseja Estornar a venda ?";
             String title = "Estornar Venda";
             int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);
        
           if(finalizar == JOptionPane.YES_OPTION){
            
            int index =(int)tabelaVendasFeitas.getValueAt(tabelaVendasFeitas.getSelectedRow(), 0);
            
            mod.setIdVenda(index);
            control.cancelaVendaParcelada(mod);
            
            preencherTabelaVendas("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( )) and status = 'finalizada' ORDER BY id_venda DESC");
            
           }else{
                    
                  JOptionPane.showMessageDialog(null,"Venda não Estornada");
              
           }
        }
    }//GEN-LAST:event_tabelaVendasFeitasKeyPressed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed
    
    public void preencherTabelaVendas(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código Venda","Valor da Venda","Data da Venda","Tipo de Pagamento","Vendedor" };
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorVenda = conecta.rs.getFloat("valor_venda");
                Date novaData = conecta.rs.getDate("data_venda");
                dados.add(new Object[]{conecta.rs.getInt("id_venda"),df.format(valorVenda), sdf.format(novaData), conecta.rs.getString("tipo_pagamento"), conecta.rs.getString("vendedor")});
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
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(170);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(210);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setPreferredWidth(215);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setPreferredWidth(270);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setResizable(false);
        
        
        
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(30);
        
        somaProduto();
        
    }
    
    public void preencherTabelaProdutos(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código","Nome do Produto","Quantidade"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                
                dados.add(new Object[]{conecta.rs.getInt("id_venda"),conecta.rs.getString("nome_produto"),conecta.rs.getInt("quantidade_produto")});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR"+ e);
        }finally{
            
            conecta.desconecta();
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaProdutosVendas.setModel(modelo);
        tabelaProdutosVendas.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabelaProdutosVendas.getColumnModel().getColumn(0).setResizable(false);
        tabelaProdutosVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaProdutosVendas.getColumnModel().getColumn(1).setResizable(false);
        tabelaProdutosVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaProdutosVendas.getColumnModel().getColumn(2).setResizable(false);
        tabelaProdutosVendas.getTableHeader().setReorderingAllowed(false);
        tabelaProdutosVendas.setAutoResizeMode(tabelaProdutosVendas.AUTO_RESIZE_OFF);
        tabelaProdutosVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaProdutosVendas.setRowHeight(30);
        
        somaProduto();
        
    }
    
    public void somaProduto(){
        
        float quantidade = 0;
        
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( ))");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               quantidade = quantidade + conecta.rs.getFloat("valor_venda");
                
            }
            
            
            jTextFieldQuantidade.setText(String.valueOf(df.format(quantidade)));
            float comprasAtual = Float.parseFloat(jTextFieldComprasAtual.getText().replace(",","."));
            float total = quantidade - comprasAtual;
            jTextFieldTotalAtual.setText(String.valueOf(df.format(total)));
            
            float cAnterior = Float.parseFloat(jTextFieldComprasAnterior.getText().replace(",","."));
            float totalN = mesAnterior - cAnterior;
            jTextFieldTotalAnterior.setText(String.valueOf(df.format(totalN)));
            
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
            java.util.logging.Logger.getLogger(FrmVendaMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendaMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendaMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendaMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVendaMes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProdutos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCarregando;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldAnterior;
    private javax.swing.JTextField jTextFieldComprasAnterior;
    private javax.swing.JTextField jTextFieldComprasAtual;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTotalAnterior;
    private javax.swing.JTextField jTextFieldTotalAtual;
    private javax.swing.JTable tabelaProdutosVendas;
    private javax.swing.JTable tabelaVendasFeitas;
    // End of variables declaration//GEN-END:variables

    private void Sair() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0),"escape");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("escape", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonSair.doClick();
                }
            });   
    }

    private void ultimoMes() {
        conecta.conexao();
        conecta.executaSQL("SELECT sum(valor_venda) as 'total' , data_venda FROM venda WHERE MONTH( data_venda )  = MONTH( CURDATE())-1 AND YEAR( data_venda ) = YEAR( CURDATE( ))");
        try {
            if(conecta.rs.next()){
            conecta.rs.first();
            mesAnterior = conecta.rs.getFloat("total");
            jTextFieldAnterior.setText(String.valueOf(df.format(mesAnterior)));
            
            
            }else{
                
                jTextFieldAnterior.setText("0,00");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    public void comprasMes(){
    
        conecta.conexao();
        conecta.executaSQL("SELECT sum(total_nota) as 'total' , data_emissao FROM compras WHERE MONTH( data_emissao )  = MONTH( CURDATE()) AND YEAR( data_emissao ) = YEAR( CURDATE( ))");
        try {
            if(conecta.rs.next()){
            conecta.rs.first();
            compMes = conecta.rs.getFloat("total");
            jTextFieldComprasAtual.setText(String.valueOf(df.format(compMes)));
            
            }else{
                
                jTextFieldComprasAtual.setText("0,00");
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void comprasMesAnterior(){
    
        conecta.conexao();
        conecta.executaSQL("SELECT sum(total_nota) as 'total' , data_emissao FROM compras WHERE MONTH( data_emissao )  = MONTH( CURDATE())-1 AND YEAR( data_emissao ) = YEAR( CURDATE( ))");
        try {
            if(conecta.rs.next()){
            conecta.rs.first();
            compMes = conecta.rs.getFloat("total");
            jTextFieldComprasAnterior.setText(String.valueOf(df.format(compMes)));
            
            }else{
                
                jTextFieldComprasAnterior.setText("0,00");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmVendaMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
