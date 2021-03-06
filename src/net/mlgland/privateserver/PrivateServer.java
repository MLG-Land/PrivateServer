package net.mlgland.privateserver;

import net.mlgland.privateserver.events.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PrivateServer extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        FileManager.createPermissionsDatabaseFile();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PrivateServer] Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PrivateServer] Plugin has been disabled!");
    }

}
