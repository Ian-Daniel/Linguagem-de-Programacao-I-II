#ifndef CLIENTE_H
#define CLIENTE_H

#include <string>
using namespace std;

// Classe que representa um cliente do banco, contendo nome e CPF.
class Cliente {
private:
    string nome;
    string cpf;

public:
    Cliente(string nome, string cpf);
    string getNome() const;
    string getCpf() const;
};

#endif