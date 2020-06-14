/*
 * 
 *       Class to load the background image of each level
 *       
 */
package TileMap;
import Main.GamePanel;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;


public class BackGround {
	
	//background image variable
	private BufferedImage image;
	
	//x,y coordinate
	private double x;
	private double y;
	
	//movement of background
	private double dx;
	private double dy;
	
	//width and height of background image
	private int width;
	private int height;
	
	//scaling the image movement
	private double xscale;
	private double yscale;
	
	
	public BackGround(String s) {
		this(s, 0.1);
	}
	
	public BackGround(String s, double d) {
		this(s, d, d);
	}
	
	public BackGround(String s, double xs, double ys) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));  //taking resource image
			width = image.getWidth();   //taking width of image
			height = image.getHeight();  //taking height of image
			xscale = xs;  //horizontal move scale
			yscale = ys;  //vertical move scale
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//setting initial point for background
	public void setPosition(double x, double y) {
		this.x = (x * xscale) % width;
		this.y = (y * yscale) % height;
	}
	
	//setting vector of background scrolling
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	//setting movescale for background
	public void setScale(double xscale, double yscale) {
		this.xscale = xscale;
		this.yscale = yscale;
	}
	
	//setting dimension of background
	public void setDimensions(int w, int h) {
		width = w;
		height = h;
	}
	
	//getting the x coordinate from where image starts
	public double getx() {
		return x;
	}
	
	//getting the y coordinate from where image starts
	public double gety() {
		return y;
	}
	
	//updating background according to scale
	public void update() {
		
		x += dx;
		while(x <= -width) {
			x += width;
		}
		while(x >= width) {
			x -= width;
		}

		y += dy;
		while(y <= -height) {
			y += height;
		}

		while(y >= height) {
			y -= height;
		}
	}
	
	//drawing background image on screen
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)x, (int)y, null);
		
		if(x < 0) {
			g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
		}
		
		if(x > 0) {
			g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
		}
		
		if(y < 0) {
			g.drawImage(image, (int)x, (int)y + GamePanel.HEIGHT, null);
		}
		
		if(y > 0) {
			g.drawImage(image, (int)x, (int)y - GamePanel.HEIGHT, null);
		}
	}
	
	
}
