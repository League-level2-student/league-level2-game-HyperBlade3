import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Catcher catcher;
	ArrayList<Apple> apples = new ArrayList<Apple>();
	Random random = new Random();
	int score = 0;
	int lives = 5;
	
	
	public ObjectManager(Catcher catche) {
		catcher = catche;
	} 
	
	
	public void addApple() {
		apples.add(new Apple(random.nextInt(AppleCatcher.WIDTH - 50),0,50,50));
	}
	
	public void update() {
		
		checkCollision();
		purgeObjects();
		for (Apple a: apples) {
			a.update();
			if (a.y >= AppleCatcher.HEIGHT - 175  ) {
				lives--;
		
				a.isActive = false;
				if (lives == 0) {
				catcher.isActive = false;
				}
			}
			if ( score >= 100) {
				a.speed = 10;
				catcher.speed = 30;
			}
			else if (score >= 50) {
				a.speed = 7;
				catcher.speed = 28;
			}
			else if (score >= 25) {
				a.speed = 5;
				catcher.speed = 25;
			}
			else if (score >= 10) {
				a.speed = 3;
				catcher.speed = 23;
			}
			else {
				a.speed = 2;
				catcher.speed = 20;
			}
		}
		
	}
	
	public void purgeObjects() {
		for (int i = 0; i < apples.size(); i++) {
		
			if (apples.get(i).isActive == false) {
				apples.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		catcher.draw(g);
		for (Apple a: apples) {
			a.draw(g);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		addApple();
	} 
	
	public void checkCollision() {
		for (Apple apple: apples) {
			if (apple.x <= catcher.x + catcher.width &&
				apple.x >= catcher.x &&
				apple.y + apple.height >= catcher.y 
				   
				
					) {
				apple.isActive = false;
				score++;
				
			}
		}
	}
	
	public int getScore() {
		
		return score;
		
	}
}
