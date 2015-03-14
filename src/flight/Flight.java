package flight;
import java.util.*;

import passengerAndAirlineInfo.*;

public interface Flight {
	public String getUserInput(Scanner scanner);
	public Passenger getPassengerInfo(Scanner scanner);
	public int [] getSeatLocation(Scanner scanner);
	public void addPassenger(Scanner scanner);
	public void removePassenger(Scanner scanner);
	public void replacePassenger(Scanner scanner);
	public void updatePassenger(Scanner scanner);
	public void displaySeatingChart();
	
	
}
