package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Audio.MusicPlayer;
import ControlHandlers.InputKeys;
import Entity.Player;
import Main.GamePanel;

public class L4Prologue extends GameState{
	
	Player player;
	private Font textFont;
	
	//events 
	private float eventCount = 0;
	private boolean eventStart;
	private Rectangle tbd;
	
	public L4Prologue(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}
	


	@Override
	public void init() {
		setTextFont(new Font("Century Gothic",Font.BOLD,16));
		
		eventStart = true;
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		MusicPlayer.load("/Music/level4.mp3", "level4");
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
		
		
		g.setFont(new Font("Times New Roman",Font.PLAIN,13));
		g.drawString("->23 Days have passed since the countrywide lockdown.  ", 10, 20);
		g.drawString("Uncool Jamal had confidence in his shopping skills.  ", 10, 33);
		g.drawString("Apparently, there was just the confidence but no skills. ", 10, 46);
		g.drawString("->23 Days and Jamal has finally run out of edibles.", 10, 60);
		g.drawString("->23 Days and yet the toilet papers Jamal had bought", 10, 74);
		g.drawString(" seemed to be of no help in his survival.", 50, 88);
		g.drawString("->It did not take him 23 Days to find out that it was food", 10, 106);
		g.drawString("he needed to survive. It took him exhausting ", 40, 120);
		g.drawString("all his resources to make the discovery.", 50, 134);
		g.drawString("Strange isn’t it.", 120, 148);
		g.drawString("->To think we have tens of thousands of years of ", 10, 162);
		g.drawString(" evolution behind us.", 100, 176);
		g.drawString("->More people are getting infected. More people are ", 10, 190);
		g.drawString("getting out of their houses and panic-buying food.", 20, 204);
		g.drawString("Jamal is, of course,  no exception", 70, 220);
		

		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		g.fill(tbd);
				
	}
	
	
	@Override
	public void handleInput() {
		
		if((eventCount>600)&&InputKeys.isPressed(InputKeys.ESCAPE)) {
			gsm.setState(GameStateManager.LEVELGAME4STATE);
		}
		
		if((eventCount>600)&&InputKeys.isPressed(InputKeys.ENTER)) {
			gsm.setState(GameStateManager.LEVELGAME4STATE);
		}
	}
	
	private void eventStart() {
		
		eventCount++;
		
		if(eventCount > 1 && eventCount < 300) {
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
