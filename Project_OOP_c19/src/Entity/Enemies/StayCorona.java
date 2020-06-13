package Entity.Enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Entity.Animation;
import Entity.Enemy;
import TileMap.TileMap;

public class StayCorona extends Enemy{
	private BufferedImage[] sprites;

	public StayCorona(TileMap tm) {
		super(tm);
		
		//speed of corona
		moveSpeed = 1.5;
		maxSpeed = 1;
		fallSpeed = 0.2;
		maxFallSpeed = 10.0;
		
		width = 20;
		height = 20;
		cwidth = 40;
		cheight = 40;
		
		health = maxHealth = 2;
		damage = 1;
		
		// load sprites
		try {
					
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/corona.png"));
					
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
		animation.setDelay(20);
		
		left = true;
		facingRight = false;
		
	}
	
	
	private void getNextPosition() {
		

		
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
		

		// update animation
		animation.update();
		
	}

	public void draw(Graphics2D g) {
		
		//if(notOnScreen()) return;
		
		setMapPosition();
		
		super.draw(g);
		
	}

}
