/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gutav
 */
public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";// Modelo para autenticar se um email é válido.
    private static final String SENHA_PATTERN = "^(?=.*[A-Z])(?=.*\\d).{6,}$"; // Modelo para válidar se a senha é válida. Deve conter no minimo 6 digitos sento pelo menos 1 maiuscula e um numero. Não permite simbolos.

    public Usuario() {
    }
    
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuario( String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static boolean validarEmail(Usuario usuario){
        return usuario.getEmail().matches(EMAIL_PATTERN);
    }
    public static Boolean validarSenha(Usuario usuario){
        return usuario.getSenha().matches(SENHA_PATTERN);
    }
    public String toString() {
        return "Nome: " + this.nome + "\n" +
               "Email: " + this.email + "\n" +
               "Senha: " + this.senha;
    }
    
    
}
