package the_game;

import java.awt.Color;
import java.awt.Graphics;

public class Victim extends GameObjectDTB {

	int speed;

	Victim() {
		super(225, 375, 10, 10);
		speed = 5;
	}

	public void update() {
		super.update();

	}

	public void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawImage(GamePanel.victimImg, x, y, height, width, null);
		g.setColor(Color.RED);

	}

}