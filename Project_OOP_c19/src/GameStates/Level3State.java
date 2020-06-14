/*
 * 
 * 			Level 3 class
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
import Entity.Npc;
import Entity.Player;
import Entity.Enemies.Bushra;
import Entity.Enemies.Corona;
import Entity.Enemies.Habib1;
import Entity.Enemies.StayCorona;
import Entity.Npcs.FatMan;
import Entity.Npcs.Finn;
import Entity.Npcs.Jameel;
import Entity.Npcs.Jameela;
import Entity.Npcs.Kimg;
import Entity.Npcs.UncleBob;
import Entity.Npcs.UncleJojo;
import Main.GamePanel;
import TileMap.BackGround;
import TileMap.TileMap;

public class Level3State extends GameState{
	
	private TileMap tilemaps;
	private BackGround bglevel3a;
	
	private HUD hud;
	private ArrayList<Enemy> enemies;
	private ArrayList<Npc> npcs;
	
	private Font warnFont;
	private Color warnColor;
	
	private Player player;

	//events
	private int eventCount = 0;
	private boolean eventStart;
	private Rectangle tbu,tbd;


	public Level3State(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {

		//event for screen
		eventCount = 0;
				
		//musics		
		MusicPlayer.stop("level1");
		MusicPlayer.stop("level-2");
		
		MusicPlayer.loop("level3", 400, MusicPlayer.getFrames("level3") - 1600);
		
		//tiles stuff
		tilemaps = new TileMap(30);
		tilemaps.loadTiles("/TileSets/CVTileSet.png");
		tilemaps.loadMap("/Maps/Level3.map");
		tilemaps.setPosition(0, 0);
				
				
		//backgroud selection
		bglevel3a = new BackGround("/Backgrounds/level3.jpg", 0.00);			
				
		//new player
		player = new Player(tilemaps,"/Sprites/Player/Unnamed.png");
		player.setPosition(45, 80);
				
				
		populateNpcs();
		populateEnemies();
				
		hud = new HUD(player);
		
		// start event
		eventStart = true;
		tbu = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
		tbd = new Rectangle(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT); 
				
			
		warnColor = new Color(0, 255, 255);
		warnFont = new Font("Times New Roman",Font.PLAIN,12);
		
	}
	
	//npcs method
	public void populateNpcs() {
		npcs = new ArrayList<Npc>();
		
		UncleBob ub;
		ub = new UncleBob(tilemaps);
		ub.setPosition(1340,1133);
		npcs.add(ub);
		
		UncleBob ub2;
		ub2 = new UncleBob(tilemaps);
		ub2.setPosition(990,760);
		npcs.add(ub2);
		
		UncleJojo uj;
		uj = new UncleJojo(tilemaps);
		uj.setPosition(1053,880);
		npcs.add(uj);
		
		UncleJojo uj2;
		uj2 = new UncleJojo(tilemaps);
		uj2.setPosition(1260,650);
		npcs.add(uj2);
		
		UncleJojo uj3;
		uj3 = new UncleJojo(tilemaps);
		uj3.setPosition(1111,290);
		npcs.add(uj3);
		
		
		Finn fn;
		fn = new Finn(tilemaps);
		fn.setPosition(180,890);
		npcs.add(fn);
		
		FatMan fm;
		fm = new FatMan(tilemaps);
		fm.setPosition(640,890);
		npcs.add(fm);
		
		Jameel jj;
		jj = new Jameel(tilemaps);
		jj.setPosition(1350,900);
		npcs.add(jj);
		
		Kimg kimg;
		kimg = new Kimg(tilemaps);
		kimg.setPosition(1300,1120);
		npcs.add(kimg);
		
		
		Jameela jameela;
		jameela = new Jameela(tilemaps);
		jameela.setPosition(930,770);
		npcs.add(jameela);
		
		FatMan fm2;
		fm2 = new FatMan(tilemaps);
		fm2.setPosition(1200,645);
		npcs.add(fm2);
		
		
		Jameel jj2;
		jj2 = new Jameel(tilemaps);
		jj2.setPosition(1530,175);
		npcs.add(jj2);
		
		
	}
	
	//enemies method
	public void populateEnemies() {
		enemies = new ArrayList<Enemy>();
		
		StayCorona cs;
		cs = new StayCorona(tilemaps);
		cs.setPosition(50,360);
		enemies.add(cs);
		
		StayCorona cs2;
		cs2 = new StayCorona(tilemaps);
		cs2.setPosition(90,470);
		enemies.add(cs2);
		
		StayCorona cs3;
		cs3 = new StayCorona(tilemaps);
		cs3.setPosition(1230,880);
		enemies.add(cs3);
		
		StayCorona cs4;
		cs4 = new StayCorona(tilemaps);
		cs4.setPosition(1245,450);
		enemies.add(cs4);
		
		StayCorona cs5;
		cs5 = new StayCorona(tilemaps);
		cs5.setPosition(985,332);
		enemies.add(cs5);
		
		StayCorona cs6;
		cs6 = new StayCorona(tilemaps);
		cs6.setPosition(1380,655);
		enemies.add(cs6);
		
		StayCorona cs7;
		cs7 = new StayCorona(tilemaps);
		cs7.setPosition(1348,283);
		enemies.add(cs7);
		
		
		Corona c;
		c = new Corona(tilemaps);
		c.setPosition(30,440);
		enemies.add(c);
		
		Corona c2;
		c2 = new Corona(tilemaps);
		c2.setPosition(280,840);
		enemies.add(c2);
		
		Corona c3;
		c3 = new Corona(tilemaps);
		c3.setPosition(915,745);
		enemies.add(c3);
		
		Corona c4;
		c4 = new Corona(tilemaps);
		c4.setPosition(1240,620);
		enemies.add(c4);
		
		Corona c5;
		c5 = new Corona(tilemaps);
		c5.setPosition(930,510);
		enemies.add(c5);
		
		Corona c6;
		c6 = new Corona(tilemaps);
		c6.setPosition(1500,180);
		enemies.add(c6);
		
		Habib1 h1;
		h1 = new Habib1(tilemaps);
		h1.setPosition(570,890);
		enemies.add(h1);
		
		Habib1 h2;
		h2 = new Habib1(tilemaps);
		h2.setPosition(2400,150);
		enemies.add(h2);
		
		Bushra b1;
		b1 = new Bushra(tilemaps);
		b1.setPosition(1080,405);
		enemies.add(b1);
		
		Bushra b2;
		b2 = new Bushra(tilemaps);
		b2.setPosition(1780,165);
		enemies.add(b2);
	}

	
	@Override
	public void update() {

		handleInput();
		
		// play event
		if(eventStart) {
			eventStart();
		}
					
		
		//background
		bglevel3a.setPosition(tilemaps.getXcord(), tilemaps.getYcord());

		//player
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
			
			else if(es.isDead()) {
				MusicPlayer.play("enemyhit");
				enemies.remove(i);
				i--;
			}
		}
			
		for(int i = 0; i < npcs.size(); i++) {
			Npc npc = npcs.get(i);
			npc.update();
			
		}
		
		//mask.update();
		
		if(((player.getx()>30&&player.getx()<90)&&(player.gety()>260&&player.gety()<300))&&(player.getPicking())) {
			int ammo = player.getFire();
			
			player.setFire(ammo+1);
			if(player.getFire()>5){
				player.setFire(5);
			}
		}
		
		if(((player.getx()>810&&player.getx()<870)&&(player.gety()>1110&&player.gety()<1140))&&(player.getPicking())) {
			int ammo = player.getFire();
			
			player.setFire(ammo+1);
			if(player.getFire()>10){
				player.setFire(10);
			}
		}
		
		if(((player.getx()>1440&&player.getx()<1500)&&(player.gety()>630&&player.gety()<660))&&(player.getPicking())) {
			
			int health = player.getHealth();
			
			player.setHealth(health+1);
			
			if(player.getHealth()>5){
				player.setHealth(5);
			}
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
		// TODO Auto-generated method stub
		
		bglevel3a.draw(g);
		
		//drawing the tilemap
		tilemaps.draw(g);
		
		tilemaps.setPosition(GamePanel.WIDTH / 2 - player.getx(),GamePanel.HEIGHT / 2 - player.gety());
		
		

		
		//font
		g.setColor(warnColor);
		g.setFont(warnFont);
		

		//Story lines
			
		
		if((player.getx()>30)&&(player.getx()<60)&&(player.gety()>90)&&(player.gety()<120)) {
			g.drawString("Cool Jamal was chilling at a hill-view point", 60, 25);
			g.drawString("when all of a sudden news flashed in.", 60, 35);		
		}
		
		if((player.getx()>150)&&(player.getx()<180)&&(player.gety()>150)&&(player.gety()<180)) {
			g.drawString("The Government has issued countrywide lockdown", 50, 25);
			g.drawString("to prevent the spread of virus.", 50, 35);		
		}
		
		if((player.getx()>180)&&(player.getx()<210)&&(player.gety()>150)&&(player.gety()<180)) {
			g.drawString("Cool Jamal starts getting anxious....", 80, 25);		
		}
		
		
		if((player.getx()>240)&&(player.getx()<270)&&(player.gety()>270)&&(player.gety()<300)) {
			g.drawString("slowly becoming uncool", 90, 25);		
		}
		
		if((player.getx()>150)&&(player.getx()<180)&&(player.gety()>270)&&(player.gety()<300)) {
			g.drawString("~Check out that room~",90, 25);		
		}
		
		if((player.getx()>100)&&(player.getx()<120)&&(player.gety()>270)&&(player.gety()<300)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>120)&&(player.getx()<150)&&(player.gety()>270)&&(player.gety()<300)) {
			g.drawString("~press \"A\" to pick up Sanitizer and \"D\" to spray~", 50, 35);		
		}
		
		if((player.getx()>60)&&(player.getx()<90)&&(player.gety()>270)&&(player.gety()<300)) {
			g.drawString("~Sanitizer can be used to disinfect the virus", 70, 35);	
			g.drawString(" and the people carrying the virus.~", 70, 45);
			
		}
		
		if((player.getx()>60)&&(player.getx()<180)&&(player.gety()>360)&&(player.gety()<390)) {
			g.drawString("~However, it cannot cure those who are infected ", 50, 35);	
			g.drawString(" so always keep your distance~", 50, 45);
			
		}
		
		if((player.getx()>30)&&(player.getx()<60)&&(player.gety()>540)&&(player.gety()<570)) {
			g.drawString("Uncool Jamal hurries to the Super Market to buy ", 50, 35);	
			g.drawString("toilet paper.", 50, 45);
			
		}
		
		if((player.getx()>120)&&(player.getx()<150)&&(player.gety()>600)&&(player.gety()<630)) {
			g.drawString("For humanity would've perished long ago, ", 80, 35);	
			g.drawString("had it not been for toilet paper.", 80, 45);
			
		}
		
		
		if((player.getx()>750)&&(player.getx()<780)&&(player.gety()>900)&&(player.gety()<930)) {
			g.drawString("Hmmm, Probably should check out the basement first.", 45, 35);	
		}
		
		if((player.getx()>1020)&&(player.getx()<1080)&&(player.gety()>630)&&(player.gety()<690)) {
			g.drawString("\"There are not much left, ", 90, 35);	
			g.drawString("  better buy all the remaining stock\"", 90, 45);
		}
		
		if((player.getx()>1080)&&(player.getx()<1110)&&(player.gety()>630)&&(player.gety()<690)) {
			g.drawString("~Wearing a Mask can be helpful~", 90, 35);	
		
		}
		
		if((player.getx()>1330)&&(player.getx()<1380)&&(player.gety()>630)&&(player.gety()<690)) {
			g.drawString("This just turned into a survival hunt", 100, 35);	
	
		}
		
		if((player.getx()>1410)&&(player.getx()<1420)&&(player.gety()>630)&&(player.gety()<660)) {
			MusicPlayer.play("ding");
		}
		if((player.getx()>1410)&&(player.getx()<1440)&&(player.gety()>630)&&(player.gety()<690)) {
		g.drawString("~Press \"A\" near mask to wear one~", 90, 50);	
		}
		if((player.getx()>1320)&&(player.getx()<1350)&&(player.gety()>510)&&(player.gety()<540)) {
			g.drawString("Uncool Jamal buys too much toiler paper ", 70, 35);	
			g.drawString("and nothing to eat.", 70, 45);
		}
		
		if((player.getx()>1290)&&(player.getx()<1320)&&(player.gety()>300)&&(player.gety()<330)) {
			g.drawString("He hurries towards his house.", 100, 35);	

		}
		
		if((player.getx()>2660)&&(player.getx()<2710)) {
			g.drawString("~Press Y to go to next Level~", 78, 30);
			
		}
		
		
		//draw npcs
		for(int i = 0; i < npcs.size(); i++) {
			npcs.get(i).draw(g);
		}
		
		
		// draw enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
				
		player.draw(g);
		
//		int x;
//		x=player.getx();
//		g.drawString(""+x, 50, 20);
//		int y;
//		y=player.gety();
//		g.drawString(""+y, 50, 40);
//		
		hud.draw(g);
		
		
				
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		g.fill(tbu);
		g.fill(tbd);
	}

	@Override
	public void handleInput() {
		
		if(InputKeys.isPressed(InputKeys.ESCAPE)) 
			gsm.setPaused(true);
	
		player.setUp(InputKeys.currentKeyState[InputKeys.UP]);
		
		player.setLeft(InputKeys.currentKeyState[InputKeys.LEFT]);
		
		player.setDown(InputKeys.currentKeyState[InputKeys.DOWN]);
		
		player.setRight(InputKeys.currentKeyState[InputKeys.RIGHT]);
		
		player.setJumping(InputKeys.currentKeyState[InputKeys.JUMPBUTTON]);
		if(InputKeys.isPressed(InputKeys.JUMPBUTTON)) {
			MusicPlayer.play("yeet");
		}
		
		if(InputKeys.isPressed(InputKeys.PICKBUTTON)) {
			player.setPicking();
			
		}
		
		
		if(InputKeys.isPressed(InputKeys.SPRAYBUTTON)) {
			player.setFiring();
				
		}
		
		if(player.getx()>2700 && player.getx()<2760) {
			if(InputKeys.isPressed(InputKeys.CONFIRM)) {
				MusicPlayer.stop("level3");
				gsm.setState(GameStateManager.LEVEL4PROLOGUESTATE);
			}
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
