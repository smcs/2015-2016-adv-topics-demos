package smcs.battis.ContainsAClick;

import java.awt.*;

import objectdraw.*;

public class ToggleOval extends FilledOval {
	
	private FilledRect toggleSwitch;

	private RandomIntGenerator color = new RandomIntGenerator(0, 255);
	
	public ToggleOval(double x, double y, double width, double height, DrawingCanvas canvas) {
		super(x, y, width, height, canvas);
		toggleSwitch = new FilledRect(x + width, y + height / 2 - 5, 10, 10, canvas);
	}
	
	public void toggle() {
		setColor(new Color(color.nextValue(), color.nextValue(), color.nextValue()));
		toggleSwitch.setColor(new Color(255 - getColor().getRed(), 255 - getColor().getGreen(), 255 - getColor().getBlue()));
	}
	
	public boolean contains(Location point) {
		return toggleSwitch.contains(point);
	}
}
