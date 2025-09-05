#include <iostream>
#include <vector>
#include <clocale>
#include "include/Funcionario.h"
#include "include/Desenvolvedor.h"
#include "include/Gerente.h"
#include "include/Estagiario.h"

void cadastrarFuncionarios(std::vector<Funcionario*>& funcionarios) {
    int tipo, id, quantidade, horas;
    float salario, bonus;
    std::string nome;

    std::cout << "\nCadastro de Funcionários (mínimo 6)" << std::endl;
    std::cout << "-----------------------------------" << std::endl;

    for (int i = 0; i < 6 || (i < 10 && i >= 6 && std::cout << "Deseja cadastrar mais? (1-Sim, 0-Não): " && std::cin >> tipo && tipo); i++) {
        std::cout << "\nTipo de funcionário (1-Desenvolvedor, 2-Gerente, 3-Estagiário): ";
        std::cin >> tipo;
        std::cin.ignore();

        std::cout << "ID: ";
        std::cin >> id;
        std::cin.ignore();

        std::cout << "Nome: ";
        getline(std::cin, nome);

        std::cout << "Salário base: ";
        std::cin >> salario;

        switch (tipo) {
            case 1:
                std::cout << "Quantidade de projetos: ";
                std::cin >> quantidade;
                funcionarios.push_back(new Desenvolvedor(nome, salario, id, quantidade));
                break;
            case 2:
                std::cout << "Bônus mensal: ";
                std::cin >> bonus;
                funcionarios.push_back(new Gerente(nome, salario, id, bonus));
                break;
            case 3:
                std::cout << "Horas trabalhadas: ";
                std::cin >> horas;
                funcionarios.push_back(new Estagiario(nome, salario, id, horas));
                break;
            default:
                std::cout << "Tipo inválido!" << std::endl;
                i--;
                break;
        }
    }
}

int main() {
    setlocale(LC_ALL, "Portuguese");
    std::vector<Funcionario*> funcionarios;

    cadastrarFuncionarios(funcionarios);

    std::cout << "\nRelatório de Funcionários" << std::endl;
    std::cout << "------------------------" << std::endl;
    for (const auto& func : funcionarios) {
        func->exibirInformacoes();
        std::cout << std::endl;
    }

    for (auto& func : funcionarios) {
        delete func;
    }
    funcionarios.clear();

    return 0;
}