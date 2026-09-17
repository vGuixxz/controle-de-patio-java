import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {

        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:3306/gerenciamento_de_patio";
            String usuario = "root";
            String senha = "@gGui01020304";

            conn = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conectado ao banco!");

        } catch (Exception e) {

            System.out.println("Erro na conexão");
            e.printStackTrace();

        }

        return conn;
    }
}
