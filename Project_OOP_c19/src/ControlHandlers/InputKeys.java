/*
 * 
 * 		input keys class
 * 
 */

package ControlHandlers;


import java.awt.event.KeyEvent;

public class InputKeys {
	
	//range of keys
	public static final int NUMOFKEYS = 12;  
	
	//boolean for storing keys
	public static boolean currentKeyState[] = new boolean[NUMOFKEYS]; 
	
	//boolean for keys left or just pressed 
	public static boolean previousKeyState[] = new boolean [NUMOFKEYS]; 
	
	//assigning keys to certain values
	public static int UP = 0;
	public static int DOWN = 1;
	public static int LEFT = 2;
	public static int RIGHT = 3;
	public static int JUMPBUTTON = 4;
	public static int RUNBUTTON = 5;
	public static int SCRATCHBUTTON = 6;
	public static int SPRAYBUTTON = 7;
	public static int ENTER = 8;
	public static int ESCAPE = 9;
	public static int CONFIRM = 10;

	
	//setting the key, like assigning an event handler
	public static void setKey(int i, boolean b) {
		
		if(i == KeyEvent.VK_UP) {
			currentKeyState[UP] = b;
		}
		
		else if(i == KeyEvent.VK_LEFT) {
			currentKeyState[LEFT] = b;
		}
		
		else if(i == KeyEvent.VK_DOWN) {
			currentKeyState[DOWN] = b;
		}
		
		else if(i == KeyEvent.VK_RIGHT) {
			currentKeyState[RIGHT] = b;
		}
		
		else if(i == KeyEvent.VK_SPACE) {
			currentKeyState[JUMPBUTTON] = b;
		}
		
		else if(i == KeyEvent.VK_Y){
			currentKeyState[CONFIRM] = b;
		}
		
		else if(i == KeyEvent.VK_A) {
			currentKeyState[SCRATCHBUTTON] = b;
		}
		else if(i == KeyEvent.VK_D) {
			currentKeyState[SPRAYBUTTON] = b;
		}
		
		else if(i == KeyEvent.VK_ENTER) {
			currentKeyState[ENTER] = b;
		}
		
		else if(i == KeyEvent.VK_ESCAPE) {
			currentKeyState[ESCAPE] = b;
		}
	}
	
	//update method for updating keys
	public static void update() {
		for(int i = 0; i < NUMOFKEYS; i++) {
			previousKeyState[i] = currentKeyState[i];
		}
	}
	
	//
	public static boolean isPressed(int i) {
		return currentKeyState[i] && !previousKeyState[i];
	}
}
