/*
 * 
 * 			Player class for each animation, move, and its all attributes
 * 			its extends mapobject and implements it all
 * 
 */

package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import Audio.MusicPlayer;
import TileMap.TileMap;



public class Player extends MapObject {
	
	// player stuff
	private int health;
	private int maxHealth;
	private int fire;
	private int maxFire;
	private boolean dead;
	private boolean flinching;
	private long flinchTimer;
	
	private boolean knockdown;
	
	// sprayball
	private boolean firing;
	private int sprayCost;
	private int sprayBallDamage;
	private ArrayList<Sprays> sprayBalls;
	
	// picking up
	//private boolean picking;

	
	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	// animations
	private ArrayList<BufferedImage[]> sprites;
	
	private final int[] numFrames = {
		4, 6, 1, 1,4,4,1,2
	};
	
	// animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int FALLING = 3;
	private static final int PICKING = 4;
	private static final int SPRAYING = 5;
	private static final int DEAD = 7;
	

	
	public Player(TileMap tm , String s) {
		
		super(tm);
		
		width = 40;
		height = 40;
		cwidth = 30;
		cheight = 38;
		
		moveSpeed = 0.3;
		maxSpeed = 2.2;
		stopSpeed = 0.4;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -5.0;
		stopJumpSpeed = 0.3;
		
		facingRight = true;
		
		health = maxHealth = 5;
		fire = 1;
		maxFire = 25;
		
		sprayCost = 1;
		sprayBallDamage = 5;
		
		sprayBalls = new ArrayList<Sprays>();
		

		// load sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream(s));
			
			sprites = new ArrayList<BufferedImage[]>();
			
			
			for(int i = 0; i < 8; i++) {
				
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				
				for(int j = 0; j < numFrames[i]; j++) {
					
					if(i != PICKING) {
						bi[j] = spritesheet.getSubimage(j * width,i * height,width,height);
					}
					if(i==PICKING){
						bi[j] = spritesheet.getSubimage(j * 50 * 2,i * height,50 * 2,height);
					}
					if(i==SPRAYING){
						bi[j] = spritesheet.getSubimage(j * width * 2,i * height,width*2,height);
					}
					
				}
				
				sprites.add(bi);
				

				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//animation objects
		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(100);
		
		//music  loading
		MusicPlayer.load("/SFX/yeet.mp3", "yeet");
		MusicPlayer.load("/SFX/spray.mp3", "spray");
		MusicPlayer.load("/SFX/empty_spray.mp3", "empty_spray");
		MusicPlayer.load("/SFX/warning.mp3", "warning");
		MusicPlayer.load("/SFX/run.mp3", "run");
		MusicPlayer.load("/SFX/knock.mp3", "knock");
		MusicPlayer.load("/SFX/enemyhit.mp3", "enemyhit");
		MusicPlayer.load("/SFX/ded.mp3", "ded");
		MusicPlayer.load("/SFX/swosh.mp3", "swosh");
		
		
	}
	
	
	public int getHealth() { 
		return health; 
		}
	
	public void setHealth(int i) {
		this.health = i;
		
	}
	public int getMaxHealth() { 
		return maxHealth; 
		}
	public int getFire() { 
		return fire; 
		}
	public void setFire(int fire) { 
		this.fire = fire;; 
		}
	public int getMaxFire() { 
		return maxFire; 
		}
	
	public void setFiring() { 
		if(knockdown)  
			return;
		else
			firing = true;
	}
	public void setScratching() {
		if(knockdown)  
			return;
		else
			scratching = true;
	}
	public boolean getScratching() {
		return scratching;
	}

	
	public void checkAttack(ArrayList<Enemy> enemies) {
		
		// loop through enemies
		for(int i = 0; i < enemies.size(); i++) {
			
			Enemy e = enemies.get(i);
			
		
			// sprays balls
			for(int j = 0; j < sprayBalls.size(); j++) {
				if(sprayBalls.get(j).intersects(e)) {
					e.hit(sprayBallDamage);
					
					sprayBalls.get(j).setHit();
					break;
				}
			}
			
			// check enemy collision
			// intersect is from mapobject
			if(intersects(e)) {
				hit(e.getDamage());
			}
			
		}
		
	}
	
	
	public void setDead() {
		health = 0;
		//stop();
	}
	

	public void hit(int damage) {
		if(flinching) 
			return;
		
		
		stop();  //stop all animation for knowck down 
		
		if(damage>0) {
			health -= damage;
			MusicPlayer.play("knock");
			flinching = true;
			flinchTimer = System.nanoTime();
		}
		
		if(health < 0) 
			health = 0;
		
		if(health == 0) {
			MusicPlayer.stop("run");
			MusicPlayer.stop("enemyhit");
			MusicPlayer.play("ded");
			dead = true;
		}
		
		
		
		if(facingRight) dx = -1;
		else dx = 1;
		dy = -3;
		

		
		falling = true;
		jumping = false;
	}
	
	//reset everything
	public void reset() {
		health = maxHealth;
		facingRight = true;
		currentAction = -1;
		stop();
	}
	
	//stops everything by assigning all variables false
	public void stop() {
		
		left = right = up = down = flinching  = jumping = scratching = firing = false;
	}
	
	
	private void getNextPosition() {
		// movement
		if(left) {

			dx -= moveSpeed;

			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {  /////running code

			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		
		// cannot move while attacking, except in air
		if((currentAction == PICKING || currentAction == SPRAYING) &&!(jumping || falling)) {
			dx = 0;
		}
		
		// jumping
		if(jumping && !falling) {
			 
			dy = jumpStart;
			falling = true;
		}
		
		// falling
		if(falling) {
			 dy += fallSpeed;
			
			if(dy > 0) 
				jumping = false;
			
			if(dy < 0 && !jumping) 
				dy += stopJumpSpeed;
			
			if(dy > maxFallSpeed) 
				dy = maxFallSpeed;
			
		}
		
	}
	
	public void update() {
		
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		

		//ded state
		if((health == 0)&&(currentAction != DEAD)) {
			currentAction = DEAD;
			animation.setFrames(sprites.get(DEAD));
			animation.setDelay(50);
			width = 40;
			
		}

		
		// check attack has stopped
		if(currentAction == PICKING) {
			if(animation.hasPlayedOnce()) 
				scratching = false;
		}
		
		
		if(currentAction == SPRAYING) {
			if(animation.hasPlayedOnce()) {
				
				firing = false;
			}
		}
		
	
		if(fire > maxFire) 
			fire = maxFire;
		
		if(firing && currentAction != SPRAYING) {
			
			if(fire > sprayCost) {
				fire -= sprayCost;
				Sprays sanit = new Sprays(tileMap, facingRight);
				sanit.setPosition(x, y);
				sprayBalls.add(sanit);
			}
		}
		
		// update sprayballs
		for(int i = 0; i < sprayBalls.size(); i++) {
			sprayBalls.get(i).update();
			if(sprayBalls.get(i).shouldRemove()) {
				sprayBalls.remove(i);
				i--;
			}
		}
		
		// check done flinching
		if(flinching) {
			long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
			if(elapsed > 1000) {
				flinching = false;
			}
		}
		
		// set animation
		if(scratching) {
			if(currentAction != PICKING) {
				MusicPlayer.stop("run");
				currentAction = PICKING;
				animation.setFrames(sprites.get(PICKING));
				animation.setDelay(50);
				MusicPlayer.play("swosh");
				width = 100;
			}
		}
		else if(firing) {
			if(currentAction != SPRAYING) {
				currentAction = SPRAYING;
				MusicPlayer.stop("run");
				animation.setFrames(sprites.get(SPRAYING));
				animation.setDelay(80);
				width = 80;
				if(fire>5) {
					MusicPlayer.play("spray");
				}
				else if(fire<5){
					MusicPlayer.play("empty_spray");
				}
			}
		}
		else if(dy > 0) {

			if(currentAction != FALLING) {
				currentAction = FALLING;
				MusicPlayer.stop("run");
				animation.setFrames(sprites.get(FALLING));
				animation.setDelay(-1);
				width = 40;
			}
		}
		else if(dy < 0) {
			if(currentAction != JUMPING) {
				currentAction = JUMPING;
				MusicPlayer.stop("run");
				animation.setFrames(sprites.get(JUMPING));
				animation.setDelay(-1);
				width = 40;
			}
		}
		else if(left || right) {
			if(currentAction != WALKING) {
				currentAction = WALKING;
				MusicPlayer.loop("run");
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(60);
				width = 40; 
			}
		}
		else {
			if(currentAction != IDLE) {
				currentAction = IDLE;
				MusicPlayer.stop("run");
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(140);
				width = 40;
			}
		}
		
		animation.update();
		
		// set direction
		if(currentAction != PICKING ) {
			if(right) 
				facingRight = true;
			if(left) 
				facingRight = false;
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		setMapPosition();
		
		// draw fireballs
		for(int i = 0; i < sprayBalls.size(); i++) {
			sprayBalls.get(i).draw(g);
		}
		
		// draw player
		if(flinching) {
			long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
			if(elapsed / 100 % 2 == 0) {
				return;
			}
		}
		
		super.draw(g);
		
	}
	
}




















