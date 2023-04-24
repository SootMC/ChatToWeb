package net.sootmc.chattoweb.Listeners;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.sootmc.chattoweb.HttpHandler;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onServerConnection(ServerSwitchEvent event) {
        String name = event.getPlayer().getName();
        String uuid = event.getPlayer().getUniqueId().toString();
        String serverConnected = event.getPlayer().getServer().getInfo().getName();

        if(event.getFrom() == null) {
            HttpHandler.makeConnectionRequest(name, uuid, serverConnected, "connect");
            return;
        }
        String serverDisconnected = event.getFrom().getName();
        HttpHandler.makeConnectionRequest(name, uuid, serverConnected, "connect");
        HttpHandler.makeConnectionRequest(name, uuid, serverDisconnected, "disconnect");
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent event) {
        String name = event.getPlayer().getName();
        String uuid = event.getPlayer().getUniqueId().toString();
        String server = event.getPlayer().getServer().getInfo().getName();

        HttpHandler.makeConnectionRequest(name, uuid, server, "disconnect");
    }
}
