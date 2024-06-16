package telas;

import classes.Evento;
import classes.GerenciaUsuario;
import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class telaEvento extends javax.swing.JFrame {
    private Date selecDate;
    private Evento evento;
    private boolean isEditing;

    public telaEvento(Date selecDate) {
        this.selecDate = selecDate;
        initComponents();
        atualizarData();
        this.isEditing = false;
    }

    public telaEvento(Evento evento) {
        this.evento = evento;
        this.selecDate = evento.getData();
        initComponents();
        preencherDados();
        this.isEditing = true;
    }

    private void atualizarData() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
        dataInical.setValue(selecDate);
        dataInical.setText(dataFormatada.format(selecDate));
    }

    private void preencherDados() {
        txtTitulo.setText(evento.getTitulo());
        txtDescricao.setText(evento.getDescricao());
        dataInical.setValue(evento.getData());
        dataInical.setText(new SimpleDateFormat("dd-MM-yyyy").format(evento.getData()));
        txtLocal.setText(evento.getLocal());
        // Preencher lista de convidados
        for (String convidado : evento.getConvidados()) {
            listConvidados.add(convidado);
        }
        choiceHora.select(String.valueOf(evento.getHorario().getHour()));
        choiceMinuto.select(String.valueOf(evento.getHorario().getMinute()));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dataInical = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        choiceHora = new java.awt.Choice();
        choiceMinuto = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDescricao = new java.awt.TextArea();
        txtLocal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        participanteField = new javax.swing.JTextField();
        adicionarButton = new javax.swing.JButton();
        listConvidados = new java.awt.List();
        removerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 360));

        jLabel1.setText("Descrição do compromisso:");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo:");

        dataInical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInicalActionPerformed(evt);
            }
        });

        jLabel3.setText("Data:");

        jLabel4.setText("Hora");

        jLabel5.setText("Minutos");

        jLabel6.setText("Adição de compromisso");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Local");

        jLabel8.setText("Participante");

        adicionarButton.setText("Adicionar");
        adicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarButtonActionPerformed(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dataInical, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(choiceHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(choiceMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel6))
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addComponent(txtLocal, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listConvidados, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(participanteField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adicionarButton)
                                    .addComponent(removerButton)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInical, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceHora, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(choiceMinuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(participanteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(listConvidados, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(removerButton))
                .addGap(241, 241, 241))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        GerenciaUsuario gerenciausuario = GerenciaUsuario.getInstancia();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();
        String horarioStr = choiceHora.getSelectedItem() + ":" + choiceMinuto.getSelectedItem();
        Date dataInicial = (Date) this.dataInical.getValue();
        String dataFormatada = sdf.format(dataInicial);
        LocalTime horario = LocalTime.parse(horarioStr, DateTimeFormatter.ofPattern("HH:mm"));
        String local = txtLocal.getText();
    
        ArrayList<String> convidados = new ArrayList<>();
        for (String convidado : listConvidados.getItems()) {
            convidados.add(convidado);
        }
    
        if (evento == null) {
            evento = new Evento(titulo, descricao, dataInicial, horario, local, convidados);
        } else {
            evento.setTitulo(titulo);
            evento.setDescricao(descricao);
            evento.setData(dataInicial);
            evento.setHorario(horario);
            evento.setLocal(local);
            evento.setConvidados(convidados);
        }
    
        try {
            String sql = isEditing
                ? "UPDATE compromisso_evento SET Titulo_compromisso = ?, descricao_compromisso = ?, data = ?, hora = ?, localizacao = ? WHERE Titulo_compromisso = ?"
                : "INSERT INTO compromisso_evento (ID_usuario, Titulo_compromisso, descricao_compromisso, data, hora, localizacao) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            if (isEditing) {
                stmt.setString(1, evento.getTitulo());
                stmt.setString(2, evento.getDescricao());
                stmt.setString(3, new SimpleDateFormat("dd-MM-yyyy").format(evento.getData()));
                stmt.setString(4, evento.getHorario().toString());
                stmt.setString(5, evento.getLocal());
                stmt.setString(6, evento.getTitulo()); // Adiciona o título do compromisso para a condição WHERE
            } else {
                stmt.setInt(1, gerenciausuario.getId());
                stmt.setString(2, evento.getTitulo());
                stmt.setString(3, evento.getDescricao());
                stmt.setString(4, new SimpleDateFormat("dd-MM-yyyy").format(evento.getData()));
                stmt.setString(5, evento.getHorario().toString());
                stmt.setString(6, evento.getLocal());
            }
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        this.dispose();
    }

    private void dataInicalActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void adicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String participante = participanteField.getText();
        if (!participante.isEmpty()) {
            listConvidados.add(participante);
            participanteField.setText("");
        }
    }

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selecionado = listConvidados.getSelectedItem();
        if (selecionado != null) {
            listConvidados.remove(selecionado);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaEvento(new Date()).setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton adicionarButton;
    private java.awt.Choice choiceHora;
    private java.awt.Choice choiceMinuto;
    private javax.swing.JFormattedTextField dataInical;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private java.awt.List listConvidados;
    private javax.swing.JTextField txtTitulo;
    private java.awt.TextArea txtDescricao;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField participanteField;
    private javax.swing.JButton removerButton;
    // End of variables declaration
}
