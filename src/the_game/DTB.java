package the_game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DTB {

	JFrame f;
	static int height = 800;
	static int width = 500;
	GamePanel gp;

	public static void main(String[] args) {
		DTB li = new DTB();

		li.setup();
	}

	DTB() {
		f = new JFrame();
		gp = new GamePanel();
	}

	public void setup() {
		f.setVisible(true);
		f.setSize(width, height);
		f.add(gp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane();
		f.setPreferredSize(new Dimension(width, height));
		gp.startGame();
		f.addKeyListener(gp);
		f.pack();

	}
}
