package br.com.frete;

import java.util.ArrayList;
import java.util.List;

public class ServicoDeEntrega {

    private List<Fretavel> itens = new ArrayList<>();
    private double distancia;

    public ServicoDeEntrega(double distancia) {
        this.distancia = distancia;
    }

    public void adicionarItem(Fretavel f) {
        itens.add(f);
    }

    public double calcularCustoTotal() {
        double total = 0.0;
        for (Fretavel f : itens) {
            total += f.calcularCustoFrete(distancia);
        }
        return total;
    }
}
