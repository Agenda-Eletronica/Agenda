package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.Conexao;
import entity.Usuario;

public class UserDAO {

    public void cadastro(Usuario user){



        String sql = "INSERT INTO usuarios (nome, gmail, senha) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getGmail());
            ps.setString(3, user.getSenha());
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Erro na conexao:" + e.getMessage());
        }
    }

}
