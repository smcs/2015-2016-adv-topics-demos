package smcs.battis.GrowMan;

import objectdraw.*;

public class GrowMan extends WindowController {
	// Amount each body part grow by (should be even)
	private static final int GROW = 2;
	// Initial size of head
	private static final int HEAD_SIZE = 6;
	private static final int LIMB_SIZE = 5; // Initial displacement of ends //
											// of limbs from body, both
											// horizontally and vertically
	private static final int HEAD_START = 50; // x and y coordinate of //
												// initial starting point
	// Coordinates of body parts
	private static final int BODY_X = HEAD_START + HEAD_SIZE / 2;
	private static final int NECK_Y = HEAD_START + HEAD_SIZE;
	private static final int ARMPIT_Y = HEAD_START + 2 * HEAD_SIZE;
	private static final int BODY_END = HEAD_START + 3 * HEAD_SIZE;
	private static final int FEET_Y = BODY_END + LIMB_SIZE;
	private static final int ARMS_Y = ARMPIT_Y - LIMB_SIZE;
	private static final int LEFT_X = BODY_X - LIMB_SIZE;
	private static final int RIGHT_X = BODY_X + LIMB_SIZE;

	// Instance variables
	private FramedOval head;
	private Line body, leftArm, rightArm, leftLeg, rightLeg;

	public void begin() {
		head = new FramedOval(HEAD_START, HEAD_START, HEAD_SIZE, HEAD_SIZE, canvas);
		body = new Line(BODY_X, NECK_Y, BODY_X, BODY_END, canvas);
		leftArm = new Line(BODY_X, ARMPIT_Y, LEFT_X, ARMS_Y, canvas);
	}

	public void onMouseClick(Location clickityclick) {
		double limbSize;
		head.setSize(head.getWidth() + GROW, head.getHeight() + GROW);
		limbSize = (double) LIMB_SIZE / (double) HEAD_SIZE * head.getHeight();
		
		body.move(GROW / 2, GROW);
		body.setEnd(body.getEnd().getX(), HEAD_START + 3 * head.getHeight());
		leftArm.setStart(body.getStart().getX(), HEAD_START + 2 * head.getHeight());
		leftArm.setEnd(
				body.getStart().getX() - limbSize,
				leftArm.getStart().getY() - limbSize);
	}
}











