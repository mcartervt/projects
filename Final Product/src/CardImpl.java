/**
 * This class represents a generic playing card
 */

public class CardImpl implements Card {
	//Instance variables
	private final Suit suit;
	private final SuitColor suitColor;
	private final int faceValue;
	private Side side;
	private String image;
	private int xCoordinate;
	private int yCoordinate;
	
	
	//Constructor
	public CardImpl(Suit suit, int faceValue) {
		this.suit = suit;
		
		if (suit == Suit.Hearts || suit == Suit.Diamonds) {
			this.suitColor = SuitColor.Red;
		}
		else {
			this.suitColor = SuitColor.Black;
		}
		
		this.faceValue = faceValue;
		this.side = Side.FaceDown;
		this.image = "Card_Back.png";
		this.xCoordinate = 0;
		this.yCoordinate = 0;
	}
	
	
	//Getters
	@Override
	public Suit getSuit() {
		return this.suit;
	}
	
	@Override
	public SuitColor getSuitColor() {
		return this.suitColor;
	}
	
	@Override
	public int getFaceValue() {
		return this.faceValue;
	}
	
	@Override
	public Side getSide() {
		return this.side;
	}

	@Override
	public String getImage() {
		return this.image;
	}
	
	@Override
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	
	@Override
	public int getYCoordinate() {
		return this.yCoordinate;
	}
	
	
	//Setters
	@Override
	public void setSide(Side side) {
		if (side == Side.FaceDown) {
			this.image = "Card_Back.png";
		}
		else {
			this.image = this.faceValue + "_of_" + this.suit + ".png";
		}
		this.side = side;
	}
	
	@Override
	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	@Override
	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
		
	@Override
	public String toString() {
		if (this.faceValue == 1) {
			return "Ace of " + this.suit;
		}
		if (this.faceValue == 11) {
			return "Jack of " + this.suit;
		}
		if (this.faceValue == 12) {
			return "Queen of " + this.suit;
		}
		if (this.faceValue == 13) {
			return "King of " + this.suit;
		}
		return this.faceValue + " of " + this.suit;
	}
}
