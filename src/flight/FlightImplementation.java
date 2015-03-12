package flight;

import java.util.*;

import passengerAndAirlineInfo.*;

public abstract class FlightImplementation implements Flight {
	WaitingList waitingList = new WaitingList();
	SeatingChart seatingChart = new SeatingChart();
	
	public Passenger getPassengerInfo() {
		Passenger newPassenger = new Passenger();
		
		Scanner nameScanner = new Scanner(System.in);
		
		System.out.printf("Passenger first name: ");
		String firstName = nameScanner.nextLine();
		System.out.printf("\nPassenger last name: ");
		String lastName = nameScanner.nextLine();
		
		newPassenger.setPassengerFirstName(firstName);
		newPassenger.setPassengerLastName(lastName);
		
		nameScanner.close();
		
		return newPassenger;
	}
	
	public int [] getSeatLocation() {
		int [] coordinate = new int [2];
		
		Scanner coordinateScanner = new Scanner(System.in);
		
		System.out.printf("\nRow number: ");
		int row = coordinateScanner.nextInt();
		System.out.printf("\nColumn number: ");
		int column = coordinateScanner.nextInt();
		
		coordinateScanner.close();
		
		coordinate[0] = row;
		coordinate[1] = column;
		
		return coordinate;
	}
	
	
	
	public boolean addPassenger() {
		boolean success = false;
		
		Passenger newPassenger = this.getPassengerInfo();
		int [] seatLocation = this.getSeatLocation();
		
		// Now have to check if the seatingChart is full
		
		
		
		
		
		return success;
	}
	
	
	public void getSeatChoiceFromUser() { 
		int row, column;
		Scanner intScanner = new Scanner(System.in);
		
		System.out.printf("Please enter the row following by the column of the seat you want: ");
		row = intScanner.nextInt();
		column = intScanner.nextInt();
		
		if(row < 10 || column < 4) {
			if(seatingChart.checkEmptySeat(row, column) != true) {
				System.out.printf("This seat has been reserved\n");
			}
			else {
				Scanner stringScanner = new Scanner(System.in);
				System.out.printf("This seat is currently empty.\n"
						+ "Do you want to check in this seat? ");
				String answer = stringScanner.nextLine();
				
				if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
					System.out.printf("Please enter your first name: ");
					String firstName = stringScanner.nextLine();
					
					System.out.printf("Please enter your last name: ");
					String lastName = stringScanner.nextLine();
					
					seatingChart.setPassengerInfo(row, column, firstName, lastName);
					
					System.out.printf("Success\n");
				}
				else {
					System.out.printf("Thank you!\n");
				}
				stringScanner.close();
			}
		}
		else {
			System.out.printf("Error!\n");
		}
		intScanner.close();
	}
}
