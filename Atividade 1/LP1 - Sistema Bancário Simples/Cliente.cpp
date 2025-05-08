#include "Cliente.h"

// Construtor da classe.
Cliente::Cliente(string nome, string cpf) : nome(nome), cpf(cpf) {}

string Cliente::getNome() const {
    return nome;
}

string Cliente::getCpf() const {
    return cpf;
}