package reservation;
import java.util.*;

public class Lab5Driver {
	public static void main (String [] args) {
		Reservation reservation = new Reservation();
		Scanner scanner = new Scanner(System.in);

		reservation.addNewPassenger(reservation, scanner);
		reservation.displaySeatingChart();
		
//		reservation.drivenMenu(reservation, scanner);
		
		scanner.close();
	}
}
