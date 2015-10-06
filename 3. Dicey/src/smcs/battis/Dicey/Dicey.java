package smcs.battis.Dicey;

import objectdraw.*;

public class Dicey extends WindowController {

		private Text result;
	
		public void begin() {
			result = new Text("Hello world", 10, 10, canvas);
		}
		
		public void onMouseClick(Location click) {
			result.setText("(" + (int) click.getX() + ", " + (int) click.getY() + ")");
		}
}
