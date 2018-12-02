package the_game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullets extends GameObjectDTB {

	int width = 50;

	int height = 50;

	public Bullets(int x1, int y1, int width1, int height1) {

		super(x1, y1, width1, height1);

		x = x1;
		y = y1;
		width = width1;
		height = height1;

		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawImage(GamePanel.dbulletImg, x, y, width, height, null, null);
		g.setColor(Color.RED);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}

	public void update() {
		super.update();
		y += 1;
	}

}
