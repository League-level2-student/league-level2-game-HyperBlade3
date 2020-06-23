import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Catcher extends GameObject{
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	public Catcher(int getX, int getY, int w, int h) {
		super(getX, getY, w, h);
		// TODO Auto-generated constructor stub
		speed = 20;
		if (needImage) {
		    loadImage ("resizedBasket.png");
		}
		
	}
	
	void update() {
		super.update();
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

		
	}
	
	public void right() {
		if (x < AppleCatcher.WIDTH - 125    ) {
        x+=speed;
		}
    }
	
	public void left() {
		if (x > 0) {
        x-=speed;
		}
    }
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}
