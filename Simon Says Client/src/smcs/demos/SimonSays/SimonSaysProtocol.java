package smcs.demos.SimonSays;

/**
 * Minimal network protocol -- so minimal as to be fundamentally unnecessary,
 * but perhaps convenient for clients to implement.
 * 
 * @author sethbattis
 *
 */
public interface SimonSaysProtocol {

	/**
	 * The magic words that the user must use to get a desired response from the
	 * server
	 */
	public static final String MAGIC_WORD = "Simon says ";

	/**
	 * The command that ends the connection (if the magic words are used)
	 */
	public static final String EXIT = "bye";

}
