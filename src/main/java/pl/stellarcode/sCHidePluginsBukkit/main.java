package pl.stellarcode.sCHidePluginsBukkit;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class main extends JavaPlugin implements Listener {

    FileConfiguration config;

    @Override
    public void onEnable() {
        reload.setplugin(this);
        saveDefaultConfig();
        config = getConfig();
        getCommand("hideplugins").setExecutor(new reload());
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("plugin wlaczony");

    }

    @Override
    public void onDisable() {
        getLogger().info("plugin wylaczony");
    }

    @EventHandler
    public void onCommandUse(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("hideplugin.bypass")){
            return;
        }
        List commands = config.getList("zablokowane-komendy.komendy");
        commands.forEach(all -> {
            if (event.getMessage().toLowerCase().equalsIgnoreCase("/" + all.toString().toLowerCase())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("wiadomosc.BRAK_PERMISJI")));
            }
        });
    }
}
