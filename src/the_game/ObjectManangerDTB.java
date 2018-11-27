package the_game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

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

	Victim v;

	ObjectManangerDTB(Victim v) {
		this.v = v;
	}

	ArrayList<GameObjectDTB> b = new ArrayList<GameObjectDTB>();

	public void addBullets(GameObjectDTB AN1) {
		b.add(AN1);
		if (GamePanel.currentState == 0) {
			b.remove(AN1);
		}

	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addBullets(new Bullets(new Random().nextInt(DTB.width), 0, 5, 35));

			enemyTimer = System.currentTimeMillis();

		}

	}

	public void manageEnemiesR() {
		if (System.currentTimeMillis() - enemyTimer1 >= enemySpawnTime) {
			addBullets(new Right_Bullet(0, new Random().nextInt(DTB.height), 35, 5));

			enemyTimer1 = System.currentTimeMillis();
		}
	}

	public void manageEnemiesUP() {
		if (System.currentTimeMillis() - enemyTimer2 >= enemySpawnTime) {
			addBullets(new GUP_Bullet(new Random().nextInt(DTB.width), 800, 5, 35));

			enemyTimer2 = System.currentTimeMillis();
		}

	}

	public void manageEnemiesLeft() {
		if (System.currentTimeMillis() - enemyTimer3 >= enemySpawnTime) {
			addBullets(new LeftBullet(500, new Random().nextInt(DTB.height), 35, 5));

			enemyTimer3 = System.currentTimeMillis();
		}

	}

	public void update() {

		for (int i = 0; i < b.size(); i++) {
			b.get(i).update();

		}
	}

	public void draw(Graphics g) {

		for (int i = 0; i < b.size(); i++) {
			b.get(i).draw(g);

		}

	}

	public void checkCollision() {
		for (GameObjectDTB a : b) {

			if (v.collisionBox.intersects(a.collisionBox)) {
				System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
				GamePanel.currentState = GamePanel.END_STATE;
			}
		}
	}
}
