package com.ufrn.elenco.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnShowJogadores;

    @FXML
    public void initialize() {
        btnShowJogadores.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/ufrn/elenco/ui/resources/fxml/JogadorListView.fxml")
                );
                Parent root = loader.load();

                Stage stage = (Stage) btnShowJogadores.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.setTitle("Lista de Jogadores - Elenco UFRN");
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
