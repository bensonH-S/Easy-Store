/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleBaixaParcela;
import controle.ControleBaixaParcelaCartao;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import modelo.ModeloBaixaParcela;
import modelo.ModeloBaixaParcelaCartao;


/**
 *
 * @author cyro
 */
public class FrmBaixaParcelaCartao extends javax.swing.JFrame {
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco c = new ConectaBanco();
    ModeloBaixaParcelaCartao mod = new ModeloBaixaParcelaCartao();
    ControleBaixaParcelaCartao control = new ControleBaixaParcelaCartao();
    
    DecimalFormat df = new DecimalFormat("0.00");
    Date atual = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    LocalDate dataPadrao;
    int cod_parcela, cod_venda, codCliente, comanda =0, idCaixa;
    float valor_parcela, valor_parcial, restante,valorParcialPago, valorRestante,valorpagoComInput;
    String bandeira, valorPagoI;
    Date dataVencimento;
    public FrmBaixaParcelaCartao(int cod) {
        initComponents();
        setIcon();
        valorAction();
        pagarAction();
        
        conecta.conexao();
        
        jLabelDataAtual.setText(sdf.format(atual));
        
       
        conecta.executaSQL("select * from parcela_cartao where id_parc_venda="+cod);
        jLabelCodigo.setText(String.valueOf(cod));
        try {
            conecta.rs.first();
            
            
            cod_venda = conecta.rs.getInt("cod_venda");
            valor_parcela = conecta.rs.getFloat("valor_parc");            
            
            dataVencimento = conecta.rs.getDate("datavenc");
            
            bandeira = conecta.rs.getString("bandeira");
            jTextFieldCodigoP.setText(String.valueOf(cod));
            jTextFieldNome.setText(bandeira);
            jTextFieldCodigoVenda.setText(String.valueOf(cod_venda));
            jTextFieldValorParcela.setText(String.valueOf(df.format(valor_parcela)).replace(".", ","));
            jTextFieldPagoInput.setText(String.valueOf(df.format(valor_parcela)).replace(".", ","));
            jTextFieldData.setText(String.valueOf(sdf.format(dataVencimento)));

        } catch (SQLException ex) {
            Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             conecta.desconecta();
            
            }
        
        c.conexao();
        
        jLabelDataAtual.setText(sdf.format(atual));
        
       
        c.executaSQL("select id_caixa  from caixa where status='aberto'");
        
        try {
            c.rs.first();
            
            idCaixa = c.rs.getInt("id_caixa");
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             c.desconecta();
            
            }
        
        jLabelCaixa.setText(String.valueOf(idCaixa));
    }

    private FrmBaixaParcelaCartao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void pagarAction(){
    
    InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0),"forward");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("forward", new AbstractAction(){
        private static final long serialVersionUID = 2L;
        public void actionPerformed(ActionEvent arg0) {
        //pagar();
        jButtonPagar.doClick();
    }
});
    
    }
    
    public void valorAction(){
    
    InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"pagar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("pagar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        public void actionPerformed(ActionEvent arg0) {
        //pagar();
        jButtonValorPago.doClick();
    }
});
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonPagar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelCaixa = new javax.swing.JLabel();
        jLabelDataAtual = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldValorParcela = new javax.swing.JTextField();
        jButtonValorPago = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPagoInput = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldCodigoP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCodigoVenda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 438));

        jButtonPagar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPagar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonPagar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonPagar.setText("Efetuar Recebimento (F12)");
        jButtonPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonPagar.setBorderPainted(false);
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 181, 181));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabelCodigo.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("jLabel2");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Parcela atual:");
        jLabel9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel9KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caixa aberto no momento:");

        jLabelCaixa.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelCaixa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCaixa.setText("Caixa");

        jLabelDataAtual.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelDataAtual.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataAtual.setText("Data atual");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabelDataAtual)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelDataAtual)
                    .addComponent(jLabelCaixa)
                    .addComponent(jLabel1)
                    .addComponent(jLabelCodigo))
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Valor da parcela:");

        jTextFieldValorParcela.setEditable(false);
        jTextFieldValorParcela.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldValorParcela.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldValorParcela.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldValorParcela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorParcela.setMinimumSize(new java.awt.Dimension(16, 60));

        jButtonValorPago.setBackground(new java.awt.Color(255, 255, 255));
        jButtonValorPago.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonValorPago.setForeground(new java.awt.Color(0, 153, 153));
        jButtonValorPago.setText("Valor a Ser Recebido (F10)");
        jButtonValorPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonValorPago.setBorderPainted(false);
        jButtonValorPago.setPreferredSize(new java.awt.Dimension(139, 40));
        jButtonValorPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorPagoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Valor a ser Recebido:");

        jTextFieldPagoInput.setEditable(false);
        jTextFieldPagoInput.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPagoInput.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldPagoInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldPagoInput.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldPagoInput.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jButtonValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPagoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPagoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jTextFieldCodigoP.setEditable(false);
        jTextFieldCodigoP.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigoP.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldCodigoP.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCodigoP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCodigoP.setMinimumSize(new java.awt.Dimension(20, 60));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Código parcela:");

        jTextFieldNome.setEditable(false);
        jTextFieldNome.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldNome.setMinimumSize(new java.awt.Dimension(16, 60));
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome da bandeira:");

        jTextFieldData.setEditable(false);
        jTextFieldData.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldData.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldData.setMinimumSize(new java.awt.Dimension(16, 60));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data de vencimento:");

        jTextFieldCodigoVenda.setEditable(false);
        jTextFieldCodigoVenda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigoVenda.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldCodigoVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCodigoVenda.setPreferredSize(new java.awt.Dimension(16, 60));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Código da venda:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    public void somaProduto(){
        float total = 0;
        conecta.conexao();
        
        conecta.executaSQL("select * from parcela_venda WHERE id_parc_venda="+cod_parcela);
        
        try {
           
            
            while(conecta.rs.next()){
                
               total = total + conecta.rs.getFloat("valor_parc") - conecta.rs.getFloat("valor_parcial");
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
        }finally{
            
             conecta.desconecta();
            
            }
    }
    

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        
        String message = "Deseja finalizar o Recebimento ?";
        String title = "Finalizar Recebimento";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);
         
        if(finalizar == JOptionPane.YES_OPTION){
        mod.setCodParc(Integer.parseInt(jTextFieldCodigoP.getText()));
        
        mod.setPago(Float.parseFloat(jTextFieldPagoInput.getText().replace(",", ".")));
        //mod.setDataatual(sdf.format(atual));
        mod.setIdCaixa(idCaixa);
        mod.setCodVenda(cod_venda);
        
        control.BaixarParcela(mod);
        FrmSelecionaCartao c = new FrmSelecionaCartao();
        c.setVisible(true);
        dispose();
        
        }else{
        
         JOptionPane.showMessageDialog(null,"Recebimento da Parcela Cancelado");
        
        }
        
        
        
        
    }//GEN-LAST:event_jButtonPagarActionPerformed
    public void limparCampos(){
    
     jTextFieldCodigoP.setText("");
     jTextFieldCodigoVenda.setText("");
     jTextFieldData.setText("");
     jTextFieldNome.setText("");
     jTextFieldPagoInput.setText("");
     jTextFieldValorParcela.setText("");
     
    
    }
    public void pagar(){
        mod.setCodParc(Integer.parseInt(jTextFieldCodigoP.getText()));
        
        mod.setPago(Float.parseFloat(jTextFieldPagoInput.getText()));
        //mod.setDataatual(sdf.format(atual));
        mod.setIdCaixa(idCaixa);
        mod.setCodVenda(cod_venda);
        
        control.BaixarParcela(mod);

        dispose();
    }
    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            
        comanda=1;
        if(comanda == 1){
        
        String nome;
        if(!jTextFieldNome.getText().equals("")){
        
        
        nome = jTextFieldNome.getText();
          }else{
          
            JOptionPane.showMessageDialog(rootPane, "Digite o Nome de um Cliente");
        
        }
            
        }
        
        comanda=1;
    }//GEN-LAST:event_jTextFieldNomeKeyPressed
    
    }
    private void jLabel9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel9KeyPressed
        
        
        
    }//GEN-LAST:event_jLabel9KeyPressed

    private void jButtonValorPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorPagoActionPerformed

        valorPagoI = JOptionPane.showInputDialog("Valor Recebido da Parcela");
        jTextFieldPagoInput.setText(valorPagoI);

    }//GEN-LAST:event_jButtonValorPagoActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBaixaParcelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBaixaParcelaCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonValorPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCaixa;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataAtual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextFieldCodigoP;
    private javax.swing.JTextField jTextFieldCodigoVenda;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPagoInput;
    private javax.swing.JTextField jTextFieldValorParcela;
    // End of variables declaration//GEN-END:variables

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
