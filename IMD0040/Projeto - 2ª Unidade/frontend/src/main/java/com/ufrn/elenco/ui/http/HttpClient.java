package com.ufrn.elenco.ui.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpClient {

    private static final java.net.http.HttpClient CLIENT =
            java.net.http.HttpClient.newHttpClient();

    private HttpClient() {
        // Evita instanciar
    }


    public static String get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}
