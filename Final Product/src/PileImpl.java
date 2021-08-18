import java.util.ArrayList;

/**
 * This abstract class implements the common methods among the four pile 
 * types in Solitaire
 */

public abstract class PileImpl implements Pile {
	//Initialize an empty pile
	private ArrayList<CardImpl> pile = new ArrayList<>();
	
	public PileImpl() {
		this.pile = pile;
	}
	

	@Override
	public ArrayList<CardImpl> getPile() {
		return this.pile;
	}
	
	@Override 
	public boolean isEmpty() {
		if (this.pile.size() == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public void acceptCard(CardImpl card) {
		//Add the card sent to the top of this pile
		this.getPile().add(0, card);
	}
	
	@Override
	public String toString() {
		String pileString = "";
		
		for (int j = 0; j < this.pile.size(); j++) {
			pileString += this.getPile().get(j);
			pileString += "\n";
		}
		
		return pileString;
	}
}
