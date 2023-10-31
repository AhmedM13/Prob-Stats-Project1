/**
 * 
 * @author Ahmed Malik
 * Main runs the simulations and displays the results
 */
public class Main
{
    public static void main(String[] args)
    {
        Birthdays birthday = new Birthdays();

        int classSize = 30;  // Number of people in the class
        int trials = 1000;  // Number of trials to run

        double Probability = birthday.countBirthdays(classSize, trials);
        System.out.println("In a class of " + classSize + " students, the probability of at least two students sharing a birthday is approximately " + Probability + "% after " + trials + " trials.");
    }
}