package smcs.battis.tankwars;

import java.awt.*;
import java.io.*;
import java.util.*;

import objectdraw.*;

/**
 * Model a bullet that follows a parabolic trajectory
 * 
 * Modified in Phase 4 to animate one pixel at a time.
 * 
 * @author sethbattis
 *
 */
public class Bullet implements Serializable {

    public static final double GRAVITY = -9.8; // m/s^2
    public static final long DELAY = 100; // milliseconds

    private Location center, previousCenter, nextCenter;
    private double velocityX, velocityY;
    private Color color;

    private Vector<BulletListener> listeners;

    public Bullet(Location center, double angle, double power, Color color) {
	super();

	this.center = center;
	this.color = color;

	// bullet is not yet in motion
	previousCenter = null;
	nextCenter = center;

	velocityX = power * Math.cos(angle);
	velocityY = power * Math.sin(angle);

	// instantiate listeners
	listeners = new Vector<BulletListener>();
    }

    public void addBulletListener(BulletListener listener) {
	listeners.add(listener);
    }

    /**
     * Calculates the next step of the bullet along its trajectory
     * 
     * @return A list of SolidObjects hit by the bullet after this move
     */
    public Vector<SolidObject> move() {

	/* when we start moving, tell listeners we were fired */
	if (previousCenter == null) {
	    for (BulletListener listener : listeners) {
		listener.onBulletFired();
	    }
	}

	/*
	 * if we're "essentially" at the nextCenter, re-calculate next segment
	 */
	if (Math.sqrt(
		Math.pow(center.getX() - nextCenter.getX(), 2) + Math.pow(center.getY() - nextCenter.getY(), 2)) < 1) {
	    /* store current position */
	    previousCenter = center;

	    /* calculate new position */
	    velocityY -= GRAVITY;
	    nextCenter = new Location(center.getX() - velocityX, center.getY() + velocityY);
	}

	/*
	 * walk along the line between two parabolic points, one pixel at a time
	 */
	double slope = (previousCenter.getY() - nextCenter.getY()) / (previousCenter.getX() - nextCenter.getX());
	if (Math.abs(slope) <= 1) {
	    int increment = (nextCenter.getX() > previousCenter.getX() ? 1 : -1);
	    center = new Location(center.getX() + increment,
		    slope * (center.getX() + increment - previousCenter.getX()) + previousCenter.getY());
	} else {
	    int increment = (nextCenter.getY() > previousCenter.getY() ? 1 : -1);
	    center = new Location((center.getY() + increment - previousCenter.getY()) / slope + previousCenter.getX(),
		    center.getY() + increment);
	}

	Vector<SolidObject> hits = SolidObject.objectsContaining(center);

	/*
	 * if hits not empty, bullet has landed (tell listeners)
	 * 
	 * FIXME if the bullet continues after impact, the BulletListeners will
	 * be informed of impact multiple times. This _could_ be a bad thing.
	 * (e.g. if the Referee advances the turn multiple times)
	 */
	if (!hits.isEmpty()) {
	    for (BulletListener listener : listeners) {
		listener.onBulletImpact(hits);
	    }
	}

	return hits;
    }

    public Location getCenter() {
	return center;
    }

    public Color getColor() {
	return color;
    }
}
