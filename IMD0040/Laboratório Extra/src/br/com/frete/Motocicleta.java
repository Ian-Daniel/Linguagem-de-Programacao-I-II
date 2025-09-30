
public class Motocicleta extends Veiculo {

    public Motocicleta(String placa, int ano) {
        super(placa, ano);
    }

    @Override
    public double calcularCustoFrete(double distanciaEmKm) {
        return distanciaEmKm * 0.45;
    }
}
