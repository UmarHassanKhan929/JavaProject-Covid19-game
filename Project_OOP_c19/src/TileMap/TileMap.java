

/*
 *  This class is basically responsible for displaying the maps by tileset image and 
 *  by loading tile map to determine which tile is intractable and which tile is not
 */


package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import Main.GamePanel;

public class TileMap {
	
	// position
	private double xcord;
	private double ycord;
	
	// bounds
	private int xMin;
	private int yMin;
	private int xMax;
	private int yMax;
	//smoother camera movement
	private double smoothCamera;
	
	// map
	private int[][] map;
	
	//tilesize ofc
	private int tileSize;
	//no of rows and columns on the map
	private int numOfRows;
	private int numOfCols;
	
	//dimensions of the map, i.e width and height of pixel
	private int width;
	private int height;
	
	//array to hold tileset
	private BufferedImage tileSet;
	
	//on the tileset sheet
	private int numOfTilesAcross;
	
	//represents tiles, gonna import images of "tileSet" into this array
	private Tile[][] tiles;
	
	//tiles to draw on screen, according to screen resolution and scale
	
	private int rowOffset;  //which row to start draw on screen
	private int colOffset;  //which columns to draw on screen
	private int numRowsToDraw;  //how many rows to draw
	private int numColsToDraw;   //how many col to draw
	
	//constructor
	public TileMap(int tileSize) {
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.HEIGHT / tileSize + 2; //8 tiles vertical
		numColsToDraw = GamePanel.WIDTH / tileSize + 2;  //11 tiles across
		smoothCamera = 0.07;
	}
	
	//loads the tile into memory from tileset image
	public void loadTiles(String s) {
		try {
			tileSet = ImageIO.read(getClass().getResourceAsStream(s)); //loading image
			
			//from the tileSet image
			numOfTilesAcross = tileSet.getWidth() / tileSize;
			
			//2rows tile across as in tilesetimage 
			tiles = new Tile[2][numOfTilesAcross]; 
			
			BufferedImage subimage;  //single tile retrieval
			
			for(int col = 0; col < numOfTilesAcross; col++) {
				
				//unblocked tiles
				subimage = tileSet.getSubimage(col * tileSize,0,tileSize,tileSize);
				tiles[0][col] = new Tile(subimage, Tile.NORMAL);
				
				//blocked tiles
				subimage = tileSet.getSubimage(col * tileSize,tileSize,tileSize,tileSize);
				tiles[1][col] = new Tile(subimage, Tile.BLOCKED);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//loadmap method to load .map files and mapping tileset image onto it
	public void loadMap(String s) {
		try {
			
			InputStream in = getClass().getResourceAsStream(s);
			//to read text tile
			BufferedReader tileBR = new BufferedReader(new InputStreamReader(in));
			
			numOfCols = Integer.parseInt(tileBR.readLine());  //reading columns
			numOfRows = Integer.parseInt(tileBR.readLine());  //reading rows
			
			map = new int[numOfRows][numOfCols];
			
			//width and height in pixels
			width = numOfCols * tileSize;
			height = numOfRows * tileSize;
			
			xMin = GamePanel.WIDTH - width;
			xMax = 0;
			yMin = GamePanel.HEIGHT - height;
			yMax = 0;
			
			String delims = "\\s+";  // regular expression for cutting off whitespace
			for(int row = 0; row < numOfRows; row++) {
				
				String line = tileBR.readLine();
				
				String[] tokens = line.split(delims);
				
				for(int col = 0; col < numOfCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
			tileBR.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	//required getters
	public double getXcord() {
		return xcord;
	}


	public double getYcord() {
		return ycord;
	}


	public int getTileSize() {
		return tileSize;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	//camera follow player smoothly
	public void setTween(double d) { 
		smoothCamera = d; 
	}
	
	//getting number of rows and column
	public int getNumRows() { 
		return numOfRows; 
	}
	public int getNumCols() { 
		return numOfCols; 
	}

	//tiles type, whether solid or pass through
	public int getType(int row, int col) {
		int rcTiles = map[row][col];
		
		int r = rcTiles / numOfTilesAcross;
		int c = rcTiles % numOfTilesAcross;
		
		return tiles[r][c].getType();
	}
	
	
	//tiles position to draw on screen
	public void setPosition(double x, double y) {	
		this.xcord += (x - this.xcord) * smoothCamera;
		this.ycord += (y - this.ycord) * smoothCamera;
		
		//check bounds are not left
		fixBounds();
		
		//where to start draw
		colOffset = (int)-this.xcord / tileSize;
		rowOffset = (int)-this.ycord / tileSize;
		
	}
	
	//determining bounds of tiles for collision and other stuff
	public void fixBounds() {
		if(xcord < xMin) 
			xcord = xMin;
		if(ycord < yMin) 
			ycord = yMin;
		if(xcord > xMax) 
			xcord = xMax;
		if(ycord > yMax) 
			ycord = yMax;
	}
	
	
	//Draw method to draw tiles on screen
	public void draw(Graphics2D g) {
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
		
			if(row >= numOfRows) 
				break;
			//loop for outer row
			for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
				
				if(col >= numOfCols) 
					break;
				
				if(map[row][col] == 0) 
					continue;
				
				int maprc = map[row][col];
				int r = maprc / numOfTilesAcross;
				int c = maprc % numOfTilesAcross;
				
				//position to draw tile map
				g.drawImage(tiles[r][c].getImage(),(int)xcord + col * tileSize,(int)ycord + row * tileSize,null);
				
			}
			
		}
		
	}
	
}
