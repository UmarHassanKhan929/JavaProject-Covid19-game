/* 
 * 
 *             class for tile types
 *             
 *             
 */

package TileMap;
import java.awt.image.BufferedImage;

public class Tile {
	
	//just image and type of tile
	private BufferedImage tileImage;
	private int type;
	
	// tile types for environment
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	//constructor
	public Tile(BufferedImage image, int type) {
		this.tileImage = image;
		this.type = type;
	}
	
	//getting tile
	public BufferedImage getImage() { 
		return tileImage; 
	}
	
	//getting tile type
	public int getType() { 
		return type; 
	}
}




