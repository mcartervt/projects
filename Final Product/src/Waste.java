/**
 * This class represents the Waste pile in Solitaire
 */
public class Waste extends PileImpl {
	
	Waste() {
		super();
	}
	
	//Can only receive a card from the Stock
	void acceptCard(CardImpl card, Deck sendingPile) {
		//Add the card sent to the top of this pile
		this.getPile().add(0, card);
	}
}
