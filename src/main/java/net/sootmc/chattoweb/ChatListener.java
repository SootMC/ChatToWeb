package net.sootmc.chattoweb;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.UUID;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(ChatEvent event) {
        if(event.getSender() instanceof ProxiedPlayer player) {

            String message = event.getMessage();

            if(message.startsWith("/")) 
                return;

            String name = player.getName();
            UUID uuid = player.getUniqueId();
            String server = player.getServer().getInfo().getName();

            HttpHandler.makeRequest(message, name, uuid.toString(), server);
        }
    }
}
