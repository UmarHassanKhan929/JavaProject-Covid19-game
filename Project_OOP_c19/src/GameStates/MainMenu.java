/*
 * 
 * 
 * 			This is menu of the game, which appears first on GamePanel
 * 
 * 
 */

package GameStates;

import ControlHandlers.InputKeys;
import Entity.Title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


import Audio.MusicPlayer;
import TileMap.BackGround;

public class MainMenu extends GameState{
	
	private BackGround menuBG;   //background for menu

	private int currentChoice = 0;    //for selecting current choice
	private String[] options = {"Start","Mini Game","Safety First","Controls","Quit"};  //bunch of options
	
	
	private Title title;
	
	private Font subOptFont;

	public MainMenu(GameStateManager gsm) {                                                   //every game state needs reference to game state manager
		
		super(gsm);
		
		try {
			//image = Toolkit.getDefaultToolkit().getImage("/Backgrounds/C-19-nfected.png");
			MusicPlayer.stop("bgmini");
			MusicPlayer.stop("walk");
			
			MusicPlayer.load("/SFX/menuoption.mp3", "menuoption");
			MusicPlayer.load("/SFX/menuselect.mp3", "menuselect");
			MusicPlayer.load("/Music/level1.mp3", "level1");
			MusicPlayer.load("/Music/level2.mp3", "level2");
			MusicPlayer.load("/Music/level3.mp3","level3");
			
			MusicPlayer.load("/Music/ending.mp3", "ending");
			
			MusicPlayer.load("/Music/bgmini.mp3", "bgmini");
			menuBG = new BackGround("/Backgrounds/menubg.jpg", 0.2);
			menuBG.setVector(0.1, 0);
			
			
			subOptFont = new Font("Times New Roman", Font.PLAIN, 12);
			
			title = new Title();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();  //exception to catch any error in the loading of resources
			
		}
		
	}


	@Override
	public void init() {
		
	}
	
	

	@Override
	public void update() {

		menuBG.update();
		handleInput();
		
	}
	
	

	@Override
	public void draw(Graphics2D g) {
		
		// draw bg
		menuBG.draw(g);
		
		title.draw(g);
				

			
		// draw menu options
		g.setFont(subOptFont);
		
		for(int i = 0; i < options.length; i++) {
			
			if(i == currentChoice) {
				g.setColor(Color.BLUE);
			}
			
			else {
				g.setColor(Color.YELLOW);
			}
			
			g.drawString(options[i], 120, 120 + i * 15);
		}
		
	}
	
	//selection of options in menu
	private void select() {
		
		if(currentChoice == 0) {
			MusicPlayer.play("menuselect");
			gsm.setState(GameStateManager.LEVELGAME1STATE);
		}
		
		else if(currentChoice == 1) {
			MusicPlayer.play("menuselect");
			gsm.setState(GameStateManager.LEVELMINISTATE);
		}
		
		else if(currentChoice == 2) {
			MusicPlayer.play("menuselect");
			gsm.setState(GameStateManager.HELPSTATE);
		}
		
		else if(currentChoice == 3) {
			MusicPlayer.play("menuselect");
			gsm.setState(GameStateManager.CONTROLSTATE);
		}
		
		else if(currentChoice == 4) {
			MusicPlayer.play("menuselect");
			System.exit(0);
		}
		
		
	}
	
	@Override
	public void handleInput() {
		
		if(InputKeys.isPressed(InputKeys.ENTER)) {
			select();
		}
		
		if(InputKeys.isPressed(InputKeys.UP)) {
			if(currentChoice > 0) {
				MusicPlayer.play("menuoption", 0);
				currentChoice--;
			}
		}
		if(InputKeys.isPressed(InputKeys.DOWN)) {
			if(currentChoice < options.length - 1) {
				MusicPlayer.play("menuoption", 0);
				currentChoice++;
			}
		}
	}
	

}
