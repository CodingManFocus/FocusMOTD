package com.codenamemc.focusmotd;

import com.codenamemc.focusmotd.api.*;
import com.codenamemc.focusmotd.manager.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class FocusMOTD extends JavaPlugin {

    private ConfigManager configManager;
    private MOTDManager motdManager;
    private PlayerCountManager playerCountManager;
    private IconManager iconManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        motdManager = new MOTDManager(this, configManager);
        playerCountManager = new PlayerCountManager(this, configManager);
        iconManager = new IconManager(this, configManager);

        motdManager.setServerMOTD();
        playerCountManager.setPlayerCount();
        iconManager.scheduleIconChange();

        // PlaceholderAPI 및 Skript API 지원을 초기화
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PlaceHolders(this).register();
        }
        getLogger().info("FocusMOTD is enabled!");

    }

    @Override
    public void onDisable() {
        getLogger().info("FocusMOTD is disabled");
        getLogger().info("GoodBye!~");
    }
}
