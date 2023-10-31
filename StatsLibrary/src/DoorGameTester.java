/**
 * 
 * @author Ahmed Malik
 * Test class to run simulations
 */
public class DoorGameTester 
{
	public static void main(String[] args) 
	{
		
		DoorGame test = new DoorGame();
		System.out.println("The percentage of times the player wins if they decide to stay is: " + test.stayPercentage());
		
		System.out.println("The percentage of times the player wins if they decide to switch is: " + test.switchPercentage());
		System.out.println("Therefore this proves the Monty Hall Problem");
	}
}
