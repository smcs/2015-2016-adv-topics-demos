package smcs.demos.SimonSays;

/**
 * Main class, to start the server. Defaults to port 1337, unless a different
 * port is specified as the first argument to the main method.
 * 
 * @author sethbattis
 *
 */
public class App {

	/**
	 * Start the server.
	 * 
	 * @param args
	 *            args[0] may specify a port number
	 */
	public static void main(String[] args) {
		int port = 1337;
		if (args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		new SimonSaysServer(port);
	}
}
