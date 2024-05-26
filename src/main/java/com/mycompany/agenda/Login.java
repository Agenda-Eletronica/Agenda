/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda;

/**
 *
 * @author gutav
 */
public class Login {
    
    private String senha;
    private String email;

    public Login(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    

    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public String getEmail(){
        return email;
    }

    public static boolean autenticarMeu (Usuario usuario){

        if(Usuario.validarEmail(usuario) && Usuario.validarSenha(usuario)){
            System.out.println("Autenticado com sucesso.");
            return true;
        }else{
            System.out.println("não autenticado.");
            return false;
        }
    }
    
}
