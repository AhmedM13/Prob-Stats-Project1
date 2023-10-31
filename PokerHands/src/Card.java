/**
 * 
 * @author Ahmed Malik
 */
public class Card {
    private String suit;
    private String value;

    //Suits and values
    public static final String[] SUITS = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    public static final String[] VALUES = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

    /**
     * Constructor, constructs a card with the values
     * @param suit The suit of the card
     * @param value The value of the card
     */
    public Card(String suit, String value) 
    {
        this.suit = suit;
        this.value = value;
    }

    // Getters
    public String getSuit() 
    {
        return suit;
    }

    public String getValue() 
    {
        return value;
    }

    // Setters
    public void setSuit(String suit) 
    {
        this.suit = suit;
    }

    public void setValue(String value) 
    {
        this.value = value;
    }

    public String toString() 
    {
        return value + " of " + suit;
    }
}
