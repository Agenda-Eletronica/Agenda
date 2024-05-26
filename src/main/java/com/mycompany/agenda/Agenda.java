/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agenda;

import java.util.Scanner;

/**
 *
 * @author gutav
 */
public class Agenda {

    public static void main(String[] args) {
        
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);

        Usuario usuario1 = new Usuario();
        String nome = "Gustavo";
        String email = "gustavohe2016@gamil.com";
        String senha = "Adimin4";

        usuario1.setNome(nome);
        usuario1.setEmail(email);
        usuario1.setSenha(senha);
        cadastro.AdicionarUsuario(usuario1);
        input.close();
        System.out.println(usuario1.toString());
        if(Usuario.validarEmail(usuario1)){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
        Login.autenticarMeu(usuario1);
        Data data = new Data(2024, 5, 20);
        Horario hora = new Horario(8, 30);
        Compromisso compromisso = new Compromisso("Comprar pão", "Devo ir comprar pão segunda feira", data, hora, usuario1);
        System.out.println(compromisso.toString());
        
    }

}
