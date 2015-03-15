/*
 * Reservation abstract class is responsible for allowing users to 
 * enter their information, get the seat location, add new passenger
 * to either seating chart or waiting list appropriately, update
 * seating chart, search passenger, replace passenger, change seat,
 * display seating chart, and show the menu options
 */

package flightConfirmation;

import java.io.*;
import java.util.*;

import exceptionHandler.*;
import passengerAndAirlineInfo.*;

public abstract class Reservation implements Flight {
	WaitingList waitingList = new WaitingList();
	SeatingChart seatingChart = new SeatingChart(10, 4);	// 10 rows, 4 columns
	
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
	
	public int [] getSeatLocation(Scanner scanner)  {
		int [] coordinate = new int [2];
		boolean problemFixed = false;
		ProblemGenerator problem = new ProblemGenerator(
				seatingChart.getRowNumber(), seatingChart.getColumnNumber());
		
		do {
			try {
				System.out.printf("These seats (_) are still available.\n"
						+ "Enter your seat location\n");
				seatingChart.displaySeatingChart();
				
				System.out.printf("Row number: ");
				int row = scanner.nextInt();
				System.out.printf("Column number: ");
				int column = scanner.nextInt();
				
				coordinate[0] = row;
				coordinate[1] = column;
				
				problemFixed = problem.isOutOfBounds(row, column);
			}
			catch(IOException err) {
				System.out.printf("Error -- " + err.toString());
			}
			catch (Repair exception) {
				exception.fixProblemReadFromConsole();
			}
			
		} while (problemFixed == true);
		
		return coordinate;
	}
	
	public void addPassenger(Scanner scanner) {
		boolean isEmpty = false;
			
		System.out.printf("\t***Add New Passenger***\n");
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
	}
	
	// This function also move the first passenger in the waiting list to the just-removed passenger seat
	public void updateSeatingChart(Scanner scanner) {
		System.out.printf("\t***Remove Passenger***\n");
		
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
		System.out.printf("\t***Search Passenger***\n");
		
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
		System.out.printf("\t***Replace Passenger***\n");
		
		System.out.printf("Old passenger info\n");
		Passenger oldPassenger = this.getPassengerInfo(scanner);
		
		System.out.printf("New passenger info\n");
		Passenger newPassenger = this.getPassengerInfo(scanner);
		
		if(seatingChart.replacePassenger(oldPassenger, newPassenger) == true) {
			seatingChart.replacePassenger(oldPassenger, newPassenger);
			oldPassenger.displayName();
			System.out.printf("'s seat has been replaced by passenger ");
			newPassenger.displayName();
			System.out.printf("\n");
		}
	}
	
	public void changeSeat(Scanner scanner) {
		System.out.printf("\t***Change Passenger's Seat***\n");
		
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
		System.out.printf("\t***Seating Chart***\n");
		seatingChart.displaySeatingChart();
	}
	
	public void displayMenu() {
		System.out.printf("\t***Menu***\n"
				+ "A: Add new passengers\n"
				+ "F: Find/Search passengers\n"
				+ "R: Replace passengers\n"
				+ "U: Update the seating chart (remove passenger)\n"
				+ "C: Change seat\n"
				+ "D: Display seating chart\n"
				+ "M: Display menu\n"
				+ "S: Serialize the seating chart\n"
				+ "Q: Quit\n");
	}
	
	public void serializeSeatingChart() {
		System.out.printf("\t***Serialize Seating Chart***\n");
		
		try{
			FileOutputStream fileOut = new FileOutputStream("SeatingChart.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(seatingChart);
			
			out.close();
			System.out.printf("The seating chart is saved in SeatingChart.dat\n");	
		}
		catch(Exception i) {
			i.printStackTrace();
		}
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
				
			case "F":
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
				this.replacePassenger(scanner);
				break;
				
			case "U":
				this.updateSeatingChart(scanner);
				break;
				
			case "C":
				this.changeSeat(scanner);
				break;
				
			case "D":
				this.displaySeatingChart();
				break;
			
			case "M":
				this.displayMenu();
				break;
				
			case "S":
				this.serializeSeatingChart();
				break;
				
			default:
				break;
			}	
		} while (!(option.equalsIgnoreCase("Q")));
	}
}
