import java.util.ArrayList;
/**
 * 
 * @author Ahmed Malik
 * Contains methods to check for shared birthdays and then calculates the probability of shared birthdays
 */

public class Birthdays
{
	/**
	 * Checks the given list to see if anyone shares the same birthday
	 * 
	 * @param people List of people to check birthdays
	 * @return true if at least 2 people share a birthday, false otherwise
	 */
	public boolean birthdayChecker(ArrayList<Person> people)
	{
        for (int i = 0; i < people.size(); i++) 
        {
            for (int j = i + 1; j < people.size(); j++)
            {
                if (people.get(i).getBirthday() == people.get(j).getBirthday())
                {
                    return true;
                }
            }
        }
        return false;
    }
	
	/**
	 * Generates multiples classes of people, and checks for shared birthdays
	 * 
	 * @param classSize Number of people in the class
	 * @param trials Number of simulations to run
	 * @return The percentage of trials where at least 2 people share a birthday
	 */
	public double countBirthdays(int classSize, int trials) 
	{
        double count = 0;
        for (int i = 0; i < trials; i++) 
        {
            ArrayList<Person> people = new ArrayList<>();
            for (int j = 0; j < classSize; j++) 
            {
                people.add(new Person());
            }
            if(birthdayChecker(people)) 
            {
            	count++;
            }
            people.clear(); //Have to clear the class after for the next trial
        }
        return (count / trials) * 100;
    }
	
}
