package gq.pixelnetwork.fedsncrims.handlers;

import gq.pixelnetwork.fedsncrims.items.GrenadeLauncher;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import gq.pixelnetwork.fedsncrims.items.Pistol;

public class GunHandler {
	private static Pistol pistol = new Pistol();
	private static GrenadeLauncher grenadeLauncher = new GrenadeLauncher();
	
	/** Check if the given ItemMeta corresponds with a gun's ItemMeta
	 * @param		itemStack
	 */
	public boolean isHoldingGun(ItemStack itemStack) {
		switch(itemStack.getType()) {
		case pistol.materialType():
			return true;
		case grenadeLauncher.materialType():
			return true;
		default:
			return false;
		}
	}

	/**
	 * Checks what gun is being held
	 * @param itemStack
	 * @return gunType
	 */
	public String holdingGunType(ItemStack itemStack) {
		if (itemStack.getType() == pistol.materialType()) {
			return "pistol";
		} else if (itemStack.getType() == grenadeLauncher.materialType()) {
			return "grenade_launcher";
		}

		return null;
	}
	
	/** Give all guns to the player
	 * @param player
	 */
	public void getGuns(Player player) {
		player.getInventory().addItem(pistol.getGun());
		player.getInventory().addItem(grenadeLauncher.getGun());
	}

	public String getBulletType(String bulletName) {
		if (bulletName.toLowerCase().indexOf("pistol") != -1) {
			return "pistol";
		} else if (bulletName.toLowerCase().indexOf("grenade_launcher") != -1) {
			return "grenade_launcher";
		}

		return null;
	}

	/**
	 * Fires a bullet
	 * @param gun
	 * @param player
	 */
	public void fire(String gun, Player player) {
		if (gun == "pistol") {
			pistol.fire(player);
		} else if (gun == "grenade_launcher") {
			grenadeLauncher.fire(player);
		}
	}
}
