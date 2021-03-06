package Entity.Npcs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import Entity.Animation;
import Entity.Npc;
import TileMap.TileMap;

public class UncleJojo extends Npc {
private BufferedImage[] sprites;
	
	public UncleJojo(TileMap tm) {
		
		super(tm);
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
			
		width = 30;
		height = 30;
		cwidth = 30;
		cheight = 30;
			
		health = maxHealth = 5;

			
		// load sprites
		try {
						
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Npc/unclejojo.png"));
						
			sprites = new BufferedImage[5];
				
			for(int i = 0; i < sprites.length; i++) {
				
				sprites[i] = spritesheet.getSubimage(i * width,0,width,height);
				}
						
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
			
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(80);
				
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
