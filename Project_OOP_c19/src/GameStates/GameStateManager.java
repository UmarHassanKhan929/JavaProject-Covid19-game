
/*                
 *             to manage all the possible game states
 *                                                      
 *                                                          */
package GameStates;

import Audio.MusicPlayer;
import Main.GamePanel;


public class GameStateManager {
	
	//just some states variables
	private GameState[] possibleGameStates;
	private int currentGameState;                                //storing current game state, index of game state in list
	
	//pause menu state variables
	private PauseMenu pauseGameState;                           //object of PauseState class
	private boolean isPaused;                                   //boolean for checking pause state in level state
	
	//number of game states
	public static final int NUMGAMESTATES = 14;
	public static final int MENUSTATE = 0;
	public static final int LEVELGAME1STATE = 2;
	public static final int LEVELGAME2STATE = 3;
	public static final int LEVELGAME3STATE = 4;
	public static final int LEVEL4PROLOGUESTATE = 6;
	public static final int LEVELGAME4STATE = 5;
	public static final int ENDCREDITS = 12;
	public static final int DEADSTATE = 11;
	public static final int FINALESTATE = 10;
	public static final int LEVELMINISTATE = 7;
	public static final int HELPSTATE = 8;
	public static final int CONTROLSTATE = 9;
	
	
	
	
	
	public GameStateManager() {
		
		MusicPlayer.init();
		
		possibleGameStates = new GameState[NUMGAMESTATES];               //array size for game states
		
		pauseGameState = new PauseMenu(this);                           //initialize pausestate object
		
		isPaused = false;                                               //setting paused as false
		
		currentGameState = MENUSTATE;                                 //initialize state as menustate
		
		loadState(currentGameState);                                    //loading currentState
		
	}
	
	//to load a state in gamestatemanager
	private void loadState(int state) {  
		
		if(state == MENUSTATE) {
			possibleGameStates[state] = new MainMenu(this);
		}
		
		else if(state == LEVELGAME1STATE) {
			possibleGameStates[state] = new Level1State(this);
		}
		else if(state == LEVELGAME2STATE) {
			possibleGameStates[state] = new Level2State(this);
		}
		else if(state == LEVELGAME3STATE) {
			possibleGameStates[state] = new Level3State(this);
		}
		else if(state == LEVEL4PROLOGUESTATE) {
			possibleGameStates[state] = new L4Prologue(this);
		}
		else if(state == LEVELGAME4STATE) {
			possibleGameStates[state] = new Level4State(this);
		}
		else if(state == FINALESTATE){
			possibleGameStates[state] = new Finale(this);
		}
		
		else if(state == LEVELMINISTATE) {
			possibleGameStates[state] = new LevelMini(this);
		}
		
		else if(state == HELPSTATE) {
			possibleGameStates[state] = new HelpMenu(this);
		}
		
		else if(state == CONTROLSTATE) {
			possibleGameStates[state] = new ControlMenu(this);
		}
		
	
		else if(state == DEADSTATE) {
			possibleGameStates[state] = new DeadScreen(this);
		}
		
		else if(state == ENDCREDITS) {
			possibleGameStates[state] = new EndCredits(this);
			}
		}
	
	
	
	// to unloadstate from game state
	private void unloadState(int state) {
		
		possibleGameStates[state] = null;
	}
	
	
	//set the desired state
	public void setState(int state) {
		
		unloadState(currentGameState);
		currentGameState = state;
		loadState(currentGameState);
		possibleGameStates[currentGameState].init();
		
	}
	
	//method to check out pause state 
	public void setPaused(boolean b) {
		
		isPaused = b;
	}
	
	//ofc the update method to update states
	
	public void update() {
		
		if(isPaused) {                              //updating to pause state of game from the level state
			pauseGameState.update();
			return;
		}
		
		if(possibleGameStates[currentGameState] != null) {
			possibleGameStates[currentGameState].update();
		}
	}
	
	//the prestegious draw method to draw on screen
	public void draw(java.awt.Graphics2D g) {
		
		if(isPaused) {  //drawing the pause state
			pauseGameState.draw(g);
			return;
		}
		
		if(possibleGameStates[currentGameState] != null) {
			possibleGameStates[currentGameState].draw(g);
		}
		
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
	}
	
	
}
