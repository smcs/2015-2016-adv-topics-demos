package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

/**
 * This approach to FunnyFace and Tophat extends FunnyFace to include an
 * additional TopHat component
 * 
 * @author sethbattis
 */
public class FunnyFaceWithTopHatV2 extends FunnyFace {
	private static final int HAT_WIDTH = 50, HAT_HEIGHT = 40, HAT_Y_OFFSET = (int) ((FACE_WIDTH / 2) + HAT_HEIGHT),
			HAT_X_OFFSET = HAT_WIDTH / 2;

	private FilledRect hat;

	public FunnyFaceWithTopHatV2(double centerX, double centerY, DrawingCanvas canvas) {

		// this explains the super command
		super(centerX, centerY, canvas);

		// this explains the this.hat assignment
		this.hat = new FilledRect(centerX - HAT_X_OFFSET, centerY - HAT_Y_OFFSET, HAT_WIDTH, HAT_HEIGHT, canvas);
	}

	public void moveTo(double x, double y) {

		// this explains the next few contiguous lines of code
		super.moveTo(x, y);
		System.out.println(x + ", " + y);
	}
}
