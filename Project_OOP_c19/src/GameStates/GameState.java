/*
 * 
 * 			game state abstract class
 * 
 */

package GameStates;

import java.awt.Graphics2D;

public abstract class GameState {  //blueprint for classes
	
	protected GameStateManager gsm;  // gsm object
	
	public GameState(GameStateManager gameStateManager) {  
		this.gsm = gameStateManager;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void handleInput();
	
}
