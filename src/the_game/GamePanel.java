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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	static int xMin = 0;

	static int xMAx = DTB.width - 50;

	static int yMin = 0;

	static int yMAx = DTB.height - 50;

	Victim v = new Victim();

	static int challenge = 0;

	The_moving_heart tmh = new The_moving_heart(new Random().nextInt(xMAx), new Random().nextInt(yMAx), 10, 10);

	ObjectManangerDTB om = new ObjectManangerDTB(v, tmh);

	Timer t;
	public static BufferedImage egImg;

	public static BufferedImage victimImg;

	public static BufferedImage lbulletImg;

	public static BufferedImage rbulletImg;

	public static BufferedImage ubulletImg;

	public static BufferedImage dbulletImg;

	public static BufferedImage skyImg;

	public static BufferedImage vLiveImg;

	final static int MENU_STATE = 0;

	final static int GAME_STATE = 1;

	final static int END_STATE = 2;

	final static int INTRO_STATE = 3;

	Font titleFont;
	Font startFont;
	Font infoFont;

	static int currentState = MENU_STATE;

	long ScoreTimer;

	long ScoreTimerr;
	int SecondCount = 51;
	int SecondCountt = 0;
	int SecondCounttt = 100;
	int FinalCount = 0;

	GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 30);
		try {
			egImg = ImageIO.read(this.getClass().getResourceAsStream("hWn54.jpg"));

			victimImg = ImageIO.read(this.getClass().getResourceAsStream("UFO for DTBS.png"));

			lbulletImg = ImageIO.read(this.getClass().getResourceAsStream("crop for rocket.png"));

			skyImg = ImageIO.read(this.getClass().getResourceAsStream("air photo.jpeg"));

			rbulletImg = ImageIO.read(this.getClass().getResourceAsStream("rightward.png"));

			ubulletImg = ImageIO.read(this.getClass().getResourceAsStream("upward.png"));

			dbulletImg = ImageIO.read(this.getClass().getResourceAsStream("downward.png"));

			vLiveImg = ImageIO.read(this.getClass().getResourceAsStream("MC_Heart.png"));

		}

		catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	void updateEndState() {
		challenge = 0;

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
		FinalCount = 0;

	}

	void drawGameState(Graphics g) {

		g.drawImage(GamePanel.skyImg, 0, 0, DTB.width, DTB.height, null);
		ScoreTimer = ScoreTimer - ScoreTimerr;
		if (System.currentTimeMillis() - ScoreTimer >= SecondCount) {
			SecondCountt += 1;

		}
		if (SecondCountt >= SecondCount) {
			SecondCountt = 0;
			FinalCount += 1;

			if (FinalCount % 10 == 0) {
				challenge += 1;
				System.out.println(challenge);
			}

		}

		// ScoreTimer = System.currentTimeMillis();
		// ScoreTimerr = System.currentTimeMillis();
		// ScoreTimer = ScoreTimer - ScoreTimerr;

		// if (ScoreTimer % 1000 == 0) {
		// ScoreTimer = ScoreTimer / 1000;
		// }
		g.setFont(startFont);
		g.setColor(Color.BLUE);
		g.drawString(FinalCount + " seconds", 100, 100);
		v.draw(g);
		om.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.drawImage(GamePanel.egImg, 0, 0, null);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("You lasted for " + FinalCount + " seconds", 100, 400);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 100, 700);

	}

	void drawIntroState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, DTB.width, DTB.height);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("INSTRUCTIONS", 100, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("Your objective is to stay alive for as long as you can." + ""
				+ "The longer you last the harder it gets." + "" + "Use the arrow keys to move around." + ""
				+ "You start out with 3 lives and you can get up to a max of 5 lives " + ""
				+ "Every time you hit the irregular heart you gain one life", 100, 400);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to go back to menu", 100, 700);
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
		v.update();
		om.manageEnemiesR();
		om.manageEnemies();
		om.update();
		om.manageEnemiesUP();
		om.manageEnemiesLeft();
		om.checkCollision();
		om.boundryChecker();

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

		} else if (current == INSTRUCTION) {

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e, ) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;
				currentState = 0;
			}

			if (currentState == GAME_STATE) {
				om.gameRestart();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				drawIntroState(null);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			v.x += v.speed + (challenge);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			v.x -= v.speed + (challenge);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			v.y += v.speed + (challenge);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			v.y -= v.speed + (challenge);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
