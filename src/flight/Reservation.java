package flight;

import java.io.*;
import java.util.*;

import passengerAndAirlineInfo.*;

public abstract class Reservation implements Flight {
	WaitingList waitingList = new WaitingList();
	SeatingChart seatingChart = new SeatingChart(1, 2);
	
	public Reservation() {}
	public Reservation(WaitingList wl, SeatingChart sc) {
		waitingList = wl;
		seatingChart = sc;
	}
	
	public WaitingList getWaitingList() {
		return waitingList;
	}
	public void setWaitingList(WaitingList waitingList) {
		this.waitingList = waitingList;
	}
	public SeatingChart getSeatingChart() {
		return seatingChart;
	}
	public void setSeatingChart(SeatingChart seatingChart) {
		this.seatingChart = seatingChart;
	}
	
	public String getUserInput(Scanner scanner) {
		String input = scanner.next();

		return input;
	}
	
	public Passenger getPassengerInfo(Scanner scanner) {
		
		Passenger newPassenger = new Passenger();
		String firstName, lastName;
		
		System.out.printf("Passenger first name: ");
		firstName = scanner.next();
			
		System.out.printf("Passenger last name: ");
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
		
		System.out.printf("Row number: ");
		int row = scanner.nextInt();
		System.out.printf("Column number: ");
		int column = scanner.nextInt();
		
		coordinate[0] = row;
		coordinate[1] = column;
		
		return coordinate;
	}
	
	public void addPassenger(Scanner scanner) {
		try {
			boolean isEmpty = false;
			
			System.out.printf("Enter the information of the passenger \n");
			Passenger newPassenger = this.getPassengerInfo(scanner);
			int [] seatLocation = this.getSeatLocation(scanner);
			
			isEmpty = seatingChart.isEmptySeat(seatLocation[0], seatLocation[1]);
				
			// If the wanted seat is empty, then set the passenger to the location
			if(isEmpty == true) {
				seatingChart.setPassengerInfo(newPassenger, seatLocation);
				System.out.printf("Passenger ");
				newPassenger.displayName();
				System.out.printf(" has been added to the seating chart\n");
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
			
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("seatingChart.txt"));
        	out.writeUTF(newPassenger.getPassengerFirstName());
        	out.close();
		}
		catch(Exception e) {
	          System.out.print("Error: " + e);
	          System.exit(1);
		}

	}
	
	// This function also move the first passenger in the waiting list to the just-removed passenger seat
	public void removePassenger(Scanner scanner) {
		Passenger removedPassenger = new Passenger();
		int [] seatLocation = new int [2];
		
		System.out.printf("Enter the passenger's information you want to remove \n");
		
		removedPassenger = this.getPassengerInfo(scanner);
		seatLocation = seatingChart.removePassenger(removedPassenger, waitingList);
		
		if(seatLocation[0] != -1 && seatLocation[1] != -1 && waitingList.isEmptyWaitingList() == false) {
			Passenger newPassenger = waitingList.moveUpTheWaitingList();
			seatingChart.setPassengerInfo(newPassenger, seatLocation);
			System.out.printf("The first passenger in the waiting list has been successfully moved to the seating chart\n");
		}
	}
	
	public int [] searchPassenger(Scanner scanner) {
		int [] location = new int [2];
		Passenger passenger = this.getPassengerInfo(scanner);
		
		
		
		if(seatingChart.searchPassenger(passenger)[0] != -1
				&& seatingChart.searchPassenger(passenger)[1] != -1) {
			location = seatingChart.searchPassenger(passenger);
		}
		else {
			location[0] = waitingList.searchWaitingPassenger(passenger);
			location[1] = -1;
		}
		
		
		return location;
	}
	
	public void replacePassenger(Scanner scanner) {
		System.out.printf("Old passenger info\n");
		Passenger oldPassenger = this.getPassengerInfo(scanner);
		
		System.out.printf("New passenger info\n");
		Passenger newPassenger = this.getPassengerInfo(scanner);
		
		if(seatingChart.replacePassenger(oldPassenger, newPassenger) == true) {
			oldPassenger.displayName();
			System.out.printf("'s seat has been replaced by passenger \n");
			newPassenger.displayName();
		}
	}
	
	public void updatePassenger(Scanner scanner) {
		boolean isEmpty = false;
		
		System.out.printf("Change passenger to a new seat\n");
		Passenger passenger = this.getPassengerInfo(scanner);
		System.out.printf("New seat location\n");
		int [] newLocation = this.getSeatLocation(scanner);
		
		isEmpty = seatingChart.isEmptySeat(newLocation[0], newLocation[1]); 
		
		if(isEmpty == true) {
			seatingChart.setPassengerInfo(passenger, newLocation);
			System.out.printf("Passenger ");
			passenger.displayName();
			System.out.printf(" has been placed to a new seat\n");
		}
		else {
			System.out.printf("This seat has been reserved\n");
		}
	}
	
	public void displaySeatingChart() {
		seatingChart.displaySeatingChart();
	}
	
	public void displayMenu() {
		System.out.printf("\t Menu\n"
				+ "A: Add new passengers\n"
				+ "S: Search passengers\n"
				+ "R: Remove passengers\n"
				+ "D: Display seating chart\n"
				+ "M: Display menu\n"
				+ "Q: Quit\n");
	}
	
	public void drivenMenu(Scanner scanner) {
		String option;
		this.displayMenu();
		do {
			System.out.printf("Please enter your option: ");
			option = this.getUserInput(scanner).toUpperCase();
			
			switch(option) {
			case "A":
				this.addPassenger(scanner);
				break;
				
			case "S":
				int [] location = new int[2];
				location = this.searchPassenger(scanner);
				
				if(location[0] != -1 && location[1] != -1) {
					System.out.printf("Your seat is at row " + location[0]
							+ ", column " + location[1] + "\n");
				}
				else {
					if(location[0] != -1) {
						System.out.printf("You are number " + location[0]
								+ " on the waiting list\n");
					}
					else {
						System.out.printf("Not found!\n");
					}
				}
				break;
				
			case "R":
				this.removePassenger(scanner);
				break;
				
			case "D":
				this.displaySeatingChart();
				break;
			
			case "M":
				this.displayMenu();
				break;
			default:
				break;
			}	
		} while (!(option.equalsIgnoreCase("QUIT")) || !(option.equalsIgnoreCase("Q")));
	}
}