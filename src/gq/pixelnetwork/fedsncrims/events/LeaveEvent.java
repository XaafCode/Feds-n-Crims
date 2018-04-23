package gq.pixelnetwork.fedsncrims.events;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import gq.pixelnetwork.fedsncrims.handlers.TeamHandler;
import net.md_5.bungee.api.ChatColor;

public class LeaveEvent implements Listener {
    TeamHandler teamHandler = new TeamHandler();

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        teamHandler.removeUUIDFromTeam(event.getPlayer().getUniqueId().toString());

        for (int i = 0; i < teamHandler.getInGame(); i++) {
            String uuid = teamHandler.getTeam("ingame").get(i).toString();
            Player player = Bukkit.getPlayer(uuid);

            player.sendMessage(ChatColor.WHITE + "FnC" + ChatColor.GRAY + "> " + ChatColor.YELLOW + player.getName() + ChatColor.WHITE + " has left Feds 'n Crims!");
        }

        Log.info("Player has left...");
    }
}
