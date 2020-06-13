/*
 * 
 * 		spray animation and object
 * 
 */

package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public class Sprays extends MapObject{
	//varaibles
	Player player;
	private boolean hit;
	private boolean remove;
	
	//variables for images
	private BufferedImage[] sprites;
	private BufferedImage[] hitSprites;

	//constructor
	public Sprays(TileMap tm, boolean right) {
		
		super(tm);
		
		moveSpeed = 2;
		
		facingRight = right;
		
		if(right) {
			dx = moveSpeed;
			
		}
		else {
			dx = -moveSpeed;
		}
		
		//dimensions for spray
		width =30;
		height =30;
		cwidth =14;
		cheight=14;
		
		
		// load sprites
		try {
					
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player/sprayball.png"));
				
				//spray ball images
			sprites = new BufferedImage[4];
					
					
			for(int i = 0; i < sprites.length; i++) {
						
				sprites[i] = spritesheet.getSubimage(i * width,0,width,height);
						
			}
					
					
			//dissapearing images, after hitting
			hitSprites = new BufferedImage[3];
					
					
			for(int i = 0; i < hitSprites.length; i++) {
						
				hitSprites[i] = spritesheet.getSubimage(i * width,height,width,height);
			}
					
			animation = new Animation();
			animation.setFrames(sprites);
			animation.setDelay(70);
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//check collision
	public void setHit() {
		//for not resetting
		if(hit) 
			return;
		
		hit = true;
		
		animation.setFrames(hitSprites);
		animation.setDelay(70);
		dx = 0;
		
	}
	
	//remove trigger
	public boolean shouldRemove() { 
		return remove; 
	}
	
	
	//update method
	public void update() {
		
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
	
		if(((dx == 0) && !hit)) {
			setHit();
		}
	
		animation.update();
		
		if(hit && animation.hasPlayedOnce()) {
			remove = true;
		}
		
		
		
	}

	
	//draw method
	public void draw(Graphics2D g) {
		
		setMapPosition();
		
		super.draw(g);
		
	}
	

}
