package smcs.battis.Example;

import java.awt.*;

import objectdraw.*;

public class SubShape {

	public static final double SIZE = 12, SPACE = 3;

	private FilledRect left, right;
	private LocalOrigin myOrigin;

	public SubShape(double x, double y, DrawingCanvas canvas) {
		left = new FilledRect(x - SIZE - SPACE, y, SIZE, SIZE, canvas);
		left.setColor(Color.GREEN);
		right = new FilledRect(x + SPACE, y, SIZE, SIZE, canvas);
		right.setColor(Color.RED);
		myOrigin = new LocalOrigin(x, y, canvas);
	}

	public void moveTo(double x, double y) {
		myOrigin.moveTo(x, y);
		left.moveTo(x - SIZE - SPACE, y);
		right.moveTo(x + SPACE, y);
	}

	public void moveTo(Location point) {
		moveTo(point.getX(), point.getY());
	}
}
