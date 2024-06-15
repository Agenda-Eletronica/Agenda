import telas.telaLogin;


public class Main {
    
    public static void main(String[] args){

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex){

            System.out.println("Driver nao encontrado");
        }
        
       new telaLogin().setVisible(true);
    }
}
