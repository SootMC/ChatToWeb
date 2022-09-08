package net.sootmc.chattoweb;

import net.md_5.bungee.api.plugin.Plugin;

public final class ChatToWeb extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, new ChatListener());
        getLogger().info("ChatToWeb has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ChatToWeb has been disabled!");
    }
}
