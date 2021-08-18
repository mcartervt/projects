import java.util.ArrayList;

/**
 * This interface represents a general pile of cards
 * in the game Solitaire
 */
public interface Pile {
	/**
	 * Gets this pile of cards
	 * 
	 * @return the pile of cards
	 */
	ArrayList<CardImpl> getPile();
	
	/**
	 * Identifies if the pile is empty or not
	 * 
	 * @return true if the size of the pile
	 * is zero; otherwise, returns false
	 */
	boolean isEmpty();
	
	/**
	 * Adds the provided card from the provided pile onto this pile
	 * with the given side showing
	 * 
	 * @param card the card to be added to this pile
	 */
	void acceptCard(CardImpl card);
	
	/**
	 * Formats the pile of cards into one string
	 * with each card one its own line represented 
	 * as "Face Value of Suit"
	 * 
	 * @return the formatted string
	 */
	@Override
	String toString();
}
