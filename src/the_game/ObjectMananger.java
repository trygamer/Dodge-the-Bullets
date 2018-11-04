package the_game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectMananger {
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	ArrayList<Bullets> b = new ArrayList<Bullets>();

	public void addBullets(Bullets AN1) {
		b.add(AN1);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addBullets(new Bullets(new Random().nextInt(DTB.width), 0, 5, 35));

			enemyTimer = System.currentTimeMillis();
		}

	}

	public void manageEnemiesR() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addBullets(new Bullets(new Random().nextInt(DTB.width), 0, 35, 5));

			
			
			enemyTimer = System.currentTimeMillis();
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
}
