import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int gameState = MENU;
	Timer frameDraw;
	Font titleFont;
	Font otherFont;
	Catcher catcher = new Catcher(325, 565, 125, 75);
	ObjectManager objectManager = new ObjectManager(catcher);
	Timer appleSpawn;
	int highScore = 0;
	
	public GamePanel() {
		frameDraw = new Timer(1000/60, this);
	    frameDraw.start();
	    titleFont = new Font("Arial", Font.PLAIN, 48);
	    otherFont = new Font("Arial", Font.PLAIN, 24);
	}
	
	public void paintComponent(Graphics g){
		if(gameState == MENU){
		    drawMenuState(g);
		}else if(gameState == GAME){
		    drawGameState(g);
		}else if(gameState == END){
		    drawEndState(g);
		}
	}
	
	 void updateMenuState() {  }
	 void updateGameState() {
		 
	 objectManager.update();
	 if (objectManager.getScore() > highScore) {
		 highScore = objectManager.getScore();
	 }
	 if (catcher.isActive == false) {
		 gameState = END;
	 }
	 
	 }
	 void updateEndState()  {  }
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, AppleCatcher.WIDTH, AppleCatcher.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 250, 100);
		g.setFont(otherFont);
		g.drawString("Press SPACE to restart", 260, 350);
		g.drawString("Your score was " + objectManager.getScore(), 275, 550);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, AppleCatcher.WIDTH, AppleCatcher.HEIGHT);
		g.setFont(otherFont);
		g.setColor(Color.BLUE);
		g.drawString("Score: " + objectManager.getScore(), 50, 50);
		g.drawString("High Score: " + highScore,  50, 100);
		objectManager.draw(g);
	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, AppleCatcher.WIDTH, AppleCatcher.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("APPLE CATCHER", 200, 100);
		g.setFont(otherFont);
		g.drawString("Press SPACE to play", 265, 350);
		g.drawString("Instructions: Use the right and left arrow keys to move your basket.", 50, 500);
		g.drawString("Try to catch as many apples as possible. " ,185, 550);
		g.drawString("You lose if an apple falls on the ground. ", 185, 600);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (gameState == END) {
				gameState = MENU;
				appleSpawn.stop();   
				catcher = new Catcher(325, 565, 125, 75);
				objectManager = new ObjectManager(catcher);
		        
		    } else {
		        gameState++;
		        if (gameState == GAME) {
		        	startGame();
		        }
		        
		    }
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			catcher.right();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			catcher.left();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(gameState == MENU){
		    updateMenuState();
		}else if(gameState == GAME){
		    updateGameState();
		}else if(gameState == END){
		    updateEndState();
		}
		repaint();
	}
	
	void startGame() {
		appleSpawn = new Timer(1500    , objectManager);
	    appleSpawn.start();
	}

}
