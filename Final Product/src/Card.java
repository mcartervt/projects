/**
 * This interface represents all operations for a generic playing card in a 
 * deck
 */
public interface Card {
	/**
	 * Get the suit of this card
	 * 
	 * @return the suit of this card
	 */
	Suit getSuit();
	
	/**
	 * Get the suit color of this card
	 * 
	 * @return the suit color of this card
	 */
	SuitColor getSuitColor();
	
	/**
	 * Get the face value of this card
	 * 
	 * @return the face value of this card
	 */
	int getFaceValue();
	
	/**
	 * Get the side of this card that's
	 * showing
	 * 
	 * @return the side of this card that's 
	 * showing
	 */
	Side getSide();
	
	/**
	 * Get the image this card is showing
	 * 
	 * @return the image this card is showing
	 */
	String getImage();
	
	/**
	 * Get the x-coordinate of the top left
	 * point of this card
	 * 
	 * @return the x-coordinate of the top
	 * left point of this card
	 */
	int getXCoordinate();
	
	/**
	 * Get the y-coordinate of the top left
	 * point of this card
	 * 
	 * @return the y-coordinate of the top
	 * left point of this card 
	 */
	int getYCoordinate();
	
	/**
	 * Sets the side showing of this card to
	 * the provided side; adjusts the image 
	 * accordingly
	 * 
	 * @param side the side of this card that
	 * should show and adjusts the image
	 * accordingly
	 */
	void setSide(Side side);
	
	/**
	 * Set the x-coordinate of the top
	 * left point of this card
	 * 
	 * @param xCoordinate the x-coordinate 
	 * to be used for the top left point
	 * of this card
	 */
	void setXCoordinate(int xCoordinate);
	
	/**
	 * Set the y-coordinate of the top
	 * left point of this card
	 * 
	 * @param yCoordinate the y-coordinate 
	 * to be used for the top left point
	 * of this card
	 */
	void setYCoordinate(int yCoordinate);
	
	/**
	 * Formats the card into one string
	 * represented as "Face Value of Suit"
	 * 
	 * @return the formatted string
	 */
	@Override
	String toString();
}
