package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import gq.pixelnetwork.fedsncrims.items.GrenadeLauncher;

public class ProjectileHit implements Listener {
    GrenadeLauncher grenadeLauncher = new GrenadeLauncher();

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile instanceof Snowball) {
            Snowball s = (Snowball) projectile;

            Player shooter = Bukkit.getPlayer(s.getName());

            if (s.getName() == grenadeLauncher.getBulletName()) {
                s.getWorld().createExplosion(s.getLocation(), 1.0F);
            }
//
        }
    }
}
