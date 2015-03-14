package flight;
import java.util.*;

import passengerAndAirlineInfo.*;
import reservation.Reservation;

public interface Flight {
	public String getUserInput(Scanner scanner);
	public Passenger getPassengerInfo(Scanner scanner);
	public int [] getSeatLocation(Scanner scanner);
	public boolean addPassenger(Passenger newPassenger, int [] seatLocation);
	public void removePassenger(Reservation reservation, Scanner scanner);
	public void displaySeatingChart();
	
	
}
