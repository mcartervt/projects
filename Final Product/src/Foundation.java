/**
 * This class represents a Foundation pile in Solitaire
 */

public class Foundation extends PileImpl {
	//Instance Variable
	private Suit suit;
	private SuitColor suitColor;
	
	Foundation(Suit suit) {
		super();
		this.suit = suit;
		
		if (this.suit == Suit.Diamonds || this.suit == Suit.Hearts) {
			this.suitColor = SuitColor.Red;
		}
		else {
			this.suitColor = SuitColor.Black;
		}
	}
	
	//Getter
	/**
	 * Lets the caller know if there are 
	 * 13 cards in the pile or not
	 * 
	 * @return true if the pile contains 13
	 * cards; otherwise return false
	 */
	boolean isFull() {
		if (getPile().size() == 13) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the suit color of this Foundation
	 * pile
	 * 
	 * @return the suit color of this Foundation
	 * pile
	 */
	public SuitColor getSuitColor() {
		return this.suitColor;
	}
	
	/**
	 * Gets the suit of this Foundation pile
	 * 
	 * @return the suit of this Foundation pile
	 */
	public Suit getSuit() {
		return this.suit;
	}
	
	
}
