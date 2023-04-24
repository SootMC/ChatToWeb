package net.sootmc.chattoweb.Models;

import com.google.gson.annotations.SerializedName;

public class ChatRequest {
    private String message;
    @SerializedName("username")
    private String name;
    private String uuid;

    public ChatRequest(String message, String name, String uuid) {
        this.message = message;
        this.name = name;
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
}
