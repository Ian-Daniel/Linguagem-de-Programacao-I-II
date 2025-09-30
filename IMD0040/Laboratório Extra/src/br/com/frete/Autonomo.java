package br.com.frete;

public class Autonomo extends Entregador {

    @Override
    public double calcularCustoFrete(double distanciaEmKm) {
        return distanciaEmKm * 0.95;
    }
}
