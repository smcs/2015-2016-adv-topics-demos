package smcs.battis.ContainsAClick;

import java.awt.Color;

import objectdraw.*;

public class ContainsAClick extends WindowController {

	private ToggleOval oval;
	
	public void begin() {
		oval = new ToggleOval(10, 10, 100, 100, canvas);
		oval.toggle();
	}
	
	public void onMouseClick(Location point) {
		if (oval.contains(point)) {
			oval.toggle();
		}
	}
}
