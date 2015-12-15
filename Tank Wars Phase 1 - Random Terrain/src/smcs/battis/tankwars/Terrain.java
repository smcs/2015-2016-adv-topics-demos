package smcs.battis.tankwars;

import java.util.*;

import objectdraw.*;

/**
 * Generate a random terrain for Tank Wars
 * 
 * @author sethbattis
 *
 */
public class Terrain {

    public static final double DEFAULT_CEILING = 0.75; // %, 0-1, > floor
    public static final double DEFAULT_FLOOR = 0.1; // %, 0-1, < ceiling
    public static final double DEFAULT_SEGMENT = 5; // > 0, pixels
    public static final double DEFAULT_TURN = Math.PI / 90; // rad, >= 0
    public static final double DEFAULT_UP_LIMIT = Math.PI / 4; // rad;
    public static final double DEFAULT_DOWN_LIMIT = Math.PI / -4; // rad;
    public static final double DEFAULT_BEARING = 0; // rad
    public static final double DEFAULT_WEIGHT = 0;
    public static final int DEFAULT_WEIGHT_STEP = 10;
    public static final double DEFAULT_WEIGHT_SHIFT = 1; // +/-

    private Vector<Location> elevations;

    public Terrain(double width, double height) {
	this(width, height, DEFAULT_CEILING, DEFAULT_FLOOR, DEFAULT_SEGMENT, DEFAULT_TURN, DEFAULT_UP_LIMIT,
		DEFAULT_DOWN_LIMIT, DEFAULT_BEARING, DEFAULT_WEIGHT, DEFAULT_WEIGHT_STEP, DEFAULT_WEIGHT_SHIFT);
    }

    public Terrain(double width, double height, double ceiling, double floor, double segment, double turn,
	    double upLimit, double downLimit, double bearing, double weight, int weightStep, double weightShift) {

	/* convert proportions to coordinates */
	ceiling = height * ceiling;
	floor = height * floor;

	double x = 0, y = Math.random() * (ceiling - floor) + floor;
	int step = 0;
	RandomDoubleGenerator gen = new RandomDoubleGenerator(-weightShift, weightShift);

	elevations = new Vector<Location>();

	while (x < width) {
	    // add current location to elevation list
	    elevations.add(new Location(x, y));
	    
	    // if we're at a weight-adjustment step, adjust the weight
	    if (step % weightStep == 0) {
		weight += gen.nextValue();
	    }
	    step++;

	    // adjust bearing based on the sign of the weight
	    if (weight > 0) {
		bearing += turn;
	    } else if (weight < 0) {
		bearing -= turn;
	    }
	    
	    // adjust bearing to be within vertical limits
	    if (bearing > upLimit) {
		bearing = upLimit;
	    } else if (bearing < downLimit) {
		bearing = downLimit;
	    }
	   
	    // check to make sure our next step is between the floor and ceiling
	    if (y + segment * Math.sin(bearing) > ceiling ||
		y + segment * Math.sin(bearing) < floor) {
		bearing = 0; // Sean notes that setting the bearing to -bearing is cuter
	    }

	    // calculate next position
	    x += segment * Math.cos(bearing);
	    y += segment * Math.sin(bearing);
	}
    }

    public void draw(DrawingCanvas canvas) {
	Location prev = null, next = null;
	for(Iterator<Location> i = elevations.iterator(); i.hasNext(); ) {
	    prev = next;
	    next = i.next();
	    if (prev != null) {
		new Line(prev, next, canvas);
	    }
	}
    }
    
    /* an implementation of draw() that doesn't use an iterator
    public void draw(DrawingCanvas canvas) {
	int prev = -1;
	for (int next = 0; next < elevations.size(); next++) {
	    if (prev >= 0) {
		new Line(elevations.get(prev), elevations.get(next), canvas);
	    }
	    prev = next;
	}
    }
    */
}







