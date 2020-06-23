import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	Rectangle collisionBox;
	
	public GameObject(int getX, int getY, int w, int h) {
		x = getX;
		y = getY;
		width = w;
		height = h;
		collisionBox = new Rectangle(x, y, width, height);
		
	}
	
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
}
