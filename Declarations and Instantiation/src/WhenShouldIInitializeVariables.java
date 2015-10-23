import objectdraw.*;

public class WhenShouldIInitializeVariables  extends WindowController {
	
	private int josiah;
	private boolean firstClick = true;
	private RandomIntGenerator gen;
	
	public void begin() {
		gen = new RandomIntGenerator(0, 100);
		
		System.out.println(josiah);
	}

	private double randomWidthWithinCanvas() {
		/*
		RandomDoubleGenerator width = new RandomDoubleGenerator(0, canvas.getWidth());
		return width.nextValue();
		*/
		return Math.random() * canvas.getWidth();
	}
	
	public void onMouseMove(Location point) {
		System.out.println(randomWidthWithinCanvas());
	}
	
	public void onMouseClick(Location point) {
		System.out.println(randomWidthWithinCanvas());
	}
}
