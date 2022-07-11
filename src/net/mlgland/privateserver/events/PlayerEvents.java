package net.mlgland.privateserver.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerEvents implements Listener {

    @EventHandler
    public static void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        UUID playerUUID = event.getUniqueId();
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerUUID);
        Player player = offlinePlayer.getPlayer();

        // if (!player.hasPermission("privateserver.join")) {
        // event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, ChatColor.RED
        // + "[PrivateServer] You do not have permission to join this server! Please
        // contact a server administrator if you think this is incorrect.\n");
        // System.out.println("[PrivateServer] [Log] Player " + player.getName() + " has
        // been kicked for insufficient permissions");
        // }

        // player.getEffectivePermissions().forEach(e -> {
        // Boolean perm = e.getAttachment().getPermissions().get("privateserver.join");
        // if (perm) {
        // event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, ChatColor.RED
        // + "[PrivateServer] You do not have permission to join this server! Please
        // contact a server administrator if you think this is incorrect.\n");
        // System.out.println("[PrivateServer] [Log] Player " + offlinePlayer.getName()
        // + " has been kicked for insufficient permissions");
        // }
        // });

    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        // get the player's UUID
        String uuid = event.getPlayer().getUniqueId().toString();
        // now we need to get the player's permissions
        boolean hasPerm = event.getPlayer().hasPermission("privateserver.join");
        if (!hasPerm) {
            event.getPlayer().kickPlayer(ChatColor.RED
                    + "[PrivateServer] You do not have permission to join this server! Please contact a server administrator if you think this is incorrect.\n");
        }
    }

}
