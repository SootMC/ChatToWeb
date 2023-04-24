package net.sootmc.chattoweb;

import com.google.gson.Gson;
import net.sootmc.chattoweb.Models.ChatRequest;
import net.sootmc.chattoweb.Models.ConnectionRequest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandler {

    public static void makeRequest(String message, String name, String uuid, String server) {
        ChatRequest requestModel = new ChatRequest(message, name, uuid);
        Gson gson = new Gson();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ChatToWeb.url + "/api/servers/" + server + "/message"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + ChatToWeb.token)
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestModel)))
                    .build();

            HttpClient.newBuilder()
                    .build()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {

        }
    }

    public static void makeConnectionRequest(String name, String UUID, String server, String connectionType) {
        ConnectionRequest requestModel = new ConnectionRequest(name, UUID, connectionType);
        Gson gson = new Gson();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ChatToWeb.url + "/api/servers/" + server + "/connection"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + ChatToWeb.token)
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestModel)))
                    .build();

            HttpClient.newBuilder()
                    .build()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {

        }
    }
}
