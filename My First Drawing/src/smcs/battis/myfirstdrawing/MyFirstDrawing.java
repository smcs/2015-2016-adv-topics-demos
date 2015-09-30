package smcs.battis.myfirstdrawing;

import objectdraw.*;

public class MyFirstDrawing extends WindowController {
	
	public void begin() {
		new FilledRect(20, 40, 100, 50, canvas);
	}
	
	public void onMouseClick(Location rhubarb) {
		new FilledOval(rhubarb, 20, 20, canvas);
	}

}
