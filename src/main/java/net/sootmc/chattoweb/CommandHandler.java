package net.sootmc.chattoweb;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class CommandHandler extends Command {
    public CommandHandler(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!sender.hasPermission("chattoweb.reload")) { return; }

        if (args.length == 0) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Invalid Usage. Correct Usage: /chattoweb reload"));
            return;
        } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            ChatToWeb.instance.reloadConfig();
            sender.sendMessage(new TextComponent(ChatColor.GREEN + "Config reloaded!"));
        } else {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Invalid Usage. Correct Usage: /chattoweb reload"));
        }
    }
}
