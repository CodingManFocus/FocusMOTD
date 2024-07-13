package com.codenamemc.focusmotd.manager;

import com.codenamemc.focusmotd.FocusMOTD;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import me.clip.placeholderapi.PlaceholderAPI;

import java.util.List;

public class MOTDManager {
    private final FocusMOTD plugin;
    private final ConfigManager configManager;

    public MOTDManager(FocusMOTD plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    public void setServerMOTD() {
        FileConfiguration config = configManager.getConfig();
        List<String> motdLines = config.getStringList("motd");
        String motd = String.join("\n", motdLines).replaceAll("&", "§");

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            motd = PlaceholderAPI.setPlaceholders(null, motd);
        }

        Bukkit.getServer().setMotd(motd);
    }
}
