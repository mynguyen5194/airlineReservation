package flightConfirmation;

import java.util.*;
import flight.*;
import passengerAndAirlineInfo.Passenger;

public class Lab5Driver extends FlightImplementation implements Flight {
	public static void main (String [] args) {
		
		Lab5Driver driver = new Lab5Driver();
		Scanner scanner = new Scanner(System.in);
		Passenger newPassenger = new Passenger();
		int [] seatLocation = new int [2];
		
		seatLocation = driver.getSeatLocation(scanner);
		newPassenger = driver.getPassengerInfo(scanner);
		
		newPassenger.displayName();
		
		driver.addPassenger(newPassenger, seatLocation);
		driver.displaySeatingChart();
		
		seatLocation = driver.getSeatLocation(scanner);
		newPassenger = driver.getPassengerInfo(scanner);
		newPassenger.displayName();
		
		driver.addPassenger(newPassenger, seatLocation);

		

	}
}
