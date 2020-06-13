/*
 * 
 * 		title image
 * 
 */

package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Title {

	private BufferedImage image;
	
	public Title() {
		
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/cv2.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {	
		g.drawImage(image, 20, 40, null);
	}
}
