package gq.pixelnetwork.fedsncrims;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import gq.pixelnetwork.fedsncrims.events.LeaveEvent;
import gq.pixelnetwork.fedsncrims.handlers.CommandHandler;
import gq.pixelnetwork.fedsncrims.handlers.FileHandler;
import gq.pixelnetwork.fedsncrims.handlers.ProjectileHit;
import gq.pixelnetwork.fedsncrims.handlers.RightClickHandler;

public class Main extends JavaPlugin {
	private static CommandHandler CommandHandler = new CommandHandler();
	private static Listener rightClickHandler = new RightClickHandler();
	private static Listener leaveEvent = new LeaveEvent();
	private static Listener projectileHitEvent = new ProjectileHit();
//	private static FileHandler FileHandler  = new FileHandler();

	public void onEnable() {
		Log.info("Enabled the \"Feds 'n Crimes\" plugin!");
//		FileHandler.saveConf();
		
		Bukkit.getPluginManager().registerEvents(rightClickHandler, this);
		Bukkit.getPluginManager().registerEvents(leaveEvent, this);
		Bukkit.getPluginManager().registerEvents(projectileHitEvent, this);

		CommandHandler.setExecutors();
	}
	
	public void onDisable() {
		Log.info("Disabled the \"Feds 'n Crimes\" plugin!");

//		FileHandler.saveConf();
	}
}
