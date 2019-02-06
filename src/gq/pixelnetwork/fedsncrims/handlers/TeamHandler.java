package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

importy gq.pixelnetwork.fedsncrims.Utilities.java;

public class TeamHandler {
    ArrayList<Player> teamCops = new ArrayList<Player>();
    ArrayList<Player> teamCrims = new ArrayList<Player>();

    /**
     * Adds the player to a team
     * @param player
     */
    public void addToTeam(Player player) {
        if (getTeamCount("cops") < getTeamCount("crims")) {
            addPlayerToTeam(player, "cops");
        } else if (getTeamCount("cops") > getTeamCount("crims")) {
            addPlayerToTeam(player, "crims");
        } else if (getTeamCount("cops") == getTeamCount("crims")) {
            int rand = getRandomNumberRange(0, 1);

            if (rand == 0)
                addPlayerToTeam(player, "cops");
            else
                addPlayerToTeam(player, "crims");
        }
    }

    /**
     * Add the player to the given team
     * @param player
     */
    public void addPlayerToTeam(Player player, String team) {
        player.sendMessage("You have been added to team " + ChatColor.BLUE + team);
    }

    /**
     * Returns the team's size.
     * @param team
     * @return
     */
    public int getTeamCount(String team) {
        if (team == "cops") {
            return teamCops.size();
        } else if (team == "crims") {
            return teamCrims.size();
        } else {
            return 0;
        }
    }
}

