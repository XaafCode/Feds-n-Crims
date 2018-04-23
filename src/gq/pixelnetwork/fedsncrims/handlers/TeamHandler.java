package gq.pixelnetwork.fedsncrims.handlers;

import java.util.ArrayList;

import org.bukkit.craftbukkit.libs.jline.internal.Log;

public class TeamHandler {
    // ArrayList keeping track of who's in team Feds
    ArrayList<String> teamFeds = new ArrayList<String>();
    // ArrayList keeping track of who's in team Crims
    ArrayList<String> teamCrims = new ArrayList<String>();
    // ArrayList keeping track of who's in-game
    ArrayList<String> inGame = new ArrayList<String>();

    /**
     * Get specified team as an ArrayList<String>
     * @param 	team    String that specifies what team you want it to return
     * @return          Null or ArrayList of the specified team
     */
    public ArrayList<String> getTeam(String team) {
        if (team != null) {
            if (team == "crims") {
                return teamCrims;
            } else if (team == "feds") {
                return teamFeds;
            } else if (team == "ingame") {
                return inGame;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Returns the team containing the player with the UUID
     * @param   uuid    String that contains the UUID of the player
     * @return          Null or the team containing the UUID
     */
    public String getTeamWithUUID(String uuid) {
        if (uuid != null) {
            if (teamFeds.contains(uuid)) {
                return "feds";
            } else if (teamCrims.contains(uuid)) {
                return "crims";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Checks the amount of players that are currently in-game
     * @return          Amount of players in-game
     */
    public int getInGame() {
        int amount = 0;

        for (int i = 0; i < inGame.size(); i++) {
            amount += 1;
        }

        return amount;
    }

    /**
     * Adds the Player's UUID to the specified team
     * @param   team    Team you want to add the UUID of the player to
     * @param   uuid    UUID of the player you want to add to the team
     */
    public void addUUID(String team, String uuid) {
        if (team != null) {
            if (uuid != null) {
                if (team == "crims") {
                    teamCrims.add(uuid);
                    inGame.add(uuid);
                } else if (team == "feds") {
                    teamFeds.add(uuid);
                    inGame.add(uuid);
                } else {
                    Log.info("Invalid team given! Please use either 'crims' or 'feds'!");
                }
            }
        } else {
            Log.info("No team given for adding a Player to a team!");
        }
    }

    /**
     * Removes a player from their team
     * @param   uuid    UUID of the player you want to remove from their team
     */
    public void removeUUIDFromTeam(String uuid) {
        if (uuid != null) {
            if (getTeamWithUUID(uuid) == "feds") {
                teamFeds.remove(uuid);
                inGame.remove(uuid);
            } else if (getTeamWithUUID(uuid) == "crims") {
                teamCrims.remove(uuid);
                inGame.remove(uuid);
            } else {
                Log.info("Player with UUID " + uuid + " is not in any team!");
            }
        }
    }

    /**
     * Checks if the Player with the provided uuid is in-game
     * @param   uuid    UUID of the player who's being check if they're in-game
     * @return          True or False
     */
    public boolean isInGame(String uuid) {
        if (uuid != null) {
            if (inGame.contains(uuid)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
