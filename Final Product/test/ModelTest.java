import static org.junit.Assert.*;
import org.junit.Test;
/**
 * This file contains unit testing for the methods in the Model
 */
public class ModelTest {

	//Create the Model
	Model model = new Model();
	
	
	@Test
	public void testSetup() {
		//Check the deck and tableau piles have the correct number of cards
		//before setup()
		assertEquals(52, model.deck.getPile().size());
		assertEquals(0, model.tableau1.getPile().size());
		assertEquals(0, model.tableau2.getPile().size());
		assertEquals(0, model.tableau3.getPile().size());
		assertEquals(0, model.tableau4.getPile().size());
		assertEquals(0, model.tableau5.getPile().size());
		assertEquals(0, model.tableau6.getPile().size());
		assertEquals(0, model.tableau7.getPile().size());
		
		model.setup();
		//Make sure cards were sent out of the deck
		assertEquals(24, model.deck.getPile().size());
		
		//Make sure the tableau piles are the right size and the top card is
		//face up
		assertEquals(1, model.tableau1.getPile().size());
		assertEquals(Side.FaceUp, model.tableau1.getPile().get(0).getSide());
		
		assertEquals(2, model.tableau2.getPile().size());
		assertEquals(Side.FaceUp, model.tableau2.getPile().get(0).getSide());
		
		assertEquals(3, model.tableau3.getPile().size());
		assertEquals(Side.FaceUp, model.tableau3.getPile().get(0).getSide());
		
		assertEquals(4, model.tableau4.getPile().size());
		assertEquals(Side.FaceUp, model.tableau4.getPile().get(0).getSide());
		
		assertEquals(5, model.tableau5.getPile().size());
		assertEquals(Side.FaceUp, model.tableau5.getPile().get(0).getSide());
		
		assertEquals(6, model.tableau6.getPile().size());
		assertEquals(Side.FaceUp, model.tableau6.getPile().get(0).getSide());
		
		assertEquals(7, model.tableau7.getPile().size());
		assertEquals(Side.FaceUp, model.tableau7.getPile().get(0).getSide());
	}
	
	
	@Test
	public void testHasWon() {
		//Test false condition
		assertFalse(model.hasWon());
		
		//Add cards to Clubs foundation
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 2));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 3));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 4));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 5));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 6));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 7));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 8));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 9));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 10));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 11));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 12));
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 13));
		
		//Test false condition
		assertFalse(model.hasWon());
		
		//Add cards to the Diamonds foundation
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 3));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 5));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 6));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 7));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 8));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 9));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 10));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 11));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 12));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 13));
		
		//Test false condition
		assertFalse(model.hasWon());
		
		//Add cards to the Hearts foundation
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 2));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 3));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 4));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 5));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 6));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 7));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 8));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 9));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 10));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 11));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 12));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 13));
		
		//Test false condition
		assertFalse(model.hasWon());
		
		//Add cards to the Spades foundation
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 1));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 2));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 3));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 4));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 5));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 6));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 7));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 8));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 9));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 10));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 11));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 12));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 13));
		
		//Test false condition
		assertFalse(model.hasWon());
		//Clear the deck
		model.deck.getPile().clear();
		
		//Test true condition
		assertTrue(model.hasWon());
		
	}
	
	//Make tests for the Controller/Model methods
	@Test
	public void testDeckToWaste() {
		//Empty the deck
		for (int i = 0; i < 52; i++) {
			model.deck.getPile().remove(0);
		}
		
		//Add cards to the deck
		model.deck.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.deck.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.deck.acceptCard(new CardImpl(Suit.Hearts, 3));
		model.deck.acceptCard(new CardImpl(Suit.Spades, 4));
		model.deck.acceptCard(new CardImpl(Suit.Clubs, 5));
		
		model.deckToWaste();
		//Check that the top deck card was added to the waste
		assertEquals(5, model.waste.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.waste.getPile().get(0).getSuit());
	}
	
	@Test
	public void testWasteToFoundation() {
		//Add cards to the waste
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.waste.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.waste.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.waste.acceptCard(new CardImpl(Suit.Spades, 1));
		
		model.wasteToFoundation();
		model.wasteToFoundation();
		model.wasteToFoundation();
		model.wasteToFoundation();
		
		//Check that former waste cards are now on the appropriate foundation 
		//piles
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		
		//Add more to the waste
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 4));
		model.waste.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.waste.acceptCard(new CardImpl(Suit.Hearts, 3));
		model.waste.acceptCard(new CardImpl(Suit.Spades, 2));
		
		//Move the 2 of Spades onto the Ace of Spades
		model.wasteToFoundation();
		//Try to move the 3 of Hearts onto the Ace of Hearts (Invalid move)
		model.wasteToFoundation();
		
				
		//Check that the 2 of Spades went on top of the Ace of Spades
		assertEquals(2, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		
		//Check that the 3 of Hearts didn't get added to the Ace of Hearts
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		//Remove the 3 of Hearts from the Waste to prep the next test
		model.waste.getPile().remove(0);
		
		//Add the 2 of Diamonds to the Foundation
		model.wasteToFoundation();
		//Check that the 2 of Diamonds went on top of the Ace of Diamonds
		assertEquals(2, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		
		//Try to add the 4 of Clubs on top of the Ace of Clubs (Invalid move)
		model.wasteToFoundation();
		//Check that the 4 of Clubs didn't get added to the Ace of Clubs
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		
	}
	
	@Test
	public void testWasteToTableau() {
		//Add cards to the waste
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.waste.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.waste.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.waste.acceptCard(new CardImpl(Suit.Spades, 1));
		
		//Add cards to Tableau 1 - 4
		model.tableau1.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.tableau2.acceptCard(new CardImpl(Suit.Clubs, 2));
		model.tableau3.acceptCard(new CardImpl(Suit.Spades, 2));
		model.tableau4.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		model.wasteToTableau(1);
		model.wasteToTableau(2);
		model.wasteToTableau(3);
		model.wasteToTableau(4);
		
		//Check that the waste cards went to the tableau piles
		assertEquals(2, model.tableau1.getPile().size());
		assertEquals(2, model.tableau2.getPile().size());
		assertEquals(2, model.tableau3.getPile().size());
		assertEquals(2, model.tableau4.getPile().size());
		
		assertEquals(1, model.tableau1.getPile().get(0).getFaceValue());
		assertEquals(1, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(1, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(1, model.tableau2.getPile().get(0).getFaceValue());
		
		//Add the kings to the waste
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 13));
		model.waste.acceptCard(new CardImpl(Suit.Hearts, 13));
		model.waste.acceptCard(new CardImpl(Suit.Diamonds, 13));
		model.waste.acceptCard(new CardImpl(Suit.Spades, 13));
		//Clear some of the tableau piles
		model.tableau2.getPile().clear();
		model.tableau3.getPile().clear();
		model.tableau4.getPile().clear();
		
		//Try adding the king to tableau 1 while it still has cards in it (invalid move)
		model.wasteToTableau(1);
		//Confirm it didn't get added
		assertEquals(2, model.tableau1.getPile().size());
		assertEquals(1, model.tableau1.getPile().get(0).getFaceValue());
		
		//Move the Kings to the other open tableau piles
		model.wasteToTableau(2);
		assertEquals(1, model.tableau2.getPile().size());
		assertEquals(13, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.tableau2.getPile().get(0).getSuit());
		
		model.wasteToTableau(3);
		assertEquals(1, model.tableau3.getPile().size());
		assertEquals(13, model.tableau3.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.tableau3.getPile().get(0).getSuit());
		
		model.wasteToTableau(5);
		assertEquals(1, model.tableau5.getPile().size());
		assertEquals(13, model.tableau5.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau5.getPile().get(0).getSuit());
		
		model.wasteToTableau(7);
		assertEquals(1, model.tableau7.getPile().size());
		assertEquals(13, model.tableau7.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau7.getPile().get(0).getSuit());
	}
	
	@Test
	public void testTableau1ToFoundation() {
		//Tableau 1
		//Ace from Tableau 1 to Hearts Foundation
		model.tableau1.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(1, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau1.getPile().size());
		
		//Ace from Tableau 1 to Spades Foundation
		model.tableau1.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(1, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau1.getPile().size());
		
		//Ace from Tableau 1 to Diamonds Foundation
		model.tableau1.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(1, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau1.getPile().size());
		
		//Ace from Tableau 1 to Clubs Foundation
		model.tableau1.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(1, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau1.getPile().size());
		
		//Add some more cards
		model.tableau1.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau1.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau1.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(1, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(1, Suit.Spades);
		model.tableau1.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(1, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		
	}
	
	@Test
	public void testTableau2ToFoundation() {
		//Tableau 2
		//Ace from Tableau 2 to Hearts Foundation
		model.tableau2.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(2, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau2.getPile().size());
		
		//Ace from Tableau 2 to Spades Foundation
		model.tableau2.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(2, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau2.getPile().size());
		
		//Ace from Tableau 2 to Diamonds Foundation
		model.tableau2.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(2, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau2.getPile().size());
		
		//Ace from Tableau 2 to Clubs Foundation
		model.tableau2.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(2, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau2.getPile().size());
		
		//Add some more cards
		model.tableau2.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau2.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau2.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(2, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(2, Suit.Spades);
		model.tableau2.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(2, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableau3ToFoundation() {
		//Tableau 3
		//Ace from Tableau 3 to Hearts Foundation
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(3, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau3.getPile().size());
		
		//Ace from Tableau 3 to Spades Foundation
		model.tableau3.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(3, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau3.getPile().size());
		
		//Ace from Tableau 3 to Diamonds Foundation
		model.tableau3.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(3, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau3.getPile().size());
		
		//Ace from Tableau 3 to Clubs Foundation
		model.tableau3.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(3, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau3.getPile().size());
		
		//Add some more cards
		model.tableau3.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau3.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(3, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(3, Suit.Spades);
		model.tableau3.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(3, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableau4ToFoundation() {
		//Tableau 4
		//Ace from Tableau 4 to Hearts Foundation
		model.tableau4.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(4, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau4.getPile().size());
		
		//Ace from Tableau 4 to Spades Foundation
		model.tableau4.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(4, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau4.getPile().size());
		
		//Ace from Tableau 4 to Diamonds Foundation
		model.tableau4.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(4, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau4.getPile().size());
		
		//Ace from Tableau 4 to Clubs Foundation
		model.tableau4.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(4, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau4.getPile().size());
		
		//Add some more cards
		model.tableau4.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau4.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau4.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(4, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(4, Suit.Spades);
		model.tableau4.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(4, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableau5ToFoundation() {
		//Tableau 5
		//Ace from Tableau 5 to Hearts Foundation
		model.tableau5.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(5, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau5.getPile().size());
		
		//Ace from Tableau 5 to Spades Foundation
		model.tableau5.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(5, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau5.getPile().size());
		
		//Ace from Tableau 5 to Diamonds Foundation
		model.tableau5.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(5, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau5.getPile().size());
		
		//Ace from Tableau 5 to Clubs Foundation
		model.tableau5.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(5, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau5.getPile().size());
		
		//Add some more cards
		model.tableau5.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau5.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau5.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(5, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(5, Suit.Spades);
		model.tableau5.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(5, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableau6ToFoundation() {
		//Tableau 6
		//Ace from Tableau 6 to Hearts Foundation
		model.tableau6.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(6, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau6.getPile().size());
		
		//Ace from Tableau 6 to Spades Foundation
		model.tableau6.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(6, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau6.getPile().size());
		
		//Ace from Tableau 6 to Diamonds Foundation
		model.tableau6.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(6, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau6.getPile().size());
		
		//Ace from Tableau 6 to Clubs Foundation
		model.tableau6.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(6, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau6.getPile().size());
		
		//Add some more cards
		model.tableau6.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau6.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau6.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(6, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(6, Suit.Spades);
		model.tableau6.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(6, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableau7ToFoundation() {
		//Tableau 7
		//Ace from Tableau 7 to Hearts Foundation
		model.tableau7.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.tableauToFoundation(7, Suit.Hearts);
		assertEquals(1, model.foundationHearts.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.foundationHearts.getPile().get(0).getSuit());
		assertEquals(0, model.tableau7.getPile().size());
		
		//Ace from Tableau 7 to Spades Foundation
		model.tableau7.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableauToFoundation(7, Suit.Spades);
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.foundationSpades.getPile().get(0).getSuit());
		assertEquals(0, model.tableau7.getPile().size());
		
		//Ace from Tableau 7 to Diamonds Foundation
		model.tableau7.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.tableauToFoundation(7, Suit.Diamonds);
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.foundationDiamonds.getPile().get(0).getSuit());
		assertEquals(0, model.tableau7.getPile().size());
		
		//Ace from Tableau 7 to Clubs Foundation
		model.tableau7.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.tableauToFoundation(7, Suit.Clubs);
		assertEquals(1, model.foundationClubs.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.foundationClubs.getPile().get(0).getSuit());
		assertEquals(0, model.tableau7.getPile().size());
		
		//Add some more cards
		model.tableau7.acceptCard(new CardImpl(Suit.Diamonds, 4));
		model.tableau7.acceptCard(new CardImpl(Suit.Spades, 3));
		model.tableau7.acceptCard(new CardImpl(Suit.Hearts, 2));
		
		//Try to move them onto the Foundation
		model.tableauToFoundation(7, Suit.Hearts);
		//Try an invalid move
		model.tableauToFoundation(7, Suit.Spades);
		model.tableau7.getPile().remove(0);
		//Try another invalid move
		model.tableauToFoundation(7, Suit.Diamonds);
		
		//Confirm expected size and face value
		assertEquals(2, model.foundationHearts.getPile().size());
		assertEquals(2, model.foundationHearts.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationSpades.getPile().size());
		assertEquals(1, model.foundationSpades.getPile().get(0).getFaceValue());
		
		assertEquals(1, model.foundationDiamonds.getPile().size());
		assertEquals(1, model.foundationDiamonds.getPile().get(0).getFaceValue());
	}
	
	@Test
	public void testTableauToTableau() {
		//SITUATION: When King is on top and other pile is empty
		model.tableau1.acceptCard(new CardImpl(Suit.Clubs, 13));
		model.tableau1.getPile().get(0).setSide(Side.FaceUp);
		model.tableauToTableau(1, 2);
		//Check the king is the top card on tableau 2
		assertEquals(13, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau2.getPile().get(0).getSuit());
		//Check tableau 1 is now empty
		assertEquals(0, model.tableau1.getPile().size());
		
		//Add face down cards under the king on top
		model.tableau3.acceptCard(new CardImpl(Suit.Clubs, 5));
		model.tableau3.getPile().get(0).setSide(Side.FaceDown);
		model.tableau3.acceptCard(new CardImpl(Suit.Diamonds, 10));
		model.tableau3.getPile().get(0).setSide(Side.FaceDown);
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 13));
		model.tableauToTableau(3, 4);
		//Check the king is on top of tableau 4 now
		assertEquals(13, model.tableau4.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau4.getPile().get(0).getSuit());
		//Check tableau 3 only has the 2 face down cards now
		assertEquals(2, model.tableau3.getPile().size());
		
		
		//SITUATION: When King has other cards on top, and other pile is empty
		model.tableau5.acceptCard(new CardImpl(Suit.Diamonds, 13));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		model.tableau5.acceptCard(new CardImpl(Suit.Spades, 12));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		model.tableau5.acceptCard(new CardImpl(Suit.Hearts, 11));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		model.tableau5.acceptCard(new CardImpl(Suit.Clubs, 10));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		model.tableauToTableau(5, 6);
		//Check the cards moved to tableau 6
		assertEquals(10, model.tableau6.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau6.getPile().get(0).getSuit());
		assertEquals(11, model.tableau6.getPile().get(1).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau6.getPile().get(1).getSuit());
		assertEquals(12, model.tableau6.getPile().get(2).getFaceValue());
		assertEquals(Suit.Spades, model.tableau6.getPile().get(2).getSuit());
		assertEquals(13, model.tableau6.getPile().get(3).getFaceValue());
		assertEquals(Suit.Diamonds, model.tableau6.getPile().get(3).getSuit());
		//Check tableau 5 is now empty
		assertEquals(0, model.tableau5.getPile().size());
		
		
		//SITUATION: When moving one face up card onto another pile
		//Add cards to the receiving pile
		model.tableau3.acceptCard(new CardImpl(Suit.Spades, 6));
		model.tableau3.getPile().get(0).setSide(Side.FaceUp);
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 5));
		model.tableau3.getPile().get(0).setSide(Side.FaceUp);
		model.tableau3.acceptCard(new CardImpl(Suit.Spades, 4));
		model.tableau3.getPile().get(0).setSide(Side.FaceUp);
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 3));
		model.tableau3.getPile().get(0).setSide(Side.FaceUp);
		//Add cards to the sending pile
		model.tableau1.acceptCard(new CardImpl(Suit.Diamonds, 5));
		model.tableau1.getPile().get(0).setSide(Side.FaceDown);
		model.tableau1.acceptCard(new CardImpl(Suit.Hearts, 4));
		model.tableau1.getPile().get(0).setSide(Side.FaceDown);
		model.tableau1.acceptCard(new CardImpl(Suit.Clubs, 2));
		model.tableau1.getPile().get(0).setSide(Side.FaceUp);
		model.tableauToTableau(1, 3);
		//Check the 2 was moved onto tableau 3
		assertEquals(2, model.tableau3.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau3.getPile().get(0).getSuit());
		//Check tableau 1 only has the 2 face down cards now
		assertEquals(2, model.tableau1.getPile().size());
		
				
		//SITUATION: When moving multiple face up cards onto another pile
		model.tableau5.acceptCard(new CardImpl(Suit.Clubs, 6));
		model.tableau5.getPile().get(0).setSide(Side.FaceDown);
		model.tableau5.acceptCard(new CardImpl(Suit.Spades, 1));
		model.tableau5.getPile().get(0).setSide(Side.FaceDown);
		model.tableau5.acceptCard(new CardImpl(Suit.Diamonds, 12));
		model.tableau5.getPile().get(0).setSide(Side.FaceDown);
		model.tableau5.acceptCard(new CardImpl(Suit.Diamonds, 11));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		model.tableau5.acceptCard(new CardImpl(Suit.Clubs, 10));
		model.tableau5.getPile().get(0).setSide(Side.FaceUp);
		//Add cards to receiving pile
		model.tableau7.acceptCard(new CardImpl(Suit.Clubs, 7));
		model.tableau7.getPile().get(0).setSide(Side.FaceDown);
		model.tableau7.acceptCard(new CardImpl(Suit.Clubs, 12));
		model.tableau7.getPile().get(0).setSide(Side.FaceUp);
		model.tableauToTableau(5, 7);
		//Check the Jack and 10 were moved onto tableau 7
		assertEquals(10, model.tableau7.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau7.getPile().get(0).getSuit());
		assertEquals(11, model.tableau7.getPile().get(1).getFaceValue());
		assertEquals(Suit.Diamonds, model.tableau7.getPile().get(1).getSuit());
		assertEquals(4, model.tableau7.getPile().size());
		//Check that tableau 5 only has the 3 face down cards now
		assertEquals(3, model.tableau5.getPile().size());
		
	}
	
	@Test
	public void testFoundationToTableau() {
		//Add cards to the Foundation
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 1));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 1));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 1));
		
		//Add cards to some tableau piles
		model.tableau1.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.tableau2.acceptCard(new CardImpl(Suit.Clubs, 2));
		model.tableau3.acceptCard(new CardImpl(Suit.Hearts, 2));
		model.tableau4.acceptCard(new CardImpl(Suit.Spades, 2));
		
		model.foundationToTableau(Suit.Clubs, 1);
		model.foundationToTableau(Suit.Diamonds, 2);
		model.foundationToTableau(Suit.Hearts, 4);
		model.foundationToTableau(Suit.Spades, 3);
		
		//Check the cards moved to the respective tableau piles
		assertEquals(1, model.tableau1.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau1.getPile().get(0).getSuit());
		
		assertEquals(1, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.tableau2.getPile().get(0).getSuit());
		
		assertEquals(1, model.tableau3.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.tableau3.getPile().get(0).getSuit());
		
		assertEquals(1, model.tableau4.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau4.getPile().get(0).getSuit());
		
		//Add the kings to the Foundation
		model.foundationClubs.acceptCard(new CardImpl(Suit.Clubs, 13));
		model.foundationDiamonds.acceptCard(new CardImpl(Suit.Diamonds, 13));
		model.foundationHearts.acceptCard(new CardImpl(Suit.Hearts, 13));
		model.foundationSpades.acceptCard(new CardImpl(Suit.Spades, 13));
		//Clear some of the Tableau
		model.tableau1.getPile().clear();
		model.tableau2.getPile().clear();
		
		//Move the King of Clubs from the Foundation to Tableau 1
		model.foundationToTableau(Suit.Clubs, 1);
		assertEquals(1, model.tableau1.getPile().size());
		assertEquals(13, model.tableau1.getPile().get(0).getFaceValue());
		assertEquals(Suit.Clubs, model.tableau1.getPile().get(0).getSuit());
		
		//Try to move the King of Diamonds from the Foundation to Tableau 3 (invalid move)
		model.foundationToTableau(Suit.Diamonds, 3);
		assertEquals(2, model.tableau3.getPile().size());
		assertEquals(1, model.tableau3.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.tableau3.getPile().get(0).getSuit());
		
		//Move to Tableau 2 instead
		model.foundationToTableau(Suit.Diamonds, 2);
		assertEquals(1, model.tableau2.getPile().size());
		assertEquals(13, model.tableau2.getPile().get(0).getFaceValue());
		assertEquals(Suit.Diamonds, model.tableau2.getPile().get(0).getSuit());
		
		//Attempt invalid move from Hearts Foundation to Tableau 4
		model.foundationToTableau(Suit.Hearts, 4);
		assertEquals(2, model.tableau4.getPile().size());
		assertEquals(1, model.tableau4.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau4.getPile().get(0).getSuit());
		
		//Move to Tableau 5 instead
		model.foundationToTableau(Suit.Hearts, 5);
		assertEquals(1, model.tableau5.getPile().size());
		assertEquals(13, model.tableau5.getPile().get(0).getFaceValue());
		assertEquals(Suit.Hearts, model.tableau5.getPile().get(0).getSuit());
		
		//Move the King of Spades to Tableau 6
		model.foundationToTableau(Suit.Spades, 6);
		assertEquals(1, model.tableau6.getPile().size());
		assertEquals(13, model.tableau6.getPile().get(0).getFaceValue());
		assertEquals(Suit.Spades, model.tableau6.getPile().get(0).getSuit());
	}
	
	@Test
	public void testWasteToDeck() {
		//Empty the deck
		for (int i = 0; i < 52; i++) {
			model.deck.getPile().remove(0);
		}
		
		//Add cards to the Waste
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 1));
		model.waste.acceptCard(new CardImpl(Suit.Diamonds, 2));
		model.waste.acceptCard(new CardImpl(Suit.Hearts, 3));
		model.waste.acceptCard(new CardImpl(Suit.Spades, 4));
		model.waste.acceptCard(new CardImpl(Suit.Clubs, 5));
		
		model.wasteToDeck();
		//Check the cards are now in the deck
		assertEquals(5, model.deck.getPile().size());
		assertEquals(Suit.Clubs, model.deck.getPile().get(0).getSuit());
		assertEquals(1, model.deck.getPile().get(0).getFaceValue());
		
		assertEquals(3, model.deck.getPile().get(2).getFaceValue());
		
	}
	
	

}




