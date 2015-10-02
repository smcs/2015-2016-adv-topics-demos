package smcs.battis.classinstancelocal;

public class ClassInstanceLocal {

	public static void main(String[] args) {
		ExampleObject a, b;
		a = new ExampleObject();
		b = new ExampleObject();
		
		a.printMe();
		b.printMe();
		
		a.printMe();
		b.printMe();		
	}

}
