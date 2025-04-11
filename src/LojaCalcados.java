// Arquivo: LojaCalcados.java (classe Main)
import java.util.*;

public class LojaCalcados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Menu Loja de Calçados ---");
            System.out.println("1. Adicionar Calçado");
            System.out.println("2. Consultar Estoque");
            System.out.println("3. Listar Todos os Calçados");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (bota/sapato/sandalia/tenis): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    Calcado novo = switch (tipo.toLowerCase()) {
                        case "bota" -> new Bota(modelo, marca, preco, quantidade);
                        case "sapato" -> new Sapato(modelo, marca, preco, quantidade);
                        case "sandalia" -> new Sandalia(modelo, marca, preco, quantidade);
                        case "tenis" -> new Tenis(modelo, marca, preco, quantidade);
                        default -> null;
                    };

                    if (novo != null) {
                        estoque.adicionarCalcado(novo);
                        System.out.println("Calçado adicionado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o modelo do calçado: ");
                    String consulta = scanner.nextLine();
                    Calcado encontrado = estoque.consultarEstoque(consulta);
                    if (encontrado != null) {
                        System.out.println("\n" + encontrado);
                        List<Calcado> similares = estoque.sugerirModelos(consulta);
                        if (!similares.isEmpty()) {
                            System.out.println("\nModelos semelhantes:");
                            for (Calcado c : similares) {
                                System.out.println(c);
                            }
                        }
                    } else {
                        System.out.println("Modelo não encontrado.");
                    }
                    break;

                case 3:
                    estoque.listarTodos();
                    break;

                case 4:
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
