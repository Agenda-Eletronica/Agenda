/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gutav
 */

public class Cadastro {

    List<Usuario> usuarios;

    public Cadastro(){
        this.usuarios = new ArrayList<>();
    }
    public void AdicionarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public boolean usuarioExistente(String email){
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
