import java.sql.*;
import java.util.ArrayList;

public class CaminhaoDAO {

    // =========================================
    // INSERIR CAMINHÃO
    // =========================================

    public void inserirCaminhao(Movimentacao m) {

        String sql = "INSERT INTO caminhao (frota, motorista, container, tipo_operacao, shipment, nota_fiscal, referencia, produto, hora_chegada, situacao, ocorrencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, m.frota);
            stmt.setString(2, m.motorista);
            stmt.setString(3, m.container);
            stmt.setString(4, m.tipoOperacao);

            stmt.setString(5, m.shipment);
            stmt.setString(6, m.notaFiscal);
            stmt.setString(7, m.referencia);
            stmt.setString(8, m.produto);

            stmt.setString(9, m.horaChegada);

            stmt.setString(10, m.situacao);
            stmt.setString(11, m.ocorrencia);

            stmt.executeUpdate();

            System.out.println("Caminhão registrado com sucesso!");

        } catch (Exception e) {

            System.out.println("Erro ao registrar caminhão");
            e.printStackTrace();
        }
    }

    // =========================================
    // LISTAR CAMINHÕES NO PÁTIO
    // =========================================

    public ArrayList<Movimentacao> listarCaminhoes() {

        ArrayList<Movimentacao> lista = new ArrayList<>();

        String sql = "SELECT * FROM caminhao WHERE hora_saida IS NULL";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Movimentacao m = new Movimentacao();

                m.id = rs.getInt("id_caminhao");

                m.frota = rs.getString("frota");
                m.motorista = rs.getString("motorista");
                m.container = rs.getString("container");

                m.tipoOperacao = rs.getString("tipo_operacao");

                m.shipment = rs.getString("shipment");

                m.notaFiscal = rs.getString("nota_fiscal");
                m.referencia = rs.getString("referencia");
                m.produto = rs.getString("produto");

                m.horaChegada = rs.getString("hora_chegada");
                m.horaSaida = rs.getString("hora_saida");

                m.situacao = rs.getString("situacao");
                m.ocorrencia = rs.getString("ocorrencia");

                lista.add(m);
            }

        } catch (Exception e) {

            System.out.println("Erro ao listar caminhões");
            e.printStackTrace();
        }

        return lista;
    }

    // =========================================
    // ATUALIZAR SITUAÇÃO
    // =========================================

    public void atualizarSituacao(int id, String situacao, String ocorrencia) {

        String sql = "UPDATE caminhao SET situacao = ?, ocorrencia = ? WHERE id_caminhao = ?";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, situacao);
            stmt.setString(2, ocorrencia);
            stmt.setInt(3, id);

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");

        } catch (Exception e) {

            System.out.println("Erro ao atualizar");
            e.printStackTrace();
        }
    }

    // =========================================
    // REGISTRAR SAÍDA
    // =========================================

    public void registrarSaida(int id, String horaSaida) {

        String sql = "UPDATE caminhao SET hora_saida = ? WHERE id_caminhao = ?";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, horaSaida);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            System.out.println("Saída registrada!");

        } catch (Exception e) {

            System.out.println("Erro ao registrar saída");
            e.printStackTrace();
        }
    }

    // =========================================
    // HISTÓRICO
    // =========================================

    public ArrayList<Movimentacao> listarHistorico() {

        ArrayList<Movimentacao> lista = new ArrayList<>();

        String sql = "SELECT * FROM caminhao WHERE hora_saida IS NOT NULL";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Movimentacao m = new Movimentacao();

                m.id = rs.getInt("id_caminhao");

                m.frota = rs.getString("frota");
                m.motorista = rs.getString("motorista");
                m.container = rs.getString("container");

                m.tipoOperacao = rs.getString("tipo_operacao");

                m.shipment = rs.getString("shipment");

                m.notaFiscal = rs.getString("nota_fiscal");
                m.referencia = rs.getString("referencia");
                m.produto = rs.getString("produto");

                m.horaChegada = rs.getString("hora_chegada");
                m.horaSaida = rs.getString("hora_saida");

                m.situacao = rs.getString("situacao");
                m.ocorrencia = rs.getString("ocorrencia");

                lista.add(m);
            }

        } catch (Exception e) {

            System.out.println("Erro ao listar histórico");
            e.printStackTrace();
        }

        return lista;
    }

    // =========================================
    // REMOVER CAMINHÃO
    // =========================================

    public void removerCaminhao(int id) {

        String sql = "DELETE FROM caminhao WHERE id_caminhao = ?";

        Connection conn = Conexao.conectar();

        try {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {

                System.out.println("Caminhão removido com sucesso!");

            } else {

                System.out.println("Caminhão não encontrado.");
            }

        } catch (Exception e) {

            System.out.println("Erro ao remover caminhão");
            e.printStackTrace();
        }
    }
}