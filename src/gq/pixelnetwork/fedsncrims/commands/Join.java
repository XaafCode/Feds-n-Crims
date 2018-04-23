package gq.pixelnetwork.fedsncrims.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gq.pixelnetwork.fedsncrims.handlers.TeamHandler;
import net.md_5.bungee.api.ChatColor;

public class Join implements CommandExecutor {
    TeamHandler teamHandler = new TeamHandler();
    ArrayList<String> teamFeds = teamHandler.getTeam("feds");
    ArrayList<String> teamCrims = teamHandler.getTeam("crims");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("fnc.join")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (teamFeds.size() > teamCrims.size()) {
                    // Join team Crims
                    teamHandler.addUUID("crims", player.getUniqueId().toString());
                    player.sendMessage(ChatColor.WHITE + "FnC" + ChatColor.GRAY + "> " + ChatColor.WHITE + "You have join team Crims!");
                } else if (teamFeds.size() < teamCrims.size()) {
                    // Join team Feds
                    teamHandler.addUUID("feds", player.getUniqueId().toString());
                    player.sendMessage(ChatColor.WHITE + "FnC" + ChatColor.GRAY + "> " + ChatColor.WHITE + "You have join team Feds!");
                } else {
                    int tmp = (int) ( Math.random() * 2 + 1);
                    if (tmp == 1) {
                        teamHandler.addUUID("crims", player.getUniqueId().toString());
                        player.sendMessage(ChatColor.WHITE + "FnC" + ChatColor.GRAY + "> " + ChatColor.WHITE + "You have join team Crims!");
                    } else {
                        teamHandler.addUUID("feds", player.getUniqueId().toString());
                        player.sendMessage(ChatColor.WHITE + "FnC" + ChatColor.GRAY + "> " + ChatColor.WHITE + "You have join team Feds!");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.WHITE + "You must be a Player to use this command.");
            }
        }

        return true;
    }
}
