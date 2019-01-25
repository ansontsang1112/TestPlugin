package com.ericlam.mc.commands;

import com.ericlam.mc.main.ConfigManager;
import com.ericlam.mc.main.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ConfigManager.getInstance(TestPlugin.plugin).reloadConfig();
        commandSender.sendMessage(ChatColor.GREEN + ConfigManager.reloadMSG);
        return true;
    }
}
