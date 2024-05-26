package com.mycompany.agenda.telas;

import java.awt.event.*;

import javax.swing.*;

public class telaLoginGpt {
    public static void main(String[] args) {
        // Criação do frame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        // Criação do painel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        // Tornando o frame visível
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label de usuário
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Campo de texto para usuário
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Label de senha
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Campo de texto para senha
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Adicionando o ActionListener ao botão
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin(userText.getText(), new String(passwordText.getPassword()));
            }
        });
    }

    // Método que será chamado quando o botão for clicado
    private static void performLogin(String username, String password) {
        // Aqui você pode adicionar o código para realizar o login
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Lógica de autenticação vai aqui
    }
}