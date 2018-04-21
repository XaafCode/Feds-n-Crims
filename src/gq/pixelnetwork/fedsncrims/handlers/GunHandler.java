package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import gq.pixelnetwork.fedsncrims.items.Pistol;

public class GunHandler {
	private static Pistol pistol = new Pistol();
	
	/** Check if the given ItemMeta corresponds with a gun's ItemMeta
	 * @param itemMeta
	 */
	public boolean isHoldingGun(ItemMeta itemMeta) {
		if (itemMeta.getDisplayName() == pistol.getBareDisplayName()) {
			return true;
		}
		
		return false;
	}
	
	/** Give all guns to the player
	 * @param Player player
	 */
	public void getGuns(Player player) {
		player.getInventory().addItem(pistol.getGun());
	}
}
