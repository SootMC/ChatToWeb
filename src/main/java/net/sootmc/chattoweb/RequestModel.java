package net.sootmc.chattoweb;

public class RequestModel {
    private String message;
    private String name;
    private String uuid;

    public RequestModel(String message, String name, String uuid) {
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
