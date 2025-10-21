# 🍽️ Sistema de Gerenciamento de Pedidos (Restaurante Rabo Cheio)

Projeto desenvolvido na disciplina **Linguagem de Programação II (LP II)**.  
O sistema simula o gerenciamento de pedidos de um restaurante, permitindo registrar, remover e listar pedidos via **console**.  

---

## 🚀 Funcionalidades

- Registrar novos pedidos (com cliente e itens);
- Remover pedidos existentes pelo número;
- Listar todos os pedidos ativos de forma organizada;
- Exibição de nota fiscal formatada no console.

---

## 🛠️ Tecnologias utilizadas

- **Java 17+**;
- **Orientação a Objetos** (composição: Pedido possui Itens);
- **ArrayList** como estrutura de dados;
- **Scanner** para entrada de dados;
- Estruturas de controle: `while` + `switch-case`.

---

## 📂 Estrutura do projeto

```
Laboratório 1/
│── src/
│ ├── Item.java # Classe que representa um item (nome, preço)
│ ├── Pedido.java # Classe que representa um pedido (id, cliente, itens)
│ ├── RaboCheio.java # Classe principal com menu e lógica do sistema
│── README.md
```

---

## ▶️ Como compilar e executar
Dentro da pasta do projeto:

```bash
# 1. Compilar
javac src/*.java -d bin

# 2. Executar
java -cp bin RaboCheio
```

- Certifique-se de ter o *Java JDK* instalado e configurado no PATH.

## 📌 Exemplo de uso

```
--- Sistema de Gerenciamento de Pedidos ---
1. Registrar Pedido
2. Remover Pedido
3. Listar Pedidos
4. Sair
Escolha uma opção: 1
Nome do cliente: Ian
Nome do item: PF
Preço do item: R$ 12,99
Deseja adicionar outro item? (s/n): n

Pedido registrado com sucesso!

========================================
      Restaurante Rabo Cheio     
========================================
Pedido N°: 1
Cliente: Ian
----------------------------------------
Itens:
- PF R$ 12,99
----------------------------------------
Total: R$ 12,99
========================================
   Obrigado pela preferência! :)
========================================
```

## 👨‍💻 Autor

- **Ian Daniel Varela Marques**;
Disciplina: **Linguagem de Programação II (IMD0040) - UFRN / IMD**