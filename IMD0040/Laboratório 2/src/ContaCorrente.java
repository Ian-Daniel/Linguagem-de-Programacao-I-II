public class ContaCorrente extends Conta implements ITributavel {

    public ContaCorrente(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) {
        double taxa = valor * 0.05;
        double total = valor + taxa;
        if (saldo >= total) {
            saldo -= total;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public double calculaTributos() {
        return saldo * 0.01;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Corrente";
    }
}