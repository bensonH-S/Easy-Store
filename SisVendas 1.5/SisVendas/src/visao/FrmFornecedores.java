/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConectaBanco;
import controle.ControleFornecedor;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import modelo.ModeloFornecedor;
import modelo.ModeloTabela;
import modelo.NimbusClasse;

/**
 *
 * @author cyro
 */
public class FrmFornecedores extends javax.swing.JFrame {
            
    ConectaBanco conectaFor = new ConectaBanco();
    ModeloFornecedor mod = new ModeloFornecedor();
    ControleFornecedor control = new ControleFornecedor();
    
    int flag=1;
    /**
     * Creates new form FrmFornecdores
     */
    public FrmFornecedores() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        novoProduto();
        salvaProduto();
        EditaProduto();
        ExcluirProduto();
        Sair();
        
        preencherTabela("SELECT * FROM fornecedor ORDER BY nome_fornecedor DESC");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelCidade = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableForncedores = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCNPJ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEnd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelCity = new javax.swing.JLabel();
        jLabelState = new javax.swing.JLabel();
        jTextFieldIE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFantasia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCelular = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Cadastro de Fornecedores");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableForncedores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableForncedores.setForeground(new java.awt.Color(51, 51, 51));
        jTableForncedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableForncedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableForncedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableForncedores);

        jButtonNovo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonNovo.setForeground(new java.awt.Color(0, 153, 153));
        jButtonNovo.setText("Novo (F6)");
        jButtonNovo.setToolTipText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSalvar.setText("Salvar (F12)");
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonEditar.setText("Editar (F8)");
        jButtonEditar.setToolTipText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(0, 153, 153));
        jButtonExcluir.setText("Excluir (Del)");
        jButtonExcluir.setToolTipText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSair.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSair.setText("Sair (ESC)");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código:");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCodigo.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCodigo.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Razão Social:");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldNome.setEnabled(false);

        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldTelefone.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTelefone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldTelefone.setEnabled(false);
        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefone:");

        jTextFieldCNPJ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCNPJ.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCNPJ.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCNPJ.setEnabled(false);
        jTextFieldCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCNPJActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CNPJ:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Endereço:");

        jTextFieldEnd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldEnd.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldEnd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEnd.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bairro:");

        jLabelCity.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelCity.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCity.setText("Cidade: ");

        jLabelState.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabelState.setForeground(new java.awt.Color(255, 255, 255));
        jLabelState.setText("Estado:");

        jTextFieldIE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIE.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldIE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldIE.setEnabled(false);
        jTextFieldIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIEActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("I.E");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEmail.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Celular:");

        jTextFieldFantasia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldFantasia.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldFantasia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldFantasia.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nome Fantasia:");

        jTextFieldCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCelular.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldCelular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCelular.setEnabled(false);

        jTextFieldEstado.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldEstado.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldEstado.setEnabled(false);

        jTextFieldCidade.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldCidade.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldCidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCidade.setEnabled(false);

        jTextFieldBairro.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextFieldBairro.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldBairro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldBairro.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldEnd))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jTextFieldTelefone)
                                                    .addGap(42, 42, 42)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(232, 232, 232)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabelCity))))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldIE, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabelState)))
                                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIE, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabelCity)
                        .addComponent(jLabelState)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTextFieldPesquisa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldPesquisa.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldPesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCidade)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonEditar)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonExcluir)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldPesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSair))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCidade)
                            .addComponent(jLabelEstado))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        mod.setId(Integer.parseInt(jTextFieldCodigo.getText()));
//        mod.setNome(jTextFieldNome.getText());
//        mod.setEndereco(jTextFieldEnd.getText());
//        mod.setCnpj(jTextFieldCNPJ.getText());
//        mod.setBairro(jTextFieldBairro.getText());
//        mod.setCidade(jTextFieldCidade.getText());
//        mod.setEstado(jTextFieldEstado.getText());
//        mod.setTelefone(jTextFieldTelefone.getText());
//        mod.setCelular(jTextFieldCelular.getText());
//        mod.setNomeFantasia(jTextFieldFantasia.getText());
//        mod.setEmail(jTextFieldEmail.getText());
//        mod.setIe(jTextFieldIE.getText());
        
        control.Excluir(mod);
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

        mod.setId(Integer.parseInt(jTextFieldCodigo.getText()));
        mod.setNome(jTextFieldNome.getText());
        mod.setEndereco(jTextFieldEnd.getText());
        mod.setCnpj(jTextFieldCNPJ.getText());
        mod.setBairro(jTextFieldBairro.getText());
        mod.setCidade(jTextFieldCidade.getText());
        mod.setEstado(jTextFieldEstado.getText());
        mod.setTelefone(jTextFieldTelefone.getText());
        mod.setCelular(jTextFieldCelular.getText());
        mod.setEmail(jTextFieldEmail.getText());
        mod.setIe(jTextFieldIE.getText());
        mod.setNomeFantasia(jTextFieldFantasia.getText());
        control.Alterar(mod);
        jTextFieldNome.setEnabled(true);
        jTextFieldEnd.setEnabled(true);
        jTextFieldCNPJ.setEnabled(true);
        jTextFieldTelefone.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonEditar.setEnabled(false);

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        if(flag ==1)
        {
            mod.setNome(jTextFieldNome.getText());
            mod.setEndereco(jTextFieldEnd.getText());
            mod.setCnpj(jTextFieldCNPJ.getText());
            mod.setBairro(jTextFieldBairro.getText());
            mod.setCidade(jTextFieldCidade.getText());
            mod.setEstado(jTextFieldEstado.getText());
            mod.setTelefone(jTextFieldTelefone.getText());
            mod.setCelular(jTextFieldCelular.getText());
            mod.setEmail(jTextFieldEmail.getText());
            mod.setIe(jTextFieldIE.getText());
            mod.setNomeFantasia(jTextFieldFantasia.getText());
            control.Salvar(mod);
            LimparCamposFornecedores();
            preencherTabela("select * from fornecedor  IRDER BY nome_fornecedor");
            

        }else{
            flag =2;
            mod.setNome(jTextFieldNome.getText());
            mod.setEndereco(jTextFieldEnd.getText());
            mod.setCnpj(jTextFieldCNPJ.getText());
            mod.setBairro(jTextFieldBairro.getText());
            mod.setCidade(jTextFieldCidade.getText());
            mod.setEstado(jTextFieldEstado.getText());
            mod.setTelefone(jTextFieldTelefone.getText());
            control.Alterar(mod);
            LimparCamposFornecedores();
            //preencherTabela("select * from fornecedor inner join bairro on fornecedor.id_bairro=bairro.id_bairro");

        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        
        jTextFieldCNPJ.setEnabled(true);
        jTextFieldCodigo.setEnabled(true);
        jTextFieldEnd.setEnabled(true);
        jTextFieldBairro.setEnabled(true);
        jTextFieldCidade.setEnabled(true);
        jTextFieldEstado.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jTextFieldTelefone.setEnabled(true);
        jTextFieldEmail.setEnabled(true);
        jTextFieldIE.setEnabled(true);
        jTextFieldFantasia.setEnabled(true);
        jTextFieldCelular.setEnabled(true);
        jTextFieldTelefone.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jTextFieldNome.requestFocus();
        LimparCamposFornecedores();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextFieldCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCNPJActionPerformed

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jTextFieldIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIEActionPerformed

    private void jTableForncedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableForncedoresMouseClicked
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonNovo.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        habilitarCamposFornecedores();
        int index = (int) jTableForncedores.getValueAt(jTableForncedores.getSelectedRow(), 0);
        String bairro = (String) jTableForncedores.getValueAt(jTableForncedores.getSelectedRow(), 3);
        System.out.println("Bairro é "+ bairro);
        conectaFor.executaSQL("select * from fornecedor where id_fornecedor = "+index);
        try {
            conectaFor.rs.first();
            jTextFieldCodigo.setText(""+conectaFor.rs.getInt("id_fornecedor"));
            jTextFieldNome.setText(""+conectaFor.rs.getString("nome_fornecedor"));
            jTextFieldTelefone.setText(""+conectaFor.rs.getString("telefone"));
            jTextFieldCNPJ.setText(""+conectaFor.rs.getString("cnpj"));
            jTextFieldCelular.setText(""+conectaFor.rs.getString("celular"));
            jTextFieldEmail.setText(""+conectaFor.rs.getString("email"));
            jTextFieldIE.setText(""+conectaFor.rs.getString("ie"));
            jTextFieldFantasia.setText(""+conectaFor.rs.getString("nomefantasia"));
            jTextFieldEnd.setText(""+conectaFor.rs.getString("endereco_fornecedor"));
            jTextFieldBairro.setText(""+conectaFor.rs.getString("bairro"));
            jTextFieldCidade.setText(""+conectaFor.rs.getString("cidade"));
            jTextFieldEstado.setText(""+conectaFor.rs.getString("estado"));
        } catch (SQLException ex) {
            Logger.getLogger(FrmFornecedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableForncedoresMouseClicked

    private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
       conectaFor.conexao();
       try {
                 conectaFor.executaSQL("select * from fornecedor  where nome_fornecedor like'%"+jTextFieldPesquisa.getText()+"%'");
                 conectaFor.rs.first();
                 
                 preencherTabela("select * from fornecedor  where nome_fornecedor like'%"+jTextFieldPesquisa.getText()+"%'");

                
            } catch (SQLException ex) {
                
            }
    }//GEN-LAST:event_jTextFieldPesquisaKeyReleased
    
    
    
    
    public void LimparCamposFornecedores(){
        
        jTextFieldCodigo.setText("");
        jTextFieldNome.setText("");
        jTextFieldEnd.setText("");
        jTextFieldBairro.setText("");
        jTextFieldCidade.setText("");
        jTextFieldEstado.setText("");
        jTextFieldCNPJ.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldEmail.setText("");
        jTextFieldIE.setText("");
        jTextFieldCelular.setText("");
        jTextFieldFantasia.setText("");
        
        
    }
    public void habilitarCamposFornecedores(){
        
        
        jTextFieldNome.setEnabled(true);
        jTextFieldEnd.setEnabled(true);
        jTextFieldBairro.setEnabled(true);
        jTextFieldCidade.setEnabled(true);
        jTextFieldEstado.setEnabled(true);
        jTextFieldCNPJ.setEnabled(true);
        jTextFieldTelefone.setEnabled(true);
        jTextFieldEmail.setEnabled(true);
        jTextFieldIE.setEnabled(true);
        jTextFieldCelular.setEnabled(true);
        jTextFieldFantasia.setEnabled(true);
        
        
    }
    
    
    public void preencherTabela(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código","Nome Fornecedor", "Endereço", "Bairro","Telefone", "CNPJ","Celular","Email","Inscrição Estadual"};
        conectaFor.conexao();
        conectaFor.executaSQL("select * from fornecedor where nome_fornecedor like'%"+jTextFieldPesquisa.getText()+"%'");
        
        try {
            
            conectaFor.rs.first();
            
            do {                
                dados.add(new Object[]{conectaFor.rs.getInt("id_fornecedor"),conectaFor.rs.getString("nome_fornecedor"), conectaFor.rs.getString("endereco_fornecedor"), conectaFor.rs.getString("bairro"),conectaFor.rs.getString("telefone"), conectaFor.rs.getString("cnpj"),conectaFor.rs.getString("celular"),conectaFor.rs.getString("email"),conectaFor.rs.getString("ie")});
            } while (conectaFor.rs.next());
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR "+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        jTableForncedores.setModel(modelo);
        jTableForncedores.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableForncedores.getColumnModel().getColumn(0).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTableForncedores.getColumnModel().getColumn(1).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableForncedores.getColumnModel().getColumn(2).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(3).setPreferredWidth(160);
        jTableForncedores.getColumnModel().getColumn(3).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableForncedores.getColumnModel().getColumn(4).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableForncedores.getColumnModel().getColumn(5).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTableForncedores.getColumnModel().getColumn(6).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(7).setPreferredWidth(150);
        jTableForncedores.getColumnModel().getColumn(7).setResizable(false);
        jTableForncedores.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTableForncedores.getColumnModel().getColumn(8).setResizable(false);
        
        jTableForncedores.getTableHeader().setReorderingAllowed(false);
        jTableForncedores.setAutoResizeMode(jTableForncedores.AUTO_RESIZE_OFF);
        jTableForncedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableForncedores.setRowHeight(30);
        
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
            java.util.logging.Logger.getLogger(FrmFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFornecedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableForncedores;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEnd;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFantasia;
    private javax.swing.JTextField jTextFieldIE;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
    
    private void novoProduto() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"novo");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("novo", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonNovo.doClick();
                }
            });
    }

    private void salvaProduto() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0),"salvar");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("salvar", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonSalvar.doClick();
                }
            });   
    }
    
    private void EditaProduto() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0),"edita");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("edita", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonEditar.doClick();
                }
            });   
    }
    
    private void ExcluirProduto() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0),"exclui");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("exclui", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonExcluir.doClick();
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
