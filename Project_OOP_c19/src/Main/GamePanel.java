
/*
 * 
 * 
 * 			This class is responsible for each game cycle and rendering and drawing each object and state on screen with each gameloop cycle
 * 
 * 
 */
package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import ControlHandlers.InputKeys;
import GameStates.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// Screen resolution dimensions
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	
	// Game Threads == important stuff
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	
	// for image loading
	private BufferedImage image;
	private Graphics2D g;
	
	// game state manager
	private GameStateManager gsm;
	
	// constructor for gamepanel	
	public GamePanel() {
		
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));   //passing screen dimensions to set window
		setFocusable(true);                                               //set focus
		requestFocus();                                                   //requesting focus for screen
		
	}
	
	//thread process
	public void addNotify() {
		
		super.addNotify();                                               //gamePanel done loading, just start the thread
		
		if(thread == null) {                                            //if no thread already running
			thread = new Thread(this);                                 //initialize it with "THIS" thread == this class
			addKeyListener(this);  
			thread.start();
		}
	}
	
	
	//method to initialize everything in beginning
	private void init() {
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		gsm = new GameStateManager();
		
	}
	
	//game loop running refreshing every millisecond
	@Override
	public void run() {
		
		init();                                                        //calling init method to initialize everything
		
		//three timers
		long startTime;
		long elapsedTime;
		long waitTime;
		
		while(running) {
			
			startTime = System.nanoTime();
			
			//main heartbeat of code
			
			update();
			render();
			drawToScreen();
			
			elapsedTime = System.nanoTime() - startTime;
			
			waitTime = targetTime - elapsedTime / 1000000;
			
			if(waitTime < 0) 
				waitTime = 5;
			
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception excep) {
				excep.printStackTrace();
			}
			
		}
		
	}
	
	//updating each game state according to each gameloop cycle
	private void update(){	
		gsm.update();
		InputKeys.update();
	}
	
	//rendering under screen
	private void render(){
		gsm.draw(g);
	}
	
	//drawing on the screen the rendered image
	private void drawToScreen(){  
		Graphics gp = getGraphics();  // gonna use gamePAnel graphics object
		gp.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		gp.dispose();
	}

	
	@Override
	public void keyTyped(KeyEvent key) {
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		InputKeys.setKey(key.getKeyCode(), true);  
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		InputKeys.setKey(key.getKeyCode(), false); 
		
	}

	

}
