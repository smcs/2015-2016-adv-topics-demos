package smcs.demo.Dominos.model;

public class DominosOrder {

	private String address;
	
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	
	public String sendOrder() {
		return address;
	}
	
	public boolean CancelOrder() {
		return true;
	}
}
