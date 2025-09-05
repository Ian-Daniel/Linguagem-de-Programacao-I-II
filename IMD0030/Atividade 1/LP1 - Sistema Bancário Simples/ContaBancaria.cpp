#include "ContaBancaria.h"

// Construtor que inicializa número, titular e saldo (que já tem um valor preestabelecido).
ContaBancaria::ContaBancaria(int numero, Cliente titular, double saldo)
    : numero(numero), saldo(saldo), titular(titular) {}

void ContaBancaria::depositar(double valor) {
    saldo += valor;
}

void ContaBancaria::sacar(double valor) {
    if (valor <= saldo)
        saldo -= valor;
    else
        cout << "Saldo insuficiente! Conta: " << numero << endl;
}

void ContaBancaria::transferir(double valor, ContaBancaria &destino) {
    if (valor <= saldo) {
        saldo -= valor;
        destino.depositar(valor);
        cout << "Transferido: R$ " << valor << " da conta " << numero
             << " para a conta " << destino.numero << endl;
    } else {
        cout << "Saldo insuficiente para realizar a operação de transferência na conta "
             << numero << endl;
    }
}

void ContaBancaria::transferir(double valor, ContaBancaria &destino1, ContaBancaria &destino2) {
    if (valor <= saldo) {
        double metade = valor / 2.0;
        saldo -= valor;
        destino1.depositar(metade);
        destino2.depositar(metade);
        cout << "Transferido: R$ " << metade << " para cada conta ( "
             << destino1.numero << " e " << destino2.numero << " ) a partir da conta "
             << numero << endl;
    } else {
        cout << "Saldo insuficiente para realizar a operação de transferência múltipla na conta "
             << numero << endl;
    }
}

void ContaBancaria::exibirSaldo() const {
    cout << "Saldo atual da conta " << numero << ": R$ " << saldo << endl;
}

void ContaBancaria::exibirInformacoes() const {
    cout << "Titular: " << titular.getNome()
         << ", CPF: " << titular.getCpf()
         << ", Número da Conta: " << numero
         << ", Saldo: R$ " << saldo << endl;
}