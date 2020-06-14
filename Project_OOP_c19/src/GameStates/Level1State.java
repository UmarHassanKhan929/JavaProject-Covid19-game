/*
 * 
 * 
 * 		level 2 class
 * 
 */

package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import Audio.MusicPlayer;
import ControlHandlers.InputKeys;
import Entity.Npc;
import Entity.Player;
import Entity.Npcs.FatMan;
import Entity.Npcs.Finn;
import Entity.Npcs.Girly;
import Entity.Npcs.Hamza;
import Entity.Npcs.Jameel;
import Entity.Npcs.Kimg;
import Entity.Npcs.UncleBob;
import Entity.Npcs.UncleJojo;
import Main.GamePanel;
import TileMap.BackGround;
import TileMap.TileMap;

public class Level1State extends GameState{
	
	//first thing, tiles and background
	private TileMap tilemaps;
	private BackGround bglevel1a;

	
	//npcs 
	private ArrayList<Npc> npcs;
	
	//font
	private Font warnFont;
	private Color warnColor;
	
	//creating player
	private Player player;
	
	
    //events stuff
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;
	//private Rectangle tbd;


	//constructor of level1
	public Level1State(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}
	
	

	//initializing stuff
	@Override
	public void init() {
		
		//tiles related stuff
		tilemaps = new TileMap(30);
		tilemaps.loadTiles("/TileSets/CVTileSet.png");
		tilemaps.loadMap("/Maps/Level1.map");
		tilemaps.setPosition(0, 0);
		
		
		//backgroud selection
		bglevel1a = new BackGround("/Backgrounds/levelall.png", 0.05);

		
		
		//new player
		player = new Player(tilemaps,"/Sprites/Player/Unnamed.png");
		player.setPosition(60, 180);
		
		//calling npcs
		populateNpcs();
				
		// start event
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 


		//music load
		MusicPlayer.loop("level1", 400, MusicPlayer.getFrames("level1") - 1600);
		MusicPlayer.load("/SFX/ding.mp3", "ding");
		
		//text stuff
		warnColor = new Color(255, 255, 255);
		warnFont = new Font("Times New Roman",Font.BOLD,14);
		
		
	}
	
	
	//npc creations
	public void populateNpcs() {
		//oading all npc and assigning their coordinates in setposition methods
		npcs = new ArrayList<Npc>();
		
		Hamza h;
		h = new Hamza(tilemaps);
		h.setPosition(1010,180);
		npcs.add(h);
		
		Jameel jj;
		jj = new Jameel(tilemaps);
		jj.setPosition(520,180);
		npcs.add(jj);
		
		UncleBob ub;
		ub = new UncleBob(tilemaps);
		ub.setPosition(700,180);
		npcs.add(ub);
		
		UncleJojo uj;
		uj = new UncleJojo(tilemaps);
		uj.setPosition(1460,180);
		npcs.add(uj);
		
		UncleBob ub2;
		ub2 = new UncleBob(tilemaps);
		ub2.setPosition(1580,180);
		npcs.add(ub2);
		
		Finn fn;
		fn = new Finn(tilemaps);
		fn.setPosition(800,180);
		npcs.add(fn);
		
		Jameel jj2;
		jj2 = new Jameel(tilemaps);
		jj2.setPosition(1600,180);
		npcs.add(jj2);
		
		FatMan fm;
		fm = new FatMan(tilemaps);
		fm.setPosition(1800,180);
		npcs.add(fm);
		
		Kimg kimg;
		kimg = new Kimg(tilemaps);
		kimg.setPosition(2170,180);
		npcs.add(kimg);
		
		
		Girly gorl;
		gorl = new Girly(tilemaps);
		gorl.setPosition(2700,180);
		npcs.add(gorl);
		
	}

	@Override
	public void update() {
		
		handleInput();
		
		// play events
		if(eventStart) {
			eventStart();
		}
		
		//background
		bglevel1a.setPosition(tilemaps.getXcord(), tilemaps.getYcord());

		
		//player
		player.update();
		
		//updating npcs
		for(int i = 0; i < npcs.size(); i++) {
			Npc npc = npcs.get(i);
			npc.update();
		
			//restarts game by calling method when player dies
			
			if(player.isDead()) {
				init();
			}
			
		}
		
	}

	@Override
	public void draw(Graphics2D g) {

		//drawing background
		bglevel1a.draw(g);

		
		//drawing the tilemap
		tilemaps.draw(g);
		tilemaps.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
		
		//font
		g.setColor(warnColor);
		g.setFont(warnFont);
		
		//instructions
		//instructions are displayed when player reaches a specific region
		if((player.getx()>50)&&(player.getx()<100)) {
			g.drawString("~Left and Right arrow key to move~", 58, 40);
		}
		
		
		if((player.getx()>210)&&(player.getx()<260)) {
			g.drawString("Cool Jamal is off to his Friend's house", 50, 40);
		}
		
		if((player.getx()>270)&&(player.getx()<300)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>330)&&(player.getx()<400)) {
			g.drawString("~Press SPACE to Jump~", 90, 40);
		}
		
		
		if((player.getx()>510)&&(player.getx()<570)) {
			g.drawString("The Corona virus outbreak in China is at its", 30, 20);
			g.drawString("maturity stages right now but nobody here", 30, 40);
			g.drawString("seems to be concerned about it.", 30, 60);
		}
		
		
		if((player.getx()>570)&&(player.getx()<650)) {
			g.drawString("This is the local market.", 90, 30);
			
		}
		
		
		if((player.getx()>730)&&(player.getx()<800)) {
			g.drawString("All these people out here at shops", 68, 30);
			g.drawString("and stalls for shopping.", 68, 50);
		}
		
		
		if((player.getx()>1100)&&(player.getx()<1180)) {
			g.drawString("Cool Jamal does not want to stop here.", 50, 30);
			g.drawString("He hurries", 50, 50);
			
		}
		
		
		if((player.getx()>1700)&&(player.getx()<1780)) {
			g.drawString("\"Almost there, can see Uncle Kamal too\"", 40, 30);
			
		}
		
		if((player.getx()>2120)&&(player.getx()<2150)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>2180)&&(player.getx()<2230)) {
			g.drawString("\"Jump\"", 140, 30);
			
		}
		
		
		if((player.getx()>2550)&&(player.getx()<2620)) {
			g.drawString("\"There she is.\"", 110, 30);
			
		}
		
		if((player.getx()>2600)&&(player.getx()<2620)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>2660)&&(player.getx()<2690)) {
			g.drawString("~Press Y to go to next Level~", 78, 30);
			
		}

		//drawing npcs
		for(int i = 0; i < npcs.size(); i++) {
			npcs.get(i).draw(g);
		}
		
		//draw player
		player.draw(g);
		
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		g.fill(tbu);
		g.fill(tbd);
		
	}

	@Override
	public void handleInput() {
		if(InputKeys.isPressed(InputKeys.ESCAPE)) { 
			gsm.setPaused(true);
		}
	
		player.setUp(InputKeys.currentKeyState[InputKeys.UP]);
		
		player.setLeft(InputKeys.currentKeyState[InputKeys.LEFT]);
		
		player.setDown(InputKeys.currentKeyState[InputKeys.DOWN]);
		
		player.setRight(InputKeys.currentKeyState[InputKeys.RIGHT]);
		
		player.setJumping(InputKeys.currentKeyState[InputKeys.JUMPBUTTON]);
		if(InputKeys.isPressed(InputKeys.JUMPBUTTON)) {
			MusicPlayer.play("yeet");
		}
		
		if((player.getx()>2660)&&(player.getx()<2690)) {
			if(InputKeys.isPressed(InputKeys.CONFIRM)) {
				gsm.setState(GameStateManager.LEVELGAME2STATE);
			}
		}
			
	}
	
	
	// level started
	private void eventStart() {
		eventCount++;

		if(eventCount > 1 && eventCount < 60) {
			
			tbu.height -= 6;
			tbd.y += 6;
		}

	}
	

	
}
