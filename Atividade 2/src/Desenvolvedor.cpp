#include "../include/Desenvolvedor.h"

Desenvolvedor::Desenvolvedor(std::string nome, float salarioBase, int id, int quantidadeDeProjetos)
    : Funcionario(nome, salarioBase, id), quantidadeDeProjetos(quantidadeDeProjetos) {}

float Desenvolvedor::calcularSalarioFinal() const {
    return salarioBase + (500 * quantidadeDeProjetos);
}

void Desenvolvedor::exibirInformacoes() const {
    std::cout << "ID: " << getId() << std::endl;
    std::cout << "Nome: " << getName() << std::endl;
    std::cout << "Tipo: Desenvolvedor" << std::endl;
    std::cout << "Projetos: " << quantidadeDeProjetos << std::endl;
    std::cout << "Salário base: " << std::fixed << std::setprecision(2) << getSalarioBase() << std::endl;
    std::cout << "Salário final: " << calcularSalarioFinal() << std::endl;
}