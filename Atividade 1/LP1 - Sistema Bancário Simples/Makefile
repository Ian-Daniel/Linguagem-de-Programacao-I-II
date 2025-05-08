# Nome do executável final em questão.
EXEC = LP1 - Sistema Bancário Simples

# Compilador e flags.
CXX = g++
CXXFLAGS = -Wall -std=c++11

# Fontes e objetos.
SRC = main.cpp ContaBancaria.cpp Cliente.cpp
OBJ = $(SRC:.cpp=.o)

# Regra padrão.
all: $(EXEC)

$(EXEC): $(OBJ)
	$(CXX) $(CXXFLAGS) -o $@ $^

# Compilação individual dos arquivos .cpp em .o.
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Limpa os arquivos gerados.
clean:
	rm -f *.o $(EXEC)