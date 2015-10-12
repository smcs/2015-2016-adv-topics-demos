package smcs.battis.ElapsedTime;

import objectdraw.*;

public class ElapsedTime extends WindowController {
	
	private Text instructions, result;	
	private String encouragement[] = {
			"Keep clicking!",
			"Click again!",
			"Click it one more time!",
			"Click it pro!",
			"Even more clicks!"
	};
	private double firstClick = 3.14159;
	
	public void begin() {
		instructions = new Text ("Click!", 10, 10, canvas);
	}
	
	public void onMouseClick(Location p) {
		if (firstClick == 3.14159) {
			instructions.setText("Click a second time!");
			firstClick = 2.171;
		} else {
			instructions.setText(encouragement[(int) (Math.random() * encouragement.length)]);
		}
	}
}
