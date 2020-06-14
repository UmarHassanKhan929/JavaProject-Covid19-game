/*
 * 
 * 				Level4 class and all its material
 * 
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


public class Level4State extends GameState{
	
	private TileMap tilemaps;
	
	private BackGround bglevel4;
	
	private HUD hud;
	
	private ArrayList<Enemy> enemies;
	
	private Font warnFont;
	private Color warnColor;
	
	private Player player;
	
	
	//events
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;
	


	public Level4State(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		//event for screen
		eventCount = 0;

		tilemaps  = new TileMap(30);
		tilemaps.loadTiles("/TileSets/CVTileSet.png");
		tilemaps.loadMap("/Maps/Level4.map");
		tilemaps.setPosition(0,0);
		
		bglevel4 = new BackGround("/Backgrounds/levelall.png", 0.02);
		
		player = new Player(tilemaps,"/Sprites/Player/Unnamed2.png");
		player.setPosition(100, 330);
		
		
		populateEnemies();
		
		hud = new HUD(player);
		
		// start event
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		
		
		warnColor = new Color(0, 255, 255);
		warnFont = new Font("Times New Roman",Font.PLAIN,12);
		
		MusicPlayer.loop("level4", 400, MusicPlayer.getFrames("level4") - 1600);
		
	}
	
	//populating enemies method
	public void populateEnemies(){
		
		enemies = new ArrayList<Enemy>();
		
		StayCorona cs;
		cs = new StayCorona(tilemaps);
		cs.setPosition(308,306);
		enemies.add(cs);
		
		StayCorona cs2;
		cs2 = new StayCorona(tilemaps);
		cs2.setPosition(2458,300);
		enemies.add(cs2);
		
		StayCorona cs3;
		cs3 = new StayCorona(tilemaps);
		cs3.setPosition(4800,300);
		enemies.add(cs3);
		
		StayCorona cs4;
		cs4 = new StayCorona(tilemaps);
		cs4.setPosition(6660,300);
		enemies.add(cs4);
		
		StayCorona cs5;
		cs5 = new StayCorona(tilemaps);
		cs5.setPosition(8262,270);
		enemies.add(cs5);
		
		StayCorona cs6;
		cs6 = new StayCorona(tilemaps);
		cs6.setPosition(9000,330);
		enemies.add(cs6);
		
		StayCorona cs7;
		cs7 = new StayCorona(tilemaps);
		cs7.setPosition(9100,320);
		enemies.add(cs7);
		
		StayCorona cs8;
		cs8 = new StayCorona(tilemaps);
		cs8.setPosition(9180,330);
		enemies.add(cs8);
		
		StayCorona cs9;
		cs9 = new StayCorona(tilemaps);
		cs9.setPosition(9300,320);
		enemies.add(cs9);
		
		Corona c;
		c = new Corona(tilemaps);
		c.setPosition(270,240);
		enemies.add(c);
		
		Corona c2;
		c2 = new Corona(tilemaps);
		c2.setPosition(660,270);
		enemies.add(c2);
		
		Corona c3;
		c3 = new Corona(tilemaps);
		c3.setPosition(500,330);
		enemies.add(c3);
		
		Corona c8;
		c8 = new Corona(tilemaps);
		c8.setPosition(811,301);
		enemies.add(c8);
		
		Corona c4;
		c4 = new Corona(tilemaps);
		c4.setPosition(1100,210);
		enemies.add(c4);
		
		Corona c5;
		c5 = new Corona(tilemaps);
		c5.setPosition(1530,330);
		enemies.add(c5);
		
		Corona c6;
		c6 = new Corona(tilemaps);
		c6.setPosition(1470,240);
		enemies.add(c6);
		
		Corona c7;
		c7 = new Corona(tilemaps);
		c7.setPosition(2467,245);
		enemies.add(c7);
		
		Corona c9;
		c9 = new Corona(tilemaps);
		c9.setPosition(2790,300);
		enemies.add(c9);
		
		Corona c10;
		c10 = new Corona(tilemaps);
		c10.setPosition(2890,272);
		enemies.add(c10);
		
		Corona c11;
		c11 = new Corona(tilemaps);
		c11.setPosition(3620,272);
		enemies.add(c11);
		
		Corona c12;
		c12 = new Corona(tilemaps);
		c12.setPosition(4000,330);
		enemies.add(c12);
		
		Corona c13;
		c13 = new Corona(tilemaps);
		c13.setPosition(5000,300);
		enemies.add(c13);
		
		Corona c14;
		c14 = new Corona(tilemaps);
		c14.setPosition(5650,273);
		enemies.add(c14);
		
		Corona c15;
		c15 = new Corona(tilemaps);
		c15.setPosition(6710,330);
		enemies.add(c15);
		
		Corona c16;
		c16 = new Corona(tilemaps);
		c16.setPosition(7111,321);
		enemies.add(c16);
		
		Corona c17;
		c17 = new Corona(tilemaps);
		c17.setPosition(8100,308);
		enemies.add(c17);
		
		
		Habib1 h1;
		h1 = new Habib1(tilemaps);
		h1.setPosition(430,310);
		enemies.add(h1);
		
		Habib1 h2;
		h2 = new Habib1(tilemaps);
		h2.setPosition(6000,300);
		enemies.add(h2);
		
		Bushra b1;
		b1 = new Bushra(tilemaps);
		b1.setPosition(1240,310);
		enemies.add(b1);
		
		Bushra b2;
		b2 = new Bushra(tilemaps);
		b2.setPosition(4350,300);
		enemies.add(b2);
		
		Habibti hb;
		hb = new Habibti(tilemaps);
		hb.setPosition(1960,310);
		enemies.add(hb);
		
		Habibti hb2;
		hb2 = new Habibti(tilemaps);
		hb2.setPosition(3000,300);
		enemies.add(hb2);
		
		Aladin a;
		a = new Aladin(tilemaps);
		a.setPosition(2670,315);
		enemies.add(a);
		
		Aladin a2;
		a2 = new Aladin(tilemaps);
		a2.setPosition(3800,300);
		enemies.add(a2);
		
		Aladin a3;
		a3 = new Aladin(tilemaps);
		a3.setPosition(7900,300);
		enemies.add(a3);
		
	}
	

	@Override
	public void update() {
		
		handleInput();
		
		// play event
		if(eventStart) {
			eventStart();
		}
		
		
		bglevel4.setPosition(tilemaps.getXcord(), tilemaps.getYcord());
		
		
		player.update();
		
		//attacking on enemies
		player.checkAttack(enemies);
		
		// update all enemies
		for(int i = 0; i < enemies.size(); i++) {
			Enemy es = enemies.get(i);
			es.update();
					

			if((es instanceof Habib1)  && es.isDead()) {

				es.setDamage(0);

			}
					
			else if((es instanceof Bushra ) && es.isDead()) {
				es.setDamage(0);
			}
			
			else if((es instanceof Habibti ) && es.isDead()) {
				es.setDamage(0);
			}
			
			else if((es instanceof Aladin ) && es.isDead()) {
				es.setDamage(0);
			}
					
			else if(es.isDead()) {
				MusicPlayer.play("enemyhit");
				enemies.remove(i);
				i--;
			}
		}
					

		
		
		if(((player.getx()>60&&player.getx()<90)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>10){
				player.setFire(10);
			}
		}
		
		if(((player.getx()>60&&player.getx()<90)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>10){
				player.setFire(10);
			}
		}
		
		if(((player.getx()>960&&player.getx()<990)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>15){
				player.setFire(15);
			}
		}
		
		if(((player.getx()>3630&&player.getx()<3720)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>20){
				player.setFire(20);
			}
		}
		
		if(((player.getx()>6810&&player.getx()<6840)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int ammo = player.getFire();
			player.setFire(ammo+1);
			if(player.getFire()>25){
				player.setFire(25);
			}
		}
		
		if(((player.getx()>2700&&player.getx()<2800)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>5190&&player.getx()<5250)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(((player.getx()>8550&&player.getx()<8599)&&(player.gety()>330&&player.gety()<360))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
		}
		
		if(player.getx()>9100 && player.isDead()) {
			gsm.setState(GameStateManager.FINALESTATE);
		}
		
		
		if(player.getx()>9400) {
			player.setDead(true);
		}
		
		if(player.isDead()&& (player.getx()<9400) ) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			init();
		}
		
		
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		bglevel4.draw(g);
		
		tilemaps.draw(g);
		
		tilemaps.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		player.draw(g);
		
		hud.draw(g);
		
		
		g.setColor(warnColor);
		g.setFont(warnFont);
		
		
		if(player.getx()>600 && player.getx()<630 && player.gety()>270 && player.gety()<300) {
			g.drawString("\"Hmm no luck here\"", 110, 30);
		}
		
		if(player.getx()>930 && player.getx()<960 && player.gety()>180 && player.gety()<210) {
			g.drawString("\"Got to go to the market then. Can\'t be helped\"", 50, 30);
		}
		
		if(player.getx()>1590 && player.getx()<1640) {
			g.drawString("\"Are you kidding me????\"", 100, 30);
		}
		if(player.getx()>1770 && player.getx()<1800) {
			g.drawString("Jamal was frustrated", 110, 30);
		}
		if(player.getx()>1800 && player.getx()<1860) {
			g.drawString("All he had found was traces of food", 70, 30);
		}
		
		if(player.getx()>2460 && player.getx()<2490) {
			g.drawString("Surgical masks do not protect you from the virus, ", 50, 30);
			g.drawString("rather they protect others from your sneezes ", 50, 40);
			
		}
		if(player.getx()>2500 && player.getx()<2520) {
			g.drawString("~Press \"A\" to equip Mask and replenish health~ ", 50, 30);
			
			
		}
		
		if(player.getx()>8610 && player.getx()<8640) {
			g.drawString("Jamal was able to find barely enough to last him", 50, 30);
			g.drawString("for two days", 50, 40);
		}
		
		if(player.getx()>8700 && player.getx()<8730) {
			g.drawString("He heads straight home cursing his inability to understand", 40, 30);
			g.drawString("something that should\'ve been involuntary to any human.", 40, 40);
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

		}
		
		if(InputKeys.isPressed(InputKeys.PICKBUTTON)) {
			player.setPicking();
			
		}
		
		
		
		if(InputKeys.isPressed(InputKeys.SPRAYBUTTON)) {
			player.setFiring();
				
		}
			
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
