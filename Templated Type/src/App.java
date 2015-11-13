
public class App {

	public static void main(String[] args) {
		TemplatedTypeExample<String> sExample = new TemplatedTypeExample<String>("Foobar");
		TemplatedTypeExample<Integer> iExample = new TemplatedTypeExample<Integer>(42);
		
		System.out.println(sExample.getIt());
		System.out.println(iExample.getIt());
	}

}
