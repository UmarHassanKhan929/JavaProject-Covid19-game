package Entity.Npcs;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Npc;
import TileMap.TileMap;

public class Jameel extends Npc{
	
	private BufferedImage[] sprites;

	public Jameel(TileMap tm) {
		
		super(tm);
		//speed of jameel
			moveSpeed = 0.6;
			maxSpeed = 0.6;
			fallSpeed = 0.2;
			maxFallSpeed = 10.0;
				
			width = 22;
			height = 22;
			cwidth = 22;
			cheight = 20;
				
			health = maxHealth = 5;

				
				// load sprites
			try {
							
				BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Npc/hameel22.png"));
							
				sprites = new BufferedImage[8];
					
				for(int i = 0; i < sprites.length; i++) {
					
					sprites[i] = spritesheet.getSubimage(i * width,0,width,height);
					}
							
				}
				
			catch(Exception e) {
				e.printStackTrace();
			}
				
			animation = new Animation();
			animation.setFrames(sprites);
			animation.setDelay(50);
				
			left = true;
			facingRight = false;
	}

	
	
	
	private void getNextPosition() {
		
		// movement of jameel
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
		
		//if(notOnScreen()) return;
		
		setMapPosition();
		
		super.draw(g);
		
	}
}