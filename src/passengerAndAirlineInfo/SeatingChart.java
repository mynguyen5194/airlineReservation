/*
 * SeatingChart class keeps track of the reserved seats on the airplane
 * It also allows users to enter add, remove, or display the booked seats
 */

package passengerAndAirlineInfo;

public class SeatingChart {
	private int rowNumber;
	private int columnNumber;
	Passenger [][] seatingChart;
	
	public SeatingChart() {}
	public SeatingChart(int rowNum, int columnNum) {
		rowNumber = rowNum;
		columnNumber = columnNum;
		seatingChart = new Passenger [rowNumber][columnNumber];
	}
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
	
	public boolean isEmptySeat(int rowNum, int columnNum) {
		boolean isEmpty = true;
		
		if(seatingChart[rowNum][columnNum] != null) {	// If the seat is occupied
			isEmpty = false;						// then it's not empty
		}
		
		return isEmpty;
	}
	
	public boolean isEmptySeatingChart() {
		boolean isEmpty = false;
		for(int r = 0; r < rowNumber; r++) {
			for(int c = 0; c < columnNumber; c ++) {
				if(seatingChart[r][c] == null) {
					isEmpty = true;
				}
			}
		}
		return isEmpty;
	}
	
	public void displaySeatingChart() {
		System.out.printf("  ");
		for(int i = 0; i < columnNumber; i ++) {
			System.out.printf(" " + i + " ");
		}
		System.out.printf("\n");
		
		for(int r = 0; r < rowNumber; r++) {
			System.out.printf( r + " ");
			for(int c = 0; c < columnNumber; c++) {
				if(this.isEmptySeat(r, c) == false) {	// not empty
					System.out.printf(" X ");
				}
				else {
					System.out.printf(" _ ");
				}
			}
			System.out.printf("\n");
		}
	}
	
	public int [] searchPassenger(Passenger passenger) {
		boolean found = false;
		int [] coordinate = new int [2];
		
		for(int r = 0; r < rowNumber; r++) {
			for(int c = 0; c < columnNumber; c++) {
				if(seatingChart[r][c] != null
						&& seatingChart[r][c].getPassengerFirstName().equals(passenger.getPassengerFirstName())
						&& seatingChart[r][c].getPassengerLastName().equals(passenger.getPassengerLastName())) {
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
	public int [] removePassenger(Passenger removedPassenger, WaitingList waitingList) {
		int [] location = this.searchPassenger(removedPassenger);
		
		if(location[0] != -1 && location [1] != -1) {
			seatingChart[location[0]] [location[1]] = null;
			System.out.printf("Passenger " + removedPassenger.getPassengerFirstName() + " "
					+ removedPassenger.getPassengerLastName() + " was removed from the seating chart.\n");
		}
		else {
			int index = waitingList.searchWaitingPassenger(removedPassenger);
			
			if(index != -1) {
				removedPassenger = waitingList.removeSpecificPassenger(index);
				location[0] = -1;
				location[1] = -1;
				System.out.printf("Passenger " + removedPassenger.getPassengerFirstName() + " "
						+ removedPassenger.getPassengerLastName() + " was removed from the waiting list.\n");
			}
			else {
				location[0] = -1;
				location[1] = -1;
				System.out.printf("Passenger " + removedPassenger.getPassengerFirstName() + " "
						+ removedPassenger.getPassengerLastName() + " cannot be found.\n");
			}
		}	
		
		return location;
	}
	
	public boolean setPassengerInfo(Passenger newPassenger, int [] location) {
		boolean successful = false;
		
		if(this.isEmptySeat(location[0], location[1]) == true) {		// if empty
			seatingChart[location[0]][location[1]] = newPassenger;
			successful = true;
		}
		
		return successful;
	}
	
	public Passenger getPassengerInformation(int row, int column) {
		Passenger newPassenger = new Passenger();
		
		newPassenger.setPassengerFirstName(seatingChart[row][column].getPassengerFirstName());
		newPassenger.setPassengerLastName(seatingChart[row][column].getPassengerLastName());
		
		return newPassenger;
	}
	
	public boolean replacePassenger(Passenger oldPassenger, Passenger newPassenger) {
		boolean replaced = false;
		int [] location = new int [2];
		
		location = this.searchPassenger(oldPassenger);
		
		if(location[0] != -1 && location[1] != -1) {
			seatingChart[location[0]][location[1]] = newPassenger;
			replaced = true;
		}
		
		return replaced;
	}
	
	public boolean updatePassenger(Passenger passenger, int [] newLocation) {
		boolean updated = false;
		
		if(this.isEmptySeat(newLocation[0], newLocation[1]) == true) {
			updated = this.setPassengerInfo(passenger, newLocation);
		}
		
		return updated;
	}
}
