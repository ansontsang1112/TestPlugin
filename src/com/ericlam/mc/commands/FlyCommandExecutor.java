package com.ericlam.mc.commands;

import com.ericlam.mc.main.ConfigManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommandExecutor implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("you are not player");
            return false;
        }

        Player player = (Player) commandSender;

        if (player.getGameMode() == GameMode.CREATIVE){
            commandSender.sendMessage("you are in creative mode!!!");
            return false;
        }

        boolean notFly = !player.getAllowFlight();

        player.setAllowFlight(notFly);
        player.setFlying(notFly);
        player.sendMessage(notFly ? ConfigManager.flyMSG : ConfigManager.flyNotMSG);

        return true;
    }
}
