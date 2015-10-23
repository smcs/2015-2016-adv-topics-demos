package smcs.battis.Example;

import objectdraw.*;

public class Example extends WindowController {

	private ComplicatedShape c;
	
	public void begin() {
		c = new ComplicatedShape(10, 10, canvas);
	}
	
	public void onMouseClick(Location point) {
		c.moveTo(point);
	}
}
