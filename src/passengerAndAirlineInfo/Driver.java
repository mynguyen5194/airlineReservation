package passengerAndAirlineInfo;

public class Driver {

	public static void main(String[] args) {
		SeatingChart chart = new SeatingChart(10, 4);
		
		chart.displaySeatingChart();
		
		chart.setPassengerInfo(0, 0, "My", "Nguyen");
		chart.setPassengerInfo(0, 1, "Viet", "Nguyen");
		chart.setPassengerInfo(2, 3, "Hello", "World");
		chart.setPassengerInfo(8, 2, "Yum", "my"); 
		
		chart.displaySeatingChart();
//		chart.getSeatChoiceFromUser();
		
//		int coor[] = new int [2];
//		coor = chart.searchPassenger("Yumm", "my");
//		
//		System.out.printf("row = " + coor[0] + " column = " + coor[1]);


	}

}
