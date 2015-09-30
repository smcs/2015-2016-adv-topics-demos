package smcs.battis.RandomBox;

import objectdraw.*;

public class RandomBox extends WindowController {
	private FilledOval o;
	
	public void begin() {
		double ovalWidth = 96;
		double ovalHeight = 47;
		o = new FilledOval(
				(canvas.getWidth() - ovalWidth) / 2,
				(canvas.getHeight() - ovalHeight) / 2,
				ovalWidth,
				ovalHeight,
				canvas
			);
	}
	
	public void onMouseClick(Location p) {
		o.moveTo(
				(canvas.getWidth() - o.getWidth()) / 2,
				(canvas.getHeight() - o.getHeight()) / 2
			);
	}
}
