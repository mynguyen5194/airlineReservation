package flightConfirmation;

import flight.*;

public class FlightConfirmation extends FlightImplementation implements Flight {
	private FlightConfirmation flight;
	
	public FlightConfirmation() {
		flight = new FlightConfirmation();
	}

	public FlightConfirmation getFlight() {
		return flight;
	}

	public void setFlight(FlightConfirmation flight) {
		this.flight = flight;
	}
	
	
	
}
