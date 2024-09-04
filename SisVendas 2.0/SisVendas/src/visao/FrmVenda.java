package visao;

import controle.ConectaBanco;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
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
public class FrmVenda extends javax.swing.JFrame {

    private ModeloTabelaProduto modeloProduto = new ModeloTabelaProduto();
    ConectaBanco conecta = new ConectaBanco();
    ModeloVenda mod = new ModeloVenda();
    ModeloLogin modlogin = new ModeloLogin();
    ModeloProduto modP = new ModeloProduto();
    ControleVenda control = new ControleVenda();
    DecimalFormat df = new DecimalFormat("0.00");

    NimbusClasse n = new NimbusClasse();
    ModeloTabela modelo;
    DefaultListModel modelList;

    int codVenda, barras, codProd, caixaId, enter = 0;
    float preco_produto, total, valorComDesconto, valor;
    String resultado, caixa, nome, nomePro;

    private FrmSelecionaProduto selecionaProduto;

    String name = modlogin.getUser();

    public FrmVenda(String name) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        this.selecionaProduto = new FrmSelecionaProduto();
        jLabelUsuario.setText(name);
        modelList = new DefaultListModel();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();

        jTextFieldDataVenda.setText(df.format(hoje));
        jTextFieldDesconto.setText("0,00");
        jTextFieldSubTotal.setText("0,00");
        jTextFieldValorPorItem.setText("0,00");
        jTextFieldValorTotalGeral.setText("0,00");
        jTextFieldDesconto.setVisible(false);
        jLabelDesconto.setVisible(false);
        jLabelDescontoReais.setVisible(false);
        conecta.conexao();

        try {
            conecta.executaSQL("SELECT * FROM caixa");
            conecta.rs.last();
            caixaId = conecta.rs.getInt("id_caixa");
            lblIdCaixa.setText(String.valueOf(caixaId));
            caixa = conecta.rs.getString("status");
            if (caixa.equals("aberto")) {

            } else {
                JOptionPane.showMessageDialog(rootPane, "Caixa fechado,abra o caixa para iniciar a Venda");
                dispose();

                FrmAbrirCaixa t = new FrmAbrirCaixa();
                t.setVisible(true);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao Preencher Caixa" + ex);
        } finally {

            conecta.desconecta();
        }

        conecta.conexao();

        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("INSERT INTO venda(valor_venda, status) VALUES(?,?)");
            pst.setFloat(1, 0);
            pst.setString(2, "iniciada");
            pst.execute();
            conecta.executaSQL("SELECT  * FROM venda");
            conecta.rs.last();
            codVenda = conecta.rs.getInt("id_venda");
            jLabelNumeroVenda.setText(String.valueOf(codVenda));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao abrir venda:  " + ex);
        } finally {

            conecta.desconecta();
        }

        vendaAVista();
        vendaCrediario();
        vendaCartao();
        procuraProdutos();

    }

    private FrmVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ListadePesquisa() {

        conecta.conexao();
        try {
            conecta.executaSQL("SELECT * FROM produto WHERE nome_produto like '" + jTextFieldProduto.getText() + "%' ORDER BY nome_produto");
            modelList.removeAllElements();
            int v = 0;
            while (conecta.rs.next() & v < 4) {
                modelList.addElement(conecta.rs.getString("nome_produto"));
                v++;

            }

            resultadoPesquisa();

        } catch (SQLException ex) {
            Logger.getLogger(FrmVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            conecta.desconecta();
        }

    }

    public void resultadoPesquisa() {
        conecta.conexao();

        try {
            conecta.rs.first();
            jTextFieldProduto.setText(nomePro);
            jTextFieldProduto.setText(conecta.rs.getString("nome_produto"));
            jTextFieldProduto.selectAll();

            preco_produto = conecta.rs.getFloat("preco_venda");

            String nPrecoProduto = df.format(preco_produto).replace(".", ",");

            jTextFieldValorPorItem.setText(String.valueOf(nPrecoProduto));

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Erro ao Inserir Dados Produtos"+ex);
        } finally {

            conecta.desconecta();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldDataVenda = new javax.swing.JTextField();
        jTextFieldProduto = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldValorPorItem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaItensVenda = new javax.swing.JTable();
        jButtonFinalizarCartao = new javax.swing.JButton();
        jButtonCancelarVenda = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonDesconto = new javax.swing.JButton();
        jTextFieldDesconto = new javax.swing.JTextField();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblIdCaixa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelDesconto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelDescontoReais = new javax.swing.JLabel();
        jButtonFinalizarCrediario = new javax.swing.JButton();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelEstoque = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorTotalGeral = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelnomeVe = new javax.swing.JLabel();
        jLabelNumeroVenda = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();

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
        setTitle("formulário de vendas");
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

        jTextFieldDataVenda.setEditable(false);
        jTextFieldDataVenda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTextFieldDataVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDataVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldDataVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataVendaFocusGained(evt);
            }
        });
        jPanel1.add(jTextFieldDataVenda);
        jTextFieldDataVenda.setBounds(300, 570, 227, 42);

        jTextFieldProduto.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextFieldProduto.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldProdutoFocusGained(evt);
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
        jPanel1.add(jTextFieldProduto);
        jTextFieldProduto.setBounds(10, 30, 1110, 95);

        jTextFieldQuantidade.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldQuantidade);
        jTextFieldQuantidade.setBounds(1120, 160, 227, 74);

        jTextFieldValorPorItem.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
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
        jPanel1.add(jTextFieldValorPorItem);
        jTextFieldValorPorItem.setBounds(1120, 280, 227, 76);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pesquisar Produto por Nome ( F6 ) por Código ou Código de Barras:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 490, 17);

        TabelaItensVenda.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        TabelaItensVenda.setForeground(new java.awt.Color(51, 51, 51));
        TabelaItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaItensVenda.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaItensVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaItensVendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaItensVenda);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(11, 221, 889, 243);

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
        jPanel1.add(jButtonFinalizarCartao);
        jButtonFinalizarCartao.setBounds(470, 640, 154, 40);

        jButtonCancelarVenda.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelarVenda.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonCancelarVenda.setForeground(new java.awt.Color(0, 153, 153));
        jButtonCancelarVenda.setText("Cancelar Venda");
        jButtonCancelarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonCancelarVenda.setBorderPainted(false);
        jButtonCancelarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarVendaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelarVenda);
        jButtonCancelarVenda.setBounds(1120, 640, 224, 40);

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
        jPanel1.add(jButtonRemover);
        jButtonRemover.setBounds(861, 475, 39, 42);

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
        jPanel1.add(jButtonDesconto);
        jButtonDesconto.setBounds(300, 640, 160, 40);

        jTextFieldDesconto.setBackground(new java.awt.Color(240, 240, 240));
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
        jPanel1.add(jTextFieldDesconto);
        jTextFieldDesconto.setBounds(10, 530, 227, 83);

        jTextFieldSubTotal.setEditable(false);
        jTextFieldSubTotal.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextFieldSubTotal.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSubTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldSubTotal.setCaretColor(new java.awt.Color(0, 153, 153));
        jPanel1.add(jTextFieldSubTotal);
        jTextFieldSubTotal.setBounds(1120, 390, 227, 78);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caixa Número:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 640, 106, 30);

        lblIdCaixa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblIdCaixa.setForeground(new java.awt.Color(255, 255, 255));
        lblIdCaixa.setText("caixa");
        jPanel1.add(lblIdCaixa);
        lblIdCaixa.setBounds(120, 640, 92, 29);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Itens da Venda:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(11, 198, 111, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data da Venda:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 550, 106, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1120, 140, 85, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Por Item:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1120, 260, 107, 17);

        jLabelDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDesconto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesconto.setText("Desconto:");
        jPanel1.add(jLabelDesconto);
        jLabelDesconto.setBounds(10, 510, 70, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SubTotal em :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1120, 370, 96, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("R$");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(1330, 370, 22, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("R$");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1330, 260, 22, 20);

        jLabelDescontoReais.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelDescontoReais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDescontoReais.setText("R$");
        jPanel1.add(jLabelDescontoReais);
        jLabelDescontoReais.setBounds(210, 510, 22, 20);

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
        jPanel1.add(jButtonFinalizarCrediario);
        jButtonFinalizarCrediario.setBounds(650, 640, 145, 40);

        jButtonFinalizarVenda.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFinalizarVenda.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButtonFinalizarVenda.setForeground(new java.awt.Color(0, 153, 153));
        jButtonFinalizarVenda.setText("Finalizar Venda - F12");
        jButtonFinalizarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonFinalizarVenda.setBorderPainted(false);
        jButtonFinalizarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFinalizarVenda);
        jButtonFinalizarVenda.setBounds(810, 640, 154, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estoque:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(11, 148, 69, 18);

        jLabelEstoque.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelEstoque);
        jLabelEstoque.setBounds(86, 148, 36, 18);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Valor Total em ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1120, 490, 104, 17);

        jTextFieldValorTotalGeral.setEditable(false);
        jTextFieldValorTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextFieldValorTotalGeral.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldValorTotalGeral.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorTotalGeral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 10, true));
        jTextFieldValorTotalGeral.setCaretColor(new java.awt.Color(0, 153, 153));
        jPanel1.add(jTextFieldValorTotalGeral);
        jTextFieldValorTotalGeral.setBounds(1120, 510, 227, 111);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("R$");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(1330, 490, 22, 20);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1186, 690));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jLayeredPane1);
        jLayeredPane1.setBounds(-10, 0, 44, 0);

        jLabelUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Vendedor");
        jPanel1.add(jLabelUsuario);
        jLabelUsuario.setBounds(410, 143, 210, 30);

        jLabelnomeVe.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelnomeVe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelnomeVe.setText("Vendedor:");
        jPanel1.add(jLabelnomeVe);
        jLabelnomeVe.setBounds(320, 140, 100, 40);

        jLabelNumeroVenda.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelNumeroVenda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumeroVenda.setText("0000");
        jPanel1.add(jLabelNumeroVenda);
        jLabelNumeroVenda.setBounds(850, 150, 50, 18);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Número da venda:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(690, 150, 150, 18);

        jButtonPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPesquisar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(0, 153, 153));
        jButtonPesquisar.setText("Pesquisar Produto - F6");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPesquisar);
        jButtonPesquisar.setBounds(1150, 30, 200, 90);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescontoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldDescontoInputMethodTextChanged
        jTextFieldSubTotal.setText(String.valueOf(valorComDesconto));
    }//GEN-LAST:event_jTextFieldDescontoInputMethodTextChanged

    private void jTextFieldDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescontoFocusGained
        jTextFieldSubTotal.setText(String.valueOf(valorComDesconto));
    }//GEN-LAST:event_jTextFieldDescontoFocusGained

    private void jButtonDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescontoActionPerformed
        jTextFieldDesconto.setVisible(true);
        jLabelDesconto.setVisible(true);
        jLabelDescontoReais.setVisible(true);
        jTextFieldDesconto.setEnabled(true);

        resultado = JOptionPane.showInputDialog("Digite o valor de desconto");

        //adicionando subtotal avariavel totalGeral
        float totalGeral = Float.parseFloat(jTextFieldSubTotal.getText().replace(",", "."));

        //convertendo o desconto para flot
        float subtracao = Float.parseFloat(resultado);

        //subtraindo totalgeral e desconto é guardando valor na variavel totalDesconto!
        float totalDesconto = totalGeral - subtracao;
        //System.out.println("estou aqui agora!"+totalDesconto);

        jTextFieldDesconto.setText(String.valueOf(subtracao).replace(".", ","));
        jTextFieldValorTotalGeral.setText(String.valueOf(df.format(totalGeral = totalDesconto).replace(".", ",")));
        //System.out.println("finalizando metodo!!!"+totalGeral);


    }//GEN-LAST:event_jButtonDescontoActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

        conecta.conexao();

        int k = TabelaItensVenda.getSelectedRow();
        int id = (int) TabelaItensVenda.getValueAt(k, 0);
        int quantidade = (int) TabelaItensVenda.getValueAt(k, 2);
        int Estoque = (int) TabelaItensVenda.getValueAt(k, 4);
        int TotalEstoqueR = Estoque + quantidade;
        PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("DELETE FROM itens_venda_produto WHERE id_produto='" + id + "'");
            //pst.setInt(1, modP.getIdProduto());
            pst.executeUpdate();

            pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade = ? WHERE id_produto = '" + id + "'");
            pst.setInt(1, TotalEstoqueR);
            pst.execute();

            int modelRowIndex = TabelaItensVenda.convertRowIndexToModel(TabelaItensVenda.getSelectedRow());
            modelo = (ModeloTabela) TabelaItensVenda.getModel();
            TabelaItensVenda.clearSelection();
            modelo.removeRow(modelRowIndex);

            somaProduto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir" + ex);
        }

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoverMouseClicked

    }//GEN-LAST:event_jButtonRemoverMouseClicked

    private void jButtonCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarVendaActionPerformed

        String message = "Desenja Cancelar a venda ?";
        String title = "Cancelamento de  Venda";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_OPTION);

        if (finalizar == JOptionPane.YES_OPTION) {

            control.cancelaVenda();
            dispose();
            TelaPrincipal tela = new TelaPrincipal(modlogin.getUser());

        } else {

            JOptionPane.showMessageDialog(null, "Venda Não Cancelada");

        }

    }//GEN-LAST:event_jButtonCancelarVendaActionPerformed

    private void jButtonFinalizarCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarCartaoActionPerformed
        String message = "Deseja Realizar Venda no Cartão?";
        String title = "Venda no Cartão";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_OPTION);

        if (finalizar == JOptionPane.YES_OPTION) {
            float valorTotal = Float.parseFloat(jTextFieldSubTotal.getText().replace(",", "."));
            if (!jTextFieldSubTotal.getText().equals("0,00")) {

                mod.setIdVenda(codVenda);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());

                if (jTextFieldDesconto.getText().equals("0,00")) {
                    mod.setValorVenda(valorTotal);
                    jTextFieldSubTotal.setText(String.valueOf(df.format(valorTotal)).replace(".", ","));

                } else {

                    mod.setValorVenda(valorComDesconto);
                    jTextFieldSubTotal.setText(String.valueOf(valorComDesconto));

                }

                mod.setIdVenda(codVenda);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setValorVenda(valorTotal);
                mod.setPagamento("Cartao");
                control.fechaVenda(mod);
                //JOptionPane.showMessageDialog(null,"Abrir Formulário de Cartão");
                FrmCartao parc = new FrmCartao(codVenda);
                parc.setVisible(true);

                dispose();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Venda Não Finalizada");

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


    private void jTextFieldValorPorItemCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemCaretPositionChanged
        somaProduto();
    }//GEN-LAST:event_jTextFieldValorPorItemCaretPositionChanged

    private void jTextFieldValorPorItemInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldValorPorItemInputMethodTextChanged

    private void jTextFieldValorPorItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemFocusLost

    }//GEN-LAST:event_jTextFieldValorPorItemFocusLost

    private void jTextFieldValorPorItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPorItemFocusGained
        somaProduto();
    }//GEN-LAST:event_jTextFieldValorPorItemFocusGained

    private void jTextFieldProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutoKeyPressed
//        if(evt.getKeyCode()== KeyEvent.VK_F6){
//            
//            this.selecionaProduto.setVisible(true);
//            
//            
//            
//             nomePro = this.selecionaProduto.getNomeProduto();
//             
//             
//             
//            
//           
//       }
        //       if(evt.getKeyCode()== KeyEvent.VK_ENTER){

//            if(!jTextFieldProduto.getText().equals("")){
//                conecta.conexao();
//        try {
//            conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+jTextFieldProduto.getText()+"' OR nome_produto='"+jTextFieldProduto.getText()+"'");
//            modelList.removeAllElements();
//            int v = 0;
//            while(conecta.rs.next() & v < 7){
//              modelList.addElement(conecta.rs.getString("nome_produto"));
//              int estoque = conecta.rs.getInt("quantidade");
//              jLabelEstoque.setText(String.valueOf(estoque));
//              
//              
//              v++;
//                
//            } 
//            
//            resultadoPesquisa();
//        
//        } catch (SQLException ex) {
//            //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
//        }       
//        
//                jTextFieldQuantidade.requestFocus();
//                jTextFieldQuantidade.selectAll();
//
//                //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");
//
//            }else{
//
//                JOptionPane.showMessageDialog(rootPane,"Selecione um Produto");
//
//            }
        //      }
    }//GEN-LAST:event_jTextFieldProdutoKeyPressed

    private void jTextFieldDataVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataVendaFocusGained
        somaProduto();
    }//GEN-LAST:event_jTextFieldDataVendaFocusGained

    private void jTextFieldProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdutoActionPerformed

        if (!jTextFieldProduto.getText().equals("")) {
            conecta.conexao();

//                String regex ="^([0-9]+)(.)([0-9]+)$";
//                String texto = jTextFieldProduto.getText();
//             
//             Pattern pattern = Pattern.compile(regex);
//             Matcher matcher = pattern.matcher(texto);
//          try {   
//             if(matcher.find()){
//                 String quantidade = matcher.group(1);
//                 String produto = matcher.group(3);
//                 
//                 System.out.println("Quantidade é : "+quantidade);
//                 System.out.println("Código produto é : "+produto);
//                 
//                 conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+produto+"'  OR codigobarras = '"+produto+"'");
//                 modelList.removeAllElements();
//                int v = 0;
//                while(conecta.rs.next() & v < 7){
//                modelList.addElement(conecta.rs.getString("nome_produto"));
//                int estoque = conecta.rs.getInt("quantidade");
//                jLabelEstoque.setText(String.valueOf(estoque));
//                jTextFieldQuantidade.setText(quantidade);
//                v++;
//                
//            } 
//            
//            resultadoPesquisa();
//             }else{
            try {
                conecta.executaSQL("SELECT * FROM produto WHERE id_produto='" + jTextFieldProduto.getText() + "'  OR codigobarras = '" + jTextFieldProduto.getText() + "' OR nome_produto = '" + jTextFieldProduto.getText() + "'");
                modelList.removeAllElements();
                int v = 0;
                while (conecta.rs.next() & v < 7) {
                    modelList.addElement(conecta.rs.getString("nome_produto"));
                    int estoque = conecta.rs.getInt("quantidade");
                    jLabelEstoque.setText(String.valueOf(estoque));
                    jTextFieldQuantidade.setText("1");

                    v++;

                }

                resultadoPesquisa();

            } catch (SQLException ex) {
                //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTextFieldQuantidade.requestFocus();
            jTextFieldQuantidade.selectAll();

            //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");
        } else {

            JOptionPane.showMessageDialog(rootPane, "Selecione um Produto");

        }

        //enter =1;
    }//GEN-LAST:event_jTextFieldProdutoActionPerformed

    private void jTextFieldProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProdutoKeyReleased
        if (jTextFieldProduto.getText().length() >= 13) {
            conecta.conexao();
            try {
//                String regex ="^([0-9]+)(.)([0-9]+)$";
//                String texto = jTextFieldProduto.getText();
//        System.out.println("Valor pego do jText"+jTextFieldProduto.getText());
//                Pattern pattern = Pattern.compile(regex);
//                Matcher matcher = pattern.matcher(texto);
//            
//             if(matcher.find()){
//                 System.out.println("Caiu no IF");
//                 String quantidade = matcher.group(1);
//                 String ast = matcher.group(2);
//                 String produto = matcher.group(3);
//                 
//                 System.out.println("Quantidade é : "+quantidade);
//                 System.out.println("Astericos é : "+ast);
//                 System.out.println("Código produto é : "+produto);        
//                
//        
//            conecta.executaSQL("SELECT * FROM produto WHERE id_produto='"+produto+"' OR codigobarras = '"+produto+"'");
//            modelList.removeAllElements();
//            int v = 0;
//            while(conecta.rs.next() & v < 10){
//              modelList.addElement(conecta.rs.getString("nome_produto"));
//              int estoque = conecta.rs.getInt("quantidade");
//              jLabelEstoque.setText(String.valueOf(estoque));
//              jTextFieldQuantidade.setText(quantidade);
//              
//              
//              v++;
//             
//            } 
//            
//            resultadoPesquisa();
//            
//            
//            }else{

                conecta.executaSQL("SELECT * FROM produto WHERE id_produto='" + jTextFieldProduto.getText() + "'  OR codigobarras = '" + jTextFieldProduto.getText() + "' OR nome_produto = '" + jTextFieldProduto.getText() + "'");
                modelList.removeAllElements();
                int v = 0;
                while (conecta.rs.next() & v < 10) {
                    modelList.addElement(conecta.rs.getString("nome_produto"));
                    int estoque = conecta.rs.getInt("quantidade");
                    jLabelEstoque.setText(String.valueOf(estoque));
                    jTextFieldQuantidade.setText("1");

                    v++;

                }

                resultadoPesquisa();

                // fim try     
            } catch (SQLException ex) {
                //Logger.getLogger(FrmVenda1.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                conecta.desconecta();
            }

            jTextFieldQuantidade.requestFocus();
            jTextFieldQuantidade.selectAll();

            //preencherTabelaProduto("select * from produto  where nome_produto like '%"+jTextFieldProduto.getText()+"%'");
// fim do primeiro if
        } else {

            //JOptionPane.showMessageDialog(rootPane,"Selecione um Produto");
        }

// fim do metodo
    }//GEN-LAST:event_jTextFieldProdutoKeyReleased

    private void jTextFieldQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                int quantidade = 0;

                conecta.conexao();
                conecta.executaSQL("SELECT * FROM produto WHERE nome_produto = '" + jTextFieldProduto.getText() + "'");

                conecta.rs.first();
                quantidade = conecta.rs.getInt("quantidade");
//            String name = conecta.rs.getString("nome_produto");
                //System.out.println("Nome do Produto:"+ name);
                if (quantidade >= Integer.parseInt(jTextFieldQuantidade.getText())) {
                    mod.setNomeProduto((String) jTextFieldProduto.getText());
                    mod.setQtItem(Integer.parseInt(jTextFieldQuantidade.getText()));
                    mod.setIdVenda(codVenda);
                    control.adicionaItem(mod);
                    preencherTabelaItensVenda("SELECT * FROM produto INNER JOIN itens_venda_produto ON produto.id_produto = itens_venda_produto.id_produto INNER JOIN venda ON venda.id_venda = itens_venda_produto.id_venda WHERE venda.id_venda =" + codVenda);

                    jTextFieldQuantidade.setText("1");
                    jTextFieldProduto.setText("");
                    jTextFieldProduto.requestFocus();
                    jTextFieldProduto.selectAll();

                    jLabelEstoque.setText("0");

                } else {

                    JOptionPane.showMessageDialog(rootPane, "Quantidade desejada não disponivel no estoque");

                }

            } catch (SQLException ex) {
                Logger.getLogger(FrmVenda.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                conecta.desconecta();
            }

        }
    }//GEN-LAST:event_jTextFieldQuantidadeKeyPressed

    private void jTextFieldProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldProdutoFocusGained

//        if(jTextFieldProduto.getText()!= null)
//            {
//            
//            try {
//                
//                jTextFieldProduto.requestFocus();
//                jTextFieldProduto.selectAll();
//                conecta.conexao();
//                this.jTextFieldProduto.setText(String.valueOf(this.selecionaProduto.getNomeProduto()));  
//                conecta.executaSQL("SELECT * FROM produto WHERE nome_produto='"+jTextFieldProduto.getText()+"'");
//                
//                int i=0;
//                while(conecta.rs.next() & i<7){
//                  this.jTextFieldProduto.setText(conecta.rs.getString("nome_produto"));
//                    i++;
//                    
//                }
//                jTextFieldQuantidade.setText("1");
//                jTextFieldQuantidade.selectAll();
//                resultadoPesquisa();
//                
//                
//               
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(FrmVenda.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_jTextFieldProdutoFocusGained

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F12) {

            JOptionPane.showMessageDialog(null, "F12");
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jButtonFinalizarCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarCrediarioActionPerformed

        String message = "Deseja Parcelar a venda ?";
        String title = "Parcelar Venda";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_OPTION);

        if (finalizar == JOptionPane.YES_OPTION) {
            float valorTotal = Float.parseFloat(jTextFieldSubTotal.getText().replace(",", "."));
            if (!jTextFieldSubTotal.getText().equals("0,00")) {

                mod.setIdVenda(codVenda);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());

                if (jTextFieldDesconto.getText().equals("0,00")) {
                    mod.setValorVenda(valorTotal);
                    jTextFieldSubTotal.setText(String.valueOf(df.format(valorTotal)).replace(".", ","));

                } else {

                    mod.setValorVenda(valorComDesconto);
                    jTextFieldSubTotal.setText(String.valueOf(valorComDesconto));

                }

                mod.setIdVenda(codVenda);
                mod.setIdCaixa(caixaId);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setValorVenda(valorTotal);
                mod.setPagamento("Crediario");
                control.fechaVenda(mod);
                FrmEntrada parc = new FrmEntrada(codVenda);
                parc.setVisible(true);

                dispose();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Venda Não Finalizada");

        }


    }//GEN-LAST:event_jButtonFinalizarCrediarioActionPerformed

    private void jButtonFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarVendaActionPerformed

        String message = "Deseja finalizar a venda ?";
        String title = "Finalizar Venda";
        int finalizar = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_OPTION);

        if (finalizar == JOptionPane.YES_OPTION) {
            String valorTotal = jTextFieldSubTotal.getText().replace(",", ".");
            if (!jTextFieldSubTotal.getText().equals("0,00")) {

                mod.setIdVenda(codVenda);
                mod.setVendedor(jLabelUsuario.getText());
                mod.setIdCaixa(caixaId);

                valorComDesconto = Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", "."));

                if (jTextFieldDesconto.getText().equals("0,00")) {
                    //decidir comentar aqui pois estava subtraindo o subtotal
                    //String valorTotal = jTextFieldValorTotalGeral.getText().replace(",",".");

                    mod.setValorVenda(Float.parseFloat(valorTotal));
                    //jTextFieldSubTotal.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));
                    //jTextFieldValorTotalGeral.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));
                } else {

                    mod.setValorVenda(valorComDesconto);
                    //jTextFieldSubTotal.setText(String.valueOf(df.format(valorComDesconto)).replace(".", ","));

                }

                mod.setPagamento("Dinheiro");

                control.fechaVenda(mod);

                JOptionPane.showMessageDialog(rootPane, "Venda à Vista Realizada com Sucesso " + mod.getVendedor());
                this.valor = Float.parseFloat(jTextFieldValorTotalGeral.getText().replace(",", "."));
                Troco t = new Troco(valor);
                t.setVisible(true);
                dispose();

            } else {

                JOptionPane.showMessageDialog(null, "Venda Não Realizada");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Venda não Finalizada");

        }


    }//GEN-LAST:event_jButtonFinalizarVendaActionPerformed

    private void jTextFieldQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeKeyReleased

    private void TabelaItensVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaItensVendaMouseClicked
        if (evt.getClickCount() == 2) {

            String nome = (String) TabelaItensVenda.getValueAt(TabelaItensVenda.getSelectedRow(), 1);
            int quantidade = (int) TabelaItensVenda.getValueAt(TabelaItensVenda.getSelectedRow(), 2);

            jTextFieldProduto.setText(nome);
            jTextFieldQuantidade.setText(String.valueOf(quantidade));

        }
    }//GEN-LAST:event_TabelaItensVendaMouseClicked

    private void jTextFieldQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeFocusGained
//        
//        
//        try {
//            int quantidade = 0;
//            
//            conecta.conexao();
//            conecta.executaSQL("SELECT * FROM produto WHERE nome_produto = '"+jTextFieldProduto.getText()+"'");
//
//            conecta.rs.first();
//             quantidade = conecta.rs.getInt("quantidade");
////            String name = conecta.rs.getString("nome_produto");
//            //System.out.println("Nome do Produto:"+ name);
//            if(quantidade >= Integer.parseInt(jTextFieldQuantidade.getText())){
//                mod.setNomeProduto((String)jTextFieldProduto.getText());
//                mod.setQtItem(Integer.parseInt(jTextFieldQuantidade.getText()));
//                mod.setIdVenda(codVenda);
//                control.adicionaItem(mod);
//                preencherTabelaItensVenda("SELECT * FROM produto INNER JOIN itens_venda_produto ON produto.id_produto = itens_venda_produto.id_produto INNER JOIN venda ON venda.id_venda = itens_venda_produto.id_venda WHERE venda.id_venda ="+codVenda);
//                
//                jTextFieldQuantidade.setText("1");
//                
//                jTextFieldProduto.setText("");
//                jTextFieldProduto.selectAll();
//                jTextFieldProduto.requestFocus();
//                jLabelEstoque.setText("0");
//                
//                
//            }else{
//
//                JOptionPane.showMessageDialog(rootPane,"Quantidade desejada não disponivel no estoque");
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(FrmVenda.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        

    }//GEN-LAST:event_jTextFieldQuantidadeFocusGained

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        FrmSelecionaProduto p = new FrmSelecionaProduto(this.jTextFieldProduto);
        p.setVisible(true);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeActionPerformed
    public void finalizarVendaVista() {

    }

    public void descontoEvento(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {

            resultado = JOptionPane.showInputDialog("Digite o valor do desconto");

        } else {

            JOptionPane.showInputDialog("Digite o valor do desconto");
        }
    }

    public void preencherTabelaItensVenda(String SQL) {

        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição", "Quantidade", "Valor Total", "Estoque"};
        conecta.conexao();
        conecta.executaSQL(SQL);

        try {

            conecta.rs.first();
            int linhas = TabelaItensVenda.getRowCount();
            int coluna = 1;
            boolean tem = false;
            String nome = conecta.rs.getString("nome_produto");

            for (int i = 0; i < linhas; i++) {

                String name = (String) TabelaItensVenda.getValueAt(i, coluna);
                if (name.equals(nome)) {

                }

            }
            System.out.println("Nome é " + name);
            do {

                float valorProduto = conecta.rs.getFloat("preco_venda");
                int quantidadeVendida = conecta.rs.getInt("quantidade_produto");
                float TotalPreco = valorProduto * quantidadeVendida;
                dados.add(new Object[]{conecta.rs.getInt("id_produto"), conecta.rs.getString("nome_produto"), conecta.rs.getInt("quantidade_produto"), df.format(TotalPreco), conecta.rs.getInt("quantidade")});

            } while (conecta.rs.next());
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR" + e);
        } finally {

            conecta.desconecta();
        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);

        TabelaItensVenda.setModel(modelo);
        TabelaItensVenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        TabelaItensVenda.getColumnModel().getColumn(0).setResizable(false);

        TabelaItensVenda.getColumnModel().getColumn(1).setPreferredWidth(400);
        TabelaItensVenda.getColumnModel().getColumn(1).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(2).setPreferredWidth(180);
        TabelaItensVenda.getColumnModel().getColumn(2).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(3).setPreferredWidth(200);
        TabelaItensVenda.getColumnModel().getColumn(3).setResizable(false);
        TabelaItensVenda.getColumnModel().getColumn(4).setPreferredWidth(40);
        TabelaItensVenda.getColumnModel().getColumn(4).setResizable(false);

        TabelaItensVenda.getTableHeader().setReorderingAllowed(false);
        TabelaItensVenda.setAutoResizeMode(TabelaItensVenda.AUTO_RESIZE_OFF);
        TabelaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TabelaItensVenda.setRowHeight(28);

        somaProduto();

    }

    public void somaProduto() {
        float total = 0;
        conecta.conexao();
        conecta.executaSQL("select * from itens_venda_produto inner join produto on itens_venda_produto.id_produto = produto.id_produto where id_venda =" + codVenda);

        try {

            while (conecta.rs.next()) {

                total = total + conecta.rs.getFloat("preco_venda") * conecta.rs.getInt("quantidade_produto");

            }

            String nTotal = df.format(total).replace(".", ",");

            jTextFieldSubTotal.setText(String.valueOf(nTotal));
            jTextFieldValorTotalGeral.setText(String.valueOf(nTotal));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao somar " + ex);
        } finally {

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
            java.util.logging.Logger.getLogger(FrmVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaItensVenda;
    private javax.swing.JButton jButtonCancelarVenda;
    private javax.swing.JButton jButtonDesconto;
    private javax.swing.JButton jButtonFinalizarCartao;
    private javax.swing.JButton jButtonFinalizarCrediario;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelDescontoReais;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelNumeroVenda;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelnomeVe;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDataVenda;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldValorPorItem;
    private javax.swing.JTextField jTextFieldValorTotalGeral;
    private javax.swing.JLabel lblIdCaixa;
    // End of variables declaration//GEN-END:variables

    private void vendaAVista() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "vista");
        this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("vista", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent arg0) {
                jButtonFinalizarVenda.doClick();
            }
        });
    }

    private void vendaCrediario() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "receber");
        this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("receber", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent arg0) {
                jButtonFinalizarCrediario.doClick();
            }
        });
    }

    private void vendaCartao() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "cartao");
        this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("cartao", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent arg0) {
                jButtonFinalizarCartao.doClick();
            }
        });
    }

    private void procuraProdutos() {
        javax.swing.InputMap inputMap = this.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "produtos");
        this.getRootPane().setInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("produtos", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent arg0) {
                jButtonPesquisar.doClick();
            }
        });
    }

    public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

}
