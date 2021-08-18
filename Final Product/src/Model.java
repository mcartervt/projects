import java.util.ArrayList;

/**
 * The Model represents what's happening behind 
 * the View
 */

public class Model {
	//Instance Variables
	
	//Initialize a Deck
	protected Deck deck;
	
	//Initialize the Foundation piles
	protected Foundation foundationHearts;
	protected Foundation foundationSpades;
	protected Foundation foundationDiamonds;
	protected Foundation foundationClubs;
	
	//Initialize the Tableau piles
	protected Tableau tableau1;
	protected Tableau tableau2;
	protected Tableau tableau3;
	protected Tableau tableau4;
	protected Tableau tableau5;
	protected Tableau tableau6;
	protected Tableau tableau7;
	
	//Initialize a Waste pile
	protected Waste waste;
	
	//Constructor
	Model() {
		//Create a deck object
		this.deck = new Deck();
		
		//Create the 4 Foundation piles
		this.foundationHearts = new Foundation(Suit.Hearts);
		this.foundationSpades = new Foundation(Suit.Spades);
		this.foundationDiamonds = new Foundation(Suit.Diamonds);
		this.foundationClubs = new Foundation(Suit.Clubs);
		
		//Create the 7 Tableau piles
		this.tableau1 = new Tableau();
		this.tableau2 = new Tableau();
		this.tableau3 = new Tableau();
		this.tableau4 = new Tableau();
		this.tableau5 = new Tableau();
		this.tableau6 = new Tableau();
		this.tableau7 = new Tableau();
				
		//Create a Waste object
		this.waste = new Waste();
				
				
		//Shuffle the deck
		deck.shuffleDeck();
	}
	
	/**
	 * Sets up the gameboard for the beginning of Solitaire;
	 * cards are dealt from the deck to the Tableau piles
	 * 
	 * @param pilesLeft an ArrayList of the Tableau piles left that still need
	 * cards added
	 */
	public void setupHelper(ArrayList<Tableau> pilesLeft) {
		//Add the top card from the deck to the 1st Tableau pile 
		//in the ArrayList
		pilesLeft.get(0).acceptCard(this.deck.getPile().get(0));
		//Remove that card from the deck
		this.deck.getPile().remove(0);
		//Flip the top card over in the 1st Tableau pile in the 
		//ArrayList
		pilesLeft.get(0).getPile().get(0).setSide(Side.FaceUp);
			
		for (int i = 1; i < pilesLeft.size(); i++) {
			//Add the top card from the deck to the current Tableau pile
			pilesLeft.get(i).acceptCard(this.deck.getPile().get(0));
			//Remove that card from the deck
			this.deck.getPile().remove(0);
		}
		//Remove the Tableau pile at index 0 from the ArrayList
		pilesLeft.remove(0);
	}
	
	/**
	 * Utilizes the setupHelper() to distribute cards for the beginning of 
	 * Solitaire
	 */
	public void setup() {
		//Make an ArrayList of the Tableau piles
		ArrayList<Tableau> tableauPiles = new ArrayList<Tableau>();
		tableauPiles.add(this.tableau1);
		tableauPiles.add(this.tableau2);
		tableauPiles.add(this.tableau3);
		tableauPiles.add(this.tableau4);
		tableauPiles.add(this.tableau5);
		tableauPiles.add(this.tableau6);
		tableauPiles.add(this.tableau7);
		
		//Pass the list to the setup helper to distribute
		//cards amongst the 7 Tableau piles
		for (int i = 0; i < 7; i++) {
			setupHelper(tableauPiles);
		}
	}
	
	/**
	 * Determines if the game has been won; this means all 13 cards are in 
	 * their respective Foundation piles and all other piles are empty
	 * 
	 * @return true if the game has been won, false otherwise
	 */
	public boolean hasWon() {
		//Return true if all foundations are full and all other piles are empty
		if (this.foundationClubs.isFull() &&
				this.foundationDiamonds.isFull() &&
				this.foundationHearts.isFull() &&
				this.foundationSpades.isFull() &&
				this.deck.isEmpty() &&
				this.waste.isEmpty() &&
				this.tableau1.isEmpty() &&
				this.tableau2.isEmpty() &&
				this.tableau3.isEmpty() &&
				this.tableau4.isEmpty() &&
				this.tableau5.isEmpty() &&
				this.tableau6.isEmpty() &&
				this.tableau7.isEmpty()) {
			return true;
		}
		//Else return false
		else {
			return false;
		}
	}
	
	/**
	 * Moves the top card of the deck to the waste pile
	 */
	public void deckToWaste() {
		//Have the Waste pile accept the new card
		this.waste.acceptCard(this.deck.getPile().get(0), this.deck);
		
		//Remove the card from the deck
		this.deck.getPile().remove(0);
	}
	
	/**
	 * Determines if the top waste card can be moved to its respective 
	 * Foundation pile per the traditional rules of Solitaire
	 * 
	 * @param receivingPile the Foundation pile the card is being moved to
	 * @return true if the card can be moved, false otherwise
	 */
	protected boolean wastetoFoundationCondition(Foundation receivingPile) {
		if (receivingPile.getPile().size() == 0 && this.waste.getPile().get(0).getFaceValue() == 1) {
			return true;
		}
		else if(this.waste.getPile().get(0).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() + 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Helps the wasteToFoundation() method move the top card of the waste pile
	 * to its appropriate Foundation pile
	 * 
	 * @param receivingPile the Foundation pile the card is being moved to
	 */
	public void wasteToFoundationHelper(Foundation receivingPile) {
		if (receivingPile.getPile().size() == 0 && this.waste.getPile().get(0).getFaceValue() == 1) {
			receivingPile.acceptCard(this.waste.getPile().get(0));
			this.waste.getPile().remove(0);
		}
		//If there's already a card there
		else if (this.waste.getPile().get(0).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() + 1) {
			receivingPile.acceptCard(this.waste.getPile().get(0));
			this.waste.getPile().remove(0);
		}
	}
	
	/**
	 * Moves the top card of the waste pile to its appropriate Foundation pile
	 * based on the card's suit
	 */
	public void wasteToFoundation() {
		Suit topCardSuit;
		topCardSuit = this.waste.getPile().get(0).getSuit();
				
		switch(topCardSuit) {
			case Hearts:			
				wasteToFoundationHelper(this.foundationHearts);
				break;
			case Spades:
				wasteToFoundationHelper(this.foundationSpades);
				break;
			case Diamonds:
				wasteToFoundationHelper(this.foundationDiamonds);
				break;
			case Clubs:
				wasteToFoundationHelper(this.foundationClubs);
				break;
			default: 
				System.out.println("You've reached the default!");
		}
	}
	
	/**
	 * Determines if the top waste card can be moved to the provided Tableau 
	 * pile per the traditional rules of Solitaire
	 * 
	 * @param receivingPile the Tableau pile to which the card is to be moved
	 * @return true if the card can be moved to the indicated Tableau pile, 
	 * false otherwise
	 */
	protected boolean wastetoTableauCondition(Tableau receivingPile) {
		//If the top waste card is a king and the tableau pile is empty
		if (this.waste.getPile().get(0).getFaceValue() == 13 && receivingPile.getPile().size() == 0) {
			return true;
		}
		//Check if the top Waste card is one less than and the opposite suit of the card on top of the receiving pile
		else if(this.waste.getPile().get(0).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() - 1 && 
				this.waste.getPile().get(0).getSuitColor() != receivingPile.getPile().get(0).getSuitColor()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Assists wasteToTableau() in moving the top waste card to the provided 
	 * Tableau pile
	 * 
	 * @param receivingPile the Tableau pile the card is being moved to
	 */
	private void wasteToTableauHelper(Tableau receivingPile) {
		//If the top waste card is a king and the tableau pile is empty
		if (this.waste.getPile().get(0).getFaceValue() == 13 && receivingPile.getPile().size() == 0) {
			//Then add the card to the receiving Tableau pile
			receivingPile.acceptCard(this.waste.getPile().get(0));
			this.waste.getPile().remove(0);
		}
		//Check if the top Waste card is one less than and the opposite suit of the card on top of the receiving pile
		else if(this.waste.getPile().get(0).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() - 1 && 
				this.waste.getPile().get(0).getSuitColor() != receivingPile.getPile().get(0).getSuitColor()) {
			//Then add the card to the receiving Tableau pile
			receivingPile.acceptCard(this.waste.getPile().get(0));
			this.waste.getPile().remove(0);
		}
	}
	
	/**
	 * Moves the top card from the waste to the provided Tableau
	 * 
	 * @param tableauNumber the number of the Tableau pile the card is being
	 * moved to
	 */
	public void wasteToTableau(int tableauNumber) {
		switch(tableauNumber) {
			case 1:
				wasteToTableauHelper(this.tableau1);
				break;
			case 2: 
				wasteToTableauHelper(this.tableau2);
				break;
			case 3:
				wasteToTableauHelper(this.tableau3);
				break;
			case 4:
				wasteToTableauHelper(this.tableau4);
				break;
			case 5:
				wasteToTableauHelper(this.tableau5);
				break;
			case 6: 
				wasteToTableauHelper(this.tableau6);
				break;
			case 7:
				wasteToTableauHelper(this.tableau7);
				break;
			default:
				System.out.println("Invalid Tableau pile number!");
		}
	}
	
	/**
	 * Determines if the top card of the provided Tableau pile can be moved 
	 * onto the provided Foundation pile per the rules of Solitaire
	 * 
	 * @param tableauPile the Tableau pile the card is being moved from
	 * @param foundationPile the Foundation pile the card is being moved to
	 * @return true if the card can be moved, false otherwise
	 */
	protected boolean tableauToFoundationCondition(Tableau tableauPile, Foundation foundationPile) {
		//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
		//If the foundation pile is empty and the card being placed is an Ace
		if (tableauPile.getPile().get(0).getSuit() == foundationPile.getSuit() &&
				foundationPile.getPile().isEmpty() && tableauPile.getPile().get(0).getFaceValue() == 1) {
			return true;
		}
		//If the tableau card is one more than the top foundation card
		else if (tableauPile.getPile().get(0).getSuit() == foundationPile.getSuit() &&
				tableauPile.getPile().get(0).getFaceValue() == foundationPile.getPile().get(0).getFaceValue() + 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Helps the tableauToFoundation() method moved a card from the provided 
	 * Tableau pile to the provided Foundation pile
	 * 
	 * @param tableauPile the Tableau pile the card is being moved from
	 * @param foundationPile the Foundation pile the card is being moved to
	 */
	private void tableauToFoundationHelper(Tableau tableauPile, Foundation foundationPile) {
		//If the foundation pile is empty and the card being placed is an Ace
		if (foundationPile.getPile().isEmpty() && tableauPile.getPile().get(0).getFaceValue() == 1) {
			//Then add the card to the foundation
			foundationPile.acceptCard(tableauPile.getPile().get(0));
			tableauPile.getPile().remove(0);
		}
		//If the tableau card is one more than the top foundation card
		else if (tableauPile.getPile().get(0).getFaceValue() == foundationPile.getPile().get(0).getFaceValue() + 1) {
			//Then add the card to the foundation
			foundationPile.acceptCard(tableauPile.getPile().get(0));
			tableauPile.getPile().remove(0);
		}
		//If the pile's empty and the card being placed isn't an Ace
		else if (foundationPile.getPile().isEmpty() && tableauPile.getPile().get(0).getFaceValue() != 1) {
			//Then throw an exception
			throw new IllegalArgumentException("Incorrect face value for move!");
		}
		//Otherwise the card has to be exactly one more than top foundation card
		else if(tableauPile.getPile().get(0).getFaceValue() != foundationPile.getPile().get(0).getFaceValue() + 1) {
			//throw new IllegalArgumentException("Incorrect face value for move!");
		}
	}
	
	/**
	 * Moves the top card of the provided Tableau pile onto the provided 
	 * Foundation pile, if permissible
	 * 
	 * @param tableauNumber the number of the Tableau pile the card is being 
	 * moved from
	 * @param foundationSuit the suit of the Foundation pile the card is being 
	 * moved to
	 */
	public void tableauToFoundation(int tableauNumber, Suit foundationSuit) {
		
		switch(tableauNumber) {
			//Move from the first Tableau pile
			case 1:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau1.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau1, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau1, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau1, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau1, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the second Tableau pile
			case 2: 
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau2.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau2, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau2, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau2, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau2, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the third Tableau pile
			case 3:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau3.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau3, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau3, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau3, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau3, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the fourth Tableau pile
			case 4:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau4.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau4, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau4, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau4, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau4, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the fifth Tableau pile
			case 5:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau5.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau5, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau5, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau5, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau5, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the sixth Tableau pile
			case 6:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau6.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau6, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau6, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau6, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau6, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			//Move from the seventh Tableau pile
			case 7:
				//Suit of top card of the source Tableau pile has to match the destination Foundation pile provided
				if (this.tableau7.getPile().get(0).getSuit() != foundationSuit) {
					throw new IllegalArgumentException("This card is the wrong suit!");
				}
				switch(foundationSuit) {
					//To the Hearts Foundation
					case Hearts:
						tableauToFoundationHelper(this.tableau7, this.foundationHearts);
						break;
					//To the Spades Foundation
					case Spades:
						tableauToFoundationHelper(this.tableau7, this.foundationSpades);
						break;
					//To the Diamonds Foundation
					case Diamonds:
						tableauToFoundationHelper(this.tableau7, this.foundationDiamonds);
						break;
					//To the Clubs Foundation
					case Clubs:
						tableauToFoundationHelper(this.tableau7, this.foundationClubs);
						break;
					default:
						System.out.println("Invalid Foundation pile!");
				}
				break;
			default:
				System.out.println("Invalid Tableau pile number!");
		}
	}
	
	/**
	 * Determines if the face up cards on the sending Tableau pile can be sent
	 * to the receiving Tableau pile per the rules of Solitaire
	 * 
	 * @param sendingPile the Tableau pile the face up cards will be sent from
	 * @param receivingPile the Tableau pile the face up cards will be sent to
	 * @return true if the face up cards can be sent, otherwise false
	 */
	protected boolean tableauToTableauCondition(Tableau sendingPile, Tableau receivingPile) {
		int i = 0;
		//Iterate to the last card that's faceup in the pile
		while(i < sendingPile.getPile().size() && sendingPile.getPile().get(i).getSide() == Side.FaceUp) {
			i++;
		}
		//Handles case where pile is size 1
		if (i > 0) {
			i--;//This sets i back to the last faceup card index
		}
		//If the foundation card is a king and the tableau pile is empty
		if (sendingPile.getPile().get(i).getFaceValue() == 13 && receivingPile.getPile().size() == 0) {
			return true;
		}
		//Check if it's one less than and the opposite suit of the card on top of the receiving pile
		if(sendingPile.getPile().get(i).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() - 1 && 
				sendingPile.getPile().get(i).getSuitColor() != receivingPile.getPile().get(0).getSuitColor()) {
			return true;
			}
		return false;
		
	}
	
	/**
	 * Determines the index of the last face up card in the sending Tableau 
	 * pile
	 * 
	 * @param sendingPile the Tableau pile that will send cards
	 * @return the index of the last face up card in the sending Tableau pile
	 */
	protected int tableauToTableauViewHelper(Tableau sendingPile) {
		int i = 0;
		//Iterate to the last card that's face up in the pile
		while(i < sendingPile.getPile().size() && sendingPile.getPile().get(i).getSide() == Side.FaceUp) {
			i++;
		}
		//Handles case where pile is size 1
		if (i > 0) {
			i--;//This sets i back to the last face up card index
		}
		return i;
	}
	
	/**
	 * Assists tableauToTableau() in moving all face up cards from one Tableau
	 * pile to another
	 * 
	 * @param sendingPile the Tableau pile the cards are being sent from
	 * @param receivingPile the Tableau pile the card are being sent to
	 */
	private void tableauToTableauHelper(Tableau sendingPile, Tableau receivingPile) {
		int i = 0;
		//Iterate to the last card that's faceup in the pile
		while(i < sendingPile.getPile().size() && sendingPile.getPile().get(i).getSide() == Side.FaceUp) {
			i++;
		}
		//Handles case where pile is size 1
		if (i > 0) {
			i--;//This sets i back to the last faceup card index
		}
		//If the foundation card is a king and the tableau pile is empty or,
		//Check if it's one less than and the opposite suit of the card on top of the receiving pile
		if((sendingPile.getPile().get(i).getFaceValue() == 13 && receivingPile.getPile().size() == 0) ||
				(sendingPile.getPile().get(i).getFaceValue() == receivingPile.getPile().get(0).getFaceValue() - 1 && 
				sendingPile.getPile().get(i).getSuitColor() != receivingPile.getPile().get(0).getSuitColor())) {
			//Then add the cards to the receiving Tableau pile
			while(i >= 0) {
				receivingPile.acceptCard(sendingPile.getPile().get(i));
				sendingPile.getPile().remove(i);
				i--;
			}
		}
		
	}
	
	/**
	 * Moves all face up cards from the sending Tableau pile onto the receiving
	 * Tableau pile, if allowed by traditional Solitaire rules
	 * 
	 * @param sendingTableauNumber the number of the Tableau pile the cards are 
	 * being sent from 
	 * @param receivingTableauNumber the number of the Tableau pile the cards 
	 * are being sent to
	 */
	public void tableauToTableau(int sendingTableauNumber, int receivingTableauNumber) {
		//From the sending Tableau pile
		switch(sendingTableauNumber) {
			case 1:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 2:
						tableauToTableauHelper(this.tableau1, this.tableau2);
						break;
					case 3:
						tableauToTableauHelper(this.tableau1, this.tableau3);
						break;
					case 4:
						tableauToTableauHelper(this.tableau1, this.tableau4);
						break;
					case 5:
						tableauToTableauHelper(this.tableau1, this.tableau5);
						break;
					case 6:
						tableauToTableauHelper(this.tableau1, this.tableau6);
						break;
					case 7:
						tableauToTableauHelper(this.tableau1, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 2:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau2, this.tableau1);
						break;
					case 3:
						tableauToTableauHelper(this.tableau2, this.tableau3);
						break;
					case 4:
						tableauToTableauHelper(this.tableau2, this.tableau4);
						break;
					case 5:
						tableauToTableauHelper(this.tableau2, this.tableau5);
						break;
					case 6:
						tableauToTableauHelper(this.tableau2, this.tableau6);
						break;
					case 7:
						tableauToTableauHelper(this.tableau2, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 3:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau3, this.tableau1);
						break;
					case 2:
						tableauToTableauHelper(this.tableau3, this.tableau2);
						break;
					case 4:
						tableauToTableauHelper(this.tableau3, this.tableau4);
						break;
					case 5:
						tableauToTableauHelper(this.tableau3, this.tableau5);
						break;
					case 6:
						tableauToTableauHelper(this.tableau3, this.tableau6);
						break;
					case 7:
						tableauToTableauHelper(this.tableau3, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 4:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau4, this.tableau1);
						break;
					case 2:
						tableauToTableauHelper(this.tableau4, this.tableau2);
						break;
					case 3:
						tableauToTableauHelper(this.tableau4, this.tableau3);
						break;
					case 5:
						tableauToTableauHelper(this.tableau4, this.tableau5);
						break;
					case 6:
						tableauToTableauHelper(this.tableau4, this.tableau6);
						break;
					case 7:
						tableauToTableauHelper(this.tableau4, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 5:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau5, this.tableau1);
						break;
					case 2:
						tableauToTableauHelper(this.tableau5, this.tableau2);
						break;
					case 3:
						tableauToTableauHelper(this.tableau5, this.tableau3);
						break;
					case 4:
						tableauToTableauHelper(this.tableau5, this.tableau4);
						break;
					case 6:
						tableauToTableauHelper(this.tableau5, this.tableau6);
						break;
					case 7:
						tableauToTableauHelper(this.tableau5, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 6:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau6, this.tableau1);
						break;
					case 2:
						tableauToTableauHelper(this.tableau6, this.tableau2);
						break;
					case 3:
						tableauToTableauHelper(this.tableau6, this.tableau3);
						break;
					case 4:
						tableauToTableauHelper(this.tableau6, this.tableau4);
						break;
					case 5:
						tableauToTableauHelper(this.tableau6, this.tableau5);
						break;
					case 7:
						tableauToTableauHelper(this.tableau6, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			case 7:
				//To the receiving Tableau pile
				switch(receivingTableauNumber) {
					case 1:
						tableauToTableauHelper(this.tableau7, this.tableau1);
						break;
					case 2:
						tableauToTableauHelper(this.tableau7, this.tableau2);
						break;
					case 3:
						tableauToTableauHelper(this.tableau7, this.tableau3);
						break;
					case 4:
						tableauToTableauHelper(this.tableau7, this.tableau4);
						break;
					case 5:
						tableauToTableauHelper(this.tableau7, this.tableau5);
						break;
					case 6:
						tableauToTableauHelper(this.tableau7, this.tableau6);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			//Invalid sending pile!
			default:
				System.out.println("Invalid sending Tableau pile!");
		}//End of outer switch
	}//End of tableauToTableau()
	
	/**
	 * Determines if the top Foundation card can be moved onto the provided 
	 * Tableau pile per the rules of Solitaire
	 * 
	 * @param sendingPile the Foundation pile the card is being sent from
	 * @param receivingPile the Tableau pile the card is being sent to
	 * @return true if the card is allowed to be moved, false otherwise
	 */
	protected boolean foundationToTableauCondition(Foundation sendingPile, Tableau receivingPile) {
		//If the foundation card is a king and the tableau pile is empty
		if (sendingPile.getPile().get(0).getFaceValue() == 13 && receivingPile.getPile().size() == 0) {
			return true;
		}
		//If top card's suit color is opposite the foundation's and its face value is 1 more than top foundation card
		else if (receivingPile.getPile().get(0).getSuitColor() != sendingPile.getSuitColor() && 
		receivingPile.getPile().get(0).getFaceValue() == sendingPile.getPile().get(0).getFaceValue() + 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Helps the foundationToTableau() method move the top Foundation card onto
	 * the Tableau pile provided
	 * 
	 * @param sendingPile the Foundation pile the card is being sent from
	 * @param receivingPile the Tableau pile the card is being sent to
	 */
	private void foundationToTableauHelper(Foundation sendingPile, Tableau receivingPile) {
		//If the foundation card is a king and the tableau pile is empty
		if (sendingPile.getPile().get(0).getFaceValue() == 13 && receivingPile.getPile().size() == 0) {
			receivingPile.acceptCard(sendingPile.getPile().get(0));
			sendingPile.getPile().remove(0);
		}
		//If top card's suit color is opposite the foundation's and its face value is 1 more than top foundation card
		else if (receivingPile.getPile().get(0).getSuitColor() != sendingPile.getSuitColor() && 
		receivingPile.getPile().get(0).getFaceValue() == sendingPile.getPile().get(0).getFaceValue() + 1) {
			receivingPile.acceptCard(sendingPile.getPile().get(0));
			sendingPile.getPile().remove(0);
		}
	}
	
	/**
	 * Moves the top card of the provided Foundation pile to the provided 
	 * Tableau pile
	 * 
	 * @param foundationSuit the suit of the Foundation pile the card is being 
	 * moved from
	 * @param tableauNumber the number of the Tableau pile the card is being 
	 * moved to
	 */
	public void foundationToTableau(Suit foundationSuit, int tableauNumber) {
		switch(foundationSuit) {
			//If sending foundation suit is Clubs
			case Clubs:
				switch(tableauNumber) {
					case 1:
						foundationToTableauHelper(this.foundationClubs, this.tableau1);
						break;
					case 2:
						foundationToTableauHelper(this.foundationClubs, this.tableau2);
						break;
					case 3:
						foundationToTableauHelper(this.foundationClubs, this.tableau3);
						break;
					case 4:
						foundationToTableauHelper(this.foundationClubs, this.tableau4);
						break;
					case 5:
						foundationToTableauHelper(this.foundationClubs, this.tableau5);
						break;
					case 6:
						foundationToTableauHelper(this.foundationClubs, this.tableau6);
						break;
					case 7:
						foundationToTableauHelper(this.foundationClubs, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			//If sending foundation suit is Diamonds	
			case Diamonds:
				switch(tableauNumber) {
					case 1:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau1);
						break;
					case 2:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau2);
						break;
					case 3:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau3);
						break;
					case 4:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau4);
						break;
					case 5:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau5);
						break;
					case 6:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau6);
						break;
					case 7:
						foundationToTableauHelper(this.foundationDiamonds, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			//If sending foundation suit is Hearts
			case Hearts:
				switch(tableauNumber) {
					case 1:
						foundationToTableauHelper(this.foundationHearts, this.tableau1);
						break;
					case 2:
						foundationToTableauHelper(this.foundationHearts, this.tableau2);
						break;
					case 3:
						foundationToTableauHelper(this.foundationHearts, this.tableau3);
						break;
					case 4:
						foundationToTableauHelper(this.foundationHearts, this.tableau4);
						break;
					case 5:
						foundationToTableauHelper(this.foundationHearts, this.tableau5);
						break;
					case 6:
						foundationToTableauHelper(this.foundationHearts, this.tableau6);
						break;
					case 7:
						foundationToTableauHelper(this.foundationHearts, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			//If sending foundation suit is Spades
			case Spades:
				switch(tableauNumber) {
					case 1:
						foundationToTableauHelper(this.foundationSpades, this.tableau1);
						break;
					case 2:
						foundationToTableauHelper(this.foundationSpades, this.tableau2);
						break;
					case 3:
						foundationToTableauHelper(this.foundationSpades, this.tableau3);
						break;
					case 4:
						foundationToTableauHelper(this.foundationSpades, this.tableau4);
						break;
					case 5:
						foundationToTableauHelper(this.foundationSpades, this.tableau5);
						break;
					case 6:
						foundationToTableauHelper(this.foundationSpades, this.tableau6);
						break;
					case 7:
						foundationToTableauHelper(this.foundationSpades, this.tableau7);
						break;
					default:
						System.out.println("Invalid receiving Tableau pile!");
				}
				break;
			default:
				System.out.println("Invalid sending Foundation suit!");
		}
	}
	
	/**
	 * Recycles the waste pile into the deck
	 */
	public void wasteToDeck() {
		int wastePileSize = this.waste.getPile().size();
		
		for (int i = 0; i < wastePileSize; i++) {
			//Set the bottom card of the Waste to be face down
			this.waste.getPile().get(0).setSide(Side.FaceDown);
			//Add the bottom card of the Waste to the deck
			this.deck.acceptCard(this.waste.getPile().get(0));
			//Remove the bottom card of the Waste
			this.waste.getPile().remove(0);
			
			
		}
	}
}





