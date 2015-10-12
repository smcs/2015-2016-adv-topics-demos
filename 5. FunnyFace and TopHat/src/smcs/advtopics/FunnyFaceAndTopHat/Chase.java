package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

public class Chase extends WindowController {
	
	private FunnyFace ff;
	
	public void begin() {
		ff = new FunnyFace(100, 100, canvas);
	}
	
	public void onMouseMove(Location point) {
		// ff.moveTo(point.getX(), point.getY());
		
		ff.moveTo(point);
	}
}
