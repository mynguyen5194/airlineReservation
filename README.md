# airlineReservation

Airline Reservation 
You must use Object Oriented Programming to design this project. 

Write a reservation system for an airline flight. Assume the airplane has 10 rows with 4 seats in each row. Use a two dimensional array of strings to maintain a seating chart. In addition create a array to be used as a waiting list in case the plane is full. The waiting list should be "first come first serve" that is people who are added early in the list get the priority over those who are added later. Allow the user to add three options 

1. Add a passenger to the list. 
a. Request the passenger's name. 
b. Display a chart of the seats in the airplane in a tabular form 
c. If seats are available let the passenger choose a seat. Add the passenger to the seating chart. 
d. If no seats are available, place the passenger on the waiting list. 

2. Remove a passenger from the list 
a. Request the passengers name 
b. Search the seating chart for the passenger's name and delete it. 
c. If the waiting list is empty, update the array so that the seat is available, 
d. If the waiting list is not empty remove the first person from the list, and give him or her the newly vacated seat. 

3. Quit 

You will need to use string methods defined in java.lang.String in the documentation reference. 
String comparision function names are as follows 
equal, equalIgnoreCase. 
You must use OOP Concepts learnt in the class. (As much as possible.) 

Some help with Lab 5 
-------------------- 
Lab 5 out of the lot will take the longest. You will need to apply most of the concepts learnt in this course including 
1. OOP theory 
2. File IO 
3. Language constructs such as (Looping/Decision Making/Methods etc.) 
4. Swing (Optional) 
5. Interfaces (optional) 
6. Exception Handing (optional) 

How to approach this lab? 
1. Read the lab requirement very carefully. The requirements are provided in the manner a Marketing Department in an organization would provide. 
2. Identify all the entities (object types) that are involved in this lab. 
3. Identify the relationship between each entity. You should identify what properties in a given object would be changed by what methods in a given class. 
4. After this step you are ready to do your design. On a piece of paper draw a large box for each class and document what properties and methods would go in each class. 
5. Identify opportunites for reusability. i.e. as you look at the picture - 
-look at duplication for properties and methods?. 
-Do the relationship make sense? 
-Identify opportunities for using -inheritance/polymorphism. -For e.g. can there be one add/remove method for passenger chart and waiting list. 
-Or can these two methods be overrridden? 
-Do you see any opportunities for using abstract classes? 
These are just some questions to ask. You may consider asking additional question depending on what concepts you may end up applying. For e.g. - Can we serialize some objects to a file to remember program state? etc. 


Once your design is done, you are ready for coding. 

You just write your classes separately and unit test them. 
Unit testing means that you take each class and write a main that has a driver program that exercises the methods giving specific inputs (depending on datatype) and looking for expected outputs. 

Once you write the main for your application - you will automatically end up sequencing the method calls that will dictate the application usage. This setup is called a use case. It may not be a bad idea to think of your use case ahead of time. You can use the top-down design methodology or bottom-up. It your choice. I find the top-down to be more friendly than bottom-up in software engineering. Top-down methology provides me with a big picture and allows me to drill down to specific components. 

After you done coding your application be sure to test it. 


Design proposal for Lab 5:
Classes and their respective properties. 
Method declarations (returntype and parameters to be defined by implementor.)
	
	Flight
		SeatingChart sc;
		WaitingList wl;
		AddPassenger()
		RemovePassenger()		
		
	SeatingChart
		Passenger [] pass = new Passenger[40];
		printSeatingChart()
		getSeatChoicefromUser() //prompts the user to enter which seat they want to occupy.	
		setPassenger()
		getPassenger() //given the location in Seating Chart.
		search()
		removePassenger()
			//delete passenger from seating chart
		reconcileWithWaitingList()
			//If the waiting list is not empty remove the first person from the list, and give him or her the newly vacated seat.
		addPassengerToWaitingList()


	WaitingList
		Passenger [] waitlist = new WaitingList[10];
		printWaitingList()
		setPassenger() //FIFO
		getPassenger()
		
	Passenger
		Instance Variables
		FirstName
		LastName
		getName()
		setFirstName()
		setLastName()
		

Putting it all together

1. Add a passenger to the list.
a. Request the passenger's name.
b. Display a chart of the seats in the airplane in a tabular form
c. If seats are available let the passenger choose a seat. Add the passenger to the seating chart.
d. If no seats are available, place the passenger on the waiting list.

	Flight sw101 = new Flight();

	Psuedocode for AddPassenger()
		String fn = Console.readLine("Enter First Name");
		String ln = Console.readLine("Enter Last Name");
		sw101.sc.printSeatingChart();		
		sw101.sc.getSeatChoicefromUser();			sw101.sc.addPassengerToWaitingList();	

//Follow Java Coding Standards
//Package your code.



//Additional Considerations
	Serialize/Deserialze Flight Object
	Swing Interface is Optional.
	
