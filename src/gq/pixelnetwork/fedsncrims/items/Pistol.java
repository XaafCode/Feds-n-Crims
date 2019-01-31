package gq.pixelnetwork.fedsncrims.items;

import java.util.ArrayList;

import gq.pixelnetwork.fedsncrims.handlers.FileHandler;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Pistol {
	private static FileHandler fileHandler = new FileHandler();
	private final float damage = 3;

	private ItemStack createGun() {
		ItemStack gun = new ItemStack(Material.GOLD_AXE);
		ItemMeta gunMeta = gun.getItemMeta();
		
		gunMeta.setDisplayName(ChatColor.WHITE + "Pistol");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "Ammo Type: Pistol");
		gunMeta.setLore(lore);
		
		gun.setItemMeta(gunMeta);
		
		return gun;
	}
	
	/** Returns the gun's ItemStack */
	public ItemStack getGun() {
		return createGun();
	}
	
	/** Returns the gun's ItemMeta */
	public ItemMeta getGunMeta() {
		return createGun().getItemMeta();
	}

    /**
     * Returns the gun's material
     */
	public Material materialType() {
		return createGun().getType();
	}

    /**
     * Fires the gun
     */
	public void fire(Player player) {
        Snowball s = player.launchProjectile(Snowball.class);
        s.setCustomName(player.getUniqueId().toString() + " pistol");

        if (fileHandler.getBool("debug")) {
			s.setCustomNameVisible(true);
		}

        s.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 10);
    }

	/**
	 * How much damage does the gun do
	 */
	public float getDamage() {
		return damage;
	}
}
