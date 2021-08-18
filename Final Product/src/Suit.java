/**
 * This enum represents the four suits in Solitaire
 */
public enum Suit {
	Hearts, Spades, Diamonds, Clubs;

	@Override
	public String toString() {
		if (this == Hearts) {
			return "hearts";
		}
		else if (this == Spades) {
			return "spades";
		}
		else if (this == Diamonds) {
			return "diamonds";
		}
		else {
			return "clubs";
		}
	}
}