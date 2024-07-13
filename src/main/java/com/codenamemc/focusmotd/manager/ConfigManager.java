package com.codenamemc.focusmotd.manager;

import com.codenamemc.focusmotd.FocusMOTD;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final FocusMOTD plugin;

    public ConfigManager(FocusMOTD plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }
}
