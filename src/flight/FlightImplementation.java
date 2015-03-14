package flight;

import java.util.Scanner;
import passengerAndAirlineInfo.*;

public abstract class FlightImplementation implements Flight {
	WaitingList waitingList = new WaitingList();
	SeatingChart seatingChart = new SeatingChart(1, 1);
	
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
		
		if(isEmpty == true) {
			seatingChart.setPassengerInfo(newPassenger, seatLocation);
			System.out.printf("Success\n");
		}
		else if (isEmpty == false && seatingChart.isEmptySeatingChart() == true) {
			System.out.printf("This seat has been reserved\n");
		}
		// Once the seatingChart is full, place newPassenger in the waiting list
		else if(seatingChart.isEmptySeatingChart() == false){
			System.out.printf("\nWe appologize! All seats have been reserved\n"
					+ "You are now on the waiting list\n");
			waitingList.addPassengerToWaitingList(newPassenger);
		}
		
		
		return isEmpty;
	}
	
	public void displaySeatingChart() {
		seatingChart.displaySeatingChart();
	}
}
