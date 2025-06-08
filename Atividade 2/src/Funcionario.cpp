#include "../include/Funcionario.h"

Funcionario::Funcionario(std::string nome, float salarioBase, int id) 
    : nome(nome), salarioBase(salarioBase), id(id) {}

void Funcionario::setName(std::string nome) { this->nome = nome; }
std::string Funcionario::getName() const { return nome; }

void Funcionario::setSalarioBase(float salarioBase) { this->salarioBase = salarioBase; }
float Funcionario::getSalarioBase() const { return salarioBase; }

void Funcionario::setId(int id) { this->id = id; }
int Funcionario::getId() const { return id; }

void Funcionario::exibirInformacoes() const {
    std::cout << "ID: " << id << std::endl;
    std::cout << "Nome: " << nome << std::endl;
    std::cout << "Salário base: " << std::fixed << std::setprecision(2) << salarioBase << std::endl;
}