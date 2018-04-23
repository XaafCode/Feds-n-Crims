package gq.pixelnetwork.fedsncrims.items;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class GrenadeLauncher {
    private ItemStack createGun() {
        ItemStack gun = new ItemStack(Material.IRON_AXE);
        ItemMeta gunMeta = gun.getItemMeta();

        gunMeta.setDisplayName(ChatColor.WHITE + "Grenade Launcher");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Ammo Type: Grenade");
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

    public String getBulletName() {
        return " grenade_launcher";
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
        s.setCustomName(player.getUniqueId().toString() + getBulletName());
        s.setCustomNameVisible(true);
        s.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 10);
    }
}
