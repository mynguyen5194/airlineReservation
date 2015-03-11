package passengerAndAirlineInfo;

public class Passenger {
	private String passengerFirstName;
	private String passengerLastName;
	
	public Passenger() {}
	public Passenger(String firstName, String lastName) {
		passengerFirstName = firstName;
		passengerLastName = lastName;
	}
	
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	
	public Passenger getName() {
		Passenger newPassenger = new Passenger();
		
		newPassenger.setPassengerFirstName(passengerFirstName);
		newPassenger.setPassengerLastName(passengerLastName);
		
		return newPassenger;
	}
	
	public void displayName() {
		StringBuffer str = new StringBuffer(" ");
		
		str.append(this.getPassengerFirstName() + " ");
		str.append(this.getPassengerLastName());
		
		System.out.printf(" " + str + " ");
	}

}
