import java.util.Random;

/**
 * 
 * @author Ahmed Malik
 * Represents an individual person with a random birthday.
 */
public class Person
{
	private int birthday; //The day of the year the person was born

	/**
	 * Constructor, generates a random birthday for someone
	 */
    public Person() 
    {
        Random random = new Random();
        this.birthday = random.nextInt(365) + 1;  // Days of the year numbered 1 to 365
    }
    
    /**
     * Getter method to get the person's birthday.
     * @return The birthday of the person.
     */
    public int getBirthday() 
    {
        return birthday;
    }
}
