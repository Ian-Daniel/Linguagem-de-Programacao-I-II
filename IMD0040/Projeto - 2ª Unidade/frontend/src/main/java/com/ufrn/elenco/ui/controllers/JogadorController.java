package com.ufrn.elenco.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JogadorController {
    @FXML
    private Label lblJogadorNome;
    @FXML
    private Label lblJogadorIdade;
    @FXML
    private Label lblJogadorPosicao;

    public void setJogador(String nome, int idade, String posicao) {
        lblJogadorNome.setText(nome);
        lblJogadorIdade.setText(String.valueOf(idade));
        lblJogadorPosicao.setText(posicao);
    }
}