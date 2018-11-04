package the_game;

import java.awt.Graphics;

public class Right_Bullet {
	int width = 50;

	int height = 50;

	public void Right_Bullets(int x1, int y1, int width1, int height1) {

	

		x = x1;
		y = y1;
		width = width1;
		height = height1;

		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	public void update() {
		super.update();
		x += 1;
	}

}
}
