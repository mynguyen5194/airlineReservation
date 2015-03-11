package passengerAndAirlineInfo;

import java.util.*;

public class SeatingChart {
	private int rowNumber;
	private int columnNumber;
	Passenger [][] passenger = new Passenger [10][4];	// 10 Rows, 4 Columns
	
	public SeatingChart() {}
	public SeatingChart(int rowNum, int columnNum, Passenger [][] Passenger) {
		rowNumber = rowNum;
		columnNumber = columnNum;
		passenger = Passenger;
	}
	
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public int getColumnNumber() {
		return columnNumber;
	}
	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}
	public Passenger[][] getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger[][] passenger) {
		this.passenger = passenger;
	}
	
	public boolean checkEmptySeat(int rowNum, int columnNum) {
		boolean empty = true;
		
		if(passenger[rowNum][columnNum] != null) {	// If the seat is occupied
			empty = false;						// then it's not empty
		}
		
		return empty;
	}
	
	public void displaySeatingChart() {
		System.out.printf("   0  1  2  3 \n");
		for(int r = 0; r < 10; r++) {
			System.out.printf( r + " ");
			for(int c = 0; c < 4; c++) {
				if(this.checkEmptySeat(r, c) == false) {	// not empty
					System.out.printf(" X ");
				}
				else {
					System.out.printf(" _ ");
				}
			}
			System.out.printf("\n");
		}
	}
	
	public int [] searchPassenger(String firstName, String lastName) {
		
		int [] coordinate = new int [2];
		
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 4; c++) {
				if(passenger[r][c] != null
						&& passenger[r][c].getPassengerFirstName() == firstName
						&& passenger[r][c].getPassengerLastName() == lastName) {
					coordinate[0] = r;
					coordinate[1] = c;
				}
			}
		}
		return coordinate;
	}
	
	// Remove passenger from the seating chart
	public void cancleFlight(int row, int column) {
		passenger[row][column] = null;
			
	}
	
	public void setPassengerInfo(int row, int column, String firstName, String lastName) {
		Passenger newPassenger = new Passenger(firstName, lastName);
		
		if(this.checkEmptySeat(row, column) != false) {		// empty
			passenger[row][column] = newPassenger;
		}
	}
	
	public Passenger getPassengerInfo(int row, int column) {
		Passenger newPassenger = new Passenger();
		
		newPassenger.setPassengerFirstName(passenger[row][column].getPassengerFirstName());
		newPassenger.setPassengerLastName(passenger[row][column].getPassengerLastName());
		
		return newPassenger;
	}
	
	public void getSeatChoiceFromUser() { 
		int row, column;
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Please enter the row following by the column of the seat you want: ");
		row = scanner.nextInt();
		column = scanner.nextInt();
		
		if(row < 10 || column < 4) {
			if(this.checkEmptySeat(row, column) != true) {
				System.out.printf("Not Empty");
			}
			else {
				Scanner stringScanner = new Scanner(System.in);
				System.out.printf("This seat is currently empty\n"
						+ "Do you want to check in this seat? ");
				String answer = stringScanner.nextLine();
				
				if(answer == "Yes" || answer == "YES" || answer == "Y" || answer == "yes" || answer == "y") {
					System.out.printf("\nPlease enter your first name: ");
					String firstName = scanner.nextLine();
					
					System.out.printf("\nPlease enter your last name: ");
					String lastName = scanner.nextLine();
					
					this.setPassengerInfo(row, column, firstName, lastName);
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
		
		
		scanner.close();
	}
	
	public void updateAvailableSeat() {
		WaitingList waitingList = new WaitingList();
		Passenger passenger = new Passenger();
		
		if(waitingList.isEmptyWaitingList() == false) {
			passenger = waitingList.removePassengerFromWL();
			
			
		}
	}
	

}
