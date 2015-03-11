package passengerAndAirlineInfo;

import java.util.*;

public class WaitingList {
	LinkedList<Passenger> waitingList = new LinkedList<Passenger>();
	
	public WaitingList() {}
	public WaitingList(LinkedList<Passenger> WaitingList) {
		waitingList = WaitingList;
	}
	
	public LinkedList<Passenger> getwaitingList() {
		return waitingList;
	}
	public void setwaitingList(LinkedList<Passenger> waitingList) {
		this.waitingList = waitingList;
	}
	
	public boolean isEmptyWaitingList() {
		return waitingList.isEmpty();
	}
	
	public void addPassengerToWL(String firstName, String lastName) {
		// Create new passenger
		Passenger newWaitingPassenger = new Passenger(firstName, lastName);
		
		waitingList.addLast(newWaitingPassenger);
	}
	
	public Passenger removePassengerFromWL() {
		Passenger firstInWaitingListPassenger = new Passenger();
		
		firstInWaitingListPassenger = waitingList.removeFirst();
		
		return firstInWaitingListPassenger;
	}
	
	public void displayWaitingList() {
		ListIterator<Passenger> iterator = waitingList.listIterator();
		while(iterator.hasNext()) {
			iterator.next().displayName();
			System.out.printf("\n");
		}
	}
}
