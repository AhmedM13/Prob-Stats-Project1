import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Ahmed Malik
 * Evaluates each type of Poker Hand
 */

public class HandEvaluator {
    ArrayList<Card> hand;
    ArrayList<Card> deck;
    
    /**
     * Constructor for Hand Evaluator, starts with an empty hand and a full deck of 52 cards
     */
    public HandEvaluator() 
    {
        hand = new ArrayList<>();
        deck = new ArrayList<>();
        populateDeck();
    }
    
    
    /**
     * Populates deck with 52 playing cards
     * Iterates over each suit and for each suit, it iterates over each value, 
     * creating a card for every combination
     */
    private void populateDeck() 
    {
        for (String suit : Card.SUITS) 
        {
            for (String value : Card.VALUES) 
            {
                deck.add(new Card(suit, value));
            }
        }
    }
    
    
    /**
     * Draws a card from the deck and adds it to the hand
     */
    public void drawCard() 
    {
        if (deck.isEmpty()) 
        {
            System.out.println("Deck is empty!");
            return;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(deck.size());
        Card drawnCard = deck.get(randomIndex);
        hand.add(drawnCard);
        deck.remove(randomIndex);
    }
    
    
    /**
     * Draws a hand, with a configurable handsize
     * @param handSize The number of cards that the player wants to draw
     */
    public void drawHand(int handSize) 
    {
    	hand.clear();
        for (int i = 0; i < handSize; i++) 
        {
            drawCard();
        }
    }
    
    
    /**
     * Resets deck back to 52 cards
     */
    public void resetDeck()
    {
        deck.clear();
        populateDeck();
    }
    
    
    /**
     * For Testing purposes only, I used this method to see if the printed hands were correct
     * Took it out of the test class because I did not need to print the hands to the terminal
     * @param handSize number of cards in a hand
     * @param numberOfHands number of total hands to deal
     */
    public void dealHands(int handSize, int numberOfHands) 
    {
        for (int i = 0; i < numberOfHands; i++) 
        {
            drawHand(handSize);
            System.out.println(hand); // Print each hand
            resetDeck();
        }
    }
    
    
    /**
     * Checks to see if the hand is a pair (Exactly 2 of the cards have the same value)
     * @return true if the hand contains exactly one pair, false otherwise
     */
    public boolean isPair() 
    {
        int countOfPairs = 0;
        for (int i = 0; i < hand.size(); i++) 
        {
            for (int j = i + 1; j < hand.size(); j++) 
            {
            	//if a pair is found, increment the count of pairs
                if (hand.get(i).getValue().equals(hand.get(j).getValue())) 
                {
                	countOfPairs++;
                    if (countOfPairs > 1) 
                    {
                        return false; // More than one pair found, it will not longer be a pair
                    }
                }
            }
        }
        return countOfPairs == 1; //If only 1 pair is found, returns true
    }
    
    
    /**
     * Checks to see if the hand is a 3 of a kind (Exactly 3 of the cards have the same value)
     * @return true if the hand contains a 3 of a kind, false otherwise
     */
    public boolean isThreeOfAKind() 
    {
        for (int i = 0; i < hand.size(); i++) 
        {
            int count = 0;
            for (int j = 0; j < hand.size(); j++) 
            {
                if (hand.get(i).getValue().equals(hand.get(j).getValue())) 
                {
                    count++;
                }
            }
            if (count == 3) 
            {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Checks to see if the hand is a 4 of a kind (Exactly 4 of the cards have the same value)
     * @return true if the hand contains a 4 of a kind, false otherwise
     */
    public boolean isFourOfAKind() 
    {
        for (int i = 0; i < hand.size(); i++) 
        {
            int count = 0;
            for (int j = 0; j < hand.size(); j++) 
            {
                if (hand.get(i).getValue().equals(hand.get(j).getValue())) 
                {
                    count++;
                }
            }
            if (count == 4) 
            {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Checks to see if the hand has 5 consecutive cards of any suit
     * @return true if the hand contains a straight, false otherwise
     */
    public boolean isStraight() 
    {
    	/*
    	 * Since the values include Ace(which could be 1 or 14), Jack (11), Queen (12), King(13), 
    	 * We need to assign them numerical values so that we can see which value come in consecutive order
    	 */
        int[] values = new int[15]; // Using 14 to account for both low and high ACE

        // Populate values array
        for (Card card : hand) {
            String value = card.getValue();
            switch (value) 
            {
                case "ACE": values[1]++; values[14]++; break; // ACE can be high or low
                case "TWO": values[2]++; break;
                case "THREE": values[3]++; break;
                case "FOUR": values[4]++; break;
                case "FIVE": values[5]++; break;
                case "SIX": values[6]++; break;
                case "SEVEN": values[7]++; break;
                case "EIGHT": values[8]++; break;
                case "NINE": values[9]++; break;
                case "TEN": values[10]++; break;
                case "JACK": values[11]++; break;
                case "QUEEN": values[12]++; break;
                case "KING": values[13]++; break;
            }
        }

        // Check for consecutive ranks
        int consecutiveCount = 0;
        for (int i = 1; i < values.length; i++) 
        {
            if (values[i] > 0) 
            {
                consecutiveCount++;
                if (consecutiveCount == 5) 
                {
                    return true; //if 5 consecutive cards are found return true
                }
            } else {
                consecutiveCount = 0;
            }
        }

        return false;
    }
    
    
    /**
     * Determines if all of the cards in the hand have the same suit
     * @return true if the hand contains a flush, false otherwise
     */
    public boolean isFlush() 
    {
        String suitOfFirstCard = hand.get(0).getSuit();

        for (Card card : hand) 
        {
            if (!card.getSuit().equals(suitOfFirstCard)) 
            {
                return false;
            }
        }

        return true;
    }
    
    
    /**
     * Determines if the hand has a 3 of a kind and a pair
     * @return true if the hand contains a full house, false otherwise
     */
    public boolean isFullHouse() 
    {
        boolean foundThreeOfAKind = false;
        boolean foundPair = false;

        for (int i = 0; i < hand.size(); i++) 
        {
            int count = 0;
            for (int j = 0; j < hand.size(); j++) 
            {
                if (hand.get(i).getValue().equals(hand.get(j).getValue())) 
                {
                    count++;
                }
            }
            if (count == 3) 
            {
                foundThreeOfAKind = true;
            } else if (count == 2) {
                foundPair = true;
            }
        }

        return foundThreeOfAKind && foundPair;
    }
    
    
    /**
     * Determines if the hand has a straight and a flush
     * @return true if the hand contains a straight flush, false otherwise
     */
    public boolean isStraightFlush() 
    {
        return isStraight() && isFlush();
    }
    
    
    /**
     * Checks if the hand contains a straight flush with the highest valued cards
     * @return true if the hand contains a royal flush, false otherwise
     */
    public boolean isRoyalFlush() 
    {
        if (!isStraightFlush()) 
        {
            return false;
        }
        // Check for the specific values of a royal flush
        ArrayList<String> royalValues = new ArrayList<>(Arrays.asList("ACE", "KING", "QUEEN", "JACK", "TEN"));
        for (Card card : hand) 
        {
            if (!royalValues.contains(card.getValue())) 
            {
                return false;
            }
        }
        return true;
    }

    
}
