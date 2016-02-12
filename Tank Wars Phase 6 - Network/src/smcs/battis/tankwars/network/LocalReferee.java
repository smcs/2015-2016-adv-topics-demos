package smcs.battis.tankwars.network;

import smcs.battis.tankwars.*;

// small, trivial modification

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

    public void setActive(int tankId) {
	if (activePlayer != null) {
	    players.add(activePlayer);
	}
	for(Tank player : players) {
	    if (player.getId() == tankId) {
		activePlayer = player;
		players.remove(player);
		return;
	    }
	}
    }

    public Tank getPlayer(int tankId) {
	for (Tank player : players) {
	    if (player.getId() == tankId) {
		return player;
	    }
	}
	return null;
    }
}
