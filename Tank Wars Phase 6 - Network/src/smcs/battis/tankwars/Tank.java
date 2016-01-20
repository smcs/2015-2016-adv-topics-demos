package smcs.battis.tankwars;

import objectdraw.*;

/**
 * Represents a tank
 * 
 * @author sethbattis
 *
 */
public class Tank extends SolidObject {
    
    private static int nextId = 1337; // h4x0r for "elite"
    private int id;

    public static final double RADIUS = 10;
    public static final double BARREL_LENGTH = 10; // beyond radius

    public static final double DROP_STEP = 3, // pixel, when placing
	    ANGLE_INCREMENT = Math.PI / 180.0, // rad
	    ANGLE_FLOOR = Math.PI, // rad, <= ANGLE_CEILING
	    ANGLE_CEILING = Math.PI * 2, // rad, >= ANGLE_FLOOR
	    POWER_FLOOR = 0, // <= POWER_CEILING
	    POWER_CEILING = 100, // >= POWER_FLOOR
	    POWER_INCREMENT = (POWER_CEILING - POWER_FLOOR) / 100.0; // arbitrary

    private Location center;
    private double angle, power;

    /**
     * Construct a new tank by dropping it from the start location on to the
     * terrain
     * 
     * @param terrain
     * @param start
     */
    public Tank(Terrain terrain, Location start) {
	super();
	
	id = nextId++;

	angle = (ANGLE_FLOOR + ANGLE_CEILING) / 2;
	power = (POWER_FLOOR + POWER_CEILING) / 2;
	center = start;

	while (!terrain.contains(center)) {
	    center = new Location(center.getX(), center.getY() + DROP_STEP);
	}
    }

    @Override
    public boolean contains(Location point) {
	return Math
		.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2)) <= RADIUS;
    }

    public Location getCenter() {
	return center;
    }

    public double getAngle() {
	return angle;
    }

    public double getPower() {
	return power;
    }

    public void increaseAngle() {
	angle += ANGLE_INCREMENT;
	if (angle > ANGLE_CEILING) {
	    angle = ANGLE_CEILING;
	}
    }

    public void decreaseAngle() {
	angle -= ANGLE_INCREMENT;
	if (angle < ANGLE_FLOOR) {
	    angle = ANGLE_FLOOR;
	}
    }

    public void increasePower() {
	power += POWER_INCREMENT;
	if (power > POWER_CEILING) {
	    power = POWER_CEILING;
	}
    }

    public void decreasePower() {
	power -= POWER_INCREMENT;
	if (power < POWER_FLOOR) {
	    power = POWER_FLOOR;
	}
    }

    public Bullet fire() {
	/*
	 * bullet starts at the end of the barrel to prevent "friendly fire"
	 */
	return new Bullet(new Location(center.getX() - (RADIUS + BARREL_LENGTH) * Math.cos(angle),
		center.getY() + (RADIUS + BARREL_LENGTH) * Math.sin(angle)), angle, power);
    }

    public int getId() {
	return id;
    }
}
