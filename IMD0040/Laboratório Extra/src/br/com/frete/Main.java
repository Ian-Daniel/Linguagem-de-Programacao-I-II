package br.com.frete;

public class Main {

    public static void main(String[] args) {
        // Primeira entrega: 10 km, Funcionario + Carro
        ServicoDeEntrega entrega1 = new ServicoDeEntrega(10);
        entrega1.adicionarItem(new Carro("ABC-1234", 2020));
        entrega1.adicionarItem(new Funcionario());
        System.out.println("Entrega 1 (10km, Carro + Funcionario): R$ "
                + entrega1.calcularCustoTotal());

        // Segunda entrega: 25 km, Autonomo + Motocicleta
        ServicoDeEntrega entrega2 = new ServicoDeEntrega(25);
        entrega2.adicionarItem(new Motocicleta("XYZ-9876", 2022));
        entrega2.adicionarItem(new Autonomo());
        System.out.println("Entrega 2 (25km, Moto + Autonomo): R$ "
                + entrega2.calcularCustoTotal());
    }
}
