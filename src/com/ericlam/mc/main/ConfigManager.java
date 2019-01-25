package com.ericlam.mc.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    private File configFile;
    private FileConfiguration config;
    private static ConfigManager configManager;

    public static ConfigManager getInstance(Plugin plugin) {
        if (configManager == null) configManager = new ConfigManager(plugin);
        return configManager;
    }

    public static String joinMSG, flyMSG, flyNotMSG, noPerm, fuckMSG, reloadMSG;

    private ConfigManager(Plugin plugin){
        configFile = new File(plugin.getDataFolder(),"config.yml");
        if (!configFile.exists()) plugin.saveResource("config.yml",true);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    void loadConfig(){
        joinMSG = ChatColor.translateAlternateColorCodes('&',config.getString("join-msg"));
        flyMSG =  ChatColor.translateAlternateColorCodes('&',config.getString("fly.msg"));
        flyNotMSG = ChatColor.translateAlternateColorCodes('&',config.getString("fly.not-msg"));
        noPerm = ChatColor.translateAlternateColorCodes('&',config.getString("fuck.no-perm-msg"));
        fuckMSG = ChatColor.translateAlternateColorCodes('&',config.getString("fuck.msg"));
        reloadMSG = ChatColor.translateAlternateColorCodes('&',config.getString("reload"));
    }

    public void reloadConfig(){
        config = YamlConfiguration.loadConfiguration(configFile);
        loadConfig();
    }
}
