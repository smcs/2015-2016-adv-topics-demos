package smcs.battis.RandomBox;

import objectdraw.*;

public class RandomBox extends WindowController {
	
	private FilledRect rect;
	
	public void begin() {
		// start with random rectangle
		rect = new FilledRect(10, 10, 20, 20, canvas);
	}
	
	public void onMouseEnter(Location p) {
		// new rectangle
		if (rect.getCanvas() != null) {
			// destroy
		}
		
		// recreate
	}
	
	public void onMouseExit(Location p) {
		// hide rectangle
		rect.removeFromCanvas();
	}
	
	public void onMouseClick(Location p) {
		// show information
	}
}
