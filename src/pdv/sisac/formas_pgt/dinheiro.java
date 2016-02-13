/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdv.sisac.formas_pgt;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import javax.swing.JOptionPane;

import static pdv.sisac.pdv.*;
/**
 *
 * @author meirinaldo
 */
public class dinheiro extends javax.swing.JFrame {

    
      NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
           
    //iniciando variveis dos calculos
    
    float valor_totalVenda = pdv.sisac.pdv.total_compra;
  //  float valor_recebido = Float.parseFloat(base) ;
    float troco_calcula;
    float valor_dinheiro_rece;
    //convertando valores para real
        //ValorTotal
    BigDecimal bd = new BigDecimal (Float.toString(pdv.sisac.pdv.total_compra));
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    String Volalor_totalConvert = nf.format (bd); // deve mostrar "R$ 12,34"
    
   
    
    /**
     * Creates new form dinheiro
     */
    public dinheiro() {
        initComponents();
        valor_total_field.setText(Volalor_totalConvert);
        desconto_fild.setEditable(false);
        dinheiro_pago.requestFocus();
        bt_finalizarVenda.setVisible(false);
        troco_field.setEditable(false);
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
        jLabel2 = new javax.swing.JLabel();
        desconto_fild = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_finalizarVenda = new javax.swing.JButton();
        valor_total_field = new javax.swing.JFormattedTextField();
        dinheiro_pago = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        troco_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Valor total");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Desconto:");

        desconto_fild.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        desconto_fild.setForeground(new java.awt.Color(255, 0, 0));
        desconto_fild.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Dinheiro");

        bt_finalizarVenda.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        bt_finalizarVenda.setForeground(new java.awt.Color(197, 1, 1));
        bt_finalizarVenda.setText("Encerrar Venda");
        bt_finalizarVenda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bt_finalizarVendaItemStateChanged(evt);
            }
        });
        bt_finalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarVendaActionPerformed(evt);
            }
        });
        bt_finalizarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_finalizarVendaKeyPressed(evt);
            }
        });

        valor_total_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        dinheiro_pago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        dinheiro_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dinheiro_pagoActionPerformed(evt);
            }
        });
        dinheiro_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dinheiro_pagoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Troco");

        troco_field.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        troco_field.setForeground(new java.awt.Color(255, 0, 0));
        troco_field.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(bt_finalizarVenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desconto_fild, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dinheiro_pago)
                    .addComponent(troco_field)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valor_total_field))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(valor_total_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(desconto_fild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(troco_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dinheiro_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(59, 59, 59)
                .addComponent(bt_finalizarVenda)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_finalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarVendaActionPerformed
        encerra_venda_dinheiro();
    }//GEN-LAST:event_bt_finalizarVendaActionPerformed

    private void dinheiro_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dinheiro_pagoKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_finalizarVenda.setVisible(true);

            //iniciando variaveis para cálculo
            valor_dinheiro_rece = Float.parseFloat(dinheiro_pago.getText());
           // float desconto = (Float.parseFloat(desconto_fild.getText()));

            //calcula troco
            troco_calcula =  valor_dinheiro_rece - valor_totalVenda ;
            
            
 
            if(valor_dinheiro_rece > valor_totalVenda){
            
            dinheiro_pago.setText(formatoMoeda.format(Float.parseFloat(dinheiro_pago.getText())));
            troco_field.setText(formatoMoeda.format(troco_calcula));
            bt_finalizarVenda.setFocusable(true);
            } else{
                JOptionPane.showMessageDialog(this, "Desculpe você deve inserir um valor maior que o totalx");
            }
            
            
        }

    }//GEN-LAST:event_dinheiro_pagoKeyPressed

    private void dinheiro_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dinheiro_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dinheiro_pagoActionPerformed

    private void bt_finalizarVendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bt_finalizarVendaItemStateChanged
           
    }//GEN-LAST:event_bt_finalizarVendaItemStateChanged

    private void bt_finalizarVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_finalizarVendaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
               encerra_venda_dinheiro();
           }
    }//GEN-LAST:event_bt_finalizarVendaKeyPressed

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
            java.util.logging.Logger.getLogger(dinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dinheiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dinheiro().setVisible(true);
            }
        });
    }
    
    public void encerra_venda_dinheiro(){
        
        int opcao = JOptionPane.showConfirmDialog(this, "Confirma o encerramento da venda?");
        
        if (opcao == 0){ 
             
                     try {
            //Registra JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
 
            //Abrindo a conexão
            //Abrindo a conexão
            Connection conn =  DriverManager.getConnection("jdbc:mysql://"+caminho+":"+porta+"/"+base,usuario, senha); //Conecta-se ao banco de dados
  
            //Executa a query de atualização
            java.sql.Statement st = conn.createStatement();
            st.executeUpdate("UPDATE compra SET subtotal='"
                    + total_compra + "',total='"
                    + total_compra + "',finalizada='"
                    + 1 + "',tipo_pagamento='"
                    + 1 + "',din_recebido='"
                    + 12.99 + "',troco='"
                    + troco_calcula
                    + "' WHERE id='" + id_venda_atual + "'");
            JOptionPane.showMessageDialog(rootPane, "Aluno atualizado");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }//Fim try
             
             

        }
                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_finalizarVenda;
    private javax.swing.JTextField desconto_fild;
    private javax.swing.JFormattedTextField dinheiro_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField troco_field;
    private javax.swing.JFormattedTextField valor_total_field;
    // End of variables declaration//GEN-END:variables
}
