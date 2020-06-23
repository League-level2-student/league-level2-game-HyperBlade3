import javax.swing.JFrame;

public class AppleCatcher {
	
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		AppleCatcher appleCatcher = new AppleCatcher();
		appleCatcher.setup();
	}
	
	public AppleCatcher()
	{   
		panel = new GamePanel();
		frame = new JFrame();
		
	}
	
	public void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
