/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdv.sisac;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Parser;

/**
 *
 * @author meirinaldo
 */
public class pdv extends javax.swing.JFrame {

    /**
     * Creates new form pdv
     */
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
    static public Boolean finalizada = false;
     

    String Produto;
    float preco_venda;
    
    public static String caminho;
    public static String porta;
    public static String usuario;
    public static String senha;
    public static String base;
    
    public static int total_itensQuanti;
    public static int id_venda_atual;
    public static Boolean venda_iniciada = false;
    public static float total_compra = 0;
                        
    
    static public JTable tabela;
    static public DefaultTableModel modelo =new DefaultTableModel();
  
      private void criar_jtable(){
        
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("quantidade");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
        
    }
    
    
    public pdv() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        produto_field.setEditable(false);
        
        criar_jtable();
        jScrollPane2.setViewportView(tabela);
        //iniciando configurações salvas do banco
         String[] arquivo = new String[5];
			try{			
                                FileReader entrada = new FileReader("con.sist");
                                BufferedReader leitor = new BufferedReader(entrada);
				int c = 0;
				String linha = null;
				while((linha = leitor.readLine()) != null)  {
					arquivo[c] = leitor.readLine();
					c++;					
				}
			}catch(IOException e){
                            /*      JOptionPane.showMessageDialog(this, "Erro ao buscar arquivo de "
                            + "configurações da Base de Dados, para o sistema funcionar DEVE ter as configurações feitas.");
                            */
                        
                        }

                   
                        caminho = arquivo[0];
                        porta = arquivo[1];
                        usuario = arquivo[2];
                        senha = arquivo[3];
                        base = arquivo[4];
                        
        produto_field.requestFocus();
        produto_field.selectAll();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        precoItem_labe = new javax.swing.JTextField();
        quantidade_field = new javax.swing.JTextField();
        produto_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        total_itensLabel = new javax.swing.JLabel();
        total_itens = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        preco_total_vendaLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        status_venda = new javax.swing.JLabel();
        id_venda_Labe = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(180, 1, 1));

        precoItem_labe.setBackground(new java.awt.Color(1, 1, 1));
        precoItem_labe.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        precoItem_labe.setForeground(new java.awt.Color(254, 254, 254));
        precoItem_labe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        quantidade_field.setBackground(new java.awt.Color(1, 1, 1));
        quantidade_field.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        quantidade_field.setForeground(new java.awt.Color(254, 254, 254));
        quantidade_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantidade_field.setText("1");
        quantidade_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantidade_fieldKeyPressed(evt);
            }
        });

        produto_field.setBackground(new java.awt.Color(1, 1, 1));
        produto_field.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        produto_field.setForeground(new java.awt.Color(254, 254, 254));
        produto_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        produto_field.setText("VENDA NÃO INICIADA");
        produto_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                produto_fieldKeyPressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quantidade");

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Produto");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Preço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quantidade_field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(precoItem_labe, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produto_field, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoItem_labe, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidade_field, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produto_field, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(156, 34, 34));

        total_itensLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        total_itensLabel.setForeground(new java.awt.Color(254, 254, 254));
        total_itensLabel.setText("Total Itens:");

        total_itens.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        total_itens.setForeground(new java.awt.Color(254, 254, 254));
        total_itens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(total_itensLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(total_itens, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(total_itens, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(total_itensLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel5.setBackground(new java.awt.Color(1, 5, 119));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(97, 97, 97));

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("INSERT - Quant. Itens");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("END - Finaliza Venda");

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("F2 - Cancela Venda");

        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("F3 - Consulta Item");

        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("F4 - Ultimas vendas");

        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("HOME - Configurações");

        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("END - Finaliza Venda");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(156, 34, 34));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Total Compra:");

        preco_total_vendaLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        preco_total_vendaLabel.setForeground(new java.awt.Color(254, 254, 254));
        preco_total_vendaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        preco_total_vendaLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preco_total_vendaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(preco_total_vendaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jToolBar1.setRollover(true);

        status_venda.setText("Status: ");
        jToolBar1.add(status_venda);

        id_venda_Labe.setText("ID da Venda Atual");
        jToolBar1.add(id_venda_Labe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantidade_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidade_fieldKeyPressed
            

    //Apertar enter voltar para produto
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
             produto_field.requestFocus();
             produto_field.selectAll();
        }  
  
    
    }//GEN-LAST:event_quantidade_fieldKeyPressed

    private void produto_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produto_fieldKeyPressed
    //Entrar no metodo das teclas de atalho  
        
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                       //Procurar produto!!!
                      //Atributos de comando     
                      String comando = "SELECT * FROM produtos WHERE id='"+Integer.parseInt(produto_field.getText().replaceAll(" ",""))+"'";     

                      try{
                          Class.forName("com.mysql.jdbc.Driver");


                          try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base, 
                                                                              usuario, senha); //Conecta-se ao banco de dados
                              Statement statement = conexao.createStatement()) {

                              ResultSet resultSet = statement.executeQuery(comando);


                              while (resultSet.next()) {
                                  
                                  int id_Produto = resultSet.getInt("id");
                                  Produto = resultSet.getString("produto");
                                  preco_venda = resultSet.getFloat("preco_venda");
                              }
                             

                              //produto não encontrado na base
                              if (resultSet.first() == false){
                                  JOptionPane.showMessageDialog(this, "Produto não cadastrado!");
                                  precoItem_labe.setText("");
                                  produto_field.setText("");
                              }
                          }

                                    }//fim do try     //fim do try     
                      catch(ClassNotFoundException | SQLException e){     

                          System.err.println(e.getMessage());     
                      }                
                //Incluindo produto na venda!
                      
                            try {
                  Class.forName("com.mysql.jdbc.Driver");

                  Connection conn = DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base, 
                                                                              usuario, senha); //Conecta-se ao banco de dados
                  java.sql.Statement st = conn.createStatement();
                  st.executeUpdate("INSERT INTO compra_itens (id,id_pedido,id_produto,quantidade_itens) VALUES ("
                          + "0"+ ",'"
                          +  id_venda_atual + "','"
                          + Integer.parseInt(produto_field.getText().replaceAll(" ","")) + "','"                          
                          + Integer.parseInt(quantidade_field.getText()) + "')");
                  
                  //Inclui na lista de vendas da tela
                  
                   modelo.addRow(new Object[] {produto_field.getText().replaceAll(" ",""), Produto,formatoMoeda.format(preco_venda),quantidade_field.getText()} );

                  //depois de incluido na base mostra para o usuário e faz os tratamentos:
                              String PrecoVendaString = "R$ "+preco_venda;
                              precoItem_labe.setText(PrecoVendaString);
                              produto_field.setText(Produto);
                              produto_field.requestFocus();
                              produto_field.selectAll();
                              
                              total_itensQuanti = total_itensQuanti + Integer.parseInt(quantidade_field.getText()); 
                              total_compra = total_compra + (Integer.parseInt(quantidade_field.getText())*preco_venda);
                              total_itens.setText(total_itensQuanti+"");
                              
                              //resetando preços e quantidades 
                              quantidade_field.setText("1");
                              preco_total_vendaLabel.setText(formatoMoeda.format(total_compra));
                              
                  
              } catch (SQLException | ClassNotFoundException e) {
                  JOptionPane.showMessageDialog(rootPane, e);
              }//Fim try
                            
                            
          
          
          }else{
                teclas_atalho(evt);
                }
          
          
    }//GEN-LAST:event_produto_fieldKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
    //Entrar no metodo das teclas de atalho
    teclas_atalho(evt);
                
    }//GEN-LAST:event_jPanel1KeyPressed

    public void teclas_atalho(java.awt.event.KeyEvent evt){
           //Aperta espaço para iniciar venda!!!
            //inicia venda!
         if (evt.getKeyCode() == KeyEvent.VK_SPACE){  
             if(venda_iniciada == false){
                 
                    if(verificar_VendaAnteriorFinalizada() == true){

                        venda_iniciada = true;
                        status_venda.setText("Venda Iniciada!");
                        produto_field.setText("Venda Iniciada!");
                        produto_field.requestFocus();
                        produto_field.selectAll();
                        produto_field.setEditable(true);
                        

                          try {
                        //Registra JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");

                        //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS("") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
                        Connection conn = DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base, 
                                                                                    usuario, senha); //Conecta-se ao banco de dados

                        //Executa a query de inserção
                        java.sql.Statement st = conn.createStatement();
                        st.executeUpdate("INSERT INTO compra (id,cliente) VALUES ("
                                + "0,'"
                                +"Cliente Balcão" + "')");
                        
                        
                        
                    } catch (SQLException | ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(rootPane, "Problema ao iniciar venda! "+e);
                    }//Fim try
                      }
                    //pega ID da compra atual
                    id_venda_atual = select_banco("SELECT id FROM compra ORDER BY id DESC LIMIT 1");
                    id_venda_Labe.setText(" | ID da venda: "+id_venda_atual);
             }
        } 
 
        
        //Apertar insert entrar na quatidade
        if (evt.getKeyCode() == KeyEvent.VK_INSERT) { 
             quantidade_field.requestFocus();
             quantidade_field.selectAll();
        }
        //Apertar end finalizar venda
        if(evt.getKeyCode() == KeyEvent.VK_END){
            if(venda_iniciada=true && total_itensQuanti != 0){
            finalizar_venda frame_FinalizarVenda = new finalizar_venda();
            frame_FinalizarVenda.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "Você precisa iniciar uma venda e ter produtos adicionado!!!");
            }
        }
        //Apertar HOME entrar nas configurações do PDV
        if(evt.getKeyCode() == KeyEvent.VK_HOME){
            configuracao frame_configuracao = new configuracao();
            frame_configuracao.setVisible(true);
        }
        
        //Apertar enter ir para produti
      
        
        //Apertar f2 abrir frame exluir item
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            excluir_item frame_exluirItem = new excluir_item();
            frame_exluirItem.setVisible(true);
        } 
        //Apertar f3 consulta item
        if(evt.getKeyCode() == KeyEvent.VK_F3){
            pesquisar_produto frame_ConsultarItem = new pesquisar_produto();
            frame_ConsultarItem.setVisible(true);
        }
        //Apertar f4 ultimas vendas
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            excluir_item frame_exluirItem = new excluir_item();
            frame_exluirItem.setVisible(true);
        }
        //Apertar f5 cancelar venda
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            excluir_item frame_exluirItem = new excluir_item();
            frame_exluirItem.setVisible(true);
        }
    }
    
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
            java.util.logging.Logger.getLogger(pdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pdv().setVisible(true);
            }
        });
    }

   public Boolean verificar_VendaAnteriorFinalizada(){
        
        //Verificar se venda anterior foi fechada!!!!
                //Atributos de comando     
                String comando = "SELECT `finalizada` FROM compra ORDER BY id DESC LIMIT 1";     

                try{
                    Class.forName("com.mysql.jdbc.Driver");


                    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base, 
                                                                        usuario, senha); //Conecta-se ao banco de dados
                        Statement statement = conexao.createStatement()) {
                        
                        ResultSet resultSet = statement.executeQuery(comando);
                        
                     
                        while (resultSet.next()) {
                           int eh_finalizada = resultSet.getInt("finalizada");
                           
                           if (eh_finalizada == 1){
                               finalizada = true;
                           } else{
                               produto_field.setText("Venda Anterior não finalizada!!!");
                               produto_field.setForeground(Color.yellow);

                           }
                            
                        }
                        
                    }

                              }//fim do try     //fim do try     
                catch(ClassNotFoundException | SQLException e){     
                    System.err.println(e.getMessage());     
                }                
                
        
        
        return finalizada;
    }
            
   
   public int select_banco(String sql){
       int id = 0;
                try{
                    Class.forName("com.mysql.jdbc.Driver");


                    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base, 
                                                                        usuario, senha); //Conecta-se ao banco de dados
                        Statement statement = conexao.createStatement()) {
                        
                        ResultSet resultSet = statement.executeQuery(sql);
                        
                     
                        while (resultSet.next()) {
                           id = resultSet.getInt("id");                           
                        }
                        
                    }

                              }//fim do try     //fim do try     
                catch(ClassNotFoundException | SQLException e){     
                    System.err.println(e.getMessage());     
                }                
          
       
       return id;
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id_venda_Labe;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTextField precoItem_labe;
    public static javax.swing.JLabel preco_total_vendaLabel;
    public static javax.swing.JTextField produto_field;
    private javax.swing.JTextField quantidade_field;
    public static javax.swing.JLabel status_venda;
    public static javax.swing.JLabel total_itens;
    private javax.swing.JLabel total_itensLabel;
    // End of variables declaration//GEN-END:variables
}
