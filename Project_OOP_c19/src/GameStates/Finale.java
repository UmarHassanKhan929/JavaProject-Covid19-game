
/*
 * 
 * 		end level class
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

public class Finale extends GameState {
	
	Player player;
	private Font textFont;
	
	//events 
	private float eventCount = 0;
	private boolean eventStart;
	private Rectangle tbd;

	public Finale(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		
		MusicPlayer.stop("level4");
		MusicPlayer.stop("run");
		setTextFont(new Font("Century Gothic",Font.BOLD,16));

		eventStart = true;
		//tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
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
		
		g.setFont(new Font("Times New Roman",Font.BOLD,16));
		g.drawString("\"Beautiful flowers, too, eventually", 45, 50);
		g.drawString("wither and fall.", 110, 70);
		g.drawString("That is the fate of all living beings.\"", 40, 90);
		g.drawString("But I do believe that stupid flowers meet their", 7, 140);
		g.drawString("doom earlier.", 120, 160);
		
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		//g.fill(tbu);
		g.fill(tbd);

	}

	@Override
	public void handleInput() {
		if(InputKeys.isPressed(InputKeys.ESCAPE)) {
			gsm.setState(GameStateManager.ENDCREDITS);
		}
		if(InputKeys.isPressed(InputKeys.ENTER)) {
			gsm.setState(GameStateManager.ENDCREDITS);
		}
	}
	
	private void eventStart() {
		eventCount++;

		if(eventCount > 80 && eventCount < 500) {
			tbd.y += 1;
		}

	}

	public Font getTextFont() {
		return textFont;
	}

	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}

}


