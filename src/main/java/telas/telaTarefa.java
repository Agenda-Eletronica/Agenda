/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Compromisso;
import classes.Tarefa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gutav
 */
public class telaTarefa extends javax.swing.JFrame {

    /**
     * Creates new form telaCompromisso
     */
    Date selecDate;
    public telaTarefa(Date selecDate) {
        this.selecDate = selecDate;
        initComponents();
        atualizarData();
    }
    public void atualizarData(){
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
        dataInicialFild.setValue(selecDate);
        dataInicialFild.setText(dataFormatada.format(selecDate));
        dataFinalFild.setText(dataFormatada.format(selecDate));
        dataFinalFild.setValue(selecDate);
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
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dataInicialFild = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        choiceHoraInicial = new java.awt.Choice();
        choiceMinutoInicial = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDescricao = new java.awt.TextArea();
        dataFinalFild = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        choicePrioridade = new java.awt.Choice();
        choiceMinutoFinal = new java.awt.Choice();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        choiceHoraFinal = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(245, 420));
        setMinimumSize(new java.awt.Dimension(245, 420));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 360));

        jLabel1.setText("Descrição do compromisso: ");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo: ");

        dataInicialFild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInicialFildActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Inicial: ");

        jLabel4.setText("Hora");

        jLabel5.setText("Minutos");

        jLabel6.setText("Adição Tarefa");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDescricao.setPreferredSize(new java.awt.Dimension(200, 80));
        txtDescricao.setRows(10);

        dataFinalFild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataFinalFildActionPerformed(evt);
            }
        });

        jLabel7.setText("Data Final: ");

        jLabel8.setText("Hora");

        jLabel9.setText("Minutos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(83, 83, 83))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dataInicialFild)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(choiceHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(choiceMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(choicePrioridade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataFinalFild))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(choiceHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(choiceMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addComponent(jLabel1)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicialFild, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceMinutoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceMinutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinalFild, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(choicePrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        choiceHoraInicial.add("00");
        choiceHoraInicial.add("01");
        choiceHoraInicial.add("02");
        choiceHoraInicial.add("03");
        choiceHoraInicial.add("04");
        choiceHoraInicial.add("05");
        choiceHoraInicial.add("06");
        choiceHoraInicial.add("07");
        choiceHoraInicial.add("08");
        choiceHoraInicial.add("09");
        choiceHoraInicial.add("10");
        choiceHoraInicial.add("11");
        choiceHoraInicial.add("12");
        choiceHoraInicial.add("13");
        choiceHoraInicial.add("14");
        choiceHoraInicial.add("15");
        choiceHoraInicial.add("16");
        choiceHoraInicial.add("17");
        choiceHoraInicial.add("18");
        choiceHoraInicial.add("19");
        choiceHoraInicial.add("20");
        choiceHoraInicial.add("21");
        choiceHoraInicial.add("22");
        choiceHoraInicial.add("23");
        choiceMinutoInicial.add("00");
        choiceMinutoInicial.add("15");
        choiceMinutoInicial.add("30");
        choiceMinutoInicial.add("45");
        choicePrioridade.add("Baixa Prioridade");
        choicePrioridade.add("Média Prioridade");
        choicePrioridade.add("Alta Prioridade");
        choicePrioridade.add("Urgente");
        choiceMinutoFinal.add("00");
        choiceMinutoFinal.add("15");
        choiceMinutoFinal.add("30");
        choiceMinutoFinal.add("45");
        choiceHoraFinal.add("00");
        choiceHoraFinal.add("01");
        choiceHoraFinal.add("02");
        choiceHoraFinal.add("03");
        choiceHoraFinal.add("04");
        choiceHoraFinal.add("05");
        choiceHoraFinal.add("06");
        choiceHoraFinal.add("07");
        choiceHoraFinal.add("08");
        choiceHoraFinal.add("09");
        choiceHoraFinal.add("10");
        choiceHoraFinal.add("11");
        choiceHoraFinal.add("12");
        choiceHoraFinal.add("13");
        choiceHoraFinal.add("14");
        choiceHoraFinal.add("15");
        choiceHoraFinal.add("16");
        choiceHoraFinal.add("17");
        choiceHoraFinal.add("18");
        choiceHoraFinal.add("19");
        choiceHoraFinal.add("20");
        choiceHoraFinal.add("21");
        choiceHoraFinal.add("22");
        choiceHoraFinal.add("23");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String horarioInicialStr = choiceHoraInicial.getSelectedItem() +":"+ choiceMinutoInicial.getSelectedItem();
        String horarioFinalStr = choiceHoraFinal.getSelectedItem() +":"+ choiceMinutoInicial.getSelectedItem();
        Date dataInicial = selecDate;
        Date DataFinal = (Date) dataFinalFild.getValue();
        String prioridade = choicePrioridade.getSelectedItem();
        
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        
        LocalTime horarioInicial = LocalTime.parse(horarioInicialStr, formatter);
        LocalTime horarioFinal = LocalTime.parse(horarioFinalStr, formatter);
        
        Compromisso compromisso = new Tarefa(titulo, descricao, dataInicial, horarioInicial, DataFinal, horarioFinal, prioridade);
        System.out.println(compromisso.toString());
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void dataInicialFildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInicialFildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataInicialFildActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void dataFinalFildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataFinalFildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataFinalFildActionPerformed

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
            java.util.logging.Logger.getLogger(telaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaTarefa(new Date()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceHoraFinal;
    private java.awt.Choice choiceHoraInicial;
    private java.awt.Choice choiceMinutoFinal;
    private java.awt.Choice choiceMinutoInicial;
    private java.awt.Choice choicePrioridade;
    private javax.swing.JFormattedTextField dataFinalFild;
    private javax.swing.JFormattedTextField dataInicialFild;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextArea txtDescricao;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
