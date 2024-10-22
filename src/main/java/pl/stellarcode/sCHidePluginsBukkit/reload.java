package pl.stellarcode.sCHidePluginsBukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {
    private static main plugin;
    public static void setplugin(main plugin) {
        reload.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hideplugins")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "Plugin stworzony przez Matisio (StellarCode)\nUzyj: /hideplugins reload");
                return true;

            } else {
                if (args[0].equalsIgnoreCase("reload")) {

                    if (sender.hasPermission("hideplugins.reload")) {
                        sender.sendMessage("Plugin przeladowano!");
                        plugin.reloadConfig();
                        plugin.config = plugin.getConfig();
                        return true;

                    } else {
                        sender.sendMessage(ChatColor.RED + "Nie masz permisji!");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Plugin stworzony przez Matisio (StellarCode)\nUzyj: /hideplugins reload");
                    return true;
                }
            }


        }
        return false;
    }
}

