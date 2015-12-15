package smcs.battis.tankwars;

import objectdraw.*;

/**
 * Represents a tank
 * 
 * @author sethbattis
 *
 */
public class Tank implements SolidObject {

    public static final double DROP_STEP = 3, // pixel, when placing
	    ANGLE_FLOOR = Math.PI, // rad, <= ANGLE_CEILING
	    ANGLE_CEILING = Math.PI * 2, // rad, >= ANGLE_FLOOR
	    ANGLE_INCREMENT = (ANGLE_FLOOR - ANGLE_CEILING) / 180.0, // rad
	    POWER_FLOOR = 0, // <= POWER_CEILING
	    POWER_CEILING = 100, // >= POWER_FLOOR
	    POWER_INCREMENT = (POWER_CEILING - POWER_FLOOR) / 100.0; // arbitrary

    private Location center;
    private double angle, power;

    public Tank(Terrain terrain, Location start) {
	super();
	angle = (ANGLE_FLOOR + ANGLE_CEILING) / 2;
	power = (POWER_FLOOR + POWER_CEILING) / 2;
	center = start;

	while (!terrain.contains(center)) {
	    center = new Location(center.getX(), center.getY() + DROP_STEP);
	}
    }

    @Override
    public boolean contains(Location point) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean contains(double x, double y) {
	// TODO Auto-generated method stub
	return false;
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

    public void fire() {
	System.out.println("Unleash devastation.");
    }
}
