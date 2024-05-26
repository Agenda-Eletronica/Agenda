/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gutav
 */

public class Cadastro {
    
    List<Usuario> usuario;

    public Cadastro(){
        this.usuario = new ArrayList<>();
    }
    public void AdicionarUsuario(Usuario usuario){
        this.usuario.add(usuario);
    }
    public List<Usuario> getUsuarios(){
        return usuario;
    }
    
    
}
