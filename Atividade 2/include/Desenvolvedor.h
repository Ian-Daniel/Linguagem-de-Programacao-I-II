#ifndef DESENVOLVEDOR_H
#define DESENVOLVEDOR_H

#include "Funcionario.h"

class Desenvolvedor : public Funcionario {
private:
    int quantidadeDeProjetos;

public:
    Desenvolvedor(std::string nome, float salarioBase, int id, int quantidadeDeProjetos);
    float calcularSalarioFinal() const override;
    void exibirInformacoes() const override;
};

#endif
