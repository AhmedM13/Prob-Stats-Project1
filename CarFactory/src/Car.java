/**
 * 
 * @author Ahmed Malik
 * Represents a car/vehicle with multiples different attributes 
 */
public class Car {
	public String carType;
	public int Year;
	public String Color;
	public int Miles;
	
	public static String[] colors = {"blue", "red", "pink", "white", "black", "red", "red"}; //Red slightly more popular
	public static String[] cartypes = {"Sedan", "SUV", "Mini Van", "Coupe", "Pick-up", "Sedan"}; //Sedans slightly more popular
	
	/**
	 * Constuctor, constructs a car object with the given attributes cartype, year, color, and miles
	 * @param cartype Type of car
	 * @param year Year that the car was manufactered
	 * @param color Color of the car
	 * @param miles Miles on the odometer 
	 */
	public Car(String cartype, int year, String color, int miles)
	{
		carType = cartype;
		Year = year;
		Color = color;
		Miles = miles;
	}
	
	/**
	 * 
	 * @return A string representation of the car
	 */
	public String toString() 
	{
        return carType + " , " + Year + " , " + Color + " , " + Miles;
    }

}
