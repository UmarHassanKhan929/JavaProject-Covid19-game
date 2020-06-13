
/*
 * 
 * 
 * 			Control menu stuff
 * 
 * 
 */
package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import ControlHandlers.InputKeys;
import TileMap.BackGround;

public class ControlMenu extends GameState{
	
	
	private BackGround controlBG;
	
	private Font title;
	private Color titleColor;
	
	private Font textmsg;
	private Color textColor;

	//constructor
	public ControlMenu(GameStateManager gameStateManager) {
		super(gameStateManager);  //invoke
		
		try {
			
			title = new Font("Century Gothic", Font.BOLD, 14);
			titleColor = new Color(255,255,255);
			
			textmsg = new Font("Century Gothic",Font.PLAIN,10);
			textColor = new Color(255,255,255);
		
			controlBG = new BackGround("/Backgrounds/helpbg3.jpg", 0.01);
			
		
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}

	
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update() {
		controlBG.update();
		handleInput();
		
	}



	@Override
	public void draw(Graphics2D g) {
		
		controlBG.draw(g);
		// draw title
		g.setColor(titleColor);
		g.setFont(title);
		g.drawString("CONTROL MENU", 120, 14);
							
		//subtitle
		g.setColor(textColor);
		g.setFont(textmsg);
		g.drawString("'UP DOWN ARROW' KEY   -> for menu option choose", 10, 48);
		g.drawString("'ENTER' KEY  ->  to select option", 10, 68);
		g.drawString("'LEFT RIGHT ARROW' KEY  ->  for character movement", 10, 88);
		g.drawString("'SPACE' key  ->   for jump", 10, 108);
		g.drawString("'A' key  ->   for PickUp", 10, 128);
		g.drawString("'D' key  ->   for disinfecting virus", 10, 148);
		g.drawString("ESCAPE key to go back", 180, 210);
	
		
	}
	
	
	public void handleInput() {
		if(InputKeys.isPressed(InputKeys.ESCAPE)) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
		
	}
}
