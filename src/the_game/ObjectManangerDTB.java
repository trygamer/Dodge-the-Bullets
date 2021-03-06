package the_game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class ObjectManangerDTB {
	long enemyTimer = 0;
	long enemyTimerr = 0;
	int enemySpawnTime = 1000;

	long enemyTimer1 = 0;
	long enemyTimer11 = 0;
	long enemyTimer2 = 0;
	long enemyTimer22 = 0;
	long enemyTimer3 = 0;
	long enemyTimer33 = 0;

	public static BufferedImage vLiveImg;

	static boolean tired = false;

	Graphics g;
	static int vLives = 3;

	public void gameRestart() {
		vLives = 3;
		bullets = new ArrayList<GameObjectDTB>();

		v.x = 225;
		v.y = 375;

	}

	Victim v;
	The_moving_heart tmh;

	ObjectManangerDTB(Victim v, The_moving_heart tmh) {
		this.v = v;
		this.tmh = tmh;
		try {

			vLiveImg = ImageIO.read(this.getClass().getResourceAsStream("MC_Heart.png"));

		}

		catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	ArrayList<GameObjectDTB> bullets = new ArrayList<GameObjectDTB>();

	public void addBullets(GameObjectDTB AN1) {
		bullets.add(AN1);
		if (GamePanel.currentState == 0) {
			bullets.remove(AN1);
		}

	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addBullets(new Bullets(new Random().nextInt(DTB.width), 0, 10, 70));

			enemyTimer = System.currentTimeMillis();

		}

	}

	public void manageEnemiesR() {
		if (System.currentTimeMillis() - enemyTimer1 >= enemySpawnTime) {
			addBullets(new Right_Bullet(0, new Random().nextInt(DTB.height), 70, 10));

			enemyTimer1 = System.currentTimeMillis();
		}
	}

	public void manageEnemiesUP() {
		if (System.currentTimeMillis() - enemyTimer2 >= enemySpawnTime) {
			addBullets(new GUP_Bullet(new Random().nextInt(DTB.width), 800, 10, 70));

			enemyTimer2 = System.currentTimeMillis();
		}

	}

	public void manageEnemiesLeft() {
		if (System.currentTimeMillis() - enemyTimer3 >= enemySpawnTime) {
			addBullets(new LeftBullet(500, new Random().nextInt(DTB.height), 70, 10));

			enemyTimer3 = System.currentTimeMillis();
		}

	}

	public void update() {

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();

		}
		tmh.update();
	}

	public void draw(Graphics g) {

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);

		}
		int mcheart = 50;
		for (int i = 0; i < vLives; i++) {
			g.drawImage(vLiveImg, 400, mcheart + (i * 10), 10, 10, null);
		}

		tmh.draw(g);
	}

	public void checkCollision() {
		for (GameObjectDTB c : bullets) {

			if (v.collisionBox.intersects(c.collisionBox)) {
				vLives -= 1;
				System.out.print(vLives);
				bullets = new ArrayList<GameObjectDTB>();
				v.x = 225;
				v.y = 375;

			}

			if (vLives == 0) {
				GamePanel.currentState = GamePanel.END_STATE;
			}

		}
		if (v.collisionBox.intersects(tmh.collisionBox)) {
			if (ObjectManangerDTB.vLives <= 5) {
				vLives += 1;

				tired = false;

			}

		}

	}

	public void boundryChecker() {

		if (v.x > DTB.width) {
			v.x = DTB.width - 10;
			GameObjectDTB.isAlive = false;

		}
		if (v.x < 0) {
			v.x += 10;
			GameObjectDTB.isAlive = false;

		}
		if (v.y > DTB.height) {
			v.y = DTB.height - 20;
			GameObjectDTB.isAlive = false;

		}
		if (v.y < 0) {
			v.y += 10;
			GameObjectDTB.isAlive = false;

		}

	}

	public void purgeObjects() {
		for (int i = 0; i < bullets.size(); i++) {

			if (!GameObjectDTB.isAlive) {
				bullets.remove(i);
			}
		}

	}

}
