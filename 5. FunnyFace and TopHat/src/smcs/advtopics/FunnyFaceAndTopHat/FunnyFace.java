package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;
import java.awt.*;

/**
 * This approach to FunnyFace and TopHat just edits the original FunnyFace
 * object. (This is the least-recommended approach, although some editing is
 * necessary to change private variables to protected to allow extending
 * subclasses to see those variables.)
 * 
 * @author sethbattis
 *
 */
public class FunnyFace {

	/*
	 * protected means that no one outside this class can access this, but
	 * classes that extend this class DO inherit access to this
	 */
	protected static final double FACE_HEIGHT = 60, // Dimensions of the face
			FACE_WIDTH = 60, EYE_OFFSET = 20, // Eye location and size
			EYE_DIAMETER = 8, MOUTH_WIDTH = FACE_WIDTH / 2, // Dimensions of the
			MOUTH_HEIGHT = 10; // mouth

	/*
	 * private means tht no one outside this class can access this, AND classes
	 * that extend this class DO NOT inherit access to this
	 */
	private FramedOval head, leftEye, rightEye, mouth; // Parts of the face //
														// Create pieces of
														// funny face

	/* public means everyone can access this */
	public FunnyFace(double centerX, double centerY, DrawingCanvas canvas) {
		double hoffset = FACE_WIDTH / 2;
		double voffset = FACE_HEIGHT / 2;
		head = new FramedOval(centerX - hoffset, centerY - voffset, FACE_WIDTH, FACE_HEIGHT, canvas);
		mouth = new FramedOval(centerX - hoffset + (FACE_WIDTH - MOUTH_WIDTH) / 2,
				(centerY - voffset) + 2 * FACE_HEIGHT / 3, MOUTH_WIDTH, MOUTH_HEIGHT, canvas);
		leftEye = new FramedOval(centerX - hoffset + EYE_OFFSET - EYE_DIAMETER / 2, (centerY - voffset) + EYE_OFFSET,
				EYE_DIAMETER, EYE_DIAMETER, canvas);
		rightEye = new FramedOval(centerX - hoffset + FACE_WIDTH - EYE_OFFSET - EYE_DIAMETER / 2,
				(centerY - voffset) + EYE_OFFSET, EYE_DIAMETER, EYE_DIAMETER, canvas);
	}

	// Move funny face by (dx, dy)
	public void move(double dx, double dy) {
		head.move(dx, dy);
		leftEye.move(dx, dy);
		rightEye.move(dx, dy);
		mouth.move(dx, dy);
	}

	public double getX() {
		return head.getX() + (head.getWidth() / 2);
	}

	public double getY() {
		return head.getY() + (head.getHeight() / 2);
	}

	public void moveTo(double x, double y) {
		this.move(x - this.getX(), y - this.getY());
	}

	// Determine whether point is inside funny face
	public boolean contains(Location point) {
		return head.contains(point);
	}

	public void moveTo(Location point) {
		this.moveTo(point.getX(), point.getY());
	}
}
