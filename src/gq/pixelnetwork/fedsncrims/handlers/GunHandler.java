package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import gq.pixelnetwork.fedsncrims.items.Pistol;

public class GunHandler {
	private static Pistol pistol = new Pistol();
	
	/** Check if the given ItemMeta corresponds with a gun's ItemMeta
	 * @param		itemStack
	 */
	public boolean isHoldingGun(ItemStack itemStack) {
		if (itemStack.getType() == pistol.materialType()) {
			return true;
		}
		
		return false;
	}
	
	/** Give all guns to the player
	 * @param		player
	 */
	public void getGuns(Player player) {
		player.getInventory().addItem(pistol.getGun());
	}

	public void fire(String gun, Player player) {
		if (gun == "pistol") {
			pistol.fire(player);
		}
	}
}
