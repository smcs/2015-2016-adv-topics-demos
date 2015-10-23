package smcs.battis.Example;

import objectdraw.*;
import java.awt.*;

public class ComplicatedShape {

	public static final double OFFSET = 50;

	private SubShape a, b, c;
	private LocalOrigin myOrigin;

	public ComplicatedShape(double x, double y, DrawingCanvas canvas) {
		a = new SubShape(x, y, canvas);
		b = new SubShape(x + OFFSET, y, canvas);
		c = new SubShape(x, y + OFFSET, canvas);
		myOrigin = new LocalOrigin(x, y, canvas);
		myOrigin.setColor(Color.RED);
	}

	public void moveTo(Location point) {
		myOrigin.moveTo(point.getX(), point.getY());
		a.moveTo(point);
		b.moveTo(point.getX() + OFFSET, point.getY());
		c.moveTo(point.getX(), point.getY() + OFFSET);
	}
}
