# 🏦 Sistema de Simulação de Sistema Bancário (AgiotBank)

## 🧩 Descrição do Projeto

O objetivo deste projeto é simular um sistema bancário digital utilizando os principais conceitos de Programação Orientada a Objetos (POO) em Java.

O sistema permite criar contas, realizar transações financeiras básicas e calcular tributos, utilizando herança, polimorfismo e interfaces para garantir extensibilidade e reutilização de código.

---

## 🧠 Conceitos Aplicados

- Classe Abstrata (Conta) — define os comportamentos e atributos comuns;
- Herança — ContaCorrente e ContaPoupanca herdam de Conta;
- Polimorfismo — todas as contas são manipuladas como objetos Conta;
- Interface (ITributavel) — define o contrato para objetos que podem ser tributados;
- ArrayList — armazena todas as contas criadas;
- Tratamento de exceções (try/catch) — evita erros de entrada do usuário.

---

## ⚙️ Funcionalidades Principais

- Criar conta (corrente ou poupança);
- Realizar depósitos;
- Efetuar saques (com taxa de 5% para contas correntes);
- Transferir valores entre contas;
- Listar todas as contas cadastradas;
- Calcular o total de tributos (1% do saldo das contas correntes);
- Sair do sistema.

---

## 📂 Estrutura do Projeto

```
SistemaBancarioLP2/
 ├── src/
 │    ├── Banco.java
 │    ├── Conta.java
 │    ├── ContaCorrente.java
 │    ├── ContaPoupanca.java
 │    └── ITributavel.java
 ├── Makefile
 └── README.md
```

---

## 💻 Execução do Programa
🔹 Compilar e Executar Manualmente

```bash
cd src
javac *.java
java Banco
```

🔹 Usando o Makefile

Na pasta principal do projeto:

```bash
make run
```

Para limpar os arquivos compilados:

```bash
make clean
```

## 📋 Exemplo de Uso

```
========================================
        🏦 BANCO DIGITAL AgiotBank
========================================
1. Criar Conta
2. Realizar Depósito
3. Realizar Saque
4. Realizar Transferência
5. Listar Contas
6. Calcular Total de Tributos
7. Sair
========================================
Escolha uma opção: 1
Nome do cliente: Ian
Tipo (1 - Corrente | 2 - Poupança): 1
Conta 101 criada com sucesso para Ian!

```

## 🧮 Exemplo de Cálculo de Tributos

- Conta Corrente (Ian): saldo = R$ 500,00 → tributo = R$ 5,00 (1%)
- Conta Poupança (Maria): saldo = R$ 300,00 → tributo = R$ 0,00

Total de tributos: R$ 5,00

## 🏁 Observação Final

Este projeto cumpre todos os requisitos funcionais e técnicos exigidos no Laboratório 2 de LP2, incluindo o uso de POO, interface, herança, polimorfismo, controle de fluxo e interação via console.

## 👨‍💻 Autor

- **Ian Daniel Varela Marques**;
Disciplina: **Linguagem de Programação II (IMD0040) - UFRN / IMD**