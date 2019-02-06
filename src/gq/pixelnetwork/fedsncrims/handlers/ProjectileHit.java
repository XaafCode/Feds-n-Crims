package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

import gq.pixelnetwork.fedsncrims.items.GrenadeLauncher;
import gq.pixelnetwork.fedsncrims.items.Pistol;

public class ProjectileHit implements Listener {
    GrenadeLauncher grenadeLauncher = new GrenadeLauncher();
    Pistol pistol = new Pistol();
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

            if (bulletName.equals(grenadeLauncher.getBulletName())) {
                s.getWorld().createExplosion(s.getLocation(), 1.0F);

                return;
            }

            if (e instanceof LivingEntity) {
                float damage;

                // How much damage should the entity take?
                switch(bulletName) {
                case pistol.getBulletName():
                    damage = pistol.getDamage();
                    break;
                case grenadeLauncher.getBulletName():
                    damage = grenadeLauncher.getDamage();
                    break;
                }

                // Get hit entity and apply damage
                LivingEntity hitEntity = (LivingEntity) e;
                hitEntity.setHealth(hitEntity.getHealth() - damage);
            }
        }
    }
}
