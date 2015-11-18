package smcs.demos.SimonSays;

public class App {
	public static void main(String[] args) {
		int port = 1337;
		if (args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		new SimonSaysServer(port);
	}
}
