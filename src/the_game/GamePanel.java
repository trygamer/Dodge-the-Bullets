package the_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Victim v = new Victim(250 - 25, 400 - 25, 50, 50, 5);

	Timer t;
	public static BufferedImage egImg;

	final static int MENU_STATE = 0;

	final static int GAME_STATE = 1;

	final static int END_STATE = 2;

	Font titleFont;
	Font startFont;
	Font infoFont;

	static int currentState = MENU_STATE;

	GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 30);
		try {
			egImg = ImageIO.read(this.getClass().getResourceAsStream("hWn54.jpg"));
		}

		catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, DTB.width, DTB.height);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("DTB", 200, 100);
		g.setFont(startFont);
		g.setColor(Color.RED);
		g.drawString("Press ENTER to start", 100, 400);
		g.setFont(startFont);

	}

	void drawGameState(Graphics g) {
		v.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.drawImage(GamePanel.egImg, 0, 0, null);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("You lasted for " + " seconds", 100, 400);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 100, 700);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
		repaint();

	}

	private void updateGameState() {
		// TODO Auto-generated method stub

	}

	private void updateMenuState() {
		// TODO Auto-generated method stub

	}

	public void startGame() {
		t.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;
			System.out.println(currentState);

			if (currentState > END_STATE) {

				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("t");
			v.x += v.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			v.x -= v.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("t");
			v.y += v.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			v.y -= v.speed;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}