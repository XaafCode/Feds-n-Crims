package gq.pixelnetwork.fedsncrims.handlers;

import gq.pixelnetwork.fedsncrims.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class FileHandler {
    public static JavaPlugin jp;

    /**
     * Loads the Config file, including the Defaults
     */
    public void loadConfig() {
        String path = "debug";
        jp.getConfig().addDefault(path, "false");

        jp.getConfig().options().copyDefaults(true);
        jp.saveConfig();
    }

    /**
     * Reloads the Config
     */
    public void reloadConfig() {
        jp.reloadConfig();
    }

    public void set(String path, Object value) {
        jp.getConfig().set(path, value);
    }

    public String getString(String path) {
        return jp.getConfig().getString(path);
    }

    public int getInt(String path) {
        return jp.getConfig().getInt(path);
    }

    public boolean getBool(String path) {
        return jp.getConfig().getBoolean(path);
    }
}