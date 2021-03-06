package smcs.battis.helloworld;

/* public/protected/private -- public means everyone can see this class */
/* a class describes a type of object */
public class HelloWorld {

	/*
	 * public -- everyone can see this method
	 * 
	 * static -- this is something that every instances of this object shares,
	 * so if one instance changes it, it is changed for all instances
	 * 
	 * void --- nothingness, in this case meaning that the return type of this
	 * method is "nothing" -- it doesn't return anything
	 * 
	 * main -- name of the method that is called by the JVM to start our
	 * application
	 * 
	 * String[] args -- parameter list (in this case an array of Strings that we
	 * will refer to as args)
	 */
	public static void main(String[] args) { // start code block

		/* method body */

		/*
		 * primitive types (int, char, float, double, boolean) are built into
		 * the language
		 */
		char c = 'a'; // 'a' is a character literal
		int i = 17; // 17 is an integer literal
		boolean b = false; // false is a boolean literal

		/* A String, however, is not primitive. A String is an object. */
		String s = "this is a string literal";

		/*
		 * static reference to the System class, to its static member variable
		 * out, and thence to out's method println -- with the parameter
		 * "Hello World!"
		 */
		System.out.println("Hello World!");

	} // end code block

}
