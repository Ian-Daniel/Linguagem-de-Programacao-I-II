#include <iostream>
#include <locale.h>
#include <string>
using namespace std;

// Classe que representa um cliente do banco, contendo nome e CPF.
class Cliente
{
private:
    string nome;
    string cpf;

public:
    // Construtor que inicializa o nome e o CPF do cliente.
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

// Classe que representa uma conta bancária.
class ContaBancaria
{
private:
    int numero;
    double saldo;
    Cliente titular;

public:
    // Construtor que inicializa número, titular e saldo (padrão: 0.0).
    ContaBancaria(int numero, Cliente titular, double saldo = 0.0)
        : numero(numero), saldo(saldo), titular(titular) {} // A ordem da lista deve coincidir com a ordem dos atributos declarados na classe para evitar *warnings* do compilador relacionados à inicialização fora de ordem.

    // Deposita um valor na conta.
    void depositar(double valor)
    {
        saldo += valor;
    }

    // Realiza um saque se houver saldo suficiente.
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

    // Transfere um valor para outra conta, se houver saldo suficiente.
    void transferir(double valor, ContaBancaria &destino)
    {
        if (valor <= saldo)
        {
            saldo -= valor;
            destino.depositar(valor);
            cout << "Transferido: R$ " << valor << " da conta " << numero << " para a conta " << destino.numero << endl;
        }
        else
        {
            cout << "Saldo insuficiente para realizar a operação de transferência na conta " << numero << endl;
        }
    }

    // Transfere um valor dividido igualmente entre duas contas.
    void transferir(double valor, ContaBancaria &destino1, ContaBancaria &destino2)
    {
        if (valor <= saldo)
        {
            double metade = valor / 2.0;
            saldo -= valor;
            destino1.depositar(metade);
            destino2.depositar(metade);
            cout << "Transferido: R$ " << metade << " para cada conta ( " << destino1.numero << " e " << destino2.numero << " ) a partir da conta " << numero << endl;
        }
        else
        {
            cout << "Saldo insuficiente para realizar a operação de transferência múltipla na conta " << numero << endl;
        }
    }

    // Exibe o saldo atual da conta.
    void exibirSaldo() const
    {
        cout << "Saldo atual da conta " << numero << ": R$ " << saldo << endl;
    }

    // Exibe informações completas da conta.
    void exibirInformacoes() const
    {
        cout << "Titular: " << titular.getNome() << ", CPF: " << titular.getCpf() << "Número da Conta: " << numero << "Saldo: R$ " << saldo << endl;
    }
};

int main()
{
    // Criação dos clientes.
    Cliente cliente1("Ana", "111.111.111-11");
    Cliente cliente2("Bruno", "222.222.222-22");
    Cliente cliente3("Carla", "333.333.333-33");

    // Criação das contas bancárias com saldos iniciais.
    ContaBancaria conta1(1001, cliente1, 1000.0);
    ContaBancaria conta2(1002, cliente2);
    ContaBancaria conta3(1003, cliente3);

    // Exibe o saldo inicial da conta de Ana.
    conta1.exibirSaldo();

    // Ana transfere R$ 200,00 para Bruno.
    conta1.transferir(200.0, conta2);

    // Ana transfere R$ 300,00 divididos entre Bruno e Carla.
    conta1.transferir(300.0, conta2, conta3);

    // Exibição dos saldos finais.
    cout << endl;
    conta1.exibirInformacoes();
    conta2.exibirInformacoes();
    conta3.exibirInformacoes();

    return 0;
}