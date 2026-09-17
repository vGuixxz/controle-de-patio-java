import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CaminhaoDAO dao = new CaminhaoDAO();

        Usuario usuario = null;

        // =========================================
        // LOGIN
        // =========================================

        while (usuario == null) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Login: ");
            String login = sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            usuario = usuarioDAO.fazerLogin(login, senha);

            if (usuario == null) {

                System.out.println("Login inválido!");

            } else {

                System.out.println("\nBem-vindo " + usuario.getNome());
                System.out.println("Perfil: " + usuario.getPerfil());
            }
        }

        // =========================================
        // VERIFICA SE É ADMIN
        // =========================================

        boolean admin = usuario.getPerfil().equals("admin");

        int opcao;

        do {

            // =========================================
            // MENU
            // =========================================

            System.out.println("\n===== SISTEMA LOGISTICO =====");

            System.out.println("1 - Registrar caminhão");
            System.out.println("2 - Ver caminhões no pátio");
            System.out.println("3 - Atualizar situação / ocorrência");
            System.out.println("4 - Registrar saída do caminhão");
            System.out.println("5 - Ver histórico");

            // MENU ADMIN
            if (admin) {

                System.out.println("6 - Cadastrar usuário");
                System.out.println("7 - Remover caminhão");
                System.out.println("8 - Remover usuário");
            }

            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                // =========================================
                // REGISTRAR CAMINHÃO
                // =========================================

                case 1:

                    Movimentacao mov = new Movimentacao();

                    System.out.println("Tipo de operação:");
                    System.out.println("0 - Carregamento");
                    System.out.println("1 - Descarregamento");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 0) {

                        mov.tipoOperacao = "Carregamento";

                    } else {

                        mov.tipoOperacao = "Descarregamento";
                    }

                    System.out.print("Hora chegada: ");
                    mov.horaChegada = sc.nextLine();

                    System.out.print("Frota: ");
                    mov.frota = sc.nextLine();

                    System.out.print("Motorista: ");
                    mov.motorista = sc.nextLine();

                    System.out.print("Container: ");
                    mov.container = sc.nextLine();

                    if (tipo == 0) {

                        System.out.print("Shipment: ");
                        mov.shipment = sc.nextLine();

                    } else {

                        System.out.print("Nota Fiscal: ");
                        mov.notaFiscal = sc.nextLine();

                        System.out.print("Referencia: ");
                        mov.referencia = sc.nextLine();

                        System.out.print("Produto: ");
                        mov.produto = sc.nextLine();
                    }

                    mov.situacao = "Aguardando";
                    mov.ocorrencia = "Nenhuma";

                    dao.inserirCaminhao(mov);

                    break;

                // =========================================
                // VER PÁTIO
                // =========================================

                case 2:

                    ArrayList<Movimentacao> patio = dao.listarCaminhoes();

                    if (patio.isEmpty()) {

                        System.out.println("Nenhum caminhão no pátio.");

                    } else {

                        for (Movimentacao m : patio) {

                            System.out.println("\nID: " + m.id);
                            System.out.println("Chegada: " + m.horaChegada);
                            System.out.println("Frota: " + m.frota);
                            System.out.println("Motorista: " + m.motorista);
                            System.out.println("Container: " + m.container);
                            System.out.println("Tipo: " + m.tipoOperacao);

                            if (m.tipoOperacao.equals("Carregamento")) {

                                System.out.println("Shipment: " + m.shipment);

                            } else {

                                System.out.println("Nota Fiscal: " + m.notaFiscal);
                                System.out.println("Referencia: " + m.referencia);
                                System.out.println("Produto: " + m.produto);
                            }

                            System.out.println("Situação: " + m.situacao);
                            System.out.println("Ocorrência: " + m.ocorrencia);
                        }
                    }

                    break;

                // =========================================
                // ATUALIZAR SITUAÇÃO
                // =========================================

                case 3:

                    System.out.print("Digite o ID do caminhão: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nova situação: ");
                    String novaSituacao = sc.nextLine();

                    System.out.print("Ocorrência: ");
                    String ocorrencia = sc.nextLine();

                    dao.atualizarSituacao(idEditar, novaSituacao, ocorrencia);

                    break;

                // =========================================
                // REGISTRAR SAÍDA
                // =========================================

                case 4:

                    System.out.print("Digite o ID do caminhão: ");
                    int idSaida = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Hora de saída: ");
                    String horaSaida = sc.nextLine();

                    dao.registrarSaida(idSaida, horaSaida);

                    break;

                // =========================================
                // HISTÓRICO
                // =========================================

                case 5:

                    ArrayList<Movimentacao> historico = dao.listarHistorico();

                    if (historico.isEmpty()) {

                        System.out.println("Nenhum caminhão no histórico.");

                    } else {

                        for (Movimentacao m : historico) {

                            System.out.println("\nID: " + m.id);
                            System.out.println("Chegada: " + m.horaChegada);
                            System.out.println("Saída: " + m.horaSaida);
                            System.out.println("Frota: " + m.frota);
                            System.out.println("Motorista: " + m.motorista);
                            System.out.println("Container: " + m.container);
                            System.out.println("Tipo: " + m.tipoOperacao);

                            if (m.tipoOperacao.equals("Carregamento")) {

                                System.out.println("Shipment: " + m.shipment);

                            } else {

                                System.out.println("Nota Fiscal: " + m.notaFiscal);
                                System.out.println("Referencia: " + m.referencia);
                                System.out.println("Produto: " + m.produto);
                            }

                            System.out.println("Situação final: " + m.situacao);
                            System.out.println("Ocorrência: " + m.ocorrencia);
                        }
                    }

                    break;

                // =========================================
                // CADASTRAR USUÁRIO
                // =========================================

                case 6:

                    if (admin) {

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Login: ");
                        String login = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        System.out.print("Perfil (admin/operador): ");
                        String perfil = sc.nextLine();

                        Usuario novo = new Usuario(0, nome, login, senha, perfil);

                        usuarioDAO.cadastrarUsuario(novo);

                    } else {

                        System.out.println("Acesso negado!");
                    }

                    break;

                // =========================================
                // REMOVER CAMINHÃO
                // =========================================

                case 7:

                    if (admin) {

                        System.out.print("Digite o ID do caminhão: ");
                        int idRemover = sc.nextInt();
                        sc.nextLine();

                        dao.removerCaminhao(idRemover);

                    } else {

                        System.out.println("Acesso negado!");
                    }

                    break;

                // =========================================
                // REMOVER USUÁRIO
                // =========================================

                case 8:

                    if (admin) {

                        System.out.print("Digite o ID do usuário: ");
                        int idUsuario = sc.nextInt();
                        sc.nextLine();

                        usuarioDAO.removerUsuario(idUsuario);

                    } else {

                        System.out.println("Acesso negado!");
                    }

                    break;

                // =========================================
                // SAIR
                // =========================================

                case 0:

                    System.out.println("Saindo do sistema...");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}