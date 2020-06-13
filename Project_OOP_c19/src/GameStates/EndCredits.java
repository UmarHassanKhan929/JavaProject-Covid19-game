package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Audio.MusicPlayer;
import ControlHandlers.InputKeys;
import Main.GamePanel;

public class EndCredits extends GameState{
	
	
	//Player player;
	
	private Font textFont;
	private Font textFont2;
	
    private int count;
	
    //constructor
	public EndCredits(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}
	


	@Override
	public void init() {
		this.setTextFont(new Font("Century Gothic",Font.BOLD,16));
		 setTextFont2(new Font("Century Gothic",Font.ITALIC,50));
		 MusicPlayer.loop("ending", 400, MusicPlayer.getFrames("ending") - 1600);
	}
	
	@Override
	public void update() {
		handleInput();
		
	}
	
	//drawing credits
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		

		g.setFont(new Font("Century Gothic",Font.BOLD,26));
		g.drawString("  RIP JAMAL\n   2000-2020 ", 10, 70);
		g.setFont(new Font("Times New Roman",Font.PLAIN,13));
		
        count++;
        
        
        if(count>300) {
        	g.setColor(Color.BLACK);
    		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    		g.setColor(Color.WHITE);
    		
    		g.setFont(new Font("Century Gothic",Font.BOLD,15));
    		g.drawString("  D I R E C T O R S:      ", 10, 50);
    		
    		g.setFont(new Font("Century Gothic",Font.PLAIN,10));
    	    g.drawString("  Muhammad Noman Shahid         ", 10, 70);
    		g.drawString("  Umar Hassan Khan             ", 10, 90);
    		g.drawString("  Muhammad Umair             ", 10, 110);
    		
 	
        }
        
      if(count >600) {
        g.setColor(Color.BLACK);
  		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
  		g.setColor(Color.WHITE);
  		
  		g.setFont(new Font("Century Gothic",Font.BOLD,15));
  		g.drawString("  P R O D U C E R S:           ", 10, 130);
  		
  		g.setFont(new Font("Century Gothic",Font.PLAIN,10));
 		g.drawString("  Muhammad Noman Shahid         ", 10, 150);
 		g.drawString("  Umar Hassan Khan             ", 10, 170);
 		g.drawString("  Muhammad Umair             ", 10, 190);
  		
      }
      
    
     if(count>1200) {
    	 g.setColor(Color.BLACK);
   		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
   		g.setColor(Color.WHITE);
   		
   		g.setFont(new Font("Century Gothic",Font.BOLD,15));
    	g.drawString("  A R T   E X P E R T:           ", 10, 210);
    	
    	g.setFont(new Font("Century Gothic",Font.PLAIN,10));
 		g.drawString("  Muhammad Noman Shahid         ", 10, 220);
     }
     
     
     if(count>1500) {
    	 g.setColor(Color.BLACK);
   		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
   		g.setColor(Color.WHITE);
   		
   		g.setFont(new Font("Century Gothic",Font.BOLD,15));
    	g.drawString("  A U D I O   E X P E R T S:          ", 140, 50);
    	
    	g.setFont(new Font("Century Gothic",Font.PLAIN,10));
 		g.drawString("  Lil Umairus             ", 140, 70);
 		g.drawString("  DJ Nomi              ", 140, 90);
     }
     
     if(count>1800) {
    	    g.setColor(Color.BLACK);
   		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
   		g.setColor(Color.WHITE);
   		
   		g.setFont(new Font("Century Gothic",Font.BOLD,15));
    	g.drawString("  P R O G R A M M E R S:              ", 140, 110);
    	
    	g.setFont(new Font("Century Gothic",Font.PLAIN,10));
 		g.drawString("  Muhammad Noman Shahid         ", 140, 130);
 		g.drawString("  Umar Hassan Khan             ", 140, 150);
 		g.drawString("  Muhammad Umair             ", 140, 170);
     }
     
     if(count>2500) {
    	    g.setColor(Color.BLACK);
   		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
   		g.setColor(Color.WHITE);
   		
   		g.setFont(new Font("Century Gothic",Font.BOLD,15));
 		g.drawString("  S T O R Y  W R I T E R:        ", 80, 50);
 		
 		g.setFont(new Font("Century Gothic",Font.PLAIN,10));
 		g.drawString("  Muhammad Noman Shahid       ", 80, 70);
     }
     
     
     if(count>2800) {
    	    g.setColor(Color.BLACK);
       		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
       		g.setColor(Color.WHITE);
 		g.setFont(new Font("Century Gothic",Font.BOLD,20));
 		g.drawString("  Special thanks to Y'all     ", 50, 110);
 		g.drawString("  Stay Home, Stay Safe    ", 55, 160);
     }

        	
	}
	
	
	
	@Override
	public void handleInput() {

		if((count>3500)&&InputKeys.isPressed(InputKeys.ESCAPE)) {
			MusicPlayer.stop("ending");
			gsm.setState(GameStateManager.MENUSTATE);
		}
		if((count>3500)&&InputKeys.isPressed(InputKeys.ENTER)) {
			MusicPlayer.stop("ending");
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}



	public Font getTextFont() {
		return textFont;
	}



	public void setTextFont(Font textFont) {
		this.textFont = textFont;
	}



	public Font getTextFont2() {
		return textFont2;
	}



	public void setTextFont2(Font textFont2) {
		this.textFont2 = textFont2;
	}

}
