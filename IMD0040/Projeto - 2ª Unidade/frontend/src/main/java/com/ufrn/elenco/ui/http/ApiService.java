package com.ufrn.elenco.ui.http;

import javafx.concurrent.Task;

public class ApiService {

    private static final String API_URL = "http://localhost:8080/jogadores";

    public Task<String> getJogadores() {
        return new Task<>() {
            @Override
            protected String call() throws Exception {
                // Usa o HttpClient do próprio projeto
                return HttpClient.get(API_URL);
            }
        };
    }
}
