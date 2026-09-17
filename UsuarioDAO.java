import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // =========================================
    // LOGIN
    // =========================================

    public Usuario fazerLogin(String login, String senha) {

        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");

                String nome = rs.getString("nome");
                String loginBanco = rs.getString("login");
                String senhaBanco = rs.getString("senha");
                String perfil = rs.getString("perfil");

                return new Usuario(id, nome, loginBanco, senhaBanco, perfil);
            }

        } catch (Exception e) {

            System.out.println("Erro ao fazer login");
            e.printStackTrace();
        }

        return null;
    }

    // =========================================
    // CADASTRAR USUÁRIO
    // =========================================

    public void cadastrarUsuario(Usuario u) {

        String sql = "INSERT INTO usuario (nome, login, senha, perfil) VALUES (?, ?, ?, ?)";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());

            stmt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar usuário");

            // LOGIN DUPLICADO
            if (e.getMessage().contains("Duplicate")) {

                System.out.println("Esse login já existe!");
            }

            e.printStackTrace();
        }
    }

    // =========================================
    // REMOVER USUÁRIO
    // =========================================

    public void removerUsuario(int id) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Usuário removido com sucesso!");

            } else {

                System.out.println("Usuário não encontrado.");
            }

        } catch (Exception e) {

            System.out.println("Erro ao remover usuário");
            e.printStackTrace();
        }
    }
}