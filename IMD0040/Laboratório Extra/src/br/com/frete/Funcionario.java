package br.com.frete;

public class Funcionario extends Entregador {

    @Override
    public double calcularCustoFrete(double distanciaEmKm) {
        return 5.0;
    }
}
