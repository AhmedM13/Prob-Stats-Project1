import java.util.Random;

/**
 * 
 * @author Ahmed Malik
 * Simulates the Monty Hall Problem to prove that
 * the player has a 2/3 chance of winning if they switch doors
 *
 */

public class DoorGame 
{
    private int simulations = 10000; //Number of simulations
    private Random random = new Random();
    
     
    /**
     * Simulates the probability of the player winning if they decide to stay with their initial choice
     * 
     * @return The percentage of times the players wins when staying with their initial choice
     */
    public double stayPercentage()
    {
        int stayWins = 0;

        for (int i = 0; i < simulations; i++)
        {
            int prizeDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);

            if (playerChoice == prizeDoor)
            {
                stayWins++;
            }
        }
        return (double) stayWins / simulations * 100;
    }

    /**
     * Simulates the probability of the player winning if they decide to switch their initial choice
     * 
     * @return The percentage of times the player wins when they switch their choice
     */
    public double switchPercentage()
    {
        int switchWins = 0;

        for (int i = 0; i < simulations; i++)
        {
            int prizeDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);


            if (playerChoice != prizeDoor)
            {
                switchWins++;
            }
        }
        return (double) switchWins / simulations * 100;
    }
}

