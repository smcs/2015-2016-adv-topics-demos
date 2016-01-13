package smcs.battis.tankwars;

import java.util.*;

/**
 * Enforce the rules in a game of tank wars (only one players fires at a time,
 * players rotate through turns, the game is over when only one player is left)
 * 
 * @author sethbattis
 *
 */
public class Referee implements BulletListener {

    /**
     * The queue of players
     */
    private LinkedList<Tank> players;

    /**
     * The currently active player
     */
    private Tank activePlayer;

    /**
     * Construct a new Referee
     */
    public Referee() {
	players = new LinkedList<Tank>();
    }

    /**
     * Add a player to the (refereed) game
     * 
     * @param player
     */
    public void addPlayer(Tank player) {
	players.add(player);
    }

    /**
     * Remove a player from the game (as when hit by another tank)
     * 
     * @param player
     * @return true if the player was in the game (and is now removed) or false
     *         if the player was not in the game
     */
    private boolean removePlayer(Tank player) {
	if (!players.remove(player)) {
	    if (player == activePlayer) {
		activePlayer = null;
	    } else {
		return false;
	    }
	}
	return true;
    }

    /**
     * Remove a list of tanks from the player list
     * 
     * @param hits
     */
    private void removePlayers(Vector<SolidObject> hits) {
	for (SolidObject hit : hits) {
	    if (hit.getClass() == Tank.class) {
		removePlayer((Tank) hit);
	    }
	}
    }

    /**
     * Advance to the next player's turn
     */
    public void nextTurn(Vector<SolidObject> hits) {
	removePlayers(hits);
	if (activePlayer != null) {
	    players.add(activePlayer);
	}
	activePlayer = players.remove();
    }

    /**
     * Is the game over?
     * 
     * @return
     */
    public boolean gameOver() {
	return (players.size() + (activePlayer == null ? 0 : 1)) == 1;
    }

    /**
     * Who won the game?
     * 
     * @return
     */
    public Tank winner() {
	if (gameOver()) {
	    if (activePlayer != null) {
		return activePlayer;
	    } else {
		return players.getFirst();
	    }
	}
	return null;
    }

    /**
     * Which player is currently active
     * 
     * @return null if no player is currently active (as at the start of the
     *         game)
     */
    public Tank activePlayer() {
	return activePlayer;
    }

    /**
     * Disable the active player so no one can shoot!
     */
    public void disableActivePlayer() {
	if (activePlayer != null) {
	    players.add(activePlayer);
	    activePlayer = null;
	}
    }

    @Override
    public void onBulletFired() {
	disableActivePlayer();
    }

    @Override
    public void onBulletImpact(Vector<SolidObject> hits) {
	nextTurn(hits);
    }

    /**
     * Start the game!
     */
    public void beginGame() {
	if (activePlayer == null) {
	    activePlayer = players.remove();
	}
    }
}
