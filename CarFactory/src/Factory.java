import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Factory {
	private Random random = new Random();
	private ArrayList<Car> cars = new ArrayList<Car>();
	private final String FILENAME = "cars.csv";
	
	//Generates 1000 cars
	public void createCars() 
	{
        for (int i = 0; i < 1000; i++) 
        {
            String carType = Car.cartypes[random.nextInt(Car.cartypes.length)]; 
            int year = 1973 + random.nextInt(50); //Within 50 years
            String color = Car.colors[random.nextInt(Car.colors.length)];
            int miles = random.nextInt(250001); //Within 250,000 miles

            Car car = new Car(carType, year, color, miles);
            cars.add(car);
        }
    }
	
	
	/**
	 * Writes the list of cars to a CSV file and populates the list
	 */
	public void writeCarsToFile() 
	{
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) 
	    {
	        bw.write("CarType,Year,Color,Miles");  // Header
	        bw.newLine();
	        
	        for (Car car : cars) 
	        {
	            bw.write(car.toString());
	            bw.newLine();
	        }
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	
	/**
	 * Reads cars from a CSV file and populates the list
	 */
	public void readCarsFromFile() 
	{
        cars.clear();  // Clearing the existing cars list
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
        {
            String line;
            br.readLine();  // Skipping the header
            
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(",");
                String carType = parts[0];
                int year = Integer.parseInt(parts[1].trim());
                String color = parts[2];
                int miles = Integer.parseInt(parts[3].trim());

                Car car = new Car(carType, year, color, miles);
                cars.add(car);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	
	/**
	 * Clears list of cars
	 */
	public void clearCars() 
	{
	    cars.clear();
	}
	
}
