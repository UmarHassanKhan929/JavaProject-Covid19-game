package Entity.Npcs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Npc;
import TileMap.TileMap;

public class Hamza extends Npc{
private BufferedImage[] sprites;
	
	public Hamza(TileMap tm) {
		super(tm);

		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
			
		width = 32;
		height = 32;
		cwidth = 30;
		cheight = 30;
			
		health = maxHealth = 5;

			
			// load sprites
		try {
						
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Npc/hamza.png"));
						
			sprites = new BufferedImage[3];
				
			for(int i = 0; i < sprites.length; i++) {
				
				sprites[i] = spritesheet.getSubimage(i * width,0,width,height);
				}
						
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
			
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(150);
			

	}


	
	private void getNextPosition() {
		

		
		// falling
		if(falling) {
			dy += fallSpeed;
		}
		
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		

		// update animation
		animation.update();
		
	}

	public void draw(Graphics2D g) {
		
	
		setMapPosition();	
		super.draw(g);
		
	}

}

	
	
