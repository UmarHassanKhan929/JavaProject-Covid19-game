/*
 * 
 * 		help menu class
 * 
 * 
 */


package GameStates;

import ControlHandlers.InputKeys;
import TileMap.BackGround;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HelpMenu extends GameState{
	
	private BufferedImage Sanitizer;
	private BufferedImage Soap;
	
	private BackGround helpBG; //help menu background
	
	private Color titleColor;
	private Font title;  //title for help menu
	
	private Color textColor;
	private Font textmsg;  //text message for help menu

	public HelpMenu(GameStateManager gameStateManager) {
		
		super(gameStateManager);  //invoke
		
		try {
			
			Soap = ImageIO.read(getClass().getResourceAsStream("/Icons/soapsanit.png")).getSubimage(0, 0, 12, 11);
			Sanitizer = ImageIO.read(getClass().getResourceAsStream("/Icons/soapsanit.png")).getSubimage(0, 12, 12, 11);
			
			title = new Font("Century Gothic", Font.BOLD, 14);
			titleColor = new Color(255,255,255);
			
			textmsg = new Font("Century Gothic",Font.PLAIN,10);
			//color set at white			
			textColor = new Color(255,255,255);
		
			helpBG = new BackGround("/Backgrounds/helpbg3.jpg", 0.01);
		
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {
		helpBG.update();
		handleInput();
	}

	@Override
	public void draw(Graphics2D g) {
		helpBG.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(title);
		g.drawString("HELP MENU", 120, 14);
					
		//subtitle
	    //describing the  situation using panel and strings
		
		g.setColor(textColor);
		g.setFont(textmsg);
		g.drawString("2020, the year which began like anyother year, but", 10, 28);
		g.drawString("brought a pandemic with it. Corona Virus, a virus which", 10, 38);
		g.drawString("seemed like anyother oridinary flu started appearing in ", 10, 48);
		g.drawString("Humans, rumors are that it started from Bats, but who ", 10, 58);
		g.drawString("knows. ", 10, 68);
		g.drawString("Symptons like Respiratory issues, dry cough, fever ", 10, 88);
		g.drawString("were shown by the patients infected with it.", 10, 98);
		g.drawString("This virus is highly contagious and patients have ", 10, 108);
		g.drawString("fatality rate of 2-4%", 10, 118);
		g.drawString("No proper vaccine is yet made", 10, 138);
		g.drawString("Hence precaution is necessary in order to stay safe", 10, 148);
		
		g.drawString(" ~) Avoid Going out as much as you can,", 10, 158);
		g.drawString(" ~) Maintain Social distancing", 10, 168);
		g.drawString(" ~) Wash hands with soap after every two hours", 10, 178);
		g.drawImage(Soap, 260, 170, null);
		g.drawString(" ~) Make a habit of usage of sanitizer", 10, 188);
		g.drawImage(Sanitizer, 208, 180, null);
		g.drawString(" ~) Cover your face while sneezing,coughing", 10, 198);
		
		
	}

	@Override
	public void handleInput() {
		
		if(InputKeys.isPressed(InputKeys.ESCAPE)) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
		
	}

}
