/*
 * WaitingList class is responsible for recording information about
 * passengers who are in the waiting list
 */

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
	
	public Passenger moveUpTheWaitingList() {
		return waitingList.removeFirst();
	}
	
	public Passenger removeSpecificPassenger(int index) {
		Passenger removedPassenger = waitingList.remove(index);
		
		return removedPassenger;
	}
	
	public int searchWaitingPassenger(Passenger waitingPassenger) {
		int location = -1;
		
		for(int i = 1; i <= waitingList.size(); i++) {
			if((waitingList.get(i).getPassengerFirstName().equals(waitingPassenger.getPassengerFirstName())
					&& (waitingList.get(i).getPassengerLastName().equals(waitingPassenger.getPassengerLastName())))) {
				location = i;
			}
		}
		
		return location;
	}
	
	public void displayWaitingList() {
		ListIterator<Passenger> iterator = waitingList.listIterator();
		while(iterator.hasNext()) {
			iterator.next().displayName();
			System.out.printf("\n");
		}
	}
}
