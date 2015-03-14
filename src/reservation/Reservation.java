package reservation;

import java.io.*;
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
		try {
			Passenger newPassenger = new Passenger();
			int [] seatLocation = new int [2];
			
			System.out.printf("Enter the information of the passenger \n");
			
			newPassenger = reservation.getPassengerInfo(scanner);
			seatLocation = reservation.getSeatLocation(scanner);
				
			super.addPassenger(newPassenger, seatLocation);
			
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("seatingChart.txt"));
//        	out.writeObject("hello");
        	out.writeUTF(newPassenger.getPassengerFirstName());
        	out.close();
		}
		catch(Exception e) {
	          System.out.print("Error: " + e);
	          System.exit(1);
		}
	}
	
	public void removePassenger(Reservation reservation, Scanner scanner) {
		super.removePassenger(reservation, scanner);
	}
	
	public void drivenMenu(Reservation reservation, Scanner scanner) {
		String option;
		this.displayMenu();
		do {
			System.out.printf("Please enter your option: ");
			option = super.getUserInput(scanner).toUpperCase();
			
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
			default:
				break;
			}	
		} while (!(option.equalsIgnoreCase("QUIT")) || !(option.equalsIgnoreCase("Q")));
	}
}
