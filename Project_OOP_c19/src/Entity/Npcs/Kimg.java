package Entity.Npcs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Npc;
import TileMap.TileMap;

public class Kimg extends Npc{

	private BufferedImage[] sprites;
	
	public Kimg(TileMap tm) {
		super(tm);

		moveSpeed = 1;
		maxSpeed = 1;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
			
		width = 46;
		height = 46;
		cwidth = 40;
		cheight = 40;
			
		health = maxHealth = 5;

			
		// load sprites
		try {
						
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Npc/kimg.png"));
						
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
		animation.setDelay(100);
			
		left = true;
		facingRight = false;
	}
	
	private void getNextPosition() {
		
		// movement of kimg
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		
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
		

		
		// if it hits a wall, go other direction
		if(right && dx == 0) {
			
			right = false;
			
			left = true;
			
			facingRight = false;
		}
		else if(left && dx == 0) {
			
			right = true;
			
			left = false;
			
			facingRight = true;
		}
		
		// update animation
		animation.update();
		
	}

	public void draw(Graphics2D g) {

		setMapPosition();
		super.draw(g);
		
	}

}
