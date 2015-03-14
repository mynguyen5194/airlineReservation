package reservation;

import java.util.Scanner;

import passengerAndAirlineInfo.Passenger;
import flight.*;

public class Reservation extends FlightImplementation implements Flight {
	private Reservation reservation;
	
	public Reservation() {
		reservation = new Reservation();
	}

	public Reservation getFlight() {
		return reservation;
	}

	public void setFlight(Reservation Reservation) {
		this.reservation = Reservation;
	}
	
	public void menu() {
		System.out.printf("\t\t Menu\n"
				+ "A: Add new passengers\n"
				+ "S: Search passengers\n"
				+ "R: Remove passengers\n"
				+ "Q: Quit\n");
	}
	
	public void addNewPassenger() {
		Scanner scanner = new Scanner(System.in);
		Passenger newPassenger = new Passenger();
		int [] seatLocation = new int [2];
		
		System.out.printf("Enter the information or enter 'Exit/exit' to quit adding new passengers\n");
		do {
			newPassenger = reservation.getPassengerInfo(scanner);
			seatLocation = reservation.getSeatLocation(scanner);
			
			super.addPassenger(newPassenger, seatLocation);
		} while (super.getUserInput(scanner).equalsIgnoreCase("exit"));
		
		scanner.close();
	}
	
}
