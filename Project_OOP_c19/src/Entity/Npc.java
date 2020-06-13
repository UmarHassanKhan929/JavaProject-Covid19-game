/*
 * 
 * 				npc class with extends mapobject
 * 				all the common attributes of all npcs
 * 
 * 
 */

package Entity;

import TileMap.TileMap;

public class Npc extends MapObject{

	protected int health;     //npc health
	protected int maxHealth;  //npc maxhealth

	public Npc(TileMap tm) {
		super(tm);
	}
	
	public void update() {

	}

}
