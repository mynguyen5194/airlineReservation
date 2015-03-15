/*
 * Name: My Nguyen
 * Course: CIS 35A - 61Y
 * Assignment: #5
 * Project: #1
 * Due date: 03/15/2015
 * Data submitted: 03/15/2015
 * 
 * This program works as a reservation system for an airline flight.
 * Assume the airplane has 10 rows with 4 seats in each row. Use a two dimensional 
 * array of strings to maintain a seating chart. In addition create a array to be 
 * used as a waiting list in case the plane is full. The waiting list should be 
 * "first come first serve" that is people who are added early in the list get the 
 * priority over those who are added later. Allow the user to do the following options 
 *
 * A: Add new passengers
 * S: Search passengers
 * R: Replace passengers
 * U: Update the seating chart
 * C: Change seat
 * D: Display seating chart
 * M: Display menu
 * Q: Quit
 * 
 */


package flightConfirmation;
import java.util.*;
import flight.*;

public class Lab5Driver extends Reservation implements Flight{
	public static void main (String [] args) {
		Lab5Driver driver = new Lab5Driver();
		
		Scanner scanner = new Scanner(System.in);

		driver.drivenMenu(scanner);
		
		scanner.close();
	}
}
