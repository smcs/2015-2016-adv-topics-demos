package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

/**
 * A quick little game where a funny face chases the mouse around the screen.
 * 
 * @author Seth Battis <SethBattis@stmarksschool.org>
 */
public class Chase extends WindowController {

	/**
	 * The face that will track my mouse
	 */
	private FunnyFaceWithTopHatV2 ff;

	/**
	 * Set up the window
	 */
	public void begin() {
		this.resize(500, 300);

		ff = new FunnyFaceWithTopHatV2(100, 100, canvas);
	}

	/**
	 * Have the face chase the mouse
	 * 
	 * @param point
	 *            Where the mouse clicked
	 */
	public void onMouseMove(Location point) {
		ff.moveTo(point);
	}
}
