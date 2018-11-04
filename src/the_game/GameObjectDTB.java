package the_game;

import java.awt.Rectangle;

public class GameObjectDTB {
	int x;

	int y;

	int width;

	int height;

	Rectangle collisionBox;

	public GameObjectDTB(int x1, int y1, int width1, int height1) {
		// TODO Auto-generated constructor stub

		x = x1;

		y = y1;

		width = width1;

		height = height1;

		collisionBox = new Rectangle(x, y, height, width);
	}

	public void update() {
		System.out.println("x=" + x + ",y=" + y);
		// TODO Auto-generated method stub
		if (x < GamePanel.xMin) {
			x = GamePanel.xMin;
		} else if (x > GamePanel.xMAx) {
			x = GamePanel.xMAx;
		}
		if (y < GamePanel.yMin) {
			y = GamePanel.yMin;
		} else if (y > GamePanel.yMAx) {
			y = GamePanel.yMAx;
		}
		collisionBox.setBounds(x, y, width, height);

	}

}
