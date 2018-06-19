package gq.pixelnetwork.fedsncrims.handlers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class PlayerHandler {
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

    /**
     * Creates a random number in the range
     * @param min
     * @param max
     * @return
     */
    private int getRandomNumberRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("'max' must be greater than 'min'!");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

