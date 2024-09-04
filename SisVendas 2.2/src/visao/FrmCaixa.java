/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleCaixa;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.ModeloCaixa;

/**
 *
 * @author cyro
 */
public class FrmCaixa extends javax.swing.JFrame {
    
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    ControleCaixa control = new ControleCaixa();
    DecimalFormat df = new DecimalFormat("0.00");
    Date hoje = new Date();
    String dataRec;
    int i=1,caixa;
    float entradaPrazo,entradaCartao, recebCartao,debitoCartao, abertura, vista, pago,despesa, totalGeral,saidaCaixa,PagamentoParcelas;
    private GregorianCalendar cal = new GregorianCalendar();
    
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat hm = new SimpleDateFormat("hh:mm");
    Date dataHora = new Date();
    
    
    
    public FrmCaixa() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jLabelHora.setText(hm.format(dataHora));
        salvaProduto();
        AtualizaCaixa();
        Sair();
        setIcon();
        conecta.conexao();
        conecta.executaSQL("select id_caixa from caixa where status='aberto'");
        try {
            conecta.rs.first();
            caixa = conecta.rs.getInt("id_caixa");
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        conecta.desconecta();
        }
        conecta.conexao();
        conecta.executaSQL("select sum(valor) as 'valores' from tbl_registrar_despesa where id_caixa='"+caixa+"'");
        try {
            conecta.rs.first();
            despesa = conecta.rs.getFloat("valores");
            jTextFieldDespesas.setText(String.valueOf(df.format(despesa)).replace(".", ","));
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
        }
        preencherComboCaixa();
        PagamentosParcelas();
        saidaDeCaixa();
        chamaVista();
        chamaRecebimento();
        entrada();
        entradaCartao();
        debitoCartao();
        recebimentoCartao();
        total();
        
        jLabelCaixa.setText(String.valueOf(caixa));
                
        jTextFieldAbertura.setText(String.valueOf(df.format(abertura)).replace(".", ","));
        
        try {
            
            MaskFormatter form = new MaskFormatter("##-##-####");
            jFormattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(form));
            
        } catch (Exception e) {
        }
        
        
        
        jFormattedTextFieldData.setText(format.format(hoje));
        //conecta.conexao();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupVendas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        totalRece = new javax.swing.JLabel();
        precoRender1 = new util.PrecoRender();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelCaixa = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEntradaPrazo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldVista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldRecebimento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotalGeral = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldAbertura = new javax.swing.JTextField();
        jLabelHora = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldDebito = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldTotalCartao = new javax.swing.JTextField();
        jTextFieldRecebimentoCartao = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldEntradaCartao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonFechaCaixa = new javax.swing.JButton();
        jTextFieldTotalCaixa = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jTextFieldFicaCaixa = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        valor6 = new javax.swing.JTextField();
        valor1 = new javax.swing.JTextField();
        valor2 = new javax.swing.JTextField();
        valor3 = new javax.swing.JTextField();
        valor4 = new javax.swing.JTextField();
        valor5 = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        moeda5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        moeda10 = new javax.swing.JTextField();
        moeda25 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        moeda50 = new javax.swing.JTextField();
        moeda1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTotalDinheiro = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldSaidas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldParcelas = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldTotalSaida = new javax.swing.JTextField();
        jTextFieldDespesas = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa");

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(894, 500));

        totalRece.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalRece.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 181, 181));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data de hoje :");

        jFormattedTextFieldData.setEditable(false);
        jFormattedTextFieldData.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jFormattedTextFieldData.setForeground(new java.awt.Color(51, 51, 51));
        jFormattedTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jFormattedTextFieldData.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jFormattedTextFieldDataInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Caixa aberto :");

        jLabelCaixa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCaixa.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabelCaixa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCaixa.setText("caixa");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Saldo de abertura:");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(942, 125));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Entradas a prazo:");

        jTextFieldEntradaPrazo.setEditable(false);
        jTextFieldEntradaPrazo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEntradaPrazo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldEntradaPrazo.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldEntradaPrazo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEntradaPrazo.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valores a vista:");

        jTextFieldVista.setEditable(false);
        jTextFieldVista.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldVista.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldVista.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldVista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldVista.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVistaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Recebimentos parcelas:");

        jTextFieldRecebimento.setEditable(false);
        jTextFieldRecebimento.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldRecebimento.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldRecebimento.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldRecebimento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldRecebimento.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total ");

        jTextFieldTotalGeral.setEditable(false);
        jTextFieldTotalGeral.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalGeral.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalGeral.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalGeral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldEntradaPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVista, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEntradaPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldVista, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("A vista e Crediário:");

        jTextFieldAbertura.setEditable(false);
        jTextFieldAbertura.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAbertura.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jTextFieldAbertura.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldAbertura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabelHora.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHora.setText("jLabel32");

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));
        jPanel7.setPreferredSize(new java.awt.Dimension(942, 125));

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Vendas no débito:");

        jTextFieldDebito.setEditable(false);
        jTextFieldDebito.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDebito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDebito.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldDebito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldDebito.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Total:");

        jTextFieldTotalCartao.setEditable(false);
        jTextFieldTotalCartao.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalCartao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalCartao.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalCartao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jTextFieldRecebimentoCartao.setEditable(false);
        jTextFieldRecebimentoCartao.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldRecebimentoCartao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldRecebimentoCartao.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldRecebimentoCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Recebimento de parcelas:");

        jTextFieldEntradaCartao.setEditable(false);
        jTextFieldEntradaCartao.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEntradaCartao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldEntradaCartao.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldEntradaCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEntradaCartao.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vendas no crédito:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEntradaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRecebimentoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldTotalCartao)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldEntradaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addGap(6, 6, 6)
                            .addComponent(jTextFieldRecebimentoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTotalCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cartão:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelCaixa)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel23))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabelCaixa)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(7, 7, 7)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));
        jPanel4.setPreferredSize(new java.awt.Dimension(942, 125));

        jButtonFechaCaixa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFechaCaixa.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButtonFechaCaixa.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFechaCaixa.setText("Finalizar Caixa (F12)");
        jButtonFechaCaixa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonFechaCaixa.setBorderPainted(false);
        jButtonFechaCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFechaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechaCaixaActionPerformed(evt);
            }
        });

        jTextFieldTotalCaixa.setEditable(false);
        jTextFieldTotalCaixa.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalCaixa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldTotalCaixa.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalCaixa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldTotalCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalCaixaActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSair.setText("Sair do Caixa (ESC)");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAtualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAtualizar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonAtualizar.setText("Atualizar Dados (F5)");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jTextFieldFicaCaixa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldFicaCaixa.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldFicaCaixa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFicaCaixa.setText("0,00");
        jTextFieldFicaCaixa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldFicaCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFicaCaixaFocusGained(evt);
            }
        });
        jTextFieldFicaCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFicaCaixaKeyPressed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Fica no Caixa:");

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Total geral no caixa :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButtonFechaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotalCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldFicaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonFechaCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldFicaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTotalCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(62, 62, 62))))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cédulas de R$ 50:");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cédulas de R$ 100:");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cédulas de R$ 10:");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cédulas de R$ 20:");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cédulas de R$ 5:");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cédulas de R$ 2 :");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("TOTAL");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Contagem de Cédulas e Moedas do Caixa:");

        valor6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor6.setText("0");
        valor6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor6FocusLost(evt);
            }
        });

        valor1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor1.setText("0");
        valor1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor1FocusLost(evt);
            }
        });

        valor2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor2.setText("0");
        valor2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor2FocusLost(evt);
            }
        });

        valor3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor3.setText("0");
        valor3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor3FocusLost(evt);
            }
        });

        valor4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor4.setText("0");
        valor4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor4FocusLost(evt);
            }
        });

        valor5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor5.setText("0");
        valor5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        valor5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valor5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor5FocusLost(evt);
            }
        });

        total.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        total.setForeground(new java.awt.Color(51, 51, 51));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        moeda5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        moeda5.setText("0");
        moeda5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        moeda5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moeda5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moeda5FocusLost(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Moeda de R$0,05:");

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Moeda de R$ 0,10:");

        moeda10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        moeda10.setText("0");
        moeda10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        moeda10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moeda10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moeda10FocusLost(evt);
            }
        });

        moeda25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        moeda25.setText("0");
        moeda25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        moeda25.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moeda25FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moeda25FocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Moeda de R$ 0,25:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Moeda de  R$ 0,50:");

        moeda50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        moeda50.setText("0");
        moeda50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        moeda50.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moeda50FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moeda50FocusLost(evt);
            }
        });

        moeda1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        moeda1.setText("0");
        moeda1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        moeda1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moeda1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                moeda1FocusLost(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Moeda de R$ 1:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total em dinheiro caixa :");

        jTextFieldTotalDinheiro.setEditable(false);
        jTextFieldTotalDinheiro.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalDinheiro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextFieldTotalDinheiro.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalDinheiro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalDinheiro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(148, 148, 148))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(moeda50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(moeda1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(valor4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(valor3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(valor2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(valor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(valor5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(valor6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(moeda25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel26)
                                                .addComponent(jLabel27))
                                            .addGap(14, 14, 14)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(moeda10)
                                                .addComponent(moeda5)))))
                                .addGap(4, 4, 4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTotalDinheiro)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(total))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(valor1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(valor2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(valor3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(valor4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(valor5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(valor6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(moeda1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(moeda50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(moeda25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(moeda10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(moeda5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTotalDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pagamentos a vista:");

        jTextFieldSaidas.setEditable(false);
        jTextFieldSaidas.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSaidas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldSaidas.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldSaidas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldSaidas.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pagamentos de parcelas:");

        jTextFieldParcelas.setEditable(false);
        jTextFieldParcelas.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldParcelas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldParcelas.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldParcelas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total das saídas do caixa:");

        jTextFieldTotalSaida.setEditable(false);
        jTextFieldTotalSaida.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotalSaida.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTotalSaida.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalSaida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jTextFieldDespesas.setEditable(false);
        jTextFieldDespesas.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDespesas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldDespesas.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldDespesas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Total de despesas do caixa:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jTextFieldDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextFieldTotalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTotalSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Fechamento de caixa:");

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Saidas do Caixa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2))
                                    .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22))))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(precoRender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(totalRece, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       
               conecta.conexao();
               
            try {
                String data = jFormattedTextFieldData.getText();
                conecta.executaSQL("select valor_venda from tbl_entrada_venda where data_venda='"+data+"'");
                if(conecta.rs.next()){
                   
                    
                    ativarValores();
                    somaProduto();
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null,"Não Existe Registro para essa Data");
                    
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
             conecta.desconecta();
            
            }
                    
       
              
        }
    }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed

    private void jButtonFechaCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechaCaixaActionPerformed
        
        fechaCaixa();
        
        
    }//GEN-LAST:event_jButtonFechaCaixaActionPerformed
    public void fechaCaixa(){
        
        String message = "Deseja Fechar o Caixa ?";
        String title = "Fechar Caixa";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);
         
        if(finalizar == JOptionPane.YES_OPTION){
            if(!jTextFieldFicaCaixa.getText().equals("0,00")){
            ModeloCaixa mod = new ModeloCaixa();
            mod.setTotalCaixa(Float.parseFloat(jTextFieldTotalCaixa.getText().replace(",", ".")));
            mod.setIdCaixa(Integer.parseInt(jLabelCaixa.getText()));
            mod.setHoraFechar(String.valueOf(jLabelHora.getText()));
            mod.setDataFechamento(jFormattedTextFieldData.getText());
            
            mod.setSaldoFinal(Float.parseFloat(jTextFieldFicaCaixa.getText()));
            control.Atualizar(mod);
            dispose();
        
            }else{
        
            JOptionPane.showMessageDialog(null, "Preencha o valor que vai ficar no Caixa");
            jTextFieldFicaCaixa.requestFocus();
        
            }
        }else{
        
        JOptionPane.showMessageDialog(null, "Caixa não Fechado");
        
        }
    }
    public void CalcularCedulas(){
        DecimalFormat dff = new DecimalFormat("0.00");
        int valor100 = Integer.parseInt(valor1.getText())* 100;
        int valor50 = Integer.parseInt(valor2.getText())* 50;
        int valor20 = Integer.parseInt(valor3.getText())* 20;
        int valor10 = Integer.parseInt(valor4.getText())* 10;
        int valor05 = Integer.parseInt(valor5.getText())* 5;
        int valor02 = Integer.parseInt(valor6.getText())* 2;
             
        float resultado = valor100 + valor50 + valor20 + valor10 + valor05 + valor02;
        
        float moeda1Real = (float) (Float.parseFloat(moeda1.getText())* 1); 
        float moeda50Real = (float) (Float.parseFloat(moeda50.getText())* 0.50);
        float moeda25Real = (float) (Float.parseFloat(moeda25.getText())* 0.25);
        float moeda10Real = (float)(Float.parseFloat(moeda10.getText())* 0.10);
        float moeda5Real = (float) (Float.parseFloat(moeda5.getText())* 0.05);
        float resultadoMoedas = moeda1Real + moeda50Real + moeda25Real + moeda10Real + moeda5Real;
        float totalGeral = resultado + resultadoMoedas;
        total.setText(String.valueOf(dff.format(totalGeral)));
    }
    private void jTextFieldVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVistaActionPerformed

    private void jFormattedTextFieldDataInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataInputMethodTextChanged
        JOptionPane.showMessageDialog(null,"Mudou");
    }//GEN-LAST:event_jFormattedTextFieldDataInputMethodTextChanged

    private void moeda1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda1FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_moeda1FocusLost

    private void moeda1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda1FocusGained
        moeda1.selectAll();
    }//GEN-LAST:event_moeda1FocusGained

    private void moeda50FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda50FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_moeda50FocusLost

    private void moeda50FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda50FocusGained
        moeda50.selectAll();
    }//GEN-LAST:event_moeda50FocusGained

    private void moeda25FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda25FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_moeda25FocusLost

    private void moeda25FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda25FocusGained
        moeda25.selectAll();
    }//GEN-LAST:event_moeda25FocusGained

    private void moeda10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda10FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_moeda10FocusLost

    private void moeda10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda10FocusGained
        moeda10.selectAll();
    }//GEN-LAST:event_moeda10FocusGained

    private void moeda5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda5FocusLost
        CalcularCedulas();
        
    }//GEN-LAST:event_moeda5FocusLost

    private void moeda5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moeda5FocusGained
        moeda5.selectAll();
    }//GEN-LAST:event_moeda5FocusGained

    private void valor5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor5FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_valor5FocusLost

    private void valor5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor5FocusGained
        valor5.selectAll();
    }//GEN-LAST:event_valor5FocusGained

    private void valor4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor4FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_valor4FocusLost

    private void valor4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor4FocusGained
        valor4.selectAll();
    }//GEN-LAST:event_valor4FocusGained

    private void valor3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor3FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_valor3FocusLost

    private void valor3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor3FocusGained
        valor3.selectAll();
    }//GEN-LAST:event_valor3FocusGained

    private void valor2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor2FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_valor2FocusLost

    private void valor2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor2FocusGained
        valor2.selectAll();
    }//GEN-LAST:event_valor2FocusGained

    private void valor1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor1FocusLost
        CalcularCedulas();
    }//GEN-LAST:event_valor1FocusLost

    private void valor1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor1FocusGained
        valor1.selectAll();
    }//GEN-LAST:event_valor1FocusGained

    private void valor6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor6FocusLost
        CalcularCedulas();

    }//GEN-LAST:event_valor6FocusLost

    private void valor6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor6FocusGained
        valor6.selectAll();
    }//GEN-LAST:event_valor6FocusGained

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        this.dispose();
        new FrmCaixa().setVisible(true);
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextFieldFicaCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFicaCaixaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            fechaCaixa();
        }
    }//GEN-LAST:event_jTextFieldFicaCaixaKeyPressed

    private void jTextFieldFicaCaixaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFicaCaixaFocusGained
        jTextFieldFicaCaixa.selectAll();
    }//GEN-LAST:event_jTextFieldFicaCaixaFocusGained

    private void jTextFieldTotalCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalCaixaActionPerformed
    
    public void ativarValores(){
        
        jTextFieldVista.setVisible(true);
        
    }
    public void preencherComboCaixa(){
    
    conecta.conexao();
    conecta.executaSQL("select id_caixa, saldo_inicial from caixa where status='aberto' order by id_caixa desc");
    
        try {
            conecta.rs.last();
            
                
                abertura = conecta.rs.getFloat("saldo_inicial");
                
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
    
        
    }
    
    
    public void somaProduto(){
        
        
        vista = 0;
        entradaPrazo = 0;
        conecta.conexao();
        conecta.executaSQL("select tv.id_caixa, tv.id_venda, tv.valor_venda, tv.data_venda from tbl_entrada_venda tv inner join venda v on tv.id_venda = v.id_venda  where tv.data_venda='"+dataRec+"'");
        
        try {
            
            while(conecta.rs.next()){
               vista = vista + conecta.rs.getFloat("valor_venda");
                
            }
              jTextFieldVista.setText(String.valueOf(df.format(vista)).replace(".", ","));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }
    
    public void somaPrazo(){
        
        
        pago = 0;
        conecta.conexao();
        conecta.executaSQL("select id_caixa, id_venda, valor_pago from tbl_entrada_crediario  where id_caixa='"+caixa+"'");
        
        try {
           
            
            while(conecta.rs.next()){
                
               
               pago = pago + conecta.rs.getFloat("valor_pago");
               
                
            }
            
            jTextFieldRecebimento.setText(String.valueOf(df.format(pago)).replace(".", ","));
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }
    public void saidaDeCaixa(){
        
        conecta.conexao();
        
        conecta.executaSQL("select valor_saida from tbl_saida where id_caixa ='"+caixa+"'");
        
        try {
            
            
            if(conecta.rs.next()){
             conecta.rs.first();   
                do {                    
                    
                    saidaCaixa = saidaCaixa + conecta.rs.getFloat("valor_saida");
                } while (conecta.rs.next());
             jTextFieldSaidas.setText(String.valueOf(df.format(saidaCaixa)).replace(".", ","));   
            }else{
            
                jTextFieldSaidas.setText("0,00");
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
        
        
    }
    public void PagamentosParcelas(){
        
        conecta.conexao();
        
        conecta.executaSQL("select valor_pago from tbl_saida_crediario where id_caixa ='"+caixa+"'");
        
        try {
            
            
            if(conecta.rs.next()){
             conecta.rs.first();   
                do {                    
                    
                    PagamentoParcelas = PagamentoParcelas + conecta.rs.getFloat("valor_pago");
                } while (conecta.rs.next());
             jTextFieldParcelas.setText(String.valueOf(df.format(PagamentoParcelas)).replace(".", ","));   
            }else{
            
                jTextFieldParcelas.setText("0,00");
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
        
        
    }
    private void chamaVista() {
        conecta.conexao();
        conecta.executaSQL("select valor_venda from tbl_entrada_venda where id_caixa='"+caixa+"'");
        try {
            
            if(conecta.rs.next()){
            
            conecta.rs.first();
            do{
            vista = vista + conecta.rs.getFloat("valor_venda");
            }while(conecta.rs.next());
            jTextFieldVista.setText(String.valueOf(df.format(vista)).replace(".", ","));
            }else{
            
             jTextFieldVista.setText("0,00");
             
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }
    private void chamaRecebimento() {
        conecta.conexao();
        conecta.executaSQL("select valor_pago from tbl_entrada_crediario where id_caixa='"+caixa+"'");
        try {
            
            if(conecta.rs.next()){
            
                conecta.rs.first();
            do{
            pago = pago + conecta.rs.getFloat("valor_pago");
            }while(conecta.rs.next());
            jTextFieldRecebimento.setText(String.valueOf(df.format(pago)).replace(".", ","));
            
            }else{
            
               jTextFieldRecebimento.setText("0,00");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }
    
    public void total(){
        float totalCaixa = 0;
        float totalSaida = 0;
        float totalCartao = 0;
        float totalDinheiro = 0;
        
        totalCartao = entradaCartao + recebCartao + debitoCartao;
        float totalizando = entradaPrazo + pago + vista;
        
        jTextFieldTotalGeral.setText(String.valueOf(df.format(totalizando)).replace(".", ","));
        totalSaida = saidaCaixa + despesa + PagamentoParcelas;
        jTextFieldTotalSaida.setText(String.valueOf(df.format(totalSaida)));
        totalCaixa = (abertura + totalizando+totalCartao) - totalSaida;
        totalDinheiro = (totalizando + abertura)- totalSaida;
        jTextFieldTotalCaixa.setText(String.valueOf(df.format(totalCaixa)).replace(".", ","));
        jTextFieldTotalCartao.setText(String.valueOf(df.format(totalCartao)).replace(".",","));
        jTextFieldTotalDinheiro.setText(String.valueOf(df.format(totalDinheiro)).replace(".",","));
    }
    
    public void entrada(){
        c.conexao();
        
        c.executaSQL("select sum(valor_entrada) as 'entrada'  from tbl_entrada where id_caixa='"+caixa+"'");
        try {
               if(c.rs.next()){
               
                   c.rs.first();
                
               do{
                
                entradaPrazo = c.rs.getFloat("entrada");
                
               }
                
                while(c.rs.next());
                jTextFieldEntradaPrazo.setText(String.valueOf(df.format(entradaPrazo)).replace(".", ","));
               
               }else{
               
               jTextFieldEntradaPrazo.setText("0,00");
               
               }
               
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao selecionar entrada");
        }finally{
        
        c.desconecta();
        }
        }
    public void entradaCartao(){
        c.conexao();
        
        c.executaSQL("select sum(entrada_cartao) as 'entrada'  from tbl_cartao where id_caixa='"+caixa+"'");
        try {
               if(c.rs.next()){
               
                   c.rs.first();
                
               do{
                
                entradaCartao = c.rs.getFloat("entrada");
                
               }
                
                while(c.rs.next());
                jTextFieldEntradaCartao.setText(String.valueOf(df.format(entradaCartao)).replace(".", ","));
               
               }else{
               
               jTextFieldEntradaCartao.setText("0,00");
               
               }
               
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao selecionar entrada");
        }finally{
        
        c.desconecta();
        
        }
        }
    public void debitoCartao(){
        c.conexao();
        
        c.executaSQL("select sum(valor_venda) as 'entrada'  from tbl_cartao_debito where id_caixa='"+caixa+"'");
        try {
               if(c.rs.next()){
               
                   c.rs.first();
                
               do{
                
                debitoCartao = c.rs.getFloat("entrada");
                
               }
                
                while(c.rs.next());
                jTextFieldDebito.setText(String.valueOf(df.format(debitoCartao)).replace(".", ","));
               
               }else{
               
               jTextFieldDebito.setText("0,00");
               
               }
               
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao selecionar entrada");
        }finally{
        
        c.desconecta();
        }
        }
    public void recebimentoCartao(){
        c.conexao();
        
        c.executaSQL("select sum(valor_pago) as 'entrada'  from tbl_entrada_cartao where id_caixa='"+caixa+"'");
        try {
               if(c.rs.next()){
               
                   c.rs.first();
                
               do{
                
                recebCartao = c.rs.getFloat("entrada");
                
               }
                
                while(c.rs.next());
                jTextFieldRecebimentoCartao.setText(String.valueOf(df.format(recebCartao)).replace(".", ","));
               
               }else{
               
               jTextFieldRecebimentoCartao.setText("0,00");
               
               }
               
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao selecionar entrada");
        }finally{
            
             c.desconecta();
            
            }
        }
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupVendas;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonFechaCaixa;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCaixa;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextFieldAbertura;
    private javax.swing.JTextField jTextFieldDebito;
    private javax.swing.JTextField jTextFieldDespesas;
    private javax.swing.JTextField jTextFieldEntradaCartao;
    private javax.swing.JTextField jTextFieldEntradaPrazo;
    private javax.swing.JTextField jTextFieldFicaCaixa;
    private javax.swing.JTextField jTextFieldParcelas;
    private javax.swing.JTextField jTextFieldRecebimento;
    private javax.swing.JTextField jTextFieldRecebimentoCartao;
    private javax.swing.JTextField jTextFieldSaidas;
    private javax.swing.JTextField jTextFieldTotalCaixa;
    private javax.swing.JTextField jTextFieldTotalCartao;
    private javax.swing.JTextField jTextFieldTotalDinheiro;
    private javax.swing.JTextField jTextFieldTotalGeral;
    private javax.swing.JTextField jTextFieldTotalSaida;
    private javax.swing.JTextField jTextFieldVista;
    private javax.swing.JTextField moeda1;
    private javax.swing.JTextField moeda10;
    private javax.swing.JTextField moeda25;
    private javax.swing.JTextField moeda5;
    private javax.swing.JTextField moeda50;
    private util.PrecoRender precoRender1;
    private javax.swing.JTextField total;
    private javax.swing.JLabel totalRece;
    private javax.swing.JTextField valor1;
    private javax.swing.JTextField valor2;
    private javax.swing.JTextField valor3;
    private javax.swing.JTextField valor4;
    private javax.swing.JTextField valor5;
    private javax.swing.JTextField valor6;
    // End of variables declaration//GEN-END:variables
    

    private void salvaProduto() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0),"salvar");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("salvar", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonFechaCaixa.doClick();
                }
            });   
    }
    
    
    
    private void AtualizaCaixa() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),"exclui");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("exclui", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonAtualizar.doClick();
                }
            });   
    }
    
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
