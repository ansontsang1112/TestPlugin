package com.ericlam.mc.commands;

import com.ericlam.mc.main.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FuckCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)){
                sender.sendMessage("fuck off , you are not player");
                return false;
            }

            if (!sender.hasPermission("fuck.perm")){
                sender.sendMessage(ConfigManager.noPerm);
                return false;
            }

            sender.sendMessage(ConfigManager.fuckMSG);

            return true;
    }
}
