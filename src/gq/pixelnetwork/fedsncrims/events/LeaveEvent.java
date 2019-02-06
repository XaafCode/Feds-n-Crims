package gq.pixelnetwork.fedsncrims.events;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
//    TeamHandler teamHandler = new TeamHandler();

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {


        Log.info("Player " + event.getPlayer().getName() + " has left...");
    }
}
