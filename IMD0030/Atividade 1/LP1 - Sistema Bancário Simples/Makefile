# Compilador e flags.
CXX = g++
CXXFLAGS = -Wall -Wextra -std=c++17

# Arquivos-fonte e objetos.
SRC = main.cpp Cliente.cpp ContaBancaria.cpp
OBJ = $(SRC:.cpp=.o)

# Nome do executável final.
TARGET = programa

# Regra principal.
all: $(TARGET)

$(TARGET): $(OBJ)
	$(CXX) $(CXXFLAGS) -o $@ $^

# Regra para arquivos .o.
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Limpa arquivos de build.
clean:
	rm -f $(OBJ) $(TARGET)

# Facilita testes e execução.
run: $(TARGET)
	./$(TARGET)