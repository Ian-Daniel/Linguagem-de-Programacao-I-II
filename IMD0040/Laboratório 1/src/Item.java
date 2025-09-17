public class Item {
    private final String nome;
    private final double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "- " + nome + " R$ " + String.format("%.2f", preco);
    }
}