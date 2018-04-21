package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.Bukkit;

import gq.pixelnetwork.fedsncrims.commands.FNC;

public class CommandHandler {
	public void setExecutors() {
		/* TEMPLATE:
		 * Bukkit.getPluginCommand("commandname").setExecutor(new CommandName());
		 * CommandName() is a class in the commands package.
		 */
		Bukkit.getPluginCommand("fnc").setExecutor(new FNC());
	}
}