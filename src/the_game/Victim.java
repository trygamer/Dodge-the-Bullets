package the_game;

import java.awt.Color;
import java.awt.Graphics;

public class Victim extends GameObjectDTB {

	int speed;

	Victim(int x1, int y1, int width1, int height1, int speed1) {
		super(x1, y1, width1, height1);
		x= x1;
		y = y1;
		width = width1;
		height = height1;

		speed = speed1;
		speed = 10;
	}

	public void update() {
		super.update();

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, height, width);

	}

}