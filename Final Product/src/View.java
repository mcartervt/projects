import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextPane;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * The View handles what the user sees when playing the Solitaire game
 */
@SuppressWarnings("serial") //Prevents the serial warning
public class View extends JFrame {

	// Instance Variables
	private Model model;//BAD MVC!!!
	
	//setup a timer object
	private Timer timer;
	
	private String lastClicked;
		
	private ArrayList<GameBoardCardObject> deckImage;
	private ArrayList<GameBoardCardObject> wasteImages;
	
	private ArrayList<GameBoardCardObject> tableau1Images;
	private ArrayList<GameBoardCardObject> tableau2Images;
	private ArrayList<GameBoardCardObject> tableau3Images;
	private ArrayList<GameBoardCardObject> tableau4Images;
	private ArrayList<GameBoardCardObject> tableau5Images;
	private ArrayList<GameBoardCardObject> tableau6Images;
	private ArrayList<GameBoardCardObject> tableau7Images;
	
	private ArrayList<GameBoardCardObject> clubsFoundationImages;
	private ArrayList<GameBoardCardObject> diamondsFoundationImages;
	private ArrayList<GameBoardCardObject> heartsFoundationImages;
	private ArrayList<GameBoardCardObject> spadesFoundationImages;
	
	private ArrayList<GameBoardCardObject> suitImages;
	
	private ArrayList<GameBoardCardObject> click1Images;

	View() {
		model = new Model();//BAD MVC!!!
		model.setup();//BAD MVC!!!
		
		lastClicked = "";
				
		this.deckImage = new ArrayList<GameBoardCardObject>();
		this.wasteImages = new ArrayList<GameBoardCardObject>();
		
		this.tableau1Images = new ArrayList<GameBoardCardObject>();
		this.tableau2Images = new ArrayList<GameBoardCardObject>();
		this.tableau3Images = new ArrayList<GameBoardCardObject>();
		this.tableau4Images = new ArrayList<GameBoardCardObject>();
		this.tableau5Images = new ArrayList<GameBoardCardObject>();
		this.tableau6Images = new ArrayList<GameBoardCardObject>();
		this.tableau7Images = new ArrayList<GameBoardCardObject>();
		
		this.clubsFoundationImages = new ArrayList<GameBoardCardObject>();
		this.diamondsFoundationImages = new ArrayList<GameBoardCardObject>();
		this.heartsFoundationImages = new ArrayList<GameBoardCardObject>();
		this.spadesFoundationImages = new ArrayList<GameBoardCardObject>();
		
		this.suitImages = new ArrayList<GameBoardCardObject>();
		
		this.click1Images = new ArrayList<GameBoardCardObject>();

		getContentPane().setBackground(new Color(51, 204, 51));
		getContentPane().setLayout(null);

		
		// Place for messages to the user
		JTextPane textPane_MessageBoard = new JTextPane();
		textPane_MessageBoard.setBounds(495, 12, 202, 140);
		getContentPane().add(textPane_MessageBoard);

		// Foundation piles
		JPanel panel_Clubs = new JPanel();
		panel_Clubs.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Clubs Foundation
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.waste.getPile().get(0).getSuit() == Suit.Clubs && model.wastetoFoundationCondition(model.foundationClubs)) {
					//then add the image to the Foundation pile
					try {
						clubsFoundationImages.add(0, new GameBoardCardObject(11, 12, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToFoundation();
					wasteImages.remove(0);
					
				}
				//If the previous click was in the Tableau
				else if (lastClicked == "tableau1" && model.tableauToFoundationCondition(model.tableau1, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau1, 1, tableau1Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau2" && model.tableauToFoundationCondition(model.tableau2, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau2, 2, tableau2Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau3" && model.tableauToFoundationCondition(model.tableau3, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau3, 3, tableau3Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau4" && model.tableauToFoundationCondition(model.tableau4, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau4, 4, tableau4Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau5" && model.tableauToFoundationCondition(model.tableau5, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau5, 5, tableau5Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau6" && model.tableauToFoundationCondition(model.tableau6, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau6, 6, tableau6Images, Suit.Clubs, clubsFoundationImages);
				}
				else if (lastClicked == "tableau7" && model.tableauToFoundationCondition(model.tableau7, model.foundationClubs)) {
					tableauToFoundationHelper(model.tableau7, 7, tableau7Images, Suit.Clubs, clubsFoundationImages);
				}
				//If last clicked wasn't the waste or a tableau pile (foundationToTableau)
				else {
					//then copy the top foundation image to the click1Images list
					click1Images.clear();
					}
				//Recored the clicked location
				lastClicked = "clubs";
			}
		});
		panel_Clubs.setBackground(new Color(51, 204, 51));
		panel_Clubs.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_Clubs.setBounds(11, 12, 100, 140);
		getContentPane().add(panel_Clubs);
		panel_Clubs.setLayout(null);
		

		JPanel panel_Diamonds = new JPanel();
		panel_Diamonds.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Clubs Foundation
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.waste.getPile().get(0).getSuit() == Suit.Diamonds && model.wastetoFoundationCondition(model.foundationDiamonds)) {
					//then add the image to the Foundation pile
					try {
						diamondsFoundationImages.add(0, new GameBoardCardObject(132, 12, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToFoundation();
					wasteImages.remove(0);			
				}
				//If the previous click was in the Tableau
				else if (lastClicked == "tableau1" && model.tableauToFoundationCondition(model.tableau1, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau1, 1, tableau1Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau2" && model.tableauToFoundationCondition(model.tableau2, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau2, 2, tableau2Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau3" && model.tableauToFoundationCondition(model.tableau3, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau3, 3, tableau3Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau4" && model.tableauToFoundationCondition(model.tableau4, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau4, 4, tableau4Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau5" && model.tableauToFoundationCondition(model.tableau5, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau5, 5, tableau5Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau6" && model.tableauToFoundationCondition(model.tableau6, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau6, 6, tableau6Images, Suit.Diamonds, diamondsFoundationImages);
				}
				else if (lastClicked == "tableau7" && model.tableauToFoundationCondition(model.tableau7, model.foundationDiamonds)) {
					tableauToFoundationHelper(model.tableau7, 7, tableau7Images, Suit.Diamonds, diamondsFoundationImages);
				}
				//If last clicked wasn't the waste or a tableau pile (foundationToTableau)
				else {
					//then copy the top foundation image to the click1Images list
					click1Images.clear();					
				}
				//Recored the clicked location
				lastClicked = "diamonds";
			}
		});
		panel_Diamonds.setBackground(new Color(51, 204, 51));
		panel_Diamonds.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Diamonds.setBounds(132, 12, 100, 140);
		getContentPane().add(panel_Diamonds);
		panel_Diamonds.setLayout(null);

		JPanel panel_Hearts = new JPanel();
		panel_Hearts.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Clubs Foundation
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.waste.getPile().get(0).getSuit() == Suit.Hearts && model.wastetoFoundationCondition(model.foundationHearts)) {
					//then add the image to the Foundation pile
					try {
						heartsFoundationImages.add(0, new GameBoardCardObject(253, 12, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToFoundation();
					wasteImages.remove(0);			
				}
				//If the previous click was in the Tableau
				else if (lastClicked == "tableau1" && model.tableauToFoundationCondition(model.tableau1, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau1, 1, tableau1Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau2" && model.tableauToFoundationCondition(model.tableau2, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau2, 2, tableau2Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau3" && model.tableauToFoundationCondition(model.tableau3, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau3, 3, tableau3Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau4" && model.tableauToFoundationCondition(model.tableau4, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau4, 4, tableau4Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau5" && model.tableauToFoundationCondition(model.tableau5, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau5, 5, tableau5Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau6" && model.tableauToFoundationCondition(model.tableau6, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau6, 6, tableau6Images, Suit.Hearts, heartsFoundationImages);
				}
				else if (lastClicked == "tableau7" && model.tableauToFoundationCondition(model.tableau7, model.foundationHearts)) {
					tableauToFoundationHelper(model.tableau7, 7, tableau7Images, Suit.Hearts, heartsFoundationImages);
				}
				//If last clicked wasn't the waste or a tableau pile (foundationToTableau)
				else {
					//then copy the top foundation image to the click1Images list
					click1Images.clear();					
				}
				//Recored the clicked location
				lastClicked = "hearts";
			}
		});
		panel_Hearts.setBackground(new Color(51, 204, 51));
		panel_Hearts.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Hearts.setBounds(253, 12, 100, 140);
		getContentPane().add(panel_Hearts);
		panel_Hearts.setLayout(null);

		JPanel panel_Spades = new JPanel();
		panel_Spades.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Clubs Foundation
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.waste.getPile().get(0).getSuit() == Suit.Spades && model.wastetoFoundationCondition(model.foundationSpades)) {
					//then add the image to the Foundation pile
					try {
						spadesFoundationImages.add(0, new GameBoardCardObject(374, 12, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToFoundation();
					wasteImages.remove(0);			
				}
				//If the previous click was in the Tableau
				else if (lastClicked == "tableau1" && model.tableauToFoundationCondition(model.tableau1, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau1, 1, tableau1Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau2" && model.tableauToFoundationCondition(model.tableau2, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau2, 2, tableau2Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau3" && model.tableauToFoundationCondition(model.tableau3, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau3, 3, tableau3Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau4" && model.tableauToFoundationCondition(model.tableau4, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau4, 4, tableau4Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau5" && model.tableauToFoundationCondition(model.tableau5, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau5, 5, tableau5Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau6" && model.tableauToFoundationCondition(model.tableau6, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau6, 6, tableau6Images, Suit.Spades, spadesFoundationImages);
				}
				else if (lastClicked == "tableau7" && model.tableauToFoundationCondition(model.tableau7, model.foundationSpades)) {
					tableauToFoundationHelper(model.tableau7, 7, tableau7Images, Suit.Spades, spadesFoundationImages);
				}
				//If last clicked wasn't the waste or a tableau pile (foundationToTableau)
				else {
					//then copy the top foundation image to the click1Images list
					click1Images.clear();					
				}
				//Recored the clicked location
				lastClicked = "spades";
			}
		});
		panel_Spades.setBackground(new Color(51, 204, 51));
		panel_Spades.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Spades.setBounds(374, 12, 100, 140);
		getContentPane().add(panel_Spades);
		panel_Spades.setLayout(null);
		
		// Deck pile
		JPanel panel_Deck = new JPanel();
		panel_Deck.addMouseListener(new MouseAdapter() {
			@Override
			//When the mouse is clicked over the deck JPanel
			public void mouseClicked(MouseEvent e) {
				//Clear the pressedImages list
				int pressedSize = click1Images.size();
				if (pressedSize > 0) {
					for (int i = 0; i < pressedSize; i++) {
						click1Images.remove(0);
					}
				}
				//Check if there's no card back image in the deck JPanel area
				if (deckImage.size() == 0) {
					try {
						//Add a card back image to the deck JPanel area if there isn't one
						deckImage.add(0, new GameBoardCardObject(839, 12, ImageIO.read(new File("Card_Back.png")), 100, 140));
					}
					catch(IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
				}
				
				//If the deck is empty,
				if (model.deck.getPile().size() == 0) {
					//then the waste becomes the deck (recycle cards)
					model.wasteToDeck();
					//Remove all the images from the Waste area
					wasteImages.clear();
				}
				else {				
					//Move the top card of the deck to the waste pile
					model.deckToWaste();
					//Make the top card of the waste faceup
					model.waste.getPile().get(0).setSide(Side.FaceUp);
					//Show the top card image of the waste pile
					String topCardImage = model.waste.getPile().get(0).getImage();
					
					try {
						//Add a GameBoardCardObject to the ArrayList in the top deck card jpanel area
						wasteImages.add(0, new GameBoardCardObject(718, 12, ImageIO.read(new File(topCardImage)), 100, 140));
					}
					catch(IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}		
				}
				
				//Recored the clicked location
				lastClicked = "deck";
				
				//If the deck is empty after the click
				if (model.deck.getPile().size() == 0) {
					//then remove the card back image from the deck area
					for (int i = 0; i < deckImage.size(); i++) {
						deckImage.remove(0);
					}
				}
			}
		});
		panel_Deck.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Deck.setBackground(new Color(51, 204, 51));
		panel_Deck.setBounds(839, 12, 100, 140);
		getContentPane().add(panel_Deck);
		panel_Deck.setLayout(null);

		// Top card of the deck showing face up
		JPanel panel_Top_Deck_Card_FaceUp = new JPanel();		
		panel_Top_Deck_Card_FaceUp.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse pressed in the Waste pile
			public void mouseClicked(MouseEvent e) {
				//then copy that image to the click1Images list
				click1Images.clear();
				
				//Recored the clicked location
				lastClicked = "waste";
			}
		});
		panel_Top_Deck_Card_FaceUp.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Top_Deck_Card_FaceUp.setBackground(new Color(51, 204, 51));
		panel_Top_Deck_Card_FaceUp.setBounds(718, 12, 100, 140);
		getContentPane().add(panel_Top_Deck_Card_FaceUp);
		panel_Top_Deck_Card_FaceUp.setLayout(null);

		// Tableau piles
		JPanel panel_Tableau1 = new JPanel();
		panel_Tableau1.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {				
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau1)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau1Images.size();
					try {
						tableau1Images.add(0, new GameBoardCardObject(11, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(1);
					wasteImages.remove(0);			
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau1)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 1, tableau1Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau1)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 1, tableau1Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau1)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 1, tableau1Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau1)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 1, tableau1Images);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau1)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau1Images, 1);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau1)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau1Images, 1);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau1)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau1Images, 1);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau1)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau1Images, 1);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau1)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau1Images, 1);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau1)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau1Images, 1);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau1";
			}
		});
		panel_Tableau1.setBackground(new Color(51, 204, 51));
		panel_Tableau1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_Tableau1.setBounds(11, 178, 100, 140);
		getContentPane().add(panel_Tableau1);
		panel_Tableau1.setLayout(null);

		JPanel panel_Tableau2 = new JPanel();
		panel_Tableau2.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau2)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau2Images.size();
					try {
						tableau2Images.add(0, new GameBoardCardObject(149, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(2);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau2)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 2, tableau2Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau2)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 2, tableau2Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau2)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 2, tableau2Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau2)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 2, tableau2Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau2)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau2Images, 2);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau2)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau2Images, 2);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau2)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau2Images, 2);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau2)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau2Images, 2);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau2)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau2Images, 2);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau2)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau2Images, 2);
				}
				//If the top card is facedown
				if (model.tableau2.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau2, tableau2Images, 2);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau2";
			}
		});
		panel_Tableau2.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau2.setBackground(new Color(51, 204, 51));
		panel_Tableau2.setBounds(149, 178, 100, 140);
		getContentPane().add(panel_Tableau2);
		panel_Tableau2.setLayout(null);

		JPanel panel_Tableau3 = new JPanel();
		panel_Tableau3.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau3)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau3Images.size();
					try {
						tableau3Images.add(0, new GameBoardCardObject(287, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(3);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau3)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 3, tableau3Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau3)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 3, tableau3Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau3)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 3, tableau3Images);
				}
				//If the previous click was in the spades foundation
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau3)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 3, tableau3Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau3)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau3Images, 3);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau3)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau3Images, 3);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau3)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau3Images, 3);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau3)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau3Images, 3);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau3)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau3Images, 3);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau3)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau3Images, 3);
				}
				//If the top card is facedown
				else if (model.tableau3.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau3, tableau3Images, 3);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau3";
			}
		});
		panel_Tableau3.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau3.setBackground(new Color(51, 204, 51));
		panel_Tableau3.setBounds(287, 178, 100, 140);
		getContentPane().add(panel_Tableau3);
		panel_Tableau3.setLayout(null);

		JPanel panel_Tableau4 = new JPanel();
		panel_Tableau4.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau4)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau4Images.size();
					try {
						tableau4Images.add(0, new GameBoardCardObject(425, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(4);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau4)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 4, tableau4Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau4)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 4, tableau4Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau4)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 4, tableau4Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau4)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 4, tableau4Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau4)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau4Images, 4);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau4)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau4Images, 4);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau4)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau4Images, 4);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau4)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau4Images, 4);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau4)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau4Images, 4);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau4)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau4Images, 4);
				}
				//If the top card is face down
				else if (model.tableau4.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau4, tableau4Images, 4);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau4";
			}
		});
		panel_Tableau4.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau4.setBackground(new Color(51, 204, 51));
		panel_Tableau4.setBounds(425, 178, 100, 140);
		getContentPane().add(panel_Tableau4);
		panel_Tableau4.setLayout(null);

		JPanel panel_Tableau5 = new JPanel();
		panel_Tableau5.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau5)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau5Images.size();
					try {
						tableau5Images.add(0, new GameBoardCardObject(563, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(5);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau5)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 5, tableau5Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau5)) {
					foundationToTableauHelper(model.foundationDiamonds, clubsFoundationImages, 5, tableau5Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau5)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 5, tableau5Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau5)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 5, tableau5Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau5)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau5Images, 5);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau5)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau5Images, 5);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau5)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau5Images, 5);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau5)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau5Images, 5);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau5)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau5Images, 5);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau5)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau5Images, 5);
				}
				//If the top card is face down
				else if (model.tableau5.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau5, tableau5Images, 5);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau5";
			}
		});
		panel_Tableau5.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau5.setBackground(new Color(51, 204, 51));
		panel_Tableau5.setBounds(563, 178, 100, 140);
		getContentPane().add(panel_Tableau5);
		panel_Tableau5.setLayout(null);

		JPanel panel_Tableau6 = new JPanel();
		panel_Tableau6.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau6)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau6Images.size();
					try {
						tableau6Images.add(0, new GameBoardCardObject(701, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(6);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau6)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 6, tableau6Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau6)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 6, tableau6Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau6)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 6, tableau6Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau6)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 6, tableau6Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau6)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau6Images, 6);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau6)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau6Images, 6);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau6)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau6Images, 6);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau6)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau6Images, 6);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau6)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau6Images, 6);
				}
				//If the previous click was in Tableau 7
				else if (lastClicked == "tableau7" && model.tableauToTableauCondition(model.tableau7, model.tableau6)) {
					tableauToTableauHelper(model.tableau7, tableau7Images, 7, tableau6Images, 6);
				}
				//If the top card is face down
				else if (model.tableau6.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau6, tableau6Images, 6);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau6";
			}
		});
		panel_Tableau6.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau6.setBackground(new Color(51, 204, 51));
		panel_Tableau6.setBounds(701, 178, 100, 140);
		getContentPane().add(panel_Tableau6);
		panel_Tableau6.setLayout(null);

		JPanel panel_Tableau7 = new JPanel();
		panel_Tableau7.addMouseListener(new MouseAdapter() {
			@Override
			//If mouse clicked in the Tableau 5
			public void mouseClicked(MouseEvent e) {
				//If the previous click was in the waste
				if (lastClicked == "waste" && model.wastetoTableauCondition(model.tableau7)) {
					//then add the image to the Tableau pile
					int numCardImages = tableau7Images.size();
					try {
						tableau7Images.add(0, new GameBoardCardObject(839, 178 + numCardImages * 15, ImageIO.read(new File(model.waste.getPile().get(0).getImage())), 100, 140));
					}
					catch (IOException IE) {
						textPane_MessageBoard.setText("Unable to load image\n");
					}
					
					//Remove from the waste
					model.wasteToTableau(7);
					wasteImages.remove(0);				
				}
				//If the previous click was in the clubs foundation
				else if (lastClicked == "clubs" && model.foundationToTableauCondition(model.foundationClubs, model.tableau7)) {
					foundationToTableauHelper(model.foundationClubs, clubsFoundationImages, 7, tableau7Images);				
				}
				//If the previous click was in the diamonds foundation
				else if (lastClicked == "diamonds" && model.foundationToTableauCondition(model.foundationDiamonds, model.tableau7)) {
					foundationToTableauHelper(model.foundationDiamonds, diamondsFoundationImages, 7, tableau7Images);					
				}
				//If the previous click was in the hearts foundation
				else if (lastClicked == "hearts" && model.foundationToTableauCondition(model.foundationHearts, model.tableau7)) {
					foundationToTableauHelper(model.foundationHearts, heartsFoundationImages, 7, tableau7Images);
				}
				else if (lastClicked == "spades" && model.foundationToTableauCondition(model.foundationSpades, model.tableau7)) {
					foundationToTableauHelper(model.foundationSpades, spadesFoundationImages, 7, tableau7Images);
				}
				//If the previous click was in Tableau 1
				else if (lastClicked == "tableau1" && model.tableauToTableauCondition(model.tableau1, model.tableau7)) {
					tableauToTableauHelper(model.tableau1, tableau1Images, 1, tableau7Images, 7);
				}
				//If the previous click was in Tableau 2
				else if (lastClicked == "tableau2" && model.tableauToTableauCondition(model.tableau2, model.tableau7)) {
					tableauToTableauHelper(model.tableau2, tableau2Images, 2, tableau7Images, 7);
				}
				//If the previous click was in Tableau 3
				else if (lastClicked == "tableau3" && model.tableauToTableauCondition(model.tableau3, model.tableau7)) {
					tableauToTableauHelper(model.tableau3, tableau3Images, 3, tableau7Images, 7);
				}
				//If the previous click was in Tableau 4
				else if (lastClicked == "tableau4" && model.tableauToTableauCondition(model.tableau4, model.tableau7)) {
					tableauToTableauHelper(model.tableau4, tableau4Images, 4, tableau7Images, 7);
				}
				//If the previous click was in Tableau 5
				else if (lastClicked == "tableau5" && model.tableauToTableauCondition(model.tableau5, model.tableau7)) {
					tableauToTableauHelper(model.tableau5, tableau5Images, 5, tableau7Images, 7);
				}
				//If the previous click was in Tableau 6
				else if (lastClicked == "tableau6" && model.tableauToTableauCondition(model.tableau6, model.tableau7)) {
					tableauToTableauHelper(model.tableau6, tableau6Images, 6, tableau7Images, 7);
				}
				//If the top card is face down
				else if (model.tableau7.getPile().get(0).getSide() == Side.FaceDown) {
					flipCardOver(model.tableau7, tableau7Images, 7);
				}
				//If last clicked wasn't the waste, foundation, or other tableau pile (tableauToFoundation)
				else {
					//then copy the top tableau image to the click1Images list
					click1Images.clear();
				}
				
				//Recored the clicked location
				lastClicked = "tableau7";
			}
		});
		panel_Tableau7.setBorder(new LineBorder(Color.WHITE, 2));
		panel_Tableau7.setBackground(new Color(51, 204, 51));
		panel_Tableau7.setBounds(839, 178, 100, 140);
		getContentPane().add(panel_Tableau7);
		panel_Tableau7.setLayout(null);


		try {
			//Add GameBoardCardBack objects to the ArrayList in the appropriate positions
			//Deck position
			this.deckImage.add(new GameBoardCardObject(839, 12, ImageIO.read(new File("Card_Back.png")), 100, 140));
			
			//Add base suit images to the Foundation
			this.suitImages.add(new GameBoardCardObject(11, 32, ImageIO.read(new File("clubs.png")), 100, 100));
			this.suitImages.add(new GameBoardCardObject(132, 32, ImageIO.read(new File("diamonds.png")), 100, 100));
			this.suitImages.add(new GameBoardCardObject(253, 32, ImageIO.read(new File("hearts.png")), 100, 100));
			this.suitImages.add(new GameBoardCardObject(374, 32, ImageIO.read(new File("spades.png")), 100, 100));

			//Tableau positions
			
			//Make an ArrayList of the Tableau Image Lists
			ArrayList<ArrayList<GameBoardCardObject>> tableauPiles = new ArrayList<ArrayList<GameBoardCardObject>>();
			tableauPiles.add(this.tableau2Images);
			tableauPiles.add(this.tableau3Images);
			tableauPiles.add(this.tableau4Images);
			tableauPiles.add(this.tableau5Images);
			tableauPiles.add(this.tableau6Images);
			tableauPiles.add(this.tableau7Images);
			
			//Base layer
			int j = 0;
			this.tableau2Images.add(0, new GameBoardCardObject(149, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau3Images.add(0, new GameBoardCardObject(287, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau4Images.add(0, new GameBoardCardObject(425, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau5Images.add(0, new GameBoardCardObject(563, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau6Images.add(0, new GameBoardCardObject(701, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			
			//Second layer
			j = 1;
			this.tableau3Images.add(0, new GameBoardCardObject(287, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau4Images.add(0, new GameBoardCardObject(425, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau5Images.add(0, new GameBoardCardObject(563, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau6Images.add(0, new GameBoardCardObject(701, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			
			//Third layer
			j = 2;
			this.tableau4Images.add(0, new GameBoardCardObject(425, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau5Images.add(0, new GameBoardCardObject(563, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau6Images.add(0, new GameBoardCardObject(701, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			
			//Fourth layer
			j = 3;
			this.tableau5Images.add(0, new GameBoardCardObject(563, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau6Images.add(0, new GameBoardCardObject(701, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			 
			//Fifth layer
			j = 4;
			this.tableau6Images.add(0, new GameBoardCardObject(701, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			
			//Sixth layer
			j = 5;
			this.tableau7Images.add(0, new GameBoardCardObject(839, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));


			//BAD MVC!!!
			//Add the top card images
			this.tableau1Images.add(0, new GameBoardCardObject(11, 178, ImageIO.read(new File(model.tableau1.getPile().get(0).getImage())), 100, 140));
			this.tableau2Images.add(0, new GameBoardCardObject(149, 193, ImageIO.read(new File(model.tableau2.getPile().get(0).getImage())), 100, 140));
			this.tableau3Images.add(0, new GameBoardCardObject(287, 208, ImageIO.read(new File(model.tableau3.getPile().get(0).getImage())), 100, 140));
			this.tableau4Images.add(0, new GameBoardCardObject(425, 223, ImageIO.read(new File(model.tableau4.getPile().get(0).getImage())), 100, 140));
			this.tableau5Images.add(0, new GameBoardCardObject(563, 238, ImageIO.read(new File(model.tableau5.getPile().get(0).getImage())), 100, 140));
			this.tableau6Images.add(0, new GameBoardCardObject(701, 253, ImageIO.read(new File(model.tableau6.getPile().get(0).getImage())), 100, 140));
			this.tableau7Images.add(0, new GameBoardCardObject(839, 268, ImageIO.read(new File(model.tableau7.getPile().get(0).getImage())), 100, 140));
		} 
		catch (IOException IE) {
			textPane_MessageBoard.setText("Unable to load image\n");
		}

		// Print a welcome massage
		textPane_MessageBoard.setText(textPane_MessageBoard.getText() + "Hello, welcome to Solitaire!\n");


		// Timer loops and draws the images
		timer = new Timer(500, new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  				
				  //Draw the top Waste image
				  if (wasteImages.size() != 0) {
					  wasteImages.get(0).drawImage(getContentPane().getGraphics());
				  }
				  else {
					  	clearArea(718, 12, 100, 140);
					  	//Redraw the JPanel
					  	panel_Top_Deck_Card_FaceUp.setBorder(new LineBorder(Color.WHITE, 2));
					  }
				  
				  //Draw the card back image for the deck
				  if (deckImage.size() != 0) {
					  for (GameBoardCardObject temp : deckImage) {
						  temp.drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  clearArea(839, 12, 100, 140);
					  //Redraw the JPanel
					  panel_Deck.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  				  
				  //Clear the tableau areas and draw the tableau images
				  clearArea(11, 178, 100, 472);
				  //If there're images in the Tableau 1 ArrayList
				  if (tableau1Images.size() != 0) {
					  //Draw the images
					  for (int i = tableau1Images.size(); i > 0; i--) {
						  tableau1Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau1.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				
				  clearArea(148, 178, 100, 472);
				  //If there're images in the Tableau 2 ArrayList
				  if (tableau2Images.size() != 0) {
					  for (int i = tableau2Images.size(); i > 0; i--) {
						  tableau2Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau2.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  clearArea(287, 178, 100, 472);
				  //If there're images in the Tableau 3 ArrayList
				  if (tableau3Images.size() != 0) {
					  for (int i = tableau3Images.size(); i > 0; i--) {
						  tableau3Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau3.setBorder(new LineBorder(Color.WHITE, 2)); 
				  }
				  
				  clearArea(425, 178, 100, 472);
				  //If there're images in the Tableau 4 ArrayList
				  if (tableau4Images.size() != 0) {
					  for (int i = tableau4Images.size(); i > 0; i--) {
						  tableau4Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau4.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  clearArea(563, 178, 100, 472);
				  //If there're images in the Tableau 5 ArrayList
				  if (tableau5Images.size() != 0) {
					  for (int i = tableau5Images.size(); i > 0; i--) {
						  tableau5Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau5.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  clearArea(701, 178, 100, 472);
				  //If there're images in the Tableau 6 ArrayList
				  if (tableau6Images.size() != 0) {
					  for (int i = tableau6Images.size(); i > 0; i--) {
						  tableau6Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau6.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  clearArea(839, 178, 100, 472);
				  //If there're images in the Tableau 7 ArrayList
				  if (tableau7Images.size() != 0) {
					  for (int i = tableau7Images.size(); i > 0; i--) {
						  tableau7Images.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //redraw the JPanel
					  panel_Tableau7.setBorder(new LineBorder(Color.WHITE, 2));
				  }
				  
				  
				  //Draw the Foundation images
				  clearArea(11, 12, 100, 140);
				  //If there're images in the Clubs ArrayList
				  if (clubsFoundationImages.size() != 0) {
					  //Draw the images
					  for (int i = clubsFoundationImages.size(); i > 0; i--) {
						  clubsFoundationImages.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //Clear the last image
					  //clearArea(11, 12, 100, 140);
					  //and redraw the JPanel
					  panel_Clubs.setBorder(new LineBorder(Color.WHITE, 2));
					  //draw the base suit image
					  suitImages.get(0).drawImage(getContentPane().getGraphics());
				  }
				  
				  clearArea(132, 12, 100, 140);
				  //If there're images in the Diamonds ArrayList
				  if (diamondsFoundationImages.size() != 0) {
					  //Draw the images
					  for (int i = diamondsFoundationImages.size(); i > 0; i--) {
						  diamondsFoundationImages.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //Clear the last image
					  //clearArea(132, 12, 100, 140);
					  //and redraw the JPanel
					  panel_Diamonds.setBorder(new LineBorder(Color.WHITE, 2));
					  //draw the base suit image
					  suitImages.get(1).drawImage(getContentPane().getGraphics());
				  }
				  
				  clearArea(253, 12, 100, 140);
				  //If there're images in the Hearts ArrayList
				  if (heartsFoundationImages.size() != 0) {
					  //Draw the images
					  for (int i = heartsFoundationImages.size(); i > 0; i--) {
						  heartsFoundationImages.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //Clear the last image
					  //clearArea(253, 12, 100, 140);
					  //and redraw the JPanel
					  panel_Hearts.setBorder(new LineBorder(Color.WHITE, 2));
					  //draw the base suit image
					  suitImages.get(2).drawImage(getContentPane().getGraphics());
				  }
				  
				  clearArea(374, 12, 100, 140);
				  //If there're images in the Spades ArrayList
				  if (spadesFoundationImages.size() != 0) {
					  //Draw the images
					  for (int i = spadesFoundationImages.size(); i > 0; i--) {
						  spadesFoundationImages.get(i-1).drawImage(getContentPane().getGraphics());
					  }
				  }
				  else {
					  //Clear the last image
					  //clearArea(374, 12, 100, 140);
					  //and redraw the JPanel
					  panel_Spades.setBorder(new LineBorder(Color.WHITE, 2));
					  //draw the base suit image
					  suitImages.get(3).drawImage(getContentPane().getGraphics());
				  }
				  
				  
				  //Check if the user has won
				  if (model.hasWon()) {
					  textPane_MessageBoard.setText(textPane_MessageBoard.getText() + "You won!\n");
					  timer.stop();
				  }
			  
			  }
		});
		  
		  
		//Starts the timer
		timer.start();
		 

	}

	/**
	 * Flips a face down card in the Tableau face up
	 * 
	 * @param tableauPile the Tableau pile the face down card is in
	 * @param tableauImages the ArrayList of card image objects the face down 
	 * card image object needs to be removed from and the face up card image 
	 * object needs to be added to
	 * @param tableauPileNum the Tableau pile number the face down card is in
	 */
	private void flipCardOver(Tableau tableauPile, ArrayList<GameBoardCardObject> tableauImages, int tableauPileNum) {
		//Flip top card over 
		tableauPile.getPile().get(0).setSide(Side.FaceUp);
		//and replace the card object
		//Delete old card image object
		tableauImages.remove(0);
		
		//Add one with the face up image in its place
		int numCardImages = tableauImages.size();
		try {
			tableauImages.add(0, new GameBoardCardObject(149 + 138 * (tableauPileNum - 2), 178 + numCardImages * 15, ImageIO.read(new File(tableauPile.getPile().get(0).getImage())), 100, 140));
		}
		catch (IOException IE) {
			System.out.println("Unable to load image\n");
			//textPane_MessageBoard.setText("Unable to load image\n");
		}
	}
	
	/**
	 * Helps the click events move all face up cards from one Tableau pile to 
	 * another
	 * 
	 * @param sendingPile the Tableau pile the face up cards are being sent 
	 * from
	 * @param sendingImages the ArrayList of card image objects that belongs to
	 * the sending Tableau pile
	 * @param sendingPileNumber the Tableau pile number the cards are being 
	 * sent from 
	 * @param receivingImages the ArrayList of card image objects that belongs 
	 * to the receiving Tableau pile
	 * @param receivingPileNumber the Tableau pile number the cards are being 
	 * sent to
	 */
	private void tableauToTableauHelper(Tableau sendingPile, ArrayList<GameBoardCardObject> sendingImages, int sendingPileNumber, 
			ArrayList<GameBoardCardObject> receivingImages, int receivingPileNumber) {
		//Add the cards from the sending tableau pile to the receiving tableau pile
		int i = model.tableauToTableauViewHelper(sendingPile);
		//Add the last face up card
		while (i > -1) {
			try {
				receivingImages.add(0, new GameBoardCardObject(11 + (receivingPileNumber - 1) * 138, 178 + receivingImages.size() * 15, 
						ImageIO.read(new File(sendingPile.getPile().get(i).getImage())), 100, 140));
			}
			catch (IOException IE) {
				System.out.println("Unable to load image\n");
				//textPane_MessageBoard.setText("Unable to load image\n");
			}
			//Delete the card image
			sendingImages.remove(i);

			//and then go to the next faceup card
			i--;
		}
		
		//remove the cards from the sending tableau pile
		model.tableauToTableau(sendingPileNumber, receivingPileNumber);
	}
	
	/**
	 * Helps the click events move the top card from the provided Tableau pile 
	 * to the provided Foundation pile
	 * 
	 * @param sendingTableau the Tableau pile the card is being sent from
	 * @param tableauNumber the Tableau pile number the card is being sent from
	 * @param tableauImages the ArrayList of card image objects associated with
	 * the sending Tableau pile
	 * @param foundationSuit the suit of the Foundation pile the card is being 
	 * sent to
	 * @param foundationImages the ArrayList of card image objects associated 
	 * with the Foundation pile the card is being sent to
	 */
	private void tableauToFoundationHelper(Tableau sendingTableau, int tableauNumber, ArrayList<GameBoardCardObject> tableauImages, 
			Suit foundationSuit, ArrayList<GameBoardCardObject> foundationImages) {
			int foundationX = 11;
			//Determine the x-coordinate of the image based on the suit
			switch(foundationSuit) {
				case Clubs:
					foundationX = 11;
					break;
				case Diamonds:
					foundationX = 132;
					break;
				case Hearts:
					foundationX = 253;
					break;
				case Spades:
					foundationX = 374;
					break;
				default:
					System.out.println("Invalid suit!");
			}
			//then add the image to the Foundation pile
			try {
				foundationImages.add(0, new GameBoardCardObject(foundationX, 12, ImageIO.read(new File(sendingTableau.getPile().get(0).getImage())), 100, 140));
			}
			catch (IOException IE) {
				//textPane_MessageBoard.setText("Unable to load image\n");
				System.out.println("Unable to load image\n");
			}
			
			//Remove from the Tableau
			model.tableauToFoundation(tableauNumber, foundationSuit);
			tableauImages.remove(0);
	}
	
	/**
	 * Helps the click events move the top card from the provided Foundation 
	 * pile to the provided Tableau pile
	 * 
	 * @param sendingPile the Foundation pile the card is being sent from
	 * @param sendingImages the ArrayList of card image objects associated with
	 * the Foundation pile the card is coming from
	 * @param tableauNumber the Tableau pile number the card is being sent to
	 * @param receivingImages the ArrayList of card image objects associated 
	 * with the Tableau pile the card is being sent to
	 */
	private void foundationToTableauHelper(Foundation sendingPile, ArrayList<GameBoardCardObject> sendingImages,
			int tableauNumber, ArrayList<GameBoardCardObject> receivingImages) {
		
		//then add the image to the Tableau pile
		int numCardImages = receivingImages.size();
		try {
			receivingImages.add(0, new GameBoardCardObject(11 + (tableauNumber - 1) * 138, 178 + numCardImages * 15, 
					ImageIO.read(new File(sendingPile.getPile().get(0).getImage())), 100, 140));
		}
		catch (IOException IE) {
			System.out.println("Unable to load image\n");
			//textPane_MessageBoard.setText("Unable to load image\n");
		}
		
		//Remove from the foundation
		model.foundationToTableau(sendingPile.getSuit(), tableauNumber);
		sendingImages.remove(0);		
		
	}
	
	/**
	 * Clears the area based on the provided x and y-coordinate, width, and 
	 * height; fills it with a green rectangle of the same size
	 * 
	 * @param x the x-coordinate of the top left corner of the rectangle of the
	 * area to be cleared
	 * @param y the y-coordinate of the top left corner of the rectangle of the
	 * area to be cleared
	 * @param width the width of the rectangle to be cleared
	 * @param height the height of the rectangle to be cleared
	 */
	private void clearArea(int x, int y, int width, int height) {
		Graphics2D graphics = (Graphics2D)getContentPane().getGraphics();
		graphics.setColor(new Color(51, 204, 51));
		graphics.fillRect(x, y, width, height);
	}
	
	/**
	 * Method no longer in use
	 * Was used to add the card back image objects to the Tableau pile 
	 * ArrayLists for set up of Solitaire in the View
	 * 
	 * @param pilesLeft an ArrayList of card image object ArrayLists that need 
	 * image card objects added to them still
	 * @param i the iterator to determine the x-coordinate of the image object
	 * @param min an iterator to ensure the for loop runs the correct number of
	 * times
	 */
	public void setupHelper(ArrayList<ArrayList<GameBoardCardObject>> pilesLeft, int i, int min) {
		
		for (int j = 0; j < min; j++) {
			try {
				pilesLeft.get(i).add(0, new GameBoardCardObject(149 + i * 138, 178 + j * 15, ImageIO.read(new File("Card_Back.png")), 100, 140));
			}
			catch(IOException IE) {
				System.out.println("Unable to load image\n");
			}
		}
		min++;
		
		//Remove the Tableau pile at index 0 from the ArrayList
		pilesLeft.remove(0);
	}

}
