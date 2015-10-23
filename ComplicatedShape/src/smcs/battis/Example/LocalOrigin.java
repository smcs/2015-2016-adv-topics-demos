package smcs.battis.Example;

import objectdraw.*;
import java.awt.*;

public class LocalOrigin {
	
	public static final double SIZE = 5;
	
	private Line vertical, horizontal;
	
	public LocalOrigin(double x, double y, DrawingCanvas canvas) {
		vertical = new Line(x, y - SIZE / 2, x, y + SIZE / 2, canvas);
		horizontal = new Line(x - SIZE / 2, y, x + SIZE / 2, y, canvas);
	}
	
	public void moveTo(double x, double y) {
		vertical.moveTo(x, y - SIZE / 2);
		horizontal.moveTo(x - SIZE / 2, y);
	}
	
	public void setColor(Color c) {
		vertical.setColor(c);
		horizontal.setColor(c);
	}

}
