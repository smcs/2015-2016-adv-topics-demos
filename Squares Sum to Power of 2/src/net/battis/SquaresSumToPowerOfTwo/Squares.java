package net.battis.SquaresSumToPowerOfTwo;

public class Squares {

	public static void squares(int n) {
		String squares = "";
		for (int i = 1; i < Math.sqrt(n); i++) {
			double j = Math.sqrt(n - Math.pow(i, 2));
			if (Math.floor(j) == j) {
				System.out.println(i + "^2 + " + (int) j + "^2 = " + n);
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.println("2^" + i);
			squares((int) Math.pow(2, i));
			System.out.println();
		}
	}

}
