/*
 * 
 * 
 * 			dead state for mini game
 * 
 * 
 */

package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Audio.MusicPlayer;
import ControlHandlers.InputKeys;
import Entity.Player;
import Main.GamePanel;

public class DeadScreen extends GameState{
	Player player;
	private Font textFont;
	
	//events 
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;

	//constructor
	public DeadScreen(GameStateManager gameStateManager) {
		super(gameStateManager);
		textFont = new Font("Times New Roman",Font.BOLD,18);
		init();
		
		MusicPlayer.stop("bgmini");
		MusicPlayer.stop("level1");
		MusicPlayer.stop("walk");
	}

	@Override
	public void init() {
		
		// start event
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		
	}

	@Override
	public void update() {
		handleInput();
		
		// play events
		if(eventStart) {
			eventStart();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		
		g.setFont(textFont);
		g.drawString("YOU DIED", 90, 90);
		
		g.setFont(new Font("Times New Roman",Font.PLAIN,14));
		g.drawString("Press Enter to exit", 90, 120);
		g.drawString("Press ESC to Try again", 90, 150);
		
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		g.fill(tbu);
		g.fill(tbd);
	}

	@Override
	public void handleInput() {
		
		//escape key to enter pause menu
		if(InputKeys.isPressed(InputKeys.ESCAPE)) {
			gsm.setState(GameStateManager.LEVELMINISTATE);
		}
		
		//enter key on pause menu to exit to main menu
		if(InputKeys.isPressed(InputKeys.ENTER)) {
			MusicPlayer.stop("walk");
			gsm.setPaused(false);
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}
	
	// level started
	private void eventStart() {
		eventCount++;
    //Code snippet for adding smooth transition between level and dead screen using game clock
		if(eventCount > 1 && eventCount < 60) {
			
			tbu.height -= 6;
			tbd.y += 6;
		}

	}

}
