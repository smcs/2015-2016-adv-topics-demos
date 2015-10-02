package smcs.battis.classinstancelocal;

public class ExampleObject {
	private int instanceVariable = 1;
	private static int classVariable = 2;

	public void printMe() {
		int localVariable = 3;

		System.out.println(
				"class=" + classVariable +
				" instance=" + instanceVariable +
				" local=" + localVariable
			);
		localVariable++;
		instanceVariable++;
		classVariable++;
	}
}
