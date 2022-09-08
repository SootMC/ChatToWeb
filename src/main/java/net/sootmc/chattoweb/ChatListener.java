package net.sootmc.chattoweb;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(ChatEvent event) {
        if(event.getSender() instanceof ProxiedPlayer player) {
            String message = event.getMessage();
            String name = player.getName();
            String server = player.getServer().getInfo().getName();

            
        }
    }
}
