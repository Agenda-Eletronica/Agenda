/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package classes;

import java.util.Scanner;

import telas.telaCadastro;
import telas.telaLogin;

/**
 *
 * @author gutav
 */
public class Agenda {

    public static void main(String[] args) {
        
        Cadastro cadastro = new Cadastro();

        // Inicializar Tela de Cadastro
        telaCadastro telaCadastro = new telaCadastro(cadastro);
        telaCadastro.setVisible(true);

        // Inicializar Login com o mesmo Cadastro
        Login login = new Login(cadastro);
        telaLogin telaLogin = new telaLogin(login);
        telaLogin.setVisible(true);
        
    }

}
