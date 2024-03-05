package me.bedrye.parkourgame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParkourGame extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginCommand("EP").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
