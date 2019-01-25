package com.ericlam.mc.main;

import com.ericlam.mc.commands.FlyCommandExecutor;
import com.ericlam.mc.commands.FuckCommandExecutor;
import com.ericlam.mc.commands.ReloadCommandExecutor;
import com.ericlam.mc.listeners.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        ConsoleCommandSender sender = this.getServer().getConsoleSender();
        sender.sendMessage(ChatColor.RED+ "I am a red text");
        this.getLogger().info("Shit plugin enabled!");
        ConfigManager.getInstance(this).loadConfig();
        this.getServer().getPluginManager().registerEvents(new JoinListener(),this);
        this.getCommand("fuck").setExecutor(new FuckCommandExecutor());
        this.getCommand("fly").setExecutor(new FlyCommandExecutor());
        this.getCommand("testreload").setExecutor(new ReloadCommandExecutor());
    }

    @Override
    public void onDisable() {

    }
}
