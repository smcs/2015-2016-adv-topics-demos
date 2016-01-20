package smcs.battis.tankwars.network;

import smcs.battis.tankwars.*;

/**
 * Enforce rules locally, based on updates via the network from a server Referee
 * 
 * @author sethbattis
 *
 */
public class LocalReferee extends Referee {

    public boolean removePlayer(int tankId) {

	/* walk through the list, checking for the id */
	for (Tank player : players) {
	    if (player.getId() == tankId) {
		players.remove(player);
		return true;
	    }
	}

	/* check if the active player matches the id */
	if (activePlayer.getId() == tankId) {
	    activePlayer = null;
	    return true;
	}

	return false;
    }
}
