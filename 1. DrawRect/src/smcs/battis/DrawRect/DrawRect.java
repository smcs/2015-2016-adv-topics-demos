package smcs.battis.DrawRect;

import objectdraw.*;

/**
 * DrawRect draws a frame rect and drags it around until the mouse is released,
 * when it is turned into a filled rect.
 * 
 * @author Seth Battis <SethBattis@stmarksschool.org>
 */
public class DrawRect extends WindowController {

	private FramedRect currentRectBeingDragged;

	public void onMousePress(Location point) {
		currentRectBeingDragged = new FramedRect(point, 100, 10, canvas);
	}

	public void onMouseDrag(Location point) {
		currentRectBeingDragged.moveTo(point);
	}

	public void onMouseRelease(Location point) {
		new FilledRect(point, currentRectBeingDragged.getWidth(), currentRectBeingDragged.getHeight(), canvas);
		currentRectBeingDragged.removeFromCanvas();
	}
}
