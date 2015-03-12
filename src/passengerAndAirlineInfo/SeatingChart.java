package passengerAndAirlineInfo;

import java.util.*;

public class SeatingChart {
	private int rowNumber;
	private int columnNumber;
	Passenger [][] seatingChart = new Passenger [10][4];	// 10 Rows, 4 Columns
	
	public SeatingChart() {}
	public SeatingChart(int rowNum, int columnNum, Passenger [][] Passenger) {
		rowNumber = rowNum;
		columnNumber = columnNum;
		seatingChart = Passenger;
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
	public Passenger[][] getSeatingChart() {
		return seatingChart;
	}
	public void setSeatingChart(Passenger[][] SeatingChart) {
		this.seatingChart = SeatingChart;
	}
	
	public boolean checkEmptySeat(int rowNum, int columnNum) {
		boolean empty = true;
		
		if(seatingChart[rowNum][columnNum] != null) {	// If the seat is occupied
			empty = false;						// then it's not empty
		}
		
		return empty;
	}
	
	public boolean isEmptySeatingChart() {
		boolean empty = false;
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 4; c ++) {
				if(seatingChart[r][c] == null) {
					empty = true;
				}
			}
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
		boolean found = false;
		int [] coordinate = new int [2];
		
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 4; c++) {
				if(seatingChart[r][c] != null
						&& seatingChart[r][c].getPassengerFirstName().equals(firstName)
						&& seatingChart[r][c].getPassengerLastName().equals(lastName)) {
					coordinate[0] = r;
					coordinate[1] = c;
					found = true;
				}
				else if (found == false) {
					coordinate[0] = -1;
					coordinate[1] = -1;
				}
			}
		}
		return coordinate;
	}
	
	// Remove passenger from the seating chart
	public void cancleFlight(int row, int column) {
		seatingChart[row][column] = null;
			
	}
	
	public void setPassengerInfo(int row, int column, String firstName, String lastName) {
		Passenger newPassenger = new Passenger(firstName, lastName);
		
		if(this.checkEmptySeat(row, column) != false) {		// empty
			seatingChart[row][column] = newPassenger;
		}
	}
	
	public Passenger getPassengerInfo(int row, int column) {
		Passenger newPassenger = new Passenger();
		
		newPassenger.setPassengerFirstName(seatingChart[row][column].getPassengerFirstName());
		newPassenger.setPassengerLastName(seatingChart[row][column].getPassengerLastName());
		
		return newPassenger;
	}
	
	public void updateAvailableSeat(Passenger newPassenger, int [] seatLocation) {
		WaitingList waitingList = new WaitingList();
		
		if(waitingList.isEmptyWaitingList() == false) {
			newPassenger = waitingList.removePassengerFromWL();	// remove the first passenger in the waiting list
			
			// NEED TO GET EMPTY Row and Column
		}
	}
	

}
