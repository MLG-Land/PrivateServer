package net.mlgland.privateserver.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class PlayerEvents implements Listener {

    @EventHandler
    public static void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        UUID playerUUID = event.getUniqueId();
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerUUID);
        Player player = offlinePlayer.getPlayer();

        try {
            if (!player.hasPermission("privateserver.join")) {
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, ChatColor.RED + "[PrivateServer] You do not have permission to join this server! Please contact a server administrator if you think this is incorrect.\n");
                System.out.println("[PrivateServer] [Log] Player " + player.getName() + " has been kicked for insufficient permissions");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
