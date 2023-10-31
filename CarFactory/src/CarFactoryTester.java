/**
 * 
 * @author Ahmed Malik
 */
public class CarFactoryTester {
	public static void main(String[] args) {
		 Factory carFactory = new Factory();

	     // Generate cars
	     carFactory.createCars();
	     
	     // Write cars to a CSV file
	     carFactory.writeCarsToFile();

	     // Clear the cars list, so if the program is ran twice, it will start with a new batch of cars, and not add on to the old list
	     //Extra credit?
	     carFactory.clearCars();

	     // Load cars from the CSV file
	     carFactory.readCarsFromFile();
		
	}

}
