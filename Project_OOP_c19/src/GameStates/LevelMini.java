/*
 * 
 * 		minni game class
 * 	
 * 
 */

package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import ControlHandlers.InputKeys;
import Entity.Enemy;
import Entity.HUD;
import Entity.Player;
import Entity.Enemies.Aladin;
import Entity.Enemies.Bushra;
import Entity.Enemies.Corona;
import Entity.Enemies.Habib1;
import Entity.Enemies.Habibti;
import Entity.Enemies.StayCorona;
import Main.GamePanel;
import TileMap.BackGround;
import TileMap.TileMap;
import Audio.MusicPlayer;

public class LevelMini extends GameState {
	
	//first thing
	private TileMap tilemaps;
	private BackGround sky;
	
	//private BackGround trees;
	private BackGround land;
	private Player player;
	
	//hud
	private HUD hud;
	
	//arraylist for npcs and enemies
	private ArrayList<Enemy> enemies;

	//fonts
	private Font warnFont;
	private Color warnColor;

	
	
	//events stuff
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;


	//constructor 
	public LevelMini(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		MusicPlayer.load("/SFX/moral.mp3", "moral");
		tilemaps = new TileMap(30);
		tilemaps.loadTiles("/TileSets/mini.png");
		tilemaps.loadMap("/Maps/minif.map");
		tilemaps.setPosition(0, 0);
		tilemaps.setTween(0.07);
				
				
		//backgroud selection
		sky = new BackGround("/Backgrounds/country-platform-back.png", 0.05);
		land = new BackGround("/Backgrounds/tree.png", 0.1);
			
			
		//player stuff
		player = new Player(tilemaps,"/Sprites/Player/Unnamed.png");
		player.setPosition(100, 320);
		//amount of sanitizer is given in parameter
		
		player.setFire(25);

		//calling all enemies
		populateEnemies();

		//hud initialize
		hud = new HUD(player);
			
		//event start
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		//black color set as warnColor	
		warnColor = new Color(0, 0, 0);
		warnFont = new Font("Times New Roman",Font.BOLD,14);
		
		MusicPlayer.loop("bgmini", 600, MusicPlayer.getFrames("bgmini") - 2200);
			
			
	}
	
	//calling enemies method 
	public void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();
		
		Corona c;
		c = new Corona(tilemaps);
		c.setPosition(630,330);
		enemies.add(c);
		
		Corona c2;
		c2 = new Corona(tilemaps);
		c2.setPosition(1060,300);
		enemies.add(c2);
		
		Corona c3;
		c3 = new Corona(tilemaps);
		c3.setPosition(1860,300);
		enemies.add(c3);
		
		Corona c4;
		c4 = new Corona(tilemaps);
		c4.setPosition(2830,270);
		enemies.add(c4);
		
		Corona c5;
		c5 = new Corona(tilemaps);
		c5.setPosition(3470,330);
		enemies.add(c5);
		
		Corona c6;
		c6 = new Corona(tilemaps);
		c6.setPosition(3500,270);
		enemies.add(c6);
		
		Corona c7;
		c7 = new Corona(tilemaps);
		c7.setPosition(2800,330);
		enemies.add(c7);
		
		Corona c8;
		c8 = new Corona(tilemaps);
		c8.setPosition(4200,300);
		enemies.add(c8);
		
		Corona c9;
		c9 = new Corona(tilemaps);
		c9.setPosition(4530,270);
		enemies.add(c9);
		
		Corona c10;
		c10 = new Corona(tilemaps);
		c10.setPosition(5960,270);
		enemies.add(c10);
		
		Corona c11;
		c11 = new Corona(tilemaps);
		c11.setPosition(6340,270);
		enemies.add(c11);
		
		
		Corona c12;
		c12 = new Corona(tilemaps);
		c12.setPosition(7700,270);
		enemies.add(c12);
		
		Corona c13;
		c13 = new Corona(tilemaps);
		c13.setPosition(8000,300);
		enemies.add(c13);
		
		
		StayCorona cs;
		cs = new StayCorona(tilemaps);
		cs.setPosition(790,210);
		enemies.add(cs);
		
		StayCorona cs2;
		cs2 = new StayCorona(tilemaps);
		cs2.setPosition(2100,150);
		enemies.add(cs2);
		
		StayCorona cs3;
		cs3 = new StayCorona(tilemaps);
		cs3.setPosition(2310,180);
		enemies.add(cs3);

		StayCorona cs4;
		cs4 = new StayCorona(tilemaps);
		cs4.setPosition(2495,180);
		enemies.add(cs4);
		
		StayCorona cs5;
		cs5 = new StayCorona(tilemaps);
		cs5.setPosition(2560,305);
		enemies.add(cs5);
		
		StayCorona cs6;
		cs6= new StayCorona(tilemaps);
		cs6.setPosition(480,300);
		enemies.add(cs6);
		
		StayCorona cs7;
		cs7= new StayCorona(tilemaps);
		cs7.setPosition(800,330);
		enemies.add(cs7);
		
		StayCorona cs8;
		cs8= new StayCorona(tilemaps);
		cs8.setPosition(2010,300);
		enemies.add(cs8);
		
		StayCorona cs9;
		cs9= new StayCorona(tilemaps);
		cs9.setPosition(2370,330);
		enemies.add(cs9);
		
		StayCorona cs10;
		cs10= new StayCorona(tilemaps);
		cs10.setPosition(2675,245);
		enemies.add(cs10);
		
		StayCorona cs11;
		cs11= new StayCorona(tilemaps);
		cs11.setPosition(3450,270);
		enemies.add(cs11);
		
		StayCorona cs12;
		cs12= new StayCorona(tilemaps);
		cs12.setPosition(3840,210);
		enemies.add(cs12);
		
		StayCorona cs13;
		cs13= new StayCorona(tilemaps);
		cs13.setPosition(4050,240);
		enemies.add(cs13);
		
		StayCorona cs14;
		cs14= new StayCorona(tilemaps);
		cs14.setPosition(4680,240);
		enemies.add(cs14);
		
		StayCorona cs15;
		cs15= new StayCorona(tilemaps);
		cs15.setPosition(5040,240);
		enemies.add(cs15);
		
		StayCorona cs16;
		cs16= new StayCorona(tilemaps);
		cs16.setPosition(5790,300);
		enemies.add(cs16);
		
		StayCorona cs17;
		cs17= new StayCorona(tilemaps);
		cs17.setPosition(6330,180);
		enemies.add(cs17);
		
		StayCorona cs18;
		cs18= new StayCorona(tilemaps);
		cs18.setPosition(6645,318);
		enemies.add(cs18);
		
		StayCorona cs19;
		cs19= new StayCorona(tilemaps);
		cs19.setPosition(7505,300);
		enemies.add(cs19);
		
		StayCorona cs20;
		cs20= new StayCorona(tilemaps);
		cs20.setPosition(7730,180);
		enemies.add(cs20);
		
		StayCorona cs21;
		cs21= new StayCorona(tilemaps);
		cs21.setPosition(7830,345);
		enemies.add(cs21);
		
		StayCorona cs22;
		cs22= new StayCorona(tilemaps);
		cs22.setPosition(8150,270);
		enemies.add(cs22);
		
		StayCorona cs23;
		cs23= new StayCorona(tilemaps);
		cs23.setPosition(8280,275);
		enemies.add(cs23);
		
		
		Habib1 h1;
		h1 = new Habib1(tilemaps);
		h1.setPosition(1140,340);
		enemies.add(h1);
		
		Habib1 h2;
		h2 = new Habib1(tilemaps);
		h2.setPosition(3000,340);
		enemies.add(h2);
		
		Habib1 h3;
		h3 = new Habib1(tilemaps);
		h3.setPosition(3800,340);
		enemies.add(h3);
		
		Bushra b1;
		b1 = new Bushra(tilemaps);
		b1.setPosition(1650,330);
		enemies.add(b1);
		
		Bushra b2;
		b2 = new Bushra(tilemaps);
		b2.setPosition(4140,330);
		enemies.add(b2);
		
		Bushra b3;
		b3 = new Bushra(tilemaps);
		b3.setPosition(5220,330);
		enemies.add(b3);
		
		
		Habibti hb;
		hb = new Habibti(tilemaps);
		hb.setPosition(2070,340);
		enemies.add(hb);
		
		Habibti hb2;
		hb2 = new Habibti(tilemaps);
		hb2.setPosition(4295,340);
		enemies.add(hb2);
		
		Habibti hb3;
		hb3 = new Habibti(tilemaps);
		hb3.setPosition(6242,340);
		enemies.add(hb3);
		
		Habibti hb4;
		hb4 = new Habibti(tilemaps);
		hb4.setPosition(7600,340);
		enemies.add(hb4);
		
		Aladin a;
		a = new Aladin(tilemaps);
		a.setPosition(2797,330);
		enemies.add(a);
		
		Aladin a2;
		a2 = new Aladin(tilemaps);
		a2.setPosition(4920,340);
		enemies.add(a2);
		
		Aladin a3;
		a3 = new Aladin(tilemaps);
		a3.setPosition(7160,340);
		enemies.add(a3); 
		
		
	}
	

	@Override
	public void update() {
		
		handleInput();
		
		
		// play events
		if(eventStart) {
			eventStart();
		}

		
		//background
		sky.setPosition(tilemaps.getXcord(), 0);
		land.setPosition(tilemaps.getXcord(), 0);
		
		player.update();
		


		//attacking on enemies
		player.checkAttack(enemies);
		
		// update all enemies
		for(int i = 0; i < enemies.size(); i++) {
			Enemy es = enemies.get(i);
			es.update();
			

			if((es instanceof Habib1)  && es.isDead()) {

			}
			
			else if((es instanceof Bushra ) && es.isDead()) {
				enemies.remove(i);
				MusicPlayer.play("enemyhit");
				i--;
			}
			
			else if((es instanceof Habibti ) && es.isDead()) {
				enemies.remove(i);
				MusicPlayer.play("enemyhit");
				i--;
			}
			else if((es instanceof Aladin ) && es.isDead()) {
			}
			
			else if(es.isDead()) {
				MusicPlayer.play("enemyhit");
				enemies.remove(i);
				i--;
			}
			
			
		}

		
		if(((player.getx()>870&&player.getx()<930)&&(player.gety()>330&&player.gety()<390))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>25){
				player.setFire(25);
			}
		}
		
		if(((player.getx()>2400&&player.getx()<2460)&&(player.gety()>330&&player.gety()<390))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>25){
				player.setFire(25);
			}
		}
		
		if(((player.getx()>3600&&player.getx()<3660)&&(player.gety()>330&&player.gety()<390))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>25){
				player.setFire(25);
			}
		}
		
		if(((player.getx()>6030&&player.getx()<6120)&&(player.gety()>290&&player.gety()<330))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>25){
				player.setFire(25);
			}
		}
		
		if(((player.getx()>4650&&player.getx()<4710)&&(player.gety()>340&&player.gety()<390))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>2010&&player.getx()<2040)&&(player.gety()>120&&player.gety()<150))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>3120&&player.getx()<3150)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>4180&&player.getx()<4250)&&(player.gety()>320&&player.gety()<360))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>6700&&player.getx()<6760)&&(player.gety()>260&&player.gety()<310))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if((player.getx()>8310&&player.getx()<8370)&&(player.getPicking())) {
			MusicPlayer.play("moral");
			eventDead();
			
		}
		


		if(player.getHealth()==0) {
			MusicPlayer.stop("bgmini");
			MusicPlayer.stop("run");
			eventDead();
		}
		

	}

	@Override
	public void draw(Graphics2D g) {
		
		sky.draw(g);
		land.draw(g);
		
		//drawing the tilemap
		tilemaps.draw(g);
		tilemaps.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
	
	
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		g.setColor(warnColor);
		g.setFont(warnFont);
		

		//draw player
		player.draw(g);
		
		hud.draw(g);
		
		g.setColor(warnColor);
		g.setFont(warnFont);
		
		
		if(player.getx()>90 && player.getx()<300 ) {
			g.drawString("\"I've heard some gold coins lie in this valley.",30, 60);
			g.drawString("I must find 'em\"",30, 80);
			 
		}
		
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
	
		if(InputKeys.isPressed(InputKeys.PICKBUTTON)) 
			player.setPicking();
		
		if(InputKeys.isPressed(InputKeys.SPRAYBUTTON)) {
			player.setFiring();
				
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
	


	// player has died
	private void eventDead() {
		//dead boolean set to true
		
		player.setDead();
		MusicPlayer.stop("walk");
		gsm.setState(GameStateManager.DEADSTATE);

	}

}
