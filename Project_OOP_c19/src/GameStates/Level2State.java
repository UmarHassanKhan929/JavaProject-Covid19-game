
/*
 * 
 * 			Level2 class
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
import Entity.Enemy;
import Entity.HUD2;
import Entity.Npc;
import Entity.Player;
import Entity.Enemies.Bushra;
import Entity.Enemies.Corona;
import Entity.Enemies.Habib1;
import Entity.Npcs.FatMan;
import Entity.Npcs.Finn;
import Entity.Npcs.Girly;
import Entity.Npcs.Hamza;
import Entity.Npcs.Jameel;
import Entity.Npcs.Jameela;
import Entity.Npcs.Kimg;
import Entity.Npcs.UncleBob;
import Entity.Npcs.UncleJojo;
import Main.GamePanel;
import TileMap.BackGround;
import TileMap.TileMap;

public class Level2State extends GameState {
	
	//first thing, background and tilemaps
	private TileMap tilemaps;
	private BackGround bglevel2a;

	
	//hud and enemies
	private HUD2 hud;
	private ArrayList<Enemy> enemies;
	private ArrayList<Npc> npcs;
		
	//font
	private Font warnFont;
	private Color warnColor;

	
	//player
	private Player player;
	
	//events
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;

	
	//level 2 constructor
	public Level2State(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	//initialize method
	@Override
	public void init() {
		
		//event for screen
		eventCount = 0;
		
		//music stuff
		MusicPlayer.stop("level1");
		MusicPlayer.play("level2");
		
		MusicPlayer.loop("level2", 400, MusicPlayer.getFrames("level2") - 1600);
		
		//tilemaps
		tilemaps = new TileMap(30);
		tilemaps.loadTiles("/TileSets/CVTileSet.png");
		tilemaps.loadMap("/Maps/Level2.map");
		tilemaps.setPosition(0, 0);
		
		
		//background selection
		bglevel2a = new BackGround("/Backgrounds/levelall.png", 0.05);
		
		//player initialize
		player = new Player(tilemaps,"/Sprites/Player/Unnamed.png");
		player.setPosition(60, 180);
		
		//calling enemies and npcs
		populateNpcs();
		populateEnemies();
		
		//creating hud
		hud = new HUD2(player);
		
		// start event
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		
		//font settings
		warnColor = new Color(0, 255, 51);
		warnFont = new Font("Times New Roman",Font.PLAIN,12);
		
	}

	//method of calling enemies
	public void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();	
		
		Corona cs;
		cs = new Corona(tilemaps);
		cs.setPosition(1240,70);
		enemies.add(cs);
		
		Corona cs2;
		cs2 = new Corona(tilemaps);
		cs2.setPosition(1520,93);
		enemies.add(cs2);
		
		Corona cs3;
		cs3 = new Corona(tilemaps);
		cs3.setPosition(2500,95);
		enemies.add(cs3);
		
		Corona cs4;
		cs4 = new Corona(tilemaps);
		cs4.setPosition(3200,150);
		enemies.add(cs4);
		
		Corona cs5;
		cs5 = new Corona(tilemaps);
		cs5.setPosition(3500,90);
		enemies.add(cs5);
		
		Corona cs6;
		cs6 = new Corona(tilemaps);
		cs6.setPosition(3890,150);
		enemies.add(cs6);
		
		Corona cs7;
		cs7 = new Corona(tilemaps);
		cs7.setPosition(4000,155);
		enemies.add(cs7);
		
		Corona cs8;
		cs8 = new Corona(tilemaps);
		cs8.setPosition(4280,185);
		enemies.add(cs8);
		
		Corona cs9;
		cs9 = new Corona(tilemaps);
		cs9.setPosition(4470,185);
		enemies.add(cs9);
		
		Corona cs10;
		cs10 = new Corona(tilemaps);
		cs10.setPosition(5190,90);
		enemies.add(cs10);
		
		Corona cs11;
		cs11 = new Corona(tilemaps);
		cs11.setPosition(6720,185);
		enemies.add(cs11);
		
		Habib1 h1;
		h1 = new Habib1(tilemaps);
		h1.setPosition(1860,180);
		enemies.add(h1);
		
		Bushra b2;
		b2 = new Bushra(tilemaps);
		b2.setPosition(3970,180);
		enemies.add(b2);
		
		Habib1 h2;
		h2 = new Habib1(tilemaps);
		h2.setPosition(3720,180);
		enemies.add(h2);
		
		Bushra b1;
		b1 = new Bushra(tilemaps);
		b1.setPosition(2100,180);
		enemies.add(b1);
		
		Habib1 h3;
		h3 = new Habib1(tilemaps);
		h3.setPosition(6200,180);
		enemies.add(h3);
		
	}
	
	//npc creations
	public void populateNpcs() {
		
		npcs = new ArrayList<Npc>();
		
		Hamza h;
		h = new Hamza(tilemaps);
		h.setPosition(1240,180);
		npcs.add(h);
		
		Jameel jj;
		jj = new Jameel(tilemaps);
		jj.setPosition(520,180);
		npcs.add(jj);
			
		UncleBob ub;
		ub = new UncleBob(tilemaps);
		ub.setPosition(820,180);
		npcs.add(ub);
		
		UncleBob ub3;
		ub3 = new UncleBob(tilemaps);
		ub3.setPosition(1000,180);
		npcs.add(ub3);
		
		UncleJojo uj;
		uj = new UncleJojo(tilemaps);
		uj.setPosition(1542,180);
		npcs.add(uj);
		
		UncleJojo uj2;
		uj2= new UncleJojo(tilemaps);
		uj2.setPosition(5585,95);
		npcs.add(uj2);
		
		UncleBob ub4;
		ub4 = new UncleBob(tilemaps);
		ub4.setPosition(5743,80);
		npcs.add(ub4);
		
		UncleBob ub2;
		ub2 = new UncleBob(tilemaps);
		ub2.setPosition(1662,180);
		npcs.add(ub2);
		
		Finn fn;
		fn = new Finn(tilemaps);
		fn.setPosition(800,180);
		npcs.add(fn);
		
		Finn fn2;
		fn2 = new Finn(tilemaps);
		fn2.setPosition(4600,180);
		npcs.add(fn2);
		
		Jameel jj2;
		jj2 = new Jameel(tilemaps);
		jj2.setPosition(1600,180);
		npcs.add(jj2);
		
		FatMan fm;
		fm = new FatMan(tilemaps);
		fm.setPosition(2680,180);
		npcs.add(fm);
		
		FatMan fm2;
		fm2 = new FatMan(tilemaps);
		fm2.setPosition(3300,180);
		npcs.add(fm2);
		
		Girly gorl;
		gorl = new Girly(tilemaps);
		gorl.setPosition(6300,180);
		npcs.add(gorl);
		
		Kimg kimg;
		kimg = new Kimg(tilemaps);
		kimg.setPosition(3000,180);
		npcs.add(kimg);
		
		Jameela jameela;
		jameela = new Jameela(tilemaps);
		jameela.setPosition(2170,180);
		npcs.add(jameela);
		
		
		
		FatMan fm3;
		fm3 = new FatMan(tilemaps);
		fm3.setPosition(6670,180);
		npcs.add(fm3);
		
		
	}
	
	
	//updating each cycle
	@Override
	public void update() {

		//input keys
		handleInput();
		
			
		// play event
		if(eventStart) {
			eventStart();
		}
			
		
		player.setFire(1);
		
		//background
		bglevel2a.setPosition(tilemaps.getXcord(), tilemaps.getYcord());
	
		//player
		player.update();
		
				
		//attacking on enemies, collision
		player.checkAttack(enemies);
		
		// update all enemies
		for(int i = 0; i < enemies.size(); i++) {
			Enemy es = enemies.get(i);
			es.update();
						
			if(es.isDead()) {
				MusicPlayer.play("enemyhit");
				enemies.remove(i);
				i--;
			}
		}
		
		//npcs update	
		for(int i = 0; i < npcs.size(); i++) {
			Npc npc = npcs.get(i);
			npc.update();
			
		}
		
		if(player.isDead()) {
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			init();
			
		}
		

		
	}

	@Override
	public void draw(Graphics2D g) {

		bglevel2a.draw(g);

		//drawing the tilemap
		tilemaps.draw(g);
		hud.draw(g);
		tilemaps.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
		
		//font
		g.setColor(warnColor);
		g.setFont(warnFont);
		
		if((player.getx()>50)&&(player.getx()<80)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>60)&&(player.getx()<120)) {
			g.drawString("It's finally Sunday. Cool Jamal is off to the library ", 50, 25);
			g.drawString("to read the latest issue of his favourite sci-fi novel", 50, 37);
			
		}
		
		
		if((player.getx()>760)&&(player.getx()<820)) {
			g.drawString("The situation with the pandemic has worsened", 50, 25);    
			g.drawString("and it's finally infiltrated this city", 50, 37);
			
		}
		
		
		
		if((player.getx()>1420)&&(player.getx()<1470)) {
			g.drawString("People are not restraining from going out ", 50, 25); 
			g.drawString("in crowded places at all ", 50, 37);    
			
		}
		if((player.getx()>1460)&&(player.getx()<1500)) {
			g.drawString("The Market and the library both are cramped", 30, 80);    
			
		}
		
		
		
		if((player.getx()>1890)&&(player.getx()<1950)) {
			g.drawString("But Cool Jamal is too cool to be bothered ", 50, 130); 
			g.drawString("by sOmE vIRuS", 50, 150); 
		}
		if((player.getx()>2100)&&(player.getx()<2140)) {
			g.drawString("\"Ah, Steins Gate chapter 27. It is finally here\"" , 50, 117); 
		}
		
		if((player.getx()>2130)&&(player.getx()<2150)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>2160)&&(player.getx()<2190)) {
			g.drawString("The people down there might be carrying the virus", 50, 28); 
			 
		}
		if((player.getx()>2190)&&(player.getx()<2220)) {
			g.drawString("However they themselves are not infected yet", 50, 28); 
			
		}
		if((player.getx()>2220)&&(player.getx()<2250)) {	
			g.drawString("People like them can be disinfected using a sanitiser", 50, 28); 
			 
		}
		if((player.getx()>2250)&&(player.getx()<2280)) {
			MusicPlayer.play("ding");
			g.drawString("In real life, You cannot know who is infected or ", 50, 20); 
			g.drawString("not so always be cautious", 50, 30); 
		}
		
		
		if(player.getx()>3530&&player.getx()<3550) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>3570)&&(player.getx()<3600)) {
			
			g.drawString("~Jump to avoid falling and getting the virus from the carrier~", 22, 50); 
			
		}
		
		if((player.getx()>5400)&&(player.getx()<5460)) {
			
			g.drawString("Places like markets are where the virus", 80, 25); 
			g.drawString("spreads the most. Be careful", 80, 35); 
		}
		
		if((player.getx()>6960)&&(player.getx()<6990)) {
			
			g.drawString("Oops. Looks like Cool Jamal was too indulged ", 50, 15); 
			g.drawString("in the novel and reached a dead end.", 50, 30); 
		}
		
		if((player.getx()>6995)&&(player.getx()<7020)) {
			g.drawString("~Press Y to go to next Level~", 78, 30);
			
		}
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		
		for(int i = 0; i < npcs.size(); i++) {
			npcs.get(i).draw(g);

		}
				
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
		//cheat code to skip levels
		//if(player.getx()>6990 && player.getx()<7050) {
			if(InputKeys.isPressed(InputKeys.CONFIRM)) {
				
				MusicPlayer.stop("level2");
				gsm.setState(GameStateManager.LEVELGAME3STATE);
			}
		//}
		
	}
	
	
	
	// level started
	private void eventStart() {
		
		
		eventCount++;
		if(eventCount == 1) {

		}
		if(eventCount > 1 && eventCount < 60) {
			
			tbu.height -= 6;
			tbd.y += 6;
			
		}

	}
	

}
