package flight;

import passengerAndAirlineInfo.*;

public interface Flight {
	public Passenger getPassengerInfo();
	public int [] getSeatLocation();
	public boolean addPassenger(Passenger newPassenger, SeatingChart seatingChart);
	
	
	
	public void getSeatChoiceFromUser();
}
