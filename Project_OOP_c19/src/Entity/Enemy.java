
/*
 * 		enemy class which extends map object
 * 		all enemies have these common attributes
 * 
 * 
 */
package Entity;

import TileMap.TileMap;

public class Enemy extends MapObject {
	
	protected int health;         //enemy health
	protected int maxHealth;      //enemy maxhelth
	protected boolean dead;       //enemy dead state
	protected int damage;         //damage on contact with player
	protected boolean remove;     //remove on contact
	
	protected boolean flinching;  //hint of damage
	protected long flinchCount; 
	
	public Enemy(TileMap tm) {
		super(tm);
		remove = false;
	}
	
	//dead enemy check
	public boolean isDead() {  
		return dead;
	}
	
	//remove enemy check
	public boolean shouldRemove() {  
		return remove;
	}
	
	//getting damage check
	public int getDamage() {  
		return damage;
	}
	
	//getting damage
	public void setDamage( int dmg) {  
		this.damage = dmg;
	}
	
	//enemit get hit
	public void hit(int damage) {  
		
		//not hit if attacked alreayy
		if(dead || flinching)  
			return;
		
		// damage done to jamal is calculated
		health -= damage;            
		
		if(health < 0)
			health = 0;
		
		if(health == 0)
			dead = true;
		
		if(dead)
			remove = true;

		flinching = true;
		flinchCount = System.nanoTime();
		
	}
	
	public void update() {

	}



}
