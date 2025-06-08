#include "../include/Gerente.h"

Gerente::Gerente(std::string nome, float salarioBase, int id, float bonusMensal)
    : Funcionario(nome, salarioBase, id), bonusMensal(bonusMensal) {}

float Gerente::calcularSalarioFinal() const {
    return salarioBase + bonusMensal;
}

void Gerente::exibirInformacoes() const {
    std::cout << "ID: " << getId() << std::endl;
    std::cout << "Nome: " << getName() << std::endl;
    std::cout << "Tipo: Gerente" << std::endl;
    std::cout << "Bônus: " << std::fixed << std::setprecision(2) << bonusMensal << std::endl;
    std::cout << "Salário base: " << getSalarioBase() << std::endl;
    std::cout << "Salário final: " << calcularSalarioFinal() << std::endl;
}