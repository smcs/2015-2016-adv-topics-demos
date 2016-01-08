package smcs.battis.tankwars;

import java.util.*;

/**
 * Update the referee process based on events in the game (bullet fired ends a
 * player's turn, the bullet landing starts the next player's turn)
 * 
 * @author sethbattis
 *
 */
public class RefereeController implements BulletListener {

    private Referee referee;
    private RefereeView view;

    public RefereeController(Referee referee, RefereeView view) {
	this.referee = referee;
	this.view = view;
    }

    @Override
    public void onBulletFired() {
	// turn off keyboard access for the active player
	view.getCanvas().removeKeyListener(referee.activePlayer());
    }

    @Override
    public void onBulletImpact(Vector<SolidObject> hits) {
	// update the referee's queue from the hits list (in case any tanks are
	// hit)
	// next player's turn
    }
}
