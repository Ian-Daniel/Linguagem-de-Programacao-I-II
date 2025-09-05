# Compilador.
CXX := g++
# Opções de compilação.
CXXFLAGS := -std=c++11 -Wall -Iinclude

# Nome do executável.
TARGET := programa

# Arquivos fonte (.cpp).
SRCS := src/Funcionario.cpp src/Desenvolvedor.cpp src/Gerente.cpp src/Estagiario.cpp main.cpp

# Arquivos objeto (.o).
OBJS := $(SRCS:.cpp=.o)

# Regra principal: compila tudo.
all: $(TARGET)

# Regra para gerar o executável.
$(TARGET): $(OBJS)
	$(CXX) $(CXXFLAGS) -o $@ $^

# Regra para compilar cada arquivo .cpp em .o.
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Limpa os arquivos objeto e o executável.
clean:
	rm -f $(OBJS) $(TARGET)

# Executa o programa.
run: $(TARGET)
	./$(TARGET)

.PHONY: all clean run