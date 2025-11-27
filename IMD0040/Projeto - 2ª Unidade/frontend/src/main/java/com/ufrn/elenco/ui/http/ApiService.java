package com.ufrn.elenco.ui.http;

import javafx.concurrent.Task;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ApiService {

    private static final String API_URL = "http://localhost:8080/jogadores";

    public Task<String> getJogadores() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() throws Exception {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            }
        };
        return task;
    }
}