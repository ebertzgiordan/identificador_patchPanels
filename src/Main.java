import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciação de um objeto PatchPanel para gerenciar as portas
        PatchPanel painel = new PatchPanel();

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                System.out.println("\nBem vindo ao Gerenciador de cabos 2000!");
                System.out.println("\nSelecione uma opção:");
                System.out.println("1 - Adicionar nova porta");
                System.out.println("2 - Listar todas as portas");
                System.out.println("3 - Listar portas livres");
                System.out.println("4 - Listar portas ocupadas");
                System.out.println("5 - Buscar porta por código");
                System.out.println("6 - Remover porta por código");
                System.out.println("7 - Busca por usuário");
                System.out.println("8 - Sair");
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                System.out.print("\nOpção: ");

                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        // Caso 1: Adicionar nova porta (lógica ou telefone)
                        try {
                            System.out.println("\nTipo de porta (1 - Lógica, 2 - Telefone): ");
                            int tipo = Integer.parseInt(scanner.nextLine());

                            System.out.print("Patch Panel (ex: LG01 - Lógica || TL01 - Telefone): ");
                            String patchPanel = scanner.nextLine().toUpperCase();
                            // Validação do código do Patch Panel (deve iniciar com TL ou LG)
                            if (!(patchPanel.startsWith("LG") || patchPanel.startsWith("TL"))) {
                                System.out.println("Patch Panel inválido! Deve começar com LG ou TL. Tente novamente.");
                                break;
                            }

                            // Entrada do número da porta
                            System.out.print("Número da Porta (ex: 01): ");
                            String numeroPorta = scanner.nextLine();
                            // Criação automática do código juntando Patch Panel + número
                            String codigo = patchPanel + numeroPorta;

                            // Entrada dos demais atributos da porta
                            System.out.print("Localização física (ex: Rack principal): ");
                            String localizacao = scanner.nextLine();
                            System.out.print("Está ocupada? (true/false): ");
                            boolean ocupada = Boolean.parseBoolean(scanner.nextLine());
                            System.out.print("Usuário Final: ");
                            String usuario = scanner.nextLine();
                            System.out.print("Observações: ");
                            String obs = scanner.nextLine();

                            // Criação e adição da porta conforme o tipo escolhido
                            if (tipo == 1) {
                                // Porta lógica
                                System.out.print("Tipo de Cabo (ex: Cat6): ");
                                String tipoCabo = scanner.nextLine();
                                System.out.print("Uso (ex: Internet): ");
                                String uso = scanner.nextLine();
                                painel.adicionarPorta(
                                        new PortaLogica(codigo, localizacao, ocupada, usuario, obs, tipoCabo, uso));
                            } else if (tipo == 2) {
                                // Porta telefone
                                System.out.print("Ramal: ");
                                String ramal = scanner.nextLine();
                                System.out.print("Cor do Cabo: ");
                                String corCabo = scanner.nextLine();
                                painel.adicionarPorta(new PortaTelefone(codigo, localizacao, ocupada, usuario, obs,
                                        ramal, corCabo));
                            } else {
                                System.out.println("Tipo inválido.");
                            }
                        } catch (NumberFormatException e) {
                            // Tratamento de erro caso entrada de tipo seja inválida
                            System.out.println("Erro: Entrada numérica inválida! Tente novamente.");
                        }
                        break;

                    case 2:
                        // Caso 2: Listar todas as portas cadastradas
                        System.out.println("\nTodas as portas cadastradas:");
                        painel.listarTodas();
                        break;

                    case 3:
                        // Caso 3: Listar apenas portas livres (não ocupadas)
                        System.out.println("\nPortas Livres:");
                        List<Porta> livres = painel.listarPortasLivres();
                        if (livres.isEmpty()) {
                            System.out.println("Nenhuma porta livre encontrada.");
                        } else {
                            for (Porta p : livres) {
                                System.out.println(p.getDetalhes());
                            }
                        }
                        break;

                    case 4:
                        // Caso 4: Listar apenas portas ocupadas
                        System.out.println("\nPortas Ocupadas:");
                        List<Porta> ocupadas = painel.listarPortasOcupadas();
                        if (ocupadas.isEmpty()) {
                            System.out.println("Nenhuma porta ocupada encontrada.");
                        } else {
                            for (Porta p : ocupadas) {
                                System.out.println(p.getDetalhes());
                            }
                        }
                        break;

                    case 5:
                        // Caso 5: Buscar uma porta específica pelo código
                        System.out.print("\nDigite um código de porta para buscar: ");
                        String busca = scanner.nextLine();
                        try {
                            Porta encontrada = painel.buscarPorCodigo(busca);
                            System.out.println("Encontrada: " + encontrada.getDetalhes());
                        } catch (PortaNaoEncontradaException e) {
                            // Tratamento de erro caso código não seja encontrado
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6:
                        // Caso 6: Remover uma porta pelo código
                        System.out.print("\nDigite o código da porta a ser removida: ");
                        String remover = scanner.nextLine();
                        try {
                            painel.removerPorta(remover);
                            System.out.println("Porta removida com sucesso.");
                        } catch (PortaNaoEncontradaException e) {
                            // Tratamento de erro caso a porta não exista
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 7:
                        // Caso 7: Buscar todas as portas associadas a um usuário específico
                        System.out.println("Usuário a ser pesquisado:");
                        String usuarioBusca = scanner.nextLine();
                        List<Porta> portasUsuario = painel.buscarPorUsuario(usuarioBusca);

                        if (portasUsuario.isEmpty()) {
                            System.out.println("Nenhuma porta encontrada para o usuário: " + usuarioBusca);
                        } else {
                            System.out.println("Portas encontradas para o usuário " + usuarioBusca + ":");
                            for (Porta p : portasUsuario) {
                                System.out.println(p.getDetalhes());
                            }
                        }
                        break;

                    case 8:
                        // Caso 8: Sair do sistema
                        continuar = false;
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        // Opção inválida
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Tratamento de erro caso a opção não seja um número
                System.out.println("Erro: Entrada inválida. Digite um número para selecionar uma opção.");
            }
        }
        scanner.close();
    }
}