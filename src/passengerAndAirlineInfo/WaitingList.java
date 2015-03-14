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
	
	public void addPassengerToWaitingList(Passenger newWaitingPassenger) {
		waitingList.addLast(newWaitingPassenger);
	}
	
	public Passenger removePassengerFromWaitingList() {
		return waitingList.removeFirst();
	}
	
	public void displayWaitingList() {
		ListIterator<Passenger> iterator = waitingList.listIterator();
		while(iterator.hasNext()) {
			iterator.next().displayName();
			System.out.printf("\n");
		}
	}
}
