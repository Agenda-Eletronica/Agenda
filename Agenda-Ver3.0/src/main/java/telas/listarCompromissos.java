package telas;

import classes.Compromisso;
import classes.Evento;
import classes.GerenciaUsuario;
import classes.Tarefa;
import conexao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Listar compromissos.
 */
public class listarCompromissos extends javax.swing.JFrame {
    private List<Compromisso> compromissos;
    private DefaultListModel<String> listModel;

    /**
     * Creates new form listarCompromissos
     */
    public listarCompromissos() {
        initComponents();
        compromissos = new ArrayList<>();
        listModel = new DefaultListModel<>();
        listCompromissos.setModel(listModel);
        importarCompromissosDoBanco();
    }

    /**
     * Importa compromissos do banco de dados.
     */
    private void importarCompromissosDoBanco() {
        Connection connection = Conexao.getConexao();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  // Formato correto
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        GerenciaUsuario gerenciausuario = GerenciaUsuario.getInstancia();
        int userId = gerenciausuario.getId();

        try (Statement statement = connection.createStatement()) {
            // Importar eventos
            ResultSet resultSetEvento = statement.executeQuery("SELECT * FROM compromisso_evento WHERE id_usuario = " + userId);

            while (resultSetEvento.next()) {
                String titulo = resultSetEvento.getString("titulo_compromisso");
                String descricao = resultSetEvento.getString("descricao_compromisso");
                String dataStr = resultSetEvento.getString("data");
                Date data = dateFormat.parse(dataStr);
                LocalTime horario = resultSetEvento.getString("hora") != null ? LocalTime.parse(resultSetEvento.getString("hora"), timeFormatter) : null;
                String local = resultSetEvento.getString("localizacao");
                ArrayList<String> convidados = new ArrayList<>(); // Supondo que a lista de convidados esteja vazia ou que precise de outra lógica para preenchimento

                Evento evento = new Evento(titulo, descricao, data, horario, local, convidados);
                compromissos.add(evento);
                listModel.addElement(evento.toShortString());
            }

            // Importar tarefas
            ResultSet resultSetTarefa = statement.executeQuery("SELECT * FROM compromisso_tarefa WHERE id_usuario = " + userId);

            while (resultSetTarefa.next()) {
                String titulo = resultSetTarefa.getString("titulo_compromisso");
                String descricao = resultSetTarefa.getString("descricao");
                String dataStr = resultSetTarefa.getString("data_inicial");
                Date data = dateFormat.parse(dataStr);
                LocalTime horarioInicial = resultSetTarefa.getString("hora_inicial") != null ? LocalTime.parse(resultSetTarefa.getString("hora_inicial"), timeFormatter) : null;
                String dataFinalStr = resultSetTarefa.getString("data_final");
                Date dataFinal = dateFormat.parse(dataFinalStr);
                LocalTime horarioFinal = resultSetTarefa.getString("hora_final") != null ? LocalTime.parse(resultSetTarefa.getString("hora_final"), timeFormatter) : null;
                String prioridade = resultSetTarefa.getString("prioridade");

                Tarefa tarefa = new Tarefa(titulo, descricao, data, horarioInicial, dataFinal, horarioFinal, prioridade);
                compromissos.add(tarefa);
                listModel.addElement(tarefa.toShortString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCompromissos = new javax.swing.JList<>();
        removerButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
    
        jButton1.setText("jButton1");
    
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
    
        listCompromissos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listCompromissos);
    
        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedIndex = listCompromissos.getSelectedIndex();
                if (selectedIndex != -1) {
                    Compromisso compromisso = compromissos.get(selectedIndex);
                    removerCompromissoDoBanco(compromisso);
                    compromissos.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });
    
        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedIndex = listCompromissos.getSelectedIndex();
                if (selectedIndex != -1) {
                    Compromisso compromisso = compromissos.get(selectedIndex);
                    if (compromisso instanceof Evento) {
                        new telaEvento((Evento) compromisso).setVisible(true);
                    } else if (compromisso instanceof Tarefa) {
                        new telaTarefa((Tarefa) compromisso).setVisible(true);
                    }
                }
            }
        });
    
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
    }
    
    private void removerCompromissoDoBanco(Compromisso compromisso) {
        Connection connection = Conexao.getConexao();
    
        try (Statement statement = connection.createStatement()) {
            String query = "";
    
            if (compromisso instanceof Evento) {
                query = "DELETE FROM compromisso_evento WHERE titulo_compromisso = '" + compromisso.getTitulo() + "' AND descricao_compromisso = '" + compromisso.getDescricao() + "'";
            } else if (compromisso instanceof Tarefa) {
                query = "DELETE FROM compromisso_tarefa WHERE titulo_compromisso = '" + compromisso.getTitulo() + "' AND descricao = '" + compromisso.getDescricao() + "'";
            }
    
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(listarCompromissos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarCompromissos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarCompromissos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarCompromissos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarCompromissos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editarButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listCompromissos;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
