package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

/**
 * Draws a top hat centered at the bottom of the brim (that is, the origin of
 * the hat is the center of the bottom edge of the brim)
 * 
 * @author sethbattis
 *
 */
public class TopHat {

	private static final double BRIM_WIDTH = 100, BRIM_HEIGHT = 20, HAT_WIDTH = 40, HAT_HEIGHT = 50, TOP_HEIGHT = 20;
	
	private FilledOval brim, top;
	private FilledRect body;
	
	public TopHat(double x, double y, DrawingCanvas canvas) {
		
	}
	
	public void moveTo(Location point) {
		
	}
	
	public boolean contains(Location point) {
		return brim.contains(point) || top.contains(point) || body.contains(point);
	}
}
