/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdv.sisac;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static pdv.sisac.pdv.Coidgo_ultimaVenda;
import static pdv.sisac.pdv.base;
import static pdv.sisac.pdv.caminho;
import static pdv.sisac.pdv.finalizada;
import static pdv.sisac.pdv.modelo;
import static pdv.sisac.pdv.porta;
import static pdv.sisac.pdv.produto_field;
import static pdv.sisac.pdv.senha;
import static pdv.sisac.pdv.tabela;
import static pdv.sisac.pdv.usuario;

/**
 *
 * @author meirinaldo
 */
public class listar_ultimas_vendas extends javax.swing.JFrame {

     NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
     static public JTable tabela;
     static public DefaultTableModel modelo =new DefaultTableModel();
  
    
    public listar_ultimas_vendas() {
        initComponents();
        criar_jtable();
        jScrollPane1.setViewportView(tabela);
        Listar_ultimas_vendas();
        
    }

    public void Listar_ultimas_vendas(){
            //Verificar se venda anterior foi fechada!!!!
                //Atributos de comando     
                String comando = "SELECT * FROM compra ORDER BY id LIMIT 15";     

                try{
                    Class.forName("com.mysql.jdbc.Driver");


                    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"+pdv.caminho+":"+pdv.porta+"/"+pdv.base, 
                                                                        pdv.usuario, pdv.senha); //Conecta-se ao banco de dados
                        Statement statement = conexao.createStatement()) {
                        
                        ResultSet resultSet = statement.executeQuery(comando);
                        
                     
                        while (resultSet.next()) {
                            
                           int cod = resultSet.getInt("id");
                           String cliente = resultSet.getString("cliente");
                           float total = resultSet.getFloat("total");
                           float troco = resultSet.getFloat("troco");
                           float din_recebido = resultSet.getFloat("din_recebido");
                           int finalizada = resultSet.getInt("finalizada");
                           int tipo_pagamento = resultSet.getInt("tipo_pagamento");
                           
                          
                           
                         modelo.addRow(new Object[] {cod, cliente,formatoMoeda.format(din_recebido),
                             formatoMoeda.format(troco),formatoMoeda.format(total),tipo_pagamento,finalizada} );

                
                        }
                        
                    }

                              }//fim do try     //fim do try     
                catch(ClassNotFoundException | SQLException e){     
                    System.err.println(e.getMessage());     
                }                
                
    }
    
    private void criar_jtable(){
        
        tabela = new JTable(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dinheiro Recebido");
        modelo.addColumn("Troco");
        modelo.addColumn("Total");
        modelo.addColumn("Tipo Pagamento");
        modelo.addColumn("Finalizada");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
        
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listar Ultimas Vendas");

        jButton1.setText("ATUALIZAR LISTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        //Limpar dados da Jtable
                    while (tabela.getModel().getRowCount() > 0){
                              modelo.removeRow(0);
                           }  

         //re-insirar dados atualizados
             Listar_ultimas_vendas();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(listar_ultimas_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listar_ultimas_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listar_ultimas_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listar_ultimas_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listar_ultimas_vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
