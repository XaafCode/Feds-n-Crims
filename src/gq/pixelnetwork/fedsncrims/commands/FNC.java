package gq.pixelnetwork.fedsncrims.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gq.pixelnetwork.fedsncrims.handlers.GunHandler;
import net.md_5.bungee.api.ChatColor;

public class FNC implements CommandExecutor {
	private static GunHandler gunHandler = new GunHandler();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("fnc.base") || sender.hasPermission("fnc.*")) {
			if (args.length > 0) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.RESET + "");
						sender.sendMessage(ChatColor.GRAY + "-= " + ChatColor.WHITE + "Feds 'n Crims - Commands" + ChatColor.GRAY + "=-");
						sender.sendMessage(ChatColor.GRAY + "+ " + ChatColor.WHITE + "/fnc" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Base command for Feds 'n Crims");
						sender.sendMessage(ChatColor.GRAY + "+ " + ChatColor.WHITE + "/fnc guns" + ChatColor.GRAY + " - " + ChatColor.WHITE + "Gives you all Feds 'n Crims guns");
						sender.sendMessage(ChatColor.RESET + "");
						return true;
					} else if (args[0].equalsIgnoreCase("guns")) {
						if (sender instanceof Player)  {
							Player player = (Player) sender; // Here we're telling the server that the sender is indeed a player instance
							
							sender.sendMessage(ChatColor.GRAY + "\nGiving you all guns..." + ChatColor.RESET + "");
							
							gunHandler.getGuns(player);
						} else {
							sender.sendMessage(ChatColor.RED + "Hey! " + ChatColor.WHITE + "You must be a Player to use this command.");
						}
						
						return true;
					} else {
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.WHITE + "Please enter a valid sub-command. Use '/fnc help' for a list with usable commands.");
						
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.WHITE + "Please enter a valid sub-command. Use '/fnc help' for a list with usable commands.");
					
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.WHITE + "Please enter a valid sub-command. Use '/fnc help' for a list with usable commands.");
				
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.WHITE + "Sorry, but you don't have the permission to do this!");
			return true;
		}
	}
}
