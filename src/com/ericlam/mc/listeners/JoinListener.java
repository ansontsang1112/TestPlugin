package com.ericlam.mc.listeners;

import com.ericlam.mc.main.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(ConfigManager.joinMSG.replace("<player>",e.getPlayer().getName()));
    }

    @EventHandler
    public void onPlayerVoid(EntityDamageEvent e){
        if (!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        if (!player.getWorld().getName().equalsIgnoreCase("world")) return;

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
            return;
        }

        if (e.getCause() != EntityDamageEvent.DamageCause.VOID) return;
        e.setCancelled(true);
        player.teleport(player.getWorld().getSpawnLocation());
        player.sendMessage("Teleporting you to spawn....");
    }
}
