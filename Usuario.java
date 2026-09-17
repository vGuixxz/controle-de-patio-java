public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;

    // 🔵 CONSTRUTOR
    public Usuario(int id, String nome, String login, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // 🔹 GETTERS
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getPerfil() {
        return perfil;
    }

    // 🔹 SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    // 🔹 MOSTRAR DADOS
    public void mostrarDados() {
        System.out.println("=== DADOS DO USUÁRIO ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Login: " + login);
        System.out.println("Perfil: " + perfil);
        System.out.println("------------------------");
    }
}