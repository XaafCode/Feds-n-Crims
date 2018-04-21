package gq.pixelnetwork.fedsncrims;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import gq.pixelnetwork.fedsncrims.handlers.CommandHandler;
import gq.pixelnetwork.fedsncrims.handlers.RightClickHandler;

public class Main extends JavaPlugin {
	private static CommandHandler CommandHandler = new CommandHandler();
	private static Listener rightClickHandler = new RightClickHandler();
	
	public void onEnable() {
		Log.info("Enabled the \"Feds 'n Crimes\" plugin!");
		
		Bukkit.getPluginManager().registerEvents(rightClickHandler, this);		
		CommandHandler.setExecutors();
	}
	
	public void onDisable() {
		Log.info("Disabled the \"Feds 'n Crimes\" plugin!");
	}
}
