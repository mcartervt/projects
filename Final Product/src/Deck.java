import java.util.Collections;

/**
 * This class represents a standard deck of 52 cards
 */

public class Deck extends PileImpl {
	
	public Deck() {
		super();
		//Create the 52 unique cards in the deck
		for (int i = 1; i < 53; i++) {
			if (i < 14) {
				this.getPile().add(new CardImpl(Suit.Hearts, ((i-1)%13)+1));				
			}
			else if (i > 13 && i < 27) {
				this.getPile().add(new CardImpl(Suit.Spades, ((i-1)%13)+1));
			}
			else if (i > 26 && i < 40) {
				this.getPile().add(new CardImpl(Suit.Diamonds, ((i-1)%13)+1));
			}
			else {
				this.getPile().add(new CardImpl(Suit.Clubs, ((i-1)%13)+1));
			}
		}
	}
	
		
	/**
	 * Shuffles this deck of cards
	 */
	public void shuffleDeck() {
		//Shuffle the deck of cards
		Collections.shuffle(this.getPile());
	}
		
		
	
}
