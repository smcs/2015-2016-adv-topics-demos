package smcs.demos.SimonSays;

public class App {
	public static void main(String[] args) {
		SimonSaysServer sss = new SimonSaysServer(1337);
		SimonSaysClient ssc = new SimonSaysClient("localhost", 1337);
	}
}
