package reservation;
import java.util.*;
import flight.*;

public class Lab5Driver extends Reservation implements Flight{
	public static void main (String [] args) {
		Lab5Driver driver = new Lab5Driver();
		
		Scanner scanner = new Scanner(System.in);

//		driver.addPassenger(scanner);
//		driver.displaySeatingChart();
		driver.drivenMenu(scanner);
		
		scanner.close();
	}
}
