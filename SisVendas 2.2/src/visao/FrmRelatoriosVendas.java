/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleVenda;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import modelo.ModeloVenda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.TarefasSegundoPlano;

/**
 *
 * @auth
 * or cyro
 */
public class FrmRelatoriosVendas extends javax.swing.JFrame {
    
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    ModeloVenda mod = new ModeloVenda();
    ControleVenda control = new ControleVenda();
    DecimalFormat df = new DecimalFormat("0.00");
    
    String dataRec;
    int i=1,caixa;
    float entradaPrazo, abertura, vista, pago, cartao, totalGeral;
    private GregorianCalendar cal = new GregorianCalendar();
    Date hoje = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    LocalDate dataPesquisa;
    
    
    
    public FrmRelatoriosVendas() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jLabelCarregando.setVisible(false);
        setIcon();
        Sair();
        
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            jFormattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (Exception e) {
        }
        
        
        
        jFormattedTextFieldData.setText(format.format(hoje));
        String data = jFormattedTextFieldData.getText();
        String[] dataFormatada = data.split("-");
        dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
        
        conecta.conexao();
        conecta.executaSQL("select sum(valor_venda) as 'entradas' from venda where tipo_pagamento = 'Crediario' and data_venda='"+dataPesquisa+"'");
        try {
            
            conecta.rs.first();
            float pEntrada = conecta.rs.getFloat("entradas");
            jTextFieldEntradaPrazo.setText(String.valueOf(df.format(pEntrada)).replace(".", ","));
        } catch (SQLException ex) {
            Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaSQL("select sum(entrada_cartao) as 'entradas' from tbl_cartao where data_venda = '"+dataPesquisa+"'");
        try {
            conecta.rs.first();
            float pEntrada = conecta.rs.getFloat("entradas");
            jTextFieldCartao.setText(String.valueOf(df.format(pEntrada)).replace(".", ","));
        } catch (SQLException ex) {
            Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaSQL("select sum(valor_venda) as 'vendas' from tbl_entrada_venda where data_venda='"+dataPesquisa+"'");
        try {
            conecta.rs.first();
            float pVista = conecta.rs.getFloat("vendas");
            jTextFieldVista.setText(String.valueOf(df.format(pVista)).replace(".", ","));
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            conecta.desconecta();
        }
        
        conecta.conexao();
        conecta.executaSQL("select sum(valor_pago) as 'pagos' from tbl_entrada_crediario where data_recebimento='"+dataPesquisa+"'");
        try {
            conecta.rs.first();
            float pRecebimento = conecta.rs.getFloat("pagos");
            jTextFieldRecebimento.setText(String.valueOf(df.format(pRecebimento)).replace(".", ","));
        } catch (SQLException ex) {
            Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            conecta.desconecta();
        }
        
        total();
        
        preencherTabelaVendasVista("select tv.id_caixa, tv.id_venda, tv.valor_venda, tv.data_venda, v.vendedor from tbl_entrada_venda tv inner join venda v on tv.id_venda = v.id_venda  where tv.data_venda='"+dataPesquisa+"'");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupVendas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVendasFeitas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDetalhesV = new javax.swing.JTable();
        totalRece = new javax.swing.JLabel();
        precoRender1 = new util.PrecoRender();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonRecebimento = new javax.swing.JRadioButton();
        jRadioButtonVista = new javax.swing.JRadioButton();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioCrediario = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabelCarregando = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotalGeral = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldRecebimento = new javax.swing.JTextField();
        jTextFieldVista = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEntradaPrazo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCartao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Diário");

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 770));
        jPanel1.setPreferredSize(new java.awt.Dimension(894, 700));

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

        tabelaDetalhesV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaDetalhesV.setForeground(new java.awt.Color(51, 51, 51));
        tabelaDetalhesV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaDetalhesV);

        totalRece.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalRece.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jRadioButtonRecebimento.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupVendas.add(jRadioButtonRecebimento);
        jRadioButtonRecebimento.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jRadioButtonRecebimento.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRecebimento.setText("Recebimentos");
        jRadioButtonRecebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonRecebimentoMouseClicked(evt);
            }
        });

        jRadioButtonVista.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupVendas.add(jRadioButtonVista);
        jRadioButtonVista.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jRadioButtonVista.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVista.setSelected(true);
        jRadioButtonVista.setText("A Vista");
        jRadioButtonVista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonVistaMouseClicked(evt);
            }
        });

        jFormattedTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite uma data : ");

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Selecione o tipo:");

        jRadioCrediario.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupVendas.add(jRadioCrediario);
        jRadioCrediario.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jRadioCrediario.setForeground(new java.awt.Color(255, 255, 255));
        jRadioCrediario.setText("Crediário");
        jRadioCrediario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioCrediarioMouseClicked(evt);
            }
        });
        jRadioCrediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCrediarioActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("Relatório");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelCarregando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCarregando.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCarregando.setText("CARREGANDO RELATÓRIO...");

        jRadioButton1.setBackground(new java.awt.Color(0, 151, 151));
        btnGroupVendas.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Cartao");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(139, 139, 139)
                        .addComponent(jLabelCarregando)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonVista, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioCrediario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonRecebimento)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabelCarregando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonRecebimento)
                            .addComponent(jRadioButtonVista)
                            .addComponent(jRadioCrediario)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))))
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total no dia :");

        jTextFieldTotalGeral.setEditable(false);
        jTextFieldTotalGeral.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldTotalGeral.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalGeral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Recebimentos de parcelas");

        jTextFieldRecebimento.setEditable(false);
        jTextFieldRecebimento.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldRecebimento.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldRecebimento.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldRecebimento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldRecebimento.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jTextFieldVista.setEditable(false);
        jTextFieldVista.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldVista.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldVista.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldVista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldVista.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVistaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vendas a vista:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Entradas no crediario:");

        jTextFieldEntradaPrazo.setEditable(false);
        jTextFieldEntradaPrazo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEntradaPrazo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldEntradaPrazo.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldEntradaPrazo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEntradaPrazo.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Entradas cartão:");

        jTextFieldCartao.setEditable(false);
        jTextFieldCartao.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCartao.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextFieldCartao.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCartao.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldEntradaPrazo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldVista, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43))
                            .addComponent(jTextFieldCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVista, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldEntradaPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Produtos da venda:");

        jButtonSair.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSair.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSair.setText("Sair (ESC)");
        jButtonSair.setBorderPainted(false);
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(precoRender1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//       
//               conecta.conexao();
//               String data = jFormattedTextFieldData.getText();
//               String[] dataFormatada = data.split("-");
//               dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
//               
//               
//            try {
//                
//                conecta.executaSQL("select sum(valor_venda) as 'valor' from tbl_entrada_venda where data_venda='"+dataPesquisa+"'");
//                if(conecta.rs.next()){
//                    float pValorV = conecta.rs.getFloat("valor");
//                    jTextFieldVista.setText(String.valueOf(df.format(pValorV)).replace(".", ","));
//                    
//                }else{
//                    
//                    JOptionPane.showMessageDialog(null,"Não Existe Registro para essa Data");
//                    
//                
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
//            }finally{
//            
//            conecta.desconecta();
//        }
//            
//            try {
//                
//                conecta.executaSQL("select sum(valor_entrada) as 'entrada' from tbl_entrada where data_venda='"+dataPesquisa+"'");
//                if(conecta.rs.next()){
//                    //preencherTabelaVendas("select valor_entrada from tbl_entrada where data_recebimento='"+data+"'");
//                    float pValorE = conecta.rs.getFloat("entrada");
//                    jTextFieldEntradaPrazo.setText(String.valueOf(df.format(pValorE)).replace(".", ","));
//                    
//                    
//                }else{
//                    
//                    JOptionPane.showMessageDialog(null,"Não Existe Registro para essa Data");
//                    
//                
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
//            }finally{
//            
//            conecta.desconecta();
//        }
//            
//            try {
//                
//                conecta.executaSQL("select sum(valor_pago) as 'pago' from tbl_entrada_crediario where data_recebimento='"+dataPesquisa+"'");
//                if(conecta.rs.next()){
//                    //preencherTabelaVendas("select valor_entrada from tbl_entrada where data_recebimento='"+data+"'");
//                    float pValorR = conecta.rs.getFloat("pago");
//                    jTextFieldRecebimento.setText(String.valueOf(df.format(pValorR)).replace(".", ","));
//                    
//                    
//                }else{
//                    
//                    JOptionPane.showMessageDialog(null,"Não Existe Registro para essa Data");
//                    
//                
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(FrmRelatoriosVendas.class.getName()).log(Level.SEVERE, null, ex);
//            }finally{
//            
//            conecta.desconecta();
//        }
//            entradaPrazo = Float.parseFloat(jTextFieldEntradaPrazo.getText().replace(",", "."));
//            pago = Float.parseFloat(jTextFieldRecebimento.getText().replace(",", "."));
//            vista = Float.parseFloat(jTextFieldVista.getText().replace(",", "."));
//            float totall = entradaPrazo + pago + vista ;
//            jTextFieldTotalGeral.setText(String.valueOf(df.format(totall)).replace(".", ","));
//              
//            if(jRadioButtonVista.isSelected()){
//
//            preencherTabelaVendasVista("select tv.id_caixa, tv.id_venda, tv.valor_venda, tv.data_venda, v.vendedor from tbl_entrada_venda tv inner join venda v on tv.id_venda = v.id_venda  where tv.data_venda='"+dataPesquisa+"'");
//            ativarValores();
//            somaProduto();
//            }else if(jRadioButtonRecebimento.isSelected()){
//
//            preencherTabelaVendasPrazo("select id_caixa, id_venda, valor_pago from tbl_entrada_crediario  where data_recebimento='"+dataPesquisa+"'");
//            tabelaVendasFeitas.removeAll();
//            ativarValores();
//            somaPrazo();
//
//          }else{
//            
//            preencherTabelaVendasVista("select * from venda where tipo_pagamento = 'Crediario' and data_venda='"+dataPesquisa+"'");
//            ativarValores();
//            somaProduto();
//            
//            }
//        }
        
        
    }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed

    private void jTextFieldVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVistaActionPerformed

    private void tabelaVendasFeitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasMouseClicked
        int cod = (int) tabelaVendasFeitas.getValueAt(tabelaVendasFeitas.getSelectedRow(),1);
        preencherTabelaDetalhesVendas("select * from venda inner join itens_venda_produto on venda.id_venda = itens_venda_produto.id_venda\n" +
            "inner join produto on itens_venda_produto.id_produto = produto.id_produto  where venda.id_venda ="+cod);
    }//GEN-LAST:event_tabelaVendasFeitasMouseClicked

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
       dispose();
         
        
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void tabelaVendasFeitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaVendasFeitasKeyPressed
        if(evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER){
            
             String message = "Deseja Estornar a venda ?";
             String title = "Estornar Venda";
             int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);
        
           if(finalizar == JOptionPane.YES_OPTION){
            
            int index =(int)tabelaVendasFeitas.getValueAt(tabelaVendasFeitas.getSelectedRow(), 0);
            
            mod.setIdVenda(index);
            control.cancelaVendaParcelada(mod);
            
            //preencherTabelaVendas("SELECT * FROM venda WHERE MONTH( data_venda ) = MONTH( CURDATE( ) ) AND YEAR( data_venda ) = YEAR( CURDATE( )) and status = 'finalizada' ORDER BY id_venda DESC");
            
           }else{
                    
                  JOptionPane.showMessageDialog(null,"Venda não Estornada");
              
           }
        }
    }//GEN-LAST:event_tabelaVendasFeitasKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String dataAmericana = jFormattedTextFieldData.getText();
        String[] dataFormatada = dataAmericana.split("-");
        dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
        
        new Thread(){
            
            @Override
            public void run(){
                jLabelCarregando.setVisible(true);
                TarefasSegundoPlano p = new TarefasSegundoPlano();
                p.VendasDodia(dataPesquisa);
                jLabelCarregando.setVisible(false);
            }
            
        }.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCrediarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioCrediarioActionPerformed

    private void jRadioCrediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioCrediarioMouseClicked
            
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
             preencherTabelaVendasVista("select * from venda where tipo_pagamento = 'Crediario' and data_venda='"+dataPesquisa+"'");
            ativarValores();
            somaCrediario();
            total();
    }//GEN-LAST:event_jRadioCrediarioMouseClicked

    private void jRadioButtonVistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonVistaMouseClicked
            
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
            preencherTabelaVendasVista("select tv.id_caixa, tv.id_venda, tv.valor_venda, tv.data_venda, v.vendedor from tbl_entrada_venda tv inner join venda v on tv.id_venda = v.id_venda  where tv.data_venda='"+dataPesquisa+"'");
            ativarValores();
            somaProduto();
            total();
            
    }//GEN-LAST:event_jRadioButtonVistaMouseClicked

    private void jRadioButtonRecebimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRecebimentoMouseClicked
            
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
            preencherTabelaVendasPrazo("select id_caixa, id_venda, valor_pago from tbl_entrada_crediario  where data_recebimento='"+dataPesquisa+"'");
            tabelaVendasFeitas.removeAll();
            ativarValores();
            somaPrazo();
            total();
    }//GEN-LAST:event_jRadioButtonRecebimentoMouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code hereString data = jFormattedTextFieldData.getText();
            String data = jFormattedTextFieldData.getText();
            String[] dataFormatada = data.split("-");
            dataPesquisa = LocalDate.of(Integer.parseInt(dataFormatada[2]), Integer.parseInt(dataFormatada[1]),Integer.parseInt(dataFormatada[0]));
            preencherTabelaCartao("select *  from venda where data_venda='"+dataPesquisa+"' and tipo_pagamento ='Cartao'");
            tabelaVendasFeitas.removeAll();
            ativarValores();
            somaCartao();
            total();
    }//GEN-LAST:event_jRadioButton1MouseClicked
    
    public void ativarValores(){
        
        jTextFieldVista.setVisible(true);
        
        
    }
    
    public void preencherTabelaVendasPrazo(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código do Caixa","Código da Venda","Valor do Recebimento"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorPago = conecta.rs.getFloat("valor_pago");
                
                dados.add(new Object[]{conecta.rs.getInt("id_caixa"),conecta.rs.getInt("id_venda"), df.format(valorPago)});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "Sem Registros"+ e);
        }finally{
            
            conecta.desconecta();
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(270);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(28);
        somaPrazo();
        
    }
    public void preencherTabelaCartao(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código do Caixa","Código da Venda","Valor do venda"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorPago = conecta.rs.getFloat("valor_venda");
                
                dados.add(new Object[]{conecta.rs.getInt("id_caixa"),conecta.rs.getInt("id_venda"), df.format(valorPago)});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "Sem Registros"+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(270);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(28);
        somaCartao();
        
    }
    public void preencherTabelaVendasVista(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Caixa","Venda","Valor Venda","Vendedor","Data Venda"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorVenda = conecta.rs.getFloat("valor_venda");
                Date data = conecta.rs.getDate("data_venda");
                dados.add(new Object[]{conecta.rs.getInt("id_caixa"), conecta.rs.getInt("id_venda"), df.format(valorVenda), conecta.rs.getString("vendedor"), format.format(data)});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "Sem Registros"+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaVendasFeitas.getColumnModel().getColumn(1).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaVendasFeitas.getColumnModel().getColumn(2).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setPreferredWidth(300);
        tabelaVendasFeitas.getColumnModel().getColumn(3).setResizable(false);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setPreferredWidth(300);
        tabelaVendasFeitas.getColumnModel().getColumn(4).setResizable(false);
        
        
        
        
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(28);
        somaProduto();
        
    }
    
    public void preencherTabelaVendas(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Entrada e vendas a vista" };
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorVenda = conecta.rs.getFloat("valor_venda");
                dados.add(new Object[]{df.format(valorVenda)});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "Sem Registros"+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaVendasFeitas.setModel(modelo);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabelaVendasFeitas.getColumnModel().getColumn(0).setResizable(false);
      
        tabelaVendasFeitas.getTableHeader().setReorderingAllowed(false);
        tabelaVendasFeitas.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaVendasFeitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVendasFeitas.setRowHeight(28);
        
        somaProduto();
        
    }
    public void preencherTabelaDetalhesVendas(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Nome do Produto", "Quantidade do Produto"};
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                
                dados.add(new Object[]{conecta.rs.getString("nome_produto"), conecta.rs.getString("quantidade_produto")});
            } while (conecta.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "Sem Registros"+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        tabelaDetalhesV.setModel(modelo);
        tabelaDetalhesV.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabelaDetalhesV.getColumnModel().getColumn(0).setResizable(false);
        tabelaDetalhesV.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelaDetalhesV.getColumnModel().getColumn(1).setResizable(false);
        
        tabelaDetalhesV.getTableHeader().setReorderingAllowed(false);
        tabelaDetalhesV.setAutoResizeMode(tabelaVendasFeitas.AUTO_RESIZE_OFF);
        tabelaDetalhesV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaDetalhesV.setRowHeight(28);
        
        
    }
    
    
    public void somaProduto(){
        
        
        vista = 0;
        conecta.conexao();
        conecta.executaSQL("select tv.id_caixa, tv.id_venda, tv.valor_venda, tv.data_venda from tbl_entrada_venda tv inner join venda v on tv.id_venda = v.id_venda  where tv.data_venda='"+dataPesquisa+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               
               vista = vista + conecta.rs.getFloat("valor_venda");
                
            }
            
            
              jTextFieldVista.setText(String.valueOf(df.format(vista)).replace(".", ","));
              //jTextFieldEntradaPrazo.setText(String.valueOf(entrada));
              
              
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }
    }
    
    public void somaPrazo(){
        
        
        pago = 0;
        conecta.conexao();
        conecta.executaSQL("select id_caixa, id_venda, valor_pago from tbl_entrada_crediario  where data_recebimento='"+dataPesquisa+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               pago = pago + conecta.rs.getFloat("valor_pago");
               
                
            }
            
            jTextFieldRecebimento.setText(String.valueOf(df.format(pago)).replace(".", ","));
            
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }
    }
    
    public void somaCrediario(){
        
        
        pago = 0;
        conecta.conexao();
        conecta.executaSQL("select sum(valor_venda) as 'entradas' from venda where tipo_pagamento = 'Crediario' and data_venda ='"+dataPesquisa+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               pago = pago + conecta.rs.getFloat("entradas");
               
                
            }
            
            jTextFieldEntradaPrazo.setText(String.valueOf(df.format(pago)).replace(".", ","));
            
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }
    }
    
    public void somaCartao(){
        
        
        cartao = 0;
        conecta.conexao();
        conecta.executaSQL("select sum(valor_venda) as 'entradas' from venda where tipo_pagamento = 'Cartao' and data_venda ='"+dataPesquisa+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               cartao = cartao + conecta.rs.getFloat("entradas");
               
                
            }
            
            jTextFieldCartao.setText(String.valueOf(df.format(cartao)).replace(".", ","));
            
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }
    }
    
    private void total(){
        entradaPrazo = Float.parseFloat(jTextFieldEntradaPrazo.getText().replace(",", "."));
        pago = Float.parseFloat(jTextFieldRecebimento.getText().replace(",", "."));
        vista = Float.parseFloat(jTextFieldVista.getText().replace(",", "."));
        cartao = Float.parseFloat(jTextFieldCartao.getText().replace(",", "."));
        float totalizando = entradaPrazo + pago + vista + cartao;
        
        jTextFieldTotalGeral.setText(String.valueOf(df.format(totalizando)).replace(".", ","));
               
    }
    
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatoriosVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupVendas;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCarregando;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonRecebimento;
    private javax.swing.JRadioButton jRadioButtonVista;
    private javax.swing.JRadioButton jRadioCrediario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCartao;
    private javax.swing.JTextField jTextFieldEntradaPrazo;
    private javax.swing.JTextField jTextFieldRecebimento;
    private javax.swing.JTextField jTextFieldTotalGeral;
    private javax.swing.JTextField jTextFieldVista;
    private util.PrecoRender precoRender1;
    private javax.swing.JTable tabelaDetalhesV;
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
