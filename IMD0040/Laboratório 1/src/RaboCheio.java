import java.util.ArrayList;
import java.util.Scanner;

public class RaboCheio {
    private static final ArrayList<Pedido> pedidos = new ArrayList<>();
    private static int contadorPedidos = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha.

            switch (opcao) {
                case 1 -> registrarPedido();
                case 2 -> removerPedido();
                case 3 -> listarPedidos();
                case 4 -> System.out.println("Encerrando o sistema... Até logo!");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("===== Sistema de Gerenciamento de Pedidos do Restaurante Rabo Cheio =====");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void registrarPedido() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Pedido pedido = new Pedido(contadorPedidos++, nomeCliente);

        char adicionarMais;
        do {
            System.out.print("Nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Preço do item: ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine();

            pedido.adicionarItem(new Item(nomeItem, precoItem));

            System.out.print("Deseja adicionar outro item? (s/n): ");
            adicionarMais = scanner.nextLine().toLowerCase().charAt(0);

        } while (adicionarMais == 's');

        pedidos.add(pedido);
        pedido.exibirNotaFiscal();
    }

    private static void removerPedido() {
        System.out.print("Digite o número do pedido a remover: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoRemovido = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                pedidoRemovido = pedido;
                break;
            }
        }

        if (pedidoRemovido != null) {
            pedidos.remove(pedidoRemovido);
            System.out.println("Pedido " + numero + " removido com sucesso.");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        System.out.println("\n===== Lista de Pedidos =====");
        for (Pedido pedido : pedidos) {
            pedido.exibirNotaFiscal();
        }
    }
}