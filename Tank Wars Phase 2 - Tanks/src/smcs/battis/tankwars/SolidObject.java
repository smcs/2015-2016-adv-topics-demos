package smcs.battis.tankwars;

import objectdraw.*;

/**
 * An object that can be "hit" by other objects (tanks, terrain, etc.)
 * 
 * @author sethbattis
 *
 */
public abstract class SolidObject {

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
}
