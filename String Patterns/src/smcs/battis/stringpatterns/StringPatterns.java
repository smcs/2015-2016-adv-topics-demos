package smcs.battis.stringpatterns;

public class StringPatterns {

	/**
	 * Prints a line of n stars
	 * @param n The number of stars to print
	 */
	public static void lineOfStars(int n) {
		/* a for loop does things repetitively with a counter */
		for (
				int i = 0; // my counter is named and starts at 0
				i < n; // continue until i >= n
				i++ // add 1 to i every time through the loop
			) {
			System.out.print("* ");
		}
		System.out.println();
	}

	/**
	 * Print a diagonal line of stars
	 * @param n How many stars to print
	 */
	public static void diagonalLineOfStars(int n) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < j; k++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}
	
	/**
	 * Print a flag of stars:
	 * 
	 *     * * * * *
	 *      * * * *
	 *     * * * * *
	 *      * * * *
	 *      
	 * @param width Width of the flag
	 * @param height Height of the flag
	 */
	public static void flag(int width, int height) {
		for (int h = 0; h < height; h++) {
			if (h % 2 == 0) {
				lineOfStars(width);
			} else {
				System.out.print(' ');
				lineOfStars(width - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		//lineOfStars(10);
		//diagonalLineOfStars(10);
		flag(20,13);
		System.out.println("All done.");
	}

}
