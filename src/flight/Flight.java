package flight;
import java.util.*;
import passengerAndAirlineInfo.*;

public interface Flight {
	public Passenger getPassengerInfo(Scanner scanner);
	public int [] getSeatLocation(Scanner scanner);
	public boolean addPassenger(Passenger newPassenger, int [] seatLocation);
	public void displaySeatingChart();
	
	
}
