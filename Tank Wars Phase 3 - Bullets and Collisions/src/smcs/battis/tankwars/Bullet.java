package smcs.battis.tankwars;

import java.util.*;

import objectdraw.*;

/**
 * Model a bullet that follows a parabolic trajectory
 * 
 * @author sethbattis
 *
 */
public class Bullet {

    public static final double GRAVITY = -9.8; // m/s^2
    public static final long DELAY = 100; // milliseconds

    private Location whereIAmRightNow, whereIWasLastTime;
    private double velocityX, velocityY;

    public Bullet(Location center, double angle, double power) {
	super();

	this.whereIAmRightNow = center;
	whereIWasLastTime = null; // bullet starts with no prior history

	velocityX = power * Math.cos(angle);
	velocityY = power * Math.sin(angle);
    }

    /**
     * Calculates the next step of the bullet along its trajectory
     * 
     * @return A list of SolidObjects hit by the bullet after this move
     */
    public Vector<SolidObject> move() {
	Vector<SolidObject> hits = new Vector<SolidObject>();

	/* calculate new position */
	velocityY -= GRAVITY;
	whereIAmRightNow = new Location(whereIAmRightNow.getX() - velocityX, whereIAmRightNow.getY() + velocityY);

	/* if this isn't the first move, did I hit anything */
	if (whereIWasLastTime != null) {
	    hits = SolidObject.objectsIntersected(whereIWasLastTime, whereIAmRightNow);
	}

	/* make a note of where we are now for next time */
	whereIWasLastTime = whereIAmRightNow;
	return hits;
    }

    public Location getCenter() {
	return whereIAmRightNow;
    }
}
