package com.ufrn.elenco.ui.controllers;

import com.ufrn.elenco.ui.http.ApiService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JogadorListController {

    @FXML
    private ListView<Jogador> lstJogadores;

    private final ApiService apiService = new ApiService();
    private final ObservableList<Jogador> jogadores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        lstJogadores.setItems(jogadores);

        carregarJogadores();

        // Duplo clique abre a tela de detalhes
        lstJogadores.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Jogador selecionado = lstJogadores.getSelectionModel().getSelectedItem();
                if (selecionado != null) {
                    abrirDetalheJogador(selecionado);
                }
            }
        });
    }

    private void carregarJogadores() {
        Task<String> task = apiService.getJogadores();

        task.setOnSucceeded(e -> {
            String json = task.getValue();
            List<Jogador> lista = parseJogadoresJson(json);
            jogadores.setAll(lista);
        });

        task.setOnFailed(e -> {
            jogadores.clear();
            jogadores.add(new Jogador("Erro ao carregar jogadores", 0, "Verifique o backend"));
        });

        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
    }


    private List<Jogador> parseJogadoresJson(String json) {
        List<Jogador> lista = new ArrayList<>();

        if (json == null || json.isBlank()) {
            return lista;
        }

        String trimmed = json.trim();
        if (trimmed.startsWith("[")) trimmed = trimmed.substring(1);
        if (trimmed.endsWith("]")) trimmed = trimmed.substring(0, trimmed.length() - 1);
        if (trimmed.isBlank()) return lista;

        String[] objetos = trimmed.split("\\},\\s*\\{");

        for (String obj : objetos) {
            String o = obj.trim();
            if (!o.startsWith("{")) o = "{" + o;
            if (!o.endsWith("}")) o = o + "}";

            String nome = extrairString(o, "nome");
            int idade = extrairInt(o, "idade");
            String posicao = extrairString(o, "posicao");

            if (nome != null && !nome.isBlank()) {
                lista.add(new Jogador(nome, idade, posicao));
            }
        }

        return lista;
    }

    private String extrairString(String jsonObj, String campo) {
        String chave = "\"" + campo + "\"";
        int idx = jsonObj.indexOf(chave);
        if (idx == -1) return null;

        int start = jsonObj.indexOf(':', idx);
        if (start == -1) return null;

        start++;
        while (start < jsonObj.length() && Character.isWhitespace(jsonObj.charAt(start))) {
            start++;
        }

        if (start < jsonObj.length() && jsonObj.charAt(start) == '"') {
            start++;
            int end = jsonObj.indexOf('"', start);
            if (end == -1) return null;
            return jsonObj.substring(start, end);
        } else {
            int end = jsonObj.indexOf(',', start);
            if (end == -1) end = jsonObj.indexOf('}', start);
            if (end == -1) end = jsonObj.length();
            return jsonObj.substring(start, end).trim();
        }
    }

    private int extrairInt(String jsonObj, String campo) {
        try {
            String s = extrairString(jsonObj, campo);
            if (s == null || s.isBlank()) return 0;
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void abrirDetalheJogador(Jogador jogador) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/ufrn/elenco/ui/resources/fxml/JogadorDetailView.fxml")
            );
            Parent root = loader.load();

            JogadorController controller = loader.getController();
            controller.setJogador(jogador.getNome(), jogador.getIdade(), jogador.getPosicao());

            Stage stage = new Stage();
            stage.setTitle("Detalhes do Jogador");
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classe interna simples para representar um jogador na lista
    public static class Jogador {
        private final String nome;
        private final int idade;
        private final String posicao;

        public Jogador(String nome, int idade, String posicao) {
            this.nome = nome;
            this.idade = idade;
            this.posicao = posicao;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public String getPosicao() {
            return posicao;
        }

        @Override
        public String toString() {
            if (posicao != null && !posicao.isBlank()) {
                return nome + " (" + posicao + ", " + idade + " anos)";
            }
            return nome + " (" + idade + " anos)";
        }
    }
}
