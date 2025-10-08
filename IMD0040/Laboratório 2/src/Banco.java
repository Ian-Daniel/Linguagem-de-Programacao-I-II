import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {
    private static ArrayList<Conta> contas = new ArrayList<>();
    private static int proximoNumero = 101;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    listarContas();
                    break;
                case 6:
                    calcularTributos();
                    break;
                case 7:
                    System.out.println("\nEncerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 7);

        sc.close();
    }

    // ========== MENUS E ENTRADAS ==========
    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("AgiotBank");
        System.out.println("========================================");
        System.out.println("1. Criar Conta");
        System.out.println("2. Realizar Depósito");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Realizar Transferência");
        System.out.println("5. Listar Contas");
        System.out.println("6. Calcular Total de Tributos");
        System.out.println("7. Sair");
        System.out.println("========================================");
    }

    private static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                sc.nextLine(); // limpa buffer
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número real (ex: 100.50).");
                sc.nextLine();
            }
        }
    }

    // ========== FUNCIONALIDADES ==========
    private static void criarConta() {
        sc.nextLine(); // limpar buffer
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        int tipo;
        do {
            tipo = lerInteiro("Tipo (1 - Corrente | 2 - Poupança): ");
        } while (tipo != 1 && tipo != 2);

        Conta conta;
        if (tipo == 1) {
            conta = new ContaCorrente(proximoNumero++, nome);
        } else {
            conta = new ContaPoupanca(proximoNumero++, nome);
        }

        contas.add(conta);
        System.out.printf("Conta %d criada com sucesso para %s!%n", conta.getNumero(), nome);
    }

    private static Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero)
                return c;
        }
        return null;
    }

    private static void depositar() {
        int num = lerInteiro("Número da conta: ");
        Conta conta = buscarConta(num);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        double val = lerDouble("Valor do depósito: ");
        conta.depositar(val);
        System.out.println("Depósito realizado com sucesso!");
    }

    private static void sacar() {
        int num = lerInteiro("Número da conta: ");
        Conta conta = buscarConta(num);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        double val = lerDouble("Valor do saque: ");
        if (conta.sacar(val))
            System.out.println("Saque realizado!");
        else
            System.out.println("Saldo insuficiente!");
    }

    private static void transferir() {
        int origem = lerInteiro("Conta de origem: ");
        Conta cOrigem = buscarConta(origem);
        if (cOrigem == null) {
            System.out.println("Conta de origem não encontrada!");
            return;
        }

        int destino = lerInteiro("Conta de destino: ");
        Conta cDestino = buscarConta(destino);
        if (cDestino == null) {
            System.out.println("Conta de destino não encontrada!");
            return;
        }

        double val = lerDouble("Valor da transferência: ");
        if (cOrigem.transferir(cDestino, val))
            System.out.println("Transferência concluída!");
        else
            System.out.println("Saldo insuficiente!");
    }

    private static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n--- Contas Cadastradas ---");
        for (Conta c : contas)
            System.out.println(c);
    }

    private static void calcularTributos() {
        double total = 0.0;
        for (Conta c : contas) {
            if (c instanceof ITributavel) {
                ITributavel trib = (ITributavel) c; // cast manual
                total += trib.calculaTributos();
            }
        }
        System.out.printf("\nTotal de tributos a recolher: R$ %.2f%n", total);
    }
}
