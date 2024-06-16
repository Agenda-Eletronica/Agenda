package telas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import classes.Evento;
import classes.GerenciaUsuario;
import classes.Tarefa;
import conexao.Conexao;


public class listarCompromissos extends JFrame {

    GerenciaUsuario gerenciausuario = GerenciaUsuario.getInstancia();
    Evento evento = Evento.getInstancia();
    Tarefa tarefa = Tarefa.getInstancia();
    String tituloTarefa = null;
    String tituloEvento = null;


    public listarCompromissos() {
        initComponents(); // Inicializa os componentes Swing

        // Adiciona itens de exemplo à lista
        adicionarItens();
    }

    private void adicionarItens() {
        DefaultListModel<String> model = new DefaultListModel<>();
        PreparedStatement getTituloCompromissoEvento = null;
        PreparedStatement getTituloCompromissoTarefa = null;

        try {
            String sql = "SELECT Titulo_compromisso, data, localizacao, descricao_compromisso, hora FROM compromisso_evento WHERE id_usuario = ?";
            getTituloCompromissoEvento = Conexao.getConexao().prepareStatement(sql);
            getTituloCompromissoEvento.setInt(1, gerenciausuario.getId());
            ResultSet rs = getTituloCompromissoEvento.executeQuery();

            while(rs.next()){
                String comp = rs.getString("Titulo_compromisso");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                String local = rs.getString("localizacao");
                String desc = rs.getString("descricao_compromisso");
                model.addElement("EVENTO: " + comp + " " + data + " " + hora + " " + local + " " + desc);
                tituloEvento = comp;
                
            }

        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados " +  ex.getMessage());
  
        }
        try {
            String sql = "SELECT Titulo_compromisso, data_inicial, hora_inicial, data_final, hora_final, prioridade, descricao FROM compromisso_tarefa WHERE id_usuario = ?";
            getTituloCompromissoTarefa = Conexao.getConexao().prepareStatement(sql);
            getTituloCompromissoTarefa.setInt(1, gerenciausuario.getId());
            ResultSet rs = getTituloCompromissoTarefa.executeQuery();

            while(rs.next()){
                String comp = rs.getString("Titulo_compromisso");
                String dataI = rs.getString("data_inicial");
                String horaI = rs.getString("hora_inicial");
                String dataF = rs.getString("data_final");
                String horaF = rs.getString("hora_final");
                String prioridade = rs.getString("prioridade");
                String desc = rs.getString("descricao");
                model.addElement("TAREFA: " + comp + " " + dataI + " " + horaI + " -> " + dataF + " " + horaF + " " + prioridade + " " + desc);
                tituloTarefa = comp;
                
            }

        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados " +  ex.getMessage());

        }


        lc.setModel(model);
    }

    /**
     * Este método é gerado automaticamente pelo NetBeans e define a disposição dos componentes.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        lc = new javax.swing.JList<>();
        rb = new javax.swing.JButton();
        eb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lc);

        rb.setText("Remover");


        eb.setText("Editar");

        eb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebActionPerformed(evt); // Método que será chamado ao clicar no botão
            }
        });
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt); // Método que será chamado ao clicar no botão
            }
        });



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eb, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void ebActionPerformed(java.awt.event.ActionEvent evt) {
        //edita
        int index = lc.getSelectedIndex();
        if(index != -1){
            String selecionado = lc.getModel().getElementAt(index);
            
            if(selecionado.charAt(0) == 'T'){
                new telaTarefa(tarefa.getData()).setVisible(true);
                apagarItem();
                dispose();
            }
            if(selecionado.charAt(0) == 'E'){
                new telaEvento(evento.getData()).setVisible(true);
                apagarItem();
                dispose();
            }
        }

    }
    private void apagarItem(){
        int index = lc.getSelectedIndex();

        if(index != -1){
            String selecionado = lc.getModel().getElementAt(index);
            PreparedStatement removeSelecionado = null;
    

            if(selecionado.charAt(0) == 'T'){

                try {
                    String sql = "DELETE FROM compromisso_tarefa WHERE titulo_compromisso = ? AND id_usuario = ?";
                    removeSelecionado = Conexao.getConexao().prepareStatement(sql);
                    removeSelecionado.setString(1, tituloTarefa);
                    removeSelecionado.setInt(2, gerenciausuario.getId());
                    removeSelecionado.execute();
                    adicionarItens();
                    
                } catch (SQLException ex) {
                    System.out.println("Erro banco de dados apagar compromisso " + ex.getMessage());
                }
                
            } else if(selecionado.charAt(0) == 'E'){
                try {
                    String sql = "DELETE FROM compromisso_evento WHERE titulo_compromisso = ? AND id_usuario = ?";
                    removeSelecionado = Conexao.getConexao().prepareStatement(sql);
                    removeSelecionado.setString(1, tituloEvento);
                    removeSelecionado.setInt(2, gerenciausuario.getId());
                    removeSelecionado.execute();
                    adicionarItens();
                    
                } catch (SQLException ex) {
                    System.out.println("Erro banco de dados apagar compromisso " + ex.getMessage());
                }

            }
            
            
        }

    }
    private void rbActionPerformed(java.awt.event.ActionEvent evt) {
        //apaga
        apagarItem();


    }


    public static void main(String args[]) {
        // Define o look and feel do Nimbus para uma aparência mais moderna
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarCompromissos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Cria e exibe o JFrame
        java.awt.EventQueue.invokeLater(() -> {
            new listarCompromissos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> lc;
    private javax.swing.JButton rb;
    // End of variables declaration//GEN-END:variables
}
