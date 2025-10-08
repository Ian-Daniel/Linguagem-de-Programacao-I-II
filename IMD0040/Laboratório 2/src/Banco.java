import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private static ArrayList<Conta> contas = new ArrayList<>();
    private static int proximoNumero = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Listar Contas");
            System.out.println("6. Calcular Total de Tributos");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> criarConta(sc);
                case 2 -> depositar(sc);
                case 3 -> sacar(sc);
                case 4 -> transferir(sc);
                case 5 -> listarContas();
                case 6 -> calcularTributos();
                case 7 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        sc.close();
    }

    private static void criarConta(Scanner sc) {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Tipo (1 - Corrente | 2 - Poupança): ");
        int tipo = sc.nextInt();

        Conta conta;
        if (tipo == 1)
            conta = new ContaCorrente(proximoNumero++, nome);
        else
            conta = new ContaPoupanca(proximoNumero++, nome);

        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
    }

    private static Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero)
                return c;
        }
        return null;
    }

    private static void depositar(Scanner sc) {
        System.out.print("Número da conta: ");
        int num = sc.nextInt();
        System.out.print("Valor: ");
        double val = sc.nextDouble();

        Conta conta = buscarConta(num);
        if (conta != null) {
            conta.depositar(val);
            System.out.println("Depósito realizado!");
        } else System.out.println("Conta não encontrada!");
    }

    private static void sacar(Scanner sc) {
        System.out.print("Número da conta: ");
        int num = sc.nextInt();
        System.out.print("Valor: ");
        double val = sc.nextDouble();

        Conta conta = buscarConta(num);
        if (conta != null) {
            if (conta.sacar(val))
                System.out.println("Saque realizado!");
            else
                System.out.println("Saldo insuficiente!");
        } else System.out.println("Conta não encontrada!");
    }

    private static void transferir(Scanner sc) {
        System.out.print("Conta de origem: ");
        int origem = sc.nextInt();
        System.out.print("Conta de destino: ");
        int destino = sc.nextInt();
        System.out.print("Valor: ");
        double val = sc.nextDouble();

        Conta cOrigem = buscarConta(origem);
        Conta cDestino = buscarConta(destino);

        if (cOrigem != null && cDestino != null) {
            if (cOrigem.transferir(cDestino, val))
                System.out.println("Transferência realizada!");
            else
                System.out.println("Saldo insuficiente!");
        } else System.out.println("Conta(s) inválida(s)!");
    }

    private static void listarContas() {
        System.out.println("\n--- Contas Cadastradas ---");
        for (Conta c : contas) System.out.println(c);
    }

    private static void calcularTributos() {
        double total = 0.0;
        for (Conta c : contas) {
            if (c instanceof ITributavel trib)
                total += trib.calculaTributos();
        }
        System.out.printf("Total de tributos: R$ %.2f%n", total);
    }
}