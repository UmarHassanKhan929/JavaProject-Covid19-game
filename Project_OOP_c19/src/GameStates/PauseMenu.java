/*
 * 
 * 
 * 
 * 					Pause menu of the the game this class is accessed within every game state
 * 					
 * 					since this class and no rendering or looping through hence init() and update() are empty
 * 
 * 					draw method to draw on screen,  HandleInput() for input keys
 * 
 * 
 * 
 */

package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Audio.MusicPlayer;
import ControlHandlers.InputKeys;
import Main.GamePanel;

public class PauseMenu extends GameState{
	
	private Font textFont;

	//constructor
	public PauseMenu(GameStateManager gameStateManager) {
		super(gameStateManager);
		textFont = new Font("Times New Roman",Font.BOLD,18);
	}

	
	@Override
	public void init() {
		
	}
	

	@Override
	public void update() {
		handleInput();
	}
	

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		
		g.setFont(textFont);
		g.drawString("Game Paused", 90, 90);
		
		g.setFont(new Font("Times New Roman",Font.PLAIN,14));
		g.drawString("Press Enter to exit", 90, 120);
		g.drawString("Press ESC to continue", 90, 150);
		
	}

	@Override
	public void handleInput() {
		//escape key to enter pause menu
		if(InputKeys.isPressed(InputKeys.ESCAPE)) {
			MusicPlayer.stop("walk");
			gsm.setPaused(false);
		}
		//enter key on pause menu to exit to main menu
		if(InputKeys.isPressed(InputKeys.ENTER)) {
			gsm.setPaused(false);
			MusicPlayer.stop("level1");
			MusicPlayer.stop("level2");
			MusicPlayer.stop("level3");
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}

}
