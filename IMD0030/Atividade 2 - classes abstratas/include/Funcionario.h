#ifndef FUNCIONARIO_H
#define FUNCIONARIO_H

#include <string>
#include <iostream>
#include <iomanip>

class Funcionario {
protected:
    std::string nome;
    float salarioBase;
private:
    int id;

public:
    Funcionario(std::string nome, float salarioBase, int id);
    virtual ~Funcionario() {}

    void setName(std::string nome);
    std::string getName() const;
    void setSalarioBase(float salarioBase);
    float getSalarioBase() const;
    void setId(int id);
    int getId() const;

    virtual void exibirInformacoes() const;
    virtual float calcularSalarioFinal() const = 0;
};

#endif
