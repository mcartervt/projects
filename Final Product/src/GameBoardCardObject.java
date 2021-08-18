import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * Stationary card object to add to the gameboard
 */

public class GameBoardCardObject
{
	protected int posx; 
	protected int posy;
	protected BufferedImage bi; 
	protected int imageW;
	protected int imageH;

	GameBoardCardObject(int posx, int posy, BufferedImage bi, int imageW, int imageH)
	{
		this.posx = posx;
		this.posy = posy; 
		this.bi= bi;
		this.imageW = imageW; 
		this.imageH = imageH;
	}
	
	/**
	 * Renders the image object to the screen
	 * 
	 * @param g the image object to be drawn
	 */
	public void drawImage(Graphics g)
	{
		g.drawImage(bi,posx, posy,imageW,imageH,null);
	}
	
	@Override
	public String toString() {
		return "Image Object";
	}
}