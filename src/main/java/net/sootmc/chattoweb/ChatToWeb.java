package net.sootmc.chattoweb;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.sootmc.chattoweb.Listeners.ChatListener;
import net.sootmc.chattoweb.Listeners.ConnectionListener;

import java.io.*;

public final class ChatToWeb extends Plugin {

    public static String url;
    public static String token;
    public static ChatToWeb instance;

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, new ChatListener());
        this.getProxy().getPluginManager().registerListener(this, new ConnectionListener());
        instance = this;

        this.getProxy().getPluginManager().registerCommand(this, new CommandHandler("chattoweb", "chattoweb.reload", "ctw"));

        if (!getDataFolder().exists()) {
            getLogger().info("Created config folder: " + getDataFolder().mkdir());
        }

        File configFile = new File(getDataFolder(), "config.yml");

        // Copy default config if it doesn't exist
        if (!configFile.exists()) {
            FileOutputStream outputStream = null; // Throws IOException
            try {
                outputStream = new FileOutputStream(configFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            InputStream in = getResourceAsStream("config.yml"); // This file must exist in the jar resources folder
            try {
                in.transferTo(outputStream); // Throws IOException
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!getDataFolder().exists()) {
            getLogger().info("Created config folder: " + getDataFolder().mkdir());
        }

        try {
            Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
            url = configuration.getString("url");
            token = configuration.getString("token");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getLogger().info("ChatToWeb has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ChatToWeb has been disabled!");
    }

    public void reloadConfig() {
        try {
            Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
            url = configuration.getString("url");
            token = configuration.getString("token");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
