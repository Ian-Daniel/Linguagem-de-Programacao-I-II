#include <iostream>
#include <string>
using namespace std;

class Cliente
{
private:
    string nome;
    string cpf;

public:
    Cliente(string nome, string cpf)
    {
        this->nome = nome;
        this->cpf = cpf;
    }

    string getNome() const
    {
        return nome;
    }

    string getCpf() const
    {
        return cpf;
    }
};

class ContaBancaria
{
private:
    int numero;
    double saldo;
    Cliente titular;

public:
    ContaBancaria(int numero, Cliente titular, double saldo = 0.0)
        : numero(numero), titular(titular), saldo(saldo) {}
}

void
depositar(double valor)
{
    saldo += valor;
}

void sacar(double valor)
{
    if (valor <= saldo)
    {
        saldo -= valor;
    }
    else
    {
        cout << "Saldo insuficiente!" << numero << endl;
    }
}

void transferir(double valor, ContaBancaria &destino)
{
    if (valor <= saldo)
    {
        saldo -= valor;
        destino.depositar(valor);
        cout << "Trasnferido: R$ " << valor << " da conta " << numero << " para a conta " << destino.numero << endl;
    }
    else
    {
        cout << "Saldo insuficiente para realizar a operação de transferência na conta " << numero << endl;
    }
}

void transferir(double valor, ContaBancaria &destino1, ContaBancaria &destino2)
{
    if (valor <= saldo)
    {
        double metade = valor / 2.0;
        saldo -= valor;
        destino1.depositar(metade);
        destino2.depositar(metade);
        cout << "Trasnferido: R$ " << metade << " para ambas as contas: " << destino1 << " e " << destino2 << " da conta " << numero << endl;
    }
    else
    {
        cout << "Saldo insuficiente para realizar a operação de trasnferência múltipla na conta " << numero << endl;
    }
}

void exibirSaldo() const
{
    cout << "Saldo atual da conta " << numero << ": R$ " << saldo << endl;
}

void exibirInformacoes() const
{
    cout << "Titular: " << titular.getNome() << ", CPF: " << titular.getCpf() << "Número da Conta: " << numero << "Saldo: R$ " << saldo << endl;
}

int main()
{
    // Criação dos clientes
    Cliente cliente1("Ana", "111.111.111-11");
    Cliente cliente2("Bruno", "222.222.222-22");
    Cliente cliente3("Carla", "333.333.333-33");

    // Criação das contas bancárias com saldos iniciais
    ContaBancaria conta1(1001, cliente1, 1000.0);
    ContaBancaria conta2(1002, cliente2);
    ContaBancaria conta3(1003, cliente3);

    // Exibe o saldo inicial da conta de Ana
    conta1.exibirSaldo();

    // Ana transfere R$200 para Bruno
    conta1.transferir(200.0, conta2);

    // Ana transfere R$300 divididos entre Bruno e Carla
    conta1.transferir(300.0, conta2, conta3);

    // Exibição dos saldos finais
    cout << endl;
    conta1.exibirInformacoes();
    conta2.exibirInformacoes();
    conta3.exibirInformacoes();

    return 0;
}