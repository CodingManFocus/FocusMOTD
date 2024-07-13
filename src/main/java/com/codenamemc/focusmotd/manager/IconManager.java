package com.codenamemc.focusmotd.manager;

import com.codenamemc.focusmotd.FocusMOTD;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class IconManager {
    private final FocusMOTD plugin;
    private final ConfigManager configManager;
    private BukkitTask iconChangeTask;

    public IconManager(FocusMOTD plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    public void scheduleIconChange() {
        FileConfiguration config = configManager.getConfig();
        List<String> iconFiles = config.getStringList("icons.icon-files");
        int changeInterval = config.getInt("icons.change-interval", 60) * 20; // in ticks

        if (iconFiles.isEmpty()) return;

        iconChangeTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            Random random = new Random();
            String iconFile = iconFiles.get(random.nextInt(iconFiles.size()));
            File icon = new File(plugin.getDataFolder(), "icons/" + iconFile);
            if (icon.exists()) {
                try {
                    Path target = Paths.get(plugin.getServer().getWorldContainer().getAbsolutePath(), "server-icon.png");
                    Files.copy(icon.toPath(), target);
                } catch (IOException e) {
                    plugin.getLogger().warning("Failed to change server icon: " + e.getMessage());
                }
            }
        }, 0L, changeInterval);
    }

    public void cancelIconChange() {
        if (iconChangeTask != null) {
            iconChangeTask.cancel();
        }
    }
}