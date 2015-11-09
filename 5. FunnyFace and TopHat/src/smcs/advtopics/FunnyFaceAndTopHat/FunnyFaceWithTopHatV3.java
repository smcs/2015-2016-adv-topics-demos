package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

public class FunnyFaceWithTopHatV3 {
	private FunnyFace ff;
	private TopHat th;

	public void moveTo(Location point) {
		ff.moveTo(point);
		th.moveTo(point);
	}
	
	public boolean contains(Location point) {
		return ff.contains(point) || th.contains(point);
	}
}
