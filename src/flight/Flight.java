package flight;
import java.util.*;

import passengerAndAirlineInfo.*;

public interface Flight {
	public String getUserInput(Scanner scanner);
	public Passenger getPassengerInfo(Scanner scanner);
	public int [] getSeatLocation(Scanner scanner);
	public void addPassenger(Scanner scanner);
	public void updateSeatingChart(Scanner scanner);
	public int [] searchPassenger(Scanner scanner);
	public void replacePassenger(Scanner scanner);
	public void changeSeat(Scanner scanner);
	public void displaySeatingChart();
	public void displayMenu();
	public void drivenMenu(Scanner scanner);
}
