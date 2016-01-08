package smcs.battis.tankwars;

import java.util.*;

import objectdraw.*;

/**
 * An object that can be "hit" by other objects (tanks, terrain, etc.)
 * 
 * Modified in Phase 4 to allow for the removal of SolidObjects from the
 * environment
 * 
 * @author sethbattis
 *
 */
public abstract class SolidObject {

    /**
     * A list of all SolidObjects present
     */
    protected static Vector<SolidObject> environment;

    /**
     * The default super-constructor must be called to allow for singleton-like
     * maintenance of the list of all SolidObjects
     */
    public SolidObject() {
	if (environment == null) {
	    environment = new Vector<SolidObject>();
	}
	environment.add(this);
    }

    /**
     * Remove a SolidObject from the environment
     * 
     * @return true if SolidObject was removed from the environment, false if it
     *         could not be found
     */
    public boolean remove() {
	return environment.remove(this);
    }

    /**
     * Detects if a point is within the SolidObject
     * 
     * @param point
     * @return true iff the point is contained by the SolidObject, false
     *         otherwise
     */
    public abstract boolean contains(Location point);

    /**
     * Detects if a point is within the SolidObject
     * 
     * @param x
     *            X-coordinate of the point
     * @param y
     *            Y-coordinate of the point
     * @return true iff the point is contained by the SolidObject, false
     *         otherwise
     */
    public final boolean contains(double x, double y) {
	return contains(new Location(x, y));
    }

    /**
     * Does a particular line intersect this object?
     * 
     * @param a
     *            One end of the line
     * @param b
     *            The other end of the line
     * @return true iff the line intersects the SolidObject, false otherwise
     */
    public boolean intersects(Location a, Location b) {
	double slope = (a.getY() - b.getY()) / (a.getX() - b.getX());
	if (Math.abs(slope) <= 1) {
	    for (int x = (int) Math.min(a.getX(), b.getX()); x <= Math.max(a.getX(), b.getX()); x++) {
		if (this.contains(new Location(x, slope * (x - a.getX()) + a.getY()))) {
		    return true;
		}
	    }
	} else {
	    for (int y = (int) Math.min(a.getY(), b.getY()); y <= Math.max(a.getY(), b.getY()); y++) {
		if (this.contains(new Location((y - a.getY()) / slope + a.getX(), y))) {
		    return true;
		}
	    }
	}
	return false;
    }

    /**
     * Get a list of all SolidObjects in the environment that contain a point
     * 
     * @param point
     * @return Potentially empty list of SolidObjects containing by point
     */
    public static Vector<SolidObject> objectsContaining(Location point) {
	Vector<SolidObject> hits = new Vector<SolidObject>();
	for (Iterator<SolidObject> i = environment.iterator(); i.hasNext();) {
	    SolidObject o = i.next();
	    if (o.contains(point)) {
		hits.add(o);
	    }
	}
	return hits;
    }

    /**
     * Get a list of all SolidObjects in the environment intersected by a line
     * 
     * @param a
     *            One end of the line
     * @param b
     *            The other end of the line
     * @return Potentially empty list of SolidObjects intersected by the line
     */
    public static Vector<SolidObject> objectsIntersected(Location a, Location b) {
	Vector<SolidObject> hits = new Vector<SolidObject>();
	for (Iterator<SolidObject> i = environment.iterator(); i.hasNext();) {
	    SolidObject o = i.next();
	    if (o.intersects(a, b)) {
		hits.add(o);
	    }
	}
	return hits;
    }
}
