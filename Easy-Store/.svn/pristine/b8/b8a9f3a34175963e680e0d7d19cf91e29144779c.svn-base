/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import buscacep.WebServiceCep;
import controle.ConectaBanco;
import controle.ControleDadosEmpresa;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import modelo.ModeloCnae;
import modelo.ModeloDadosEmpresa;
import modeloCnae.ModeloCnae;

/**
 *
 * @author Haurio
 */
public class FrmDadosEmpresa extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();
    ModeloDadosEmpresa mod = new ModeloDadosEmpresa();
    ControleDadosEmpresa control = new ControleDadosEmpresa();
    ModeloCnae busca = new ModeloCnae();
    String BuscaCnae;
    int flag=0;
    public FrmDadosEmpresa() {
        initComponents();
        setIcon();
        selecionaDados();
       
       
        
        jButtonCadastrar.setEnabled(true);
        jButtonAlterar.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        BloquearCampos();
        
    }
    public void selecionaDados(){
        
        conecta.conexao();
        
        try{
            
        conecta.executaSQL("select * from empresa ");
        jComboBoxUF.removeAllItems();
        jComboBoxCidade.removeAllItems();
        jComboBoxIDUF.removeAllItems();
        conecta.rs.first();
        jTextFieldNome.setText(conecta.rs.getString("nome"));
        jTextFieldFantasia.setText(conecta.rs.getString("nomefantasia"));
        jTextFieldCNPJ.setText(conecta.rs.getString("cnpj"));
        jTextFieldIE.setText(conecta.rs.getString("ie"));
        jTextFieldIM.setText(conecta.rs.getString("im"));
        jTextFieldCTR.setText(conecta.rs.getString("crt"));
        jTextFieldCnae.setText(conecta.rs.getString("cnae"));
        jTextFieldRA.setText(conecta.rs.getString("ra"));
        jTextFieldIBGE.setText(conecta.rs.getString("ibge"));
        jComboBoxCidade.addItem(conecta.rs.getString("cidade"));
        jComboBoxUF.addItem(conecta.rs.getString("uf"));
        jTextFieldCEP.setText(conecta.rs.getString("cep"));
        jTextFieldBairro.setText(conecta.rs.getString("bairro"));
        jTextFieldLogradouro.setText(conecta.rs.getString("rua"));
        jTextFieldTelefone.setText(conecta.rs.getString("telefone"));
        jTextFieldEmail.setText(conecta.rs.getString("email"));
        jComboBoxIDUF.addItem(conecta.rs.getString("cod_uf"));
        
        
       
        
        
        
        }catch(SQLException ex){
            
             //JOptionPane.showMessageDialog(null, "Não existem dados"+ ex);
            
        }
    }
    
    public void cadastrar(){
    if(!jTextFieldNome.getText().equals("")){
     
         mod.setNome(jTextFieldNome.getText());
         mod.setNomefantasia(jTextFieldFantasia.getText());
         mod.setCnpj(jTextFieldCNPJ.getText());
         mod.setIE(jTextFieldIE.getText());
         mod.setIM(jTextFieldIM.getText());
         mod.setCRT(jTextFieldCTR.getText());
         mod.setCNAE(jTextFieldCnae.getText());
         mod.setRA(jTextFieldRA.getText());
         mod.setIBGE(Integer.parseInt(jTextFieldIBGE.getText()));
         mod.setCidade((String)jComboBoxCidade.getSelectedItem());
         mod.setUF((String)jComboBoxUF.getSelectedItem());
         mod.setCod_UF((String)jComboBoxIDUF.getSelectedItem());
         mod.setCEP(jTextFieldCEP.getText());
         mod.setBairro(jTextFieldBairro.getText());
         mod.setRua(jTextFieldLogradouro.getText());
         mod.setTelefone(jTextFieldTelefone.getText());
         mod.setEmail(jTextFieldEmail.getText());
        
         control.cadastraDados(mod);
     
     }else{
         
         JOptionPane.showMessageDialog(null, "Preencha o campo nome");
         jTextFieldNome.requestFocus();
                 
    }
     }

    
    public void alterar(){
     if(!jTextFieldNome.getText().equals("")){
     
         mod.setNome(jTextFieldNome.getText());
         mod.setNomefantasia(jTextFieldFantasia.getText());
         mod.setCnpj(jTextFieldCNPJ.getText());
         mod.setIE(jTextFieldIE.getText());
         mod.setIM(jTextFieldIM.getText());
         mod.setCRT(jTextFieldCTR.getText());
         mod.setCNAE(jTextFieldCnae.getText());
         mod.setRA(jTextFieldRA.getText());
         mod.setIBGE(Integer.parseInt(jTextFieldIBGE.getText()));
         mod.setCidade((String)jComboBoxCidade.getSelectedItem());
         mod.setUF((String)jComboBoxUF.getSelectedItem());
         mod.setCod_UF((String)jComboBoxIDUF.getSelectedItem());
         mod.setCEP(jTextFieldCEP.getText());
         mod.setBairro(jTextFieldBairro.getText());
         mod.setRua(jTextFieldLogradouro.getText());
         mod.setTelefone(jTextFieldTelefone.getText());
         mod.setEmail(jTextFieldEmail.getText());
        
         control.AtualizarDados(mod);
     
     }else{
         
         JOptionPane.showMessageDialog(null, "Preencha o campo nome");
         jTextFieldNome.requestFocus();
                 
     
     }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonCadastrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFantasia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIE = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIM = new javax.swing.JTextField();
        jTextFieldCnae = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCTR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCNPJ = new javax.swing.JFormattedTextField();
        jTextFieldRA = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldCEP = new javax.swing.JFormattedTextField();
        jTextFieldTelefone = new javax.swing.JFormattedTextField();
        jTextFieldIBGE = new javax.swing.JTextField();
        jComboBoxUF = new javax.swing.JComboBox<>();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jComboBoxIDUF = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados da Empresa");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));

        jButtonCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCadastrar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonCadastrar.setText("Incluir dados da empresa");
        jButtonCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonCadastrar.setBorderPainted(false);
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome da empresa:");

        jTextFieldFantasia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldFantasia.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldFantasia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldFantasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFantasiaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da fantasia:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CNPJ");

        jTextFieldIE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIE.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldIE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("I.E:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Insc. Municipal:");

        jTextFieldIM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIM.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldIM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jTextFieldCnae.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCnae.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldCnae.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldCnae.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCnaeFocusLost(evt);
            }
        });
        jTextFieldCnae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnaeActionPerformed(evt);
            }
        });
        jTextFieldCnae.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCnaeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCnaeKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CNAE:");

        jTextFieldCTR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCTR.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldCTR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CRT:");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ramo de Atividade:");

        jTextFieldCNPJ.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jTextFieldCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldCNPJ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextFieldRA.setEditable(false);
        jTextFieldRA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldRA.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldRA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldRA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldRAFocusLost(evt);
            }
        });
        jTextFieldRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRAActionPerformed(evt);
            }
        });
        jTextFieldRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRAKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIE, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldIM, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldCTR, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldNome))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldCnae, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldRA)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIE, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnae, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCTR, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        jTextFieldLogradouro.setEditable(false);
        jTextFieldLogradouro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldLogradouro.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldLogradouro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Logradouro");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bairro:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cidade:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefone:");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("IBGE:");

        jTextFieldBairro.setEditable(false);
        jTextFieldBairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldBairro.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldBairro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBairroActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CEP:");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("UF:");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ID UF:");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("E-mail:");

        jTextFieldCEP.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldCEP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCEPFocusLost(evt);
            }
        });
        jTextFieldCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCEPActionPerformed(evt);
            }
        });

        jTextFieldTelefone.setForeground(new java.awt.Color(102, 102, 102));
        try {
            jTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)######-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextFieldIBGE.setEditable(false);
        jTextFieldIBGE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldIBGE.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldIBGE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldIBGE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIBGEFocusLost(evt);
            }
        });

        jComboBoxUF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxUF.setForeground(new java.awt.Color(102, 102, 102));
        jComboBoxUF.setEnabled(false);
        jComboBoxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUFActionPerformed(evt);
            }
        });

        jComboBoxCidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxCidade.setEnabled(false);
        jComboBoxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadeActionPerformed(evt);
            }
        });

        jComboBoxIDUF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxIDUF.setForeground(new java.awt.Color(102, 102, 102));
        jComboBoxIDUF.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldIBGE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxIDUF, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jTextFieldCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldBairro)
                    .addComponent(jTextFieldEmail)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel18))
                        .addGap(0, 309, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIBGE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxIDUF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cadastrar Dados da empresa");

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAlterar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonAlterar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonAlterar.setText("Alterar dados da empresa");
        jButtonAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonAlterar.setBorderPainted(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonSalvar.setBorderPainted(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
         
        HabilitarCampos();
        jButtonAlterar.setEnabled(false);
        jButtonCadastrar.setEnabled(false);
        jButtonSalvar.setEnabled(true);
        
       
        
       
        
        
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTextFieldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBairroActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
       flag=2;
        HabilitarCampos();
        jButtonAlterar.setEnabled(false);
        jButtonCadastrar.setEnabled(false);
        jButtonSalvar.setEnabled(true);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldCnaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCnaeActionPerformed
        conecta.conexao();
      conecta.executaSQL("SELECT * FROM cnae WHERE cnae LIKE '%" + jTextFieldCnae.getText()+"%' ORDER BY cnae ASC");
        try {
            conecta.rs.first();
            jTextFieldRA.removeAll();
            do{
                jTextFieldRA.setText(conecta.rs.getString("descricao"));
                } while (conecta.rs.next());
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Cnae Não encontrado!");
        }
    }//GEN-LAST:event_jTextFieldCnaeActionPerformed

    private void jTextFieldCnaeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCnaeKeyReleased

    }//GEN-LAST:event_jTextFieldCnaeKeyReleased

    private void jTextFieldCnaeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCnaeKeyPressed

    }//GEN-LAST:event_jTextFieldCnaeKeyPressed

    private void jTextFieldCnaeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCnaeFocusLost
     conecta.conexao();
      conecta.executaSQL("SELECT * FROM cnae WHERE cnae LIKE '%" + jTextFieldCnae.getText()+"%' ORDER BY cnae ASC");
        try {
            conecta.rs.first();
            jTextFieldRA.removeAll();
            do{
                jTextFieldRA.setText(conecta.rs.getString("descricao"));
                } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Cnae Não encontrado!");
        }
     
 
    }//GEN-LAST:event_jTextFieldCnaeFocusLost

    private void jTextFieldFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFantasiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFantasiaActionPerformed

    private void jTextFieldCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCEPFocusLost
        buscaCep();
    }//GEN-LAST:event_jTextFieldCEPFocusLost

    private void jTextFieldCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCEPActionPerformed
        buscaCep();
    }//GEN-LAST:event_jTextFieldCEPActionPerformed

    private void jTextFieldRAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldRAFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRAFocusLost

    private void jTextFieldRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRAActionPerformed

    private void jTextFieldRAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRAKeyPressed

    private void jTextFieldRAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRAKeyReleased

    private void jTextFieldIBGEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIBGEFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIBGEFocusLost

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
         if (jTextFieldNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo NOME  esta sem preenchimento!");
            jTextFieldNome.requestFocus();

        } else if (jTextFieldFantasia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo NOME FANTASIA sem preenchimento!");
            jTextFieldFantasia.requestFocus();

        } else if (jTextFieldCNPJ.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo CPF esta sem preenchimento!");
            jTextFieldCNPJ.requestFocus();

        } else if (jTextFieldIBGE.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEVE CLICAR ECIMA DO CAMPO CIDADE PARA PREENCHER O CAMPO IBGE!");
            jTextFieldIBGE.requestFocus();

       
        } else if (flag == 0) {

            cadastrar();
            jButtonSalvar.setEnabled(false);
        BloquearCampos();
        jButtonAlterar.setEnabled(true);
        jButtonCadastrar.setEnabled(true);
        jButtonSalvar.setEnabled(false);
            
        }else{
            alterar();
            jButtonSalvar.setEnabled(false);
        BloquearCampos();
        jButtonAlterar.setEnabled(true);
        jButtonCadastrar.setEnabled(true);
        jButtonSalvar.setEnabled(false);
            

    }                 
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jComboBoxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadeActionPerformed
       BuscaIBGE();
       BuscaIBGEUF();
    }//GEN-LAST:event_jComboBoxCidadeActionPerformed

    private void jComboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFActionPerformed
        
    }//GEN-LAST:event_jComboBoxUFActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDadosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDadosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDadosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDadosEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDadosEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JComboBox<String> jComboBoxIDUF;
    private javax.swing.JComboBox<String> jComboBoxUF;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JFormattedTextField jTextFieldCEP;
    private javax.swing.JFormattedTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldCTR;
    private javax.swing.JTextField jTextFieldCnae;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFantasia;
    private javax.swing.JTextField jTextFieldIBGE;
    private javax.swing.JTextField jTextFieldIE;
    private javax.swing.JTextField jTextFieldIM;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRA;
    private javax.swing.JFormattedTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

     public void BloquearCampos(){
                 
        jTextFieldNome.setEnabled(false);
        jTextFieldFantasia.setEnabled(false);
        jTextFieldCNPJ.setEnabled(false);
        jTextFieldIE.setEnabled(false);
        jTextFieldIM.setEnabled(false);
        jTextFieldCTR.setEnabled(false);
        jTextFieldCnae.setEnabled(false);
        jTextFieldCEP.setEnabled(false);;
        jTextFieldTelefone.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
             }
     
      public void HabilitarCampos(){
                 
        jTextFieldNome.setEnabled(true);
        jTextFieldFantasia.setEnabled(true);
        jTextFieldCNPJ.setEnabled(true);
        jTextFieldIE.setEnabled(true);
        jTextFieldIM.setEnabled(true);
        jTextFieldCTR.setEnabled(true);
        jTextFieldCnae.setEnabled(true);
        jTextFieldCEP.setEnabled(true);
        jTextFieldTelefone.setEnabled(true);
        jTextFieldEmail.setEnabled(true);
             }
      
            public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(jTextFieldCEP.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        
        jComboBoxCidade.removeAllItems();
        jComboBoxUF.removeAllItems();
        
        if (webServiceCep.wasSuccessful()) {
            jTextFieldLogradouro.setText(webServiceCep.getLogradouroFull());
            jComboBoxCidade.addItem(webServiceCep.getCidade());
            jTextFieldBairro.setText(webServiceCep.getBairro());
            jComboBoxUF.addItem(webServiceCep.getUf());
            System.out.println("Cep: " + webServiceCep.getCep());
            System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
            System.out.println("Bairro: " + webServiceCep.getBairro());
            System.out.println("Cidade: "
                    + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

            //caso haja problemas imprime as exce??es.
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
        }
    }

         
         public void BuscaIBGE(){
              conecta.conexao();
      conecta.executaSQL("SELECT * FROM cidades WHERE municipio LIKE '%" + jComboBoxCidade.getSelectedItem()+"%' ORDER BY municipio ASC");
        try {
            conecta.rs.first();
            
            
            do{
                jTextFieldIBGE.setText(conecta.rs.getString("codigo_ibge"));
               
                } while (conecta.rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmDadosEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         }
         
         
        public void BuscaIBGEUF(){
              conecta.conexao();
      conecta.executaSQL("SELECT * FROM cidades WHERE municipio LIKE '%" + jComboBoxCidade.getSelectedItem()+"%' ORDER BY municipio ASC");
        try {
            conecta.rs.first();
             jComboBoxIDUF.removeAllItems();
            
            do{
                
                jComboBoxIDUF.addItem(conecta.rs.getString("codigo_uf"));
                } while (conecta.rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmDadosEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         }
         
       
          
}
