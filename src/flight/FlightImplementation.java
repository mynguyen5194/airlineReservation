package flight;

import java.util.Scanner;

import passengerAndAirlineInfo.*;
import reservation.Reservation;


public abstract class FlightImplementation implements Flight {
	WaitingList waitingList = new WaitingList();
	SeatingChart seatingChart = new SeatingChart(2, 2);
	
	public String getUserInput(Scanner scanner) {
		String input = scanner.next();

		return input;
	}
	
	public Passenger getPassengerInfo(Scanner scanner) {
		
		Passenger newPassenger = new Passenger();
		String firstName, lastName;
		
		System.out.printf("Passenger first name: ");
		firstName = scanner.next();
			
		System.out.printf("\nPassenger last name: ");
		lastName = scanner.next();
				
		newPassenger.setPassengerFirstName(firstName);
		newPassenger.setPassengerLastName(lastName);
		
		return newPassenger;
	}
	
	public int [] getSeatLocation(Scanner scanner) {
		System.out.printf("These seats (_) are still available.\n"
				+ "Enter your seat location\n");
		seatingChart.displaySeatingChart();
		
		int [] coordinate = new int [2];
		
		System.out.printf("\nRow number: ");
		int row = scanner.nextInt();
		System.out.printf("\nColumn number: ");
		int column = scanner.nextInt();
		
		coordinate[0] = row;
		coordinate[1] = column;
		
		return coordinate;
	}
	
	public boolean addPassenger(Passenger newPassenger, int [] seatLocation) {
		boolean isEmpty = false;
		
		isEmpty = seatingChart.isEmptySeat(seatLocation[0], seatLocation[1]);
		
		// If the wanted seat is empty, then set the passenger to the location
		if(isEmpty == true) {
			seatingChart.setPassengerInfo(newPassenger, seatLocation);
			System.out.printf("Success\n");
		}
		
		// If the wanted seat is not empty and the seatingChart is not full
		else if (isEmpty == false && seatingChart.isEmptySeatingChart() == true) {
			System.out.printf("This seat has been reserved\n");
		}
		// In case the seatingChart is full, place newPassenger in the waiting list
		else if(seatingChart.isEmptySeatingChart() == false){
			waitingList.addPassengerToWaitingList(newPassenger);
			System.out.printf("\nWe appologize! All seats have been reserved\n"
					+ "You are now on the waiting list\n");		// SHOULD RETURN THE INDEX IN THE WAITING LIST
		}
		
		return isEmpty;
	}
	
	// This function also move the first passenger in the waiting list to the just-removed passenger seat
	public void removePassenger(Reservation reservation, Scanner scanner) {
		Passenger removedPassenger = new Passenger();
		int [] seatLocation = new int [2];
		
		System.out.printf("Enter the passenger's information you want to remove \n");
		
		removedPassenger = reservation.getPassengerInfo(scanner);
		seatLocation = seatingChart.removePassenger(removedPassenger, waitingList);
		
		if(seatLocation[0] != -1 && seatLocation[1] != -1) {
			Passenger newPassenger = waitingList.moveUpTheWaitingList();
			seatingChart.setPassengerInfo(newPassenger, seatLocation);
		}
	}
	
	public int [] searchPassenger(Reservation reservation, Scanner scanner) {
		int [] location = new int [2];
		Passenger passenger = this.getPassengerInfo(scanner);
		
		location = seatingChart.searchPassenger(passenger);
		
		return location;
	}
	
	public void displaySeatingChart() {
		seatingChart.displaySeatingChart();
	}
}
