package reservation;

import java.util.Scanner;

import passengerAndAirlineInfo.Passenger;
import flight.*;

public class Reservation extends FlightImplementation implements Flight {
	public void displayMenu() {
		System.out.printf("\t Menu\n"
				+ "A: Add new passengers\n"
				+ "S: Search passengers\n"
				+ "R: Remove passengers\n"
				+ "D: Display seating chart\n"
				+ "M: Display menu\n"
				+ "Q: Quit\n");
	}
	
	public void addNewPassenger(Reservation reservation, Scanner scanner) {
		Passenger newPassenger = new Passenger();
		int [] seatLocation = new int [2];
		
		System.out.printf("Enter the information of the passenger \n");
		do {
			newPassenger = reservation.getPassengerInfo(scanner);
			seatLocation = reservation.getSeatLocation(scanner);
			
			super.addPassenger(newPassenger, seatLocation);
			System.out.printf("Type in any character to keep adding new passenger or enter 'Exit/exit' to quit adding new passengers\n");
		} while (!super.getUserInput(scanner).equalsIgnoreCase("exit"));
	}
	
	public void removePassenger(Reservation reservation, Scanner scanner) {
		this.removePassenger(reservation, scanner);
	}
	
	public void drivenMenu(Reservation reservation, Scanner scanner) {
		this.displayMenu();
		do {
			System.out.printf("Please enter your option: ");
			String option = super.getUserInput(scanner).toUpperCase();
			
			switch(option) {
			case "A":
				reservation.addNewPassenger(reservation, scanner);
				break;
				
			case "S":
				int [] location = new int[2];
				location = reservation.searchPassenger(reservation, scanner);
				
				if(location[0] != -1 && location[1] != -1) {
					System.out.printf("Your seat is at row " + location[0]
							+ ", column " + location[1] + "\n");
				}
				else {
					System.out.printf("Not found!\n");
				}
				break;
				
			case "R":
				reservation.removePassenger(reservation, scanner);
				break;
				
			case "D":
				reservation.displaySeatingChart();
				break;
			
			case "M":
				reservation.displayMenu();
				break;
			}	
			
		} while ((!super.getUserInput(scanner).equalsIgnoreCase("quit")) ||
				(!super.getUserInput(scanner).equalsIgnoreCase("q")));
	}
	
	public static void main (String [] args) {
		Reservation reservation = new Reservation();
		Scanner scanner = new Scanner(System.in);
		
//		reservation.displayMenu();
//		reservation.addNewPassenger(reservation, scanner);
		reservation.drivenMenu(reservation, scanner);
		
		scanner.close();
	}
}
