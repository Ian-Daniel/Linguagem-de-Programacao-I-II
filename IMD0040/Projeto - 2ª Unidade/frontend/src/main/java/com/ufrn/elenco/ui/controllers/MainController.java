package com.ufrn.elenco.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button btnShowJogadores;

    @FXML
    public void initialize() {
        btnShowJogadores.setOnAction(e -> {
            // Ação de navegar para a tela de jogadores
        });
    }
}