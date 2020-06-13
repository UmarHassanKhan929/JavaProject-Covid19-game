/*
 * 
 * 			HUD screen which shows player health and spray ammo
 * 
 */

package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HUD {
	//player object
	private Player player;
	
	//buffered image for hud
	private BufferedImage image;
	private Font font;
	
	//constructor
	public HUD(Player p) {
		player = p;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/HUD/hud.png"));
			font = new Font("Century Gothic", Font.PLAIN, 10);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//drawing static hud on screen
	public void draw(Graphics2D g) {
		
		g.drawImage(image, 0, 10, null);
		
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		//displayes attributes of player such as sanitize amount and health
		g.drawString(player.getHealth() + "/" + player.getMaxHealth(),20,22);
		
		g.drawString(player.getFire()  + "/" + player.getMaxFire() ,14,35);
	}
	
}
