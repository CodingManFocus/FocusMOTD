package com.codenamemc.focusmotd.api;

import com.codenamemc.focusmotd.FocusMOTD;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceHolders extends PlaceholderExpansion {
    private final FocusMOTD plugin;

    public PlaceHolders(FocusMOTD plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier() {
        return "custommotd";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        // 예시로 %custommotd_example% 변수를 제공
        if (identifier.equals("example")) {
            return "example output";
        }
        return null;
    }
}
