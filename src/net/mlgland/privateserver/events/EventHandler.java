package net.mlgland.privateserver.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("privateserver.join")) {
            player.kickPlayer(ChatColor.RED + "[PrivateServer] You do not have permission to join this server! Please contact a server administrator if you think this is incorrect.\n");
            System.out.println("[PrivateServer] [Log] Player " + player.getName() + " has been kicked for insufficient permissions");
        }
    }

}
