package net.sootmc.chattoweb;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandler {

    public static void makeRequest(String message, String name, String uuid, String server) {
        RequestModel requestModel = new RequestModel(message, name, uuid);
        Gson gson = new Gson();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ChatToWeb.url + "/api/servers/" + server + "/message"))
                    .header("Authorization", ChatToWeb.token)
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestModel)))
                    .build();

            HttpClient.newBuilder()
                    .build()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            
        }
    }
}
