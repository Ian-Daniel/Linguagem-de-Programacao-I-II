import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String cliente;
    private ArrayList<Item> itens;

    public Pedido(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void exibirNotaFiscal() {
        System.out.println("\n========================================");
        System.out.println("       Restaurante Sabores da Casa       ");
        System.out.println("========================================");
        System.out.println("Pedido N°: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("----------------------------------------");
        System.out.println("Itens:");
        for (Item item : itens) {
            System.out.println("- " + item.getNome() + " R$ " + String.format("%.2f", item.getPreco()));
        }
        System.out.println("----------------------------------------");
        System.out.println("Total: R$ " + String.format("%.2f", calcularTotal()));
        System.out.println("========================================");
        System.out.println("   Obrigado pela preferência! :)   ");
        System.out.println("========================================\n");
    }
}