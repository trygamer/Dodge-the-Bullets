package the_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer t;
	public static BufferedImage alienImg;

	public static BufferedImage rocketImg;

	public static BufferedImage bulletImg;

	public static BufferedImage spaceImg;
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
		g.setColor(Color.RED);
		g.drawString("Press space for intructions", 70, 700);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, DTB.width, DTB.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + " enemies", 100, 400);
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
