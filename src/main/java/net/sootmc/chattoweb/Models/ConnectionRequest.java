package net.sootmc.chattoweb.Models;

import com.google.gson.annotations.SerializedName;

public class ConnectionRequest {

    private String type;
    @SerializedName("username")
    private String name;
    private String uuid;

    public ConnectionRequest(String name, String uuid, String type) {
        this.name = name;
        this.uuid = uuid;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
}
