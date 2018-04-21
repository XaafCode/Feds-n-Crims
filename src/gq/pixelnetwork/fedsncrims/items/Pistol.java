package gq.pixelnetwork.fedsncrims.items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Pistol {
	private ItemStack createGun() {
		ItemStack gun = new ItemStack(Material.GOLD_PICKAXE);
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
	
	/** Returns the display name using §-symbols instead of ChatColor.X */
	public String getBareDisplayName() {
		return "§fPistol";
	}
}
