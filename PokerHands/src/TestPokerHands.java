import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author Ahmed Malik
 * Used to test Monte Carlo Simulator
 * Test Class sets the number of hands and the hand size
 * It iterates over 10,000 hands, and finds the probability of each type of hand appearing in the list of hands
 */
public class TestPokerHands {
	public static void main(String[] args) {
		HandEvaluator evaluator = new HandEvaluator();

        // Deal 10,000 hands and count each unique hand
        int numberOfHands = 10000;
        int handSize = 5; // You can change this to 7 for hold 'em
        
        //Counters to help find probability
        int countPairs = 0;
        int countThreeOfAKind = 0;
        int countFourOfAKind = 0;
        int countStraights = 0;
        int countFlushs = 0;
        int countFullHouses = 0;
        int countStraightFlushes = 0;
        int countRoyalFlushes = 0;
        
        //Simulates 10,000 hands
        for (int i = 0; i < numberOfHands; i++) {
            evaluator.drawHand(handSize);
            
            //Evaluates each hand for their hand type
            if (evaluator.isPair()) countPairs++;
            if (evaluator.isThreeOfAKind()) countThreeOfAKind++;
            if (evaluator.isFourOfAKind()) countFourOfAKind++;
            if (evaluator.isStraight()) countStraights++;
            if (evaluator.isFlush()) countFlushs++;
            if (evaluator.isFullHouse()) countFullHouses++;
            if (evaluator.isStraightFlush()) countStraightFlushes++;
            if (evaluator.isRoyalFlush()) countRoyalFlushes++;

            //Resets the deck for the next hand
            evaluator.resetDeck();
        }
        
        //Calculating the probability for each hand type
        double pairProbability = (double) countPairs/numberOfHands;
        double threeKindProbability = (double) countThreeOfAKind/numberOfHands;
        double fourKindProbability = (double) countFourOfAKind/numberOfHands;
        double straightProbability = (double) countStraights/numberOfHands;
        double flushProbability = (double) countFlushs/numberOfHands;
        double fullHouseProbability = (double) countFullHouses/numberOfHands;
        double straightFlushProbability = (double) countStraightFlushes/numberOfHands;
        double royalFlushProbability = (double) countRoyalFlushes/numberOfHands;
               
        //Writing results to excel
        try (FileWriter writer = new FileWriter("poker_results.csv")) {
        	writer.append("Hand Type,Count,Probability\n");
            writer.append("Pairs,").append(String.valueOf(countPairs)).append(",").append(String.valueOf(pairProbability)).append("\n");
            writer.append("Three of a Kind,").append(String.valueOf(countThreeOfAKind)).append(",").append(String.valueOf(threeKindProbability)).append("\n");
            writer.append("Four of a Kind,").append(String.valueOf(countFourOfAKind)).append(",").append(String.valueOf(fourKindProbability)).append("\n");
            writer.append("Straights,").append(String.valueOf(countStraights)).append(",").append(String.valueOf(straightProbability)).append("\n");
            writer.append("Flushs,").append(String.valueOf(countFlushs)).append(",").append(String.valueOf(flushProbability)).append("\n");
            writer.append("Full Houses,").append(String.valueOf(countFullHouses)).append(",").append(String.valueOf(fullHouseProbability)).append("\n");
            writer.append("Straight Flushes,").append(String.valueOf(countStraightFlushes)).append(",").append(String.valueOf(straightFlushProbability)).append("\n");
            writer.append("Royal Flushes,").append(String.valueOf(countRoyalFlushes)).append(",").append(String.valueOf(royalFlushProbability)).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
