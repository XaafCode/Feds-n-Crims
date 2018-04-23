package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import gq.pixelnetwork.fedsncrims.items.GrenadeLauncher;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class ProjectileHit implements Listener {
    GrenadeLauncher grenadeLauncher = new GrenadeLauncher();
    GunHandler gunHandler = new GunHandler();

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile instanceof Snowball) {
            Snowball s = (Snowball) projectile;
            Entity e = event.getHitEntity();

            // UUID as a String
            String shooterUUIDString = s.getName().replaceAll(" " + gunHandler.getBulletType(s.getName()), "");
            // Convert String UUID to UUID
            UUID shooterUUID = UUID.fromString(shooterUUIDString);
            // Get the player with the UUID
            Player shooter = Bukkit.getPlayer(shooterUUID);
            // Get the bullet name
            String bulletName = s.getName().replaceAll(shooter.getUniqueId().toString(), "");

            if (e instanceof LivingEntity) {
                LivingEntity hitEntity = (LivingEntity) e;

                hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 2, 0));
            }

            if (bulletName.equals(grenadeLauncher.getBulletName())) {
                s.getWorld().createExplosion(s.getLocation(), 1.0F);
            }
        }
    }
}
