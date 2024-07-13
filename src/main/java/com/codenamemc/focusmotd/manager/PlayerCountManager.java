package com.codenamemc.focusmotd.manager;

import com.codenamemc.focusmotd.FocusMOTD;
import org.bukkit.configuration.file.FileConfiguration;

public class PlayerCountManager {
    private final FocusMOTD plugin;
    private final ConfigManager configManager;

    public PlayerCountManager(FocusMOTD plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    public void setPlayerCount() {
        FileConfiguration config = configManager.getConfig();
        int maxPlayers = config.getInt("player-count.max-players", 100);
        plugin.getServer().setMaxPlayers(maxPlayers);
    }
}
