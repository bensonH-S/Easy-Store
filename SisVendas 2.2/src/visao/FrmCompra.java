
package visao;

import controle.ConectaBanco;
import controle.ControleCompra;
import controle.ControleVenda;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import modelo.ModeloCompra;
import modelo.ModeloLogin;
import modelo.ModeloProduto;
import modelo.ModeloTabela;
import modelo.ModeloTabelaProduto;
import modelo.ModeloVenda;
import modelo.NimbusClasse;

/**
 *
 * @author cyro
 */
public class FrmCompra extends javax.swing.JFrame {
    private ModeloTabelaProduto modeloProduto = new ModeloTabelaProduto();
    ConectaBanco conecta = new ConectaBanco();
    ModeloCompra mod = new ModeloCompra();
    ModeloLogin modlogin = new ModeloLogin();
    ModeloProduto modP = new ModeloProduto();
    ControleCompra control = new ControleCompra();
    DecimalFormat df = new DecimalFormat("0.00");
    NimbusClasse n = new NimbusClasse();
    ModeloTabela modelo;
    DefaultListModel modelList;
    
    int codCompra,barras, codProd,caixaId, enter =0;
    float preco_produto, total,valorComDesconto;
    String resultado, caixa, nome, nomePro;
    private FrmSelecionaProduto selecionaProduto;
    private FrmSelecionaFornecedor selecionaFornecedor;
    
    String name = modlogin.getUser();
    
    public FrmCompra(String name) {
        initComponents();
        setIcon();
        procuraProdutos();
        pesquisaFornecedor();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        this.selecionaProduto = new FrmSelecionaProduto();
        this.selecionaFornecedor = new FrmSelecionaFornecedor();
        jLabelUsuario.setText(name);
        modelList = new DefaultListModel();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        
        jTextFieldDataCompra.setText(df.format(hoje));
        jTextFieldDesconto.setText("0,00");
        jTextFieldDesconto.setVisible(false);
        
        jLabelDescontoReais.setVisible(false);
        conecta.conexao();
        
        
        
        try {
            conecta.executaSQL("SELECT id_caixa, status FROM caixa WHERE status = 'aberto'");
            conecta.rs.last();
            caixaId = conecta.rs.getInt("id_caixa");
            lblIdCaixa.setText(String.valueOf(caixaId));
            caixa = conecta.rs.getString("status");
            
            System.out.println("Id Caixa : "+caixaId +" Status"+ caixa);
            if(caixa.equals("aberto")){
            
                
               
            }else{
               JOptionPane.showMessageDialog(rootPane,"Caixa fechado,abra o caixa para iniciar a Compra");
               dispose();
               
               FrmAbrirCaixa t = new FrmAbrirCaixa();
               t.setVisible(true);
               
               
               
          }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao Preencher Caixa" +ex);
        }
        conecta.desconecta();
        conecta.conexao();
                
                PreparedStatement pst;
                try {
                    pst = conecta.conn.prepareStatement("INSERT INTO compras(total_nota, status) VALUES(?,?)");
                    pst.setFloat(1, 0);
                    pst.setString(2, "iniciada");
                    pst.execute();
                    conecta.executaSQL("SELECT  * FROM compras");
                    conecta.rs.last();
                    codCompra = conecta.rs.getInt("id_compra");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao abrir Compra:  "+ ex);
                }
                
                vendaAVista();
                vendaCrediario();
                vendaCartao();
             
        
        
        
 }

    private FrmCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ListadePesquisa(){
    
    conecta.conexao();
        try {
            conecta.executaSQL("SELECT * FROM produto WHERE nome_produto like '"+jTextFieldProduto.getText()+"%' ORDER BY nome_produto");
            modelList.removeAllElements();
            int v = 0;
            while(conecta.rs.next() & v < 4){
              modelList.addElement(conecta.rs.getString("nome_produto"));
              int estoque = conecta.rs.getInt("quantidade");
//              float precoCompra = conecta.rs.getFloat("preco_compra");
//              float precoVenda = conecta.rs.getFloat("preco_venda");
//              jLabelEstoque.setText(String.valueOf(estoque));
//              jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
//              jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));
              v++;
              
              
                
            } 
            
            resultadoPesquisa();
        
        } catch (SQLException ex) {
            Logger.getLogger(FrmCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void resultadoPesquisa(){    
       conecta.conexao();
       
        try {
            conecta.rs.first();
            jTextFieldProduto.setText(nomePro);
            jTextFieldProduto.setText(conecta.rs.getString("nome_produto"));
            //jTextFieldProduto.selectAll();
            
//            preco_produto = conecta.rs.getFloat("preco_venda");
//            
//            String nPrecoProduto = df.format(preco_produto).replace(".",",");
            
//            jTextFieldValorPorItem.setText(String.valueOf(nPrecoProduto));
            jTextFieldQuantidade.setText("1");
//            int estoque = conecta.rs.getInt("quantidade");
//            float precoCompra = conecta.rs.getFloat("preco_compra");
//            float precoVenda = conecta.rs.getFloat("preco_venda");
//            jLabelEstoque.setText(String.valueOf(estoque));
//            jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
//            jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Erro ao Inserir Dados Produtos"+ex);
        }
     
    
    }
//    public void mostraPesquisa(){
//     conecta.conexao();
//     
//     
//     
//     conecta.executaSQL("SELECT * FROM produto WHERE nome_produto like '"+jTextFieldProduto.getText()+"%'");
//     resultadoPesquisa();
//     
//     
//    
//    
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTextFieldNumeroNota = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldDesconto = new javax.swing.JTextField();
        lblIdCaixa = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelDesconto = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelDescontoReais = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelEstoque1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldDataVenda3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabelNovaQuantidade = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabelEstoque = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorPorItem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPrecoVenda = new javax.swing.JTextField();
        jTextFieldTotalProdutos = new javax.swing.JTextField();
        jTextFieldValorTotalGeral = new javax.swing.JTextField();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jTextFieldDataCompra = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaItensVenda = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonCancelarCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonDesconto = new javax.swing.JButton();
        jButtonFinalizarCartao = new javax.swing.JButton();
        jButtonFinalizarCrediario = new javax.swing.JButton();
        jTextFieldLucro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMargem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Fornecedor = new javax.swing.JTextField();
        jButtonFornecedor = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("formulário de Compras");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 181, 181));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setForeground(new java.awt.Color(0, 181, 181));
        jPanel1.setPreferredSize(new java.awt.Dimension(1186, 706));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pesquisar Produto por Nome ( F6 ) por Código ou Código de Barras:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 490, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Itens da Venda:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(11, 198, 111, 17);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1186, 690));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jPanel1.add(jLayeredPane1);
        jLayeredPane1.setBounds(-10, 0, 44, 345);

        jTextFieldNumeroNota.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTextFieldNumeroNota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNumeroNota.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldNumeroNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroNotaFocusGained(evt);
            }
        });
        jPanel1.add(jTextFieldNumeroNota);
        jTextFieldNumeroNota.setBounds(500, 570, 170, 42);

        jPanel2.setBackground(new java.awt.Color(0, 181, 181));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setForeground(new java.awt.Color(0, 181, 181));
        jPanel2.setPreferredSize(new java.awt.Dimension(1186, 706));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pesquisar Produto por Nome ( F6 ) por Código ou Código de Barras:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 10, 490, 17);

        jTextFieldDesconto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextFieldDesconto.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDesconto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldDesconto.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldDesconto.setEnabled(false);
        jTextFieldDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDescontoFocusGained(evt);
            }
        });
        jTextFieldDesconto.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldDescontoInputMethodTextChanged(evt);
            }
        });
        jPanel2.add(jTextFieldDesconto);
        jTextFieldDesconto.setBounds(10, 540, 227, 83);

        lblIdCaixa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblIdCaixa.setForeground(new java.awt.Color(255, 255, 255));
        lblIdCaixa.setText("caixa");
        jPanel2.add(lblIdCaixa);
        lblIdCaixa.setBounds(130, 650, 92, 29);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Itens da Venda:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(11, 198, 111, 17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Data da Emissão:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(300, 550, 140, 17);

        jLabelDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDesconto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesconto.setText("Desconto:");
        jPanel2.add(jLabelDesconto);
        jLabelDesconto.setBounds(10, 520, 70, 17);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Produtos:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(1030, 520, 120, 17);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("R$");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(1230, 520, 22, 20);

        jLabelDescontoReais.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelDescontoReais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDescontoReais.setText("R$");
        jPanel2.add(jLabelDescontoReais);
        jLabelDescontoReais.setBounds(210, 520, 22, 20);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Estoque Atual:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(11, 148, 114, 18);

        jLabelEstoque1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelEstoque1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelEstoque1);
        jLabelEstoque1.setBounds(86, 148, 36, 18);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("R$");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(1230, 600, 22, 20);

        jLayeredPane2.setMaximumSize(new java.awt.Dimension(1186, 690));

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jPanel2.add(jLayeredPane2);
        jLayeredPane2.setBounds(-10, 0, 44, 345);

        jLabelUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Vendedor");
        jPanel2.add(jLabelUsuario);
        jLabelUsuario.setBounds(1050, 0, 220, 30);

        jTextFieldDataVenda3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTextFieldDataVenda3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDataVenda3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldDataVenda3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataVenda3FocusGained(evt);
            }
        });
        jPanel2.add(jTextFieldDataVenda3);
        jTextFieldDataVenda3.setBounds(500, 570, 170, 42);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Número da Nota Fiscal:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(500, 550, 170, 17);

        jLabelNovaQuantidade.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelNovaQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNovaQuantidade.setText("000");
        jPanel2.add(jLabelNovaQuantidade);
        jLabelNovaQuantidade.setBounds(420, 150, 40, 18);

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Quantidade Comprada:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(230, 150, 190, 18);

        jLabelEstoque.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelEstoque);
        jLabelEstoque.setBounds(130, 150, 36, 18);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total da Nota:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(1030, 590, 104, 20);

        jTextFieldProduto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextFieldProduto.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldProdutoFocusLost(evt);
            }
        });
        jTextFieldProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProdutoActionPerformed(evt);
            }
        });
        jTextFieldProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldProdutoKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldProduto);
        jTextFieldProduto.setBounds(10, 30, 1020, 95);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(1030, 450, 85, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Por Item:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(1030, 160, 107, 17);

        jTextFieldValorPorItem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldValorPorItem.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldValorPorItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorPorItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorPorItem.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldValorPorItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldValorPorItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValorPorItemFocusLost(evt);
            }
        });
        jTextFieldValorPorItem.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldValorPorItemCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldValorPorItemInputMethodTextChanged(evt);
            }
        });
        jPanel2.add(jTextFieldValorPorItem);
        jTextFieldValorPorItem.setBounds(1030, 180, 227, 39);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("R$");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(1230, 160, 22, 20);

        jTextFieldPrecoVenda.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldPrecoVenda.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldPrecoVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrecoVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldPrecoVenda.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecoVendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPrecoVendaFocusLost(evt);
            }
        });
        jTextFieldPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoVendaActionPerformed(evt);
            }
        });
        jTextFieldPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoVendaKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldPrecoVenda);
        jTextFieldPrecoVenda.setBounds(1030, 260, 227, 39);

        jTextFieldTotalProdutos.setEditable(false);
        jTextFieldTotalProdutos.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldTotalProdutos.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldTotalProdutos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalProdutos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldTotalProdutos.setCaretColor(new java.awt.Color(0, 153, 153));
        jPanel2.add(jTextFieldTotalProdutos);
        jTextFieldTotalProdutos.setBounds(1030, 540, 227, 39);

        jTextFieldValorTotalGeral.setEditable(false);
        jTextFieldValorTotalGeral.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jTextFieldValorTotalGeral.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldValorTotalGeral.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorTotalGeral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorTotalGeral.setCaretColor(new java.awt.Color(0, 153, 153));
        jPanel2.add(jTextFieldValorTotalGeral);
        jTextFieldValorTotalGeral.setBounds(1030, 610, 227, 50);

        jButtonFinalizarVenda.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFinalizarVenda.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonFinalizarVenda.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFinalizarVenda.setText("Compra à Vista - F12");
        jButtonFinalizarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonFinalizarVenda.setBorderPainted(false);
        jButtonFinalizarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonFinalizarVenda);
        jButtonFinalizarVenda.setBounds(820, 670, 154, 40);

        jTextFieldDataCompra.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTextFieldDataCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDataCompra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldDataCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataCompraFocusGained(evt);
            }
        });
        jPanel2.add(jTextFieldDataCompra);
        jTextFieldDataCompra.setBounds(300, 570, 170, 42);

        TabelaItensVenda.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        TabelaItensVenda.setForeground(new java.awt.Color(51, 51, 51));
        TabelaItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaItensVenda.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(TabelaItensVenda);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 220, 910, 243);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modificar Preço de Venda:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1030, 240, 190, 17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("R$");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(1230, 240, 22, 20);

        jTextFieldQuantidade.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldQuantidade.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldQuantidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldQuantidade.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldQuantidadeFocusGained(evt);
            }
        });
        jTextFieldQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeActionPerformed(evt);
            }
        });
        jTextFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldQuantidade);
        jTextFieldQuantidade.setBounds(1030, 470, 227, 39);

        jButtonPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesquisar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonPesquisar.setText("Pesquisar Produto - F6");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPesquisar);
        jButtonPesquisar.setBounds(1050, 30, 200, 90);

        jButtonCancelarCompra.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelarCompra.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonCancelarCompra.setForeground(new java.awt.Color(0, 153, 153));
        jButtonCancelarCompra.setText("Cancelar Venda");
        jButtonCancelarCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonCancelarCompra.setBorderPainted(false);
        jButtonCancelarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCompraActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancelarCompra);
        jButtonCancelarCompra.setBounds(1030, 670, 224, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caixa Número:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 650, 106, 30);

        jButtonDesconto.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDesconto.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonDesconto.setForeground(new java.awt.Color(0, 153, 153));
        jButtonDesconto.setText("Desconto");
        jButtonDesconto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonDesconto.setBorderPainted(false);
        jButtonDesconto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescontoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDesconto);
        jButtonDesconto.setBounds(300, 670, 160, 40);

        jButtonFinalizarCartao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFinalizarCartao.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonFinalizarCartao.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFinalizarCartao.setText("Cartão  - F10");
        jButtonFinalizarCartao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonFinalizarCartao.setBorderPainted(false);
        jButtonFinalizarCartao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinalizarCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarCartaoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonFinalizarCartao);
        jButtonFinalizarCartao.setBounds(480, 670, 154, 40);

        jButtonFinalizarCrediario.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFinalizarCrediario.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonFinalizarCrediario.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFinalizarCrediario.setText("Crediário - F11");
        jButtonFinalizarCrediario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonFinalizarCrediario.setBorderPainted(false);
        jButtonFinalizarCrediario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinalizarCrediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarCrediarioActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonFinalizarCrediario);
        jButtonFinalizarCrediario.setBounds(650, 670, 145, 40);

        jTextFieldLucro.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldLucro.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldLucro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldLucro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldLucro.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldLucro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLucroFocusGained(evt);
            }
        });
        jTextFieldLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLucroActionPerformed(evt);
            }
        });
        jTextFieldLucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLucroKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldLucro);
        jTextFieldLucro.setBounds(1030, 330, 227, 39);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lucro:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(1030, 310, 44, 17);

        jTextFieldMargem.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldMargem.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldMargem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMargem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldMargem.setCaretColor(new java.awt.Color(0, 153, 153));
        jTextFieldMargem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMargemFocusGained(evt);
            }
        });
        jTextFieldMargem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMargemActionPerformed(evt);
            }
        });
        jTextFieldMargem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMargemKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldMargem);
        jTextFieldMargem.setBounds(1030, 400, 227, 39);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Margem bruta %");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(1030, 380, 130, 17);

        Fornecedor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Fornecedor.setForeground(new java.awt.Color(102, 102, 102));
        Fornecedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jPanel2.add(Fornecedor);
        Fornecedor.setBounds(470, 140, 290, 40);

        jButtonFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFornecedor.setFont(new java.awt.Font("Verdana", 1, 8)); // NOI18N
        jButtonFornecedor.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFornecedor.setText("Pesquisar fornecedor(F4)");
        jButtonFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFornecedorActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonFornecedor);
        jButtonFornecedor.setBounds(770, 140, 150, 40);

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove.png"))); // NOI18N
        jButtonRemover.setToolTipText("Remover Item");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoverMouseClicked(evt);
            }
        });
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRemover);
        jButtonRemover.setBounds(870, 470, 50, 42);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1280, 720);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F12){

            JOptionPane.showMessageDialog(null,"F12");
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jTextFieldNumeroNotaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroNotaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroNotaFocusGained

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

        conecta.conexao();

        int k = TabelaItensVenda.getSelectedRow();
        int id = (int)TabelaItensVenda.getValueAt(k, 0);
        int quantidade = (int) TabelaItensVenda.getValueAt(k, 3);
        int totalEstoque = (int) TabelaItensVenda.getValueAt(k, 6);
        System.out.println("Id do Produto é "+ id);
        System.out.println("Quantidade é "+ quantidade);
        int TotalEstoqueR =  totalEstoque - quantidade;
        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("DELETE FROM itens_compra_produto WHERE id_produto='"+id+"'");
            //pst.setInt(1, modP.getIdProduto());
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade = ? WHERE id_produto = '"+id+"'");
            pst.setInt(1, TotalEstoqueR);
            pst.execute();
            int modelRowIndex = TabelaItensVenda.convertRowIndexToModel(TabelaItensVenda.getSelectedRow());

            modelo = (ModeloTabela)TabelaItensVenda.getModel();
            TabelaItensVenda.clearSelection();
            modelo.removeRow(modelRowIndex);

            somaProduto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir"+ ex);
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoverMouseClicked

    }//GEN-LAST:event_jButtonRemoverMouseClicked

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jButtonFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFornecedorActionPerformed
        FrmSelecionaFornecedorCompra f = new FrmSelecionaFornecedorCompra(this.Fornecedor);
        f.setVisible(true);
    }//GEN-LAST:event_jButtonFornecedorActionPerformed

    private void jTextFieldMargemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMargemKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMargemKeyPressed

    private void jTextFieldMargemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMargemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMargemActionPerformed

    private void jTextFieldMargemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMargemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMargemFocusGained

    private void jTextFieldLucroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLucroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLucroKeyPressed

    private void jTextFieldLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLucroActionPerformed

    private void jTextFieldLucroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLucroFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLucroFocusGained

    private void jButtonFinalizarCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarCrediarioActionPerformed

        String message = "Deseja Parcelar a Compra ?";
        String title = "Parcelar Compra";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);

        if(finalizar == JOptionPane.YES_OPTION){
            float valorTotal = Float.parseFloat(jTextFieldTotalProdutos.getText().replace(",","."));
            if(!jTextFieldTotalProdutos.getText().isEmpty()){

                mod.setIdCompra(codCompra);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setDescont(Float.parseFloat(jTextFieldDesconto.getText().replace(",", ".")));
                mod.setNumeroNota(Integer.parseInt(jTextFieldNumeroNota.getText()));
                mod.setFornecedor(Fornecedor.getText());
                mod.setTotalProdutos(Float.parseFloat(jTextFieldTotalProdutos.getText().replace(",", ".")));
                mod.setTotalNota(Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", ".")));
                mod.setDataEmissao(new Date(jTextFieldDataCompra.getText()));
                valorComDesconto = Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", "."));

                if(jTextFieldDesconto.getText().equals("0,00")){
                    mod.setTotalNota(valorTotal);
                    jTextFieldTotalProdutos.setText(String.valueOf(df.format(valorTotal)).replace(".", ","));

                }else{

                    mod.setTotalNota(valorComDesconto);
                    jTextFieldTotalProdutos.setText(String.valueOf(valorComDesconto));

                }

                mod.setIdCompra(codCompra);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setTotalNota(valorTotal);
                mod.setTipoPagamento("Crediario");
                control.fechaCompra(mod);
                JOptionPane.showMessageDialog(null,"Formulário de Parcelamento");
                FrmEntradaCompra parc = new FrmEntradaCompra(codCompra);
                parc.setVisible(true);

                dispose();

            }

        }else{

            JOptionPane.showMessageDialog(null,"Compra Não Finalizada" );

        }
    }//GEN-LAST:event_jButtonFinalizarCrediarioActionPerformed

    private void jButtonFinalizarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarCartaoActionPerformed
        String message = "Deseja Realizar Compra no Cartão?";
        String title = "Compra no Cartão";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);

        if(finalizar == JOptionPane.YES_OPTION){
            float valorTotal = Float.parseFloat(jTextFieldTotalProdutos.getText().replace(",","."));
            if(!jTextFieldTotalProdutos.getText().isEmpty()){

                mod.setIdCompra(codCompra);
                //mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());

                if(jTextFieldDesconto.getText().equals("0,00")){
                    mod.setTotalNota(valorTotal);
                    jTextFieldTotalProdutos.setText(String.valueOf(df.format(valorTotal)).replace(".", ","));

                }else{

                    mod.setTotalNota(valorComDesconto);
                    jTextFieldTotalProdutos.setText(String.valueOf(valorComDesconto));

                }

                mod.setIdCompra(codCompra);
                //mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setTotalNota(valorTotal);
                mod.setTipoPagamento("Cartao");
                control.fechaCompra(mod);
                JOptionPane.showMessageDialog(null,"Abrir Formulário de Cartão");
                FrmCartao parc = new FrmCartao(codCompra);
                parc.setVisible(true);

                dispose();

            }

        }else{

            JOptionPane.showMessageDialog(null,"Compra Não Finalizada" );

        }

        //        String valorTotal = jTextFieldValorTotalGeral.getText().replace(",",".");
        //        if(jComboBoxPagamento.getSelectedItem().equals("Dinheiro")){
            //
            //
            //            mod.setIdVenda(codVenda);
            //            //mod.setData(jTextFieldDataVenda.getText());
            //            mod.setIdCaixa(caixaId);
            //
            //            valorComDesconto = Float.parseFloat(valorTotal) - Float.parseFloat(jTextFieldDesconto.getText());
            //
            //            if(jTextFieldDesconto.getText().equals("0.00")){
                //                //String valorTotal = jTextFieldValorTotalGeral.getText().replace(",",".");
                //
                //                mod.setValorVenda(Float.parseFloat(valorTotal));
                //                jTextFieldValorTotalGeral.setText(String.valueOf(df.format(total)).replace(".", ","));
                //                jTextFieldValorTotalGeral.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));
                //            }else{
                //
                //                mod.setValorVenda(valorComDesconto);
                //                jTextFieldValorTotalGeral.setText(String.valueOf(valorComDesconto));
                //
                //            }
            //
            //            mod.setPagamento((String)jComboBoxPagamento.getSelectedItem());
            //
            //            control.fechaVenda(mod);
            //            if(mod.getPagamento().equals("Dinheiro")){
                //
                //                JOptionPane.showMessageDialog(rootPane,"Venda à Vista Realizada com Sucesso");
                //
                //            }else{
                //
                //             JOptionPane.showMessageDialog(rootPane,"Abrir janela de Parcelamento");
                //
                //            }
            //            dispose();
            //
            //        }else{
            //
            //            mod.setIdVenda(codVenda);
            //            //mod.setData(jTextFieldDataVenda.getText());
            //            mod.setIdCaixa(caixaId);
            //            mod.setValorVenda(Float.parseFloat(valorTotal));
            //            mod.setPagamento((String)jComboBoxPagamento.getSelectedItem());
            //            control.fechaVenda(mod);
            //            FrmEntrada parc = new FrmEntrada(codVenda);
            //            parc.setVisible(true);
            //            dispose();
            //
            //        }
    }//GEN-LAST:event_jButtonFinalizarCartaoActionPerformed

    private void jButtonDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescontoActionPerformed
        jTextFieldDesconto.setVisible(true);
        jLabelDesconto.setVisible(true);
        jLabelDescontoReais.setVisible(true);
        jTextFieldDesconto.setEnabled(true);

        resultado = JOptionPane.showInputDialog("Digite um Desconto em %");

        float totalGeral = Float.parseFloat(jTextFieldTotalProdutos.getText().replace(",","."));
        System.out.println(totalGeral);
        float percentagem = Float.parseFloat(resultado)/100;
        System.out.println(percentagem);
        float totalDesconto = percentagem * totalGeral;
        System.out.println(totalDesconto);
        jTextFieldDesconto.setText(String.valueOf(df.format(totalDesconto)).replace(".", ","));
        jTextFieldValorTotalGeral.setText(String.valueOf(df.format(totalGeral - totalDesconto).replace(".", ",")));
    }//GEN-LAST:event_jButtonDescontoActionPerformed

    private void jButtonCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCompraActionPerformed

        String message = "Deseja Cancelar a Compra ?";
        String title = "Cancelamento de  Compra";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);

        if(finalizar == JOptionPane.YES_OPTION){

            control.cancelaCompra();

            dispose();
            TelaPrincipal tela = new TelaPrincipal(modlogin.getUser());

        }else{

            JOptionPane.showMessageDialog(null,"Compra Não Cancelada");

        }
    }//GEN-LAST:event_jButtonCancelarCompraActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed

        FrmSelecionaProduto produto = new FrmSelecionaProduto(this.jTextFieldProduto);
        produto.setVisible(true);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){

            try {

                int quantidade;
                float precoCompra, precoVenda;
                conecta.conexao();
                conecta.executaSQL("SELECT * FROM produto WHERE nome_produto = '"+jTextFieldProduto.getText()+"'");

                conecta.rs.first();
                int novaQuantidade = Integer.parseInt(jTextFieldQuantidade.getText());
                quantidade = conecta.rs.getInt("quantidade");
                precoCompra = Float.parseFloat(jTextFieldValorPorItem.getText().replace(",", "."));
                precoVenda = Float.parseFloat(jTextFieldPrecoVenda.getText().replace(",", "."));
                System.out.println("Quantidade do Banco "+ quantidade);
                System.out.println("Preço de Compra"+precoCompra);

                if(!jTextFieldQuantidade.getText().isEmpty()){
                    mod.setNomeProduto((String)jTextFieldProduto.getText());
                    mod.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
                    mod.setPrecoCompra(precoCompra);
                    mod.setPrecoVenda(precoVenda);
                    mod.setIdCompra(codCompra);
                    mod.setLucrovenda(Float.parseFloat(jTextFieldLucro.getText().replace(",", ".")));
                    mod.setLucroesperado(Float.parseFloat(jTextFieldMargem.getText().replace(",", ".")));
                    control.adicionaItem(mod);
                    preencherTabelaItensVenda("SELECT * FROM produto INNER JOIN itens_compra_produto ON produto.id_produto = itens_compra_produto.id_produto INNER JOIN compras ON compras.id_compra = itens_compra_produto.id_compra WHERE compras.id_compra ="+codCompra);
                    jTextFieldProduto.requestFocus();
                    jTextFieldProduto.selectAll();
                    jTextFieldProduto.setText("");
                    jLabelNovaQuantidade.setText(String.valueOf(novaQuantidade));

                }else{

                    JOptionPane.showMessageDialog(rootPane,"Quantidade desejada não disponivel no estoque");

                }

            } catch (SQLException ex) {
                Logger.getLogger(FrmCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jTextFieldQuantidadeKeyPressed

    private void jTextFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeActionPerformed

    private void jTextFieldQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeFocusGained
        jTextFieldQuantidade.selectAll();
    }//GEN-LAST:event_jTextFieldQuantidadeFocusGained

    private void jTextFieldDataCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataCompraFocusGained
        somaProduto();
    }//GEN-LAST:event_jTextFieldDataCompraFocusGained

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed
        if(jTextFieldNumeroNota.getText().equals("") && Fornecedor.getText().equals("")){

            JOptionPane.showMessageDialog(null,"Preencher com o Numero da Nota ou Fornecedor");
            jTextFieldNumeroNota.requestFocus();
        }else{

            String message = "Deseja finalizar a Compra ?";
            String title = "Finalizar Compra";
            int finalizar = JOptionPane.showConfirmDialog(this, message, title ,JOptionPane.YES_OPTION);

            if(finalizar == JOptionPane.YES_OPTION){
                String valorTotal = jTextFieldTotalProdutos.getText().replace(",",".");
                if(!jTextFieldTotalProdutos.getText().isEmpty()){

                    mod.setIdCompra(codCompra);
                    mod.setVendedor(jLabelUsuario.getText());
                    mod.setIdCaixa(caixaId);
                    mod.setDescont(Float.parseFloat(jTextFieldDesconto.getText().replace(",", ".")));
                    mod.setNumeroNota(Integer.parseInt(jTextFieldNumeroNota.getText()));
                    mod.setFornecedor(Fornecedor.getText());
                    mod.setTotalProdutos(Float.parseFloat(jTextFieldTotalProdutos.getText().replace(",", ".")));
                    mod.setTotalNota(Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", ".")));
                    mod.setDataEmissao(new Date(jTextFieldDataCompra.getText()));
                    valorComDesconto = Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", "."));

                    if(jTextFieldDesconto.getText().equals("0,00")){
                        //String valorTotal = jTextFieldValorTotalGeral.getText().replace(",",".");

                        mod.setTotalNota(Float.parseFloat(valorTotal));
                        jTextFieldTotalProdutos.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));
                        jTextFieldValorTotalGeral.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));
                    }else{

                        mod.setTotalNota(valorComDesconto);
                        jTextFieldTotalProdutos.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));

                    }

                    mod.setTipoPagamento("Dinheiro");

                    control.fechaCompra(mod);

                    JOptionPane.showMessageDialog(rootPane,"Compra à Vista Realizada com Sucesso ");

                    dispose();

                }else{

                    JOptionPane.showMessageDialog(null,"Compra Não Realizada");

                }

            }else{

                JOptionPane.showMessageDialog(null,"Compra não Finalizada" );

            }

        }

    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed

    private void jTextFieldPrecoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoVendaKeyPressed

    }//GEN-LAST:event_jTextFieldPrecoVendaKeyPressed

    private void jTextFieldPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoVendaActionPerformed

    private void jTextFieldPrecoVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoVendaFocusLost

        float precoCompra = Float.parseFloat(jTextFieldValorPorItem.getText().replace(",", "."));

        float precoVenda = Float.parseFloat(jTextFieldPrecoVenda.getText().replace(",", "."));
        float lucro = precoVenda - precoCompra;
        float p = (lucro / precoVenda)  * 100;

        String pcf = df.format(p);
        jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
        jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));
        jTextFieldMargem.setText(String.valueOf(pcf));
        jTextFieldLucro.setText(String.valueOf(df.format(lucro)));
        jTextFieldQuantidade.requestFocus();
    }//GEN-LAST:event_jTextFieldPrecoVendaFocusLost

    private void jTextFieldPrecoVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoVendaFocusGained
        jTextFieldPrecoVenda.selectAll();
    }//GEN-LAST:event_jTextFieldPrecoVendaFocusGained

    private void jTextFieldValorPorItemInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldValorPorItemInputMethodTextChanged

    private void jTextFieldValorPorItemCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemCaretPositionChanged
        somaProduto();
    }//GEN-LAST:event_jTextFieldValorPorItemCaretPositionChanged

    private void jTextFieldValorPorItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemFocusLost
        jTextFieldPrecoVenda.requestFocus();
    }//GEN-LAST:event_jTextFieldValorPorItemFocusLost

    private void jTextFieldValorPorItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemFocusGained
        jTextFieldValorPorItem.selectAll();
        somaProduto();
    }//GEN-LAST:event_jTextFieldValorPorItemFocusGained

    private void jTextFieldProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutoKeyReleased
        if(jTextFieldProduto.getText().length() >=13){
            conecta.conexao();

            try {
                conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+jTextFieldProduto.getText()+"' OR nome_produto='"+jTextFieldProduto.getText()+"' OR codigobarras = '"+jTextFieldProduto.getText()+"'");
                modelList.removeAllElements();
                int v = 0;
                while(conecta.rs.next() & v < 7){
                    modelList.addElement(conecta.rs.getString("nome_produto"));
                    int estoque = conecta.rs.getInt("quantidade");
                    float precoCompra = conecta.rs.getFloat("preco_compra");
                    float precoVenda = conecta.rs.getFloat("preco_venda");
                    jLabelEstoque.setText(String.valueOf(estoque));
                    jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
                    jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));
                    v++;

                }

                resultadoPesquisa();

            } catch (SQLException ex) {
                //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTextFieldValorPorItem.requestFocus();
            jTextFieldValorPorItem.selectAll();

            //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");

        }else{

            //JOptionPane.showMessageDialog(rootPane,"Selecione um Produto");

        }

        //        if(enter == 0){
            //
            //       ListadePesquisa();
            //
            //       }else{
            //
            //          enter = 0;
            //
            //       }
    }//GEN-LAST:event_jTextFieldProdutoKeyReleased

    private void jTextFieldProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutoKeyPressed
        //        if(evt.getKeyCode()== KeyEvent.VK_F6){
            //
            //            this.selecionaProduto.setVisible(true);
            //
            //            nomePro = this.selecionaProduto.getNomeProduto();
            //
            //        }
        //               if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            //
            //                        if(!jTextFieldProduto.getText().equals("")){
                //                                conecta.conexao();
                //                        try {
                    //                                conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+jTextFieldProduto.getText()+"' OR nome_produto='"+jTextFieldProduto.getText()+"'");
                    //                                modelList.removeAllElements();
                    //                                int v = 0;
                    //                                while(conecta.rs.next() & v < 7){
                        //                                      modelList.addElement(conecta.rs.getString("nome_produto"));
                        //                                      int estoque = conecta.rs.getInt("quantidade");
                        //                                      float precoCompra = conecta.rs.getFloat("preco_compra");
                        //                                      float precoVenda = conecta.rs.getFloat("preco_venda");
                        //                                      jLabelEstoque.setText(String.valueOf(estoque));
                        //                                      jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
                        //                                      jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));
                        //
                        //                                      v++;
                        //
                        //                                    }
                    //
                    //                                resultadoPesquisa();
                    //
                    //                            } catch (SQLException ex) {
                    //                                //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
                    //                            }
                //
                //                                jTextFieldValorPorItem.requestFocus();
                //                                jTextFieldValorPorItem.selectAll();
                //
                //
                //                                //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");
                //
                //                            }else{
                //
                //                                JOptionPane.showMessageDialog(rootPane,"Selecione um Produto");
                //
                //                            }
            //                  }
    }//GEN-LAST:event_jTextFieldProdutoKeyPressed

    private void jTextFieldProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdutoActionPerformed

        if(!jTextFieldProduto.getText().equals("")){
            conecta.conexao();
            try {
                conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+jTextFieldProduto.getText()+"' OR nome_produto='"+jTextFieldProduto.getText()+"' OR codigobarras = '"+jTextFieldProduto.getText()+"'");
                modelList.removeAllElements();
                int v = 0;
                while(conecta.rs.next() & v < 7){
                    modelList.addElement(conecta.rs.getString("nome_produto"));
                    int estoque = conecta.rs.getInt("quantidade");
                    float precoCompra = conecta.rs.getFloat("preco_compra");
                    float precoVenda = conecta.rs.getFloat("preco_venda");
                    jLabelEstoque.setText(String.valueOf(estoque));
                    jTextFieldValorPorItem.setText(String.valueOf(df.format(precoCompra)));
                    jTextFieldPrecoVenda.setText(String.valueOf(df.format(precoVenda)));

                    v++;

                }

                resultadoPesquisa();

            } catch (SQLException ex) {
                //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTextFieldValorPorItem.requestFocus();
            jTextFieldValorPorItem.selectAll();

            //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");

        }else{

            JOptionPane.showMessageDialog(rootPane,"Selecione um Produto");

        }

        //enter =1;
    }//GEN-LAST:event_jTextFieldProdutoActionPerformed

    private void jTextFieldProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProdutoFocusLost

    }//GEN-LAST:event_jTextFieldProdutoFocusLost

    private void jTextFieldProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProdutoFocusGained

        //        if(jTextFieldProduto.getText()!= null)
        //        {
            //
            //            try {
                //
                //                this.jTextFieldProduto.setText(String.valueOf(this.selecionaProduto.getNomeProduto()));
                //                conecta.conexao();
                //                conecta.executaSQL("SELECT * FROM produto WHERE nome_produto='"+jTextFieldProduto.getText()+"'");
                //
                //                int i=0;
                //                while(conecta.rs.next() & i<7){
                    //                    this.jTextFieldProduto.setText(conecta.rs.getString("nome_produto"));
                    //                    i++;
                    //
                    //                }
                //
                //                resultadoPesquisa();
                //
                //                jTextFieldProduto.selectAll();
                //
                //            } catch (SQLException ex) {
                //                Logger.getLogger(FrmCompra.class.getName()).log(Level.SEVERE, null, ex);
                //            }
            //        }
    }//GEN-LAST:event_jTextFieldProdutoFocusGained

    private void jTextFieldDataVenda3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataVenda3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataVenda3FocusGained

    private void jTextFieldDescontoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldDescontoInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescontoInputMethodTextChanged

    private void jTextFieldDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescontoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescontoFocusGained
    
        
    public void descontoEvento(java.awt.event.KeyEvent evt) {                                   
        if(evt.getKeyCode() == KeyEvent.VK_F10){
             
            resultado = JOptionPane.showInputDialog("Digite o valor do desconto");
        
            }else{
        
                JOptionPane.showInputDialog("Digite o valor do desconto");
        }
    }  
    
    public void preencherTabelaItensVenda(String SQL){
        
        ArrayList dados = new ArrayList();
        
        String[] Colunas = new String[]{"Código","Descrição", "Preco de Compra","Quantidade","Preço de Venda","Valor Total","Estoque","Lucro venda", "Margem Bruta %" };
        conecta.conexao();
        conecta.executaSQL(SQL);
        
        try {
            
            conecta.rs.first();
            
            do {
                float valorProduto = conecta.rs.getFloat("preco_compra");
                float valorLucro = conecta.rs.getFloat("lucrovenda");
                float valorMargem = conecta.rs.getFloat("lucro_esperado");
                int quantidadeComprada = conecta.rs.getInt("quantidade_produto");
                float precoVenda = conecta.rs.getFloat("preco_venda");
                float TotalPreco = valorProduto * quantidadeComprada;
                dados.add(new Object[]{conecta.rs.getInt("id_produto"),conecta.rs.getString("nome_produto"), df.format(valorProduto), conecta.rs.getInt("quantidade_produto"), df.format(precoVenda), df.format(TotalPreco), conecta.rs.getInt("quantidade"), df.format(valorLucro),df.format(valorMargem)});
            } while (conecta.rs.next());
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR"+ e);
        }
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        
        TabelaItensVenda.setModel(modelo);
        TabelaItensVenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        TabelaItensVenda.getColumnModel().getColumn(0).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(1).setPreferredWidth(300);
        TabelaItensVenda.getColumnModel().getColumn(1).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(2).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(2).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        TabelaItensVenda.getColumnModel().getColumn(3).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(4).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(4).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(5).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(5).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(6).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(6).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(7).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(7).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(8).setPreferredWidth(130);
        TabelaItensVenda.getColumnModel().getColumn(8).setResizable(false);
        
        
        
        TabelaItensVenda.getTableHeader().setReorderingAllowed(false);
        TabelaItensVenda.setAutoResizeMode(TabelaItensVenda.AUTO_RESIZE_OFF);
        TabelaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TabelaItensVenda.setRowHeight(28);
        
        TabelaItensVenda.removeAll();
        
        somaProduto();
        
    }
    
    public void somaProduto(){
        float total = 0;
        float preco = Float.parseFloat(jTextFieldValorPorItem.getText().replace(",","."));
        conecta.conexao();
        conecta.executaSQL("select * from itens_compra_produto inner join produto on itens_compra_produto.id_produto = produto.id_produto where id_compra ="+codCompra);
        
        try {
           
            
            while(conecta.rs.next()){
                
               total = total + conecta.rs.getFloat("preco_compra") * conecta.rs.getInt("quantidade_produto");
                
            }
            
            String nTotal = df.format(total).replace(".", ",");
            
            jTextFieldTotalProdutos.setText(String.valueOf(nTotal));
            jTextFieldValorTotalGeral.setText(String.valueOf(nTotal));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao somar "+ex);
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
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fornecedor;
    private javax.swing.JTable TabelaItensVenda;
    private javax.swing.JButton jButtonCancelarCompra;
    private javax.swing.JButton jButtonDesconto;
    private javax.swing.JButton jButtonFinalizarCartao;
    private javax.swing.JButton jButtonFinalizarCrediario;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JButton jButtonFornecedor;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelDescontoReais;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelEstoque1;
    private javax.swing.JLabel jLabelNovaQuantidade;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDataCompra;
    private javax.swing.JTextField jTextFieldDataVenda3;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldLucro;
    private javax.swing.JTextField jTextFieldMargem;
    private javax.swing.JTextField jTextFieldNumeroNota;
    private javax.swing.JTextField jTextFieldPrecoVenda;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTotalProdutos;
    private javax.swing.JTextField jTextFieldValorPorItem;
    private javax.swing.JTextField jTextFieldValorTotalGeral;
    private javax.swing.JLabel lblIdCaixa;
    // End of variables declaration//GEN-END:variables
    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    private void vendaAVista() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0),"vista");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("vista", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonFinalizarVenda.doClick();
                }
            });
    }

    private void vendaCrediario() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0),"receber");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("receber", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonFinalizarCrediario.doClick();
                }
            });   
    }
    
    private void vendaCartao() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"cartao");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("cartao", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonFinalizarCartao.doClick();
                }
            });   
    }
    private void procuraProdutos() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"produtos");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("produtos", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonPesquisar.doClick();
                }
            });   
    }
    
    private void pesquisaFornecedor() {
       javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"fornecedor");
                this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
                this.getRootPane().getActionMap().put("fornecedor", new AbstractAction(){
                private static final long serialVersionUID = 1L;
                public void actionPerformed(ActionEvent arg0) {            
                jButtonFornecedor.doClick();
                }
            });   
    }
    
}
