package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log;

import gq.pixelnetwork.fedsncrims.Main;

public class FileHandler {
    Main jp = new Main();

    FileConfiguration config = jp.getConfig();

    /** Saves the Default Config */
    public void saveConf() {
        jp.saveDefaultConfig();
        Log.info("[Feds 'n Crims] Saving the config!");
    }

    /**
     * Gets the Config file
     * @return configuration file
     */
    public FileConfiguration getConf() {
        return config;
    }

    /**
     * Adds a Boolean to the config
     * @param key   Location that the Boolean will be stored at
     * @param value Value for the key
     */
    public void addBool(String key, boolean value) {
        config.addDefault(key, value);
    }

    /**
     * Gets a Boolean value for a key in the config
     * @param key   Location that contains a Boolean value
     * @return      Value for the key
     */
    public boolean getBool(String key) {
        return config.getBoolean(key);
    }

    /**
     * Adds a String to the config
     * @param key   Location that the String will be stored at
     * @param value Value for the key
     */
    public void addString(String key, String value) {
        config.addDefault(key, value);
    }

    /**
     * Gets a String value for a key in the config
     * @param key   Location that contains a String value
     * @return      Value for the key
     */
    public String getString(String key) {
        return config.getString(key);
    }

    /**
     * Adds an Integer to the config
     * @param key   Location that the Integer will be stored at
     * @param value Value for the key
     */
    public void addInt(String key, int value) {
        config.addDefault(key, value);
    }

    /**
     * Gets an Integer value for a key in the config
     * @param key   Location that contains an Integer value
     * @return      Value for the key
     */
    public int getInt(String key) {
        return config.getInt(key);
    }
}