package telas;

import classes.Tarefa;
import classes.GerenciaUsuario;
import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Formulário para criação e edição de tarefas.
 */
public class telaTarefa extends javax.swing.JFrame {

    private Tarefa tarefa;
    private boolean isEditing;
    private Date selecDate;

    public telaTarefa(Date selecDate) {
        this.selecDate = selecDate;
        initComponents();
        atualizarData(selecDate);
        this.isEditing = false;
    }

    public telaTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
        initComponents();
        preencherDados();
        this.isEditing = true;
    }

    private void atualizarData(Date selecDate) {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd 'de' MMM 'de' yyyy"); // Novo formato
        dataInicial.setValue(selecDate);
        dataInicial.setText(dataFormatada.format(selecDate));
        dataFinal.setValue(selecDate);
        dataFinal.setText(dataFormatada.format(selecDate));
    }

    private void preencherDados() {
        txtTitulo.setText(tarefa.getTitulo());
        txtDescricao.setText(tarefa.getDescricao());
        dataInicial.setValue(tarefa.getData());
        dataInicial.setText(new SimpleDateFormat("dd-MM-yyyy").format(tarefa.getData()));
        choicePrioridade.select(tarefa.getPrioridade());
        dataFinal.setValue(tarefa.getDataFinal());
        dataFinal.setText(new SimpleDateFormat("dd-MM-yyyy").format(tarefa.getDataFinal()));
        choiceHoraFinal.select(tarefa.getHorarioFinal().getHour());
        choiceMinutoFinal.select(tarefa.getHorarioFinal().getMinute());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        choiceHora = new java.awt.Choice();
        choiceMinuto = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        txtDescricao = new java.awt.TextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        choiceHoraFinal = new java.awt.Choice();
        choiceMinutoFinal = new java.awt.Choice();
        jLabel10 = new javax.swing.JLabel();
        choicePrioridade = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(280, 460));
        setMinimumSize(new java.awt.Dimension(280, 460));
        setPreferredSize(new java.awt.Dimension(280, 460));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 360));

        jLabel1.setText("Descrição do compromisso:");

        jLabel2.setText("Título:");

        jLabel3.setText("Data Inicial:");

        jLabel4.setText("Hora Inicial");

        jLabel5.setText("Minutos Iniciais");

        jLabel6.setText("Adição de compromisso");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabel7.setText("Prioridade:");

        jLabel8.setText("Data Final:");

        jLabel9.setText("Hora Final");

        jLabel10.setText("Minutos Finais");

        choiceHora.add("00");
        choiceHora.add("01");
        choiceHora.add("02");
        choiceHora.add("03");
        choiceHora.add("04");
        choiceHora.add("05");
        choiceHora.add("06");
        choiceHora.add("07");
        choiceHora.add("08");
        choiceHora.add("09");
        choiceHora.add("10");
        choiceHora.add("11");
        choiceHora.add("12");
        choiceHora.add("13");
        choiceHora.add("14");
        choiceHora.add("15");
        choiceHora.add("16");
        choiceHora.add("17");
        choiceHora.add("18");
        choiceHora.add("19");
        choiceHora.add("20");
        choiceHora.add("21");
        choiceHora.add("22");
        choiceHora.add("23");

        choiceMinuto.add("00");
        choiceMinuto.add("15");
        choiceMinuto.add("30");
        choiceMinuto.add("45");

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

        choiceMinutoFinal.add("00");
        choiceMinutoFinal.add("15");
        choiceMinutoFinal.add("30");
        choiceMinutoFinal.add("45");

        choicePrioridade.add("Baixa");
        choicePrioridade.add("Média");
        choicePrioridade.add("Alta");
        choicePrioridade.add("Urgente");

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
                                .addComponent(dataInicial)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(choiceHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(choiceMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel2)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButtonConfirmar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(choicePrioridade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataFinal))
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
                .addContainerGap(28, Short.MAX_VALUE))
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
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(choicePrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        GerenciaUsuario gerenciausuario = GerenciaUsuario.getInstancia();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String horarioStr = choiceHora.getSelectedItem() + ":" + choiceMinuto.getSelectedItem();
        Date dataInicial = (Date) this.dataInicial.getValue();
        String dataInicialFormatada = sdf.format(dataInicial);
    
        String horarioFinalStr = choiceHoraFinal.getSelectedItem() + ":" + choiceMinutoFinal.getSelectedItem();
        Date dataFinal = (Date) this.dataFinal.getValue();
        String dataFinalFormatada = sdf.format(dataFinal);
    
        String prioridade = choicePrioridade.getSelectedItem();
    
        if (tarefa == null) {
            tarefa = new Tarefa();
        }
    
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setData(dataInicial);
        tarefa.setHorarioInicial(LocalTime.parse(horarioStr, DateTimeFormatter.ofPattern("HH:mm")));
        tarefa.setDataFinal(dataFinal);
        tarefa.setHorarioFinal(LocalTime.parse(horarioFinalStr, DateTimeFormatter.ofPattern("HH:mm")));
        tarefa.setPrioridade(prioridade);
    
        try {
            String sql = isEditing
                ? "UPDATE compromisso_tarefa SET descricao = ?, data_inicial = ?, hora_inicial = ?, data_final = ?, hora_final = ?, prioridade = ? WHERE Titulo_compromisso = ?"
                : "INSERT INTO compromisso_tarefa (ID_usuario, Titulo_compromisso, descricao, data_inicial, hora_inicial, data_final, hora_final, prioridade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            if (isEditing) {
                stmt.setString(1, tarefa.getDescricao());
                stmt.setString(2, dataInicialFormatada);
                stmt.setString(3, horarioStr);
                stmt.setString(4, dataFinalFormatada);
                stmt.setString(5, horarioFinalStr);
                stmt.setString(6, tarefa.getPrioridade());
                stmt.setString(7, tarefa.getTitulo());
            } else {
                stmt.setInt(1, gerenciausuario.getId());
                stmt.setString(2, tarefa.getTitulo());
                stmt.setString(3, tarefa.getDescricao());
                stmt.setString(4, dataInicialFormatada);
                stmt.setString(5, horarioStr);
                stmt.setString(6, dataFinalFormatada);
                stmt.setString(7, horarioFinalStr);
                stmt.setString(8, tarefa.getPrioridade());
            }
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        this.dispose();
    }

    private void dataInicialActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaTarefa(new Date()).setVisible(true);
            }
        });
    }

    private java.awt.Choice choiceHora;
    private java.awt.Choice choiceMinuto;
    private java.awt.Choice choiceHoraFinal;
    private java.awt.Choice choiceMinutoFinal;
    private java.awt.Choice choicePrioridade;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextArea txtDescricao;
    private javax.swing.JTextField txtTitulo;
}
