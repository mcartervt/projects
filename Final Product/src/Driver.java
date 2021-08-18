import javax.swing.JFrame;

/**
 * This Driver contains main() 
 * It creates a View object and provides the necessary set up
 */

public class Driver {
	public static void main(String [] args) {
		
		//Create the View
		View view = new View();
		view.setTitle("Solitaire");
		view.setSize(950, 650);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		view.setVisible(true);
	}
}
