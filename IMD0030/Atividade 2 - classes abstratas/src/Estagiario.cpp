#include "../include/Estagiario.h"

Estagiario::Estagiario(std::string nome, float salarioBase, int id, int horasTrabalhadas)
    : Funcionario(nome, salarioBase, id), horasTrabalhadas(horasTrabalhadas) {}

float Estagiario::calcularSalarioFinal() const {
    return salarioBase * (horasTrabalhadas / 160.0f);
}

void Estagiario::exibirInformacoes() const {
    std::cout << "ID: " << getId() << std::endl;
    std::cout << "Nome: " << getName() << std::endl;
    std::cout << "Tipo: Estagiário" << std::endl;
    std::cout << "Horas trabalhadas: " << horasTrabalhadas << std::endl;
    std::cout << "Salário base: " << std::fixed << std::setprecision(2) << getSalarioBase() << std::endl;
    std::cout << "Salário final: " << calcularSalarioFinal() << std::endl;
}