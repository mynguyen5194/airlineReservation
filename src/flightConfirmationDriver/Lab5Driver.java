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


package flightConfirmationDriver;
import java.util.*;

import flightConfirmation.*;

public class Lab5Driver extends Reservation implements Flight{
	public static void main (String [] args) {
		Lab5Driver driver = new Lab5Driver();
		
		Scanner scanner = new Scanner(System.in);

		driver.drivenMenu(scanner);
		
		scanner.close();
	}
}

/*
 * OUTPUT:
 	***Menu***
A: Add new passengers
F: Find/Search passengers
R: Replace passengers
U: Update the seating chart (remove passenger)
C: Change seat
D: Display seating chart
M: Display menu
S: Serialize the seating chart
Q: Quit
Please enter your option: d
	***Seating Chart***
   0  1  2  3 
0  _  _  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Please enter your option: a
	***Add New Passenger***
Passenger first name: My
Passenger last name: Nguyen
These seats (_) are still available.
Enter your seat location
   0  1  2  3 
0  _  _  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Row number: 0
Column number: 1
Passenger  My Nguyen  has been added to the seating chart
Please enter your option: d
	***Seating Chart***
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Please enter your option: a
	***Add New Passenger***
Passenger first name: Hello
Passenger last name: World
These seats (_) are still available.
Enter your seat location
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Row number: 0
Column number: 1
This seat has been reserved
Please enter your option: a
	***Add New Passenger***
Passenger first name: Hello
Passenger last name: World
These seats (_) are still available.
Enter your seat location
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Row number: 4
Column number: 6
These seats (_) are still available.
Enter your seat location
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  _  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Row number: 5
Column number: 1
Passenger  Hello World  has been added to the seating chart
Please enter your option: d
	***Seating Chart***
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  X  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Please enter your option: m
	***Menu***
A: Add new passengers
F: Find/Search passengers
R: Replace passengers
U: Update the seating chart (remove passenger)
C: Change seat
D: Display seating chart
M: Display menu
S: Serialize the seating chart
Q: Quit
Please enter your option: f
	***Search Passenger***
Passenger first name: Hello
Passenger last name: World
Your seat is at row 5, column 1
Please enter your option: r
	***Replace Passenger***
Old passenger info
Passenger first name: Hello
Passenger last name: World
New passenger info
Passenger first name: real
Passenger last name: passenger
 Hello World 's seat has been replaced by passenger  real passenger 
Please enter your option: c
	***Change Passenger's Seat***
Change passenger to a new seat
Passenger first name: real
Passenger last name: passenger
New seat location
These seats (_) are still available.
Enter your seat location
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  _ 
4  _  _  _  _ 
5  _  X  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Row number: 3
Column number: 3
Passenger  real passenger  has been placed to a new seat
Please enter your option: d
	***Seating Chart***
   0  1  2  3 
0  _  X  _  _ 
1  _  _  _  _ 
2  _  _  _  _ 
3  _  _  _  X 
4  _  _  _  _ 
5  _  X  _  _ 
6  _  _  _  _ 
7  _  _  _  _ 
8  _  _  _  _ 
9  _  _  _  _ 
Please enter your option: f
	***Search Passenger***
Passenger first name: Hello
Passenger last name: World
Not found!
Please enter your option: s
	***Serialize Seating Chart***
The seating chart is saved in SeatingChart.dat
Please enter your option: q
 */
