/* 
 * 
 *                   
		main class to run the code                   
		
 *
 *
 *
 */

package Main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameLaunch {
	
	public static void main(String[] args) {
		
		
		
		JFrame windowScreen = new JFrame("CV-19 !nfected");                       //setting jFrame window 
		
		JFrame.setDefaultLookAndFeelDecorated(true);

		windowScreen.setIconImage(new ImageIcon("Resources/Icons/mask.png").getImage());
		
		windowScreen.add(new GamePanel());                                        //passing game panel object in the JFrame window
		
		windowScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              //defalut close operation
		
		windowScreen.setResizable(false);                                         //not resizeable window
		
		windowScreen.pack();  
		
		windowScreen.setLocationRelativeTo(null);                                
		
		windowScreen.setVisible(true);
		
	}
	
}