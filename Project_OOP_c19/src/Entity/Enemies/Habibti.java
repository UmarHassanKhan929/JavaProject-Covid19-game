package Entity.Enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Enemy;
import TileMap.TileMap;

public class Habibti extends Enemy{
	
	private BufferedImage[] sprites;
	public Habibti(TileMap tm) {
		super(tm);

		//speed of habibti
				moveSpeed = 1.8;
				maxSpeed = 1;
				fallSpeed = 0.2;
				maxFallSpeed = 10.0;
				
				width = 44;
				height = 44;
				cwidth = 40;
				cheight = 34;
				
				health = maxHealth = 20;
				damage = 2;
				
				// load sprites
				try {
							
					BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/habibti.png"));
							
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
		
		// movement of habibti
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
		
		// check flinching
		if(flinching) {
			long elapsed =(System.nanoTime() - flinchCount) / 1000000;
			
			if(elapsed > 400) {
				flinching = false;
			}
		}
		
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
