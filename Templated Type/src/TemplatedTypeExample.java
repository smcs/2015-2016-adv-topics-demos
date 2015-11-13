
public class TemplatedTypeExample<R> {

	private R myTemplatedTypeThingie;
	
	public TemplatedTypeExample(R thingie) {
		this.myTemplatedTypeThingie = thingie;
	}
	
	public R getIt() {
		return myTemplatedTypeThingie;
	}
}
