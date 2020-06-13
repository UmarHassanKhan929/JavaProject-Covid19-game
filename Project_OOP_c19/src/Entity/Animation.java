
/*
 * 
 * 			This class is responsible for all the aniation of every sprite, player,npc,enemy,
 * 			
 * 			it crops images into sub images, stores them in array of buffered images, and displays them with given delay
 * 
 * 
 */
package Entity;
import java.awt.image.BufferedImage;

public class Animation {
	
	//stores all the frames
	private BufferedImage[] frames;    
	
	//for the current frame 
	private int currentFrame;                           
	
	//timer of frames
	private long startTime;      
	
	//delay
	private long delay;                                
	
	//useful for attacking animation
	private boolean playedOnce;                        
	
	public Animation() {
		playedOnce = false;
	}
	//setting frames
	public void setFrames(BufferedImage[] frames) {
		
		this.frames = frames;
		currentFrame = 0;
		
		//initiates with game clock = 0
		startTime = System.nanoTime();                 
		playedOnce = false;
	}
	
	public void setDelay(long d) { 
		delay = d; 
	}
	
	public void setFrame(int i) { 
		currentFrame = i; 
	}
	

	
	public void update() {
		//check whether to play next frame
		if(delay == -1) 
			return;
		
		long elapsed = (System.nanoTime() - startTime) / 1000000;
		
		if(elapsed > delay) {
			currentFrame++;
			startTime = System.nanoTime();
		}
		
		//looping back to 0 frame
		if(currentFrame == frames.length) {                  
			currentFrame = 0;
			playedOnce = true;
		}
		
	}
	
	
	public int getFrame() { 
		return currentFrame; 
	}
	
	//image need to draw
	public BufferedImage getImage() { 
		return frames[currentFrame]; 
	}

	//check wether animation played once or nahh
	public boolean hasPlayedOnce() { 
		return playedOnce; 
	}

}
