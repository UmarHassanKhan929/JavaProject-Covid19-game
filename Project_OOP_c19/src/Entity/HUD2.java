/*
 * 
 * 
 * 		same as hud class but slight change for some level
 * 
 * 
 */


package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HUD2 {
	
	private Player player;
	
	private BufferedImage image;
	private Font font;
	
	public HUD2(Player p) {
		
		player = p;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/HUD/hudL2.png"));
			font = new Font("Century Gothic", Font.PLAIN, 10);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, 0, 10, null);
		
		g.setFont(font);
		g.setColor(Color.BLACK);
		//displays only the health of player(in level 2)
		g.drawString(player.getHealth() + "/" + player.getMaxHealth(),20,22);
		
	}

}
