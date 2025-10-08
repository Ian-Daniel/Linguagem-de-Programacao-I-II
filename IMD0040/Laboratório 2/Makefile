SRC = src
BIN = bin

all:
	mkdir -p $(BIN)
	javac $(SRC)/*.java -d $(BIN)

run: all
	java -cp $(BIN) Banco

clean:
	rm -rf $(BIN)
