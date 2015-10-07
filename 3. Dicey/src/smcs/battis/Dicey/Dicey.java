package smcs.battis.Dicey;

import objectdraw.*;

public class Dicey extends WindowController {

		private Text result;
		private RandomIntGenerator generator;
	
		public void begin() {
			result = new Text("Hello world", 10, 10, canvas);
			
			generator = new RandomIntGenerator(1, 6);
		}
		
		public void onMouseClick(Location click) {
			result.setText(generator.nextValue());
			
			// I want to check conditions in order, and not check anything
			// after I find a true condition...
			if (condition1) {
				// only happens if condition1 is true
			} else if (condition2) {
				// only happens if condition1 is false and condition2 is true
			} else {
				// only happens if both condition1 and condition2 are false
			}
			
			// uncontracted (but syntactically identical) form of above if structure
			if (condition1) {
				
			} else {
				if (condition2) {
					
				} else {
					
				}
			}
		}
}







